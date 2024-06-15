package org.example.zms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.db.BatchDao;
import org.example.db.ParticipantDao;
import org.example.db.UserDao;
import org.example.model.Batch;
import org.example.model.Participant;
import org.example.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name="home", value = "/home")
public class Home extends HttpServlet {

    ParticipantDao participantDao = new ParticipantDao();
    BatchDao batchDao = new BatchDao();
    UserDao userDao = new UserDao();
    User user = new User();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        user.setEmail(request.getParameter("textEmail"));
        user.setPassword(request.getParameter("textPassword"));

        if (Objects.equals(userDao.getPasswordForEmail(user.getEmail()), user.getPassword())) {

            ArrayList<Participant> participants = participantDao.getParticipants();
            request.setAttribute("participants", participants);
            ArrayList<Batch> batches = batchDao.getBatches();
            request.setAttribute("batches", batches);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            out.print("<center><h3>User's Email and/or password doesn't match</h3></center>");


        }


    }



}

