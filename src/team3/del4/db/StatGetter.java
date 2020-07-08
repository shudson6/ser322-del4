/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3.del4.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatGetter extends DBConnector {

    public StatGetter() {
        super();
    }

    public List<String> getAllPlayers() {
        return getStringList("select name from player");
    }

    public List<String> getPlayersWithPos(String position){
        return getStringList("select name from player where " + "'" + position + "' = position;");
    }

    public List<String> getPassNames() {
        return getStringList("select player_name from passing_statistics");
    }

    public List<String> getRushNames() {
        return getStringList("select player_name from rushing_statistics");
    }

    public List<String> getRecNames() {
        return getStringList("select player_name from receiving_statistics");
    }

    public List<String> getKickNames() {
        return getStringList("select player_name from kicking_statistics");
    }

    public List<String> getTONames() {
        return getStringList("select player_name from turnover_statistics");
    }

    public List<String> getPositions() {
        return getStringList("select position from position;");
    }

    public List<String> getDivisions() {
        return getStringList("select division from division;");
    }

    public List<String> getAllTeams() {
        return getStringList("select team_name from team;");
    }

    public List<String> getAllPlayersInTeam(String team) {
        StringBuilder sb = new StringBuilder("select name from player");
        if (team != null) {
            sb.append(" where team='");
            sb.append(team);
            sb.append("'");
        }
        sb.append(";");
        return getStringList(sb.toString());
    }

    /**
     * Get the teams in a given division. If {@code div==null} then gets all
     * teams.
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
     * Get the names of players on the given team. if {@code team==null} then
     * gets all player names.
     */
    public List<String> getPlayers(String pos, String team) {
        StringBuilder sb = new StringBuilder("select name, position, team from player");
        if (team != null && pos == null) {
            sb.append(" where team='");
            sb.append(team);
            sb.append("'");
        } else if (team == null && pos != null) {
            sb.append(" where position='");
            sb.append(pos);
            sb.append("'");
        } else if (team != null && pos != null) {
            sb.append(" where team='");
            sb.append(team);
            sb.append("'");
            sb.append(" and position='");
            sb.append(pos);
            sb.append("'");
        }
        sb.append(";");
        return getStringList(sb.toString());
    }

    public List<String> getPlayersView(String pos, String team) {
        StringBuilder sb = new StringBuilder("select name, position, team from player");
        if (team != null && pos == null) {
            sb.append(" where team='");
            sb.append(team);
            sb.append("'");
        } else if (team == null && pos != null) {
            sb.append(" where position='");
            sb.append(pos);
            sb.append("'");
        } else if (team != null && pos != null) {
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
        try (Connection c = getConnection()) {
            Statement s = c.createStatement();
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

    private List<String> getStringListPlayers(String query) {
        try (Connection c = getConnection()) {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);
            ArrayList<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    private List<String> getStringListPassing(String query) {
        try (Connection c = getConnection()) {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);
            ArrayList<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
                list.add(rs.getString(5));
                list.add(rs.getString(6));
                list.add(rs.getString(7));
                list.add(rs.getString(8));
                list.add(rs.getString(9));
                list.add(rs.getString(10));
                list.add(rs.getString(11));
                list.add(rs.getString(12));
                list.add(rs.getString(13));
                list.add(rs.getString(14));
                list.add(rs.getString(15));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return List.of();
        }
    }

    private List<String> getStringListRushing(String query) {
        try (Connection c = getConnection()) {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);
            ArrayList<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
                list.add(rs.getString(5));
                list.add(rs.getString(6));
                list.add(rs.getString(7));
                list.add(rs.getString(8));
                list.add(rs.getString(9));
                list.add(rs.getString(10));
                list.add(rs.getString(11));
                list.add(rs.getString(12));
                list.add(rs.getString(13));
                list.add(rs.getString(14));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return List.of();
        }
    }

    private List<String> getStringListReceiving(String query) {
        try (Connection c = getConnection()) {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);
            ArrayList<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
                list.add(rs.getString(5));
                list.add(rs.getString(6));
                list.add(rs.getString(7));
                list.add(rs.getString(8));
                list.add(rs.getString(9));
                list.add(rs.getString(10));
                list.add(rs.getString(11));
                list.add(rs.getString(12));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return List.of();
        }
    }

    private List<String> getStringListKicking(String query) {
        try (Connection c = getConnection()) {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);
            ArrayList<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
                list.add(rs.getString(5));
                list.add(rs.getString(6));
                list.add(rs.getString(7));
                list.add(rs.getString(8));
                list.add(rs.getString(9));
                list.add(rs.getString(10));
                list.add(rs.getString(11));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return List.of();
        }
    }

    private List<String> getStringListTeam(String query){
        try (Connection c = getConnection()) {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);
            ArrayList<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
                list.add(rs.getString(5));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return List.of();
        }
    }

    public List<String> getPassingStats(String name) {
        return getStringListPassing("SELECT name, Position, team, dob, height, weight, experience, games_played, jersey_num, pass_att, pass_comp, pass_yds, pass_td, fumbles, interceptions FROM PLAYER, PASSING_STATISTICS as s, Turnover_statistics as t " +
                "where '" + name + "' = name and '" + name + "' = s.player_name and '" + name + "' = t.player_name;");
    }

    public List<String> getRushingStats(String name) {
        return getStringListRushing("SELECT name, Position, team, dob, height, weight, experience, games_played, jersey_num, rush_att, rush_yds, rush_td, fumbles, interceptions FROM PLAYER, Rushing_STATISTICS as s, Turnover_statistics as t " +
                "where '" + name + "' = name and '" + name + "' = s.player_name and '" + name + "' = t.player_name;");
    }

    public List<String> getReceivingStats(String name) {
        return getStringListReceiving("SELECT name, Position, team, dob, height, weight, experience, games_played, jersey_num, receptions, rec_yds, rec_td FROM PLAYER, Receiving_STATISTICS as s " +
                "where '" + name + "' = name and '" + name + "' = s.player_name;");
    }

    public List<String> getKickingStats(String name) {
        return getStringListKicking("SELECT name, Position, team, dob, height, weight, experience, games_played, jersey_num, fg_att, field_goals FROM PLAYER, Kicking_STATISTICS as s " +
                "where '" + name + "' = name and '" + name + "' = s.player_name;");
    }

    public List<String> getTeamStats(String name){
        return getStringListTeam("SELECT * from team where team_name = '" + name + "';");
    }
}
