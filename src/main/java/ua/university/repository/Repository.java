package ua.university.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    void save(T entity);
    void delete(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
}
