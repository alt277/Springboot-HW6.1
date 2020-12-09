package ru.geekbrains.rest;

//import io.swagger.v3.oas.annotations.tags.Tag;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.controller.NotFoundException;
import ru.geekbrains.persist.entity.Customer;
import ru.geekbrains.persist.entity.views.CustomerView;
import ru.geekbrains.persist.repo.CustomerRepository;
import ru.geekbrains.persist.services.CustomerService;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

//@Tag(name = "User resource API", description = "API to operate User resource ...")
//@CrossOrigin(origins = "http://localhost:63342")

@RequestMapping("/api/v1/customers")
@RestController
public class CustomerResource {


    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    @Autowired
    public CustomerResource(CustomerService customerService,CustomerRepository customerRepository) {
       this.customerService=customerService;
        this.customerRepository=customerRepository;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping(path = "r", produces = "application/json")
    public Customer findById(@PathVariable("id") int id) {
        return customerRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }
    @GetMapping(value = "/idName", produces= MediaType.APPLICATION_JSON_VALUE)
 //   @JsonView(CustomerView.IdName.class)
    @JsonView(CustomerView.firstNameName.class)
    @ResponseBody
    public List<Customer> customerIdNameToJson(){
        return customerService.findAll();
    }
    @GetMapping(path = "/{name}/name", produces = "application/json")

    public List<Customer> findByName(@PathVariable("name") String name) {
        return customerService.findByName(name);
    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Customer createCustomer(@RequestBody Customer customer) {
//      customerRepository.update(customer.getId(),customer.getFirst_name(),customer.getFamily_name());
        //      if(  customerRepository.findById (customer.getId()) != null){
//        if (customer.getId() != null) {
//            throw new IllegalArgumentException("Entity already exists");
//        }
        customerService.save(customer);
        return customer;
    }

 //   @PutMapping(consumes = "application/json", produces = "application/json")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer updateCustomer(@RequestBody Customer customer) {

        customerService.save(customer);
        return customer;
//        return   customerRepository.save(customer);
    }



    @DeleteMapping( path = "/{id}", produces = "application/json")
    public void deleteById(@PathVariable("id") Integer id) {

        System.out.println("in deleteByID");
        customerService.deleteById(id);
    }
    @DeleteMapping( path = "/{first_name}/first_name", produces = "application/json")
    public void deleteByName(@PathVariable("first_name") String first_name) {
//        if (customerRepository.findByName(first_name) == null) {
//            throw new IllegalArgumentException("There is no such name");
//        }
        customerRepository.deleteByFirst_name(first_name);
    }

//    @DeleteMapping( path = "/{first_name}/delete", produces = "application/json")
//    public void deleteByName(@PathVariable("first_name") String first_name) {
//        if (customerRepository.findByName(first_name) == null) {
//            throw new IllegalArgumentException("There is no such name");
//        }
//        customerRepository.deleteByFirst_name(first_name);
//    }

    @ExceptionHandler
    public ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> sqlIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}