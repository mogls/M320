package Interfaces;

import Exceptions.StockMarketException;

import java.util.Set;

public interface StockMarket {
    int getPrice(String stockName) throws StockMarketException;

    int purchase(String stockName) throws StockMarketException;

    int purchase(String stockName, int amount) throws StockMarketException;

    int sell(String stockName) throws StockMarketException;

    int sell(String stockName, int amount) throws StockMarketException;

//    void globalUpdate(double percentage);

    /**
     * Add or update a stock to the market
     * @param stockName Name of the stock to add or update
     * @param stock Instance of the stock to add or update
     */

    void updateStock(String stockName, Stock stock);

    /**
     *
     * @return a Set containing the names of all stocks, available or not
     */
    Set<String> getStockNames();

    String getName();
}
