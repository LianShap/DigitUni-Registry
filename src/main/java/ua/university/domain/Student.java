package ua.university.domain;
import ua.university.domain.enums.StudentStatus;
import ua.university.domain.enums.StudyForm;

import java.time.LocalDate;

public class Student extends Person {
    private final String studentId;
    private int course;
    private String group;
    private final int entryYear;
    private StudyForm studyForm;
    private StudentStatus status;

    public Student(String id, String lastName, String firstName, String middleName,
                   LocalDate birthDate, String email, String phone,
                   String studentId, int course, String group,
                   int entryYear, StudyForm studyForm, StudentStatus status) {

        super(id, lastName, firstName, middleName, birthDate, email, phone);
        this.studentId = studentId;
        this.course = course;
        this.group = group;
        this.entryYear = entryYear;
        this.studyForm = studyForm;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public int getEntryYear() {
        return entryYear;
    }

    public StudyForm getStudyForm() {
        return studyForm;
    }

    public StudentStatus getStatus() {
        return status;
    }                                                                                                                                           public void setCourse(int course) {
        if (course < 1 || course > 6) {
            throw new IllegalArgumentException("Course must be between 1 and 6");
        }
        this.course = course;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setStudyForm(StudyForm studyForm) {
        this.studyForm = studyForm;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }
}
