package ua.university.domain;
import java.time.LocalDate;

public abstract class Person {
    private String id;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String email;
    private String phone;

    protected Person(String id, String lastName, String firstName, String middleName,
                     LocalDate birthDate, String email, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }
    public String getId() {
        return id;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }
    @Override
    public String toString() {
        return getFullName() + ", email: " + email + ", phone: " + phone;
    }
}
