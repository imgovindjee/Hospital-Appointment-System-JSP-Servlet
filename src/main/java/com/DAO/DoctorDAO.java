package com.DAO;

import com.entity.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class DoctorDAO {

    private Connection connection;

    public DoctorDAO(Connection connection) {
        super();
        this.connection = connection;
    }

    public boolean registerDoctor(Doctor doctor) {
        boolean flag = false;
        try {
//            SQL-QUERY
            String query = "insert into doctor(fullName,dateOfBirth,qualification,specialist,email,phone,password) values(?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, doctor.getFullName());
            preparedStatement.setString(2, doctor.getDateOfBirth());
            preparedStatement.setString(3, doctor.getQualification());
            preparedStatement.setString(4, doctor.getSpecialist());
            preparedStatement.setString(5, doctor.getEmail());
            preparedStatement.setString(6, doctor.getPhone());
            preparedStatement.setString(7, doctor.getPassword());
//            Execute query
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return flag;
    }


    public List<Doctor> getAllDoctor() {
        List<Doctor> doctorList = new ArrayList<Doctor>();
        Doctor doctor_obj = null;
        try {
            String query = "select * from doctor order by id desc";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
//            Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                doctor_obj = new Doctor();

                doctor_obj.setID(resultSet.getInt("id"));
                doctor_obj.setFullName(resultSet.getString("fullName"));
                doctor_obj.setDateOfBirth(resultSet.getString("dateOfBirth"));
                doctor_obj.setQualification(resultSet.getString("qualification"));
                doctor_obj.setSpecialist(resultSet.getString("specialist"));
                doctor_obj.setEmail(resultSet.getString("email"));
                doctor_obj.setPhone(resultSet.getString("phone"));
                doctor_obj.setPassword(resultSet.getString("password"));

                doctorList.add(doctor_obj);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return doctorList;
    }

    public Doctor getDoctorById(int id) {
        Doctor doctor = null;
        try {
            String query = "select * from doctor where id=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                doctor = new Doctor();

                doctor.setID(resultSet.getInt("id"));
                doctor.setFullName(resultSet.getString("fullName"));
                doctor.setDateOfBirth(resultSet.getString("dateOfBirth"));
                doctor.setQualification(resultSet.getString("qualification"));
                doctor.setSpecialist(resultSet.getString("specialist"));
                doctor.setEmail(resultSet.getString("email"));
                doctor.setPhone(resultSet.getString("phone"));
                doctor.setPassword(resultSet.getString("password"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return doctor;
    }


    public boolean updateDoctor(Doctor doctor) {
        boolean flag = false;
        try {
//            SQL-QUERY
            String query = "update doctor set fullName=?,dateOfBirth=?,qualification=?,specialist=?,email=?,phone=?,password=? where id=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, doctor.getFullName());
            preparedStatement.setString(2, doctor.getDateOfBirth());
            preparedStatement.setString(3, doctor.getQualification());
            preparedStatement.setString(4, doctor.getSpecialist());
            preparedStatement.setString(5, doctor.getEmail());
            preparedStatement.setString(6, doctor.getPhone());
            preparedStatement.setString(7, doctor.getPassword());
            preparedStatement.setInt(8, doctor.getID());
//            Execute query
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteDoctorById(int id) {
        boolean flag = false;
        try {
//            SQL-QUERY
            String query = "delete from doctor where id=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    public Doctor loginDoctor(String email, String password) {
        Doctor doctor = null;
        try {
//            SQL-QUERY
            String query = "select * from doctor where email=? and password=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                doctor = new Doctor();

                doctor.setID(resultSet.getInt(1));
                doctor.setFullName(resultSet.getString(2));
                doctor.setDateOfBirth(resultSet.getString(3));
                doctor.setQualification(resultSet.getString(4));
                doctor.setSpecialist(resultSet.getString(5));
                doctor.setEmail(resultSet.getString(6));
                doctor.setPhone(resultSet.getString(7));
                doctor.setPassword(resultSet.getString(8));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return doctor;
    }

    public int countTotalDoctor() {
        int count = 0;
        try {
//            SQL-QUERY
            String query = "select * from doctor";

//            EXECUTE QUERY
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) count++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return count;
    }

    public int countTotalAppointment() {
        int count = 0;
        try {
//            SQL-QUERY
            String query = "select * from appointment";

//            EXECUTE QUERY
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) count++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return count;
    }

    public int countTotalAppointmentByDoctorId(int doctorId){
        int count = 0;
        try {
//            SQL-QUERY
            String query = "select * from appointment where doctorId=?";

//            EXECUTE QUERY
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, doctorId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) count++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return count;
    }

    public int countTotalUser() {
        int count = 0;
        try {
//            SQL-QUERY
            String query = "select * from user_details";

//            EXECUTE QUERY
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) count++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return count;
    }

    public int countTotalSpecialist() {
        int count = 0;
        try {
//            SQL-QUERY
            String query = "select * from specialist";

//            EXECUTE QUERY
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) count++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return count;
    }


    public boolean checkOldPassword(int doctorId, String oldPassword) {
        boolean flag = false;
        try {
//            SQL_QUERY
            String query = "select * from doctor where id=? and password=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, doctorId);
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

    public boolean changePassword(int doctorId, String newPassword) {
        boolean flag = false;
        try {
//            SQL_QUERY
            String query = "update doctor set password=? where id=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, doctorId);

//            EXECUTE-QUERY
            preparedStatement.executeUpdate();
            flag = true;
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return flag;
    }

    public boolean editDoctorProfile(Doctor doctor) {
        boolean flag = false;
        try {
//            SQL-QUERY
            String query = "update doctor set fullName=?,dateOfBirth=?,qualification=?,specialist=?,email=?,phone=? where id=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, doctor.getFullName());
            preparedStatement.setString(2, doctor.getDateOfBirth());
            preparedStatement.setString(3, doctor.getQualification());
            preparedStatement.setString(4, doctor.getSpecialist());
            preparedStatement.setString(5, doctor.getEmail());
            preparedStatement.setString(6, doctor.getPhone());
            preparedStatement.setInt(7, doctor.getID());
//            Execute query
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return flag;
    }
}
