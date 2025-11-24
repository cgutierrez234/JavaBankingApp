package app.user;

// Import the Account class to be able to create new Accounts for users
import app.account.Account;

public class User {


    private String email;
    private String password;
    private String accountType;
    private double openingDeposit;

    // Constructor for new User instance

    public User (String email, String password, String accountType, double openingDeposit) {
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.openingDeposit = openingDeposit;
    }

    // Getters
    public String getUserEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAccount() {
        return accountType;
    }

    // TODO - - - add setters for eventual account information updating. For now it isn't neccessary !

    // OVerride toString for the logs and the teehees
    
    @Override

    public String toString() {
        return "User {" + 
                "username = " + email + '\'' +
                ", account = " + (accountType != null ? accountType : "null") +
                '}';
    }
}

