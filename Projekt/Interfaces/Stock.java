package Interfaces;

import Exceptions.StockException;

public interface Stock {
    int getPrice();
    int getRemainingStocks();
    int purchaseStock();
    int purchaseStocks(int amount);
    int sellStock();
    int sellStocks(int amount) throws StockException;

    void updatePrice(int amount);
}
