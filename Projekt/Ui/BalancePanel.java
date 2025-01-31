package Ui;

import Interfaces.Renderable;
import Models.Portfolio;

import javax.swing.*;
import java.awt.*;


public class BalancePanel implements Renderable<JPanel> {

    private final JPanel panel;

    private final Portfolio portfolio;

    public BalancePanel(Portfolio portfolio) {
        this.portfolio = portfolio;
        this.panel = new JPanel();
        JLabel label = new JLabel("Your Balance: " + portfolio.getBalance());

        label.setFont(new Font("Arial", Font.PLAIN, 30));

        this.panel.add(label);

        System.out.println("Created");

    }

    public void update() {
        this.panel.removeAll();
        JLabel label = new JLabel("Your Balance: " + this.portfolio.getBalance());

        label.setFont(new Font("Arial", Font.PLAIN, 30));

        this.panel.add(label);
    }

    /**
     * @return The item to be rendered
     */
    @Override
    public JPanel render() {
        return this.panel;
    }
}
