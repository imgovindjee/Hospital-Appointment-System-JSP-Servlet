package com.servlet.user;


import com.DAO.AppointmentDAO;
import com.db.DBConnection;
import com.entity.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/addAppointment")
public class AppointmentServlet extends HttpServlet {

    public AppointmentServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            DATE RETRIEVAL
            int userId = Integer.parseInt(request.getParameter("userId"));
            String fullName = request.getParameter("fullName");
            String gender = request.getParameter("gender");
            String age = request.getParameter("age");
            String appointmentDate = request.getParameter("appointmentDate");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String diseases = request.getParameter("diseases");
            int doctorId = Integer.parseInt(request.getParameter("doctorNameSelect"));
            String address = request.getParameter("address");

            Appointment appointment = new Appointment(userId, fullName, gender, age, appointmentDate, email, phone, diseases, doctorId, address, "Pending");
//            DB CONNECTION AND UPDATE's
            AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnection.getConnection());
            boolean status_flag = appointmentDAO.addAppointment(appointment);
//            SESSION CREATION
            HttpSession httpSession = request.getSession();
            if (status_flag) {
                httpSession.setAttribute("successMsg", "Appointment Recorded Successfully");
//                REDIRECT TO
                response.sendRedirect("view_appointment.jsp");
            } else {
                httpSession.setAttribute("errorMsg", "Something went wrong on server");
//                REDIRECT TO
                response.sendRedirect("user_appointment.jsp");
            }
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
