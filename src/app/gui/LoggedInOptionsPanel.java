package app.gui;

import javax.swing.*;
import java.awt.*;

/*
 * LoggedInOptionsPanel.java
 *
 * This panel serves as the main dashboard for authenticated users,
 * presenting navigation options such as viewing account details,
 * depositing or withdrawing funds, transferring money, or logging out.
 *
 * Positioned after successful login, it acts as the central hub
 * for all user-initiated banking operations.
 */

public class LoggedInOptionsPanel extends JPanel {

    public LoggedInOptionsPanel(BankingGuiMainPanel gui) {

        setLayout(new BorderLayout());

        JLabel optionsLabel = new JLabel("What would you like to do today?");
        optionsLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        optionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel optionsLabelPanel = new JPanel();
        optionsLabelPanel.setLayout(new BoxLayout(optionsLabelPanel, BoxLayout.Y_AXIS));
        optionsLabelPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 20, 10));
        optionsLabelPanel.add(optionsLabel);

        add(optionsLabelPanel, BorderLayout.NORTH);

        JButton accountDetailsButton = new JButton("Account Details");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton transferButton = new JButton("Transfer funds");
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> gui.showPanel("home"));

       
        JPanel optionButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));  // hgap is horizontal gap and vgap is vertical gap. There will be 10 pixels of space between buttons, side to side
        optionButtonPanel.add(accountDetailsButton);
        optionButtonPanel.add(depositButton);
        optionButtonPanel.add(withdrawButton);
        optionButtonPanel.add(transferButton);
        optionButtonPanel.add(logoutButton);

        //Wrap the button panel in vertical BoxLayout for centering
        JPanel verticalWrapper = new JPanel();
        verticalWrapper.setLayout(new BoxLayout(verticalWrapper, BoxLayout.Y_AXIS));
        verticalWrapper.add(Box.createVerticalGlue());
        verticalWrapper.add(optionButtonPanel);
        verticalWrapper.add(Box.createVerticalGlue());


        add(verticalWrapper, BorderLayout.CENTER);
        
    }
    
}
