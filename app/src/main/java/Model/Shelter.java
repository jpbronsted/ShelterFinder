package Model;

import java.util.HashMap;

/**
 * Created by jpbronsted on 3/4/18.
 */

public class Shelter {
    private String name;
    private PhoneNumber phoneNumber;
    private Address address;
    private Integer capacity;
    private Double latitude;
    private Double longitude;
    private String restrictions;

    public static HashMap<String, Shelter> shelterData = new HashMap<String, Shelter>();

    public Shelter(String name, PhoneNumber phoneNumber, Address address,
                   Integer capacity, Double latitude, Double longitude,
                   String restrictions) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.capacity = capacity;
        this.latitude = latitude;
        this.longitude = longitude;
        this.restrictions = restrictions;
    }

    public Shelter() {
        this("", null, null, 0, 0.0, 0.0, "");
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public Address getAddress() {
        return address;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

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
}
