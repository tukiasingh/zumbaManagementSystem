package org.example.zms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.db.ParticipantDao;
import org.example.db.UserDao;
import org.example.model.Participant;
import org.example.model.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="registerAdmin", value = "/register-admin")
public class Register extends HttpServlet {
    UserDao userDao = new UserDao();
    User user = new User();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        user.setEmail(request.getParameter("textEmail"));
        user.setPassword(request.getParameter("textPassword"));

        int result = userDao.addUser(user);
        if (result > 0) {
            out.println("<h4> Admin" + user.getEmail() + " added Successfully! </h4>");
            out.println("<h4>Redirecting...</h4>");
            response.sendRedirect("index.jsp");
        } else {
            out.println("<h4>Something went wrong! Please try again.</h4>");
            out.println("<h4>Redirecting...</h4>");
            response.sendRedirect("index.jsp");
        }


    }
}
