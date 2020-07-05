package team3.del4.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatGetter extends DBConnector {
    public StatGetter() {
        super();
    }

    public List<String> getPositions() {
        return getStringList("select position from position;");
    }

    public List<String> getDivisions() {
        return getStringList("select division from division;");
    }

    public List<String> getAllTeams(){
        return getStringList("select team_name from team;");
    }
    /**
     * Get the teams in a given division. If {@code div==null} then gets all teams.
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

    /**
     * Get the names of players on the given team. if {@code team==null} then gets all player names.
     */
    public List<String> getPlayers(String pos, String team) {
        StringBuilder sb = new StringBuilder("select name, position, team from player");
        if (team != null && pos == null) {
            sb.append(" where team='");
            sb.append(team);
            sb.append("'");
        }
        else if (team == null && pos != null){
            sb.append(" where position='");
            sb.append(pos);
            sb.append("'");
        }
        else if (team != null && pos != null){
            sb.append(" where team='");
            sb.append(team);
            sb.append("'");
            sb.append(" and position='");
            sb.append(pos);
            sb.append("'");
        }
        sb.append(";");
        return getStringListPlayers(sb.toString());
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

    private List<String> getStringListPlayers(String query){
        try(Statement s = getStatement()){
            ResultSet rs = s.executeQuery(query);
            ArrayList<String> list = new ArrayList<>();
            while (rs.next()){
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
            }
            return list;
        } catch (SQLException e){
            e.printStackTrace();
            return List.of();
        }
    }
}
