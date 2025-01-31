package Ui;

import Exceptions.StockMarketException;
import Interfaces.Renderable;
import Interfaces.StockMarket;

import javax.swing.*;
import java.awt.*;

public class SubContent extends UiInteractiveItem<JComponent> implements Renderable<JScrollPane> {
    private JScrollPane scrollPane;

    public SubContent(String titleName, StockMarket stockMarket) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));
        JPanel textPanel = new JPanel();
        JPanel pricePanel = new JPanel();

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.Y_AXIS));

        mainPanel.add(textPanel);
        mainPanel.add(pricePanel);


        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel title = new JLabel(titleName);
        title.setFont(new Font("Arial", Font.PLAIN, 40));

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(20));
        // title + padding
        pricePanel.add(Box.createVerticalStrut(68));

        for (String stockName: stockMarket.getStockNames()) {
            int price;
            try {
                price = stockMarket.getPrice(stockName);
                pricePanel.add(createText(Integer.toString(price)));
            } catch (StockMarketException e) {
                System.out.println(e.getMessage());
            }
            // TODO add second column which displays the price
            textPanel.add(createClickableText(stockName));

            textPanel.add(Box.createVerticalStrut(10));
            pricePanel.add(Box.createVerticalStrut(10));

        }

    }

    // TODO create second constructor that handles Portfolio case


    // TODO: add function callback in later implementation
    private JLabel createClickableText(String text) {
        JLabel clickableText = new JLabel(text);
        clickableText.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clickableText.setAlignmentX(Component.LEFT_ALIGNMENT);
        clickableText.setFont(new Font("Arial", Font.PLAIN, 24));

        clickableText.setOpaque(true);

        clickableText.setName(text);

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

    /**
     * @return The item to be rendered
     */
    @Override
    public JScrollPane render() {
        return this.scrollPane;
    }
}
