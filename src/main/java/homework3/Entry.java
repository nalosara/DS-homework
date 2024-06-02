package main.java.homework3;

public class Entry implements Comparable<Entry> {
    private String name;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Entry other) {
        String[] thisNameParts = this.name.split(", ");
        String[] otherNameParts = other.name.split(", ");

        int lastNameComparison = thisNameParts[0].compareTo(otherNameParts[0]);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        return thisNameParts[1].compareTo(otherNameParts[1]);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nStreet Address: " + streetAddress + "\nCity: " + city + "\nPostcode: " + postcode + "\nCountry: " + country + "\nPhone Number: " + phoneNumber;
    }
}
