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
import team3.del4.db.StatUpdate;
import team3.del4.db.StatGetter;

import java.awt.*;

import javax.swing.*;

public class CreatePlayerCard extends JPanel {

    private String name;
    private String dob;
    private String height;
    private int weight;
    private int experience;
    private int games;
    private int jnum;

    public CreatePlayerCard() {
        run();
    }

    public void run() {

        JPanel mpan = this;

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 3, 5, 5));
        JLabel l1 = new JLabel("Name");
        JLabel l2 = new JLabel("Position");
        JLabel l3 = new JLabel("Team");

        JLabel l4 = new JLabel("DOB");
        JLabel l5 = new JLabel("Height");
        JLabel l6 = new JLabel("Weight");

        JLabel l7 = new JLabel("Experience");
        JLabel l8 = new JLabel("Games_Played");
        JLabel l9 = new JLabel("Jersey_Num");
        JTextField pname = new JTextField(10);

        JComboBox<String> pbox = new JComboBox<>(new StatGetter().getPositions().toArray(new String[0]));
        JComboBox<String> tbox = new JComboBox<>(new StatGetter().getTeams(null).toArray(new String[0]));

        JTextField dobox = new JTextField(5);

        JTextField ht = new JTextField(5);

        JTextField wt = new JTextField(5);

        JTextField exp = new JTextField(5);

        JTextField gP = new JTextField(5);

        JTextField jN = new JTextField(5);
        center.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        center.add(l1);
        center.add(l2);
        center.add(l3);
        ///name, pos, team
        center.add(pname);
        center.add(pbox);
        center.add(tbox);
        center.add(l4);
        center.add(l5);
        center.add(l6);

        center.add(dobox);
        center.add(ht);
        center.add(wt);
        center.add(l7);
        center.add(l8);
        center.add(l9);

        center.add(exp);
        center.add(gP);
        center.add(jN);
        mpan.add(center, BorderLayout.CENTER);
        JButton create = new JButton("Create");
        create.addActionListener(e -> {
            try {
                name = pname.getText();
                String p = (String) pbox.getSelectedItem();
                String t = (String) tbox.getSelectedItem();
                dob = dobox.getText();
                height = ht.getText();
                weight = Integer.parseInt(wt.getText());
                experience = Integer.parseInt(exp.getText());
                games = Integer.parseInt(gP.getText());
                jnum = Integer.parseInt(jN.getText());
                createPlayer(name, p, t, dob, height, weight, experience, games, jnum);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Failed to create player", "Invalid input for number", JOptionPane.ERROR_MESSAGE);
            }
        });

        mpan.add(create, BorderLayout.SOUTH);
    }

    public void createPlayer(String p, String pos, String t, String d, String h, int w, int e, int g, int j) {

        if (new StatUpdate().insertPlayer(p, pos, t, d, h, w, e, g, j)) {
            JOptionPane.showMessageDialog(this, "Player added successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add player", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
