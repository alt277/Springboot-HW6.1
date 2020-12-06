package ru.geekbrains.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.persist.entity.Customer;
import ru.geekbrains.persist.entity.Product;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>  {

   @Query("select c from Customer c where c.firstName = :firstName  ")
   List<Customer> findByName(@Param("firstName") String firstName);

   @Query("select c from Customer c where c.firstName = 'Alex'  ")
   List<Customer> findByName2();

   @Query("select c from Customer c where (c.firstName = :firstName ) or" +
           "(c.familyName = :familyName )")
   List<Customer> findByNameAndFamily_name(@Param("firstName") String firstName, @Param("familyName") String familyName ) ;

   @Query("select p from Product p where  p.title=:title or p.title is null")
   List<Product> findByQueryTitle(@Param("title") String title);


}

