package app;

import java.time.LocalDate;

public class CDAccount extends Account {

    private LocalDate startDate;
    private LocalDate maturityDate;
    private final int termInMonths = 6;
    private final double interestRate = .045;
    private final int earlyWithdrawalFee = 500;
    private boolean isMatured;
    private boolean interestApplied; 

    //CONSTRUCTOR
    public CDAccount(String accountNumber, String accountOwner, double balance, boolean blockedFromWithdrawal) {
        super(accountNumber, accountOwner, balance, blockedFromWithdrawal);
        this.startDate = LocalDate.now();
        this.maturityDate = startDate.plusMonths(termInMonths);
        this.isMatured = false;
    }

    /*--------------------------------------------------------------------------------
                                       METHODS
    --------------------------------------------------------------------------------*/

    /*
     * Applies interest to the CD account if it has matured and interest has not already been applied.
     * The interest is calculated using the fixed interest rate and added to the current balance.
     * Once applied, a flag prevents the interest from being applied again.
     * Prints confirmation or a message if the interest cannot be applied.
     */

    private void applyInterest() {
        if(isMatured && interestApplied == false) {
        double earnedInterest = getBalance() *  interestRate;
        double newBalance = getBalance() + earnedInterest;
        setBalance(newBalance);
        interestApplied = true;
        System.out.println("Interest applied: $" + String.format("%.2f", earnedInterest));
        } else if(interestApplied) {
            System.out.println("The interest has already been applied to this CD");
        } else {
            System.out.println("The CD has not matured yet. Interest cannot be applied");
        }
    }
    
    /*
     * Checks if the CD has reached or passed its maturity date.
     * If so, sets the isMatured flag to true.
     * This should be called before allowing withdrawals or applying interest.
     */

    public void checkIfMatured() {
        if(LocalDate.now().isAfter(maturityDate) || LocalDate.now().isEqual(maturityDate)) {
            isMatured = true;
        }
    }

    /*
     * Handles the withdrawal process for the CD account.
     * 
     * - If the account has not matured, prints a warning message and exits early.
     * - If the account has matured:
     *   - Applies interest if it hasn't been applied yet.
     *   - Validates that the withdrawal amount does not exceed the balance.
     *   - Deducts the requested amount from the balance and confirms the transaction.
     * 
     * Leaves room for GUI integration to confirm early withdrawals.
     *
     * @param amount The amount the customer wishes to withdraw.
     */

    @Override
    public void withdraw(double amount) {
        double balance = getBalance();

        validateAmount(amount);

        checkIfMatured();

        if(!isMatured) {
            System.out.println("Your CD isn't quite ready to withdraw from. However if you choose to, you may make a withdrawal that will include a fee of: $" + earlyWithdrawalFee);
            // In the GUI a JOptionPane will present the customer with the yes no option for this transaction
        } else if(amount + earlyWithdrawalFee > balance) {
            System.out.println("Your request for transaction plus the early withdrawal fee exceed your balance. Request denied.");
            return;
        } else {
            System.out.println("Your CD has matured and is ready for withdrawal!");
            //In the GUI the user will receive a prompt providing their current balance and what they wish to withdrawl.
            applyInterest();
            System.out.println("How much would you like to withdraw?");
            // Here the field where the customer enters the amount to withdraw will be captured
            setBalance(balance - amount);
            System.out.println("Withdrawal successful. Your remaining balance is: " + getBalance()); 
        }
    }

    @Override
    public String getAccountDetails() {
        return "Account Number: " + getAccountNumber() +
               "\nOwner: " + getAccountOwner() +
               "\nBalance: $" + String.format("%.2f", getBalance()) +
               "\nAccount Status: " + (isMatured ? "Matured" : "Not Matured");
    }
}
