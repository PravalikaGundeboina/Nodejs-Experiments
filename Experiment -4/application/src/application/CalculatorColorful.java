package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorColorful extends JFrame implements ActionListener {

    private JTextField display;
    private double num1 = 0, num2 = 0;
    private String operator = "";

    public CalculatorColorful() {

        setTitle("Colorful Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display box
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(new Color(230, 250, 255));
        display.setForeground(Color.BLACK);
        add(display, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 8, 8));
        panel.setBackground(new Color(200, 230, 255));

        String buttons[] = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+",
        };

        for (String txt : buttons) {
            JButton btn = new JButton(txt);
            btn.setFont(new Font("Arial", Font.BOLD, 22));
            btn.setFocusPainted(false);

            // Colors for number buttons
            if (txt.matches("[0-9]"))
                btn.setBackground(new Color(255, 240, 200));
            else if (txt.equals("C"))
                btn.setBackground(new Color(255, 140, 140));
            else if (txt.equals("="))
                btn.setBackground(new Color(150, 255, 150));
            else
                btn.setBackground(new Color(180, 210, 255));

            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            display.setText(display.getText() + cmd);
        } else if (cmd.equals("C")) {
            display.setText("");
            num1 = num2 = 0;
            operator = "";
        } else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case "+": display.setText(String.valueOf(num1 + num2)); break;
                case "-": display.setText(String.valueOf(num1 - num2)); break;
                case "*": display.setText(String.valueOf(num1 * num2)); break;
                case "/":
                    if (num2 != 0)
                        display.setText(String.valueOf(num1 / num2));
                    else
                        display.setText("Error");
                    break;
            }
            operator = "";
        } else {
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = cmd;
                display.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorColorful());
    }
}
