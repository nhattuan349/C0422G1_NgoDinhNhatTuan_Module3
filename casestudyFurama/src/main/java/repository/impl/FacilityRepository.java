package repository.impl;

import model.Facility;
import repository.IServiceRepository;

import java.sql.SQLException;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    @Override
    public void insertFacility(Facility facility) throws SQLException {

    }

    @Override
    public Facility selectFacility(int id) {
        return null;
    }

    @Override
    public List<Facility> selectAllFacility() {
        return null;
    }

    @Override
    public boolean deleteFacility(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateFacility(Facility facility) throws SQLException {
        return false;
    }
}
