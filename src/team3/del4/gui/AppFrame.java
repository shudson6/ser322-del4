package team3.del4.gui;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    final JPanel returnPanel;
    final JButton returnButton;
    final JPanel cardPanel;
    final CardLayout layout;
    final MainMenuPanel mainMenu;

    public AppFrame() {
        setTitle("Team 3 NFL Stats DB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainMenu = new MainMenuPanel();

        // panel that will display the chosen ui
        cardPanel = new JPanel();
        layout = new CardLayout();
        cardPanel.setLayout(layout);
        cardPanel.add(mainMenu, "Main Menu");

        // persistent button to return to main menu
        returnPanel = new JPanel();
        returnButton = new JButton("Main Menu");
        returnButton.addActionListener((e) -> layout.show(cardPanel, "Main Menu"));
        returnPanel.add(returnButton);

        JPanel cp = new JPanel();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(cardPanel);
        cp.add(returnPanel);

        setContentPane(cp);
        pack();
    }
}
