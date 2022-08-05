package repository.impl;

import model.Customer;
import repository.ICustomerRepository;

import java.sql.SQLException;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furamaS?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Baydem349";

    private static final String INSERT_USERS_SQL = "INSERT INTO khach_hang (ma_khach_hang, ma_loai_khach, ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select ma_khach_hang, ma_loai_khach, ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from khach_hang";
    private static final String DELETE_USERS_SQL = "delete from khach_hang where id = ?;";
    private static final String UPDATE_USERS_SQL = "update khach_hang set name = ?,email= ?, country =? where id = ?;";
    private static final String SEARCH_USER_BY_COUNTRY = "SELECT * FROM khach_hang where country like ? ";
    private static final String SORT_USER_BY_NAME = "SELECT * FROM khach_hang  order by name";
    private static final String SEARCH_USER_BY_NAME = "SELECT * FROM khach_hang where name like ? ";
    private static final String SP_FIND_ALL_USER = "CALL  sp_fin_all_khach_hang()";
    private static final String UPDATE_SP_USER = "CALL sp_edit_khach_hang(?,?,?,?) ";
    private static final String DELETE_SP_USER = "CALL sp_delete_khach_hang(?)";



    @Override
    public void insertUser(Customer user) throws SQLException {

    }

    @Override
    public Customer selectUser(int id) {
        return null;
    }

    @Override
    public List<Customer> selectAllUsers() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public List<Customer> findByCountry(String country) {
        return null;
    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }

    @Override
    public List<Customer> sort(String name) {
        return null;
    }

    @Override
    public List<Customer> viewAll() {
        return null;
    }

    @Override
    public void updateSp(Customer customer) {

    }

    @Override
    public void deleteSp(int id) {

    }
}
