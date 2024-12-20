package Stocks;

import Exceptions.StockException;
import Interfaces.Stock;

public class MicrosoftStock implements Stock {

    final private long price;
    final private long totalStocks = 1000;
    private long remainingStocks = 1000;

    public MicrosoftStock() {this.price = 100;}
    public MicrosoftStock(long price) {
        this.price = price;
    }

    @Override
    public long getRemainingStocks() {
        return this.remainingStocks;
    }

    @Override
    public long getPrice() {
        return this.price;
    }

    @Override
    public long purchaseStock() {
        if (this.remainingStocks > 0) {
            this.remainingStocks -= 1;
            return 1;
        }
        return 0;
    }

    @Override
    public long purchaseStocks(long amount) {
        long purchasedStocks;
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
    public long sellStock() {
        if (this.remainingStocks < this.totalStocks) {
            this.remainingStocks += 1;
            return 1;
        }
        return 0;
    }

    @Override
    public long sellStocks(long amount) throws Exception {
        long soldStocks;
        if (this.remainingStocks <= this.totalStocks - amount) {
            soldStocks = amount;
            this.remainingStocks += soldStocks;
        } else {
            throw new StockException("Unable to sell your stocks at the moment");
        }
        return soldStocks;
    }
}
