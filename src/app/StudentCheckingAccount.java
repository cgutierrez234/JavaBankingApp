package app;

public class StudentCheckingAccount extends CheckingAccount {
    

    // CONSTRUCTOR
    public StudentCheckingAccount(String accountNumber, String accountOwner, double balance, boolean blockedFromWithdrawal) {
        super(accountNumber, accountOwner, balance, blockedFromWithdrawal);
    }

    /*--------------------------------------------------------------------------------
                                       METHODS
    --------------------------------------------------------------------------------*/

/*
 * Overrides the withdraw method to enforce student-specific restrictions.
 *
 * - Validates that the withdrawal amount is positive and in valid increments.
 * - Denies the withdrawal if the amount exceeds the current balance,
 *   as student accounts do not support overdraft.
 * - If the withdrawal is valid, subtracts the amount from the balance and
 *   prints the updated balance.
 *
 * This implementation ensures that StudentCheckingAccount maintains
 * stricter withdrawal policies compared to standard checking accounts.
 */

    @Override 
    public void withdraw(double amount) {
        
        validateAmount(amount);

        if(getBalance() < amount) {
            System.out.println("Withdrawal denied: Insufficient funds. You may not incur overdraft fees with your Student checking Account");
            return;
        } 

        double currentBalance = getBalance() - amount;
        setBalance(currentBalance);
        System.out.println("Withdrawal successful. Your current balance is: " + currentBalance);
    }

 /*
 * This class inherits the deposit method from the Account superclass without modification.
 * StudentCheckingAccount does not override deposit behavior, as student accounts follow 
 * the same deposit rules as standard accounts.
 */
}


