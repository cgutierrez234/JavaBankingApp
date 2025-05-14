package app.gui;

import javax.swing.*;
import java.awt.*;

/*
 * HomePanel is the main landing screen for the JavaBankingApp GUI.
 * It displays a welcoming message and provides buttons for users to
 * either create a new account or log in to an existing one.
 *
 * This panel is structured using BorderLayout:
 * - NORTH: Displays the welcome label in a retro-style font.
 * - CENTER: Contains horizontally-aligned action buttons using GridBagLayout.
 *
 * Designed for modularity, this panel is intended to be swapped into the main
 * frame by the BankingGui controller.
 */

public class HomePanel extends JPanel {
    
        public HomePanel() {
        
        setLayout(new BorderLayout());

        JLabel mainLabel = new JLabel(
            "<html><div style='text-align:center;'>"
            + "<span style='font-size:24pt;'>WELCOME!</span><br>"
            + "<span style='font-size:16pt;'>What would you like to do today?</span>"
            + "</div></html>"
        );
        
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 20, 10));
        labelPanel.add(mainLabel);

        add(labelPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,20,10,20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;

        JButton createAccountButton = new JButton("Create Account");
        JButton loginButton = new JButton("Login");

        Font buttonFont = new Font("SansSerif", Font.PLAIN, 14);
        createAccountButton.setFont(buttonFont);
        loginButton.setFont(buttonFont);

        gbc.gridx = 0;
        buttonPanel.add(createAccountButton);

        gbc.gridx =1;
        buttonPanel.add(loginButton);
        
        add(buttonPanel, BorderLayout.CENTER);

    }
}
