package ru.geekbrains.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Customer;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("select c from Customer c where c.firstName = :firstName  ")
    List<Customer> findByName(@Param("firstName") String firstName);

    @Query("select c from Customer c where c.firstName = 'Alex'  ")
    List<Customer> findByName2();

    @Query("select c from Customer c where c.id = :id  ")
    Customer getById(@Param("id") Integer id);

    @Query("select c from Customer c where (c.firstName = :firstName ) or" +
            "(c.familyName = :familyName )")
    List<Customer> findByNameAndFamily_name(@Param("firstName") String firstName, @Param("familyName") String familyName);


    @Query("delete from Customer c where  c.firstName=:firstName ")
    void deleteByFirst_name(@Param("firstName") String firstName);

}

