import ESIdealUI.Interface;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1 || !(args[0].equals("admin") || args[0].equals("funcionario"))) {
            System.out.println("Uso: java Main <admin|funcionario>");
            return;
        }

        new Interface(args[0].equals("admin")).run();
    }
}
