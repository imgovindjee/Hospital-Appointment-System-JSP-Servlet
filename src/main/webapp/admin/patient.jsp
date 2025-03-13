<%@page import="com.db.DBConnection"%>
<%@page import="com.DAO.DoctorDAO"%>
<%@page import="com.DAO.AppointmentDAO"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>


<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

    <%@include file="../masterJSandStyle.jsp"%>
    <style type="text/css">
       .my-card {
          box-shadow: 0px 0px 10px 1px maroon;
       }
    </style>

    <title>Patient Details | Admin</title>
<head>


<body>

    <%@include file="navbar.jsp" %>

    <div class="col-md-12 p-5">
    	<div class="card my-card">
    		<div class="card-body">
    	    	<p class="text-center text-danger fs-3">
    	    	    Patient Details
    	    	</p>

    			<table class="table table-success table-striped">
    				<thead>
    					<tr class="table">
    						<th scope="col" style="padding-right:70px">Full Name</th>
    						<th scope="col">Gender</th>
    						<th scope="col">Age</th>
    						<th scope="col">Appointment</th>
    						<th scope="col">Email</th>
    						<th scope="col">Phone</th>
    						<th scope="col" style="padding-right:50px">Diseases</th>
    						<th scope="col" style="padding-right:70px">Doctor Name</th>
    						<th scope="col">Address</th>
    						<th scope="col" style="padding-right:100px">Status</th>
                        </tr>
    				</thead>

    			<tbody>
                    <%
                        DoctorDAO doctorDAO = new DoctorDAO(DBConnection.getConnection());

                        AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnection.getConnection());
                        List<Appointment> appointmentList = appointmentDAO.getAllAppointment();
                        for(Appointment al : appointmentList)	{
                            Doctor doctor =	doctorDAO.getDoctorById(al.getDoctorID());
                    %>
                            <tr>
                                <th><%= al.getFullName() %></th>
                                <td><%= al.getGender() %></td>
                                <td><%= al.getAge() %></td>
                                <td><%= al.getAppointmentDate()%></td>
                                <td><%= al.getEmail()%></td>
                                <td><%= al.getPhone()%></td>
                                <td><%= al.getDisease()%></td>
                                <td><%= doctor.getFullName()%></td>
                                <td><%= al.getAddress()%></td>
                                <td><%= al.getStatus()%></td>
                            </tr>
                    <%
                        }
                    %>
                    </tbody>
    		    </table>

    	    </div>
    	</div>
    </div>

</body>

</html>