package com.servlet.doctor;

import com.DAO.AppointmentDAO;
import com.db.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {

    public UpdateStatus() {
        super();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            DATE RETRIEVAL
            int id = Integer.parseInt(request.getParameter("id"));
            int doctorId = Integer.parseInt(request.getParameter("doctorId"));
            String comment = request.getParameter("comment");

//            DB CONNECTION AND UPDATE's
            AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnection.getConnection());
            boolean status_flag = appointmentDAO.updateDrAppointmentCommentStatus(id, doctorId, comment);

//            SESSION CREATION
            HttpSession httpSession = request.getSession();
            if (status_flag) {
                httpSession.setAttribute("successMsg", "Comment Updated");
//                REDIRECT PAGE TO
                response.sendRedirect("doctor/patient.jsp");
            } else {
                httpSession.setAttribute("errorMsg", "Something went wrong on server");
//                REDIRECT PAGE TO
                response.sendRedirect("doctor/patient.jsp");
            }
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
