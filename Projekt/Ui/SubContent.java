package Ui;

import Exceptions.StockMarketException;
import Interfaces.Renderable;
import Interfaces.StockMarket;

import javax.swing.*;
import java.awt.*;

public class SubContent extends UiInteractiveItem implements Renderable<JScrollPane> {
    private JScrollPane scrollPane;

    public SubContent(String titleName, StockMarket stockMarket) {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(textPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel title = new JLabel(titleName);
        title.setFont(new Font("Arial", Font.PLAIN, 40));

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(20));

        for (String stockName: stockMarket.getStockNames()) {
            int price;
            try {
                price = stockMarket.getPrice(stockName);
            } catch (StockMarketException e) {
                System.out.println(e.getMessage());
            }
            // TODO add second column which displays the price
            textPanel.add(createClickableText(stockName));

            textPanel.add(Box.createVerticalStrut(10));
        }

    }

    // TODO create second constructor that handles Portfolio case


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
