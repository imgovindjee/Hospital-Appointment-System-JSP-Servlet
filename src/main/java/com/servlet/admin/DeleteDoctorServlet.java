package com.servlet.admin;


import com.DAO.DoctorDAO;
import com.db.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;



@WebServlet("/deleteDoctor")
public class DeleteDoctorServlet extends HttpServlet {

    public DeleteDoctorServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            DATA RETRIEVAL
            int id = Integer.parseInt(request.getParameter("id"));

//            DB CONNECTION
            DoctorDAO DoctorDAO = new DoctorDAO(DBConnection.getConnection());

//            SESSION CREATION
            HttpSession httpSession = request.getSession();

//            CHANGE THE DB
//            DELETE THE DOCTOR_WITH THE "ID=id"
            boolean flag_status = DoctorDAO.deleteDoctorById(id);

            if (flag_status) {
                httpSession.setAttribute("successMsg", "Doctor Deleted Successfully");
//                REDIRECT TO
                response.sendRedirect("admin/view_doctor.jsp");
            } else {
                httpSession.setAttribute("errorMsg", "Something went wrong on server");
//                REDIRECT TO
                response.sendRedirect("admin/view_doctor.jsp");
            }
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
