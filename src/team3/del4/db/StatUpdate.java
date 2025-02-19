/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3.del4.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Socce
 */
public class StatUpdate extends DBConnector {

    public boolean updatePlayerBio(String name, String pos, String team, String dob,
            String ht, int wt, int exp, int games, int num) {
        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE PLAYER Set position =(?), team = (?), dob=(?), height=(?), weight=(?), experience=(?), games_played=(?), jersey_num=(?) Where name =(?)");
            stmt.setString(1, pos);
            stmt.setString(2, team);
            stmt.setString(3, dob);
            stmt.setString(4, ht);
            stmt.setInt(5, wt);
            stmt.setInt(6, exp);
            stmt.setInt(7, games);
            stmt.setInt(8, num);
            stmt.setString(9, name);

            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean insertPlayer(String name, String pos, String team, String dob,
            String ht, int wt, int exp, int games, int num) {
        // assuming all parameters are valid...

        // try-with-resources
        // by declaring the Statement in parentheses here, Java will make sure it gets closed no matter what happens
        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("Insert into PLAYER(name, position, team, dob, height, weight, experience, games_played, jersey_num) values(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, pos);
            stmt.setString(3, team);
            stmt.setString(4, dob);
            stmt.setString(5, ht);
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

    public boolean deletePlayer(String name) {
        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("Delete From player Where name = '" + name + "'");

            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStat(String place, String name) {
        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("Delete From " + place + " Where player_name = '" + name + "'");

            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePassStat(String name, int atts, int com, int yrds, int td) {
        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE PASSING_STATISTICS Set pass_att = (?), pass_comp = (?), pass_yds = (?), pass_td = (?) where player_name = (?)");
            //prepared statement takes in parameters.

            stmt.setInt(1, atts);
            stmt.setInt(2, com);
            stmt.setInt(3, yrds);
            stmt.setInt(4, td);
            stmt.setString(5, name);
            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
                return true;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;

    }

    public boolean createPassStat(String name, int atts, int com, int yrds, int td) {
        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("Insert into PASSING_STATISTICS(player_name, pass_att, pass_comp, pass_yds, pass_td) values(?,?,?,?,?)");
            //prepared statement takes in parameters.
            stmt.setString(1, name);
            stmt.setInt(2, atts);
            stmt.setInt(3, com);
            stmt.setInt(4, yrds);
            stmt.setInt(5, td);
            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
                return true;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean updateRushStat(String p, int ra, int ry, int rt) {
        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE RUSHING_STATISTICS Set rush_att = (?), rush_yds = (?), rush_td = (?) where player_name = (?)");
            //prepared statement takes in parameters.

            stmt.setInt(1, ra);
            stmt.setInt(2, ry);
            stmt.setInt(3, rt);
            stmt.setString(4, p);
            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
                return true;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;

    }

    public boolean createRushStat(String name, int ra, int ry, int rt) {
        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("Insert into RUSHING_STATISTICS(player_name, rush_att, rush_yds, rush_td) values(?,?,?,?)");
            //prepared statement takes in parameters.
            stmt.setString(1, name);
            stmt.setInt(2, ra);
            stmt.setInt(3, ry);
            stmt.setInt(4, rt);
            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
                return true;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean updateRecStat(String name, int ra, int ry, int rt) {
        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE RECEIVING_STATISTICS Set receptions = (?), rec_yds = (?), rec_td = (?) where player_name = (?)");
            //prepared statement takes in parameters.

            stmt.setInt(1, ra);
            stmt.setInt(2, ry);
            stmt.setInt(3, rt);
            stmt.setString(4, name);
            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
                return true;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;

    }

    public boolean createRecStat(String name, int rec, int ry, int rt) {
        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("Insert into RECEIVING_STATISTICS(player_name, receptions, rec_yds, rec_td) values(?,?,?,?)");
            //prepared statement takes in parameters.
            stmt.setString(1, name);
            stmt.setInt(2, rec);
            stmt.setInt(3, ry);
            stmt.setInt(4, rt);
            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
                return true;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean updateKickStat(String name, int att, int fg) {
        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE KICKING_STATISTICS SET fg_att = (?), field_goals = (?) Where player_name = (?)");
            stmt.setInt(1, att);
            stmt.setInt(2, fg);
            stmt.setString(3, name);
            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean createKickStat(String name, int att, int fg) {

        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("Insert into KICKING_STATISTICS(player_name, fg_att, field_goals) values(?,?,?)");
            //prepared statement takes in parameters.

            stmt.setString(1, name);
            stmt.setInt(2, att);
            stmt.setInt(3, fg);
            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTOStat(String p, int f, int i) {

        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("Update TURNOVER_STATISTICS Set fumbles = (?), interceptions = (?) Where player_name = (?)");
            stmt.setInt(1, f);
            stmt.setInt(2, i);
            stmt.setString(3, p);
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createTOStat(String p, int f, int i) {

        try (Connection c = getConnection()) {
            PreparedStatement stmt = c.prepareStatement("Insert into TURNOVER_STATISTICS(player_name, fumbles, interceptions) values(?,?,?)");
            //prepared statement takes in parameters.

            stmt.setString(1, p);
            stmt.setInt(2, f);
            stmt.setInt(3, i);
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
