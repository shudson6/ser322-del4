package team3.del4.gui;

import java.awt.*;
import team3.del4.db.StatUpdate;
import javax.swing.*;

public class AddKickStatsCard extends JPanel {
    private PlayerSelector playerCB;
    private JTextField attTF;
    private JTextField madeTF;
    private JButton update;
    private JButton delete;

    public AddKickStatsCard() {
        init();
    }

    public void init() {
        playerCB = new PlayerSelector();
        attTF = new JTextField(10);
        madeTF = new JTextField(10);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        add(playerCB, gbc);

        // alignment
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.gridx = 3;
        gbc.gridy = 0;
        add(Box.createVerticalStrut(11), gbc);

        // labels for text fields
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 1;
        add(new JLabel("Att"), gbc);
        gbc.gridx = 4;
        add(new JLabel("Made"), gbc);

        // text fields themselves
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 2;
        add(attTF, gbc);
        gbc.gridx = 4;
        add(madeTF, gbc);

        // the buttons
        update = new JButton("Update");
        update.addActionListener(e -> clickedUpdate());

        delete = new JButton("Delete");
        delete.addActionListener(e -> clickedDelete());

        // put them underneath, sort-of right-aligned
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridy = 3;
        gbc.gridx = 3;
        add(update, gbc);
        gbc.gridx = 4;
        add(delete, gbc);
    }

    public void updateStat(String p, int a, int c) {
        StatUpdate sql = new StatUpdate();
        // try update first
        if (sql.updateKickStat(p, a, c) || sql.createKickStat(p, a, c)) {
            JOptionPane.showMessageDialog(this, "Players stats updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Could not insert nor update stats.", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clickedUpdate() {
        try {
            int att = Integer.parseInt(attTF.getText());
            int com = Integer.parseInt(madeTF.getText());

            updateStat(playerCB.getSelectedPlayer(), att, com);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Failed to add player", "Invalid input for number", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clickedDelete() {
        if (new StatUpdate().deleteStat("KICKING_STATISTICS", playerCB.getSelectedPlayer())) {
            JOptionPane.showMessageDialog(this, "Players stats deleted.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete stats", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
