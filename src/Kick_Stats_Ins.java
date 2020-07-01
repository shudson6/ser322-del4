/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inset_Update;

/**
 *
 * @author Socce
 */
import java.awt.*;

import javax.swing.*;

public class Kick_Stats_Ins {

    /**
     * @param args the command line arguments
     */
    private String name = "";
    private int att = 0;
    private int com = 0;

    public Kick_Stats_Ins() {
        run();
    }

    public void run() {

        JFrame mFrame = new JFrame("Kicking_Stats");
        // TODO code application logic here
        mFrame.setVisible(true);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mpan = new JPanel();

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 3, 5, 5));
        mFrame.setTitle("KICK_STATS");
        JLabel l1 = new JLabel("Player");
        JLabel l2 = new JLabel("FG_Att");
        JLabel l3 = new JLabel("Field_Goals");
        JTextField pname = new JTextField(10);
        // String name = "";

        JTextField atts = new JTextField(10);
        //String rusha = "";
        JTextField comps = new JTextField(10);
        center.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        center.add(l1);
        center.add(l2);
        center.add(l3);

        center.add(pname);
        center.add(atts);
        center.add(comps);

        mpan.add(center, BorderLayout.CENTER);
        JButton insert = new JButton("Insert");
        insert.addActionListener(e -> {
            name = pname.getText();
            try {
                att = Integer.parseInt(atts.getText());
                com = Integer.parseInt(comps.getText());

                createStat(name, att, com);
            } catch (NumberFormatException ex) {
                System.out.println("Your supposed to enter numbers.");
            }
        });
        JButton update = new JButton("Update");
        update.addActionListener(e -> {
            name = pname.getText();
            try {
                att = Integer.parseInt(atts.getText());
                com = Integer.parseInt(comps.getText());

                updateStat(name, att, com);
            } catch (NumberFormatException ex) {
                System.out.println("Your supposed to enter numbers.");
            }
        });
        mpan.add(insert, BorderLayout.SOUTH);
        mpan.add(update, BorderLayout.SOUTH);
        mFrame.add(mpan);
        mFrame.setSize(400, 200);

    }

    public static void createStat(String p, int a, int c) {
        System.out.print("This is the player : " + p + "  --kick attempts: " + a + "--kick comps: " + c);
        /*   PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("Insert into KICKING_STATISTICS(player_name, fg_att, field_goals) values(?,?,?)");
            //prepared statement takes in parameters.

            stmt.setString(1, p);
            stmt.setInt(2, a);
            stmt.setInt(3, c);
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

    public static void updateStat(String p, int a, int c) {
        System.out.print("This is the player : " + p + "  --kick attempts: " + a + "--kick comps: " + c);
        /*   PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("Insert into KICKING_STATISTICS(player_name, fg_att, field_goals) values(?,?,?)");
            //prepared statement takes in parameters.

            stmt.setString(1, p);
            stmt.setInt(2, a);
            stmt.setInt(3, c);
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
