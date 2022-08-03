package controller;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import model.Computer;
import service.IComputerService;
import service.impl.ComputerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CpmputerServlet", urlPatterns = {"", "/computer"})
public class ComputerServlet extends HttpServlet {
    IComputerService computerService = new ComputerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showAddForm(request, response);
                break;
            default:
                showListForm(request, response);
                break;
        }
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) {
        List<Computer> computers = computerService.findAll();
        request.setAttribute("computers", computers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("computer/list.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("computer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createComputer(request, response);
                break;
            default:
                break;
        }
    }

    private void createComputer(HttpServletRequest request, HttpServletResponse response) {
        String computerName = request.getParameter("computerName");
        String ram = request.getParameter("ram");
        String cpu = request.getParameter("cpu");
        String dateProduce = request.getParameter("dateProduce");
        int id = (int) (Math.random() * 10000);
        Computer computer = new Computer(id, computerName, ram, cpu, dateProduce);
        computerService.create(computer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("computer/create.jsp");
        request.setAttribute("message", "Them moi thanh cong");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
