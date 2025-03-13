package com.servlet.doctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/doctorLogout")
public class DoctorLogoutServlet extends HttpServlet {

    public DoctorLogoutServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            GETTING THE SESSION
            HttpSession httpSession = request.getSession();
//            REMOVING THE SESSION FROM LOCAL
            httpSession.removeAttribute("doctorObj");
            httpSession.setAttribute("successMsg", "Doctor LogOut Successfully");
//            REDIRECT..
            response.sendRedirect("doctor_login.jsp");
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
