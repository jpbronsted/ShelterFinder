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
    private GenderRestriction genderRestriction;

    private static HashMap<String, Shelter> shelterData;

    public Shelter(String name, PhoneNumber phoneNumber, Address address,
                   Integer capacity, Double latitude, Double longitude,
                   GenderRestriction genderRestriction) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.capacity = capacity;
        this.latitude = latitude;
        this.longitude = longitude;
        this.genderRestriction = genderRestriction;
    }

    public Shelter() {
        this("", null, null, 0, 0.0, 0.0, null);
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

    public void setGenderRestriction(GenderRestriction genderRestriction) {
        this.genderRestriction = genderRestriction;
    }

    public Address getAddress() {
        return address;
    }

    public GenderRestriction getGenderRestriction() {
        return genderRestriction;
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
}
