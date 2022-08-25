package controller;

import model.Customer;
import model.CustomerType;
import model.Facility;
import service.IFacilityService;
import service.impl.FacilityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = {"/service"})
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IFacilityService facilityService = new FacilityService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertFacility(request, response);
                    break;
                case "edit":
                    updateFacility(request, response);
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
                    showNewFormFacility(request, response);
                    break;
                case "edit":
                    showEditFormFacility(request, response);
                    break;
                case "delete":
                    deleteFacility(request, response);
                    break;
                default:
                    listFacility(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void listFacility(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Facility> listFacility = facilityService.selectAllFacility();
        request.setAttribute("listFacility", listFacility);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response)
         throws SQLException, IOException, ServletException {
            int maDichVu = Integer.parseInt(request.getParameter("ma_khach_hang"));
            customerService.deleteCustomer(maKhachHang);

            List<Customer> listCustomer = customerService.selectAllCustomer();
            request.setAttribute("listCustomer", listCustomer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
            dispatcher.forward(request, response);
    }

    private void showEditFormFacility(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
        int maKhachHang = Integer.parseInt(request.getParameter("ma_khach_hang"));
        Customer existicungCustomer = customerService.selectCustomer(maKhachHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        request.setAttribute("customer", existicungCustomer);
        dispatcher.forward(request, response);
    }

    private void showNewFormFacility(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void insertFacility(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int maLoaiKhach = Integer.parseInt(request.getParameter("ma_loai_khach"));
        String hoTen = request.getParameter("ho_ten");
        String ngaySinh = request.getParameter("ngay_sinh");
        int gioiTinh = Integer.parseInt(request.getParameter("gioi_tinh"));
        int soCMND = Integer.parseInt(request.getParameter("so_cmnd"));
        int soDienThoai = Integer.parseInt(request.getParameter("so_dien_thoai"));
        String email = request.getParameter("email");
        String diaChi = request.getParameter("dia_chi");
        Customer newCustomer = new Customer(maLoaiKhach, hoTen, ngaySinh, gioiTinh, soCMND,
                soDienThoai, email, diaChi);
        customerService.insertCustomer(newCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateFacility(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
        int maKhachHang = Integer.parseInt(request.getParameter("ma_khach_hang"));
        int maLoaiKhach = Integer.parseInt(request.getParameter("ma_loai_khach"));
        String hoTen = request.getParameter("ho_ten");
        String ngaySinh = request.getParameter("ngay_sinh");
        int gioiTinh = Integer.parseInt(request.getParameter("gioi_tinh"));
        int soCMND = Integer.parseInt(request.getParameter("so_cmnd"));
        int soDienThoai = Integer.parseInt(request.getParameter("so_dien_thoai"));
        String email = request.getParameter("email");
        String diaChi = request.getParameter("dia_chi");
        Customer book = new Customer(maKhachHang, maLoaiKhach, hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email, diaChi);

        customerService.updateCustomer(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        dispatcher.forward(request, response);
    }
    }






}
