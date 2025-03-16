package com.servlet.admin;


import com.DAO.SpecialistDAO;
import com.db.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/addSpecialist")
public class SpecialistServlet extends HttpServlet {

    public SpecialistServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            DATA RETRIEVAL
            String specialistName = request.getParameter("specialistName");

//            DB CONNECTION
            SpecialistDAO specialistDAO = new SpecialistDAO(DBConnection.getConnection());
            boolean flag_status = specialistDAO.addSpecialist(specialistName);
//            SESSION CREATION
            HttpSession httpSession = request.getSession();
            if (flag_status) {
                httpSession.setAttribute("successMsg", "Specialist added Successfully");
//                REDIRECT TO
//                response.sendRedirect("admin/view_doctor.jsp");
                response.sendRedirect("admin/index.jsp");
            } else {
                httpSession.setAttribute("errorMsg", "Something went wrong on server");
//                REDIRECT TO
                response.sendRedirect("admin/index.jsp");
            }
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
