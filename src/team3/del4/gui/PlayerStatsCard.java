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
        goBtn.addActionListener(e -> {
            String position = (String) positionCB.getSelectedItem();
            String name = (String) playerCB.getSelectedItem();
            if (position.equals("QB")){
                List<String> list = sg.getPassingStats(name);
                Object[] stats = {
                        "Name: " + list.get(0),
                        "Position: " + list.get(1),
                        "Team: " + list.get(2),
                        "DOB: " + list.get(3),
                        "Height: " + list.get(4),
                        "Weight: " + list.get(5),
                        "Experience: " + list.get(6),
                        "Games Played: " + list.get(7),
                        "Jersey Number: " + list.get(8),
                        "Pass Attempts: " + list.get(9),
                        "Pass Completions: " + list.get(10),
                        "Passing Yards: " + list.get(11),
                        "Passing TDs: " + list.get(12),
                        "Fumbles: " + list.get(13),
                        "Interceptions: " + list.get(14)
                };
                JOptionPane.showConfirmDialog(null, stats, "Stats for " + list.get(0), JOptionPane.DEFAULT_OPTION);
            }
            if (position.equals("RB")){
                List<String> list = sg.getRushingStats(name);
                Object[] stats = {
                        "Name: " + list.get(0),
                        "Position: " + list.get(1),
                        "Team: " + list.get(2),
                        "DOB: " + list.get(3),
                        "Height: " + list.get(4),
                        "Weight: " + list.get(5),
                        "Experience: " + list.get(6),
                        "Games Played: " + list.get(7),
                        "Jersey Number: " + list.get(8),
                        "Rushing Attempts: " + list.get(9),
                        "Rushing Yards: " + list.get(10),
                        "Rushing TDs: " + list.get(11),
                        "Fumbles: " + list.get(12),
                        "Interceptions: " + list.get(13)
                };
                JOptionPane.showConfirmDialog(null, stats, "Stats for " + list.get(0), JOptionPane.DEFAULT_OPTION);
            }
            if (position.equals("WR")){
                List<String> list = sg.getReceivingStats(name);
                Object[] stats = {
                        "Name: " + list.get(0),
                        "Position: " + list.get(1),
                        "Team: " + list.get(2),
                        "DOB: " + list.get(3),
                        "Height: " + list.get(4),
                        "Weight: " + list.get(5),
                        "Experience: " + list.get(6),
                        "Games Played: " + list.get(7),
                        "Jersey Number: " + list.get(8),
                        "Receptions: " + list.get(9),
                        "Receiving Yards: " + list.get(10),
                        "Receiving TDs: " + list.get(11),
                };
                JOptionPane.showConfirmDialog(null, stats, "Stats for " + list.get(0), JOptionPane.DEFAULT_OPTION);


            }
            if (position.equals("TE")){
                List<String> list = sg.getReceivingStats(name);
                Object[] stats = {
                        "Name: " + list.get(0),
                        "Position: " + list.get(1),
                        "Team: " + list.get(2),
                        "DOB: " + list.get(3),
                        "Height: " + list.get(4),
                        "Weight: " + list.get(5),
                        "Experience: " + list.get(6),
                        "Games Played: " + list.get(7),
                        "Jersey Number: " + list.get(8),
                        "Receptions: " + list.get(9),
                        "Receiving Yards: " + list.get(10),
                        "Receiving TDs: " + list.get(11),
                };
                JOptionPane.showConfirmDialog(null, stats, "Stats for " + list.get(0), JOptionPane.DEFAULT_OPTION);
            }
            if (position.equals("K")){
                List<String> list = sg.getKickingStats(name);
                Object[] stats = {
                        "Name: " + list.get(0),
                        "Position: " + list.get(1),
                        "Team: " + list.get(2),
                        "DOB: " + list.get(3),
                        "Height: " + list.get(4),
                        "Weight: " + list.get(5),
                        "Experience: " + list.get(6),
                        "Games Played: " + list.get(7),
                        "Jersey Number: " + list.get(8),
                        "Field Goal Attempts: " + list.get(9),
                        "Field Goals Made: " + list.get(10),
                };
                JOptionPane.showConfirmDialog(null, stats, "Stats for " + list.get(0), JOptionPane.DEFAULT_OPTION);
            }
        });

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
