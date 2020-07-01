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

/**
 *
 * @author Socce
 */
public class Rec_Stats_Ins {

    /**
     * @param args the command line arguments
     */
    private String name = "";
    private int att = 0;
    private int yd = 0;
    private int td = 0;

    public Rec_Stats_Ins() {
        run();
    }

    public void run() {

        JFrame mFrame = new JFrame("Rushing_Stats");
        // TODO code application logic here
        mFrame.setVisible(true);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mpan = new JPanel();

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 4, 5, 5));
        mFrame.setTitle("REC_STATS");
        JLabel l1 = new JLabel("Player");
        JLabel l2 = new JLabel("Rec_Atts");
        JLabel l3 = new JLabel("Rec_Yds");
        JLabel l4 = new JLabel("Rec_Tds");
        JTextField pname = new JTextField(10);
        // String name = "";

        JTextField atts = new JTextField(10);
        //String rusha = "";
        JTextField yds = new JTextField(10);
        //String rushy = "";
        JTextField tds = new JTextField(10);
        //String rusht = "";
        center.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        center.add(l1);
        center.add(l2);
        center.add(l3);
        center.add(l4);
        center.add(pname);
        center.add(atts);
        center.add(yds);
        center.add(tds);
        mpan.add(center, BorderLayout.CENTER);
        JButton insert = new JButton("Insert");
        insert.addActionListener(e -> {
            name = pname.getText();
            try {
                att = Integer.parseInt(atts.getText());
                yd = Integer.parseInt(yds.getText());
                td = Integer.parseInt(tds.getText());
                createStat(name, att, yd, td);
            } catch (NumberFormatException ex) {
                System.out.println("Your supposed to enter numbers.");
            }
        });
        JButton update = new JButton("Update");
        update.addActionListener(e -> {
            name = pname.getText();
            try {
                att = Integer.parseInt(atts.getText());
                yd = Integer.parseInt(yds.getText());
                td = Integer.parseInt(tds.getText());
                createStat(name, att, yd, td);
            } catch (NumberFormatException ex) {
                System.out.println("Your supposed to enter numbers.");
            }
        });

        mpan.add(insert, BorderLayout.SOUTH);
        mpan.add(update, BorderLayout.SOUTH);

        mFrame.add(mpan);
        mFrame.setSize(500, 200);

    }

    public static void createStat(String p, int r, int ry, int rt) {
        System.out.print("This is the player : " + p + "  --receptions: " + r + " --rec yards: " + ry + " --rectds: " + rt);
        /*   PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("Insert into RECEIVING_STATISTICS(player_name, receptions, rec_yds, rec_td) values(?,?,?,?)");
            //prepared statement takes in parameters.

            stmt.setString(1, p);
            stmt.setInt(2,r);
            stmt.setInt(3, ry);
            stmt.setInt(4, rt);
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
