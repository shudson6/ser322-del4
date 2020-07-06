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
import team3.del4.db.StatGetter;
import java.awt.*;
import javax.swing.*;
import team3.del4.db.StatUpdate;

public class AddRecStatsCard extends JPanel {

    private String name;
    private int com;
    private int yd;
    private int td;
    private JComboBox pname;

    public AddRecStatsCard() {
        run();
    }

    public void run() {

        JPanel mpan = this;

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 4, 5, 5));
        JLabel l1 = new JLabel("Player");
        JLabel l2 = new JLabel("Rec_Atts");
        JLabel l3 = new JLabel("Rec_Yds");
        JLabel l4 = new JLabel("Rec_Tds");
        pname = new JComboBox<>(new StatGetter().getRecNames().toArray(new String[0]));
        pname.addActionListener((e) -> pname.getSelectedItem());
        JTextField comp = new JTextField(10);
        JTextField yds = new JTextField(10);
        JTextField tds = new JTextField(10);
        center.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        center.add(l1);
        center.add(l2);
        center.add(l3);
        center.add(l4);
        center.add(pname);
        center.add(comp);
        center.add(yds);
        center.add(tds);
        mpan.add(center, BorderLayout.CENTER);
        JButton delete = new JButton("Delete");
        delete.addActionListener(e -> {
            name = (String) pname.getSelectedItem();
            if (new StatUpdate().deleteStat("RECEIVING_STATISTICS", name)) {
                JOptionPane.showMessageDialog(this, "Player stat deleted.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add player", "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        JButton update = new JButton("Update");
        update.addActionListener(e -> {
            try {
                name = (String) pname.getSelectedItem();
                com = Integer.parseInt(comp.getText());
                yd = Integer.parseInt(yds.getText());
                td = Integer.parseInt(tds.getText());
                updateStat(name, com, yd, td);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Failed to add player", "Invalid input for number", JOptionPane.ERROR_MESSAGE);
            }
        });

        mpan.add(update, BorderLayout.SOUTH);
        mpan.add(delete, BorderLayout.SOUTH);

    }

    public void createStat(String p, int r, int ry, int rt) {
        if (new StatUpdate().createRecStat(p, r, ry, rt)) {
            JOptionPane.showMessageDialog(this, "Player stats successfully created");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add player", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateStat(String p, int r, int ry, int rt) {
        if (new StatUpdate().updateRecStat(p, r, ry, rt)) {
            JOptionPane.showMessageDialog(this, "Players stats updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add player", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
