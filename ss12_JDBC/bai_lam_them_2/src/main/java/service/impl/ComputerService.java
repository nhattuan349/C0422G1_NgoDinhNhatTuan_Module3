package service.impl;

import model.Computer;
import repository.IComputerRepository;
import repository.impl.ComputerRepository;
import service.IComputerService;

import java.util.List;

public class ComputerService implements IComputerService {
    IComputerRepository computerRepository = new ComputerRepository();

    @Override
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public void create(Computer computer) {
        computerRepository.create(computer);
    }
}
