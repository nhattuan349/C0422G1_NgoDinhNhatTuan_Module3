package ung_dung_quan_ly_khach_hang.service;

import ung_dung_quan_ly_khach_hang.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {

    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1,new Customer(1,"Tân","tan@gmail.com","Quang Nam"));
        customers.put(2,new Customer(2,"Tuấn","tuan@gmail.com","Quang Nam"));
        customers.put(3,new Customer(3,"Khánh","khanh@gmail.com","Quang Nam"));
        customers.put(4,new Customer(4,"Phong","phong@gmail.com","Quang Nam"));
        customers.put(5,new Customer(5,"Mỹ","my@gmail.com","Quang Nam"));
        customers.put(6,new Customer(6,"Đức","duc@gmail.com","Quang Nam"));
    }

    //findAll(): Trả về danh sách tất cả khách hàng
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    //save(): Lưu một khách hàng
    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }


    //findById(): Tìm một khách hàng theo Id
    @Override
    public Customer findById(int id) {
        return null;
    }

    // update(): Cập nhật thông tin của một khách hàng
    @Override
    public void update(int id, Customer customer) {

    }


    //remove(): Xoá một khách hàng khỏi danh sách
    @Override
    public void remove(int id) {

    }
}
