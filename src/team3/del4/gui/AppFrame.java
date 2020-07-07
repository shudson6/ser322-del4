/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3.del4.gui;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

    private final JPanel returnPanel;
    private final JButton returnButton;
    private final JPanel cardPanel;
    private final CardLayout layout;
    private final JPanel menuPanel;
    private final JButton viewPlayersBtn;
    private final JButton getTeamStatsBtn;
    private final JButton getPlayerStatsBtn;
    private final JButton addPlayerBtn;
    private final JButton addKicksBtn;
    private final JButton addPassBtn;
    private final JButton addRecBtn;
    private final JButton addRushBtn;
    private final JButton addTOBtn;
    private final JButton createPlayerBtn;

    public AppFrame() {
        setTitle("Team 3 NFL Stats DB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // panel that will contain all ui panels and display as appropriate
        cardPanel = new JPanel();
        layout = new CardLayout();
        cardPanel.setLayout(layout);

        // create main menu
        menuPanel = new JPanel();
        viewPlayersBtn = new JButton("Get Rosters");
        viewPlayersBtn.addActionListener((e) -> layout.show(cardPanel, "GetPlayers"));
        getTeamStatsBtn = new JButton("Get Team Data");
        getTeamStatsBtn.addActionListener((e) -> layout.show(cardPanel, "GetTeamStats"));
        getPlayerStatsBtn = new JButton("Get Player Data");
        getPlayerStatsBtn.addActionListener((e) -> layout.show(cardPanel, "GetPlayerStats"));
        addPlayerBtn = new JButton("Update Player");
        addPlayerBtn.addActionListener((e) -> layout.show(cardPanel, "UpdatePlayer"));
        createPlayerBtn = new JButton("Create Player");
        createPlayerBtn.addActionListener((e) -> layout.show(cardPanel, "CreatePlayer"));
        addPassBtn = new JButton("Edit Passing Stats");
        addPassBtn.addActionListener((e) -> layout.show(cardPanel, "AddPassStats"));
        addRecBtn = new JButton("Edit Reception Stats");
        addRecBtn.addActionListener((e) -> layout.show(cardPanel, "AddRecStats"));
        addRushBtn = new JButton("Edit Rushing Stats");
        addRushBtn.addActionListener((e) -> layout.show(cardPanel, "AddRushStats"));
        addKicksBtn = new JButton("Edit Kicking Stats");
        addKicksBtn.addActionListener((e) -> layout.show(cardPanel, "AddKickStats"));
        addTOBtn = new JButton("Edit Turnover Stats");
        addTOBtn.addActionListener((e) -> layout.show(cardPanel, "AddTOStats"));

        menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 5;
        gbc.ipady = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbc.gridx = 1;
        gbc.gridy = 1;
        menuPanel.add(viewPlayersBtn, gbc);
        gbc.gridy = 2;
        menuPanel.add(getPlayerStatsBtn, gbc);
        gbc.gridy = 3;
        menuPanel.add(getTeamStatsBtn, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        menuPanel.add(createPlayerBtn, gbc);
        gbc.gridy = 2;
        menuPanel.add(addPlayerBtn, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        menuPanel.add(addPassBtn, gbc);
        gbc.gridy = 1;
        menuPanel.add(addRecBtn, gbc);
        gbc.gridy = 2;
        menuPanel.add(addRushBtn, gbc);
        gbc.gridy = 3;
        menuPanel.add(addKicksBtn, gbc);
        gbc.gridy = 4;
        menuPanel.add(addTOBtn, gbc);

        cardPanel.add(menuPanel, "MainMenu");

        cardPanel.add(new ViewPlayersCard(), "GetPlayers");
        // create team stats query panel
        cardPanel.add(new TeamStatsCard(), "GetTeamStats");
        // panel to get player stats
        cardPanel.add(new PlayerStatsCard(), "GetPlayerStats");
        // panel to add create new player

        cardPanel.add(new CreatePlayerCard(), "CreatePlayer");
        // panel to add a player
        cardPanel.add(new PlayerUpdateCard(), "UpdatePlayer");
        //panel to add pass stats
        cardPanel.add(new AddPassStatsCard(), "AddPassStats");
        //panel to add turnover stats
        cardPanel.add(new AddTurnOverStatsCard(), "AddTOStats");
        //panel to add rush stats
        cardPanel.add(new AddRushStatsCard(), "AddRushStats");
        //panel to add rec stats
        cardPanel.add(new AddRecStatsCard(), "AddRecStats");
        // panel to add kicking stats
        cardPanel.add(new AddKickStatsCard(), "AddKickStats");

        // persistent button to return to main menu
        returnPanel = new JPanel();
        returnButton = new JButton("Main Menu");
        returnButton.addActionListener((e) -> layout.show(cardPanel, "MainMenu"));
        returnPanel.add(returnButton);

        JPanel cp = new JPanel();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(cardPanel);
        cp.add(returnPanel);

        setContentPane(cp);
        pack();
    }
}
