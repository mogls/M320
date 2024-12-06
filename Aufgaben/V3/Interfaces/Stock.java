package Interfaces;

public interface Stock {
    public long getPrice();
    public long getRemainingStocks();
    public long purchaseStock();
    public long purchaseStocks(long amount);
    public long sellStock();
    public long sellStocks(long amount) throws Exception;
}
