package Ui;


import javax.swing.*;
import java.awt.*;


public class MenuBar extends UiInteractiveItem<JMenuItem> {

    // TODO? makes logic and ui a bit tightly coupled, might refactor, but it works for now
    public JMenuBar initUi() {
        JMenuBar menuBar = new JMenuBar();

        JMenuItem stocksMenu = new JMenuItem("Stonks");
        JMenuItem portfolioMenu = new JMenuItem("Portfolio");

        stocksMenu.setName("Stonks");
        portfolioMenu.setName("Portfolio");

        this.add(stocksMenu.getName(), stocksMenu);
        this.add(portfolioMenu.getName(), portfolioMenu);

        menuBar.add(stocksMenu);
        menuBar.add(portfolioMenu);

        return menuBar;
    }
    


}
