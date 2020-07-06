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
    private JComboBox positionCB;
    private JComboBox playerCB;
    private JButton goBtn;

    public PlayerStatsCard(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        StatGetter sg = new StatGetter();
        List<String> positions = sg.getPositions();
        List<String> players = sg.getPlayersWithPos("K");

        positionCB = new JComboBox(createPosCBM(positions));
        positionCB.addActionListener((e) -> playerCB.setModel(createPlayerCBM(new StatGetter().getPlayersWithPos(
                (String) positionCB.getSelectedItem()))));
        playerCB = new JComboBox(createPlayerCBM(players));

        goBtn = new JButton(("Search"));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("Position"), gbc);
        gbc.gridx = 2;
        add(new JLabel("Player"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(positionCB,gbc);
        gbc.gridx = 2;
        add(playerCB, gbc);

        gbc.gridx = 4;
        gbc.gridwidth = 1;
        add(goBtn, gbc);
    }

    private ComboBoxModel<String> createPosCBM(List<String> positions) {
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<>(positions.toArray(new String[0]));
        return cbm;
    }

    private ComboBoxModel<String> createPlayerCBM(List<String> players){
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<>(players.toArray(new String[0]));
        return cbm;
    }
}
