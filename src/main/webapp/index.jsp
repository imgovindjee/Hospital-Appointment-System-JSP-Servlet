<%@page import="com.db.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>


<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

    <%@include file="masterJSandStyle.jsp"%>
    <style type="text/css">
       .my-card {
          box-shadow: 0px 0px 10px 1px maroon;
       }
    </style>

    <title>Home Page | Doctor Patient Portal</title>
<head>


<body>

    <%@include file="components/navbar.jsp" %>

   <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
       <div class="carousel-indicators">
        	<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          	<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
           	<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
           	<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>
       </div>

       <div class="carousel-inner">
           <div class="carousel-item active">
               	<img src="assets/images/doctor_2.jpg" class="d-block w-100" alt="..." height="500px">
           </div>
           <div class="carousel-item">
               	<img src="assets/images/doctor_1.jpg" class="d-block w-100" alt="..." height="500px">
           </div>
           <div class="carousel-item">
              	<img src="assets/images/hospital4.jpg" class="d-block w-100" alt="..." height="500px">
           </div>
           <div class="carousel-item">
               	<img src="assets/images/doctor_3.jpg" class="d-block w-100" alt="..."	height="500px">
           </div>
       </div>

       <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
           	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
           	<span class="visually-hidden">
           		Previous
           	</span>
       </button>
       <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
           	<span class="carousel-control-next-icon" aria-hidden="true"></span>
           	<span class="visually-hidden">
           	    Next
           	</span>
       </button>
   </div>


   <div class="container p-3">
   		<p class="text-center mt-2 mb-5 fs-2 myP-color">
   		    Some key Features of our
   			Doctor Patient Portal
   		</p>

   		<div class="row">
   			<div class="col-md-8 p-5">
   				<div class="row">

   					<div class="col-md-6">
   						<div class="card my-card">
   							<div class="card-body">
   								<p class="fs-5 myP-color">
   								    11000+ Healing Hands
   								</p>
   								<p>
   								    Largest network of the world’s finest and brightest
   									medical experts who provide compassionate care using
   									outstanding expertise.
   								</p>
   							</div>
   						</div>
   					</div>
   					<br>

   					<div class="col-md-6">
   						<div class="card my-card">
   							<div class="card-body">
   								<p class="fs-5 myP-color">
   								    Most Advance Healthcare Technology
   								</p>
   								<p>
   								    E-Hospitals has been the pioneer in bringing
   								    ground-breaking health care technologies to India.
   								</p>
   							</div>
   						</div>
   					</div>
   					<br>

   					<div class="col-md-6 mt-2">
   						<div class="card my-card">
   							<div class="card-body">
   								<p class="fs-5 myP-color">
   								    Best Clinical Outcomes
   								</p>
   								<p>
   								    Leveraging its vast medical expertise & technological
   									advantage, E-Hospitals has consistently delivered best in class
   									clinical outcomes.
   								</p>
   							</div>
   						</div>
   					</div>
   					<br>

   					<div class="col-md-6 mt-2">
   						<div class="card my-card">
   							<div class="card-body">
   								<p class="fs-5 myP-color">
   								    500+ Pharmacies
   								</p>
   								<p>
   								    E-Hospital Pharmacy is our first, largest and most
   									trusted branded pharmacy network, with over 150 plus outlets
   									covering the entire nation
   								</p>
   							</div>
   						</div>
   					</div>
   					<br>

   				</div>
   			</div>

   			<div class="col-md-4 mt-2 mys-card">
   				<img class="mt-3" alt="" src="assets/images/doctor_1.jpg" height="440px" width="470px">
   			</div>
   		</div>
   </div>

    <hr>

   <div class="container p-2">
   		<p class="text-center fs-2 myP-color">
   		    Our Team
   		</p>

   		<div class="row">

   			<div class="col-md-3">
   				<div class="card my-card">
   					<div class="card-body text-center">
   						<img alt="" src="assets/images/doc1.jpg" height="300px" width="230px">
   						<p class="fw-bold fs-5">
   						    Dr. John
   						</p>
   						<p class="fs-7">
   						    (CEO & Chairman)
   						</p>
   					</div>
   				</div>
   			</div>

   			<div class="col-md-3">
   				<div class="card my-card">
   					<div class="card-body text-center">
   						<img alt="" src="assets/images/doc2.jpg" height="300px" width="230px">
   						<p class="fw-bold fs-5">
   						    Dr. Brad
   						</p>
   						<p class="fs-7">
   						    (Chief Doctor)
   						</p>
   					</div>
   				</div>
   			</div>

   			<div class="col-md-3">
   				<div class="card my-card">
   					<div class="card-body text-center">
   						<img alt="" src="assets/images/doc3.jpg" height="300px" width="230px">
   						<p class="fw-bold fs-5">
   						    Dr. Jennifer
   						</p>
   						<p class="fs-7">
   						    (Chief Doctor)
   						</p>
   					</div>
   				</div>
   			</div>

   			<div class="col-md-3">
   				<div class="card my-card">
   					<div class="card-body text-center">
   						<img alt="" src="assets/images/doc4.jpg" height="300px" width="230px">
   						<p class="fw-bold fs-5">
   						    Dr. Maria
   						</p>
   						<p class="fs-7">
   						    (Dean)
   						</p>
   					</div>
   				</div>
   			</div>

   		</div>
   </div>


    <%@include file="components/footer.jsp" %>

</body>

</html>
