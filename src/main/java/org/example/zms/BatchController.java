package org.example.zms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.db.BatchDao;
import org.example.model.Batch;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="BatchController", value = "/batch-controller")
public class BatchController extends HttpServlet {

    Batch batch = new Batch();
    BatchDao dao = new BatchDao();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        batch.setTitle(request.getParameter("title"));
        batch.setStartTime(request.getParameter("startTime"));
//        batch.setBid(Integer.parseInt(request.getParameter("bid")));

        String crudOperationType = request.getParameter("crudOperationType");

        out.println("<h2>CRUD Operation: "+crudOperationType+"</h2>");
        switch (crudOperationType) {
            case "addBatch": {
                int result = dao.addBatch(batch);
                if (result > 0) {
                    out.println("<h4>" + batch.getTitle() + " added Successfully! </h4>");
                    out.println("<h4>Redirecting...</h4>");
                    response.sendRedirect("home");
                } else {
                    out.println("<h4>Something went wrong! Please try again.</h4>");
                    out.println("<h4>Redirecting...</h4>");
                    response.sendRedirect("home");
                }

                break;
            }
            case "updateBatch": {
                batch.setBid(Integer.parseInt(request.getParameter("bid")));
                int result = dao.updateBatch(batch);
                if (result > 0) {
                    out.println("<h4>" + batch.getTitle() + " updated Successfully! </h4>");
                    out.println("<h4>Redirecting...</h4>");
                    response.sendRedirect("batch-filter?jspPageType=showBatchPage");
                } else {
                    out.println("<h4>Update Operation Failed! Please try again.</h4>");
                    out.println("<h4>Redirecting...</h4>");
                    response.sendRedirect("batch-filter?jspPageType=showBatchPage");
                }

                break;
            }
            case "deleteBatch": {
                int bid = Integer.parseInt(request.getParameter("bid"));
                int result = dao.deleteBatch(bid);
                if (result > 0) {
                    out.println("<h4>" + dao.getBatchTitleByBid(bid) + " deleted Successfully! </h4>");
                    out.println("<h4>Redirecting...</h4>");
                    response.sendRedirect("batch-filter?jspPageType=showBatchPage");
                } else {
                    out.println("<h4>Delete Operation Failed! Please try again.</h4>");
                    out.println("<h4>Redirecting...</h4>");
                    response.sendRedirect("batch-filter?jspPageType=showBatchPage");
                }
                break;
            }
            default:
                out.println("<h2>Invalid CRUD operation!</h2>");
                out.println("<h4>Redirecting...</h4>");
                response.sendRedirect("batch-filter?jspPageType=showBatchPage");
                break;
        }
    }
}
