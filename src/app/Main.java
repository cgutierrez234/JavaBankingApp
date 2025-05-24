package app;

import javax.swing.SwingUtilities;

import app.gui.BankingGuiMainPanel;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankingGuiMainPanel());
    }
    
}
