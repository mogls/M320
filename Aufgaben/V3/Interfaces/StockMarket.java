package Interfaces;

import Exceptions.StockMarketException;

public interface StockMarket {
    public long getPrice(String stockName) throws StockMarketException;
    public long purchase(String stockName) throws StockMarketException;
    public long purchase(String stockName, long amount) throws StockMarketException;
    public long sell(String stockName) throws StockMarketException;
}
