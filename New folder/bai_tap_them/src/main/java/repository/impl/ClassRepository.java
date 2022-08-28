package repository.impl;

import model.Class;
import repository.IClassRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRepository implements IClassRepository {

    private static Map<Integer, Class> classs = new HashMap<>();

    static {
        Class class0 = new Class(1, "C01");
        Class class1 = new Class(2, "C02");
        Class class2 = new Class(3, "C03");
        Class class3 = new Class(4, "C04");
        Class class4 = new Class(5, "C05");
        Class class5 = new Class(6, "C06");
        classs.put(class0.getId(), class0);
        classs.put(class1.getId(), class1);
        classs.put(class2.getId(), class2);
        classs.put(class3.getId(), class3);
        classs.put(class4.getId(), class4);
        classs.put(class5.getId(), class5);
    }

    @Override
    public List<Class> findAll() {
        return new ArrayList<>(classs.values());
    }

    @Override
    public void create(Class classss) {
        classs.put(classss.getId(),classss);
    }

    @Override
    public void edit(int id, Class classss) {
        classs.put(id,classss);
    }

    @Override
    public void delete(int id) {
        classs.remove(id);
    }

    @Override
    public List<Class> findByName(String name) {
        List<Class> classs=new ArrayList<>();
        for (Class item: findAll()) {
            if(item.getClassName().contains(name)){
                classs.add(item);
            }
        }
        return classs;
    }

    @Override
    public Class findById(int id) {
        return classs.get(id);
    }
}
