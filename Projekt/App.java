
import Exceptions.StockMarketException;
import Exceptions.UserInputException;
import Initialize.Init;
import Interfaces.Stock;
import Interfaces.StockMarket;
import Markets.NewYork;
import Markets.Zurich;
import Models.Portfolio;
import Ui.MainContent;
import Ui.MenuBar;
import Ui.PurchasePanel;

import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class App extends JFrame {


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
        try {
            user.purchase(zurich, "Nvidia", 1000);
        } catch (StockMarketException e) {
            System.out.println("StockMarketException: " + e);
        } catch (UserInputException e) {
            System.out.println("UserInputException: " + e);
        }


        MenuBar menuBar = new MenuBar();
        PurchasePanel purchasePanel = new PurchasePanel();
        MainContent marketContent = new MainContent(stockMarkets);
        MainContent portfolioContent = new MainContent(user);

        CardLayout cardLayout = new CardLayout();
        JPanel contentPanel = new JPanel(cardLayout);

        contentPanel.add(marketContent.render(), "Markets");
        contentPanel.add(portfolioContent.render(), "Portfolio");


        menuBar.get("Market").addActionListener(e -> cardLayout.show(contentPanel, "Markets"));
        menuBar.get("Portfolio").addActionListener(e -> cardLayout.show(contentPanel, "Portfolio"));

        cardLayout.show(contentPanel, "Markets");

        setJMenuBar(menuBar.render());
        add(contentPanel, BorderLayout.CENTER);
        add(purchasePanel.render(), BorderLayout.SOUTH);
    }

    public static void run(String name) {
        SwingUtilities.invokeLater(() -> {
            App app = new App(name);
            app.setVisible(true);
        });
    }
}
