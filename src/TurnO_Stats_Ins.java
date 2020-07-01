/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inset_Update;

import java.awt.*;

import javax.swing.*;

public class TurnO_Stats_Ins {

    /**
     * @param args the command line arguments
     */
    private String name = "";
    private int fum;
    private int inter;

    public TurnO_Stats_Ins() {
        run();
    }

    public void run() {

        JFrame mFrame = new JFrame("TurnOver_Stats");
        // TODO code application logic here
        mFrame.setVisible(true);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mpan = new JPanel();

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 3, 5, 5));
        mFrame.setTitle("TURNOVER_STATS");
        JLabel l1 = new JLabel("Player");
        JLabel l2 = new JLabel("Fumbles");
        JLabel l3 = new JLabel("Interceptions");
        JTextField pname = new JTextField(10);
        JTextField atts = new JTextField(10);
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
                fum = Integer.parseInt(atts.getText());
                inter = Integer.parseInt(comps.getText());

                createStat(name, fum, inter);
            } catch (NumberFormatException ex) {
                System.out.println("Your supposed to enter numbers.");
            }
        });
        JButton update = new JButton("Update");
        update.addActionListener(e -> {
            name = pname.getText();
            try {
                fum = Integer.parseInt(atts.getText());
                inter = Integer.parseInt(comps.getText());

                updateStat(name, fum, inter);
            } catch (NumberFormatException ex) {
                System.out.println("Your supposed to enter numbers.");
            }
        });
        mpan.add(insert, BorderLayout.SOUTH);
        mpan.add(update, BorderLayout.SOUTH);
        mFrame.add(mpan);
        mFrame.setSize(400, 200);

    }

    public static void createStat(String p, int f, int i) {
        System.out.print("This is the player : " + p + "  --fumbles : " + f + "-- interceptions: " + i);
        /*   PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("Insert into TURNOVER_STATISTICS(player_name, fumbles, interceptions) values(?,?,?)");
            //prepared statement takes in parameters.

            stmt.setString(1, p);
            stmt.setInt(2, f);
            stmt.setInt(3, i);
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

    public void updateStat(String p, int f, int i) {
        System.out.print("This is the player : " + p + "  --fumbles: " + f + "--interceptions: " + i);
        /*   PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("Insert into TURNOVER_STATISTICS(player_name, fumbles, interceptions) values(?,?,?)");
            //prepared statement takes in parameters.

            stmt.setString(1, p);
            stmt.setInt(2, f);
            stmt.setInt(3, i);
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
