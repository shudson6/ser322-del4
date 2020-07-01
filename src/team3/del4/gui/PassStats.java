/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shit;

/**
 *
 * @author Socce
 */
import java.awt.*;

import javax.swing.*;

public class PassStats {

    /**
     * @param args the command line arguments
     */
    private static String name = "";
    private static int att = 0;
    private static int com = 0;
    private static int yd = 0;
    private static int td = 0;

    public static void run() {

        JFrame mFrame = new JFrame("Rushing_Stats");
        // TODO code application logic here
        mFrame.setVisible(true);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mpan = new JPanel();

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 5, 5, 5));
        mFrame.setTitle("PASS_STATS");
        JLabel l1 = new JLabel("Player");
        JLabel l2 = new JLabel("Pass_Att");
        JLabel l3 = new JLabel("Pass_Comp");
        JLabel l4 = new JLabel("Pass_Yds");
        JLabel l5 = new JLabel("Pass_Tds");
        JTextField pname = new JTextField(10);
        // String name = "";

        JTextField atts = new JTextField(10);
        //String rusha = "";
        JTextField comps = new JTextField(10);
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
        center.add(l5);
        center.add(pname);
        center.add(atts);
        center.add(comps);
        center.add(yds);
        center.add(tds);
        mpan.add(center, BorderLayout.CENTER);
        JButton insert = new JButton("Insert");
        insert.addActionListener(e -> {
            name = pname.getText();
            try {
                att = Integer.parseInt(atts.getText());
                com = Integer.parseInt(comps.getText());
                yd = Integer.parseInt(yds.getText());
                td = Integer.parseInt(tds.getText());

                createStat(name, att, com, yd, td);
            } catch (NumberFormatException ex) {
                System.out.println("Your supposed to enter numbers.");
            }
        });
        //JButton update = new JButton("Update");
        mpan.add(insert, BorderLayout.SOUTH);
        //rpan.add(update, BorderLayout.page);
        mFrame.add(mpan);
        mFrame.setSize(650, 200);

    }

    public static void createStat(String p, int a, int c, int y, int t) {
        System.out.print("This is the player : " + p + "  --pass attempts: " + a + "--pass comps: " + c + " --pass yards: " + y + " --passtds: " + t);
        /*   PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("Insert into PASSING_STATISTICS(player_name, pass_att, pass_comp, pass_yds, pass_td) values(?,?,?,?,?)");
            //prepared statement takes in parameters.

            stmt.setString(1, p);
            stmt.setInt(2, a);
            stmt.setInt(3, c);
            stmt.setInt(4, y);
            stmt.setInt(4, t);
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
