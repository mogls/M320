package Initialize;

import Exceptions.StockMarketException;
import Interfaces.StockMarket;
import Stocks.MicrosoftStock;
import Stocks.NvidiaStock;

public class Init {
    static public StockMarket initMarket(StockMarket market) {
        market.addStock("Microsoft", new MicrosoftStock());
        market.addStock("Nvidia", new NvidiaStock());

        initStockPrices(market);

        return market;
    }

    static private void initStockPrices(StockMarket market) {
        for (String stockName: market.getStockNames()) {
            try {
                int price = market.getPrice(stockName);
                double depreciation = market.getDepreciation();

                double amount = price * depreciation;

                market.updateStockPrice(stockName, (int) -Math.round(amount));

            } catch (StockMarketException e) {
                System.out.println("WTH?????");
            }
        }
    }
}


