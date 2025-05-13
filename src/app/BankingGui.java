package app;

 import javax.swing.*;
 import java.awt.*;

public class BankingGui {

    private JFrame frame;
    private JPanel mainAppPanel;
    // private JTable dataTable; <-- will use later

    //CONSTRUCTOR 
    public BankingGui() {
        createGui();
    }

    public void createGui() {
        frame = new JFrame("JavaBank WorldWide");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);

        createMainPanel();
        frame.add(mainAppPanel);

        frame.setVisible(true);
    }

    public void createMainPanel() {
        mainAppPanel = new JPanel();
        mainAppPanel.setLayout(new BorderLayout());

        JLabel mainLabel = new JLabel("WELCOME!");
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainAppPanel.add(mainLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 20, 0));

        JButton createAccountButton = new JButton("Create Account");
        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(createAccountButton);
        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);

        mainAppPanel.add(buttonPanel, BorderLayout.CENTER);
    }


    
}
