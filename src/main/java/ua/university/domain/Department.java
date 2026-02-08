package ua.university.domain;

public class Department {

    private String code;
    private String name;
    private Faculty faculty;
    private Teacher head;
    private String location;

    public Department(String code, String name, Faculty faculty,
                      Teacher head, String location) {
        this.code = code;
        this.name = name;
        this.faculty = faculty;
        this.head = head;
        this.location = location;
    }
}
