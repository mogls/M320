package Initialize;

import Interfaces.StockMarket;
import Stocks.MicrosoftStock;
import Stocks.NvidiaStock;

public class Init {
    static public StockMarket initMarket(StockMarket market) {
        market.updateStock("Microsoft", new MicrosoftStock());
        market.updateStock("Nvidia", new NvidiaStock());

        return market;
    }
}


