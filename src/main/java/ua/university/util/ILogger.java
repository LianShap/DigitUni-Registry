package ua.university.util;

import ua.university.domain.Student;

import java.util.List;

public interface ILogger {
     void logStudents(List<Student> students);
     void info(String message);
}
