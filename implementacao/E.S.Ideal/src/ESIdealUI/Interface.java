package ESIdealUI;

import ESIdealLN.LNFacade;

public class Interface implements Runnable {
    private final LNFacade LNFacade = new LNFacade();
    public void run() {
        Menu modo = new Menu("Modo de Operação");
        modo.addOption("Modo Administrador", new MenuAdmin(LNFacade));
        modo.addOption("Modo Funcionário", new MenuFuncionario(LNFacade));
        modo.display();
    }
}
