package app.user;

import java.util.HashMap;

public class UserManager {

    private HashMap<String, User> users = new HashMap<>();

    //Constructor

    public UserManager() {
        users = new HashMap<>();
    }

    /*--------------------------------------------------------------------------------
                                       METHODS
    --------------------------------------------------------------------------------*/

    public boolean addUser( User user) {
        if(users.containsKey(user.getUserEmail())) {
            System.out.println("Sorry, that user already exists");
            return false;
        } else {
            users.put(user.getUserEmail(), user);
            return true;
        }
    }

    public User getUser(String email) {
        if(users.get(email) != null) {
            return users.get(email);
        } else {
            System.out.println("No user available to return");
            return null;
        }
    }    
}
