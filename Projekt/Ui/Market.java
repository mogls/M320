package Ui;

import Interfaces.StockMarket;
import Models.Portfolio;

import java.util.ArrayList;

public class Market {

    private  ArrayList<StockMarket> stockMarkets;
    private Portfolio portfolio;

    // TODO: update needs removeAll() but functions will be here, so just reapply
    //  afterwards make subContent() and following gets part of a list, as they don't need their own identity


    public Market(ArrayList<StockMarket> stockMarkets, Portfolio portfolio) {
        PurchasePanel purchasePanel = new PurchasePanel(portfolio);
        MarketContent marketContent = new MarketContent(stockMarkets);



    }
}
