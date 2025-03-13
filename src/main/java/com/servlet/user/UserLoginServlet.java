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


@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {

    public UserLoginServlet() {
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
            UserDAO userDAO = new UserDAO(DBConnection.getConnection());
            User user = userDAO.loginUser(email, password);
            if (user == null) {
                httpSession.setAttribute("errorMsg", "Invalid email or password");
//                REDIRECT TO..
                response.sendRedirect("user_login.jsp");
            } else {
                httpSession.setAttribute("userObj", user);
//                REDIRECT TO..
                response.sendRedirect("index.jsp");
            }
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}
