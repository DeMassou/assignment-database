package com.example.assignmentdatabase.data_access;
import com.example.assignmentdatabase.models.Customer;

import java.util.ArrayList;

public interface CustomerRepository {
    public ArrayList <Customer> selectAllCustomers();
    public Customer selectSpecificCustomerById(int customerId);
    public Customer selectCustomerByName(String firstName);
    public ArrayList<Customer> selectPageOfCustomers();

}
