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

    // Getters

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

    // Setters

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBlockedFromWithdrawal(boolean blockedFromWithdrawal) {
        this.blockedFromWithdrawal = blockedFromWithdrawal;
    }

    // METHODS . . . . . 

    // Regular methods. Deposit 

    public void deposit(double amount) {
        if(balance > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public String getAccountDetails() {
        return "Account Number: " + accountNumber +
               "\nOwner: " + accountOwner +
               "\nBalance: $" + String.format("%.2f", balance) +
               "\nStudent Account: " + (isStudent ? "Yes" : "No");
    }

    // Abstract methods like withdraw. Not all account types withdraw the same way so this will need to be overridden
    
    public abstract void withdraw(double amount); 
    
}
