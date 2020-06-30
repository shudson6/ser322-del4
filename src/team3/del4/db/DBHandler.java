package team3.del4.db;

import team3.del4.gui.App;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBHandler {
    static final Properties dbProps = new Properties();

    static {
        // load connection info
        try {
            dbProps.load(DBHandler.class.getClassLoader().getResourceAsStream("resources/db.properties"));
        } catch (Exception ex) {
            String message = "FATAL: Failed to load db.properties; can't connect to database.";
            ex.printStackTrace(System.err);
            SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, message, "Error",
                    JOptionPane.ERROR_MESSAGE));
        }

        // load driver
        try {
            if (dbProps.contains("driverClass")) {
                Class.forName(dbProps.getProperty("driverClass"));
            }
        } catch (ClassNotFoundException ex) {
            String message = "FATAL: Could not load driver class: " + dbProps.getProperty("driverClass");
            ex.printStackTrace(System.err);
        }
    }

    // prevent direct instantiation of this class
    protected DBHandler() {}

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbProps.getProperty("dbUrl"), dbProps);
    }

    public Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }
}
