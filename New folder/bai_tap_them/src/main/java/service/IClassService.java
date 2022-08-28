package service;

import model.Class;

import java.util.List;

public interface IClassService {
    List<Class> findAll();

    void create(Class classs);

    void edit(int id, Class classs);

    void delete(int id);

    List<Class> findByName(String name);

    Class findById(int id);
}
