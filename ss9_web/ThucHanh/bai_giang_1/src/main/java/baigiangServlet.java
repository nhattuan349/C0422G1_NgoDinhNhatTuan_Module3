import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "baigiangServlet", value = "/baigiang")
public class baigiangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String str= request.getParameter("nhandulieu");
        String str2= request.getParameter("nhandulieu2");
        int num1= Integer.parseInt(request.getParameter("nhandulieu3"));
        int num2= Integer.parseInt(request.getParameter("nhandulieu4"));
        int sum = num1+num2;
        System.out.println("----------------------"+str);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ket_qua.jsp");
        request.setAttribute("ketQua",str);
        request.setAttribute("str2",str2);
        request.setAttribute("num1",num1);
        request.setAttribute("num2",num2);
        request.setAttribute("sum",sum);
        requestDispatcher.forward(request,response);

    }
}
