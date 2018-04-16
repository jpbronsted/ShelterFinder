package model;

/**
 * Created by jpbronsted on 2/26/18.
 */

public enum AccountType {
    USER("User"), ADMIN("Admin");

    String abbr = "";
    AccountType(String abbr) {
        this.abbr = abbr;
    }

    public String toString() {return this.abbr;}
}
