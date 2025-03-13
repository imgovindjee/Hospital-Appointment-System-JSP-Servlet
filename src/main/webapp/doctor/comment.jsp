<%@page import="com.db.DBConnection"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.DAO.AppointmentDAO"%>
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

       .my-bg-img {
            background: linear-gradient(rgba(0,0,0,0.4), rgba(0,0,0,0.4)),  url("../assets/images/hospital1.jpg");
            height: 35vh;
            width: 100%;
            background-size: cover;
            background-repeat: no-repeat;
       }
    </style>

    <title>Comment | Prescription Doctor</title>
<head>


<body>
    <%@include file="navbar.jsp" %>

    <c:if test="${empty doctorObj }">
        <c:redirect url="../doctor_login.jsp"></c:redirect>
    </c:if>


    <div class="container-fluid my-bg-img p-5">
    	<p class="text-center fs-2 text-white"></p>
    </div>


    <div class="container p-3">
     	<p class="fs-2"></p>

     	<div class="row">
     		<div class="col-md-6 offset-md-3">
     			<div class="card my-card">

     				<div class="card-body">
     					<p class="text-center fs-3">
     					    Leave a Treatment Comment
     					</p>

     					<c:if test="${not empty successMsg }">
     						<p class="text-center text-success fs-5">
     						    ${successMsg}
     						</p>
     						<c:remove var="successMsg" scope="session" />
     					</c:if>

     					<c:if test="${not empty errorMsg }">
     						<p class="text-center text-danger fs-5">
     						    ${errorMsg}
     						</p>
     						<c:remove var="errorMsg" scope="session" />
     					</c:if>


     					<%
     						int id = Integer.parseInt(request.getParameter("id"));

     						AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnection.getConnection());
     						Appointment appointment = appointmentDAO.getAppointmentById(id);
     					%>
     						<form class="row g-3" action="../updateStatus" method="post">
     							<div class="col-md-6">
     								<label class="form-label">
     								    Full Name
     								</label>
     								<input name="fullName" type="text" placeholder="Enter Full Name" class="form-control" readonly value="<%= appointment.getFullName()%>">
     							</div>

     							<div class="col-md-6">
     								<label class="form-label">
     								    Age
     								</label>
     								<input name="age" type="number" placeholder="Enter Your Age" class="form-control" readonly value="<%= appointment.getAge()%>">
     							</div>

     							<div class="col-md-6">
     								<label class="form-label">
     								    Phone
     								</label>
     								<input name="phone" type="number" maxlength="11" placeholder="Enter Mobile Number" class="form-control" readonly value="<%= appointment.getPhone()%>">
     							</div>

     							<div class="col-md-6">
     								<label class="form-label">
     								    Disease
     								</label>
     								<input name="diseases" type="text" placeholder="Enter Disease" class="form-control" readonly value="<%= appointment.getDisease()%>">
     							</div>

     							<div class="col-md-12">
     								<label class="form-label">
     								    Leave a Comment | Prescription
     								</label>
     								<textarea name="comment" placeholder="Leave a Comment's" class="form-control" rows="" cols=""></textarea>
     							</div>

     							<input type="hidden" name="id" value="<%= appointment.getID()%>" class="form-control">
     							<input type="hidden" name="doctorID" value="<%= appointment.getDoctorID()%>" class="form-control">

     							<div class="col-md-12">
     								<button type="submit" class="btn btn-success col-md-12">
     								    Submit
     								</button>
     							</div>
     						</form>
     					</div>

     				</div>

     			</div>

     		</div>
     	</div>

</body>

</html>