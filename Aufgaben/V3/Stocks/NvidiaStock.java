package Stocks;

import Exceptions.StockException;

public class NvidiaStock implements Interfaces.Stock {

    private long price;
    final private long totalStocks = 1000;
    private long remainingStocks = 1000;



    public NvidiaStock() {
        this.price = 150;
    }
    public NvidiaStock(long price) {
        this.price = price;
    }
    /**
     * @return current price of the stock
     */
    @Override
    public long getPrice() {
        return this.price;
    }

    /**
     * Updates the price based on the provided value
     * (to subtract from the price, provide a negative value)
     *
     * @param amount the amount that gets added to the price (can be negative)
     */
    public void updatePrice(long amount) {
        this.price += amount;
    }

    /**
     * @return remaining stock
     */
    @Override
    public long getRemainingStocks() {
        return this.remainingStocks;
    }

    /**
     * @return number of stocks successfully purchased, usually 1 unless there in insufficient remaining stock
     */
    @Override
    public long purchaseStock() {
        if (this.remainingStocks > 0) {
            this.remainingStocks -= 1;
            return 1;
        }
        return 0;
    }

    /**
     * @param amount number of stocks to purchase
     * @return amount of stocks successfully purchased, usually equal to input amount unless there in insufficient remaining stock
     */
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

    /**
     * @return number of stocks successfully sold, usually 0
     */
    @Override
    public long sellStock() {
        if (this.remainingStocks < this.totalStocks) {
            this.remainingStocks += 1;
            return 1;
        }
        return 0;
    }

    /**
     * @param amount number of stocks to sell
     * @return number of stocks successfully sold, usually equal to input amount otherwise something went wrong
     * @throws Exception StockException
     */
    @Override
    public long sellStocks(long amount) throws StockException {
        long soldStocks;
        if (this.remainingStocks <= this.totalStocks - amount) {
            soldStocks = amount;
            this.remainingStocks += soldStocks;
        } else {
            throw new StockException("Somehow there are more stocks than at the start");
        }
        return soldStocks;
    }
}