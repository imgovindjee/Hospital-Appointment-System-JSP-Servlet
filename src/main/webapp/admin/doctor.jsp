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

    <title>Doctor Page | Admin</title>
<head>


<body>

    <%@include file="navbar.jsp" %>

    <div class="container-fluid p-3">
   		<div class="row">

   			<div class="col-md-12">
   				<div class="card my-card">
   					<div class="card-body">
   						<p class="fs-3 text-center text-danger">
   						    Add Doctor
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


   						<form action="../addDoctor" method="post">
                        	<div class="mb-3">
                        		<label class="form-label">
                        		    Full Name
                        		</label>
                        		<input name="fullName" type="text" placeholder="Enter Full Name" class="form-control">
                            </div>

                        	<div class="mb-3">
                        		<label class="form-label">
                        		    Date of Birth
                        		</label>
                        		<input name="dateOfBirth" type="date" placeholder="Enter Date Of Birth" class="form-control">
                            </div>

                            <div class="mb-3">
                        		<label class="form-label">
                        		    Qualification
                        		</label>
                        		<input name="qualification" type="text"	placeholder="Enter Qualification" class="form-control">
                        	</div>

                        	<div class="mb-3">
                        		<label class="form-label">
                        		    Specialist
                        		</label>
                        		<select class="form-control" name="specialist">
                        			<option disabled="disabled" selected="selected">
                        			    ---Select---
                        			</option>
                                    <%
                        				SpecialistDAO specialistDAO = new SpecialistDAO(DBConnection.getConnection());
                        				List<Specialist> specialistList = specialistDAO.getAllSpecialist();
                        			    for (Specialist sl : specialistList) {
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
                        		    Email address
                        		</label>
                        		<input name="email" type="email" placeholder="Enter Email" class="form-control">
                            </div>

                        	<div class="mb-3">
                        		<label class="form-label">
                        		    Phone
                        		</label>
                        		<input name="phone" type="text" placeholder="Enter Phone Number" class="form-control">
                            </div>

                        	<div class="mb-3">
                        		<label class="form-label">
                        		    Password
                        		</label>
                        		<input name="password" type="password" placeholder="Enter password" class="form-control">
                        	</div>

                        	<button type="submit" class="btn btn-danger text-white col-md-12">
                        	    Register
                        	</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>

</html>