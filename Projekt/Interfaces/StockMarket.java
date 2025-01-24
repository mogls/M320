package Interfaces;

import Exceptions.StockException;
import Exceptions.StockMarketException;

import java.util.Set;

public interface StockMarket {
    int getPrice(String stockName) throws StockMarketException;
    int getRemainingStock(String stockName) throws StockMarketException;

    /**
     *
     * @return a Set containing the names of all stocks, available or not
     */
    Set<String> getStockNames();

    int purchase(String stockName) throws StockMarketException;

    int purchase(String stockName, int amount) throws StockMarketException;

    int sell(String stockName) throws StockMarketException, StockException;

    int sell(String stockName, int amount) throws StockMarketException;

//    void globalUpdate(double percentage);

    /**
     * Add a stock to the market
     * @param stockName Name of the stock to add
     * @param stock Instance of the stock to add
     */

    void addStock(String stockName, Stock stock);

    void updateStockPrice(String stockName, int amount) throws StockMarketException;

    String getName();

    double getVolatility();
    double getDepreciation();
}
