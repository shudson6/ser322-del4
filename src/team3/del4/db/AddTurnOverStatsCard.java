/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group3_del4;

/**
 *
 * @author Socce
 */
import db.StatGetter;
import java.awt.*;
import db.StatUpdate;
import javax.swing.*;

public class AddTurnOverStatsCard extends JPanel {

    private String name;
    private int fum;
    private int inter;
    private JComboBox<String> pname;

    public AddTurnOverStatsCard() {
        run();
    }

    public void run() {

        JPanel mpan = this;

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 3, 5, 5));
        JLabel l1 = new JLabel("Player");
        JLabel l2 = new JLabel("Fumbles");
        JLabel l3 = new JLabel("Interceptions");
        //JTextField pname = new JTextField(10);
        //JComboBox<String>
        pname = new JComboBox<>(new StatGetter().getTONames().toArray(new String[0]));

        pname.addActionListener((e) -> pname.getSelectedItem());
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
        JButton create = new JButton("Create");
        create.addActionListener(e -> {
            //name = pname.getText();
            try {
                fum = Integer.parseInt(atts.getText());
                inter = Integer.parseInt(comps.getText());

                createStat(name, fum, inter);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Failed to add player", "Invalid input for number", JOptionPane.ERROR_MESSAGE);
            }
        });
        JButton update = new JButton("Update");
        update.addActionListener(e -> {

            try {
                name = (String) pname.getSelectedItem();
                fum = Integer.parseInt(atts.getText());
                inter = Integer.parseInt(comps.getText());

                updateStat(name, fum, inter);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Failed to add player", "Invalid input for number", JOptionPane.ERROR_MESSAGE);
            }
        });
        JButton delete = new JButton("Delete");
        delete.addActionListener(e -> {
            name = (String) pname.getSelectedItem();
            if (new StatUpdate().deleteStat("TURNOVER_STATISTICS", name)) {
                JOptionPane.showMessageDialog(this, "Players stats deleted.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete stats", "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        mpan.add(update, BorderLayout.SOUTH);
        mpan.add(delete, BorderLayout.SOUTH);

    }

    public void createStat(String p, int f, int i) {

        if (new StatUpdate().createTOStat(p, f, i)) {
            JOptionPane.showMessageDialog(this, "Player stats successfully created");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add player", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateStat(String p, int f, int i) {
        if (new StatUpdate().updateTOStat(p, f, i)) {
            JOptionPane.showMessageDialog(this, "Players stats updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add player", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
