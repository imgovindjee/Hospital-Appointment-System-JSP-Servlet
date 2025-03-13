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
    </style>

    <title>Change Password</title>
</head>

<body>
    <%@include file="components/navbar.jsp" %>

    <c:if test="${empty userObj }">
        <c:redirect url="/user_login.jsp"></c:redirect>
    </c:if>

    <div class="container p-4">
        <div class="row">
            <div class="col-md-4 offset-md-4">

                <div class="card my-card">
               		<div class="card-body">
                        <p class="fs-3 text-center myP-color">
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
                            User userObj = (User) session.getAttribute("userObj");
                            if (userObj == null) {
                                response.sendRedirect("login.jsp");
                                return;
                            }
                        %>
                    	<form action="userChangePassword" method="post">
                    		<div class="mb-3">
                    			<label class="form-label">
                    			    Enter New Password
                    			</label>
                    	    	<input id="newPassword" name="newPassword" type="password" placeholder="Enter new password" class="form-control" required="required">
                    		</div>

                    		<div class="mb-3">
                    			<label class="form-label">
                    			    Old Password
                    			</label>
                    			<input id="oldPassword" name="oldPassword" type="password" placeholder="Enter old password" class="form-control" required>
                    		</div>

                    		<input id="uId" type="hidden" value="${userObj.getID()}" name="userId">

                    		<button type="submit" class="btn col-md-12 text-white my-bg-color">
                    		    Change Password
                    		</button>
                    	</form>

                    </div>
                </div>

            </div>
        </div>
    </div>

</body>

</html>