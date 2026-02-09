package ua.university.repository.student;

import ua.university.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// In-memory реалізація
public class InMemoryStudentRepository implements StudentRepository {

    private final List<Student> students = new ArrayList<>();

    @Override
    public List<Student> findAll() {
        return List.copyOf(students);
    }

    @Override
    public Optional<Student> findById(String id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    @Override
    public void save(Student student) {
        deleteById(student.getId());
        students.add(student);
    }

    @Override
    public void deleteById(String id) {
        students.removeIf(s -> s.getId().equals(id));
    }
}