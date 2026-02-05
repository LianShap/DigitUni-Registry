package ua.university.ui;

import ua.university.repository.student.StudentRepository;
import ua.university.service.StudentService;
import ua.university.util.ILogger;
import java.util.Scanner;

public class MainMenu {
    private final StudentMenu studentMenu;

    public MainMenu(ILogger logger) {
        Scanner scanner = new Scanner(System.in);

        StudentRepository repository = new StudentRepository();
        StudentService studentService = new StudentService(repository);

        this.studentMenu = new StudentMenu(studentService, logger, scanner);
    }

    public void run() {
        studentMenu.findStudentsByCourse();
    }
}
