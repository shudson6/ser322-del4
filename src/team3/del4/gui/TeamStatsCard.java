package team3.del4.gui;

import team3.del4.db.StatGetter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TeamStatsCard extends JPanel {
    private JComboBox teamCB;
    private JComboBox divisionCB;
    private JButton goBtn;

    public TeamStatsCard() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // use a stats getter to get the division and team names
        StatGetter sg = new StatGetter();
        List<String> divs = sg.getDivisions();
        List<String> teams = sg.getTeams(null);

        // init drop-downs
        divisionCB = new JComboBox(createDivCBM(divs));
        divisionCB.addActionListener((e) -> teamCB.setModel(createTeamCBM(new StatGetter().getTeams(
                divisionCB.getSelectedItem().equals("Any") ? null : (String) divisionCB.getSelectedItem()))));
        teamCB = new JComboBox(createTeamCBM(teams));

        // go button: launches the query
        goBtn = new JButton("Query");

        // top row: labels
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("Division"), gbc);
        gbc.gridx = 2;
        add(new JLabel("Team"), gbc);

        // next row: drop-downs
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(divisionCB, gbc);
        gbc.gridx = 2;
        add(teamCB, gbc);

        // finally: go button
        gbc.gridx = 4;
        gbc.gridwidth = 1;
        add(goBtn, gbc);
    }

    private ComboBoxModel<String> createDivCBM(List<String> divs) {
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<>(divs.toArray(new String[0]));
        cbm.insertElementAt("Any", 0);
        return cbm;
    }

    private ComboBoxModel<String> createTeamCBM(List<String> teams) {
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<>(teams.toArray(new String[0]));
        return cbm;
    }
}
