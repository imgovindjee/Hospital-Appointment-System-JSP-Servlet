<%@page import="com.entity.Doctor" %>
<%@page import="com.entity.User" %>
<%@page import="com.db.DBConnection" %>
<%@page import="com.DAO.DoctorDAO" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

    <%@include file="masterJSandStyle.jsp" %>
    <style type="text/css">
       .my-card {
          box-shadow: 0px 0px 10px 1px maroon;
       }

       .my-bg-img {
            background: linear-gradient(rgba(0,0,0,0.4), rgba(0,0,0,0.4)), url("assets/images/hospital1.jpg");
            height: 35vh;
            width: 100%;
            background-size: cover;
            background-repeat: no-repeat;
       }
    </style>

    <title>User Appointment</title>
</head>

<body>
    <%@include file="components/navbar.jsp" %>

    <div class="container-fluid my-bg-img p-5">
        <p class="text-center fs-2 text-white"></p>
    </div>


    <div class="container p-3">
        <p class="fs-2"></p>

        <div class="row">
            <div class="col-md-6 p-5">
                <img src="assets/images/doc3.jpg" alt="Shree Govind Jee's Doctor Image" width="370" height="">
            </div>

            <div class="col-md-6">
            	<div class="card my-card">

            		<div class="card-body">
            			<p class="text-center fs-3">
            			    User Appointment
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
                            User userObj = (User) session.getAttribute("userObj");
                            if (userObj == null) {
                                response.sendRedirect("user_login.jsp");
                                return;
                            }
                        %>
            			<form class="row g-3" action="addAppointment" method="post">
                            <input type="hidden" name="userId" value="${ userObj.getID() }">

                            <div class="col-md-6">
            					<label class="form-label">
            					    Full Name
            					</label>
            					<input required="required" name="fullName" type="text" placeholder="Enter full name" class="form-control">
            				</div>

                            <div class="col-md-6">
            					<label class="form-label">
            					    Gender
            					</label>
            					<select class="form-control" name="gender" required="required">
                                    <option selected="selected" disabled="disabled">
                                        ---Select Gender---
                                    </option>
                                    <option value="male">Male</option>
                                    <option value="female">Female</option>
            					</select>
            				</div>

            				<div class="col-md-6">
            					<label class="form-label">
            					    Age
            					</label>
            					<input name="age" required="required" type="number" placeholder="Enter your Age" class="form-control">
            				</div>

            				<div class="col-md-6">
            					<label class="form-label">
            					    Appointment Date
            					</label>

            					<input required="required"	name="appointmentDate" type="date" class="form-control">
            				</div>

            				<div class="col-md-6">
            					<label class="form-label">
            					    Email
            					</label>
            					<input name="email"	required="required"	type="email" placeholder="Enter email" class="form-control">
            				</div>

            				<div class="col-md-6">
            					<label class="form-label">
            					    Phone
            					</label>
            					<input name="phone"	required="required"	type="number" maxlength="11" placeholder="Enter Mobile no." class="form-control">
            				</div>

            				<div class="col-md-6">
            					<label class="form-label">
            					    Diseases
            					</label>
            					<input required="required"	name="diseases" type="text" placeholder="Enter diseases" class="form-control">
            				</div>

            				<div class="col-md-6">
            					<label class="form-label">
            					    Doctor
            					</label>
            					<select required="required" class="form-control" name="doctorNameSelect">
            						<option selected="selected" disabled="disabled">
            						    ---Select---
            						</option>
                                    <%
            							DoctorDAO doctorDAO = new DoctorDAO(DBConnection.getConnection());
            							List<Doctor> doctorList = doctorDAO.getAllDoctor();
            							for(Doctor dl : doctorList)
            								{%>
            									<option value="<%= dl.getID() %>">
            									    <%= dl.getFullName()%> (<%= dl.getSpecialist() %>)
            									</option>
            								<%
            								}
            						%>
            					</select>
            				</div>

        					<div class="col-md-12">
            					<label class="form-label">
            					    Full Address
            					</label>
            					<textarea name="address" required="required" class="form-control" rows="3" cols=""></textarea>
            				</div>

                			<div class="col-md-12">
            					<button type="submit" class="btn my-bg-color text-white col-md-12">
            					    Submit
            				    </button>
            				</div>

            			</form>
            		</div>

            	</div>
            </div>

        </div>
    </div>


    <%@include file="components/footer.jsp" %>


</body>

</html>