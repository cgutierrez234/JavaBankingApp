package app;

public class CheckingAccount extends Account {
    
    private static final double overDraftLimit = 100;
    private static final double overdraftFee = 35;
    private static final double amountToUnlockAcct = 25;
    private double negativeBalance;
    
    //Constructor

    public CheckingAccount(String accountNumber, String accountOwner, double balance, boolean blockedFromWithdrawal) {
    
        super(accountNumber, accountOwner, balance, blockedFromWithdrawal);
    }

    /*--------------------------------------------------------------------------------
                                       METHODS
    --------------------------------------------------------------------------------*/

    /*
     * Handles withdrawals for CheckingAccount, including overdraft and lockout rules.
     *
     * - Calculates a projected balance based on the withdrawal amount.
     * - If the account is currently locked, notifies the user and exits early.
     * - If the withdrawal causes the balance to go negative but remains within the allowed overdraft limit,
     *   applies a $35 overdraft fee and adjusts the balance accordingly.
     * - If the withdrawal exceeds the overdraft limit:
     *   - Locks the account
     *   - Tracks the negative balance (as a positive value internally)
     *   - Notifies the user of the lockout and their current negative balance
     * - If the withdrawal is valid and does not trigger any overdraft rules, it processes normally.
     */

    @Override
    public void withdraw(double amount) {

        validateAmount(amount);

        double projectedBalance = getBalance() - amount;

        if(getBlockedFromWithdrawal()) {
            System.out.println("Currently, your account has been locked from withdrawals. Your current negative balance is " + String.format("%.2f", -negativeBalance) + 
            ". Please reconcile your account to the amount of $25 to unlock the withdrawal feature. Thank you.");
            return;
        }
            if(projectedBalance < 0 && projectedBalance >= -overDraftLimit) {
               setBalance(projectedBalance - overdraftFee); // <---- this applies the overdraft fee
            } else if(projectedBalance < -overDraftLimit) {
                setBlockedFromWithdrawal(true);
                this.negativeBalance = Math.abs(projectedBalance);
                System.out.println("Your account has been locked due to exceeding your overdraft limit. Your current balance is " +
                String.format("%.2f", negativeBalance) + ". Bring your account to at least $25 to unlock it. Thank you.");
            } else {
                setBalance(projectedBalance); // This is the simple withdrawal
            }
        }
    
    /*
    * Handles deposits for a CheckingAccount with overdraft rules.
    *
    * - First, validates that the deposit amount is positive; throws an error if not.
    * - Then calculates the new balance by adding the deposit to the current balance.
    * - If the new balance meets or exceeds the unlock threshold ($25), it:
    *   - Unlocks the account
    *   - Resets the tracked negative balance to 0
    *   - Notifies the customer of successful unlocking
    * - If the new balance is still below the unlock threshold:
    *   - Reduces the tracked negative balance by the deposit (note: negativeBalance is stored as a positive value)
    *   - Keeps the account locked
    *   - Notifies the customer that further deposits are needed to unlock the account
    */

    @Override
    public void deposit(double amount) {
        
        validateAmount(amount);

        double newBalance = getBalance() + amount;
        setBalance(newBalance);

        if(newBalance >= amountToUnlockAcct) {
            System.out.println("Your account balance is now " + String.format("%.2f", newBalance) + ". Your account has been unlocked. Thank you.");
            setBlockedFromWithdrawal(false);
            negativeBalance = 0;
        } else {
            negativeBalance = Math.max(0, negativeBalance - amount);
            System.out.println("Thank you for your deposit. However, your balance remains below the $25 minimum required to unlock withdrawals. Please deposit funds to reach the minimum. Your current balance is " +
            String.format("%.2f", newBalance) + ".");
            setBlockedFromWithdrawal(true);
        }
    }   

    @Override
    public String getAccountDetails() {
        String status = getBlockedFromWithdrawal() ? "Account Locked(Overdraft Exceeded)" : "Active";
        return "Account Number: " + getAccountNumber() +
               "\nOwner: " + getAccountOwner() +
               "\nBalance: $" + String.format("%.2f", getBalance()) +
               "\nAccount Status: " + status;
    }
}
