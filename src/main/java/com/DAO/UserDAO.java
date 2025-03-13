package com.DAO;

import com.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    private Connection connection;


    public UserDAO(Connection connection) {
        super();
        this.connection = connection;
    }


    public boolean userRegister(User user) {
        boolean flag = false;
        try {
//            QUERY-SQL
            String query = "insert into user_details(full_name, email, password) values(?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

//            EXECUTE QUERY
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return flag;
    }



    public User loginUser(String email, String password) {
        User user = null;
        try {
//            SQL-QUERY
            String query = "select * from user_details where email=? and password=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
//            Execute-query
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()) {
                user = new User();
                user.setID(resultSet.getInt("id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return user;
    }



    public boolean checkOldPassword(int userID, String oldPassword) {
        boolean flag = false;
        try {
//            SQL_QUERY
            String query = "select * from user_details where id=? and password=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, oldPassword);
//            Execute-query
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()) {
                flag = true;
            }
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return flag;
    }



    public boolean changePassword(int userID, String newPassword) {
        boolean flag = false;
        try {
//            SQL_QUERY
            String query = "update user_details set password=? where id=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, userID);

//            EXECUTE-QUERY
            preparedStatement.executeUpdate();
            flag = true;
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return flag;
    }
}
