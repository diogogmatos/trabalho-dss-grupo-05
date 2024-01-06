package ESIdealUI;

import ESIdealLN.LNFacade;

import java.util.ArrayList;
import java.util.List;

public class MenuFuncionario implements Runnable {
    private final LNFacade ln;

    public MenuFuncionario(LNFacade ln) {
        this.ln = ln;
    }

    public void realizarServico(int nrCartao) {
        System.out.println(ln.obterServicoPendente(nrCartao));
        boolean end = false;
        while (!end) {
            end = new InputMenu<>("Pressione ENTER para terminar o serviço.", String.class).display().isEmpty();
            if (!end) {
                System.out.println("Opção inválida.");
            }
        }

        Menu terminar = new Menu("Terminar Serviço");
        terminar.addOption("Serviço concluído", () -> ln.terminarServico(nrCartao));
        terminar.addOption("Serviço incompleto", () -> {
            String motivo = new InputMenu<>("Motivo", String.class).display();
            ln.terminarServico(nrCartao, motivo);
        });
    }

    public void agendarServicos() {
        System.out.println("=== Agendar Serviços ===");
        String nif = new InputMenu<>("Insira o NIF do cliente", String.class).display();
        String matricula = new InputMenu<>("Insira a matricula do veiculo", String.class).display();
        System.out.println("--- Serviços Disponíveis ---");
        List<String> designacaoServicos = ln.obterServicosDisponiveisVeiculo(matricula);
        for (int i = 0; i < designacaoServicos.size(); i++) {
            System.out.println("\t" + i + ". " + designacaoServicos.get(i));
        }

        String[] nrServicoLidos = new String[0];
        // ler servicos
        boolean valid1 = false;
        while (!valid1) {
            String servicosStr = new InputMenu<>("Digite o número dos serviços a agendar (separados por vírgula)", String.class).display();
            nrServicoLidos = servicosStr.split(",");
            int i = 0;
            for (String servico : nrServicoLidos) {
                int nrServico = Integer.parseInt(servico);
                if (nrServico < 0 || nrServico >= designacaoServicos.size()) {
                    System.out.println("Serviço inválido: " + nrServico);
                    break;
                }
                i++;
            }
            if (i == nrServicoLidos.length) {
                valid1 = true;
            }
        }

        // obter array de nomes de servicos
        List<String> servicosAgendar = new ArrayList<>();
        for (String nrServ : nrServicoLidos) {
            servicosAgendar.add(designacaoServicos.get(Integer.parseInt(nrServ)));
        }

        // agendar
        try {
            List<Integer> marcacoes = ln.agendarServicos(matricula, servicosAgendar);
            System.out.println("--- Serviços Agendados Com Sucesso ---");

            int i = 0;
            for (int m : marcacoes) {
                System.out.println("Nº Marcação: " + m + "\n\t- " + designacaoServicos.get(Integer.parseInt(nrServicoLidos[i])));
            }

            // mostar hora conclusao
            System.out.println("Hora estimada de conclusão: " + ln.obterHoraConclusaoServicos(marcacoes));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // preferencias de notificacao
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
        ln.definirPreferenciasNotificacao(nif, notsms, notemail);
        System.out.println("Preferências registadas.");
    }

    public void realizarTurno(int nrCartao) {
        ln.iniciarTurnoTrabalho(nrCartao);
        System.out.println("Turno iniciado com sucesso.");

        Menu turno = new Menu("Turno de Trabalho");
        turno.addOption("Realizar Serviço", () -> realizarServico(nrCartao));
        turno.addOption("Agendar Serviços", this::agendarServicos);
        turno.addOption("Terminar Turno", () -> {
            ln.terminarTurnoTrabalho(nrCartao);
            System.out.println("Turno terminado com sucesso.");
        });
        turno.display();
    }

    public void run() {
        int nrCartao = 0;
        int nrPosto = 0;

        boolean valid = false;
        while (!valid) {
            nrPosto = new InputMenu<>("Executar programa no posto número", Integer.class).display();
            valid = ln.validaPostoTrabalho(nrPosto);
            if (!valid) {
                System.out.println("Posto de trabalho inválido.");
            }
        }
        boolean autenticado = false;
        while (!autenticado) {
            nrCartao = new InputMenu<>("Digite o número do cartão", Integer.class).display();
            autenticado = ln.autenticarFuncionario(nrCartao, nrPosto);
            if (!autenticado) {
                System.out.println("Número de cartão inválido.");
            }
        }
        System.out.println("Autenticado com sucesso.");

        int finalNrCartao = nrCartao;
        Menu menuFuncionario = new Menu("Funcionário");
        menuFuncionario.addOption("Realizar Turno", () -> realizarTurno(finalNrCartao));
        menuFuncionario.display();
    }
}
