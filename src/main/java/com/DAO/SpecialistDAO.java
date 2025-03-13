package com.DAO;

import com.entity.Specialist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class SpecialistDAO {

    private Connection connection;

    public SpecialistDAO(Connection connection) {
        super();
        this.connection = connection;
    }

    public boolean addSpecialist(String str) {
        boolean flag = false;
        try {
//            SQL-QUERY
            String query = "insert into specialist (specialist_name) values(?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, str);

//            EXECUTE-QUERY
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public List<Specialist> getAllSpecialist() {
        List<Specialist> specialistList = new ArrayList<>();
        Specialist specialist_Obj = null;
        try {
//            SQL-QUERY
            String query = "select * from specialist";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
//            EXECUTE QUERY
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                specialist_Obj = new Specialist();
                specialist_Obj.setID(resultSet.getInt(1));
                specialist_Obj.setSpecialistName(resultSet.getString(2));

                specialistList.add(specialist_Obj);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return specialistList;
    }
}
