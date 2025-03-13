package com.servlet.user;

import com.DAO.UserDAO;
import com.db.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;



@WebServlet("/userChangePassword")
public class ChangeUserPasswordServlet extends HttpServlet {

    public ChangeUserPasswordServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            DATA RETRIEVAL
            int userId =Integer.parseInt(request.getParameter("userId"));
            String newPassword = request.getParameter("newPassword");
            String oldPassword = request.getParameter("oldPassword");

//            DB CONNECTION
            UserDAO userDAO = new UserDAO(DBConnection.getConnection());
//            SESSION CREATION
            HttpSession httpSession = request.getSession();
            if (userDAO.checkOldPassword(userId, oldPassword)) { // CORRECT OLD-PASSWORD
                if (userDAO.changePassword(userId, newPassword)) { // CHANGE OLD-PASSWORD TO NEW-PASSWORD
                    httpSession.setAttribute("successMsg", "Password change Successfully");
//                    REDIRECT..
                    response.sendRedirect("user_login.jsp");
                } else {
                    httpSession.setAttribute("errorMsg", "Something went wrong on Server");
//                    REDIRECT..
                    response.sendRedirect("change_password.jsp");
                }
            } else {
                httpSession.setAttribute("errorMsg", "Old Password doesn't match");
//                    REDIRECT..
                response.sendRedirect("change_password.jsp");
            }
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
