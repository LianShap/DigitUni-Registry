package ua.university.domain;

public class Faculty {
    private String code;
    private String name;
    private String shortName;
    private Teacher dean;
    private String contacts;

    public Faculty(String code, String name, String shortName,
                   Teacher dean, String contacts) {
        this.code = code;
        this.name = name;
        this.shortName = shortName;
        this.dean = dean;
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }
}
