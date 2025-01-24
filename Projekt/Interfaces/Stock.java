package Interfaces;

import Exceptions.StockException;

public interface Stock {
    int getPrice();
    int getRemainingStocks();
    int purchaseStocks(int amount);
    int sellStocks(int amount) throws StockException;

    void updatePrice(int amount);
}
