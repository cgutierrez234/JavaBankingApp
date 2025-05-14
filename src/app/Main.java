package app;

import javax.swing.SwingUtilities;

import app.gui.BankingGui;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankingGui());
    }
    
}
