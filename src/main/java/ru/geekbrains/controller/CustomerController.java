package ru.geekbrains.controller;

import ru.geekbrains.controller.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.persist.entity.Customer;
import ru.geekbrains.persist.repo.CustomerRepository;
import ru.geekbrains.persist.repo.ProductRepository;
import ru.geekbrains.persist.repo.CustomerRepo;
import ru.geekbrains.persist.services.CustomerService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping
    public String all(Model model,
                      @RequestParam(value = "firstName", required = false) String firstName,
                      @RequestParam(value = "familyName", required = false) String familyName,
                      @RequestParam("page") Optional<Integer> page,
                      @RequestParam("size") Optional<Integer> size) {

        logger.info("Filtering by name: {}", firstName);
        List<Customer> customerList;

        if ((firstName == null || firstName.isEmpty()) && (familyName == null || familyName.isEmpty())) {
            customerList = customerService.findAll();
        } else {
            customerList = customerService.findByNameAndFamily_name(firstName, familyName);

        }
        model.addAttribute("customers", customerList);
        return "customers";
    }

    @GetMapping("/new_customer")
    public String addCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";
    }

    @GetMapping("/{id}")
    public String editCustomer(@PathVariable("id") Integer id, Model model) throws Exception {
        Customer customer = customerRepository.findById(id).orElseThrow(Exception::new);
        model.addAttribute("customer", customer);
        return "edit_customer";
    }

    @PostMapping("/new")
    public String addCustomer(Model model, Customer customer, BindingResult bindingResult) {
        customerService.save(customer);

        return "redirect:/customers";
    }

    @PostMapping("/update")
    public String updateCustomer(Model model, Customer customer, BindingResult bindingResult) {
        customerService.save(customer);

        return "redirect:/customers";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        customerService.deleteById(id);

        return "redirect:/customers";
    }


}


