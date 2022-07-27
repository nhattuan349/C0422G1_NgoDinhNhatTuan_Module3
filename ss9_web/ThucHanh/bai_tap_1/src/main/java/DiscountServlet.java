import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", value = "/discountServlet")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("productDescription");
        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        double discountPercentlistPrice = Double.parseDouble(request.getParameter("discountPercentlistPrice"));
        double discountAmount = listPrice*discountPercentlistPrice*0.01;
        double discountPrice = listPrice -discountAmount;

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ket_qua.jsp");
        request.setAttribute("kqProductDescription",productDescription);
        request.setAttribute("kqListPrice",listPrice);
        request.setAttribute("kqDiscountPercentlistPrice",discountPercentlistPrice);
        request.setAttribute("kqDiscountAmount",discountAmount);
        request.setAttribute("kqDiscountPrice",discountPrice);
    }
}
