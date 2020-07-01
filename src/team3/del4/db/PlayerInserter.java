package team3.del4.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerInserter extends DBConnector {
    public boolean insertPlayer(String name, String pos, String team, String dob,
                                int ht, int wt, int exp, int games, int num) {
        // assuming all parameters are valid...

        // try-with-resources
        // by declaring the Statement in parentheses here, Java will make sure it gets closed no matter what happens
        try (PreparedStatement stmt = prepareStatement("Insert into PLAYER(name, position, team, dob, height, weight, experience, games_played, jersey_num) values(?,?,?,?,?,?,?,?,?)")) {
            stmt.setString(1, name);
            stmt.setString(2, pos);
            stmt.setString(3, team);
            stmt.setString(4, dob);
            stmt.setInt(5, ht);
            stmt.setInt(6, wt);
            stmt.setInt(7, exp);
            stmt.setInt(8, games);
            stmt.setInt(9, num);

            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
