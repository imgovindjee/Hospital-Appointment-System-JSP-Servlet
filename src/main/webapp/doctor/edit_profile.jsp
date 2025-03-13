<%@page import="java.util.List" %>
<%@page import="com.db.DBConnection"%>
<%@page import="com.entity.Specialist"%>
<%@page import="com.DAO.SpecialistDAO"%>
<%@page import="com.entity.Doctor" %>
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

    <title>Edit Doctor | Doctor</title>
<head>


<body>

    <%@include file="navbar.jsp" %>

    <c:if test="${empty doctorObj }">
        <c:redirect url="../doctor_login.jsp"></c:redirect>
    </c:if>



    <div class="container p-4">
    	<div class="row">
    	    <div class="col-md-4">
    			<div class="card my-card">


    		    	<div class="card-body">
    					<p class="fs-3 text-center text-success">
    					    Change Password
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
                            Doctor doctorObj = (Doctor) session.getAttribute("doctorObj");
                            if (doctorObj == null) {
                                response.sendRedirect("doctor_login.jsp");
                                return;
                            }
                        %>
   						<form action="../doctorChangePassword" method="post">
    						<div class="mb-3">
    							<label class="form-label">
    							    Enter New Password
    							</label>
    							<input name="newPassword" type="password" placeholder="Enter New Password" class="form-control" required="required">
                            </div>

    						<div class="mb-3">
    							<label class="form-label">Enter Old Password</label>
    							<input name="oldPassword" type="password" placeholder="Enter Old Password" class="form-control" required>
    						</div>

    						<input type="hidden" value="${doctorObj.getID()}" name="doctorId">

    						<button type="submit" class="btn btn-success col-md-12">
    						    Change Password
    						</button>
    					</form>
    				</div>

    			</div>
    		</div>





            <div class="col-md-6  offset-md-2">
            	<div class="card my-card">
                    <div class="card-body">
            			<p class="fs-3 text-center text-success">
            			    Edit Doctor Profile
            			</p>

          				<c:if test="${not empty successMsgForD }">
          					<p class="text-center text-success fs-5">
          					    ${successMsgForD}
          					</p>
          					<c:remove var="successMsgForD" scope="session" />
          				</c:if>

            			<c:if test="${not empty errorMsgForD }">
            				<p class="text-center text-danger fs-5">
            				    ${errorMsgForD}
            				</p>
            				<c:remove var="errorMsgForD" scope="session" />
            			</c:if>


            			<form action="../doctorEditProfile" method="post">
            				<div class="mb-3">
            					<label class="form-label">
            					    Full Name
            					</label>
            					<input name="fullName" type="text" placeholder="Enter Full Name" class="form-control" value="${doctorObj.getFullName()}">
                            </div>

            				<div class="mb-3">
            					<label class="form-label">
            					    Date of Birth
            					</label>
            					<input name="dateOfBirth" type="date" placeholder="Enter Date Of Birth" class="form-control" value="${doctorObj.getDateOfBirth()}">
                            </div>

            				<div class="mb-3">
            					<label class="form-label">
            					    Qualification
            				    </label>
            					<input name="qualification" type="text"	placeholder="Enter Qualification" class="form-control" value="${doctorObj.getQualification()}">
            				</div>

            				<div class="mb-3">
            					<label class="form-label">
            					    Specialist
            					</label>
            					<select	class="form-control" name="specialist">
            						<option>${ doctorObj.specialist }</option>
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
            					    Email address
            					</label>
            					<input name="email" type="email" placeholder="Enter Email" class="form-control" readonly value="${doctorObj.getEmail()}">
                            </div>

            				<div class="mb-3">
            					<label class="form-label">
            					    Phone
            					</label>
            					<input name="phone" type="text" placeholder="Enter Phone Number" class="form-control" value="${doctorObj.getPhone()}">
            				</div>

            				<input type="hidden" value="${doctorObj.getID()}" name="doctorId">

        					<button type="submit" class="btn btn-success text-white col-md-12">
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