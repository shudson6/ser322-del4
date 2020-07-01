/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shit;

import java.awt.*;

import javax.swing.*;

/**
 *
 * @author Socce
 */
public class Rush_Stats {

    /**
     * @param args the command line arguments
     */
    private static String name = "";
    private static int att = 0;
    private static int yd = 0;
    private static int td = 0;

    public static void run() {

        JFrame mFrame = new JFrame("Rushing_Stats");
        // TODO code application logic here
        mFrame.setVisible(true);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mpan = new JPanel();

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 4, 5, 5));
        mFrame.setTitle("RUSH_STATS");
        JLabel l1 = new JLabel("Player");
        JLabel l2 = new JLabel("Rush_Atts");
        JLabel l3 = new JLabel("Rush_Yds");
        JLabel l4 = new JLabel("Rush_Tds");
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
        //JButton update = new JButton("Update");
        mpan.add(insert, BorderLayout.SOUTH);
        //rpan.add(update, BorderLayout.page);
        mFrame.add(mpan);
        mFrame.setSize(500, 200);

    }

    public static void createStat(String p, int ra, int ry, int rt) {
        System.out.print("This is the player : " + p + "  --rush attempts: " + ra + " --rush yards: " + ry + " --rushtds: " + rt);
        /*   PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("Insert into RUSHING_STATS(player_name, rush_att, rush_yds, rush_td) values(?,?,?,?)");
            //prepared statement takes in parameters.

            stmt.setString(1, p);
            stmt.setInt(2,ra);
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

    public static void main(String[] args) {
        run();

    }

}
