package app.gui;

 import javax.swing.*;
 import java.awt.*;

 /*
 * BankingGui is the main window controller for the JavaBankingApp.
 * It initializes the application frame and serves as the entry point
 * for loading the initial user interface panel.
 *
 * Currently, it loads the HomePanel as the default view, which contains
 * navigation options like creating a new account or logging in.
 *
 * This class is responsible for:
 * - Setting up the JFrame window (title, size, location, close operation)
 * - Attaching the initial panel to the frame
 * - Displaying the application window
 *
 * Future enhancements may include support for dynamic panel swapping
 * (e.g., navigating between HomePanel, LoginPanel, AccountDashboard).
 */

public class BankingGuiMainPanel {

    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    //CONSTRUCTOR 
    public BankingGuiMainPanel() {
        createGui();
    }

    public void createGui() {
        frame = new JFrame("JavaBank WorldWide");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,450);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(new HomePanel(this), "home");
        cardPanel.add(new LoginPanel(this), "login");
        cardPanel.add(new LoggedInOptionsPanel(this), "loggedIn");
        // cardPanel.add(LoginPanel(), "login");
        // cardPanel.add(CreateAccountPanel(), "create");

        frame.add(cardPanel);
        frame.setVisible(true);
    }

    /*
     * Switches the visible panel inside the CardLayout by name.
     * @param name The name of the panel to show (e.g., "home", "login")
     */

     /* NOT USED YET . . . WILL BE USED WHEN I WIRE THE LOGIN OR CREATE ACCOUNT BUTTONS. THE ACTION LISTENER WILL
        TRIGGER THIS METHOD TO SHOW A DIFFERENT PANEL LIKE "login" or "create" */ 

    public void showPanel(String name) {
        cardLayout.show(cardPanel, name);
    }
}

  


    

