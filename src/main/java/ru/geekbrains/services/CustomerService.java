package ru.geekbrains.services;

import org.springframework.stereotype.Service;

import ru.geekbrains.entity.Customer;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repo.CustomerRepo;
import ru.geekbrains.repo.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository ;
    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepository customerRepository, CustomerRepo customerRepo) {
        this.customerRepository = customerRepository;
        this.customerRepo = customerRepo;
    }
    public Customer findById(Integer id) {
        return customerRepository.getById(id);
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
