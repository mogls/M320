package Ui;

import Interfaces.Renderable;
import Interfaces.StockMarket;
import Models.Portfolio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainContent extends UiInteractiveItem<JComponent> implements Renderable<JScrollPane> {
    private JScrollPane scrollPane;

    public MainContent(ArrayList<StockMarket> stockMarkets) {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(textPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel title = new JLabel("Stock Markets");
        title.setFont(new Font("Arial", Font.PLAIN, 40));

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(20));

        for (StockMarket market: stockMarkets) {
            textPanel.add(createClickableText(market.getName()));
            textPanel.add(Box.createVerticalStrut(10));
        }
    }

    public MainContent(Portfolio portfolio) {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(textPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel title = new JLabel("Portfolio");
        title.setFont(new Font("Arial", Font.PLAIN, 40));

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(20));

        for (String stockName: portfolio.getOwnedStockNames()) {
            // in form of marketName:stockName
            String marketName = stockName.split(":")[0];

            textPanel.add(createClickableText(marketName));

            textPanel.add(Box.createVerticalStrut(10));
        }
    }
//    unused ATM
//    public MainContent() {
//        JPanel textPanel = new JPanel();
//        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
//
//        scrollPane = new JScrollPane(textPanel);
//
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//
//        JLabel clickableText = new JLabel("test");
//        clickableText.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        clickableText.setAlignmentX(Component.LEFT_ALIGNMENT);
//
//        textPanel.add(clickableText);
//    }

    // TODO: add function callback in later implementation
    private JLabel createClickableText(String text) {
        JLabel clickableText = new JLabel(text);
        clickableText.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clickableText.setAlignmentX(Component.LEFT_ALIGNMENT);
        clickableText.setFont(new Font("Arial", Font.PLAIN, 24));

        return clickableText;
    }

    /**
     * @return The item to be rendered
     */
    @Override
    public JScrollPane render() {
        return this.scrollPane;
    }
}
