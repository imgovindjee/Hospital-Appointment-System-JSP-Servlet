package com.servlet.doctor;


import com.DAO.DoctorDAO;
import com.db.DBConnection;
import com.entity.Doctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;



@WebServlet("/doctorEditProfile")
public class DoctorEditProfileServlet extends HttpServlet {

    public DoctorEditProfileServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            DATA RETRIEVAL
            int id = Integer.parseInt(request.getParameter("doctorId"));
            String fullName = request.getParameter("fullName");
            String dateOfBirth = request.getParameter("dateOfBirth");
            String qualification = request.getParameter("qualification");
            String specialist = request.getParameter("specialist");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
//            String password = request.getParameter("password");

//            DOCTOR OBJECT CREATION
            Doctor doctor = new Doctor(id, fullName, dateOfBirth, qualification, specialist, email, phone, "");

//            UPDATING TO DB
            DoctorDAO doctorDAO = new DoctorDAO(DBConnection.getConnection());
            boolean flag = doctorDAO.editDoctorProfile(doctor);
//            MANAGING THE SESSION
            HttpSession httpSession = request.getSession();
            if (flag) {
                Doctor updateDoctorObject = doctorDAO.getDoctorById(id);
                httpSession.setAttribute("successMessageForDoctor", "Doctor Update Successfully");
                httpSession.setAttribute("doctorObj", updateDoctorObject);
//                    REDIRECT..
                response.sendRedirect("doctor/edit_profile.jsp");
            } else {
                httpSession.setAttribute("errorMessageForDoctor", "Something Went Wrong on Server");
//                    REDIRECT..
                response.sendRedirect("doctor/edit_profile.jsp");
            }
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
