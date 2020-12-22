package ru.geekbrains.hibernate.app2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDAO {
    private GlobalSessionFactory globalSessionFactory;
    private Session session;
    private Transaction transaction;

    public ProductDAO(GlobalSessionFactory factory) {
        this.globalSessionFactory = factory;
    }

    public Session openSession() {
        session = globalSessionFactory.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession() {
        transaction.commit();
        session.close();
    }

    public Product findById(Long id) {
        return session.get(Product.class, id);
    }

    public List<Product> findAll() {
        return (List<Product>) session.createQuery("select p from Product p").getResultList();
    }

    public void deleteById(Long id) {
        session.createQuery("delete from Product p where p.id = :id");
    }

    public Product saveOrUpdate(Product product) {
        session.saveOrUpdate(product);
        return product;
    }
}