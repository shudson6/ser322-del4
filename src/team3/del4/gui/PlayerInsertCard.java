/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3.del4.gui;

/**
 *
 * @author Socce
 */
import team3.del4.db.PlayerInserter;
import team3.del4.db.StatGetter;

import java.awt.*;

import javax.swing.*;

public class PlayerInsertCard extends JPanel {

    private String name = "";
    //private static   = 0;
    //private static = 0;

    // we can get these direct from the db with a StatGetter
//    private String[] pos = {"QB", "RB", "WR", "TE", "K"};
//    private String[] teams = {"49ers", "Bears", "Bengals", "Bills", "Broncos", "Browns", "Bucks", "Cardinals", "Chargers"
//        + "Chiefs", "Colts", "Cowboys", "Dolphins", "Eagles", "Falcons", "Giants", "Jaguars", "Jets", "Lions", "Packers", "Panthers"
//        + "Patriots", "Raiders", "Rams", "Ravens", "Redskins", "Saints", "Seahawks", "Steelers", "Texans", "Titans", "Vikings"};

//Create the combo box, select item at index 4.
//Indices start at 0, so 4 specifies the QB.
    //private static int year;
    //private int dob;
    private String dob;
    private int height;
    private int weight;
    private int experience;
    private int games = 0;
    private int jnum;

    public PlayerInsertCard() {
        run();
    }

    public void run() {

        JPanel mpan = this;

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 3, 5, 5));
        JLabel l1 = new JLabel("Name");
        JLabel l2 = new JLabel("Position");
        JLabel l3 = new JLabel("Team");

        JLabel l4 = new JLabel("DOB");
        JLabel l5 = new JLabel("Height");
        JLabel l6 = new JLabel("Weight");

        JLabel l7 = new JLabel("Experience");
        JLabel l8 = new JLabel("Games_Played");
        JLabel l9 = new JLabel("Jersey_Num");
        JTextField pname = new JTextField(10);
        // String name = "";

        JComboBox<String> pbox = new JComboBox<>(new StatGetter().getPositions().toArray(new String[0]));
        JComboBox<String> tbox = new JComboBox<>(new StatGetter().getTeams(null).toArray(new String[0]));
        //String rusha = "";
        //String[] dobex = {"YYYY-MM-DD"};
        //JComboBox dobox = new JComboBox(dobex);
        // dobox.setEditable(true);
        //dobox.addActionListener(e-> String n = dobox.);
        JTextField dobox = new JTextField(5);

        JTextField ht = new JTextField(5);

        JTextField wt = new JTextField(5);

        JTextField exp = new JTextField(5);

        JTextField gP = new JTextField(5);

        JTextField jN = new JTextField(5);
        center.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        center.add(l1);
        center.add(l2);
        center.add(l3);
        ///name, pos, team
        center.add(pname);
        center.add(pbox);
        center.add(tbox);
        center.add(l4);
        center.add(l5);
        center.add(l6);

        center.add(dobox);
        center.add(ht);
        center.add(wt);
        center.add(l7);
        center.add(l8);
        center.add(l9);

        center.add(exp);
        center.add(gP);
        center.add(jN);
        mpan.add(center, BorderLayout.CENTER);
        JButton insert = new JButton("Insert");
        insert.addActionListener(e -> {
            try {
                name = pname.getText();
                String p = (String) pbox.getSelectedItem();
                String t = (String) tbox.getSelectedItem();
                // String d = (String) dbox.getSource();
                //dob = Integer.parseInt(dobox.getText());
                dob = dobox.getText();
                height = ht.getText();
                weight = Integer.parseInt(wt.getText());
                experience = Integer.parseInt(exp.getText());
                games = Integer.parseInt(gP.getText());
                jnum = Integer.parseInt(jN.getText());
                createPlayer(name, p, t, dob, height, weight, experience, games, jnum);

            } catch (NumberFormatException ex) {
                System.out.println("Your supposed to enter numbers.");
            }
        });
        JButton update = new JButton("Update");
        update.addActionListener(e -> {
            name = pname.getText();
            try {

            } catch (NumberFormatException ex) {
                System.out.println("Your supposed to enter numbers.");
            }
        });
        mpan.add(insert, BorderLayout.SOUTH);
        mpan.add(update, BorderLayout.SOUTH);
    }

    public void createPlayer(String p, String pos, String t, String d, String h, int w, int e, int g, int j) {
        System.out.print("This is the new player : " + p + " -Pos: " + pos
                + "--team: " + t + " --ht: " + h + " --wt: " + w + " -experience: " + e
                + " -games_played" + g + " -Jersey_num: " + j);
        if (new PlayerInserter().insertPlayer(p, pos, t, d, h, w, e, g, j)) {
            JOptionPane.showMessageDialog(this, "Player added successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add player", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
        /*   PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("Insert into PLAYER(name, position, team, dob, height, experience, games_played, jersey_num) values(?,?,?,?,?,?,?,?,?)");
            //prepared statement takes in parameters.

            stmt.setString(1, p);
            stmt.setString(2, pos);
            stmt.setString(3, t);
            stmt.setString(4, d);
            stmt.setString(5, h);
            stmt.setInt(6, w);
            stmt.setInt(7, e);
            stmt.setInt(8, g);
            stmt.setInt(9, j);

            if (stmt.executeUpdate() > 0) {
                System.out.println("SUCCESSFUL");
          }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //ALWAYS close your connection items.
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println("Connection not closed correctly. You have a memory leak!");
            }
        }
         */

    }
}
