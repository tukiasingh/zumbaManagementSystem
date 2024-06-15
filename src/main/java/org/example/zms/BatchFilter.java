package org.example.zms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.db.BatchAssignmentDao;
import org.example.db.BatchDao;
import org.example.model.Batch;
import org.example.model.Participant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



@WebServlet(name="batchFilter", value = "/batch-filter")
public class BatchFilter extends HttpServlet {


    BatchDao batchDao = new BatchDao();
    BatchAssignmentDao batchAssignmentDao = new BatchAssignmentDao();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


//        String crudOperationType = request.getParameter("jspPageType");

        String jspPageType = request.getParameter("jspPageType");

        out.println("<h2>Requested JSP Page: "+jspPageType+"</h2>");
        switch (jspPageType) {
            case "addBatchPage": {
                request.getRequestDispatcher("addBatch.jsp").forward(request, response);
                break;
            }
            case "updateBatchPage": {
                int bid = Integer.parseInt(request.getParameter("bid"));
                Batch batch = batchDao.getBatchByBid(bid);
                request.setAttribute("batch", batch);
                request.getRequestDispatcher("updateBatch.jsp").forward(request, response);
                break;
            }
            case "showBatchPage":
                ArrayList<Batch> batches = batchDao.getBatches();
                request.setAttribute("batches", batches);
                request.getRequestDispatcher("batches.jsp").forward(request, response);
                break;
            case "getParticipantsPerBatchPage": {
                int bid = Integer.parseInt(request.getParameter("bid"));
                String batchTitle = batchDao.getBatchTitleByBid(bid);
                ArrayList<Participant> participants = batchAssignmentDao.getParticipantsForBatch(bid);
                request.setAttribute("batchTitle", batchTitle);
                request.setAttribute("bid", bid);
                request.setAttribute("participants", participants);
                request.getRequestDispatcher("getParticipantsForBatch.jsp").forward(request, response);
                break;
            }

            case "getParticipantsPerBatchByName": {
                String batchTitle = request.getParameter("batchTitle");
                out.println("Batch title is: " + batchTitle);
                int bid = batchDao.getBatchBidByTitle(batchTitle);
                ArrayList<Participant> participants = batchAssignmentDao.getParticipantsForBatch(bid);
                request.setAttribute("batchTitle", batchTitle);
                request.setAttribute("bid", bid);
                request.setAttribute("participants", participants);
                request.getRequestDispatcher("getParticipantsForBatch.jsp").forward(request, response);
                break;
            }
//            case "findABatchForParticipantPage": {
//                int pid = Integer.parseInt(request.getParameter("pid"));
//                String participantName = dao.getParticipantNameByPid(pid);
//                ArrayList<Batch> participants = dao.findBatchesForParticipant(pid);
//                request.setAttribute("participantName", participantName);
//                request.setAttribute("batches", batches);
//                request.setAttribute("pid", pid);
//                request.getRequestDispatcher("findABatch.jsp").forward(request, response);
//
//                break;
//            }
        }
//        else if(jspPageType.equals("addParticipant")) {
//
//            int result = dao.deleteParticipant(participant.getPid());
//            if (result > 0) {
//                out.println("<h4>" + participant.getName() + " deleted Successfully! </h4>");
//            } else {
//                out.println("<h4>Delete Operation Failed! Please try again.</h4>");
//            }
    }

}

