package ru.geekbrains.hibernate.app2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuyerDAO {
    private GlobalSessionFactory globalSessionFactory;
    private Session session;
    private Transaction transaction;

    public BuyerDAO(GlobalSessionFactory globalSessionFactory) {
        this.globalSessionFactory = globalSessionFactory;
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

    public Buyer findById(Long id) {
        return session.get(Buyer.class, id);
    }

    public List<Buyer> findAll() {
        return (List<Buyer>) session.createQuery("select p from Buyer p").getResultList();
    }

    public void deleteById(Long id) {
        session.createQuery("delete from Buyer p where p.id = :id");
    }

    public Buyer saveOrUpdate(Buyer buyer) {
        session.saveOrUpdate(buyer);
        return buyer;
    }
}
