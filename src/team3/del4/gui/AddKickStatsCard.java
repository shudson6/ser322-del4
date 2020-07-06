/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3.del4.gui;

import team3.del4.db.StatUpdate;

import java.awt.*;
import javax.swing.*;

public class AddKickStatsCard extends JPanel {

    private String name = "";
    private int att = 0;
    private int com = 0;

    public AddKickStatsCard() {
        run();
    }

    public void run() {

        JPanel mpan = this;

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 3, 5, 5));
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
        JButton insert = new JButton("Create");
        insert.addActionListener(e -> {
            name = pname.getText();
            try {
                att = Integer.parseInt(atts.getText());
                com = Integer.parseInt(comps.getText());

                createStat(name, att, com);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Failed to add player", "Invalid input for number", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(this, "Failed to add player", "Invalid input for number", JOptionPane.ERROR_MESSAGE);
            }
        });
        mpan.add(insert, BorderLayout.SOUTH);
        mpan.add(update, BorderLayout.SOUTH);
    }

    public void updateStat(String p, int a, int c) {

        if (new StatUpdate().updateKickStat(p, a, c)) {
            JOptionPane.showMessageDialog(this, "Players stats updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add player", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void createStat(String p, int a, int c) {
        if (new StatUpdate().createKickStat(p, a, c)) {
            JOptionPane.showMessageDialog(this, "Player stats successfully created");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add stats", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
