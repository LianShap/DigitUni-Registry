package ua.university.repository.student;

import ua.university.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryStudentRepository implements StudentRepository {

    private final List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        students.removeIf(s -> s.getId().equals(student.getId())); // replace if exists
        students.add(student);
    }

    @Override
    public void delete(Student student) {
        students.removeIf(s -> s.getId().equals(student.getId()));
    }

    @Override
    public Optional<Student> findById(String id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }
}
