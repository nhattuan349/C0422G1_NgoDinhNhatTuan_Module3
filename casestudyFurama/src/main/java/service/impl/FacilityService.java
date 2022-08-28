package service.impl;


import model.Facility;
import repository.IFacilityRepository;
import repository.impl.FacilityRepository;
import service.IFacilityService;

import java.sql.SQLException;
import java.util.List;

public class FacilityService implements IFacilityService {
    IFacilityRepository serviceRepository = new FacilityRepository();

    @Override
    public void insertFacility(Facility facility) throws SQLException {
        serviceRepository.insertFacility(facility);
    }

    @Override
    public Facility selectFacility(int id) {
        return serviceRepository.selectFacility(id);
    }

    @Override
    public List<Facility> selectAllFacility() {
        return serviceRepository.selectAllFacility();
    }

    @Override
    public boolean deleteFacility(int id) throws SQLException {
        return serviceRepository.deleteFacility(id);
    }

    @Override
    public boolean updateFacility(Facility facility) throws SQLException {
        return serviceRepository.updateFacility(facility);
    }
}
