package service;

import model.Computer;

import java.util.List;

public interface IComputerService {
    List<Computer> findAll();

    void create(Computer computer);
}
