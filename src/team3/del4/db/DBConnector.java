package team3.del4.db;

import javax.swing.*;
import java.sql.*;
import java.util.Properties;

public class DBConnector {
    static Properties dbProps = null;

    private static void loadPropsFromResource() {
        dbProps = new Properties();
        // load connection info
        try {
            dbProps.load(DBConnector.class.getClassLoader().getResourceAsStream("resources/db.properties"));
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

    public static void setConnectionProperties(Properties dbp) {
        dbProps = dbp;
    }

    // prevent direct instantiation of this class
    protected DBConnector() {}

    public Connection getConnection() throws SQLException {
        if (dbProps == null) {
            loadPropsFromResource();
        }
        return DriverManager.getConnection(dbProps.getProperty("dbUrl"), dbProps);
    }
}
