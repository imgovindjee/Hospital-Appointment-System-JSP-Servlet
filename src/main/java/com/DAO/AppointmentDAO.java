package com.DAO;

import com.entity.Appointment;
import com.entity.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AppointmentDAO {

    private Connection connection;

    public AppointmentDAO(Connection connection) {
        super();
        this.connection = connection;
    }

    public boolean addAppointment(Appointment appointment) {
        boolean flag = false;
        try {
//            SQL-QUERY
            String query = "insert into appointment(userId,fullName,gender,age,appointmentDate,email,phone,disease,doctorId,address,status) values(?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, appointment.getUserID());
            preparedStatement.setString(2, appointment.getFullName());
            preparedStatement.setString(3, appointment.getGender());
            preparedStatement.setString(4, appointment.getAge());
            preparedStatement.setString(5, appointment.getAppointmentDate());
            preparedStatement.setString(6, appointment.getEmail());
            preparedStatement.setString(7, appointment.getPhone());
            preparedStatement.setString(8, appointment.getDisease());
            preparedStatement.setInt(9, appointment.getDoctorID());
            preparedStatement.setString(10, appointment.getAddress());
            preparedStatement.setString(11, appointment.getStatus());

//            Execute query
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return flag;
    }


    public List<Appointment> getAllAppointmentByLoginUser(int userId) {
        List<Appointment> appointmentList = new ArrayList<>();
        Appointment appointment_Obj = null;
        try {
            String query = "select * from appointment where userId=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
//            Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                appointment_Obj = new Appointment();

                appointment_Obj.setID(resultSet.getInt(1));// appoint id
                appointment_Obj.setUserID(resultSet.getInt(2));// userId
                appointment_Obj.setFullName(resultSet.getString(3));
                appointment_Obj.setGender(resultSet.getString(4));
                appointment_Obj.setAge(resultSet.getString(5));
                appointment_Obj.setAppointmentDate(resultSet.getString(6));
                appointment_Obj.setEmail(resultSet.getString(7));
                appointment_Obj.setPhone(resultSet.getString(8));
                appointment_Obj.setDisease(resultSet.getString(9));
                appointment_Obj.setDoctorID(resultSet.getInt(10));
                appointment_Obj.setAddress(resultSet.getString(11));
                appointment_Obj.setStatus(resultSet.getString(12));

                appointmentList.add(appointment_Obj);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return appointmentList;
    }


    public List<Appointment> getAllAppointmentByLoginDoctor(int doctorId) {
        List<Appointment> appointmentList = new ArrayList<>();
        Appointment appointment_Obj = null;
        try {
            String query = "select * from appointment where doctorId=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, doctorId);
//            Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                appointment_Obj = new Appointment();

                appointment_Obj.setID(resultSet.getInt(1)); // appoint-ID
                appointment_Obj.setUserID(resultSet.getInt(2)); // user-ID
                appointment_Obj.setFullName(resultSet.getString(3));
                appointment_Obj.setGender(resultSet.getString(4));
                appointment_Obj.setAge(resultSet.getString(5));
                appointment_Obj.setAppointmentDate(resultSet.getString(6));
                appointment_Obj.setEmail(resultSet.getString(7));
                appointment_Obj.setPhone(resultSet.getString(8));
                appointment_Obj.setDisease(resultSet.getString(9));
                appointment_Obj.setDoctorID(resultSet.getInt(10));
                appointment_Obj.setAddress(resultSet.getString(11));
                appointment_Obj.setStatus(resultSet.getString(12));

                appointmentList.add(appointment_Obj);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return appointmentList;
    }


    public Appointment getAppointmentById(int id) {
        Appointment appointment = null;
        try {
            String query = "select * from appointment where id=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
//            Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                appointment = new Appointment();

                appointment.setID(resultSet.getInt(1));// appoint id
                appointment.setUserID(resultSet.getInt(2));// userId
                appointment.setFullName(resultSet.getString(3));
                appointment.setGender(resultSet.getString(4));
                appointment.setAge(resultSet.getString(5));
                appointment.setAppointmentDate(resultSet.getString(6));
                appointment.setEmail(resultSet.getString(7));
                appointment.setPhone(resultSet.getString(8));
                appointment.setDisease(resultSet.getString(9));
                appointment.setDoctorID(resultSet.getInt(10));
                appointment.setAddress(resultSet.getString(11));
                appointment.setStatus(resultSet.getString(12));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return appointment;
    }

    public boolean updateDrAppointmentCommentStatus(int appointmentId, int doctorId, String comment) {
        boolean flag = false;
        try {
//            SQL-QUERY
            String query = "update appointment set status=? where id=? and doctorId=?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, comment);
            preparedStatement.setInt(2, appointmentId);
            preparedStatement.setInt(3, doctorId);
//            Execute Query
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return flag;
    }


    public List<Appointment> getAllAppointment() {
        List<Appointment> appointmentList = new ArrayList<>();
        Appointment appointment_Obj = null;
        try {
            String query = "select * from appointment order by id desc";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
//            Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                appointment_Obj = new Appointment();

                appointment_Obj.setID(resultSet.getInt(1)); // appoint-ID
                appointment_Obj.setUserID(resultSet.getInt(2)); // user-ID
                appointment_Obj.setFullName(resultSet.getString(3));
                appointment_Obj.setGender(resultSet.getString(4));
                appointment_Obj.setAge(resultSet.getString(5));
                appointment_Obj.setAppointmentDate(resultSet.getString(6));
                appointment_Obj.setEmail(resultSet.getString(7));
                appointment_Obj.setPhone(resultSet.getString(8));
                appointment_Obj.setDisease(resultSet.getString(9));
                appointment_Obj.setDoctorID(resultSet.getInt(10));
                appointment_Obj.setAddress(resultSet.getString(11));
                appointment_Obj.setStatus(resultSet.getString(12));

                appointmentList.add(appointment_Obj);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return appointmentList;
    }
}
