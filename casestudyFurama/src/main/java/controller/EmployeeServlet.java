package controller;


import model.Employee;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IEmployeeService employeeService = new EmployeeService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewFormEmployee(request, response);
                    break;
                case "edit":
                    showEditFormEmployee(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> listEmployee= employeeService.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int maNhanVien = Integer.parseInt(request.getParameter("ma_nhan_vien"));
        employeeService.deleteEmployee(maNhanVien);

        List<Employee> listEmployee = employeeService.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);

    }

    private void showEditFormEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int maNhanVien = Integer.parseInt(request.getParameter("ma_nhan_vien"));
        Employee existicungEmployee = employeeService.selectEmployee(maNhanVien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        request.setAttribute("employee", existicungEmployee);
        dispatcher.forward(request, response);
    }

    private void showNewFormEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        dispatcher.forward(request, response);

    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String hoTen = request.getParameter("ho_ten");
        String ngaySinh = request.getParameter("ngay_sinh");
        String soCMND = request.getParameter("so_cmnd");
        double luong = Double.parseDouble(request.getParameter("luong"));
        int soDienThoai = Integer.parseInt(request.getParameter("so_dien_thoai"));
        String email = request.getParameter("email");
        String diaChi = request.getParameter("dia_chi");
        int maViTri = Integer.parseInt(request.getParameter("ma_vi_tri"));
        int maTrinhDo = Integer.parseInt(request.getParameter("ma_trinh_do"));
        int maBoPhan = Integer.parseInt(request.getParameter("ma_bo_phan"));
        Employee newEmployee= new Employee(hoTen,ngaySinh,soCMND,luong,soDienThoai,email,diaChi,maViTri,maTrinhDo,maBoPhan);
        employeeService.insertEmployee(newEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        dispatcher.forward(request, response);
    }


    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
        int maNhanVien = Integer.parseInt(request.getParameter("ma_nhan_vien"));
        String hoTen = request.getParameter("ho_ten");
        String ngaySinh = request.getParameter("ngay_sinh");
        String soCMND = request.getParameter("so_cmnd");
        double luong = Double.parseDouble(request.getParameter("luong"));
        int soDienThoai = Integer.parseInt(request.getParameter("so_dien_thoai"));
        String email = request.getParameter("email");
        String diaChi = request.getParameter("dia_chi");
        int maViTri = Integer.parseInt(request.getParameter("ma_vi_tri"));
        int maTrinhDo = Integer.parseInt(request.getParameter("ma_trinh_do"));
        int maBoPhan = Integer.parseInt(request.getParameter("ma_bo_phan"));
        Employee book= new Employee(maNhanVien,hoTen,ngaySinh,soCMND,luong,soDienThoai,email,diaChi,maViTri,maTrinhDo,maBoPhan);

        employeeService.updateEmployee(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        dispatcher.forward(request, response);
    }
}
