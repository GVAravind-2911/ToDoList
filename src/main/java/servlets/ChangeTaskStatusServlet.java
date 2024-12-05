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

@WebServlet("/ChangeTaskStatusServlet")
public class ChangeTaskStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        try {
            int taskId = Integer.parseInt(request.getParameter("taskId").trim());
            int regId = Integer.parseInt(request.getParameter("regId").trim());
            int taskStatus = Integer.parseInt(request.getParameter("taskStatus").trim());

            ToDoDAOIntf dao = ToDoDAOImpl.getInstance();
            boolean isUpdated = dao.changeTaskStatus(regId, taskId, taskStatus);

            if (isUpdated) {
                context.getRequestDispatcher("/ViewTasks.jsp").forward(request, response);
            } else {
                out.println("<h3>Error updating task status</h3>");
            }
        } catch (NumberFormatException e) {
            out.println("<h3>Invalid input format</h3>");
        } catch (Exception e) {
            out.println("<h3>An unexpected error occurred: " + e.getMessage() + "</h3>");
        } finally {
            out.close();
        }
    }
}