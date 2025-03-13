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


@WebServlet("/doctorLogin")
public class DoctorLoginServlet extends HttpServlet {

    public DoctorLoginServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            DATE RETRIEVAL
            String email = request.getParameter("email");
            String password = request.getParameter("password");

//            CREATING SESSION
            HttpSession httpSession = request.getSession();

//            DB CONNECTION
            DoctorDAO doctorDAO = new DoctorDAO(DBConnection.getConnection());
            Doctor doctor = doctorDAO.loginDoctor(email, password);
            if (doctor == null) {
                httpSession.setAttribute("errorMsg", "Invalid email or Password");
//                REDIRECT PAGE TO
                response.sendRedirect("doctor_login.jsp");
            } else {
                httpSession.setAttribute("doctorObj", doctor);
//                REDIRECT PAGE TO
                response.sendRedirect("doctor/index.jsp");
            }
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
