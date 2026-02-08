package ua.university.domain;

public class University {

    private String fullName;
    private String shortName;
    private String city;
    private String address;

    public University(String fullName, String shortName, String city, String address) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.city = city;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }
}
