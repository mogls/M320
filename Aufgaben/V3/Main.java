import Exceptions.UserInputException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserInputException {
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        while (loop) {
            System.out.println("Run in : \n" +
                    "- Debug mode (d) \n" +
                    "- Ui mode (u) \n" +
                    "- Console mode (c) \n" +
                    "- Exit (e) \n");

            String mode = scanner.nextLine();
            try {

                switch (mode) {
                    case "d":
                        System.out.println("Not implemented yet");
                        // TODO: uncomment later, when/if debug mode gets implemented
    //                    loop = false;
                        break;
                    case "u":
                        App.run("Stock Market Simulator");
                        loop = false;
                        break;
                    case "c":
                        ConsoleApp.run();
                        loop = false;
                        break;
                    case "e": loop = false; break;
                    default: throw new UserInputException();
                }
            } catch (UserInputException e) {
                System.out.println("Can't input that");
            }
        }
    }
}
