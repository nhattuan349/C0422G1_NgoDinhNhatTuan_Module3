package servlet;

import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();

    @Override
    public void init() throws ServletException{
        customerList.add(new Customer("Tuấn","12/12/2022","Quảng Nam","/images/hinh1_jpg.jpg"));
        customerList.add(new Customer("Đức","12/12/2022","Quảng Nam","/images/hinh2.jpg"));
        customerList.add(new Customer("Hải","12/12/2022","Quảng Nam","/images/hinh3.jpg"));
        customerList.add(new Customer("Quang","12/12/2022","Quảng Nam","/images/hinh4.jpg"));
        customerList.add(new Customer("Công","12/12/2022","Quảng Nam","/images/hinh5.jpg"));
        customerList.add(new Customer("Khánh","12/12/2022","Quảng Nam","/images/hinh6.jpg"));
        customerList.add(new Customer("Phong","12/12/2022","Quảng Nam","/images/hinh7.jpg"));
        customerList.add(new Customer("Mỹ","12/12/2022","Quảng Nam","/images/hinh8.jpg"));
        customerList.add(new Customer("Hưng","12/12/2022","Quảng Nam","/images/hinh9.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        request.setAttribute("customerList",customerList);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
