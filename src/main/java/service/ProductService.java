//package service;
//
//import model.Product;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ProductService implements IProductService {
//    private static Map<Integer, Product> list = new HashMap<>();
//
//    static {
//        list.put(1,new Product(1, "kho ga", "vn"));
//        list.put(2,new Product(2, "kho bo", "qn"));
//
//    }
//
//    @Override
//    public List findAll() {
//        return new ArrayList<>(list.values());
//    }
//
//    @Override
//    public Product findById(int id) {
//        return list.get(id);
//    }
//
//    @Override
//    public boolean create(Product p) {
//        list.put(p.getId(), p);
//        return false;
//    }
//
//
//    @Override
//    public boolean save(Product p, int id) {
//        list.put(id, p);
//        return false;
//    }
//
//    @Override
//    public void remove(int id) {
//        list.remove(id);
//    }
//
//
//}
