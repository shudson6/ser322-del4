package team3.del4.gui;

import team3.del4.db.StatGetter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

/**
 * Component that allows for selecting a player. Contains three {@link JComboBox}es, for Team, Position, and Player. The
 * Team and Position narrow down the options for Player. This component has a vertical layout with labels on the left;
 * alternatively, use the get***ComboBox() methods and place the individual components into your own layout.
 * <p>
 * Either way, call #getSelectedPlayer() to get the selection from the Player combo box.
 */
public class PlayerSelector extends JComponent {
    private final JComboBox<String> playerCB;
    private final JComboBox<String> posCB;
    private final JComboBox<String> teamCB;

    public PlayerSelector() {
        super();
        setOpaque(true);

        playerCB = createPlayerCB();
        posCB = createPosCB();
        posCB.addActionListener((e) -> filterChanged());
        teamCB = createTeamCB();
        teamCB.addActionListener((e) -> filterChanged());

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Team"), gbc);
        gbc.gridy = 1;
        add(new JLabel("Position"), gbc);
        gbc.gridy = 2;
        add(new JLabel("Player"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        add(teamCB, gbc);
        gbc.gridy = 1;
        add(posCB, gbc);
        gbc.gridy = 2;
        add(playerCB, gbc);
    }

    public JComboBox<String> getPlayerComboBox() {
        return playerCB;
    }

    public JComboBox<String> getPositionComboBox() {
        return posCB;
    }

    public JComboBox<String> getTeamComboBox() {
        return teamCB;
    }

    public String getSelectedPlayer() {
        return (String) playerCB.getSelectedItem();
    }

    private JComboBox<String> createTeamCB() {
        JComboBox<String> cb = new JComboBox<>(createCBModel(new StatGetter().getTeams(null), true));
        cb.setSelectedIndex(0);
        return cb;
    }

    private JComboBox<String> createPosCB() {
        JComboBox<String> cb = new JComboBox<>(createCBModel(new StatGetter().getPositions(), true));
        cb.setSelectedIndex(0);
        return cb;
    }

    private JComboBox<String> createPlayerCB() {
        JComboBox<String> cb = new JComboBox<>(createPlayerCBModel(null, null));
        cb.setPrototypeDisplayValue("Aaaaaaaaaaa Aaaaaaaaaaa");
        return cb;
    }

    private ComboBoxModel<String> createPlayerCBModel(String team, String pos) {
        return createCBModel(new StatGetter().getPlayers(pos, team), false);
    }

    private ComboBoxModel<String> createCBModel(List<String> items, boolean anyOption) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items.toArray(new String[0]));
        if (anyOption) {
            model.insertElementAt("Any", 0);
        }
        return model;
    }

    private void filterChanged() {
        String team = teamCB.getSelectedItem().equals("Any") ? null : (String) teamCB.getSelectedItem();
        String pos = posCB.getSelectedItem().equals("Any") ? null : (String) posCB.getSelectedItem();
        playerCB.setModel(createPlayerCBModel(team, pos));
    }
}
