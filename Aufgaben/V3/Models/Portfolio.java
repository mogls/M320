package Models;

import Exceptions.StockMarketException;
import Exceptions.UserInputException;
import Interfaces.Stock;
import Interfaces.StockMarket;

import java.util.HashMap;

public class Portfolio {
    // TODO everything

    // flattened HashMap with composite key e.g. "Zurich:Nvidia"
    private HashMap<String, Long> ownedStocks = new HashMap<String, Long>();

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
        long totalPrice = amountPurchased * stockPrice;
        balance -= totalPrice;



        if (balance < 0) {
            market.sell(stock, amountPurchased);
            balance += totalPrice;
            throw new UserInputException("Insufficient funds to purchase this");
        } else {
            Long currentStock = ownedStocks.get(market.getName()+":"+stock);
            currentStock = currentStock == null ? 0 : currentStock;
            ownedStocks.put(market.getName()+":"+stock, currentStock + amountPurchased);
        }
    }

    public Long getBalance() { return this.balance; }

    public HashMap<String, Long> getOwnedStocks() { return this.ownedStocks; }
}
