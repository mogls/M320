
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
        PortfolioContent portfolioContent = new PortfolioContent(user);

        Market market = new Market(stockMarkets, user);

        CardLayout cardLayout = new CardLayout();
        JPanel contentPanel = new JPanel(cardLayout);

        contentPanel.add(market.render(), "Markets");
        contentPanel.add(portfolioContent.render(), "Portfolio");

        menuBar.get("Portfolio").addActionListener(e -> {
            portfolioContent.update();
            cardLayout.show(contentPanel, "Portfolio");
        });

        menuBar.get("Markets").addActionListener(e -> {
            market.resetUi();
            cardLayout.show(contentPanel, "Markets");
        });

        cardLayout.show(contentPanel, "Markets");

        setJMenuBar(menuBar.render());
        add(contentPanel, BorderLayout.CENTER);
    }

    public static void run(String name) {
        SwingUtilities.invokeLater(() -> {
            App app = new App(name);
            app.setVisible(true);
        });
    }


}
