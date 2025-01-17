package Markets;

import Exceptions.StockMarketException;
import Interfaces.Stock;
import Interfaces.StockMarket;
import Stocks.MicrosoftStock;

import java.util.HashMap;
import java.util.Set;

public class NewYork implements StockMarket {
    private HashMap<String, Stock> stocks;

    private final double volatility = 0.02;

    public NewYork(HashMap<String, Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public long getPrice(String stockName) throws StockMarketException {
        return checkStockExists(stockName).getPrice();

    }

    @Override
    public long purchase(String stockName) throws StockMarketException {
        return checkStockExists(stockName).purchaseStock();
    }

    @Override
    public long purchase(String stockName, long amount) throws StockMarketException {
        return checkStockExists(stockName).purchaseStocks(amount);
    }

    @Override
    public long sell(String stockName) throws StockMarketException {
        return checkStockExists(stockName).sellStock();
    }

    public void updateStocks(String stockName, Stock stock) {
        this.stocks.put(stockName, stock);
    }

    /**
     *
     * @return a Set containing the names of all stocks, available or not
     */
    public Set<String> getStockNames() {
        return this.stocks.keySet();
    }

    private Stock checkStockExists(String stockName) throws StockMarketException {
        Stock stock = this.stocks.get(stockName);
        if ( stock == null) throw new StockMarketException("There is no stock called : " + stockName);
        return stock;
    }


}
