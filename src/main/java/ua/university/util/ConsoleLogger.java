package ua.university.util;

import ua.university.domain.Student;

import java.util.List;

public class ConsoleLogger implements ILogger{

    public void logStudents(List<Student> students) {
        students.forEach(s ->
                System.out.println(s.getFullName() + " | курс " + s.getCourse())
        );
    }
}
