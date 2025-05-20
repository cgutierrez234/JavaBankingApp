package app.gui;

import javax.swing.*;
import java.awt.*;

/*
 * LoggedInOptions.java
 *
 * This panel serves as the main dashboard for authenticated users,
 * presenting navigation options such as viewing account details,
 * depositing or withdrawing funds, transferring money, or logging out.
 *
 * Positioned after successful login, it acts as the central hub
 * for all user-initiated banking operations.
 */

public class LoggedInOptions extends JPanel {

    public LoggedInOptions(BankingGui gui) {

        setLayout(new BorderLayout());

        JLabel optionsLabel = new JLabel("What would you like to do today?");
        optionsLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        optionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(optionsLabel, BorderLayout.NORTH);

        JButton accountDetailsButton = new JButton("Account Details");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton transferButton = new JButton("Transfer funds");
        JButton logoutButton = new JButton("Logout");

        JPanel optionButtonPanel = new JPanel();
        optionButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10)); // hgap is horizontal gap and vgap is vertical gap. There will be 10 pixels of space between buttons, side to side
        
        optionButtonPanel.add(accountDetailsButton);
        optionButtonPanel.add(depositButton);
        optionButtonPanel.add(withdrawButton);
        optionButtonPanel.add(transferButton);
        optionButtonPanel.add(logoutButton);

        add(optionButtonPanel, BorderLayout.CENTER);
        
    }
    
}
