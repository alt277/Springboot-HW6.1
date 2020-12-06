package ru.geekbrains.persist.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ru.geekbrains.persist.entity.Customer;
import ru.geekbrains.persist.repo.CustomerRepo;
import ru.geekbrains.persist.repo.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository ;
    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepository customerRepository, CustomerRepo customerRepo) {
        this.customerRepository = customerRepository;
        this.customerRepo = customerRepo;
    }
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    public List<Customer> findByNameAndFamily_name (String first_name,String family_name){
      return  customerRepository.findByNameAndFamily_name(first_name,family_name);}

   public   List<Customer> findByName( String firstName){
        return customerRepository.findByName(firstName);
   }
    public void update(Integer id, String firstName,String familyName) {
       customerRepo.update(id,firstName,familyName);
    }
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

}
