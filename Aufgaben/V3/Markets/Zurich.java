package Markets;

import Exceptions.StockMarketException;
import Interfaces.Stock;
import Interfaces.StockMarket;

import java.util.HashMap;

public class Zurich implements StockMarket {
    private HashMap<String, Stock> stocks;

    public Zurich(HashMap<String, Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public long getPrice(String stockName) throws StockMarketException {
        return checkStockExists(stockName).getPrice();

    }

    @Override
    public long purchase(String stockName) throws StockMarketException {
        return checkStockExists(stockName).purchaseStock();
    }

    @Override
    public long purchase(String stockName, long amount) throws StockMarketException {
        return checkStockExists(stockName).purchaseStocks(amount);
    }

    @Override
    public long sell(String stockName) throws StockMarketException {
        return checkStockExists(stockName).sellStock();
    }

    public void updateStocks(String stockName, Stock stock) {
        this.stocks.put(stockName, stock);
    }

    private Stock checkStockExists(String stockName) throws StockMarketException {
        Stock stock = this.stocks.get(stockName);
        if ( stock == null) throw new StockMarketException("There is no stock with this name");
        return stock;
    }

}
