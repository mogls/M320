import java.util.Scanner;

public class ConsoleApp {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        Portfolio user = new Portfolio("User 1");

        System.out.println("Where do you want to buy stocks: \n" +
                "- New York (ny) \n" +
                "- Zurich (zu) \n");

        String marketName = scanner.nextLine();
    }
}
