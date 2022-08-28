package repository.impl;

import model.Customer;
import model.Facility;
import repository.IFacilityRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Furamat?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Baydem349";

    private static final String INSERT_FACILITY_SQL = "INSERT INTO dich_vu (ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da," +
            "ma_kieu_thue,ma_loai_dich_vu,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,dich_vu_mien_phi_di_kem) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_FACILITY_BY_ID = "select * from dich_vu where ma_dich_vu =?";
    private static final String SELECT_ALL_FACILITY = "select * from dich_vu";
    private static final String DELETE_FACILITY_SQL = "delete from dich_vu where ma_dich_vu = ?;";
    private static final String UPDATE_FACILITY_SQL = "update dich_vu set " +
            "ten_dich_vu= ?," +
            "dien_tich= ?," +
            "chi_phi_thue= ?," +
            "so_nguoi_toi_da= ?," +
            " ma_kieu_thue =?," +
            " ma_loai_dich_vu =?," +
            " tieu_chuan_phong =?," +
            " mo_ta_tien_nghi_khac =?," +
            " dien_tich_ho_boi =?," +
            " so_tang =?," +
            " dich_vu_mien_phi_di_kem =?" +
            " where ma_dich_vu = ?;";


    public FacilityRepository() {

    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertFacility(Facility facility) throws SQLException {
        System.out.println(INSERT_FACILITY_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FACILITY_SQL)) {
            preparedStatement.setString(1, facility.getTenDichVu());
            preparedStatement.setInt(2, facility.getDienTich());
            preparedStatement.setDouble(3, facility.getChiPhiThue());
            preparedStatement.setInt(4, facility.getSoNguoiToiDa());
            preparedStatement.setInt(5, facility.getMaKieuThue());
            preparedStatement.setInt(6, facility.getMaLoaiDichVu());
            preparedStatement.setString(7, facility.getTieuChuanPhong());
            preparedStatement.setString(8, facility.getMoTaTienNghiKhac());
            preparedStatement.setDouble(9, facility.getDienTichHoBoi());
            preparedStatement.setInt(10, facility.getSoTang());
            preparedStatement.setString(11, facility.getDichVuMienPhiDiKem());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Facility selectFacility(int id) {
        Facility facility = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FACILITY_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String tenDichVu = rs.getString("ten_dich_vu");
                int dienTich = rs.getInt("dien_tich");
                double chiPhiThue = rs.getDouble("chi_phi_thue");
                int soNguoiToiDa = rs.getInt("so_nguoi_toi_da");
                int maKieuThue = rs.getInt("ma_kieu_thue");
                int maLoaiDichVu = rs.getInt("ma_loai_dich_vu");
                String tieuChuanPhong = rs.getString("tieu_chuan_phong");
                String moTaTienNghiKhac = rs.getString("mo_ta_tien_nghi_khac");
                double dienTichHoBoi = rs.getDouble("dien_tich_ho_boi");
                int soTang = rs.getInt("so_tang");
                String dichVuMienPhiDiKem = rs.getString("dich_vu_mien_phi_di_kem");
                facility = new Facility(tenDichVu,dienTich,chiPhiThue, soNguoiToiDa,maKieuThue,maLoaiDichVu,tieuChuanPhong,moTaTienNghiKhac,dienTichHoBoi,soTang,dichVuMienPhiDiKem);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return facility;
    }

    @Override
    public List<Facility> selectAllFacility() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Facility> facilities = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FACILITY);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maDichVu = rs.getInt("ma_dich_vu");
                String tenDichVu = rs.getString("ten_dich_vu");
                int dienTich = rs.getInt("dien_tich");
                double chiPhiThue = rs.getDouble("chi_phi_thue");
                int soNguoiToiDa = rs.getInt("so_nguoi_toi_da");
                int maKieuThue = rs.getInt("ma_kieu_thue");
                int maLoaiDichVu = rs.getInt("ma_loai_dich_vu");
                String tieuChuanPhong = rs.getString("tieu_chuan_phong");
                String moTaTienNghiKhac = rs.getString("mo_ta_tien_nghi_khac");
                double dienTichHoBoi = rs.getDouble("dien_tich_ho_boi");
                int soTang = rs.getInt("so_tang");
                String dichVuMienPhiDiKem = rs.getString("dich_vu_mien_phi_di_kem");
                facilities.add(new Facility(maDichVu,tenDichVu,dienTich,chiPhiThue, soNguoiToiDa,maKieuThue,maLoaiDichVu,tieuChuanPhong,moTaTienNghiKhac,dienTichHoBoi,soTang,dichVuMienPhiDiKem));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return facilities;
    }

    @Override
    public boolean deleteFacility(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_FACILITY_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    @Override
    public boolean updateFacility(Facility facility) throws SQLException {
            boolean rowUpdated;
            try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_FACILITY_SQL);) {
                statement.setString(1, facility.getTenDichVu());
                statement.setInt(2, facility.getDienTich());
                statement.setDouble(3, facility.getChiPhiThue());
                statement.setInt(4, facility.getSoNguoiToiDa());
                statement.setInt(5, facility.getMaKieuThue());
                statement.setInt(6, facility.getMaDichVu());
                statement.setString(7, facility.getTieuChuanPhong());
                statement.setString(8, facility.getMoTaTienNghiKhac());
                statement.setDouble(9, facility.getDienTichHoBoi());
                statement.setInt(10, facility.getSoTang());
                statement.setString(11, facility.getDichVuMienPhiDiKem());
                statement.setInt(12, facility.getMaDichVu());

                rowUpdated = statement.executeUpdate() > 0;
            }
            return rowUpdated;
    }

        private void printSQLException(SQLException ex) {
            for (Throwable e : ex) {
                if (e instanceof SQLException) {
                    e.printStackTrace(System.err);
                    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    Throwable t = ex.getCause();
                    while (t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
                }
            }
        }
}
