<%@page import="java.util.List" %>
<%@page import="com.db.DBConnection"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.DAO.DoctorDAO"%>
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
    </style>

    <title>Patient</title>
<head>


<body>

    <%@include file="navbar.jsp" %>

    <c:if test="${empty doctorObj }">
        <c:redirect url="../doctor_login.jsp"></c:redirect>
    </c:if>


    <div class="container p-3">
    	<div class="row">
    		<div class="col-md-12">
    			<div class="card my-card">

    	    		<div class="card-body">
    					<p class="text-center text-success fs-3">
    					    Patient Details
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

    					<table class="table table-striped">
    						<thead>
    							<tr>
    								<th scope="col" style="padding-right: 100px">Full Name</th>
    								<th scope="col">Gender</th>
    								<th scope="col">Age</th>
    								<th scope="col">Appointment Date</th>
    								<th scope="col">Email</th>
    								<th scope="col">Phone</th>
    								<th scope="col">Diseases</th>
    								<th scope="col">Status</th>
    								<th scope="col">Action</th>
    							</tr>
    						</thead>

    			        	<tbody>
    							<%
    							    Doctor doctor = (Doctor) session.getAttribute("doctorObj");
    							    if(doctor == null) {
    							        response.sendRedirect("../doctor_login.jsp");
    							        return;
    							    }

    								AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnection.getConnection());
    								List<Appointment> appointmentDAOList = appointmentDAO.getAllAppointmentByLoginDoctor(doctor.getID());
    								for (Appointment al : appointmentDAOList) {
    							%>
    								<tr>
    									<th><%=al.getFullName()%></th>
    									<td><%=al.getGender()%></td>
    									<td><%=al.getAge()%></td>
    									<td><%=al.getAppointmentDate()%></td>
    									<td><%=al.getEmail()%></td>
    									<td><%=al.getPhone()%></td>
    									<td><%=al.getDisease()%></td>
    									<td><%=al.getStatus()%></td>
    									<td>
    										<%
    										    if ("Pending".equals(al.getStatus())) {
    										%>
    										    <a href="comment.jsp?id=<%=al.getID()%>" class="btn btn-success btn-sm">
    										        Comment / Prescription
    										    </a>
    										<%
     										    } else {
     										%>
     										    <a href="#!" class="btn btn-success btn-sm disabled">
     										        <i class="fa fa-comment"></i>
     										        Comment / Prescription
     										    </a>
    									    <%
     										    }
     									    %>
                                        </td>
    								</tr>

                                <%
    								}
    							%>
    						</tbody>
    					</table>
    				</div>

    			</div>
    		</div>

    	</div>
    </div>

</body>

</html>