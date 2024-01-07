package ESIdealUI;

import ESIdealLN.LNFacade;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class MenuAdmin implements Runnable {
    private final LNFacade ln;

    public MenuAdmin(LNFacade ln) {
        this.ln = ln;
    }

    public void adicionar() {
        Menu adicionar = new Menu("Adicionar");
        adicionar.addOption("Posto de Trabalho", null);
        adicionar.addOption("Serviço", null);
        adicionar.addOption("Funcionário", null);
        adicionar.display();
    }

    public void remover() {
        Menu remover = new Menu("Remover");
        remover.addOption("Posto de Trabalho", null);
        remover.addOption("Serviço", null);
        remover.addOption("Funcionário", null);
        remover.display();
    }

    public void consultar() {
        Menu consultar = new Menu("Consultar");
        consultar.addOption("Clientes", () -> {
            try {
                System.out.println(ln.consultarClientes());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        consultar.addOption("Veículos", () -> {
            try {
                System.out.println(ln.consultarVeiculos());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        consultar.addOption("Postos de Trabalho", () -> {
            try {
                System.out.println(ln.consultarPostosTrabalho());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        consultar.addOption("Serviços Pendentes", () -> {
            try {
                System.out.println(ln.consultarServicosPendentes());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        consultar.addOption("Serviços Concluídos", () -> {
            try {
                System.out.println(ln.consultarServicosConcluidos());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        consultar.addOption("Serviços Incompletos", () -> {
            try {
                System.out.println(ln.consultarServicosIncompletos());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        consultar.addOption("Serviços Disponíveis", () -> {
            try {
                System.out.println(ln.consultarServicosDisponiveis());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        consultar.addOption("Funcionários", () -> {
            try {
                System.out.println(ln.consultarFuncionarios());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        consultar.addOption("Turnos", () -> {
            try {
                System.out.println(ln.consultarTurnos());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        consultar.addOption("Registo de Serviços Efetuados", () -> {
            try {
                System.out.println(ln.consultarRegistoServicos());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        consultar.display();
    }

    public void definirHorarioFuncionamento() {
        Menu definirHorarioFuncionamento = new Menu("Horário de Funcionamento");
        definirHorarioFuncionamento.addOption("Definir Abertura", () -> {
            String aberturaStr = new InputMenu<>("Digite a hora de abertura", String.class).display();
            try {
                LocalTime abertura = LocalTime.parse(aberturaStr);
                ln.definirAbertura(abertura);
            }
            catch (Exception e) {
                System.out.println("Hora inválida.");
            }
            System.out.println("Horário de abertura definido com sucesso.");
        });
        definirHorarioFuncionamento.addOption("Definir Fecho", () -> {
            String fechoStr = new InputMenu<>("Digite a hora de fecho", String.class).display();
            try {
                LocalTime fecho = LocalTime.parse(fechoStr);
                ln.definirFecho(fecho);
            }
            catch (Exception e) {
                System.out.println("Hora inválida.");
            }
            System.out.println("Horário de fecho definido com sucesso.");
        });
        definirHorarioFuncionamento.display();
    }

    public void configurarSistema() {
        Menu configurarSistema = new Menu("Configurar Sistema");
        configurarSistema.addOption("Adicionar", this::adicionar);
        configurarSistema.addOption("Remover", this::remover);
        configurarSistema.addOption("Consultar", this::consultar);
        configurarSistema.addOption("Definir Horário de Funcionamento", this::definirHorarioFuncionamento);
        configurarSistema.display();
    }

    public void alterarPalavraPasse() {
        try {
            autenticarAdmin();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        String novaPwdMestra = new InputMenu<>("Digite a nova palavra-passe mestra", String.class).display();
        try {
            ln.alterarPalavraPasseAdmin(novaPwdMestra);
            System.out.println("Palavra-passe mestra alterada com sucesso.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void autenticarAdmin() throws Exception {;
        boolean autenticado = false;
        while (!autenticado) {
            String pwdMestra = new InputMenu<>("Digite a palavra-passe mestra", String.class).display();
            if (ln.autenticarAdmin(pwdMestra))
                autenticado = true;
            else
                System.out.println("Palavra-passe mestra incorreta.");
        }
        System.out.println("Autenticado com sucesso.");
    }

    public void run() {
        try {
            autenticarAdmin();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Menu admin = new Menu("Administrador");
        admin.addOption("Configurar Sistema", this::configurarSistema);
        admin.addOption("Alterar Palavra-Passe Mestra", this::alterarPalavraPasse);
        admin.display();
    }
}
