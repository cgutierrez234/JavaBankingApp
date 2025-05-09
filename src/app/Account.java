package app;

public abstract class Account {

    private String accountNumber;
    private String accountOwner;
    private double balance;
    private boolean isStudent;
    private boolean blockedFromWithdrawal;

    // Constructor
    public Account(String accountNumber, String accountOwner, double balance, boolean isStudent, boolean blockedFromWithdrawal) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.balance = balance;
        this.isStudent = isStudent;
        this.blockedFromWithdrawal = blockedFromWithdrawal;
    }

    /*--------------------------------------------------------------------------------
                                       GETTERS
    --------------------------------------------------------------------------------*/

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public boolean getIsStudent() {
        return isStudent;
    }

    public boolean getBlockedFromWithdrawal() {
        return blockedFromWithdrawal;
    }

    /*--------------------------------------------------------------------------------
                                       SETTERS
    --------------------------------------------------------------------------------*/

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBlockedFromWithdrawal(boolean blockedFromWithdrawal) {
        this.blockedFromWithdrawal = blockedFromWithdrawal;
    }

    /*--------------------------------------------------------------------------------
                                       METHODS
    --------------------------------------------------------------------------------*/

    public void deposit(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        } 
        double newBalance = getBalance() + amount;
        setBalance(newBalance);
        System.out.println("Deposit successful. New balance: $" + String.format("%.2f", newBalance));
    }

    public String getAccountDetails() {
        return "Account Number: " + accountNumber +
               "\nOwner: " + accountOwner +
               "\nBalance: $" + String.format("%.2f", balance) +
               "\nStudent Account: " + (isStudent ? "Yes" : "No");
    }

    /*--------------------------------------------------------------------------------
                                      ABSTRACT METHODS
    --------------------------------------------------------------------------------*/
    
    public abstract void withdraw(double amount); 
    
}
