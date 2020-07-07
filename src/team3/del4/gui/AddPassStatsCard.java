/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3.del4.gui;

import team3.del4.db.StatGetter;
import team3.del4.db.StatUpdate;
import java.awt.*;

import javax.swing.*;

public class AddPassStatsCard extends JPanel {

    public AddPassStatsCard() {
        init();
    }

    public void init() {

        JPanel mpan = this;

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 5, 5, 5));

        JLabel l1 = new JLabel("Player");
        JLabel l2 = new JLabel("Pass_Att");
        JLabel l3 = new JLabel("Pass_Comp");
        JLabel l4 = new JLabel("Pass_Yds");
        JLabel l5 = new JLabel("Pass_Tds");
        pname = new JComboBox<>(new StatGetter().getPassNames().toArray(new String[0]));
        pname.addActionListener((e) -> pname.getSelectedItem());
        JTextField atts = new JTextField(10);

        JTextField comps = new JTextField(10);

        JTextField yds = new JTextField(10);

        JTextField tds = new JTextField(10);

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
        JButton create = new JButton("Create");
        create.addActionListener(e -> {
            // name = pname.getText();
            try {
                att = Integer.parseInt(atts.getText());
                com = Integer.parseInt(comps.getText());
                yd = Integer.parseInt(yds.getText());
                td = Integer.parseInt(tds.getText());

                createStat(name, att, com, yd, td);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Failed to add player", "Invalid input for number", JOptionPane.ERROR_MESSAGE);
            }
        });
        JButton delete = new JButton("Delete");
        delete.addActionListener(e -> {
            name = (String) pname.getSelectedItem();
            if (new StatUpdate().deleteStat("PASSING_STATISTICS", name)) {
                JOptionPane.showMessageDialog(this, "Players stats deleted.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete stats", "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton update = new JButton("Update");
        update.addActionListener(e -> {
            try {
                name = (String) pname.getSelectedItem();
                att = Integer.parseInt(atts.getText());
                com = Integer.parseInt(comps.getText());
                yd = Integer.parseInt(yds.getText());
                td = Integer.parseInt(tds.getText());

                updateStat(name, att, com, yd, td);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Failed to add player", "Invalid input for number", JOptionPane.ERROR_MESSAGE);
            }
        });
        mpan.add(update, BorderLayout.SOUTH);
        mpan.add(delete, BorderLayout.SOUTH);

    }

    public void updateStat(String p, int a, int c, int y, int t) {
        System.out.print("This is the player : " + p + "  --pass attempts: " + a + "--pass comps: " + c + " --pass yards: " + y + " --passtds: " + t);
        if (new StatUpdate().updatePassStat(p, a, c, y, t)) {
            JOptionPane.showMessageDialog(this, "Players stats updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add player", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void createStat(String p, int a, int c, int y, int t) {
        System.out.print("This is the player : " + p + "  --pass attempts: " + a + "--pass comps: " + c + " --pass yards: " + y + " --passtds: " + t);
        if (new StatUpdate().createPassStat(p, a, c, y, t)) {
            JOptionPane.showMessageDialog(this, "Player stats successfully created.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add player", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
