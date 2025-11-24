package app.gui;

import javax.swing.*;
import java.awt.*;

/*
 * LoginPanel.java
 *
 * This panel provides a login interface for users to enter their credentials.
 * It includes fields for email and password input, as well as Login and Cancel buttons.
 * Upon integration, the Cancel button should route the user back to the Home screen,
 * and the Login button will validate credentials to transition to the Logged-In options.
 */

public class LoginPanel extends JPanel {

    public LoginPanel(BankingGuiMainPanel gui) {

        setLayout(new BorderLayout());

        JLabel loginLabel = new JLabel("Login to your Account");
        loginLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel loginLabelPanel = new JPanel();
        loginLabelPanel.setLayout(new BoxLayout(loginLabelPanel, BoxLayout.Y_AXIS));
        loginLabelPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 20, 10));
        loginLabelPanel.add(loginLabel);

        add(loginLabelPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel userEmailLabel = new JLabel("Email Address: ");
        JTextField userEmailField = new JTextField(20);

        JLabel userPassword = new JLabel("Password: ");
        JTextField userPassField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> gui.showPanel("loggedIn"));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> gui.showPanel("home"));
        

        // Add insets or padding if you will
        gbc.insets = new Insets(5,5,5,5); 

        // GRIDX = COLUMN -----> MOVES TO THE RIGHT TO DICTATE COLUMN//// GRIDY = ROW MOVES DOWN TO DICTATE ROW

        // first row: userEmail label
        gbc.gridx = 0; // column 0
        gbc.gridy = 0; // row 0
        gbc.anchor = GridBagConstraints.EAST; // aligns the label to the right
        formPanel.add(userEmailLabel, gbc); // add the label and gbc to the JPanel

        // first row userEmail text field
        gbc.gridx = 1; // column 1
        gbc.gridy = 0; // row 0
        gbc.anchor = GridBagConstraints.WEST; // aligns the field to the left in column 1
        gbc.fill = GridBagConstraints.HORIZONTAL; // allows the label to stretch
        formPanel.add(userEmailField, gbc);

        // second row: password label
        gbc.gridx = 0; // column 0
        gbc.gridy = 1; // row 1
        gbc.anchor = GridBagConstraints.EAST; //  aligns the label to the right within its grid cell
        gbc.fill = GridBagConstraints.HORIZONTAL; // allows the label to stretch
        formPanel.add(userPassword, gbc);

        // second row: password field
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(userPassField, gbc);

        // third row: login and cancel buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,0)); // < - - - -explain what these could be doing!
        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // make it span the two columns
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(buttonPanel, gbc);

        add(formPanel, BorderLayout.CENTER); 
    }
}
