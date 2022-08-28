package service.impl;

import model.Class;
import repository.IClassRepository;
import repository.impl.ClassRepository;
import service.IClassService;

import java.util.List;

public class ClassService implements IClassService {
    IClassRepository classRepository = new ClassRepository();

    @Override
    public List<Class> findAll() {
        return classRepository.findAll();
    }

    @Override
    public void create(Class classs) {
        classRepository.create(classs);
    }

    @Override
    public void edit(int id, Class classs) {
        classRepository.edit(id, classs);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Class> findByName(String name) {
        return null;
    }

    @Override
    public Class findById(int id) {
        return null;
    }
}
