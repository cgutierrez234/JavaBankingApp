package app;

public class CheckingAccount extends Account {
    
    private static final double overDraftLimit = 100;
    private static final double overdraftFee = 35;
    private static final double amountToUnlockAcct = 25;
    private double negativeBalance;
    
    //Constructor

    public CheckingAccount(String accountNumber, String accountOwner, double balance, boolean isStudent, boolean blockedFromWithdrawal) {
    
        super(accountNumber, accountOwner, balance, isStudent, blockedFromWithdrawal);
    }

    //METHODS

    // Override withdraw to fit CheckingAccount's needs


    /*  This method sets projectedBalance which will be the current balance minus the withdraw amount. Checks to see if the customer is locked out of their account for reaching their overdraft
        limit. If they are, it let's them know that they are and exits out of withdraw. If their balance is less than zero but higher than the overdraft limit, it applies an overdraft fee of $35.
        Finally if it is a normal withdraw, it subtracts the amount and moves on. */

    @Override
    public void withdraw(double amount) {

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

    public void deposit(double amount) {
        double newBalance = getBalance() + amount;
        setBalance(newBalance);

        if(amount <= 0) {
            throw new IllegalArgumentException("Your deposit must be a dollar amount above 0.");
        }

        if(newBalance >= amountToUnlockAcct) {
            System.out.println("Your account balance is now " + String.format("%.2f", newBalance) + ". Your account has been unlocked. Thank you.");
            setBlockedFromWithdrawal(false);
            negativeBalance = 0;
        } else {
            negativeBalance = Math.max(0, negativeBalance - amount);
            System.out.println("Thank you for your deposit. However, your balance remains below the $25 minimum required to unlock withdrawals. Please deposit funds to reach the minimum. Your current balance is " +
            negativeBalance + ".");
            setBlockedFromWithdrawal(true);
        }
    }
    
}
