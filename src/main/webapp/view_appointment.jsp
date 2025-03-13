<%@page import="com.entity.Doctor" %>
<%@page import="com.entity.User" %>
<%@page import="com.entity.Appointment" %>
<%@page import="com.db.DBConnection" %>
<%@page import="com.DAO.DoctorDAO" %>
<%@page import="com.DAO.AppointmentDAO" %>
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

    <title>View Appointment</title>
</head>

<body>
    <%@include file="components/navbar.jsp" %>



    <c:if test="${empty userObj }">
        <c:redirect url="/user_login.jsp"></c:redirect>
    </c:if>

    <div class="container-fluid my-bg-img p-5">
        <p class="text-center fs-2 text-white"></p>
    </div>


    <div class="col-md-9">
    	<div class="card my-card">

    		<div class="card-body">

    			<p class="fw-bold text-center myP-color fs-4">
    			    Appointment List
    			</p>

    			<%--
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
    			--%>

                <table class="table table-striped">
                	<thead>
                		<tr class="my-bg-color text-white">
                			<th scope="col">Id</th>
                			<th scope="col">Full Name</th>
                			<th scope="col">Gender</th>
                			<th scope="col">Age</th>
                			<th scope="col">Appointment Date</th>
                			<th scope="col">Email</th>
                			<th scope="col">Phone</th>
                			<th scope="col">Diseases</th>
                			<th scope="col">Doctor Name</th>
                			<th scope="col">Status</th>
                		</tr>
             		</thead>

                	<tbody>
                		<%
                			User user = (User) session.getAttribute("userObj");
                			if (user == null) {
                			    response.sendRedirect("user_login.jsp");
                			    return;
                			}

                			DoctorDAO doctorDAO = new DoctorDAO(DBConnection.getConnection());

                			AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnection.getConnection());

                			List<Appointment> appointmentDAOList = appointmentDAO.getAllAppointmentByLoginUser(user.getID());
                			for (Appointment al : appointmentDAOList) {
                				Doctor doctor = doctorDAO.getDoctorById(al.getDoctorID());
                		%>
                            <tr>
                                <td><%=al.getFullName()%></td>
                                <td><%=al.getGender()%></td>
                                <td><%=al.getAge()%></td>
                                <td><%=al.getAppointmentDate()%></td>
                                <%-- <td><%= al.getEmail()%></td> --%>
                                <td><%=al.getPhone()%></td>
                                <td><%=al.getDisease()%></td>
                                <td><%=doctor.getFullName()%></td>
                                <td>
                                    <%
                                        if ("Pending".equals(al.getStatus())) {
                                    %>
                                        <a href="" class="btn btn-sm btn-warning">
                                            Pending
                                        </a>
                                    <%
                                        } else {
                                    %>
                                    <%=al.getStatus()%>
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

    <div class="col-md-3 p-3">
        <img src="assets/images/doc1.jpg" alt="Shree Govind Jee's world_doctor Images" width="250px" height="">
    </div>

</body>

</html>