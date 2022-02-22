package com.example.assignmentdatabase.controllers;
import com.example.assignmentdatabase.data_access.CustomerRepository;
import com.example.assignmentdatabase.data_access.CustomerRepositoryImpl;
import com.example.assignmentdatabase.models.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class CustomerController {
    private final CustomerRepositoryImpl customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = (CustomerRepositoryImpl) customerRepository;
    }

    @RequestMapping (value = "api/customer", method = RequestMethod.GET)
    public ArrayList<Customer>selectAllCustomers() {
        return customerRepository.selectAllCustomers();
    }

    @RequestMapping(value = "api/customer/{customerId}", method = RequestMethod.GET)
    public Customer selectSpecificCustomerById(@PathVariable("customerId")  int customerId) {

    return customerRepository.selectSpecificCustomerById(customerId);
    }
}
