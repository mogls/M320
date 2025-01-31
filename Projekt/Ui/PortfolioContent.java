package Ui;

import Interfaces.Renderable;
import Models.Portfolio;

import javax.swing.*;
import java.awt.*;

public class PortfolioContent extends UiInteractiveItem<JLabel> implements Renderable<JScrollPane> {

    private Portfolio portfolio;

    private JScrollPane scrollPane;

    private JPanel textPanel;

    public PortfolioContent(Portfolio portfolio) {
        this.portfolio = portfolio;
        this.textPanel = new JPanel();
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

    public void update() {
        textPanel.removeAll();

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

        textPanel.revalidate();
        textPanel.repaint();
    }

    private JLabel createClickableText(String text) {
        JLabel clickableText = new JLabel(text);
        clickableText.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clickableText.setAlignmentX(Component.LEFT_ALIGNMENT);
        clickableText.setFont(new Font("Arial", Font.PLAIN, 24));

        clickableText.setName(text);

        this.add(clickableText.getName(), clickableText);

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
