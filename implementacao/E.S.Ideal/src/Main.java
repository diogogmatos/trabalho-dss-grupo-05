import ESIdealUI.Menu;

public class Main {
    public static void main(String[] args) {
        Menu mainMenu = new Menu("Main Menu");

        mainMenu.addOption("Option 1", () -> {
            System.out.println("Handling Option 1");
            // Add your logic for Option 1 here
        });

        mainMenu.addOption("Option 2", () -> {
            System.out.println("Handling Option 2");
            // Add your logic for Option 2 here
        });

        mainMenu.addOption("Option 3", () -> {
            System.out.println("Handling Option 3");
            // Add your logic for Option 3 here
        });

        mainMenu.display();
    }
}
