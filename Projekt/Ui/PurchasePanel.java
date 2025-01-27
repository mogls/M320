package Ui;

import Interfaces.Renderable;

import javax.swing.*;


public class PurchasePanel extends UiInteractiveItem<JButton> implements Renderable<JPanel> {

    private final JPanel panel;

    public PurchasePanel() {
        this.panel = new JPanel();
        JLabel label = new JLabel("Amount to purchase: ");
        JTextField textField = new JTextField(10); // accepts up to 10 characters
        JButton btn_purchase = new JButton("Purchase");
        JButton btn_cancel = new JButton("Cancel");

        btn_purchase.addActionListener(e -> {
            textField.setText("");
            // System.out.print(e.toString());
        });

        btn_cancel.addActionListener(e -> textField.setText(""));

        btn_purchase.setName(btn_purchase.getText());
        btn_cancel.setName(btn_cancel.getText());
        textField.setName("Amount input");


        this.add(btn_purchase.getName(), btn_purchase);
        this.add(btn_cancel.getName(), btn_cancel);
        // if i need to access this, i can mayb just add a special method or a hidden button
//        this.add(textField.getName(), textField);

        this.panel.add(label);
        this.panel.add(textField);
        this.panel.add(btn_purchase);
        this.panel.add(btn_cancel);

    }

    /**
     * @return The item to be rendered
     */
    @Override
    public JPanel render() {
        return this.panel;
    }
}
