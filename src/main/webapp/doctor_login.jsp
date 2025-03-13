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

    <title>Doctor Login</title>
</head>

<body>
    <%@include file="components/navbar.jsp" %>

    <div class="container p-5">
        <div class="row">
            <div class="col-md-4 offset-md-4">

                <div class="card my-card">
                	<div class="card-header text-center text-white my-bg-color">
                		<p class="fs-4 text-center text-white mt-2">
           					<i class="fa-solid fa-stethoscope"></i>
           					&nbsp;Doctor Login
             			</p>
               		</div>

               		<div class="card-body">
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

                    	<form action="doctorLogin" method="post">
                    		<div class="mb-3">
                    			<label class="form-label">
                    			    Email Address
                    			</label>
                    	    	<input id="email" name="email" type="email" placeholder="Enter Email" class="form-control">

                    		    <div id="emailHelp" class="form-text">
                    			    We'll never share your email with anyone else.
                    			</div>
                    		</div>

                    		<div class="mb-3">
                    			<label class="form-label">
                    			    Password
                    			</label>
                    			<input id="password" name="password" type="password" placeholder="Enter password" class="form-control">
                    		</div>

                    		<button type="submit" class="btn col-md-12 text-white my-bg-color">
                    		    Submit
                    		</button>
                    	</form>

                    </div>
                </div>

            </div>
        </div>
    </div>

</body>

</html>