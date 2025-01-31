package Ui;

import Interfaces.Renderable;
import Interfaces.StockMarket;
import Models.Portfolio;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Market implements Renderable<JPanel> {

    private  ArrayList<StockMarket> stockMarkets;
    private Portfolio portfolio;

    private JPanel mainPanel;

    private CardLayout cardLayout;

    private MarketContent marketContent;
    private PurchasePanel purchasePanel;

    private ArrayList<SubContent> subContents = new ArrayList<>();

    private String selectedStock;
    private StockMarket selectedMarket;
    private SubContent selectedSubContent;


    // TODO: update needs removeAll() but functions will be here, so just reapply
    //  afterwards make subContent() and following gets part of a list, as they don't need their own identity


    public Market(ArrayList<StockMarket> stockMarkets, Portfolio portfolio) {
        this.stockMarkets = stockMarkets;
        this.portfolio = portfolio;

        initialize();

    }

    private void initialize () {
        this.purchasePanel = new PurchasePanel(this.portfolio);
        this.marketContent = new MarketContent(this.stockMarkets);

        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(this.cardLayout);

        this.mainPanel.add(marketContent.render(),"Markets");

        this.cardLayout.show(this.mainPanel, "Markets");

        this.setup();
    }

    public void resetUi() {
        this.marketContent.update();
        this.cardLayout.show(this.mainPanel, "Markets");
        this.setup();
    }

    private void setup() {
        this.createMarketFunctions();
        this.createSubContents();
        this.attachSubContentsToMarket();
    }

    private void createSubContents () {
        for (StockMarket stockMarket : this.stockMarkets) {
            SubContent subContent = new SubContent(stockMarket.getName(), stockMarket);
            this.addSubContentSelectors(subContent, stockMarket);
            this.subContents.add(subContent);
            this.mainPanel.add(subContent.render(), stockMarket.getName());
        }
    }

    private void addSubContentSelectors (SubContent subContent, StockMarket stockMarket) {
        for (String stockName : stockMarket.getStockNames()) {

            final String selectedStockName = stockName; // to ensure no funny business

            subContent.get(stockName).addMouseListener(new MouseClick(
                    e -> {
                        this.selectStock(selectedStockName);
                        this.selectSubContent(subContent);
                        this.updateSelected();
                    }
            ));
        }
    }

    private void updateSelected () {
        // call update first to clear everything
        this.selectedSubContent.updateUi();
        // then highlight
        JComponent toHighlight = this.selectedSubContent.get(this.selectedStock);
        if (toHighlight != null) {
            toHighlight.setBackground(Color.blue);
            toHighlight.setForeground(Color.white);
        } else {
            System.out.println("Warning: No component found for stock " + this.selectedStock);
        }
    }

    private void selectSubContent(SubContent subContent) {
        this.selectedSubContent = subContent;
    }

    private void selectStock(String stockName) {
        this.selectedStock = stockName;
    }

    private void selectMarket(StockMarket stockMarket) {
        this.selectedMarket = stockMarket;
    }


    private void attachSubContentsToMarket () {
        for (StockMarket stockMarket : this.stockMarkets) {
            String stockName = stockMarket.getName();
            this.marketContent.get(stockName).addMouseListener(new MouseClick(
                    e -> {
                        this.cardLayout.show(this.mainPanel, stockName);
                        this.selectMarket(stockMarket);
                    }
            ));
        }
    }

    private void createMarketFunctions () {
        for (StockMarket stockMarket : this.stockMarkets) {
            String marketName = stockMarket.getName();

            this.marketContent.get(marketName).addMouseListener(new MouseClick(
                    e -> this.cardLayout.show(this.mainPanel, marketName)));
        }
    }

    private void back() {
        this.cardLayout.show(this.mainPanel, "Markets");
    }

    /**
     * @return The item to be rendered
     */
    @Override
    public JPanel render() {
        return this.mainPanel;
    }
}
