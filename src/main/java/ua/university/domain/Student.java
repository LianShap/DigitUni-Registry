package ua.university.domain;
import ua.university.domain.enums.StudentStatus;
import ua.university.domain.enums.StudyForm;
import java.time.LocalDate;
import java.util.Objects;

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

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public String getStudentId() {
        return studentId;
    }

    public StudentStatus getStatus() {
        return status;
    }                                                                                                                                           public void setCourse(int course) {
        if (course < 1 || course > 6) {
            throw new IllegalArgumentException("Course must be between 1 and 6");
        }
        this.course = course;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return group == student.group &&
                entryYear == student.entryYear&&
                Objects.equals(studyForm, student.studyForm) &&
                Objects.equals(status, student.status);
    }

    @Override
    public String toString() {
        return "Student{" +
                ", studentId=" + studentId +
                ", course=" + course +
                ", group=" + group +
                ", entryYear=" + entryYear +
                ", studyForm=" + studyForm +
                ", status=" + status;
    }
}