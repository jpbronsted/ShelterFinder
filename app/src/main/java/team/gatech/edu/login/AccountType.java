package team.gatech.edu.login;

/**
 * Created by jpbronsted on 2/26/18.
 */

public enum AccountType {
    USER("User"), ADMIN("Admin");

    String abbr;
    AccountType(String abbr) {
        this.abbr = abbr;
    }
}
