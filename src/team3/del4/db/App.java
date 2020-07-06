package team3.del4.gui;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

public class App {
    public void createAndShowGUI() {
        new AppFrame().setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().createAndShowGUI());
    }
}
