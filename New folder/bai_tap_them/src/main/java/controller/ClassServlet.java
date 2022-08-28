package controller;

import model.Class;
import service.IClassService;
import service.impl.ClassService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClassServlet", urlPatterns = {"","/class"})
public class ClassServlet extends HttpServlet {
    IClassService classService = new ClassService();
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
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "findByName":
                findByNameClass(request,response);
                break;
            case "findById":
                viewClass(request, response);
                break;
            default:
                showListClass(request, response);
                break;
        }
    }

    private void showListClass(HttpServletRequest request, HttpServletResponse response) {
        List<Class> classs = classService.findAll();
        request.setAttribute("classs", classs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("class/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewClass(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Class classs = classService.findById(id);
        RequestDispatcher dispatcher;
        if (classs == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("classs", classs);
            dispatcher = request.getRequestDispatcher("class/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void findByNameClass(HttpServletRequest request, HttpServletResponse response) {
        String className=request.getParameter("className");
        List<Class> classs =classService.findByName(className);
        request.setAttribute("classs",classs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("class/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Class classs = classService.findById(id);
        RequestDispatcher dispatcher;
        if (classs == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("classs", classs);
            dispatcher = request.getRequestDispatcher("class/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Class classs = classService.findById(id);
        RequestDispatcher dispatcher;
        if (classs == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("classs", classs);
            dispatcher = request.getRequestDispatcher("class/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("class/create.jsp");
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
                createClass(request, response);
                break;
            case "edit":
                editClast(request, response);
                break;
            case "delete":
                deleteClass(request, response);
                break;
            case "findByName":
                break;
            case "findById":
                break;
            default:
                break;
    }
}

    private void deleteClass(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Class classs = classService.findById(id);
        RequestDispatcher dispatcher;
        if (classs == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            classService.delete(id);
            try {
                response.sendRedirect("/class");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void editClast(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameClass = request.getParameter("nameClass");
        Class classs = classService.findById(id);
        RequestDispatcher dispatcher;
        if (classs == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            classs.setClassName(nameClass);
            classService.edit(id, classs);
            request.setAttribute("classs", classs);
            request.setAttribute("massage", "Chinh sua thanh cong");
            dispatcher = request.getRequestDispatcher("class/edit.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createClass(HttpServletRequest request, HttpServletResponse response) {
        String nameClass = request.getParameter("nameClass");
        int id = (int) (Math.random() * 10000);
        Class classs = new Class(id, nameClass);
        classService.create(classs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("class/create.jsp");
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
