package service;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductServiceORM implements IProductService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        String query = "SELECT c FROM Product AS c";
        TypedQuery<Product> query1 = entityManager.createQuery(query, Product.class);
        return query1.getResultList();
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean create(Product product) {
        return false;
    }

    @Override
    public boolean save(Product product, int id) {
        return false;
    }

    @Override
    public void remove(int id) {

    }
}
