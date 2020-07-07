/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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

        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        viewPlayersBtn = new JButton("Get Players");
        viewPlayersBtn.addActionListener((e) -> layout.show(cardPanel, "GetPlayers"));
        menuPanel.add(viewPlayersBtn);

        getTeamStatsBtn = new JButton("Get Team Statistics");
        getTeamStatsBtn.addActionListener((e) -> layout.show(cardPanel, "GetTeamStats"));

        menuPanel.add(getTeamStatsBtn);
        getPlayerStatsBtn = new JButton("Get Player Statistics");
        getPlayerStatsBtn.addActionListener((e) -> layout.show(cardPanel, "GetPlayerStats"));

        menuPanel.add(getPlayerStatsBtn);
        addPlayerBtn = new JButton("Update player");
        addPlayerBtn.addActionListener((e) -> layout.show(cardPanel, "UpdatePlayer"));

        menuPanel.add(addPlayerBtn);

        menuPanel.add(getPlayerStatsBtn);
        createPlayerBtn = new JButton("Create player");
        createPlayerBtn.addActionListener((e) -> layout.show(cardPanel, "CreatePlayer"));

        menuPanel.add(createPlayerBtn);

        addPassBtn = new JButton("Add Passing Stats");
        addPassBtn.addActionListener((e) -> layout.show(cardPanel, "AddPassStats"));
        menuPanel.add(addPassBtn, "AddPassStats");

        addRecBtn = new JButton("Add Reception Stats");
        addRecBtn.addActionListener((e) -> layout.show(cardPanel, "AddRecStats"));
        menuPanel.add(addRecBtn, "AddRecStats");

        addRushBtn = new JButton("Add Rushing Stats");
        addRushBtn.addActionListener((e) -> layout.show(cardPanel, "AddRushStats"));
        menuPanel.add(addRushBtn, "AddRushStats");

        addKicksBtn = new JButton("Add Kicking Stats");
        addKicksBtn.addActionListener((e) -> layout.show(cardPanel, "AddKickStats"));
        menuPanel.add(addKicksBtn, "AddKickStats");

        addTOBtn = new JButton("Add Turnover Stats");
        addTOBtn.addActionListener((e) -> layout.show(cardPanel, "AddTOStats"));
        menuPanel.add(addTOBtn, "AddTOStats");

        cardPanel.add(menuPanel, "MainMenu");

        cardPanel.add(new ViewPlayersCard(), "GetPlayers");
        // create team stats query panel
        cardPanel.add(new TeamStatsCard(), "GetTeamStats");
        // panel to get player stats
        cardPanel.add(new PlayerStatsCard(), "GetPlayerStats");
        // panel to add create new player

        cardPanel.add(new CreatePlayerCard(), "CreatePlayer");
        // panel to add a player
        cardPanel.add(new PlayerInsertCard(), "UpdatePlayer");
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
