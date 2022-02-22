package com.example.assignmentdatabase.controllers;
import com.example.assignmentdatabase.data_access.CustomerRepository;
import com.example.assignmentdatabase.data_access.CustomerRepositoryImpl;
import com.example.assignmentdatabase.models.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping ("api")
public class CustomerController {
    private final CustomerRepositoryImpl customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = (CustomerRepositoryImpl) customerRepository;
    }

    @GetMapping ("customer")
    public ArrayList<Customer>selectAllCustomers() {
        return customerRepository.selectAllCustomers();
    }
}
