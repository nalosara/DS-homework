package main.java.homework1;

public class Entry implements Comparable<Entry> {
    private String name;
    private String street_address;
    private String city;
    private String postcode;
    private String country;
    private String phone_number;

    public Entry(String name, String street_address, String city, String postcode, String country, String phone_number){
        this.name = name;
        this.street_address = street_address;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return street_address;
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
        return phone_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
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

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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
}
