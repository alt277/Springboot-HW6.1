package ru.geekbrains.persist.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.persist.entity.Category;
import ru.geekbrains.persist.entity.Customer;
import ru.geekbrains.persist.entity.Product;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {


    @Query("  SELECT p  FROM Product as p " +
            " join Category as c on p.id=c.id "+
            "where c.title =:title")
    List<Product> findCategoryByTitle(@Param("title") String title);

    List<Product> findAllByCategoryId(Integer id);
}
