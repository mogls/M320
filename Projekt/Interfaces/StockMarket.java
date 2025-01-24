package Interfaces;

import Exceptions.StockMarketException;

import java.util.Set;

public interface StockMarket {
    long getPrice(String stockName) throws StockMarketException;

    long purchase(String stockName) throws StockMarketException;

    long purchase(String stockName, long amount) throws StockMarketException;

    long sell(String stockName) throws StockMarketException;

    long sell(String stockName, long amount) throws StockMarketException;

//    void globalUpdate(double percentage);

    void updateStock(String stockName, Stock stock);

    /**
     *
     * @return a Set containing the names of all stocks, available or not
     */
    Set<String> getStockNames();

    String getName();
}
