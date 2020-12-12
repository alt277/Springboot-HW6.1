package ru.geekbrains.repo;

import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class ProductRepo {

    @PersistenceContext
    private EntityManager em;

    public Product findMaxPrice() {
        return em.createNamedQuery("Product.findPoductByMaxPrice", Product.class).getSingleResult();
    }

    public Product findMinPrice() {
        return em.createQuery("select p from Product p where p.price= ( select MIN (p.price) from Product p) ", Product.class).getSingleResult();
    }

    public List<Product> findMinMaxPrice() {
        return em.createQuery("select p from Product p where p.price= ( select MAX (p.price) from Product p) or p.price= ( select MIN (p.price) from Product p)", Product.class).getResultList();
    }

}

