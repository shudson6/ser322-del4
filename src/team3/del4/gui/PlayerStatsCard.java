package team3.del4.gui;

import team3.del4.db.StatGetter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
    private JComboBox teamCB;
    private JButton goBtn;
    private JTable table;
    JScrollPane scrollPane;

    public PlayerStatsCard(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        StatGetter sg = new StatGetter();
        List<String> teams = sg.getAllTeams();
        List<String> positions = sg.getPositions();


        positionCB = new JComboBox(createPosCBM(positions));
        teamCB = new JComboBox(createTeamCBM(teams));
        positionCB.addActionListener((e) -> positionCB.getSelectedItem());
        teamCB.addActionListener((e) -> teamCB.getSelectedItem());

        table = new JTable();

        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();


        String[] colName = new String[]{"Name", "Position", "Team"};
        tableModel.setColumnIdentifiers(colName);
        tableModel.setRowCount(0);

        TableColumn tableColumn = table.getColumnModel().getColumn(0);
        tableColumn.setPreferredWidth(300);
        tableColumn = table.getColumnModel().getColumn(1);
        tableColumn.setPreferredWidth(200);
        tableColumn = table.getColumnModel().getColumn(2);
        tableColumn.setPreferredWidth(200);

        goBtn = new JButton("Search");
        goBtn.addActionListener(e -> {

            String pos = (String) positionCB.getSelectedItem();
            String team = (String) teamCB.getSelectedItem();

            if (pos.equals("All Positions")){
                pos = null;
            }
            if (team.equals("All Teams")){
                team = null;
            }

            List<String> result = sg.getPlayers(pos,team);

            tableModel.setRowCount(0);

            String[] data = new String[9];

            int k = 0;
            for (int i=0; i<result.size()/3; i++){
                for (int j=0; j<3; j++){
                    data[j] = result.get(k);
                    k++;
                }
                tableModel.addRow(data);
            }

            tableModel.fireTableDataChanged();
        });

        scrollPane = new JScrollPane(table);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("Position"), gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("Team"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(positionCB, gbc);
        gbc.gridx = 2;
        add(teamCB, gbc);
        gbc.gridx = 4;
        add(goBtn, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        add(scrollPane, gbc);
    }

    private ComboBoxModel<String> createTeamCBM(List<String> teams) {
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<>(teams.toArray(new String[0]));
        cbm.insertElementAt("All Teams", 0);
        return cbm;
    }

    private ComboBoxModel<String> createPosCBM(List<String> positions) {
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<>(positions.toArray(new String[0]));
        cbm.insertElementAt("All Positions",0);
        return cbm;
    }
}
