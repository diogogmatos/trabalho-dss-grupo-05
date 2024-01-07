package ESIdealUI;

import ESIdealLN.LNFacade;

public class Interface implements Runnable {
    private final LNFacade LNFacade = new LNFacade();
    private boolean modoOperacao; // true = admin, false = funcionario

    public Interface(boolean modoOperacao) {
        this.modoOperacao = modoOperacao;
    }

    public void run() {
        if (modoOperacao)
            new MenuAdmin(LNFacade).run();
        else
            new MenuFuncionario(LNFacade).run();
    }
}
