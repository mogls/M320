
import Ui.MenuBar;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App {


    public static void run(String name) {

        //Create the Frame
        JFrame jframe = new JFrame(name);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(600, 600);


        // logic
        MenuBar menuBar = new MenuBar();
        // Ui
        JMenuBar jMenuBar = menuBar.initUi();

        // Text Area at the Center
        JTextArea textArea = new JTextArea();



        //Create the panel at bottom and add label, textArea and buttons
        JPanel panel = new JPanel(); // this panel is not visible in output
        JLabel label = new JLabel("Please Enter Text");
        JTextField textField = new JTextField(15); // accepts up to 15 characters
        JButton btn_send = new JButton("Send");
        JButton btn_reset = new JButton("Reset");
        JButton btn_hide = new JButton("Hide");

        btn_send.addActionListener(e -> {
            // Add text to the text area
            textArea.append(textField.getText()+"\n");
            textField.setText("");
            // System.out.print(e.toString());
        });

        btn_reset.addActionListener(e -> textArea.setText(""));

        btn_hide.addActionListener(e -> panel.setVisible(false));

        menuBar.get("Stonks").addActionListener(e -> panel.setVisible(true));

        panel.add(label); // Components Added using Flow Layout
        panel.add(textField);
        panel.add(btn_send);
        panel.add(btn_reset);
        panel.add(btn_hide);

        //Adding Components to the frame.
        jframe.getContentPane().add(BorderLayout.SOUTH, panel);
        jframe.getContentPane().add(BorderLayout.NORTH, jMenuBar);
        jframe.getContentPane().add(BorderLayout.CENTER, textArea);
        jframe.setVisible(true);
    }
}
