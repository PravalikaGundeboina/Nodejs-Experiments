package sample;

import java.awt.*;

public class HelloButton {
    public static void main(String[] args) {
        // Create frame
        Frame frame = new Frame("Hello App");
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Create label and center it
        Label label = new Label("Hello", Label.CENTER);
        frame.add(label, BorderLayout.CENTER);

        // Create button and add it to bottom
        Button button = new Button("Yes");
        frame.add(button, BorderLayout.SOUTH);

        // Make frame visible
        frame.setVisible(true);

        // Close window properly
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
