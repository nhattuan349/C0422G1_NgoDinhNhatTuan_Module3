package service;

import model.Customer;
import model.Facility;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityService {
    void insertFacility(Facility facility) throws SQLException;

    Facility selectFacility(int id);

    List<Facility> selectAllFacility();

    boolean deleteFacility(int id) throws SQLException;

    boolean updateFacility(Facility facility) throws SQLException;

}
