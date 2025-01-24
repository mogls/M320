package Models;

import Exceptions.StockMarketException;
import Exceptions.UserInputException;
import Interfaces.Stock;
import Interfaces.StockMarket;

import java.util.HashMap;

public class Portfolio {
    // TODO everything

    // flattened HashMap with composite key e.g. "Zurich:Nvidia"
    private HashMap<String, Integer> ownedStocks = new HashMap<String, Integer>();

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
        int amountPurchased = market.purchase(stock, amount);
        int stockPrice = market.getPrice(stock);
        int totalPrice = amountPurchased * stockPrice;
        balance -= totalPrice;



        if (balance < 0) {
            market.sell(stock, amountPurchased);
            balance += totalPrice;
            throw new UserInputException("Insufficient funds to purchase this");
        } else {
            Integer currentStock = ownedStocks.get(market.getName()+":"+stock);
            currentStock = currentStock == null ? 0 : currentStock;
            ownedStocks.put(market.getName()+":"+stock, currentStock + amountPurchased);
        }
    }

    public Integer getBalance() { return this.balance; }

    public HashMap<String, Integer> getOwnedStocks() { return this.ownedStocks; }
}
