package Stocks;

import Exceptions.StockException;

public class NvidiaStock implements Interfaces.Stock {

    private int price;
    final private int totalStocks = 1000;
    private int remainingStocks = 1000;



    public NvidiaStock() {
        this.price = 150;
    }
    public NvidiaStock(int price) {
        this.price = price;
    }
    /**
     * @return current price of the stock
     */
    @Override
    public int getPrice() {
        return this.price;
    }

    /**
     * Updates the price based on the provided value
     * (to subtract from the price, provide a negative value)
     *
     * @param amount the amount that gets added to the price (can be negative)
     */
    public void updatePrice(int amount) {
        this.price += amount;
    }

    /**
     * @return remaining stock
     */
    @Override
    public int getRemainingStocks() {
        return this.remainingStocks;
    }

    /**
     * @return number of stocks successfully purchased, usually 1 unless there in insufficient remaining stock
     */
    @Override
    public int purchaseStock() {
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

    /**
     * @return number of stocks successfully sold, usually 0
     */
    @Override
    public int sellStock() {
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
    public int sellStocks(int amount) throws StockException {
        int soldStocks;
        if (this.remainingStocks <= this.totalStocks - amount) {
            soldStocks = amount;
            this.remainingStocks += soldStocks;
        } else {
            throw new StockException("Somehow there are more stocks than at the start");
        }
        return soldStocks;
    }
}