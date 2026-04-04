package CLI;

import java.util.Scanner;

public class Input {
    public static String readLineString(Scanner scanner) {
        String line;
        do {
            line = scanner.nextLine();
        } while (line.isEmpty());
        return line;
    }

    public static String readString(Scanner scanner) {
        return scanner.next();

    }

    public static double readDouble(Scanner scanner) {
        double inputD = 0;
        boolean doubleIn = false;
        while (!doubleIn) {
            try {
                String input = readString(scanner);
                inputD = Double.parseDouble(input);
                doubleIn = true;

            } catch (Exception e) {
                System.out.println("Please Enter double");

            }

        }

        return inputD;
    }

    public static int readInt(Scanner scanner) {
        int inputInt = 0;
        boolean intIn = false;
        while (!intIn) {
            try {
                String input = readString(scanner);
                inputInt = Integer.parseInt(input);
                intIn = true;

            } catch (Exception e) {
                System.out.println("Please Enter Integer");

            }

        }
        return inputInt;
    }
}
