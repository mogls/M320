package Markets;

import Exceptions.StockException;
import Exceptions.StockMarketException;
import Interfaces.Stock;
import Interfaces.StockMarket;

import java.util.HashMap;
import java.util.Set;

public class Zurich implements StockMarket {
    private HashMap<String, Stock> stocks;

    private final double volatility = 0.05;
    private final double depreciation = 0.1;

    private final String name = "Zurich";

    public Zurich(HashMap<String, Stock> stocks) {

        this.stocks = stocks;
    }

    public Zurich () {
        this.stocks = new HashMap<String, Stock>();
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

    /**
     * @param stockName the name of the stocks being sold
     * @param amount the amount of stocks to sell
     * @return the amount of stocks sold
     * @throws StockMarketException if something got fucked up
     */
    @Override
    public long sell(String stockName, long amount) throws StockMarketException {
        long sold;
        try {

            sold = checkStockExists(stockName).sellStocks(amount);

        } catch (StockException e) {
            throw new StockMarketException("There was an error in the stock market. \nThere are more stocks in " +
                    stockName + " then there should be");
        }

        return sold;
    }

    public void updateStock(String stockName, Stock stock) {
        this.stocks.put(stockName, stock);
    }

    /**
     *
     * @return a Set containing the names of all stocks, available or not
     */
    public Set<String> getStockNames() {
        return this.stocks.keySet();
    }

    public String getName() { return this.name; }

    private Stock checkStockExists(String stockName) throws StockMarketException {
        Stock stock = this.stocks.get(stockName);
        if ( stock == null) throw new StockMarketException("There is no stock called : " + stockName);
        return stock;
    }
}
