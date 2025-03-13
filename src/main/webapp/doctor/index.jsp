<%@page import="com.db.DBConnection"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.DAO.DoctorDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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

    <title>Index Page | Doctor</title>
<head>

<body>
    <%@include file="navbar.jsp" %>

    <c:if test="${empty doctorObj }">
        <c:redirect url="../doctor_login.jsp"></c:redirect>
    </c:if>

    <div class="container p-5">
    	<p class="text-center text-success fs-3">
    	    Doctor DashBoard
    	</p>

    	<%
            DoctorDAO doctorDAO = new DoctorDAO(DBConnection.getConnection());
            int totalNumberOfDoctor = doctorDAO.countTotalDoctor();

            Doctor currentLoginDoctor = (Doctor)session.getAttribute("doctorObj");
            if(currentLoginDoctor == null) {
                response.sendRedirect("../doctor_login.jsp");
                return;
            }
    	%>

    	<div class="row">
    		<div class="col-md-4 offset-md-2">
    			<div class="card my-card">
    				<div class="card-body text-center text-success">
    					<i class="fa-solid fa-user-doctor fa-3x"></i>
    					<br>
    					<p class="fs-4 text-center">
    						Doctor
    						&nbsp;<br><%= totalNumberOfDoctor %>
    					</p>
    				</div>
    			</div>
    		</div>

    		<div class="col-md-4">
    			<div class="card my-card">
    				<div class="card-body text-center text-success">
    					<i class="fa-solid fa-calendar-check fa-3x"></i>
    					<br>
    					<p class="fs-4 text-center">
    						Total Appointment
    						<br>
    						<%= doctorDAO.countTotalAppointmentByDoctorId(currentLoginDoctor.getID()) %>
    					</p>
    				</div>
    			</div>
    		</div>

    	</div>
    </div>

</body>

</html>