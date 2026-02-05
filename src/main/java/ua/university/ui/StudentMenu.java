package ua.university.ui;

import ua.university.domain.Student;
import ua.university.repository.student.StudentRepository;
import ua.university.service.StudentService;
import ua.university.util.ILogger;
import ua.university.util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class StudentMenu {

    private final StudentService studentService;
    private final ILogger logger;
    private final Scanner scanner;

    public StudentMenu(StudentService studentService, ILogger logger, Scanner scanner) {
        this.studentService = studentService;
        this.logger = logger;
        this.scanner = scanner;
    }

    public void findStudentsByCourse() {
        int course = InputValidator.readCourse(scanner);
        List<Student> result = studentService.findByCourse(course);
        logger.logStudents(result);
    }
}
