<%@page import="com.db.DBConnection"%>
<%@page import="com.DAO.DoctorDAO"%>
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

    <title>Admin Page</title>
<head>


<body>

    <%@include file="navbar.jsp" %>


    <c:if test="${empty adminObj }">
    	<c:redirect url="../admin_login.jsp"></c:redirect>
    </c:if>


    <div class="container p-5">
    	<p class="text-center text-danger fs-3">
    	    Admin Dashboard
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
    		DoctorDAO doctorDAO = new DoctorDAO(DBConnection.getConnection());
    		int totalNumberOfDoctor = doctorDAO.countTotalDoctor();
    		int totalNumberOfUser = doctorDAO.countTotalUser();
    		int totalNumberOfAppointment = doctorDAO.countTotalAppointment();
    		int totalNumberOfSpecialist = doctorDAO.countTotalSpecialist();
    	%>
    		<div class="row">

    			<div class="col-md-4">
    				<div class="card my-card">
    					<div class="card-body text-center text-danger">
    						<i class="fa-solid fa-user-doctor fa-3x"></i>
    						<br>
    						<p class="fs-4 text-center">
    							Doctor
    							<br>
    							<%= totalNumberOfDoctor %>
    						</p>
    					</div>
    				</div>
    			</div>

    			<div class="col-md-4">
    				<div class="card my-card">
    					<div class="card-body text-center text-danger">
    						<i class="fas fa-user-circle fa-3x"></i>
    						<br>
    						<p class="fs-4 text-center">
    							User
    							<br>
    							<%= totalNumberOfUser %>
    						</p>
    					</div>
    				</div>
    			</div>

    			<div class="col-md-4">
    				<div class="card my-card">
    					<div class="card-body text-center text-danger">
    						<i class="fa-solid fa-calendar-check fa-3x"></i>
    						<br>
    						<p class="fs-4 text-center">
    							Total Appointment
    							<br>
    							<%= totalNumberOfAppointment %>
    						</p>
    					</div>
    				</div>
    			</div>

    			<div class="col-md-4 mt-2">
    				<div class="card my-card" data-bs-toggle="modal"
    					data-bs-target="#exampleModal">
    					<div class="card-body text-center text-danger">
    						<i class="fa-solid fa-user-doctor fa-3x"></i>
    						<br>
    						<p class="fs-4 text-center">
    							Specialist
    							<br>
    							<%= totalNumberOfSpecialist %>
    						</p>
    					</div>
    				</div>
    			</div>
    		</div>

    	</div>

    	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			<div class="modal-header">
        				<h5 class="modal-title text-danger" id="exampleModalLabel">
        				    Add Specialist
        				</h5>
        				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        			</div>

        			<div class="modal-body">
                        <form action="../addSpecialist" method="post">
                    		<div class="form-group">
        						<label class="form-label">
        						    Enter Specialist Name
        						</label>
        						<input type="text" name="specialistName" placeholder="Enter Specialist Name" class="form-control" />
        					</div>
        					<div class="text-center mt-2">
        						<button type="submit" class="btn btn-outline-danger ">
        						    Add
        						</button>
        					</div>
                        </form>
                    </div>

        			<div class="modal-footer">
        				<button type="button" class="btn btn-secondary"	data-bs-dismiss="modal">
        				    Close
        				</button>
                    </div>

        		</div>
        	</div>
        </div>

</body>

</html>