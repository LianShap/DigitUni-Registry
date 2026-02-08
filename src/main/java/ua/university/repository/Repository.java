package ua.university.repository;

public class Repository {
}
import java.util.List;

public interface Repository<T> {

    List<T> findAll();

}
