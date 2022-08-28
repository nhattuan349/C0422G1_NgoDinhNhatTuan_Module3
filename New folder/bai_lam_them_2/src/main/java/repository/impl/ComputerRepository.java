package repository.impl;

import model.Computer;
import repository.IComputerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerRepository implements IComputerRepository {

    private static Map<Integer, Computer> computers = new HashMap<>();

    static {
        Computer computer = new Computer(1, "Asus", "16 Ghz", "Z690", "2011-12-21");
        computers.put(computer.getId(), computer);
    }

    @Override
    public List<Computer> findAll() {
        return new ArrayList<>(computers.values());
    }

    @Override
    public void create(Computer computer) {
        computers.put(computer.getId(),computer);
    }

    @Override
    public void edit(int id, Computer computer) {
        computers.put(id, computer);
    }

    @Override
    public Computer findById(int id) {
        return computers.get(id);
    }
}
