package model;

/**
 * Defines Account Type
 */
public enum AccountType {
    USER("User"), ADMIN("Admin");

    final String abbr;
    AccountType(String abbr) {
        this.abbr = abbr;
    }

    public String toString() {return this.abbr;}
}
