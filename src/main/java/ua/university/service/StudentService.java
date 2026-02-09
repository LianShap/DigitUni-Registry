package ua.university.service;

import ua.university.domain.Student;
import ua.university.repository.student.StudentRepository;
import java.util.Comparator;
import java.util.List;

/**
 * Сервісний клас для роботи зі студентами.
 * <p>
 * Містить бізнес-логіку пошуку та формування звітів.Використовує Stream API
 * Не залежить від конкретного способу зберігання даних.
 * </p>
 */

public class StudentService {

    private final StudentRepository repository;
    /**
     * Створює сервіс студентів.
     * @param repository репозиторій студентів
     */
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // ===== SEARCH =====

    /**
     * Пошук студентів за повним іменем (часткове співпадіння).
     * @param query рядок для пошуку
     * @return список студентів, що відповідають запиту
     */
    public List<Student> findByFullName(String query) {
        return repository.findAll().stream()
                .filter(s -> s.getFullName()
                        .toLowerCase()
                        .contains(query.toLowerCase()))
                .toList();
    }

    /**
     * Пошук студентів за курсом.
     * @param course номер курсу
     * @return список студентів вказаного курсу
     */
    public List<Student> findByCourse(int course) {
        return repository.findAll().stream()
                .filter(s -> s.getCourse() == course)
                .toList();
    }

    /**
     * Пошук студентів за групою.
     * @param group назва групи
     * @return список студентів цієї групи
     */
    public List<Student> findByGroup(String group) {
        return repository.findAll().stream()
                .filter(s -> s.getGroup().equalsIgnoreCase(group))
                .toList();
    }

    // ===== REPORTS =====

    /**
     * Формує список усіх студентів, відсортований за курсом.
     * @return відсортований список студентів
     */
    public List<Student> getStudentsSortedByCourse() {
        return repository.findAll().stream()
                .sorted(Comparator.comparingInt(Student::getCourse))
                .toList();
    }

    /**
     * Формує список усіх студентів, відсортований за алфавітом.
     * @return відсортований список студентів
     */
    public List<Student> getStudentsSortedByName() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Student::getLastName)
                        .thenComparing(Student::getFirstName))
                .toList();
    }
}
