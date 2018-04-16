package model;

import java.util.HashMap;
import java.util.Map;


public class Shelter {
    private String name, phoneNumber, address, capacity, restrictions;
    private Double latitude, longitude;

    public static final Map<String, Shelter> shelterData = new HashMap<>();

    public Shelter(String name, String phoneNumber, String address,
                   String capacity, Double latitude, Double longitude,
                   String restrictions) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.capacity = capacity;
        this.latitude = latitude;
        this.longitude = longitude;
        this.restrictions = restrictions;
    }

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//    public Shelter() {
//        this("", null, null, null, 0.0, 0.0, "");
//    }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//    public void setAddress(String address) {
//        this.address = address;
//    }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//    public void setLatitude(Double latitude) {
//        this.latitude = latitude;
//    }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//    public void setLongitude(Double longitude) {
//        this.longitude = longitude;
//    }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//    public void setRestrictions(String restrictions) {
//        this.restrictions = restrictions;
//    }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//    public String getAddress() {
//        return address;
//    }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)

    public String getRestrictions() {
        return restrictions;
    }

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//    public Double getLatitude() {
//        return latitude;
//    }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//    public Double getLongitude() {
//        return longitude;
//    }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)

    public String getCapacity() {
        return capacity;
    }

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Capacity: " + capacity + "\n"
                + "Latitude :" + latitude + "\n" + "Longitude: "
                + longitude + "\n" + "Restrictions: " + restrictions
                + "\n" + "Phone Number: " + phoneNumber + "\n"
                + "Address: " + "\n" + address + "\n\n";
    }

    public static Shelter[] toArray() {
        Shelter[] shelterArray = new Shelter[shelterData.size()];
        int i = 0;
        for (Shelter shelter : shelterData.values()) {
            shelterArray[i] = shelter;
            i++;
        }
        return shelterArray;
    }
}
