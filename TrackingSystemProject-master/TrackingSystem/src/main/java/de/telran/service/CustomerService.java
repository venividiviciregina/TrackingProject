package de.telran.service;

import de.telran.entity.Customer;
import de.telran.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository respository;

    public Customer createCustomer(Customer customer) {
        Customer savedCustomer = respository.save(customer);
        return savedCustomer;
    }

    public List<Customer> getAllCustomers() {
        return respository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        return respository.getOne(customerId);
    }
}
