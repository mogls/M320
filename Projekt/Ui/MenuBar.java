package Ui;


import Interfaces.Renderable;

import javax.swing.*;

public class MenuBar extends UiInteractiveItem<JMenuItem> implements Renderable<JMenuBar> {

    private final JMenuBar menuBar;

    // TODO? makes logic and ui a bit tightly coupled, might refactor, but it works for now
    public MenuBar() {
        this.menuBar = new JMenuBar();
        
        JMenu stonksMenu = new JMenu("Stonks");

        JMenuItem marketMenu = new JMenuItem("Market");
        JMenuItem portfolioMenu = new JMenuItem("Portfolio");

        marketMenu.setName("Market");
        portfolioMenu.setName("Portfolio");

        this.add(marketMenu.getName(), marketMenu);
        this.add(portfolioMenu.getName(), portfolioMenu);

        stonksMenu.add(marketMenu);
        stonksMenu.add(portfolioMenu);

        this.menuBar.add(stonksMenu);


    }


    /**
     * @return The item to be rendered
     */
    @Override
    public JMenuBar render() {
        return this.menuBar;
    }
}
