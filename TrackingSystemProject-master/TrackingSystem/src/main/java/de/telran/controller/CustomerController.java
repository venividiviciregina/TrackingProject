package de.telran.controller;

import de.telran.dto.CustomerDTO;
import de.telran.entity.Customer;
import de.telran.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {
    private CustomerService service;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/api/customers")
    List<CustomerDTO> getAllCustomers() {
        return service.getAllCustomers()
                .stream()
                .map(s -> modelMapper.map(s, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/api/customers")
    CustomerDTO createCustomer(@RequestBody CustomerDTO customer) {
        System.out.println(customer);
        Customer customerEntity = modelMapper.map(customer, Customer.class);
        System.out.println(customerEntity);
        return modelMapper.map(service.createCustomer(customerEntity), CustomerDTO.class);
    }

//    @PutMapping("/api/students")
//    Student assignStudentToCourse(@RequestBody Student student) {
//        service.assignStudentToCourse(student);
//        return service.getStudentById(student.getStudentId());
//    }

//    @GetMapping("/api/school")
//    School getSchoolInfo() {
//        return service.getSchoolInfo();
//    }
}
