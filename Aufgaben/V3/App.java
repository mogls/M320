
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App {


    public static void run(String name) {


        //Create the Frame
        JFrame jframe = new JFrame(name);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400, 400);

        //create two menubar buttons FILE and HELP
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Stonks");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        //create two more option in FILE button
        JMenuItem fileOption1 = new JMenuItem("new stonks");
        JMenuItem fileOption2 = new JMenuItem("Search");
        fileMenu.add(fileOption1);
        fileMenu.add(fileOption2);

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

        fileOption2.addActionListener(e -> panel.setVisible(true));


        panel.add(label); // Components Added using Flow Layout
        panel.add(textField);
        panel.add(btn_send);
        panel.add(btn_reset);
        panel.add(btn_hide);

        //Adding Components to the frame.
        jframe.getContentPane().add(BorderLayout.SOUTH, panel);
        jframe.getContentPane().add(BorderLayout.NORTH, menuBar);
        jframe.getContentPane().add(BorderLayout.CENTER, textArea);
        jframe.setVisible(true);
    }
}
