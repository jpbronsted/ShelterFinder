package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Shelter
 */
public class Shelter {
    private String name;
    private String phoneNumber;
    private String address;
    private String capacity;
    private String restrictions;
    private Double latitude;
    private Double longitude;

    public static final Map<String, Shelter> shelterData = new HashMap<>();

    /**
     * shelter constructor
     * @param name name
     * @param phoneNumber phoneNumber
     * @param address address
     * @param capacity capacity
     * @param latitude latitude
     * @param longitude longitude
     * @param restrictions restrictions
     */
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

    /**
     * null constructor
     */
    public Shelter() {
        this("", null, null, null, 0.0, 0.0, "");
    }

    /**
     * set address
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * set capacity
     * @param capacity capacity
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    /**
     * set latitude
     * @param latitude latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * set longitude
     * @param longitude longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * set name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set phone number
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * set restrictions
     * @param restrictions restrictions
     */
    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * get address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * get restrictions
     * @return restrictions
     */
    public String getRestrictions() {
        return restrictions;
    }

    /**
     * get latitude
     * @return latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * get longitude
     * @return longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * get capacity
     * @return capacity
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * get phone number
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * turn to string
     * @return string value
     */
    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Capacity: " + capacity + "\n"
                + "Latitude :" + latitude + "\n" + "Longitude: "
                + longitude + "\n" + "Restrictions: " + restrictions
                + "\n" + "Phone Number: " + phoneNumber + "\n"
                + "Address: " + "\n" + address + "\n\n";
    }

    /**
     * turn to array
     * @return array value
     */
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
