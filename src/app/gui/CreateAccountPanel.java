package app.gui;

import app.user.User;
import app.user.UserManager;

import java.awt.*;
import javax.swing.*;

public class CreateAccountPanel extends JPanel {

    private BankingGuiMainPanel gui;
    private UserManager userManager;

    private JTextField userEmailField;
    private JTextField confirmEmailField;
    private JTextField passwordSetField;
    private JTextField confirmPwField;
    private JTextField openingDepositField;
    private JComboBox<String> accountTypeBox;

    private final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>]).{10,}$";


    public CreateAccountPanel(BankingGuiMainPanel gui, UserManager userManager) {
        
        setLayout(new BorderLayout(10,10));
        
        JLabel createAccountLabel = new JLabel("Create Your Account");
        createAccountLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        createAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //This will be aligned NORTH due to the formPanel being aligned CENTER and the buttonPanel being aligned SOUTH
        JPanel titlePanel = new JPanel();
        titlePanel.add(createAccountLabel);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
        add(titlePanel, BorderLayout.NORTH);

        
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,300));

        JPanel container = new JPanel(new BorderLayout());
        container.add(formPanel, BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel userEmailLabel = new JLabel("Email address");
        userEmailField = new JTextField(15);

        JLabel confirmUserEmailLabel = new JLabel("Confirm email address");
        confirmEmailField = new JTextField(15);

        JLabel passwordSetLabel = new JLabel("Password");
        passwordSetField = new JTextField(15);

        JLabel confirmPasswordLabel = new JLabel("Confirm password");
        confirmPwField = new JTextField(15);

        JLabel accountTypeLabel = new JLabel("Account Type"); 
        accountTypeBox = new JComboBox<>(new String [] {
            "",
            "Checking Account",
            "Savings Account", 
            "Student Checking", 
            "CD Account"
        });

        JLabel openingDepositLabel = new JLabel("Opening Deposit");
        openingDepositField = new JTextField(10);



        gbc.insets = new Insets(5,5,5,5);

        // GRIDX = COLUMN -----> MOVES TO THE RIGHT TO DICTATE COLUMN//// GRIDY = ROW MOVES DOWN TO DICTATE ROW

        // first row: userEmailLabel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; 
        formPanel.add(userEmailLabel, gbc);


        gbc.gridx = 1; // column 1
        gbc.gridy = 0; // row 0
        gbc.anchor = GridBagConstraints.WEST; 
        formPanel.add(userEmailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST; // 
        formPanel.add(confirmUserEmailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST; 
        formPanel.add(confirmEmailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST; 
        formPanel.add(passwordSetLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST; 
        formPanel.add(passwordSetField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST; // this aligng the label to the right within its own cell
        formPanel.add(confirmPasswordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST; 
        formPanel.add(confirmPwField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST; // this aligng the label to the right within its own cell
        formPanel.add(accountTypeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST; // this aligng the label to the right within its own cell
        formPanel.add(accountTypeBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST; // this aligng the label to the right within its own cell
        formPanel.add(openingDepositLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST; // this aligng the label to the right within its own cell
        formPanel.add(openingDepositField, gbc);

        // Create the button panel with a FlowLayout as to keep the buttons next to each otherr

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));

        // Create the buttons and give them action listeneers 

        JButton createButton = new JButton("Create Account");
        createButton.addActionListener(e -> handleAccountCreation());

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> gui.showPanel("home"));

        buttonPanel.add(createButton);
        buttonPanel.add(cancelButton);

        // add the buttonPanel to the mainFrame

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /*--------------------------------------------------------------------------------
                                       METHODS
    --------------------------------------------------------------------------------*/

    private void handleAccountCreation() {
        String userEmail = userEmailField.getText().trim();
        String confirmEmail = confirmEmailField.getText().trim();
        String userPassword = passwordSetField.getText().trim();
        String confirmPassword = confirmPwField.getText().trim();
        String accountType = (String) accountTypeBox.getSelectedItem();
        double openingDeposit = 0.0;

        try{
            openingDeposit = Double.parseDouble(openingDepositField.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the opening deposit");
            return;
        }

        // Here we validate that the fields are the same

        if(!userEmail.matches(EMAIL_REGEX) || !userEmail.equals(confirmEmail)) {
           JOptionPane.showMessageDialog(this, "Please enter matching, valid emails");
           userEmailField.setText("");
           confirmEmailField.setText("");
           return;
        }

        if (!userPassword.matches(PASSWORD_REGEX) || !userPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Your password must be at least 10 characters long, contain one uppercase letter, and contain one special character");
            passwordSetField.setText("");
            confirmPwField.setText("");
            return;
        }

        if(accountType == null || accountType.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select an account type");
            return;
        }

        userManager.addUser(new User(userEmail, userPassword, accountType, openingDeposit));


    }
}
