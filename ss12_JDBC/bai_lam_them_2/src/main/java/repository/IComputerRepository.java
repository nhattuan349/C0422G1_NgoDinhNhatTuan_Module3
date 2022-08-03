package repository;

import model.Computer;

import java.util.List;

public interface IComputerRepository {
    List<Computer> findAll();

    void create(Computer computer);
}
