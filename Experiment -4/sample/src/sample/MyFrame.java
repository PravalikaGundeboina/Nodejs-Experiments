package sample;

import java.awt.*;
import java.awt.event.*;

public class MyFrame extends Frame implements ActionListener {
    Label label;
    Button button;

    // Constructor
    MyFrame() {
        setTitle("AWT Example");
        setSize(300, 200);
        setLayout(new FlowLayout());

        // Create UI controls
        label = new Label("Hello");
        button = new Button("Submit");

        // Add components to Frame
        add(label);
        add(button);

        // Register event listener
        button.addActionListener(this);

        setVisible(true);
    }

    // Override the required method for ActionListener
    public void actionPerformed(ActionEvent e) {
        label.setText("Button Clicked!");
    }

    // Main method
    public static void main(String[] args) {
        new MyFrame();
    }
}

