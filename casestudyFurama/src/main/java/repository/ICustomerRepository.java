package repository;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    void insertUser(Customer user) throws SQLException;

    Customer selectUser(int id);

    List<Customer> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(Customer customer) throws SQLException;

    List<Customer> findByCountry(String country);

    List<Customer> findByName(String name);

    List<Customer> sort(String name);

    List<Customer> viewAll();

    void updateSp(Customer customer);

    void deleteSp(int id);
}
