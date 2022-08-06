package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void insertCustomer(Customer customer) throws SQLException {

    }

    @Override
    public Customer selectCustomer(int id) {
        return null;
    }

    @Override
    public List<Customer> selectAllUsers() {
        return null;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return false;
    }
}

