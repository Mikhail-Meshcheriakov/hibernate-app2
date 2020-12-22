package ru.geekbrains.hibernate.app2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Service {
    private ProductDAO productDAO;
    private BuyerDAO buyerDAO;

    public Service(ProductDAO productDAO, BuyerDAO buyerDAO) {
        this.productDAO = productDAO;
        this.buyerDAO = buyerDAO;
    }

    public List<Product> getProductsByBuyer(Long id) {
        buyerDAO.openSession();
        Buyer buyer = buyerDAO.findById(id);
        List<Product> products = new ArrayList<>();
        if (buyer != null) {
            products.addAll(buyer.getProducts());
        }
        buyerDAO.closeSession();
        return products;
    }

    public List<Buyer> getBuyersByProduct(Long id) {
        productDAO.openSession();
        Product product = productDAO.findById(id);
        List<Buyer> buyers = new ArrayList<>();
        if (product != null) {
            buyers.addAll(product.getBuyers());
        }
        productDAO.closeSession();
        return buyers;
    }
}
