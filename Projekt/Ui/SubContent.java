package Ui;

import Exceptions.StockMarketException;
import Interfaces.Renderable;
import Interfaces.StockMarket;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SubContent extends UiInteractiveItem<JComponent> implements Renderable<JScrollPane> {
    private JScrollPane scrollPane;
    private String name;

    private JPanel textPanel;
    private JPanel pricePanel;
    private JPanel mainPanel;

    private ArrayList<JLabel> labels = new ArrayList<>();
    private StockMarket stockMarket;

    public SubContent(String titleName, StockMarket stockMarket) {
        this.name = titleName;
        this.stockMarket = stockMarket;

        this.mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));
        this.textPanel = new JPanel();
        this.pricePanel = new JPanel();

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.Y_AXIS));

        mainPanel.add(textPanel);
        mainPanel.add(pricePanel);


        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel title = new JLabel(this.name);
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
        pricePanel.removeAll();

        mainPanel.add(textPanel);
        mainPanel.add(pricePanel);


        JLabel title = new JLabel(this.name);
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
