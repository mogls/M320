
import Exceptions.StockMarketException;
import Exceptions.UserInputException;
import Initialize.Init;
import Interfaces.StockMarket;
import Markets.NewYork;
import Markets.Zurich;
import Models.Portfolio;
import Ui.*;
import Ui.MenuBar;

import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;


public class App extends JFrame {

    private StockMarket selectedMarket;
    private String selectedStock;

    public App(String name) {

        //Create the Frame
        setTitle(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        // init stock markets
        NewYork newYork = (NewYork) Init.initMarket(new NewYork());
        Zurich zurich = (Zurich) Init.initMarket(new Zurich());

        ArrayList<StockMarket> stockMarkets = new ArrayList<>();
        stockMarkets.add(zurich);
        stockMarkets.add(newYork);

        Portfolio user = new Portfolio("User");
        // test values
//        try {
//            user.purchase(zurich, "Nvidia", 20);
//        } catch (StockMarketException e) {
//            System.out.println("StockMarketException: " + e);
//        } catch (UserInputException e) {
//            System.out.println("UserInputException: " + e);
//        }


        MenuBar menuBar = new MenuBar();
        PurchasePanel purchasePanel = new PurchasePanel(user);
        MarketContent marketContent = new MarketContent(stockMarkets);
        PortfolioContent portfolioContent = new PortfolioContent(user);
        SubContent zurichContent = new SubContent("Zurich", zurich);

        CardLayout cardLayout = new CardLayout();
        JPanel contentPanel = new JPanel(cardLayout);

        contentPanel.add(marketContent.render(), "Markets");
        contentPanel.add(portfolioContent.render(), "Portfolio");
        contentPanel.add(zurichContent.render(), "Zurich");

//        marketContent.get("Zurich").addMouseListener(e -> cardLayout.show(contentPanel, "Zurich"));
        marketContent.get("Zurich").addMouseListener(new MouseClick(e -> {
            cardLayout.show(contentPanel, "Zurich");
            selectMarket(zurich);
        }));

        zurichContent.get("Nvidia").addMouseListener(new MouseClick(e -> {
            e.getComponent().setBackground(Color.BLUE);
            e.getComponent().setForeground(Color.WHITE);
            selectStock(e.getComponent().getName());
        }));

        purchasePanel.get("Purchase").addActionListener(e -> {
            try {
                user.purchase(selectedMarket, selectedStock, purchasePanel.getPurchaseAmount());
            } catch (StockMarketException | UserInputException ex) {
                System.out.println(ex.getMessage());
            }
        });

        menuBar.get("Market").addActionListener(e -> {
            marketContent.update();
            cardLayout.show(contentPanel, "Markets");
        });

        menuBar.get("Portfolio").addActionListener(e -> {
            portfolioContent.update();
            cardLayout.show(contentPanel, "Portfolio");
        });

        cardLayout.show(contentPanel, "Markets");

        setJMenuBar(menuBar.render());
        add(contentPanel, BorderLayout.CENTER);
        add(purchasePanel.render(), BorderLayout.SOUTH);
    }

    private void selectMarket(StockMarket market) {
        this.selectedMarket = market;
    }

    private void selectStock(String stock) {
        this.selectedStock = stock;
    }

    public static void run(String name) {
        SwingUtilities.invokeLater(() -> {
            App app = new App(name);
            app.setVisible(true);
        });
    }


}
