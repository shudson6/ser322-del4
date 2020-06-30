package team3.del4.gui;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    private final JPanel returnPanel;
    private final JButton returnButton;
    private final JPanel cardPanel;
    private final CardLayout layout;
    private final JPanel menuPanel;
    private final JButton getTeamStatsBtn;
    private final JButton getPlayerStatsBtn;
    private final JButton addPlayerBtn;

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
        getTeamStatsBtn = new JButton("Get Team Statistics");
        getTeamStatsBtn.addActionListener((e) -> layout.show(cardPanel, "GetTeamStats"));
        menuPanel.add(getTeamStatsBtn);
        getPlayerStatsBtn = new JButton("Get Player Statistics");
        menuPanel.add(getPlayerStatsBtn);
        addPlayerBtn = new JButton("Add player");
        menuPanel.add(addPlayerBtn);

        cardPanel.add(menuPanel, "MainMenu");

        // create team stats query panel
        JPanel getTeamStats = new TeamStatsCard();
        cardPanel.add(getTeamStats, "GetTeamStats");

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
