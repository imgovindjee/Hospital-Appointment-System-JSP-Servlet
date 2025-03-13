package com.servlet.user;

import com.DAO.UserDAO;
import com.db.DBConnection;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;



@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {

    public UserRegisterServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            DATA RETRIEVAL
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

//            USER OBJECT
            User user = new User(fullName, email, password);

//            DB CONNECTION
            UserDAO userDAO = new UserDAO(DBConnection.getConnection());

//            SESSION CREATION
            HttpSession httpSession = request.getSession();

            boolean status_flag = userDAO.userRegister(user);
            if (status_flag) {
                httpSession.setAttribute("successMsg", "Register Successfully");
//                REDIRECT TO..
                response.sendRedirect("user_login.jsp");
            } else {
                httpSession.setAttribute("errorMsg", "Something went wrong");
//                REDIRECT TO..
                response.sendRedirect("signup.jsp");
            }
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
