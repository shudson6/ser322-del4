package team3.del4.gui;


import team3.del4.db.StatGetter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * I used the team stats card as a guide for this so its really similar.
 * Currently it has search selections based on position. The user can choose
 * to search for players of all positions or from a specific position
 *
 */

public class PlayerStatsCard extends JPanel{
    private JComboBox teamCB;
    private JComboBox playerCB;
    private JButton goBtn;

    public PlayerStatsCard(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        StatGetter sg = new StatGetter();
        List<String> teams = sg.getAllTeams();
        List<String> players = sg.getAllPlayersInTeam(null);

        teamCB = new JComboBox(createTeamCBM(teams));
        teamCB.addActionListener((e) -> playerCB.setModel(createPlayerCBM(new StatGetter().getAllPlayersInTeam(
                teamCB.getSelectedItem().equals("Any") ? null : (String) teamCB.getSelectedItem()))));
        playerCB = new JComboBox(createPlayerCBM(players));

        goBtn = new JButton(("Search"));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("Team"), gbc);
        gbc.gridx = 2;
        add(new JLabel("Player"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(teamCB,gbc);
        gbc.gridx = 2;
        add(playerCB, gbc);

        gbc.gridx = 4;
        gbc.gridwidth = 1;
        add(goBtn, gbc);
    }

    private ComboBoxModel<String> createTeamCBM(List<String> teams) {
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<>(teams.toArray(new String[0]));
        cbm.insertElementAt("Any", 0);
        return cbm;
    }

    private ComboBoxModel<String> createPlayerCBM(List<String> players){
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<>(players.toArray(new String[0]));
        return cbm;
    }
}
