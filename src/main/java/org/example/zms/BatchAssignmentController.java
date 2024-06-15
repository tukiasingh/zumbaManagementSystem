package org.example.zms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.db.BatchAssignmentDao;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="batchAssignment", value = "/batch-assignment")
public class BatchAssignmentController extends HttpServlet {

    BatchAssignmentDao dao = new BatchAssignmentDao();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        int pid = Integer.parseInt(request.getParameter("pid"));
        int bid = Integer.parseInt(request.getParameter("bid"));
        String crudOperationType = request.getParameter("crudOperationType");
        PrintWriter out = response.getWriter();

        switch (crudOperationType) {
            case "registerToBatch": {
                int result = dao.registerToBatch(pid, bid);
                if (result > 0) {
                    out.println("Participant with pid: "+pid+" is registered successfully to Batch with bid: "+bid);
                    response.sendRedirect("participant-filter?pid=10&jspPageType=findABatchForParticipantPage");
                } else {
                    out.println("Batch Registration Failed! Please try again.");
                    response.sendRedirect("participant-filter?pid=10&jspPageType=findABatchForParticipantPage");
                }
                break;
            }
            case "unregisterToBatch": {
                int result = dao.unregister(pid, bid);
                if (result > 0) {
                    out.println("Participant with pid: "+pid+" unregistered successfully for batch: "+bid);
                    response.sendRedirect("participant-filter?pid=10&jspPageType=findABatchForParticipantPage");
                } else {
                    out.println("Unregister operation to batch " +bid+" failed!");
                    response.sendRedirect("participant-filter?pid=10&jspPageType=findABatchForParticipantPage");
                }
                break;
            }
            default:
                out.println("<h2>Invalid CRUD operation!</h2>");
                response.sendRedirect("participant-filter?pid=10&jspPageType=findABatchForParticipantPage");
                break;
        }


    }
}
