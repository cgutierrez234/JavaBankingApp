package app.gui;

import javax.swing.*;
import java.awt.*;

/*
 * HomePanel serves as the welcome screen for the JavaBankingApp GUI.
 * It provides users with a simple, visually centered layout to begin interacting
 * with the application by either creating a new account or logging in.
 *
 * Layout Overview:
 * - BorderLayout is used to separate the panel into distinct regions.
 * - NORTH: A vertically stacked welcome message using BoxLayout for clear, centered text.
 * - CENTER: Two horizontally-aligned action buttons using GridBagLayout for spacing and alignment.
 *
 * This panel is intended to be the first screen shown and is designed to
 * integrate with a CardLayout system for seamless panel switching.
 */

public class HomePanel extends JPanel {
    
        public HomePanel(BankingGuiMainPanel gui) {
        
        setLayout(new BorderLayout());

        JLabel label1 = new JLabel("WELCOME!");
        label1.setFont(new Font("SansSerif", Font.BOLD, 20));
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label2 = new JLabel("What would you like to do today?!");
        label2.setFont(new Font("SansSerif", Font.BOLD, 20));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 20, 10));
        labelPanel.add(label1);
        labelPanel.add(Box.createVerticalStrut(20)); // gives vertical space between the labels without needing padding. An inivisible spacer block.
        labelPanel.add(label2);

        add(labelPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,20,10,20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;

        JButton createAccountButton = new JButton("Create Account");

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> gui.showPanel("login") );

        //Font buttonFont = new Font("SansSerif", Font.PLAIN, 14);
        //createAccountButton.setFont(buttonFont);
        //loginButton.setFont(buttonFont);

        gbc.gridx = 0;
        buttonPanel.add(createAccountButton,gbc);

        gbc.gridx =1;
        buttonPanel.add(loginButton,gbc);
        
        add(buttonPanel, BorderLayout.CENTER);

    }
}
