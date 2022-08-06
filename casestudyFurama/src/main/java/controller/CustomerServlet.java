package controller;

import model.Customer;
import repository.impl.CustomerRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerRepository customerRepository;

    public void init() {
        customerRepository = new CustomerRepository();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
////        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/demo.jsp");
//        requestDispatcher.forward(request,response);
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }

            try {
                switch (action) {
                    case "create":
                        showNewFormCustomer(request, response);
                        break;
                    case "edit":
                        showEditFormCustomer(request, response);
                        break;
                    case "delete":
                        deleteCustomer(request, response);
                        break;
                    default:
                        listCustomer(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = customerRepository.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int maKhachHang = Integer.parseInt(request.getParameter("ma_khach_hang"));
        customerRepository.deleteCustomer(maKhachHang);

        List<Customer> listUser = customerRepository.selectAllCustomer();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditFormCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int maKhachHang = Integer.parseInt(request.getParameter("ma_khach_hang"));
        Customer existicungCustomer = customerRepository.selectCustomer(maKhachHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        request.setAttribute("customer", existicungCustomer);
        dispatcher.forward(request, response);
    }

    private void showNewFormCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

        int maLoaiKhach = Integer.parseInt(request.getParameter("ma_loai_khach"));
        String hoTen  = request.getParameter("ho_ten");
        String ngaySinh = request.getParameter("ngay_sinh");
        int gioiTinh = Integer.parseInt(request.getParameter("gioi_tinh"));
        int soCMND = Integer.parseInt(request.getParameter("so_cmnd"));
        int soDienThoai = Integer.parseInt(request.getParameter("so_dien_thoai"));
        String email = request.getParameter("email");
        String diaChi = request.getParameter("dia_chi");
        Customer newCustomer = new Customer(maLoaiKhach,hoTen,ngaySinh,gioiTinh,soCMND,soDienThoai,email,diaChi);
        customerRepository.insertCustomer(newCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int maKhachHang = Integer.parseInt(request.getParameter("ma_khach_hang"));
        int maLoaiKhach = request.getIntHeader("ma_loai_khach");
        String hoTen  = request.getParameter("ho_ten");
        String ngaySinh = request.getParameter("ngay_sinh");
        int gioiTinh = Integer.parseInt(request.getParameter("gioi_tinh"));
        int soCMND = Integer.parseInt(request.getParameter("so_cmnd"));
        int soDienThoai = Integer.parseInt(request.getParameter("so_dien_thoai"));
        String email = request.getParameter("email");
        String diaChi = request.getParameter("dia_chi");

            Customer book = new Customer(maKhachHang,maLoaiKhach,hoTen,ngaySinh,gioiTinh,soCMND,soDienThoai,email,diaChi);
            customerRepository.updateCustomer(book);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
            dispatcher.forward(request, response);
    }
}
