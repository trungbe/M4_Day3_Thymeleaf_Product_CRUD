package service;

import model.Product;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(Integer id);

    T update(T model);

    T save(T model);

//    T remove(T model);
    void remove(Integer id);

    List<Product> findByName(String name);
}
