package Ui;

import Exceptions.StockMarketException;
import Exceptions.UserInputException;
import Interfaces.Renderable;
import Interfaces.StockMarket;
import Models.Portfolio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Market implements Renderable<JPanel> {

    private  ArrayList<StockMarket> stockMarkets;
    private Portfolio portfolio;

    private JPanel mainPanel;

    private CardLayout cardLayout;

    private MarketContent marketContent;
    private ControlPanel controlPanel;

    private ArrayList<MarketSubContent> marketSubContents = new ArrayList<>();

    private String selectedStock;
    private StockMarket selectedMarket;
    private MarketSubContent selectedMarketSubContent;

    public Market(ArrayList<StockMarket> stockMarkets, Portfolio portfolio) {
        this.stockMarkets = stockMarkets;
        this.portfolio = portfolio;

        initialize();

    }

    private void initialize () {
        this.controlPanel = new ControlPanel();
        this.marketContent = new MarketContent(this.stockMarkets);

        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(this.cardLayout);




        this.mainPanel.add(marketContent.render(),"Markets");
//        this.mainPanel.add(purchasePanel.render(), BorderLayout.SOUTH);

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
        this.setupControlPanel();
    }

    private void setupControlPanel() {
        JButton purchaseButton = this.controlPanel.get("Purchase");
        purchaseButton.addActionListener(e -> this.purchaseStock());
        JButton sellButton = this.controlPanel.get("Sell");
        sellButton.addActionListener(e -> this.sellStock());
    }

    private void purchaseStock() {
        try {
            Integer purchaseAmount = this.controlPanel.getAmount();
            System.out.println("Purchase Amount: " + purchaseAmount);
            this.portfolio.purchase(this.selectedMarket, this.selectedStock, purchaseAmount);
        } catch (StockMarketException | UserInputException e) {
            System.out.println("There was an error: " + e);
        }
    }
    
    private void sellStock() {
        try {
            Integer sellAmount = this.controlPanel.getAmount();
            System.out.println("SellAmount: " + sellAmount);
            this.portfolio.sell(this.selectedMarket, this.selectedStock, sellAmount);
        } catch (StockMarketException e) {
            System.out.println("There was an error: " + e);
        }
    }

    private void createSubContents () {
        for (StockMarket stockMarket : this.stockMarkets) {
            MarketSubContent marketSubContent = new MarketSubContent(stockMarket.getName(), stockMarket);
            this.addSubContentSelectors(marketSubContent, stockMarket);
            this.marketSubContents.add(marketSubContent);

            JPanel subContentContainer = new JPanel();

            subContentContainer.setLayout(new BoxLayout(subContentContainer, BoxLayout.Y_AXIS));

            subContentContainer.add(marketSubContent.render(), BorderLayout.CENTER);

            this.mainPanel.add(subContentContainer, stockMarket.getName());
        }
    }

    private void addSubContentSelectors (MarketSubContent marketSubContent, StockMarket stockMarket) {
        for (String stockName : stockMarket.getStockNames()) {

            final String selectedStockName = stockName; // to ensure no funny business

            marketSubContent.get(stockName).addMouseListener(new MouseClick(
                    e -> {
                        this.selectStock(selectedStockName);
                        this.selectSubContent(marketSubContent);
                        this.updateSelected();
                    }
            ));
        }
    }

    private void updateSelected () {
        // call update first to clear everything
        this.selectedMarketSubContent.updateUi();
        // then highlight
        JComponent toHighlight = this.selectedMarketSubContent.get(this.selectedStock);
        if (toHighlight != null) {
            toHighlight.setBackground(Color.blue);
            toHighlight.setForeground(Color.white);
        } else {
            System.out.println("Warning: No component found for stock " + this.selectedStock);
        }

        Container subContentContainer = selectedMarketSubContent.render().getParent();
        subContentContainer.add(this.controlPanel.render(), BorderLayout.SOUTH);
        subContentContainer.revalidate();
        subContentContainer.repaint();
    }

    private void selectSubContent(MarketSubContent marketSubContent) {
        this.selectedMarketSubContent = marketSubContent;
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
