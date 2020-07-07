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
    private PlayerSelector player;
    private JTextField attTF;
    private JTextField compTF;
    private JTextField ydsTF;
    private JTextField tdsTF;
    private JButton update;
    private JButton delete;

    public AddPassStatsCard() {
        init();
    }

    public void init() {
        player = new PlayerSelector();
        attTF = new JTextField(10);
        compTF = new JTextField(10);
        ydsTF = new JTextField(10);
        tdsTF = new JTextField(10);

        update = new JButton("Update");
        update.addActionListener(e -> clickedUpdate());

        delete = new JButton("Delete");
        delete.addActionListener(e -> clickedDelete());

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        add(player, gbc);

        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 3;
        gbc.gridy = 1;
        add(new JLabel("Att"), gbc);
        gbc.gridx = 4;
        add(new JLabel("Comp"), gbc);
        gbc.gridx = 5;
        add(new JLabel("Yds"), gbc);
        gbc.gridx = 6;
        add(new JLabel("TDs"), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 2;
        add(attTF, gbc);
        gbc.gridx = 4;
        add(compTF, gbc);
        gbc.gridx = 5;
        add(ydsTF, gbc);
        gbc.gridx = 6;
        add(tdsTF, gbc);

        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 5;
        gbc.gridy = 3;
        add(update, gbc);
        gbc.gridx = 6;
        add(delete, gbc);
    }

    public void updateStat(String p, int a, int c, int y, int t) {
        System.out.print("This is the player : " + p + "  --pass attempts: " + a + "--pass comps: " + c + " --pass yards: " + y + " --passtds: " + t);
        StatUpdate sql = new StatUpdate();
        if (sql.updatePassStat(p, a, c, y, t) || sql.createPassStat(p, a, c, y, t)) {
            JOptionPane.showMessageDialog(this, "Players stats updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Could not insert nor update stats.", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clickedUpdate() {
        try {
            String name = player.getSelectedPlayer();
            int att = Integer.parseInt(attTF.getText());
            int com = Integer.parseInt(compTF.getText());
            int yd = Integer.parseInt(ydsTF.getText());
            int td = Integer.parseInt(tdsTF.getText());

            updateStat(name, att, com, yd, td);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Failed to add player", "Invalid input for number", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clickedDelete() {
        String name = player.getSelectedPlayer();
        if (new StatUpdate().deleteStat("PASSING_STATISTICS", name)) {
            JOptionPane.showMessageDialog(this, "Players stats deleted.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete stats", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
