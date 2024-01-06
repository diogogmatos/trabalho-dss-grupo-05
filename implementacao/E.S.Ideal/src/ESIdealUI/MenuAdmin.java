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
        consultar.addOption("Postos de Trabalho", null);
        consultar.addOption("Serviços", null);
        consultar.addOption("Funcionários", null);
        consultar.addOption("Turnos", null);
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
            catch (DateTimeParseException e) {
                System.out.println("Hora inválida.");
            }
        });
        definirHorarioFuncionamento.addOption("Definir Fecho", () -> {
            String fechoStr = new InputMenu<>("Digite a hora de fecho", String.class).display();
            try {
                LocalTime fecho = LocalTime.parse(fechoStr);
                ln.definirFecho(fecho);
            }
            catch (DateTimeParseException e) {
                System.out.println("Hora inválida.");
            }
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
        autenticarAdmin();
        String novaPwdMestra = new InputMenu<>("Digite a nova palavra-passe mestra", String.class).display();
        ln.alterarPalavraPasseAdmin(novaPwdMestra);
        System.out.println("Palavra-passe mestra alterada com sucesso.");
    }

    public void autenticarAdmin() {
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
        autenticarAdmin();

        Menu admin = new Menu("Administrador");
        admin.addOption("Configurar Sistema", this::configurarSistema);
        admin.addOption("Alterar Palavra-Passe Mestra", this::alterarPalavraPasse);
        admin.display();
    }
}
