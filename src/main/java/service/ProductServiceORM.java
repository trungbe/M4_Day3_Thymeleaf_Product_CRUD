package service;

import model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProductServiceORM implements IProductService {

    @PersistenceContext
    private EntityManager entityManager;
//    @Autowired
//    private EntityManager entityManager;
//    @Autowired
//    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAll() {
        String query = "SELECT p FROM Product AS p";
        TypedQuery<Product> queryFind = entityManager.createQuery(query, Product.class);
        return queryFind.getResultList();
    }

    @Override
    public Product findById(Integer id) {
        String queryStr = "SELECT c FROM Product AS c WHERE c.id = :id";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Product update(Product model) {
//        Session session = null;
//        Transaction transaction = null;
//        try {
//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.update(model);
//            transaction.commit();
//            return model;
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
        if (model.getId() != 0)
            entityManager.merge(model);//sua
        return null;
    }

    @Override
    public Product save(Product model) {
        if (model.getId() != 0) {
            entityManager.merge(model);//sua
        } else
            entityManager.persist(model);//them
        return null;
    }

//    @Override
//    public Product save(Product model) {
////        Session session = null;
////        Transaction transaction = null;
////        try {
////            session = sessionFactory.openSession();
////            transaction = session.beginTransaction();
////            session.save(model);
////            transaction.commit();
////            return model;
////        } catch (Exception e) {
////            e.printStackTrace();
////            if (transaction != null) {
////                transaction.rollback();
////            }
////        } finally {
////            if (session != null) {
////                session.close();
////            }
////        }
//
//        return null;
//
//
//    }

    @Override
    public void remove(Integer id) {
        Product product = findById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}



