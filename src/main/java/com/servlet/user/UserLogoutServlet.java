package com.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/userLogout")
public class UserLogoutServlet extends HttpServlet {

    public UserLogoutServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            GETTING THE SESSION
            HttpSession httpSession = request.getSession();
//            REMOVING THE SESSION FROM LOCAL
            httpSession.removeAttribute("userObj");
            httpSession.setAttribute("successMsg", "User LogOut Successfully");
//            REDIRECT..
            response.sendRedirect("user_login.jsp");
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
