package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.ToDoDAOImpl;
import dao.ToDoDAOIntf;


@WebServlet("/MarkTaskCompletedServlet")
public class MarkTaskCompletedServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        ServletContext context=getServletContext();

        int regId=Integer.parseInt(request.getParameter("regId"));
        int taskId=Integer.parseInt(request.getParameter("taskId"));

        ToDoDAOIntf dao=ToDoDAOImpl.getInstance();
        boolean flag=dao.markTaskCompleted(regId, taskId);
        if(flag)
            response.sendRedirect("./ViewTasks.jsp");
        else
            out.println("TX Failed");

    }
}
