package org.example.zms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.db.BatchAssignmentDao;
import org.example.db.ParticipantDao;
import org.example.model.Batch;
import org.example.model.Participant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name="participantFilter", value = "/participant-filter")
public class ParticipantFilter extends HttpServlet {


    ParticipantDao participantDao = new ParticipantDao();
    BatchAssignmentDao batchAssignmentDao = new BatchAssignmentDao();


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


//        String crudOperationType = request.getParameter("jspPageType");

        String jspPageType = request.getParameter("jspPageType");

        out.println("<h2>Requested JSP Page: "+jspPageType+"</h2>");
        switch (jspPageType) {
            case "addParticipantPage": {
                request.getRequestDispatcher("addParticipant.jsp").forward(request, response);
                break;
            }
            case "updateParticipantPage": {
                int pid = Integer.parseInt(request.getParameter("pid"));
                Participant participant = participantDao.getParticipantByPid(pid);
                request.setAttribute("participant", participant);
                request.getRequestDispatcher("updateParticipant.jsp").forward(request, response);
                break;
            }
            case "showParticipantPage":
                ArrayList<Participant> participants = participantDao.getParticipants();
                request.setAttribute("participants", participants);
                request.getRequestDispatcher("participants.jsp").forward(request, response);
                break;
            case "getBatchesPerParticipantPage": {
                int pid = Integer.parseInt(request.getParameter("pid"));
                String participantName = participantDao.getParticipantNameByPid(pid);
                ArrayList<Batch> batches = batchAssignmentDao.getBatchesForParticipant(pid);
                request.setAttribute("participantName", participantName);
                request.setAttribute("batches", batches);
                request.setAttribute("pid", pid);
                request.getRequestDispatcher("getBatchesForParticipant.jsp").forward(request, response);
                break;
            }

            case "getBatchesPerParticipantByName": {
                String participantName = request.getParameter("participantName");
                out.println("participant name is: " + participantName);
                int pid = participantDao.getParticipantPidByName(participantName);
                ArrayList<Batch> batches = batchAssignmentDao.getBatchesForParticipant(pid);
                request.setAttribute("participantName", participantName);
                request.setAttribute("batches", batches);
                request.setAttribute("pid", pid);

                request.getRequestDispatcher("getBatchesForParticipant.jsp").forward(request, response);
                break;
            }
            case "findABatchForParticipantPage": {
                int pid = Integer.parseInt(request.getParameter("pid"));
                String participantName = participantDao.getParticipantNameByPid(pid);
                ArrayList<Batch> batches = batchAssignmentDao.findBatchesForParticipant(pid);
                request.setAttribute("participantName", participantName);
                request.setAttribute("batches", batches);
                request.setAttribute("pid", pid);
                request.getRequestDispatcher("findABatch.jsp").forward(request, response);

                break;
            }
        }
    }

}
