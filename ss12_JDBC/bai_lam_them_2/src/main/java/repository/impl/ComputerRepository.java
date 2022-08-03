package repository.impl;

import model.Computer;
import repository.IComputerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerRepository implements IComputerRepository {

    private static Map<Integer, Computer> computers = new HashMap<>();

    @Override
    public List<Computer> findAll() {
        return new ArrayList<>(computers.values());
    }

    @Override
    public void create(Computer computer) {
        computers.put(computer.getId(),computer);
    }
}
