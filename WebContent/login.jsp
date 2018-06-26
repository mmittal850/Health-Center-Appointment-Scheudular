<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

<!--  end of messages -->
	<link href="css/login.css" rel="stylesheet" media="screen">


    <script type="text/javascript">

    </script>
</head>
<body>
<div class="container">


    <header class="header">
		<div style="margin-left:60px;">
	      <img src="assets/img/uaSeal.jpg" class="pull-left span5" alt="banner">
		 </div>
         <div style="margin-right:60px;">
          <img  src="assets/img/uaPool.jpg" alt="logo" class="pull-right col-sm-span3">
	    </div>
	</header>
	<div class="row">
		<div class="col-md-4 text-center">
			<div class="search-box">
				<div class="caption">
					<h3>UAHMS</h3>
					<!--<p>Find to All</p>-->
					
					<!-- logout message -->
<% String m =request.getParameter("message");
   

if(m !=null)

{%>

<span id="myMessage" class="pk"><%=m %></span>

<%}%>

<!-- registration succesfull message -->

<% 
   String m1 =request.getParameter("message1");

if(m1 !=null)

{%>

<span id="myMessage1" class="pk"><%=m1 %></span>

<%}%>

<!-- login failed message -->
					
					<% 
   String m2 =request.getParameter("message2");

if(m2 !=null)

{%>

<span id="myMessage2"  class="pk"><%=m2 %></span>

<%}%>
					
				</div>
				<form action="HomeController" method="post" class="loginForm" role="form" data-toggle="validator">
					<div class="input-group">
						<input type="hidden" name="command" value="login">
						<input type="email" id="name" name="emailid" class="form-control" placeholder="Email" required>
						<input type="password" id="paw"  name="pass" class="form-control" placeholder="Password" required>
						<input type="submit" id="submit" class="form-control" value="Submit">
						<button type="button" class="btn btn-success pull-right" data-toggle="modal" data-target="#patientReg">Patient Registration</button>
						
						
					</div>
				</form>
			</div>
		</div>
		














	</div>
	
<div id="patientReg" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Registration</h4>
      </div>
	  <form  role="form" data-toggle="validator" action="HomeController" method="post">
      <div class="modal-body">
      <input type="hidden" name="command" value="register">  
  <div class="form-group" >
    
      <div class="form-group col-lg-6">
    <label for="fName">First Name*:</label>
    <input type="text" class="form-control" name="fname" id="fName" required maxlength="30">
  </div>
	
   <div class="form-group col-lg-6">
    <label for="lName">Last Name*:</label>
    <input type="text" class="form-control" name="lname" id="lName" required maxlength="30">
  </div>
  <div class="form-group col-lg-6">
    <label for="dob">D.O.B.:</label>
    <div class='input-group date' id='datetimepicker2'>
                    
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
    <input type="text" class="form-control " name="dob" id="dob" required>
    </div>
  </div>


  
   <div class="form-group col-lg-6">
    <label for="userid">Email ID*:</label>
    <input type="email" class="form-control" name="emailid" id="userid"  data-error="Bruh, that email address is invalid" required>
  </div>
  
  
    <div class="form-group col-lg-6">
    <label for="password">Password*:</label>
    <input type="password" class="form-control" name="pass" id="password" required maxlength="15">
  </div>
  
     <div class="form-group col-lg-6">
    <label for="ssn">SSN*:</label>
    <input type="text" class="form-control" name="ssn" id="ssn" maxlength="9" >
  </div>
   
   
     <div class="form-group col-lg-6">
    <label for="street">Address:</label>
    <input type="text" class="form-control" name="address" id="address" required>
  </div>
  
   <div class="form-group col-lg-6">
    <label for="city">City*:</label>
    <input type="text" class="form-control" name="city" id="city" required>
  </div>
  
   <div class="form-group col-lg-6">
    <label for="state">State*:</label>
    <input list="state"  name="state" class="form-control">
	  <datalist id="state">
	<option value="Alabama">
    <option value="Alaska">
    <option value="Arizona ">
    <option value="Arkansas">
    <option value="California">
	<option value="Colorado">
    <option value="Connecticut">
    <option value="Delaware">
    <option value="Florida">
    <option value="Georgia">
	<option value="Hawaii">
    <option value="Idaho">
    <option value="Illinois">
    <option value="Indiana">
    <option value="Iowa">
	<option value="Kansas">
    <option value="Kentucky">
    <option value="Louisiana">
    <option value="Maine">
    <option value="Maryland">	
	<option value="Massachusetts">
    <option value="Michigan">
    <option value="Minnesota ">
    <option value="Mississippi">
    <option value="Missouri">
	<option value="Montana">
    <option value="Nebraska">
    <option value="Nevada">
    <option value="New Hampshire">
    <option value="New Jersey">
	<option value="Hawaii">
    <option value="New Mexico">
    <option value="New York">
    <option value="North Carolina">
    <option value="North Dakota">
	<option value="Ohio">
    <option value="Oklahoma">
    <option value="Oregon">
    <option value="Pennsylvania">
    <option value="Rhode Island">
	<option value="South Carolina ">
    <option value="South Dakota">
    <option value="Tennessee">
    <option value="Texas">
    <option value="Utah">
	<option value="Vermont">
    <option value="Virginia">
    <option value="Washington">
    <option value="West Virginia">
    <option value="Wisconsin">
	<option value="Wyoming">
  </datalist>
  </div>
  
     <div class="form-group col-lg-6">
    <label for="zip">zip*:</label>
    <input type="text" class="form-control" name="zip" id="zip">
  </div>
 <hr class="row-sm-span12">
   <div class="form-group col-lg-6">
    <label for="insCo">Insurance Company*:</label>
    <input list="insCo" class="form-control" name="insCoN">
	 <datalist id="insCo">
	<option value="Unitedhealth Group">
    <option value="Wellpoint Inc. Group">
    <option value="Kaiser Foundation Group">
    <option value="Humana Group">
    <option value="Aetna Group">
	<option value="HCSC Group">
    <option value="Cigna Health Group">
    <option value="Highmark Group">
    <option value="Coventry Corp. Group">
    <option value="HIP Insurance Group">
	<option value="Independence Blue Cross Group">
    <option value="Blue Cross Blue Shield of New Jersey Group">
    <option value="Blue Cross Blue Shield of Michigan Group">
    <option value="California Physicians' Service">
    <option value="Blue Cross Blue Shield of Florida Group">
	<option value="Health Net of California, Inc.">
    <option value="Centene Corp. Group">
    <option value="Carefirst Inc. Group">
    <option value="Wellcare Group">
    <option value="Blue Cross Blue Shield of Massachusetts Group">	
	<option value="UHC of California">
    <option value="Lifetime Healthcare Group">
    <option value="Cambia Health Solutions Inc.">
    <option value="Metropolitan Group">
    <option value="Molina Healthcare Inc. Group">
	<option value="CDPHP">
	<option value="MVP">
	<option value="Medicare">
  </datalist>
  </div>
  
     <div class="form-group col-lg-6">
    <label for="insGro">Ins. GroupID*:</label>
    <input type="text" class="form-control"name="groupid" id="insGro">
  </div>
  
  	</div>

      </div>
      <div class="modal-footer">
	  <button type="submit" class="btn btn-success pull-right">Submit</button> 
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
</form>
    </div>

  </div>
  
</div>
	

</div>
<script type="text/javascript" src="jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script src="js/login.js"></script>



</body>
</html>