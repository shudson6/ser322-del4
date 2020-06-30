package team3.del4.gui;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

public class App extends JFrame {
    public void createAndShowGUI() {

    }

    public static void main(String[] args) {
        Properties dbProps = new Properties();
        try {
            dbProps.load(App.class.getClassLoader().getResourceAsStream("resources/db.properties"));
        } catch (Exception e) {
            String message = "FATAL: Failed to load db.properties; can't connect to database.";
            e.printStackTrace(System.err);
            SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, message, "Error",
                    JOptionPane.ERROR_MESSAGE));
            return;
        }

        SwingUtilities.invokeLater(() -> new App().createAndShowGUI());
    }
}
