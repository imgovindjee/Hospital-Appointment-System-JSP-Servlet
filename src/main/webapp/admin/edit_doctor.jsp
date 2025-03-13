<%@page import="com.db.DBConnection"%>
<%@page import="com.DAO.DoctorDAO"%>
<%@page import="com.DAO.SpecialistDAO"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.entity.Specialist"%>
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

    <title>Edit Doctor Page | Admin</title>
<head>


<body>

    <%@include file="navbar.jsp" %>

    <div class="container-fluid p-3">
   		<div class="row">

            <div class="col-md-4 offset-4">
            	<div class="card my-card">
            		<div class="card-body">
            			<p class="fs-3 text-center text-danger">
            			    Edit Doctor Details
            			</p>

            			<c:if test="${not empty successMsg }">
            				<p class="text-center text-success fs-3">
            				    ${successMsg}
            				</p>
            				<c:remove var="successMsg" scope="session" />
            			</c:if>

            			<c:if test="${not empty errorMsg }">
            				<p class="text-center text-danger fs-3">
            				    ${errorMsg}
            				</p>
            				<c:remove var="errorMsg" scope="session" />
            			</c:if>

            			<%
            				int id = Integer.parseInt(request.getParameter("id"));

            				DoctorDAO doctorDAO = new DoctorDAO(DBConnection.getConnection());
            				Doctor doctor = doctorDAO.getDoctorById(id);
            			%>
            			    <form action="../updateDoctor" method="post">
            					<div class="mb-3">
            						<label class="form-label">
            						    Full Name
            						</label>
            						<input name="fullName" type="text" placeholder="Enter Full Name" class="form-control" value="<%=doctor.getFullName()%>">
                                </div>

            					<div class="mb-3">
            						<label class="form-label">
            						    Date of Birth
            						</label>
            						<input name="dateOfBirth" type="date" placeholder="Enter Date Of Birth" class="form-control" value="<%=doctor.getDateOfBirth()%>">
                                </div>

            					<div class="mb-3">
            						<label class="form-label">
            						    Qualification
            						</label>
            						<input name="qualification" type="text" placeholder="Enter qualification" class="form-control" value="<%=doctor.getQualification()%>">
            					</div>

            					<div class="mb-3">
            						<label class="form-label">
            						    Specialist
            						</label>
            						<select class="form-control" name="specialist">
            							<option>
            							    <%=doctor.getSpecialist()%>
            							</option>
                     					<%
            								SpecialistDAO specialistDAO = new SpecialistDAO(DBConnection.getConnection());
            								List<Specialist> specialistDAOList = specialistDAO.getAllSpecialist();
            								for (Specialist sl : specialistDAOList) {
            							%>
            								<option>
            									<%=sl.getSpecialistName()%>
            								</option>
            							<%
            								}
            							%>
            						</select>
            					</div>

            					<div class="mb-3">
            						<label class="form-label">
            						    Email Address
            						</label>
            						<input name="email" type="email" placeholder="Enter Email" class="form-control" value="<%=doctor.getEmail()%>">
                                </div>

            					<div class="mb-3">
            						<label class="form-label">
            						    Phone
            						</label>
            						<input name="phone" type="text" placeholder="Enter Phone Number" class="form-control" value="<%=doctor.getPhone()%>">
                                </div>

            					<div class="mb-3">
            						<label class="form-label">
            						    Password
            						</label>
            						<input name="password" type="text" placeholder="Enter password" class="form-control" value="<%=doctor.getPassword()%>">
            					</div>

            					<div class="mb-3">
            						<input name="id" type="hidden" class="form-control" value="<%=doctor.getID()%>">
            					</div>

            					<button type="submit" class="btn btn-danger text-white col-md-12">
            					    Update
            					</button>
            				</form>
            			</div>

            		</div>
            	</div>

        </div>
    </div>
</body>

</html>