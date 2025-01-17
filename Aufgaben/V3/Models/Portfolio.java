package Models;

import Exceptions.StockMarketException;
import Exceptions.UserInputException;
import Interfaces.Stock;
import Interfaces.StockMarket;

import java.util.HashMap;

public class Portfolio {
    // TODO everything

    // flattened HashMap with composite key e.g. "Zurich:Nvidia"
    private HashMap<String, Long> ownedStocks;

    private Long balance;

    final public String owner;

    public Portfolio(String owner) {
        this.owner = owner;
        this.balance = 10000L;
    }

    public Portfolio(String owner, Long balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void purchase(StockMarket market, String stock, Integer amount) throws StockMarketException, UserInputException {
        long amountPurchased = market.purchase(stock, amount);
        long stockPrice = market.getPrice(stock);
        balance -= (amountPurchased * stockPrice);
        if (balance < 0) {
            market.sell(stock, amountPurchased);
            balance += (amountPurchased * stockPrice);
            throw new UserInputException("Insufficient funds to purchase this");
        } else {
            ownedStocks.put(market.getName()+":"+stock, amountPurchased);
        }
    }

    public Long getBalance() { return this.balance; }

    public HashMap<String, Long> getOwnedStocks() { return this.ownedStocks; }
}
