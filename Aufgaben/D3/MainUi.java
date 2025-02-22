import javax.swing.*;
import java.awt.*;


class MainUi {
    public static void main(String[] args) {
        //Create the Frame
        JFrame jframe = new JFrame("HoneyDos");

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jframe.setSize(600, 400);

//     create two menuBar buttons FILE and HELP
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("FILE");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

//      create two more options in FILE button

        JMenuItem fileMenu1 = new JMenuItem("new file");
        JMenuItem fileMenu2 = new JMenuItem("Save as");

        fileMenu.add(fileMenu1);
        fileMenu.add(fileMenu2);

        // Text Area at the Center

        JTextArea textArea = new JTextArea();

        textArea.append("AaaaaAAaAaaaaaaaaaaaAAAAaaAAAaaaAaAAaaAaaaaAAAAAaaAAaaaaaaaAAaaaAAaaAAAaaaAAaaaaAAaa");

        //Create the panel at bottom and add label, textArea and buttons
        JPanel panel = getPanel();

        //Adding Components to the frame.
        jframe.getContentPane().add(BorderLayout.SOUTH, panel);
        jframe.getContentPane().add(BorderLayout.NORTH, menuBar);
        jframe.getContentPane().add(BorderLayout.CENTER, textArea);
        jframe.setVisible(true);

    }

    private static JPanel getPanel() {
        JPanel panel = new JPanel(); // this panel is not visible in output

        JLabel label = new JLabel("Please Enter Text");
        JTextField textField = new JTextField(50); // accepts up to 50 characters
        JButton btn_send = new JButton("Search");
        JButton btn_reset = new JButton("Clear");

        panel.add(label); // Components Added using Flow Layout
        panel.add(textField);
        panel.add(btn_send);
        panel.add(btn_reset);
        return panel;
    }
}