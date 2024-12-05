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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        ServletContext context=getServletContext();

        // read email,pass from browser/form
        String email=request.getParameter("email").trim();
        String pass=request.getParameter("pass").trim();

        boolean isValid=true;
        // fields not null validation
        if(email.length()==0 || pass.isEmpty()) {
            request.setAttribute("loginError", "Please fill Email/Pass");
            isValid=false;
        } else {
            // verify email & pass in DB
            ToDoDAOIntf dao=ToDoDAOImpl.getInstance();
            int regId=dao.login(email, pass);
            if(regId==0) {
                request.setAttribute("loginError", "Email/Pass is wrong");
                isValid=false;
            } else {
                session.setAttribute("regId", regId);
                context.getRequestDispatcher("/ViewTasks.jsp").forward(request,  response);
            }// else
        }// else
        if(isValid==false) {
            context.getRequestDispatcher("/Login.jsp").forward(request, response);
        }// if	
    }// doPost()
}// class
