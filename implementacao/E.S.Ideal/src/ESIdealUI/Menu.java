package ESIdealUI;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private final Map<Integer, String> optionNames;
    private final Map<Integer, Runnable> optionHandlers;
    private final String title;
    private final boolean exitOption;

    public Menu(String title) {
        this.title = title;
        this.optionNames = new HashMap<>();
        this.optionHandlers = new HashMap<>();
        this.exitOption = true;
        addExitOption("Sair", () -> {});
    }

    public Menu(String title, boolean exitOption) {
        this.title = title;
        this.optionNames = new HashMap<>();
        this.optionHandlers = new HashMap<>();
        this.exitOption = exitOption;
        if (exitOption) {
            addExitOption("Sair", () -> {});
        }
    }

    public void addExitOption(String option, Runnable handler) {
        int optionNumber = optionNames.size();
        optionNames.put(optionNumber, option);
        optionHandlers.put(optionNumber, handler);
    }

    public void addOption(String option, Runnable handler) {
        int optionNumber = optionNames.size();
        optionNames.put(optionNumber, option);
        optionHandlers.put(optionNumber, () -> {
            handler.run();
            display();
        });
    }

    public void display() {
        String boxTitle = "=== " + title + " ===";
        System.out.println("\n" + boxTitle);
        for (Map.Entry<Integer, String> entry : optionNames.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        for (int i = 0; i < boxTitle.length(); i++) {
            System.out.print("=");
        }
        System.out.println();

        int choice = getUserChoice();

        handleChoice(choice);
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.print("Digite a sua escolha (0-" + (optionNames.size() - 1) + "): ");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Input inválido. Por favor digite um número inteiro.");
                scanner.nextLine();
            }

        } while (choice < 0 || choice >= optionNames.size());

        return choice;
    }

    private void handleChoice(int choice) {
        try {
            optionHandlers.get(choice).run();
        }
        catch (NullPointerException e) {
            System.out.println("Opção não implementada.");
            display();
        }
    }
}
