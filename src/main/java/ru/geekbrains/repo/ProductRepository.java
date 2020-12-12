package ru.geekbrains.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    List<Product> findByTitleLike(String title);

    List<Product> findByTitleOrderByPriceDesc(String title);

    @Query("select p from Product p where p.price= ( select MIN (p.price) from Product p) ")
    Product findMinPrice();

    @Query("select p from Product p where p.price= ( select MAX(p.price) from Product p) ")
    Product findMaxPrice();

    @Query("select p from Product p where  p.title=:title or p.title is null")
    List<Product> findByQueryTitle(@Param("title") String title);

    @Query("select p from Product p where p.price= ( select MAX (p.price) from Product p) or p.price= ( select MIN (p.price) from Product p)")
    List<Product> findMinMaxPrice();

}

