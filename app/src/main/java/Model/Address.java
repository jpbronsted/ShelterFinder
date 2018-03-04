package Model;

/**
 * Created by jpbronsted on 3/4/18.
 */

public class Address {
    private String streetName;
    private Integer streetNumber;
    private String city;
    private State state;
    private Integer zipCode;

    public Address(String streetName, Integer streetNumber, String city,
                   State state, Integer zipCode) {
        if (streetNumber < 0) {
            // TODO: throw an exception for a bad street number input
        }
        if (zipCode.toString().length() != 5) {
            // TODO: throw an exception for a bad zipcode input
        }
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(String streetName, Integer streetNumber, String city,
                   String state, Integer zipCode) {
        this(streetName, streetNumber, city, State.ERROR, zipCode);
        State enumState = null;
        switch (state) {
            case "Alabama":
            case "AL":
                enumState = State.ALABAMA;
                break;
            case "Alaska":
            case "AK":
                enumState = State.ALASKA;
                break;
            case "Arizona":
            case "AZ":
                enumState = State.ARIZONA;
                break;
            case "Arkansas":
            case "AR":
                enumState = State.ARKANSAS;
                break;
            case "California":
            case "CA":
                enumState = State.CALIFORNIA;
                break;
            case "Colorado":
            case "CO":
                enumState = State.COLORADO;
                break;
            case "Connecticut":
            case "CT":
                enumState = State.CONNECTICUT;
                break;
            case "Delaware":
            case "DE":
                enumState = State.DELAWARE;
                break;
            case "Florida":
            case "FL":
                enumState = State.FLORIDA;
                break;
            case "Georgia":
            case "GA":
                enumState = State.GEORGIA;
                break;
            case "Hawaii":
            case "HI":
                enumState = State.HAWAII;
                break;
            case "Idaho":
            case "ID":
                enumState = State.IDAHO;
                break;
            case "Illinois":
            case "IL":
                enumState = State.ILLINOIS;
                break;
            case "Indiana":
            case "IN":
                enumState = State.INDIANA;
                break;
            case "Iowa":
            case "IA":
                enumState = State.IOWA;
                break;
            case "Kansas":
            case "KS":
                enumState = State.KANSAS;
                break;
            case "Kentucky":
            case "KY":
                enumState = State.KENTUCKY;
                break;
            case "Louisiana":
            case "LA":
                enumState = State.LOUISIANA;
                break;
            case "Maine":
            case "ME":
                enumState = State.MAINE;
                break;
            case "Maryland":
            case "MD":
                enumState = State.MARYLAND;
                break;
            case "Massachusetts":
            case "MA":
                enumState = State.MASSACHUSETTS;
                break;
            case "Michigan":
            case "MI":
                enumState = State.MICHIGAN;
                break;
            case "Minnesota":
            case "MN":
                enumState = State.MINNESOTA;
                break;
            case "Mississippi":
            case "MS":
                enumState = State.MISSISSIPPI;
                break;
            case "Missouri":
            case "MO":
                enumState = State.MISSOURI;
                break;
            case "Montana":
            case "MT":
                enumState = State.MONTANA;
                break;
            case "Nebraska":
            case "NE":
                enumState = State.NEBRASKA;
                break;
            case "Nevada":
            case "NV":
                enumState = State.NEVADA;
                break;
            case "New Hampshire":
            case "NH":
                enumState = State.NEWHAMPSHIRE;
                break;
            case "New Jersey":
            case "NJ":
                enumState = State.NEWJERSEY;
                break;
            case "New Mexico":
            case "NM":
                enumState = State.NEWMEXICO;
                break;
            case "New York":
            case "NY":
                enumState = State.NEWYORK;
                break;
            case "North Carolina":
            case "NC":
                enumState = State.NORTHCAROLINA;
                break;
            case "North Dakota":
            case "ND":
                enumState = State.NORTHDAKOTA;
                break;
            case "Ohio":
            case "OH":
                enumState = State.OHIO;
                break;
            case "Oklahoma":
            case "OK":
                enumState = State.OKLAHOMA;
                break;
            case "Oregon":
            case "OR":
                enumState = State.OREGON;
                break;
            case "Pennsylvania":
            case "PA":
                enumState = State.PENNSYLVANIA;
                break;
            case "Rhode Island":
            case "RI":
                enumState = State.RHODEISLAND;
                break;
            case "South Carolina":
            case "SC":
                enumState = State.SOUTHCAROLINA;
                break;
            case "South Dakota":
            case "SD":
                enumState = State.SOUTHDAKOTA;
                break;
            case "Tennessee":
            case "TN":
                enumState = State.TENNESSEE;
                break;
            case "Texas":
            case "TX":
                enumState = State.TEXAS;
                break;
            case "Utah":
            case "UT":
                enumState = State.UTAH;
                break;
            case "Vermont":
            case "VT":
                enumState = State.VERMONT;
                break;
            case "Virginia":
            case "VA":
                enumState = State.VIRGINIA;
                break;
            case "Washington":
            case "WA":
                enumState = State.WASHINGTON;
                break;
            case "West Virginia":
            case "WV":
                enumState = State.WESTVIRGINIA;
                break;
            case "Wisconsin":
            case "WI":
                enumState = State.WISCONSIN;
                break;
            case "Wyoming":
            case "WY":
                enumState = State.WYOMING;
                break;
            case "District of Columbia":
            case "DC":
                enumState = State.DISTRICTOFCOLUMBIA;
                break;
            default:
                // TODO: throw an exception for bad state input
        }
        this.state = enumState;
    }

    @Override
    public String toString() {
        return streetNumber + streetName + "\n" + city
                + state.getAbbreviation() + zipCode;
    }
}
