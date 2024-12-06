import Interfaces.StockMarket;

import java.util.ArrayList;

public class Portfolio {
    private ArrayList<StockMarket> stockExchanges;

    final public String owner;

    public Portfolio(String owner) {
        this.owner = owner;
    }
}
