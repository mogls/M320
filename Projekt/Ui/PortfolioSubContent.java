package Ui;

import Exceptions.StockMarketException;
import Interfaces.Renderable;
import Interfaces.StockMarket;
import Models.Portfolio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PortfolioSubContent extends UiInteractiveItem<JComponent> implements Renderable<JScrollPane> {
    private JScrollPane scrollPane;
    private String name;

    private JPanel textPanel;
    private JPanel amountPanel;
    private JPanel mainPanel;

    private ArrayList<JLabel> labels = new ArrayList<>();
    private Portfolio portfolio;

    private String selectedMarket;

    public PortfolioSubContent(String titleName, Portfolio portfolio) {
        this.name = titleName;
        this.portfolio = portfolio;

        this.selectedMarket = titleName;
        
        this.mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));
        this.textPanel = new JPanel();
        this.amountPanel = new JPanel();

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        amountPanel.setLayout(new BoxLayout(amountPanel, BoxLayout.Y_AXIS));

        mainPanel.add(textPanel);
        mainPanel.add(amountPanel);


        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel title = new JLabel(this.name);
        title.setFont(new Font("Arial", Font.PLAIN, 40));

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(20));
        // title + padding
        amountPanel.add(Box.createVerticalStrut(68));

        for (String stockName: portfolio.getOwnedStockNames()) {
            // in form of marketName:stockName
            String stock = stockName.split(":")[1];
            String marketName = stockName.split(":")[0];

            if (!selectedMarket.equals(marketName)) {
                continue;
            }
            
            int amount = portfolio.getOwnedStock(stockName);

            amountPanel.add(createText(Integer.toString(amount)));

            textPanel.add(createClickableText(stock));

            textPanel.add(Box.createVerticalStrut(10));
            amountPanel.add(Box.createVerticalStrut(10));
        }
    }

    public void updateUi () {
        for (JLabel label : labels) {
            label.setBackground(Color.white);
            label.setForeground(Color.black);
        }
        textPanel.repaint();
    }

    public void updateAll() {
        mainPanel.removeAll();
        textPanel.removeAll();
        amountPanel.removeAll();

        mainPanel.add(textPanel);
        mainPanel.add(amountPanel);


        JLabel title = new JLabel(this.name);
        title.setFont(new Font("Arial", Font.PLAIN, 40));

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(20));
        // title + padding
        amountPanel.add(Box.createVerticalStrut(68));

        for (String stockName: portfolio.getOwnedStockNames()) {
            // in form of marketName:stockName
            String stock = stockName.split(":")[1];
            String marketName = stockName.split(":")[0];

            if (!selectedMarket.equals(marketName)) {
                continue;
            }

            int amount = portfolio.getOwnedStock(stockName);

            amountPanel.add(createText(Integer.toString(amount)));

            textPanel.add(createClickableText(stock));

            textPanel.add(Box.createVerticalStrut(10));
            amountPanel.add(Box.createVerticalStrut(10));
        }

        mainPanel.revalidate();
        mainPanel.repaint();
    }


    // TODO: add function callback in later implementation
    private JLabel createClickableText(String text) {
        JLabel clickableText = new JLabel(text);
        clickableText.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clickableText.setAlignmentX(Component.LEFT_ALIGNMENT);
        clickableText.setFont(new Font("Arial", Font.PLAIN, 24));

        clickableText.setOpaque(true);

        clickableText.setName(text);

        labels.add(clickableText);

        this.add(clickableText.getName(), clickableText);

        return clickableText;
    }

    private JLabel createText(String text) {
        JLabel clickableText = new JLabel(text);
        clickableText.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clickableText.setAlignmentX(Component.LEFT_ALIGNMENT);
        clickableText.setFont(new Font("Arial", Font.PLAIN, 24));

        return clickableText;

    }

    public String getName() { return this.name; }

    /**
     * @return The item to be rendered
     */
    @Override
    public JScrollPane render() {
        return this.scrollPane;
    }
}
