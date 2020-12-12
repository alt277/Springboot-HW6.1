package ru.geekbrains.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.data.CustomerDTO;
import ru.geekbrains.entity.Customer;

import java.util.List;

public interface CustomerDataRepository extends JpaRepository<Customer, Integer> {

    @Query("select new ru.geekbrains.data.CustomerDTO (c.id,c.familyName,c.firstName) from Customer c")
    List<CustomerDTO> findAllCustomerData();

}
