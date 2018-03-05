package Model;

/**
 * Created by jpbronsted on 3/4/18.
 */

public class Address {
    private String streetName;
    private Integer streetNumber;
    private String suite;
    private String city;
    private State state;
    private Integer zipCode;

    public Address(String streetName, Integer streetNumber, String suite,
                   String city, State state, Integer zipCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = state;
        this.suite = suite;
        this.zipCode = zipCode;
    }

    public Address(String address) {
        String[] parsedAddress = address.split(",");
        String streetName;
        String suite = "";
        Integer streetNumber;
        String city;
        String state;
        Integer zipCode;
        if (parsedAddress.length == 4) {
            suite = parsedAddress[1];
            city = parsedAddress[2];
            state = parsedAddress[3].substring(0,
                    parsedAddress[3].indexOf(' '));
            zipCode = Integer.valueOf(parsedAddress[3].substring(
                    parsedAddress[3].indexOf(' ')));
        } else {
            city = parsedAddress[1];
            state = parsedAddress[2].substring(0,
                    parsedAddress[2].indexOf(' '));
            zipCode = Integer.valueOf(parsedAddress[2].substring(
                    parsedAddress[2].indexOf(' ')));
        }
        streetNumber = Integer.valueOf(parsedAddress[0].substring(
                0, parsedAddress[0].indexOf(' ')));
        streetName = parsedAddress[0].substring(
                parsedAddress[0].indexOf(' ') + 1);
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = findState(state);
        this.suite = suite;
        this.zipCode = zipCode;
    }

    public Address(String streetName, Integer streetNumber, String suite,
                   String city, String state, Integer zipCode) {
        this(streetName, streetNumber, city, suite, State.ERROR, zipCode);
        this.state = findState(state);
    }

    @Override
    public String toString() {
        return streetNumber + streetName + "\n" + suite +
                (suite.equals("") ? "" : "\n") + city +
                state.getAbbreviation() + zipCode;
    }

    private State findState(String state) {
        switch (state) {
            case "Alabama":
            case "AL":
                return State.ALABAMA;
            case "Alaska":
            case "AK":
                return State.ALASKA;
            case "Arizona":
            case "AZ":
                return State.ARIZONA;
            case "Arkansas":
            case "AR":
                return State.ARKANSAS;
            case "California":
            case "CA":
                return State.CALIFORNIA;
            case "Colorado":
            case "CO":
                return State.COLORADO;
            case "Connecticut":
            case "CT":
                return State.CONNECTICUT;
            case "Delaware":
            case "DE":
                return State.DELAWARE;
            case "Florida":
            case "FL":
                return State.FLORIDA;
            case "Georgia":
            case "GA":
                return State.GEORGIA;
            case "Hawaii":
            case "HI":
                return State.HAWAII;
            case "Idaho":
            case "ID":
                return State.IDAHO;
            case "Illinois":
            case "IL":
                return State.ILLINOIS;
            case "Indiana":
            case "IN":
                return State.INDIANA;
            case "Iowa":
            case "IA":
                return State.IOWA;
            case "Kansas":
            case "KS":
                return State.KANSAS;
            case "Kentucky":
            case "KY":
                return State.KENTUCKY;
            case "Louisiana":
            case "LA":
                return State.LOUISIANA;
            case "Maine":
            case "ME":
                return State.MAINE;
            case "Maryland":
            case "MD":
                return State.MARYLAND;
            case "Massachusetts":
            case "MA":
                return State.MASSACHUSETTS;
            case "Michigan":
            case "MI":
                return State.MICHIGAN;
            case "Minnesota":
            case "MN":
                return State.MINNESOTA;
            case "Mississippi":
            case "MS":
                return State.MISSISSIPPI;
            case "Missouri":
            case "MO":
                return State.MISSOURI;
            case "Montana":
            case "MT":
                return State.MONTANA;
            case "Nebraska":
            case "NE":
                return State.NEBRASKA;
            case "Nevada":
            case "NV":
                return State.NEVADA;
            case "New Hampshire":
            case "NH":
                return State.NEWHAMPSHIRE;
            case "New Jersey":
            case "NJ":
                return State.NEWJERSEY;
            case "New Mexico":
            case "NM":
                return State.NEWMEXICO;
            case "New York":
            case "NY":
                return State.NEWYORK;
            case "North Carolina":
            case "NC":
                return State.NORTHCAROLINA;
            case "North Dakota":
            case "ND":
                return State.NORTHDAKOTA;
            case "Ohio":
            case "OH":
                return State.OHIO;
            case "Oklahoma":
            case "OK":
                return State.OKLAHOMA;
            case "Oregon":
            case "OR":
                return State.OREGON;
            case "Pennsylvania":
            case "PA":
                return State.PENNSYLVANIA;
            case "Rhode Island":
            case "RI":
                return State.RHODEISLAND;
            case "South Carolina":
            case "SC":
                return State.SOUTHCAROLINA;
            case "South Dakota":
            case "SD":
                return State.SOUTHDAKOTA;
            case "Tennessee":
            case "TN":
                return State.TENNESSEE;
            case "Texas":
            case "TX":
                return State.TEXAS;
            case "Utah":
            case "UT":
                return State.UTAH;
            case "Vermont":
            case "VT":
                return State.VERMONT;
            case "Virginia":
            case "VA":
                return State.VIRGINIA;
            case "Washington":
            case "WA":
                return State.WASHINGTON;
            case "West Virginia":
            case "WV":
                return State.WESTVIRGINIA;
            case "Wisconsin":
            case "WI":
                return State.WISCONSIN;
            case "Wyoming":
            case "WY":
                return State.WYOMING;
            case "District of Columbia":
            case "DC":
                return State.DISTRICTOFCOLUMBIA;
            default:
                return State.ERROR;
        }
    }
}
