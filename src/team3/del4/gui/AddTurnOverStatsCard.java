package team3.del4.gui;

/**
 *
 * @author Socce
 */
import team3.del4.db.StatGetter;
import java.awt.*;
import team3.del4.db.StatUpdate;
import javax.swing.*;

public class AddTurnOverStatsCard extends JPanel {
    private PlayerSelector player;
    private JTextField fumTF;
    private JTextField intTF;
    private JButton update;
    private JButton delete;

    public AddTurnOverStatsCard() {
        run();
    }

    public void run() {
        player = new PlayerSelector();
        fumTF = new JTextField(10);
        intTF = new JTextField(10);
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

        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 1;
        add(new JLabel("Fumbles"), gbc);
        gbc.gridx = 4;
        add(new JLabel("Interceptions"), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 2;
        add(fumTF, gbc);
        gbc.gridx = 4;
        add(intTF, gbc);

        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridy = 3;
        gbc.gridx = 3;
        add(update, gbc);
        gbc.gridx = 4;
        add(delete, gbc);
    }

    public void updateStat(String p, int f, int i) {
        StatUpdate sql = new StatUpdate();
        if (sql.updateTOStat(p, f, i) || sql.createTOStat(p, f, i)) {
            JOptionPane.showMessageDialog(this, "Players stats updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add player", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clickedDelete() {
        String name = player.getSelectedPlayer();
        if (new StatUpdate().deleteStat("TURNOVER_STATISTICS", name)) {
            JOptionPane.showMessageDialog(this, "Players stats deleted.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete stats", "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clickedUpdate() {
        try {
            String name = player.getSelectedPlayer();
            int fum = Integer.parseInt(fumTF.getText());
            int inter = Integer.parseInt(intTF.getText());

            updateStat(name, fum, inter);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Failed to add player", "Invalid input for number", JOptionPane.ERROR_MESSAGE);
        }
    }
}
