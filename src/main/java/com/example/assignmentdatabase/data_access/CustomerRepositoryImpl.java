package com.example.assignmentdatabase.data_access;

import com.example.assignmentdatabase.models.Customer;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    private String URL = ConnectionHelper.URL;
    private Connection connection = null;

    //1. read all customers in the database
    public ArrayList<Customer> selectAllCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();

        try{
            connection = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT CustomerId,FirstName,LastName,Phone,Email,Country,PostalCode FROM customer");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                customers.add(new Customer(
                        resultSet.getString("customerId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("country"),
                        resultSet.getString("postalCode")


                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception exception) {
                System.out.println("Exception");
            }
        }
        return customers;
    }

    //2. Read specific customer from database by id
    public Customer selectSpecificCustomerById(int customerId){
        Customer customer = null;

        try {
            //connection
            connection = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT CustomerId,FirstName,LastName,Phone,Email,Country,PostalCode FROM customer WHERE CustomerId = ?");
            preparedStatement.setString(1, String.valueOf(customerId));
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                customer = new Customer(
                        resultSet.getString("customerId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("country"),
                        resultSet.getString("postalCode")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customer;
    }

    //3. Read specific customer by name
    public Customer selectCustomerByName(String firstName){
        Customer customer = null;

        try{
            connection = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE FirstName LIKE 'Leonie' ");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                customer = new Customer(
                        resultSet.getString("customerId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("country"),
                        resultSet.getString("postalCode")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customer;
    }

    //4.
    public ArrayList<Customer> selectPageOfCustomers(){

        ArrayList<Customer> customers = new ArrayList<Customer>();

        try{
            connection = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT CustomerId,FirstName,LastName," +
                    "Phone,Email,Country,PostalCode FROM customer LIMIT 10 OFFSET 50");

            ResultSet  resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                customers.add(new Customer(
                        resultSet.getString("customerId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("country"),
                        resultSet.getString("postalCode")

                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Boolean addCustomer(Customer customer) {
        Boolean success = false;
        try {
            connection = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customer (CustomerId, FirstName, LastName, Phone, Email, Country, PostalCode) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1,customer.getCustomerId());
            preparedStatement.setString(2,customer.getFirstName());
            preparedStatement.setString(3,customer.getLastName());
            preparedStatement.setString(4,customer.getPhone());
            preparedStatement.setString(5,customer.getEmail());
            preparedStatement.setString(6,customer.getCountry());
            preparedStatement.setString(7,customer.getPostalCode());

            int result = preparedStatement.executeUpdate();
            success = (result !=0);
            System.out.println("Add Customer Successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
            } catch (Exception exception){
                System.out.println("Exception");
            }
        }
        return success;
    }
}
