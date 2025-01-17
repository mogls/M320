package Models;

import Interfaces.Stock;
import Interfaces.StockMarket;

// so much wasted effort :(


/**
 * StockData is a data-container class to store all necessary data about a given stock,
 * such as:
 * @- The market in which it is located
 * @- The stock itself
 * @- The amount of the stock stored in the container, not necessarily purchased
 */
public class StockData {

    private StockMarket market;
    private Stock stock;
    private Integer amount;

    /**
     * Initialises StockData with a market
     * @param market the market in which the stock is located
     */
    public StockData(StockMarket market) {
        this.market = market;
    }

    /**
     * Initialises StockData with all aspects
     * @param market the market in which the stock is located
     * @param stock the owned stock
     * @param amount the amount of stock that has been purchased
     */
    public StockData(StockMarket market, Stock stock, Integer amount) {
        this.market = market;
        this.stock = stock;
        this.amount = amount;
    }

    /**
     * Initialises an empty StockData
     */
    public StockData() {}

    public void setMarket(StockMarket market) {
        this.market = market;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * Increments the amount by the value given
     * @param increment how much to increment the amount of stocks by, if negative it subtracts
     */
    public void incrementAmount(Integer increment) {
        this.amount += increment;
    }

    public StockMarket getMarket() { return this.market; }
    public Stock getStock() { return this.stock; }
    public Integer getAmount() { return this.amount; }

}
