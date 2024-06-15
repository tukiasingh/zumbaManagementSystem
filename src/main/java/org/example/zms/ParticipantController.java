package org.example.zms;

import org.example.db.ParticipantDao;
import org.example.model.Participant;

import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name ="ParticipantController", value = "/participant-controller")

public class ParticipantController extends HttpServlet {

    Participant participant = new Participant();
    ParticipantDao dao = new ParticipantDao();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        participant.setName(request.getParameter("textName"));
        participant.setPhoneNumber(request.getParameter("textPhone"));
        participant.setEmail(request.getParameter("textEmail"));

        String crudOperationType = request.getParameter("crudOperationType");

        out.println("<h2>CRUD Operation: "+crudOperationType+"</h2>");
        switch (crudOperationType) {
            case "addParticipant": {

                int result = dao.addParticipant(participant);
                if (result > 0) {
                    out.println("<h4>" + participant.getName() + " added Successfully! </h4>");
                } else {
                    out.println("<h4>Something went wrong! Please try again.</h4>");
                }
                out.println("<h4>Redirecting...</h4>");
                response.sendRedirect("home");
                break;
            }
            case "updateParticipant": {
                participant.setPid(Integer.parseInt(request.getParameter("pid")));
                int result = dao.updateParticipant(participant);
                if (result > 0) {
                    out.println("<h4>" + participant.getName() + " updated Successfully! </h4>");
                } else {
                    out.println("<h4>Update Operation Failed! Please try again.</h4>");
                }
                out.println("<h4>Redirecting...</h4>");
                response.sendRedirect("participant-filter?jspPageType=showParticipantPage");
                break;
            }
            case "deleteParticipant": {
                int pid = Integer.parseInt(request.getParameter("pid"));
                int result = dao.deleteParticipant(pid);
                out.println("Got a request to delete participant with pid: " + pid);
                out.println("Going to delete participant: " + dao.getParticipantNameByPid(pid));
                if (result > 0) {
                    out.println("<h4>" + dao.getParticipantNameByPid(pid) + " deleted Successfully! </h4>");
                } else {
                    out.println("<h4>Delete Operation Failed! Please try again.</h4>");
                }
                out.println("<h4>Redirecting...</h4>");
                response.sendRedirect("participant-filter?jspPageType=showParticipantPage");


                break;
            }
            default:
                out.println("<h2>Invalid CRUD operation!</h2>");
                out.println("<h4>Redirecting...</h4>");
                response.sendRedirect("participant-filter?jspPageType=showParticipantPage");
                break;
        }


    }
}
