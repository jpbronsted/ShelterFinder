package model;


public enum AccountType {
    USER("User"), ADMIN("Admin");

    String abbr;
    AccountType(String abbr) {
        this.abbr = abbr;
    }

    public String toString() {return this.abbr;}
}
