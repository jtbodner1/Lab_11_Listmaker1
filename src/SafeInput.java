import java.util.Scanner;
import java.util.regex.Pattern;

public class SafeInput {
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response;
        boolean valid;
        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine();
            valid = Pattern.matches(regEx, response);
            if (!valid) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (!valid);
        return response;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int result = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                pipe.nextLine(); // clear buffer
                if (result >= low && result <= high) {
                    valid = true;
                } else {
                    System.out.println("Input is out of range. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine(); // clear invalid input
            }
        } while (!valid);
        return result;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
            if (response.equals("Y")) {
                return true;
            } else if (response.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        } while (true);
    }

    public static String getString(Scanner pipe, String prompt) {
        System.out.print(prompt + ": ");
        return pipe.nextLine();
    }
}

