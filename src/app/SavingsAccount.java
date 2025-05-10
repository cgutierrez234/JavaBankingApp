package app;

import java.time.LocalDate;

public class SavingsAccount extends Account {

    private static final int withdrawalLimit = 3;
    private int withdrawalsThisMonth = 0;
    private LocalDate currentMonth = LocalDate.now().withDayOfMonth(1); //<-- This variable sets the overall check for the month. It is enduring

    // Constructor
    public SavingsAccount(String accountNumber, String accountOwner, double balance,boolean blockedFromWithdrawal) {
        super(accountNumber, accountOwner, balance, blockedFromWithdrawal);
    }

    /*--------------------------------------------------------------------------------
                                       METHODS
    --------------------------------------------------------------------------------*/

    /* 
    * The withdraw method for SavingsAccount enforces a monthly withdrawal limit.
    * 
    * - First, it validates that the withdrawal amount is positive.
    * - Then, it creates a temporary LocalDate 'now' set to the first day of the current month.
    *   This is compared to the persistent 'currentMonth'. If the month has changed,
    *   we reset 'withdrawalsThisMonth' and update 'currentMonth'.
    * 
    * - The method then checks if the user has exceeded the allowed monthly withdrawals.
    *   If so, it blocks the transaction and notifies the user.
    * 
    * - It also prevents overdrafts by verifying that the balance is sufficient.
    * 
    * - If all conditions are met, it subtracts the amount from the balance,
    *   increments the withdrawal count, and confirms the transaction.
    */

    @Override
    public void withdraw(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0 in increments of 20.");
        }

        // Set "now" to the first day of the month
        LocalDate now = LocalDate.now().withDayOfMonth(1);

        //If we have moved into a new month, reset the counter
        if(!currentMonth.equals(now)) {
            currentMonth = now;
            withdrawalsThisMonth = 0;
        }

        if(withdrawalsThisMonth >= withdrawalLimit) {
            System.out.println("Withdrawal denied: Monthly withdrawal limit of " + withdrawalLimit + " reached.");
            return;
        }

        if(getBalance() < amount) {
            System.out.println("Withdrawal denied: Insufficient funds. You may not incur overdraft fees with your Savings Account");
            return;
        }

        setBalance(getBalance() - amount);
        withdrawalsThisMonth++;
        System.out.println("Withdrawal successful. Remaining withdrawals this month " + (withdrawalLimit - withdrawalsThisMonth));
    }

    /*  SavingsAccount will use the exact same deposit function as the Account 
        class so there is no need to keep the code here. The extension of the 
        Account class is enough to access the method when needed.
    */

    @Override 
    public String getAccountDetails() {
        return "Account Number: " + getAccountNumber() +
               "\nOwner: " + getAccountOwner() +
               "\nBalance: $" + String.format("%.2f", getBalance()) +
               "\n\nWithdrawal limit: " + (withdrawalLimit) +
               "\nRemaining withdrawals this month: " +(withdrawalLimit - withdrawalsThisMonth);
    }
    

    
}
