package team3.del4.gui;

import team3.del4.db.DBConnector;

import javax.swing.SwingUtilities;
import java.util.Properties;

public class App {
    public void createAndShowGUI() {
        new AppFrame().setVisible(true);
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                Properties props = new Properties();
                props.put("driverClass", args[0]);
                props.put("dbUrl", args[1]);
                props.put("user", args[2]);
                if (args.length > 3) {
                    props.put("password", args[3]);
                }
                DBConnector.setConnectionProperties(props);
            } catch (Exception ex) {
                System.out.println("Expected usage: java team3.del4.gui.App [<driver> <url> <user> [password]]");
            }
        }
        SwingUtilities.invokeLater(() -> new App().createAndShowGUI());
    }
}
