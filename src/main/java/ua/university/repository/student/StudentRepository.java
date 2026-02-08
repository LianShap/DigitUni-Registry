package ua.university.repository.student;

public class StudentRepository {
import ua.university.domain.Student;
import ua.university.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements Repository<Student> {
    private final List<Student> students = new ArrayList<>();

    @Override
    public List<Student> findAll() {
        return List.copyOf(students);
    }
    // TODO: expand repository with save/delete methods in next stage
