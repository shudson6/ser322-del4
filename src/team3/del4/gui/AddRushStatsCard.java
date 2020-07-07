package team3.del4.gui;

/**
 *
 * @author Socce
 */
import team3.del4.db.StatGetter;
import java.awt.*;
import javax.swing.*;
import team3.del4.db.StatUpdate;

public class AddRushStatsCard extends JPanel {
    private PlayerSelector player;
    private JTextField attTF;
    private JTextField ydsTF;
    private JTextField tdsTF;
    private JButton update;
    private JButton delete;

    public AddRushStatsCard() {
        run();
    }

    public void run() {
        player = new PlayerSelector();
        attTF = new JTextField(10);
        ydsTF = new JTextField(10);
        tdsTF = new JTextField(10);
        update = new JButton("Update");
        update.addActionListener(e -> clickedUpdate());
        delete = new JButton("Delete");
        delete.addActionListener(e -> clickedDelete());

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(player, gbc);

        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 3;
        gbc.gridy = 1;
        add(new JLabel("Att"), gbc);
        gbc.gridx = 4;
        add(new JLabel("Yds"), gbc);
        gbc.gridx = 5;
        add(new JLabel("TDs"), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 2;
        add(attTF, gbc);
        gbc.gridx = 4;
        add(ydsTF, gbc);
        gbc.gridx = 5;
        add(tdsTF, gbc);

        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 4;
        gbc.gridy = 3;
        add(update, gbc);
        gbc.gridx = 5;
        add(delete, gbc);
    }

    public void updateStat(String p, int r, int ry, int rt) {
        StatUpdate sql = new StatUpdate();
        if (sql.updateRushStat(p, r, ry, rt) || sql.createRushStat(p, r, ry, rt)) {
            JOptionPane.showMessageDialog(this, "Players stats updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Could not insert nor update stat.", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clickedDelete() {
        String name = player.getSelectedPlayer();
        if (new StatUpdate().deleteStat("RUSHING_STATISTICS", name)) {
            JOptionPane.showMessageDialog(this, "Player stat deleted.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete stat", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clickedUpdate() {
        try {
            String name = player.getSelectedPlayer();
            int att = Integer.parseInt(attTF.getText());
            int yd = Integer.parseInt(ydsTF.getText());
            int td = Integer.parseInt(tdsTF.getText());
            updateStat(name, att, yd, td);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Failed to add stat", "Invalid input for number", JOptionPane.ERROR_MESSAGE);
        }
    }
}
