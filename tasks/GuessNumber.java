package tasks;

import java.util.Scanner;

public class GuessNumber {
    private static int min = 0;
    private static int max = 100;
    private static int theValue = rand(min, max);

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Wrong value.");
            return false;
        }
    }

    private static int rand(int min, int max) {
        return min + Integer.MAX_VALUE % (max - min);
    }

    public static void callRand(String str1, String str2) {
        if (isNumeric(str1) && isNumeric(str2)) {
            int min = Integer.parseInt(str1);
            int max = Integer.parseInt(str2);
            if (min - max > 0) {
                System.out.println("Wrong range.");
                System.exit(0);
            } else {
                theValue = rand(min, max);
            }
        } else System.exit(0);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to change default range? y/n");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("y")){
            System.out.print("Enter min value: ");
            String min = scanner.nextLine();
            System.out.print("Enter max value: ");
            String max = scanner.nextLine();
            callRand(min, max);
        }

        boolean searching = true;
        StringBuilder attempts = new StringBuilder();

        System.out.print("Start guess:\n");
        do {
            String attempt = scanner.nextLine();
            attempts.append(attempt).append(" ");
            if (isNumeric(attempt)) {
                if (Integer.parseInt(attempt) == theValue) {
                    System.out.println("The value is guessed. Previous actions of user:\n" + attempts.toString());
                    searching = false;
                } else {
                    max = (Integer.parseInt(attempt) > theValue) ? Integer.parseInt(attempt) : max;
                    min = (Integer.parseInt(attempt) < theValue) ? Integer.parseInt(attempt) : min;
                    System.out.println("New range: " + min + " : " + max);
                }
            }
        } while (searching);


    }

}
