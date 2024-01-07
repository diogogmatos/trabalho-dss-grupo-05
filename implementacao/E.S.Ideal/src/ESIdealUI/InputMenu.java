package ESIdealUI;

import java.util.Scanner;

public class InputMenu<T> {
    private String prompt;
    private Scanner scanner;
    private Class<T> expectedType;

    public InputMenu(String prompt, Class<T> expectedType) {
        this.prompt = prompt;
        this.scanner = new Scanner(System.in);
        this.expectedType = expectedType;
    }

    public T display() {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                String input = scanner.nextLine();
                return parseInput(input);
            } catch (Exception e) {
                System.out.println("Input inválido. Tente novamente.");
            }
        }
    }

    private T parseInput(String input) {
        if (expectedType == String.class) {
            // No need for parsing for Strings
            return expectedType.cast(input);
        } else if (expectedType == Integer.class) {
            return expectedType.cast(Integer.parseInt(input));
        } else if (expectedType == Double.class) {
            return expectedType.cast(Double.parseDouble(input));
        } else {
            // Add more type checks as needed
            throw new UnsupportedOperationException("Unsupported type: " + expectedType.getSimpleName());
        }
    }
}
