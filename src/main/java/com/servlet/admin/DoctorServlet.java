package com.servlet.admin;

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



@WebServlet("/addDoctor")
public class DoctorServlet extends HttpServlet {

    public DoctorServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            DATE RETRIEVAL
            String fullName = request.getParameter("fullName");
            String dateOfBirth = request.getParameter("dateOfBirth");
            String qualification = request.getParameter("qualification");
            String specialist = request.getParameter("specialist");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");

            Doctor doctor = new Doctor(fullName, dateOfBirth, qualification, specialist, email, phone, password);
//            DB CONNECTION AND UPDATE's
            DoctorDAO doctorDAO = new DoctorDAO(DBConnection.getConnection());
            boolean status_flag = doctorDAO.registerDoctor(doctor);
//            SESSION CREATION
            HttpSession httpSession = request.getSession();
            if (status_flag) {
                httpSession.setAttribute("successMsg", "Doctor added Successfully");
//                REDIRECT TO
                response.sendRedirect("admin/view_doctor.jsp");
            } else {
                httpSession.setAttribute("errorMsg", "Something went wrong on server");
//                REDIRECT TO
                response.sendRedirect("admin/doctor.jsp");
            }
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
