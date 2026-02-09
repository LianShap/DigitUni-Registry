package ua.university.ui;

import ua.university.repository.student.InMemoryStudentRepository;
import ua.university.service.StudentService;
import ua.university.util.ILogger;
import java.util.Scanner;

/**
 * The main menu of the console application.
 * <p>
 * Responsible for initializing the main components:
 * repository, services and submenus.
 * </p>
 * Acts as an entry point for navigating between menus.
 */

public class MainMenu {
    private final StudentMenu studentMenu;

    /**
     * Створює головне меню та ініціалізує залежності.
     *
     * @param logger реалізація логування результатів (наприклад, у консоль)
     */

    public MainMenu(ILogger logger) {
        Scanner scanner = new Scanner(System.in);

        InMemoryStudentRepository repository = new InMemoryStudentRepository();
        StudentService studentService = new StudentService(repository);

        this.studentMenu = new StudentMenu(studentService, logger, scanner);
    }

    public void run() {
        studentMenu.findStudentsByCourse();
    }
}
