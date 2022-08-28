package repository.impl;


import model.Employee;
import repository.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Furamat?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Baydem349";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO nhan_vien (ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai," +
            "email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_EMPLOYEE_BY_ID = "select ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai," +
            "email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan from nhan_vien where ma_nhan_vien =?";

    private static final String SELECT_ALL_EMPLOYEE = "select * from nhan_vien";

    private static final String DELETE_EMPLOYEE_SQL = "delete from nhan_vien where ma_nhan_vien = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update nhan_vien set " +
            "ho_ten= ?," +
            "ngay_sinh= ?," +
            "so_cmnd= ?," +
            "luong= ?," +
            "so_dien_thoai= ?," +
            "dia_chi= ?," +
            "email= ?," +
            "ma_vi_tri= ?," +
            "ma_trinh_do= ?," +
            "ma_bo_phan= ?" +
            " where ma_nhan_vien = ?";

    public EmployeeRepository() {

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
    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEE_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getHoTen());
            preparedStatement.setString(2, employee.getNgaySinh());
            preparedStatement.setString(3, employee.getSoCMND());
            preparedStatement.setDouble(4, employee.getLuong());
            preparedStatement.setInt(5, employee.getSoDienThoai());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getDiaChi());
            preparedStatement.setInt(8, employee.getMaViTri());
            preparedStatement.setInt(9, employee.getMaTrinhDo());
            preparedStatement.setInt(10, employee.getMaBoPhan());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String hoTen = rs.getString("ho_ten");
                String ngaySinh = rs.getString("ngay_sinh");
                String soCMND = rs.getString("so_cmnd");
                double luong = rs.getDouble("luong");
                int soDienThoai = rs.getInt("so_dien_thoai");
                String email = rs.getString("email");
                String diaChi = rs.getString("dia_chi");
                int maViTri = rs.getInt("ma_vi_tri");
                int maTrinhDo = rs.getInt("ma_trinh_do");
                int maBoPhan = rs.getInt("ma_bo_phan");
                employee = new Employee(hoTen,ngaySinh,soCMND,luong,soDienThoai,email,diaChi,maViTri,maTrinhDo,maBoPhan);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Employee> employees = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maNhanVien = rs.getInt("ma_nhan_vien");
                String hoTen = rs.getString("ho_ten");
                String ngaySinh = rs.getString("ngay_sinh");
                String soCMND = rs.getString("so_cmnd");
                double luong = rs.getDouble("luong");
                int soDienThoai = rs.getInt("so_dien_thoai");
                String email = rs.getString("email");
                String diaChi = rs.getString("dia_chi");
                int maViTri = rs.getInt("ma_vi_tri");
                int maTrinhDo = rs.getInt("ma_trinh_do");
                int maBoPhan = rs.getInt("ma_bo_phan");
                employees.add(new Employee(maNhanVien,hoTen,ngaySinh,soCMND,luong,soDienThoai,email,diaChi,maViTri,maTrinhDo,maBoPhan));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;

    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {

            statement.setString(1, employee.getHoTen());
            statement.setString(2, employee.getNgaySinh());
            statement.setString(3, employee.getSoCMND());
            statement.setDouble(4, employee.getLuong());
            statement.setInt(5, employee.getSoDienThoai());
            statement.setString(6, employee.getEmail());
            statement.setString(7, employee.getDiaChi());
            statement.setInt(8, employee.getMaViTri());
            statement.setInt(9, employee.getMaTrinhDo());
            statement.setInt(10, employee.getMaBoPhan());
            statement.setInt(11, employee.getMaNhanVien());

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
