package ESIdealUI;

import ESIdealLN.LNFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MenuFuncionario implements Runnable {
    private final LNFacade ln;

    public MenuFuncionario(LNFacade ln) {
        this.ln = ln;
    }

    public void realizarServico(int nrCartao) {
        try {
            System.out.println("\n" + ln.obterServicoPendente(nrCartao));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        String i = new InputMenu<>("Pressione ENTER para terminar o serviço", String.class).display();

        Menu terminar = new Menu("Terminar Serviço", false);
        terminar.addExitOption("Serviço concluído", () -> {
            try {
                ln.terminarServico();
                System.out.println("Serviço concluído com sucesso.");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        terminar.addExitOption("Serviço incompleto", () -> {
            String motivo = new InputMenu<>("Motivo", String.class).display();
            try {
                ln.terminarServico(motivo);
                System.out.println("Motivo registado com sucesso.");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        terminar.display();
    }

    public void agendarServicos() {
        System.out.println("=== Agendar Serviços ===");
        String nif = "";
        String matricula = "";
        try {
            boolean validNIF = false;
            while (!validNIF) {
                nif = new InputMenu<>("Insira o NIF do cliente", String.class).display();
                validNIF = ln.validarCliente(nif);
                if (!validNIF) {
                    System.out.println("NIF inválido.");
                }
            }
            boolean validVeiculo = false;
            while (!validVeiculo) {
                matricula = new InputMenu<>("Insira a matricula do veiculo", String.class).display();
                validVeiculo = ln.validarVeiculoCliente(nif, matricula);
                if (!validVeiculo) {
                    System.out.println("Veiculo inválido.");
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("--- Serviços Disponíveis ---");
        List<String> designacaoServicos;
        try {
            designacaoServicos = ln.obterServicosDisponiveisVeiculo(matricula);
            for (int i = 0; i < designacaoServicos.size(); i++) {
                System.out.println("\t" + i + ". " + designacaoServicos.get(i));
            }
            System.out.println("-------------------------");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] nrsServicoLidos = new String[0];
        // ler servicos
        boolean valid1 = false;
        while (!valid1) {
            String servicosStr = new InputMenu<>("Digite o número dos serviços a agendar (separados por vírgula)", String.class).display();
            nrsServicoLidos = servicosStr.split(",");
            int i = 0;
            for (String servico : nrsServicoLidos) {
                int nrServico = Integer.parseInt(servico);
                if (nrServico < 0 || nrServico >= designacaoServicos.size()) {
                    System.out.println("Serviço inválido: " + nrServico);
                    break;
                }
                i++;
            }
            if (i == nrsServicoLidos.length) {
                valid1 = true;
            }
        }

        // obter array de nomes de servicos
        List<String> servicosAgendar = new ArrayList<>();
        for (String nr : nrsServicoLidos) {
            servicosAgendar.add(designacaoServicos.get(Integer.parseInt(nr)));
        }

        // agendar
        boolean agendado = false;
        try {
            List<Integer> marcacoes = ln.agendarServicos(matricula, servicosAgendar);
            if (!marcacoes.isEmpty()) {
                System.out.println("--- Serviços Agendados Com Sucesso ---");
                int i = 0;
                for (int m : marcacoes) {
                    System.out.println("Nº Marcação: " + m + "\n\t- " + servicosAgendar.get(i));
                    i++;
                }

                if (marcacoes.size() < servicosAgendar.size()) {
                    System.out.println("--- Serviços Sem Disponibilidade ---");
                    for (int j = marcacoes.size(); j < servicosAgendar.size(); j++) {
                        System.out.println("\t- " + servicosAgendar.get(j));
                    }
                    System.out.println("\t> Por favor, tente novamente mais tarde.");
                }

                System.out.println("--------------------------------------");

                // mostar hora conclusao
                System.out.println("Hora estimada de conclusão: " + ln.obterHoraConclusaoServicos(marcacoes));

                agendado = true;
            }
            else
                System.out.println("Sem disponibilidade para os serviços selecionados. Tente novamente mais tarde.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // preferencias de notificacao
        if (agendado) {
            boolean valid2 = false;
            boolean notsms = false;
            boolean notemail = false;
            while (!valid2) {
                valid2 = true;

                String sms = new InputMenu<>("Notificar cliente por SMS? (s/n)", String.class).display();
                String email = new InputMenu<>("Notificar cliente por email? (s/n)", String.class).display();

                notsms = switch (sms) {
                    case "s" -> true;
                    case "n" -> false;
                    default -> valid2 = false;
                };

                notemail = switch (email) {
                    case "s" -> true;
                    case "n" -> false;
                    default -> valid2 = false;
                };

                if (!valid2) {
                    System.out.println("Opção inválida.");
                }
            }
            try {
                ln.definirPreferenciasNotificacao(nif, notsms, notemail);
                System.out.println("Preferências registadas.");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void realizarTurno(int nrCartao) {
        try {
            ln.iniciarTurnoTrabalho(nrCartao);
            System.out.println("Turno iniciado com sucesso.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Menu turno = new Menu("Turno de Trabalho", false);
        turno.addOption("Realizar Serviço", () -> realizarServico(nrCartao));
        turno.addOption("Agendar Serviços", this::agendarServicos);
        turno.addExitOption("Terminar Turno", () -> {
            try {
                ln.terminarTurnoTrabalho(nrCartao);
                System.out.println("Turno terminado com sucesso.");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        turno.display();
    }

    public int autenticarFuncionario(int nrPosto) {
        int nrCartao = 0;
        boolean autenticado = false;
        while (!autenticado) {
            nrCartao = new InputMenu<>("Digite o número do cartão", Integer.class).display();
            try {
                autenticado = ln.autenticarFuncionario(nrCartao, nrPosto);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                return 0;
            }
            if (!autenticado) {
                System.out.println("Número de cartão inválido.");
            }
        }
        System.out.println("Autenticado com sucesso.");
        return nrCartao;
    }

    public void run() {
        int nrPosto = 0;

        boolean valid = false;
        while (!valid) {
            nrPosto = new InputMenu<>("Executar programa no posto número", Integer.class).display();
            try {
                valid = ln.validaPostoTrabalho(nrPosto);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            if (!valid) {
                System.out.println("Posto de trabalho inválido.");
            }
        }

        AtomicBoolean change = new AtomicBoolean(true);
        while (change.get()) {
            int nrCartao = autenticarFuncionario(nrPosto);

            if (nrCartao == 0)
                return;

            Menu menuFuncionario = new Menu("Funcionário", false);
            menuFuncionario.addExitOption("Sair", () -> {
                change.set(false);
            });
            menuFuncionario.addOption("Realizar Turno", () -> realizarTurno(nrCartao));
            menuFuncionario.addExitOption("Mudar Funcionário", () -> {});
            menuFuncionario.display();
        }
    }
}
