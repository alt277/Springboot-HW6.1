package ru.geekbrains.populators;


import org.springframework.stereotype.Service;
import ru.geekbrains.data.CustomerDTO;
import ru.geekbrains.entity.Customer;

@Service
public class CustomerPopulator implements Populator<Customer, CustomerDTO> {

    @Override
    public CustomerDTO populate(Customer customer, CustomerDTO customerDTO) {
        if (customer == null || customerDTO == null)
            return null;
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setFamilyName(customer.getFamilyName());
        return customerDTO;
    }

    @Override
    public CustomerDTO populate(Customer customer) {
        return populate(customer, new CustomerDTO());
    }
}
