package com.servlet.doctor;


import com.DAO.DoctorDAO;
import com.db.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;



@WebServlet("/doctorChangePassword")
public class DoctorChangePassword extends HttpServlet {

    public DoctorChangePassword() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            DATA RETRIEVAL
            int doctorId =Integer.parseInt(request.getParameter("doctorId"));
            String newPassword = request.getParameter("newPassword");
            String oldPassword = request.getParameter("oldPassword");

//            DB CONNECTION
            DoctorDAO doctorDAO = new DoctorDAO(DBConnection.getConnection());
//            SESSION CREATION
            HttpSession httpSession = request.getSession();
            if (doctorDAO.checkOldPassword(doctorId, oldPassword)) { // CORRECT OLD-PASSWORD
                if (doctorDAO.changePassword(doctorId, newPassword)) { // CHANGE OLD-PASSWORD TO NEW-PASSWORD
                    httpSession.setAttribute("successMsg", "Password change Successfully");
//                    REDIRECT..
//                    response.sendRedirect("doctor/edit_profile.jsp");
                    response.sendRedirect("doctor_login.jsp");
                } else {
                    httpSession.setAttribute("errorMsg", "Something went wrong on Server");
//                    REDIRECT..
                    response.sendRedirect("doctor/edit_profile.jsp");
                }
            } else {
                httpSession.setAttribute("errorMsg", "Old Password doesn't match");
//                    REDIRECT..
                response.sendRedirect("doctor/edit_profile.jsp");
            }
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
