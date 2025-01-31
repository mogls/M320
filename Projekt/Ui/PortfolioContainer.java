package Ui;

import Interfaces.Renderable;
import Models.Portfolio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PortfolioContainer implements Renderable<JPanel> {
    private Portfolio portfolio;
    private JPanel containerPanel;

    private JPanel mainPanel;

    private CardLayout cardLayout;

    private PortfolioContent portfolioContent;

    private ArrayList<PortfolioSubContent> portfolioSubContents = new ArrayList<>();

    private BalancePanel balancePanel;
    private String selectedStock;
    private String selectedMarket;
    private PortfolioSubContent portfolioSubContent;

    public PortfolioContainer(Portfolio portfolio) {
        this.portfolio = portfolio;

        this.portfolioContent = new PortfolioContent(this.portfolio);
        this.balancePanel = new BalancePanel(this.portfolio);

        this.containerPanel = new JPanel();

        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));

        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(this.cardLayout);

        this.mainPanel.add(portfolioContent.render(), "Portfolio");

        this.cardLayout.show(this.mainPanel, "Portfolio");

        containerPanel.add(this.mainPanel, BorderLayout.NORTH);

        containerPanel.add(balancePanel.render(), BorderLayout.SOUTH);


        this.setup();
    }

    public void update() {
        this.portfolioContent.update();
        this.balancePanel.update();
        this.cardLayout.show(this.mainPanel, "Portfolio");
        this.setup();
    }

    private void setup() {
        this.createSubContents();
        this.createPortfolioFunctions();
    }

    private void createSubContents () {
        for (String marketName: this.portfolioContent.getKeys()) {
            PortfolioSubContent portfolioSubContent = new PortfolioSubContent(marketName, this.portfolio);
//            this.portfolioSubContents.add(portfolioSubContent);
            System.out.println("createSubContents: " + marketName);
            this.mainPanel.add(portfolioSubContent.render(), marketName);
        }
    }

    private void createPortfolioFunctions () {
        for (String marketName : this.portfolioContent.getKeys()) {
            System.out.println("createPortfolioContents: " + marketName);

            this.portfolioContent.get(marketName).addMouseListener(new MouseClick(
                    e -> this.cardLayout.show(this.mainPanel, marketName)));
        }
    }

    private void selectAndBindMarket(String stockMarket) {
        this.selectedMarket = stockMarket;
//        this.selectedPortfolioSubContent.bindSelectedMarket(this.selectedMarket);
    }

    /**
     * @return The item to be rendered
     */
    @Override
    public JPanel render() {
        return this.containerPanel;
    }
}
