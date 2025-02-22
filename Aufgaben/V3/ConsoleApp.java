import Exceptions.StockMarketException;
import Exceptions.UserInputException;
import Initialize.Init;
import Interfaces.StockMarket;
import Markets.NewYork;
import Markets.Zurich;
import Models.Portfolio;
import Models.StockData;

import java.util.Scanner;

public class ConsoleApp {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        Portfolio user = new Portfolio("User 1");

        StockMarket zurich = Init.initMarket(new Zurich());
        StockMarket newYork = Init.initMarket(new NewYork());

        while (true) {
            System.out.println("Where do you want to buy stocks: \n" +
                    "- New York (ny) \n" +
                    "- Zurich (zh) \n" +
                    "- Cancel (cancel) \n");

            String marketName = scanner.nextLine();

            StockMarket selectedMarket;
            String selectedStock;

            switch (marketName.toLowerCase()) {
                case "ny":
                    selectedMarket = newYork;
                    break;
                case "zh":
                    selectedMarket = zurich;
                    break;
                case "cancel":
                    return;
                default:
                    selectedMarket = zurich;
            }

            selectedStock = selectStock();

            if (!selectedStock.equals("cancel")) {

                System.out.println("How much do you want to buy?");

                Integer amount = Integer.parseInt(scanner.nextLine());

                try {

                    user.purchase(selectedMarket, selectedStock, amount);
                } catch (StockMarketException e) {
                    System.out.println("StockMarketException");
                } catch (UserInputException e) {
                    System.out.println("UserInputException");
                }
            }

            System.out.println(user.getBalance());
            System.out.println(user.getOwnedStocks());
        }

    }
    // also doubles as a purchase
    private static String selectStock() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("In which stock would you like to invest: \n" +
                    "- Microsoft (mc) \n" +
                    "- Nvidia (nv) \n" +
                    "- Cancel (cancel)");

            String stock = scanner.nextLine();

            switch (stock.toLowerCase()) {
                case "mc":
                    return "Microsoft";
                case "nv":
                    return "Nvidia";
                case "cancel":
                    return "cancel";
            }
        }
    }
}
