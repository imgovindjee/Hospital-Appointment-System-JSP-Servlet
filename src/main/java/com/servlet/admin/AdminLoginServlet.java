package com.servlet.admin;

import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

    public AdminLoginServlet() {
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

//            LOGIN FOR
//            STATIC ADMIN
            if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
                httpSession.setAttribute("adminObj", new User());
//                REDIRECT TO..
                response.sendRedirect("admin/index.jsp");
            } else {
                httpSession.setAttribute("errorMsg", "Invalid email or password");
//                REDIRECT TO..
                response.sendRedirect("admin_login.jsp");
            }
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
