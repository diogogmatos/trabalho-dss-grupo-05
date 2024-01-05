package ESIdealUI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<Integer, String> optionNames;
    private Map<Integer, Runnable> optionHandlers;
    private String title;

    public Menu(String title) {
        this.title = title;
        this.optionNames = new HashMap<>();
        this.optionHandlers = new HashMap<>();
        addExitOption();
    }

    private void addExitOption() {
        int exitOptionNumber = 0;
        optionNames.put(exitOptionNumber, "Sair");
        optionHandlers.put(exitOptionNumber, () -> {
            ;
        });
    }

    public void addOption(String option, Runnable handler) {
        int optionNumber = optionNames.size();
        optionNames.put(optionNumber, option);
        optionHandlers.put(optionNumber, () -> {
            handler.run();
            display(); // Redisplay the menu after the handler completes
        });
    }

    public void display() {
        System.out.println("=== " + title + " ===");
        for (Map.Entry<Integer, String> entry : optionNames.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        System.out.println("====================");

        int choice = getUserChoice();

        // Perform action based on user choice
        handleChoice(choice);
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.print("Enter your choice (0-" + (optionNames.size() - 1) + "): ");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the buffer
            }

        } while (choice < 0 || choice >= optionNames.size());

        return choice;
    }

    private void handleChoice(int choice) {
        // Perform action based on the selected option
        optionHandlers.get(choice).run();
    }
}