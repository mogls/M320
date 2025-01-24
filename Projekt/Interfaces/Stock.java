package Interfaces;

import Exceptions.StockException;

public interface Stock {
    long getPrice();
    long getRemainingStocks();
    long purchaseStock();
    long purchaseStocks(long amount);
    long sellStock();
    long sellStocks(long amount) throws StockException;

    void updatePrice(long amount);
}
