package team3.del4.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatGetter extends DBHandler {
    public StatGetter() {
        super();
    }

    public List<String> getPositions() {
        return getStringList("select position from position;");
    }

    public List<String> getDivisions() {
        return getStringList("select division from division;");
    }

    /**
     * Get the teams in a given division. If {@code div=null} then gets all teams.
     */
    public List<String> getTeams(String div) {
        StringBuilder sb = new StringBuilder("select team_name from team");
        if (div != null) {
            sb.append(" where division='");
            sb.append(div);
            sb.append("'");
        }
        sb.append(";");
        return getStringList(sb.toString());
    }

    private List<String> getStringList(String query) {
        try (Statement s = getStatement()) {
            ResultSet rs = s.executeQuery(query);
            ArrayList<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return List.of();
        }
    }
}
