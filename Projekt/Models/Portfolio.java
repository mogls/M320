package Models;

import Exceptions.StockMarketException;
import Exceptions.UserInputException;
import Interfaces.Stock;
import Interfaces.StockMarket;

import java.util.HashMap;

public class Portfolio {
    // TODO everything

    // flattened HashMap with composite key e.g. "Zurich:Nvidia"
    private HashMap<String, Integer> ownedStocks = new HashMap<>();

    private Integer balance;

    final public String owner;

    public Portfolio(String owner) {
        this.owner = owner;
        this.balance = 10000;
    }

    public Portfolio(String owner, Integer balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void purchase(StockMarket market, String stock, Integer amount) throws StockMarketException, UserInputException {
        int stockPrice = market.getPrice(stock);
        int amountPurchased = market.purchase(stock, amount);
        int totalPrice = stockPrice * amountPurchased;

        this.balance -= totalPrice;

        String fullName = market.getName() + ":" + stock;

        if (this.balance < 0) {
            market.sell(stock, amountPurchased);
            this.balance += totalPrice;
            throw new UserInputException("Insufficient funds to purchase this");
        } else {
            int currentStock = this.ownedStocks.get(fullName);
            this.ownedStocks.put(fullName, currentStock + amountPurchased);
        }
    }

    public void sell(StockMarket market, String stock, Integer amount) throws StockMarketException {
        int stockPrice = market.getPrice(stock);
        int amountSold = 0;

        try {
            amountSold = market.sell(stock, amount);

        } catch (StockMarketException e) {
            System.out.println("Naughty Naughty");
        }

        int totalPrice = stockPrice * amountSold;

        this.balance += totalPrice;

        String fullName = market.getName() + ":" + stock;

        int currentStock = this.ownedStocks.get(fullName);
        this.ownedStocks.put(fullName, currentStock - amountSold);
    }

    public Integer getBalance() { return this.balance; }

    public HashMap<String, Integer> getOwnedStocks() { return this.ownedStocks; }
}
