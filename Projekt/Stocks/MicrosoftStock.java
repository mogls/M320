package Stocks;

import Exceptions.StockException;
import Interfaces.Stock;

// this shit don't matter i think

public class MicrosoftStock implements Stock {

    private int price;
    final private int totalStocks = 1000;
    private int remainingStocks = 1000;

    public MicrosoftStock() {this.price = 100;}
    public MicrosoftStock(int price) {
        this.price = price;
    }

    @Override
    public int getRemainingStocks() {
        return this.remainingStocks;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void updatePrice(int amount) {
        this.price += amount;
    }

    @Override
    public int purchaseStock() {
        if (this.remainingStocks > 0) {
            this.remainingStocks -= 1;
            return 1;
        }
        return 0;
    }

    @Override
    public int purchaseStocks(int amount) {
        int purchasedStocks;
        if (this.remainingStocks >= amount) {
            purchasedStocks = amount;
            this.remainingStocks -= purchasedStocks;
        } else {
            purchasedStocks = this.remainingStocks;
            this.remainingStocks -= purchasedStocks;
        }
        return purchasedStocks;
    }

    @Override
    public int sellStock() {
        if (this.remainingStocks < this.totalStocks) {
            this.remainingStocks += 1;
            return 1;
        }
        return 0;
    }

    @Override
    public int sellStocks(int amount) throws StockException {
        int soldStocks;
        if (this.remainingStocks <= this.totalStocks - amount) {
            soldStocks = amount;
            this.remainingStocks += soldStocks;
        } else {
            throw new StockException("Unable to sell your stocks at the moment");
        }
        return soldStocks;
    }
}
