package service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    T findById(int id);
    boolean create(T t);
    boolean save(T t, int id);
    void remove(int id);
}
