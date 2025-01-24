package Markets;

import Exceptions.StockException;
import Exceptions.StockMarketException;
import Interfaces.Stock;
import Interfaces.StockMarket;

import java.util.HashMap;
import java.util.Set;

public class Zurich implements StockMarket {
    private HashMap<String, Stock> stocks;

    private final double volatility = 0.1;
    private final double depreciation = 0.1;

    public Zurich(HashMap<String, Stock> stocks) {

        this.stocks = stocks;
    }

    public Zurich () {
        this.stocks = new HashMap<>();
    }

    @Override
    public int getPrice(String stockName) throws StockMarketException {
        return checkStockExists(stockName).getPrice();
    }

    @Override
    public int getRemainingStock(String stockName) throws StockMarketException {
        return checkStockExists(stockName).getRemainingStocks();
    }

    @Override
    public int purchase(String stockName) throws StockMarketException {
        return checkStockExists(stockName).purchaseStock();
    }

    @Override
    public int purchase(String stockName, int amount) throws StockMarketException {
        return checkStockExists(stockName).purchaseStocks(amount);
    }

    @Override
    public int sell(String stockName) throws StockMarketException {
        return checkStockExists(stockName).sellStock();
    }

    /**
     * @param stockName the name of the stocks being sold
     * @param amount the amount of stocks to sell
     * @return the amount of stocks sold
     * @throws StockMarketException if something got fucked up
     */
    @Override
    public int sell(String stockName, int amount) throws StockMarketException {
        int sold;
        try {

            sold = checkStockExists(stockName).sellStocks(amount);

        } catch (StockException e) {
            throw new StockMarketException("There was an error in the stock market. \nThere are more stocks in " +
                    stockName + " then there should be");
        }

        return sold;
    }

    /**
     * @param stockName Name of the stock to add
     * @param stock     Instance of the stock to add
     */
    @Override
    public void addStock(String stockName, Stock stock) {
        if (this.stocks.containsKey(stockName)) {
            System.out.println("This stock already exists.");
            return;
        }

        this.stocks.put(stockName, stock);
    }

    /**
     * @param stockName Name of the stock to update
     * @param amount    by how much to update the price, can be negative
     */
    @Override
    public void updateStockPrice(String stockName, int amount) throws StockMarketException {
        checkStockExists(stockName).updatePrice(amount);
    }

    /**
     *
     * @return a Set containing the names of all stocks, available or not
     */
    public Set<String> getStockNames() {
        return this.stocks.keySet();
    }

    public String getName() {
        return "Zurich"; }

    @Override
    public double getVolatility() {
        return this.volatility;
    }

    @Override
    public double getDepreciation() {
        return this.depreciation;
    }

    private Stock checkStockExists(String stockName) throws StockMarketException {
        Stock stock = this.stocks.get(stockName);
        if ( stock == null) throw new StockMarketException("There is no stock called : " + stockName);
        return stock;
    }


}
