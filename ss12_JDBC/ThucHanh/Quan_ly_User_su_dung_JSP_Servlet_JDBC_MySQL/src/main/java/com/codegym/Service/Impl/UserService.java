package com.codegym.Service.Impl;

import com.codegym.Service.IUserService;
import com.codegym.dao.IUserDAO;
import com.codegym.dao.Impl.UserDAO;
import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    IUserDAO userDAO = new UserDAO();

    @Override
    public void insertUser(User user) throws SQLException {
        userDAO.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userDAO.selectUser(id);
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return userDAO.findByCountry(country);
    }

    @Override
    public List<User> findByName(String name) {
        return userDAO.findByName(name);
    }

    @Override
    public List<User> sort(String name) {
        return userDAO.sort(name);
    }

    @Override
    public List<User> selectAllUser() {
        return userDAO.selectAllUsers();
    }


    @Override
    public List<User> viewAll() {
        return userDAO.viewAll();
    }

    @Override
    public void updateSp(User user) {
        userDAO.updateSp(user);
    }

    @Override
    public void deleteSp(int id) {
        userDAO.deleteSp(id);
    }
}
