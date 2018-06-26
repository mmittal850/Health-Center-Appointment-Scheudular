<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
<%

	Object sessionid = session.getAttribute("pat_id");
	int patid = (Integer) sessionid;
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="robots" content="noindex, nofollow">

<title>User Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"
	media="screen">
	
	<link href="css/sstyle.css" rel="stylesheet" media="screen">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">

		<div class="row profile">
			<div class="panel-heading">
				<div class="col-md-3">
				
					<div class="profile-sidebar">
						<!-- SIDEBAR USERPIC 
				<div class="profile-userpic">
					<img src="#" class="img-responsive" alt="">
				</div>-->
						<!-- END SIDEBAR USERPIC -->
						<!-- SIDEBAR USER TITLE -->

						<div class="profile-usertitle">
						
							 
						
						
							<div class="profile-usertitle-name">${thePatient.firstName}
								${thePatient.lastName}
							</div>
							<div class="profile-usertitle-job">
								Id:
								${thePatient.id}
							</div>


						</div>
						<!-- END SIDEBAR USER TITLE -->
						<!-- SIDEBAR BUTTONS -->
						<form method="post" action="HomeController">
							<div class="profile-userbuttons">
							<input type="hidden" name="command" value="logout" />
								<!--<button type="button" class="btn btn-success btn-sm"> </button>-->
								<input type="submit" class="btn btn-danger btn-sm"
									value="Logout" id="patientlogout">

							</div>
						</form>
						<!-- END SIDEBAR BUTTONS -->
						<!-- SIDEBAR MENU -->

						<div class="profile-usermenu">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#patientprofile"
									data-toggle="tab"> <i class="glyphicon glyphicon-user"></i>
										View Profile
								</a></li>
								<li><a href="#appointment" data-toggle="tab"> <i
										class="fa fa-hospital-o" style="font-size: 20px"></i> Make
										Appointment
								</a></li>
								<li><a href="#medReport" data-toggle="tab"> <i
										class="fa fa-h-square" style="font-size: 20px"></i>
										Appointment List
								</a></li>
								<li><a href="#precripRefil" data-toggle="tab"> <i
										class="glyphicon glyphicon-ok"></i> Request Refill
								</a></li>
								<li><a href="#message" data-toggle="tab"> <i
										class="glyphicon glyphicon-flag"></i> Messages
								</a></li>
							</ul>
						</div>
						<!-- END MENU -->
					</div>
				</div>
			</div>
			<div class="panel-body">
				<div class="tab-content">
				<div text-align:center>
	<% String m1 =request.getParameter("message3");
       	if(m1 !=null)
			{%>
				<span id="myMessage1" class="pk" ><%=m1 %></span>
				
			<%}%>
			
			</div>

					<!--Patientprofile start -->
					<div class="col-md-9 profile-content tab-pane fade in active"
						id="patientprofile">

						<section>
						
							<div id="sticky" class="container col-sm-10">

								<!-- Nav tabs -->
								<ul class="nav nav-tabs nav-menu" role="tablist">
									<li class="active"><a href="#profile" role="tab"
										data-toggle="tab"> <i class="fa fa-male"></i> Profile
									</a></li>
									<li><a href="#change" role="tab" data-toggle="tab"> </i> Edit Profile
									</a></li>
									<li><a href="#password" role="tab" data-toggle="tab">
											</i> Change Password
									</a></li>
									<li><a href="#insurance" role="tab" data-toggle="tab">
											</i> Edit Insurance
									</a></li>
								</ul>
								<!--nav-tabs close-->

								<!-- Tab panes -->
								<div class="tab-content">
									<div class="tab-pane fade active in" id="profile">
										<div class="container">

											<br clear="all" />
											<div class="row">


												<div class="col-md-8">

													<div class="table-responsive responsiv-table">
														<table class="table bio-table">
															<tbody>
																<tr>
																	<td>Firstname</td>
																	<td>${thePatient.firstName}</td>
																</tr>
																<tr>
																	<td>Lastname</td>
																	<td>${thePatient.lastName}</td>
																</tr>
																<tr>
																	<td>D.O.B.</td>
																	<td>${thePatient.dateofbirth}</td>
																</tr>
																<tr>
																	<td>Email</td>
																	<td>${thePatient.email}</td>
																</tr>
																
																<tr>
																	<td>SSN</td>
																	<td>${thePatient.ssn}</td>
																</tr>
																<tr>
																	<td>Address</td>
																	<td>${thePatient.address}</td>
																</tr>
																<tr>
																	<td>City</td>
																	<td>${thePatient.city}</td>
																</tr>
																<tr>
																	<td>State</td>
																	<td>${thePatient.state}</td>
																</tr>
																<tr>
																	<td>Zip</td>
																	<td>${thePatient.zip}</td>
																</tr>
																<tr>
																	<td>Insurance Group</td>
																	<td>${thePatient.insuranceCompany}</td>
																</tr>
																<tr>
																	<td>Insurance ID</td>
																	<td>${thePatient.insuranceId}</td>
																</tr>

															</tbody>
														</table>
													</div>
													<!--table-responsive close-->
												</div>
												<!--col-md-6 close-->



											</div>
											<!--row close-->




										</div>
										<!--container close-->
									</div>
									<!--tab-pane close-->


									<div class="tab-pane fade" id="change">
										<div class="container fom-main">
											<div class="row">
												<div class="col-sm-8">
													<h2 class="register">Edit Your Profile</h2>
												</div>
												<!--col-sm-8 close-->

											</div>
											<!--row close-->
											<br />
											<div class="row">

												<form class="form-horizontal main_form text-left"
													name="form" action="HomeController" method="post">
													<fieldset>
														<input type="hidden" name="command" value="update">
														<input type="hidden" name="pat_id" value="${thePatient.id}">
											
														<div class="form-group col-md-8">
															<label class="col-md-2 control-label">First Name</label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input name="first_name" value="${thePatient.firstName}"
																		class="form-control" type="text">
																</div>
															</div>
														</div>


														<div class="form-group col-md-8">
															<label class="col-md-2 control-label">Last Name</label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input name="last_name" value="${thePatient.lastName}"
																		class="form-control" type="text">
																</div>
															</div>
														</div>

														<div class="form-group col-md-8">
															<label class="col-md-2 control-label">D.O.B</label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input name="dob" value="${thePatient.dateofbirth}"
																		class="form-control" type="text">
																</div>
															</div>
														</div>


														<div class="form-group col-md-8">
															<label class="col-md-2 control-label">Email</label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input name="email" value="${thePatient.email}"
																		class="form-control" type="text">
																</div>
															</div>
														</div>

														<div class="form-group col-md-8">
															<label class="col-md-2 control-label">SSN</label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input name="ssn" value="${thePatient.ssn}"
																		class="form-control" type="text">
																</div>
															</div>
														</div>

														<div class="form-group col-md-8">
															<label class="col-md-2 control-label">Address</label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<textarea name="address" 
																		class="form-control">${thePatient.address}</textarea>
																</div>
															</div>
														</div>

														<div class="form-group col-md-8">
															<label class="col-md-2 control-label">City</label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input name="city" value="${thePatient.city}"
																		class="form-control" type="text">
																</div>
															</div>
														</div>

														<div class="form-group col-md-8">
															<label class="col-md-2 control-label">State</label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input name="state" value="${thePatient.state}"
																		class="form-control" type="text">
																</div>
															</div>
														</div>

														<div class="form-group col-md-8">
															<label class="col-md-2 control-label">Zip</label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input name="zip" value="${thePatient.zip}"
																		class="form-control" type="text">

																</div>
															</div>
														</div>


														<!-- upload profile picture -->

														<div class="form-group col-md-8">
															<label class="col-md-2 control-label"></label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input type="submit"
																		class="btn .btn-success submit-button"
																		value="Save">
																	

																</div>
															</div>
														</div>
														<!-- Button -->

													</fieldset>
												</form>
											</div>
											<!--row close-->
										</div>
										<!--container close -->
									</div>
									<!--tab-pane close-->

									<!-- change password tab -->
									<div class="tab-pane fade" id="password">
										<div class="container fom-main">
											<div class="row">
												<div class="col-sm-8">
													<h2 class="register">Change Password</h2>
												</div>
												<!--col-sm-8 close-->

											</div>
											<!--row close-->
											<br />
											<div class="row">

												<form class="form-horizontal main_form text-left"
													action="HomeController" method="post" role="form" data-toggle="validator">
													<fieldset>

														<input type="hidden" name="command" value="pass">
														<input type="hidden" name="pat_id" value="${thePatient.id}">														<div class="form-group col-md-8">
															<label class="col-md-2 control-label">Password</label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input name="newpassword"
																		placeholder="Enter New Passord" class="form-control"
																		type="password" required>

																</div>
															</div>
														</div>
														<div class="form-group col-md-8">
															<label class="col-md-2 control-label"></label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input type="submit"
																		class="btn btn-warning submit-button" value="Update">
																</div>
															</div>
														</div>

													</fieldset>
												</form>
												<div class="col-md-4">
			<div class="aro-pswd_info">
				<div id="pswd_info">
					<h4>Password must be requirements</h4>
					<ul>
						<li id="letter" class="invalid">At least <strong>one letter</strong></li>
						<li id="capital" class="invalid">At least <strong>one capital letter</strong></li>
						<li id="number" class="invalid">At least <strong>one number</strong></li>
						<li id="length" class="invalid">Be at least <strong>8 characters</strong></li>
						<li id="space" class="invalid">be<strong> use [~,!,@,#,$,%,^,&,*,-,=,.,;,']</strong></li>
					</ul>
				</div>
			</div>
		</div>
												
												
											</div>
											<!--row close-->
										</div>
										<!--container close -->
									</div>
									<!--tab-pane close-->
									<!-- end of change password tab -->

									<!-- edit insurance tab  -->

									<div class="tab-pane fade" id="insurance">
										<div class="container fom-main">
											<div class="row">
												<div class="col-sm-8">
													<h2 class="register">Edit Insurance Details</h2>
												</div>
												<!--col-sm-8 close-->

											</div>
											<!--row close-->
											<br />
											<div class="row">

												<form class="form-horizontal main_form text-left"
													action="HomeController" method="post" id="contact_form">
													<fieldset>

														<input type="hidden" name="command" value="insurance">
														<input type="hidden" name="pat_id" value="${thePatient.id}">														<div class="form-group col-md-8">
															<label class="col-md-2 control-label">Insurance
																Company</label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input name="newinsgroup" value="${thePatient.insuranceCompany}"
																		class="form-control" type="text">
																</div>
															</div>
														</div>

														<div class="form-group col-md-8">
															<label class="col-md-2 control-label">Insurance
																Group</label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">

																	<input name="newinsid" value="${thePatient.insuranceId}"
																		class="form-control" type="text">

																</div>
															</div>
														</div>
														<div class="form-group col-md-8">
															<label class="col-md-2 control-label"></label>
															<div class="col-md-4 inputGroupContainer">
																<div class="input-group">
																	<input type="submit"
																		class="btn .btn-warning submit-button" value="Update">

																</div>
															</div>
														</div>
													</fieldset>
												</form>
											</div>
											<!--row close-->
										</div>
										<!--container close -->
									</div>
									<!--tab-pane close-->

									<!-- end of edit insurance tab -->

								</div>
								<!--tab-content close-->
							</div>
							<!--container close-->

						</section>
						<!--section close-->

					</div>
					<!-- patient profile End -->



					<!--Appointment start -->
					<div class="col-md-9 profile-content tab-pane fade in"
						id="appointment">

						<form class="well span7" action="HomeController" method="post">
							<legend class="text-center" style="background: lightgreen">
								Make an Appointment</legend>
							<div class="row">
								<div class="col-md-12">
									<div class="btn-toolbar" style="margin: 0px;">
										<div class="btn-group">
											<div class="container">
											
												<input type="hidden" name="patid" value="${thePatient.id}" />
												<input type="hidden" name="command" value="makeApt"/>
												<div class="row">
													<div class='col-sm-4'>
														<div class="form-group">
														<table>
														<tr>
														<td>
															<label for="doc" >Select Date : &nbsp &nbsp &nbsp &nbsp </label></td>
															<td><div class='input-group date' id='datetimepicker1'>

																<span class="input-group-addon"> <span
																	class="glyphicon glyphicon-calendar"></span>
																</span> <input type='text' class="form-control" id="hello"
																	onchange="ondatechange()" name="date" /></div></td>
																	</tr>
															</div>
															</table>
														</div>
													</div>
												</div>

												<div class='col-sm-4'>
													<div class="form-group pull-left">
													<table>
													<tr><td>
														<label for="doc">Choose Time: &nbsp &nbsp &nbsp &nbsp</label></td>
														 <td><select name="time" id="apttime" onchange="ontimechange()" class="form-control">
															<option disabled selected>Select Appointment Time</option>


														</select></td>
														</table>
													</div>
													<div class="form-group pull-left">
													<table>
													<tr>
													<td>
														<label for="doc">Choose Doctor:  &nbsp  &nbsp   </label> </td>
														<td><select name="doctor" id="aptdoctor" class="form-control">
															<option disabled selected>Select Doctor</option>

														</select></td>
														</tr>
														</table>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- /btn-group -->


									<table>
									<tr><td><label>&nbsp &nbsp &nbsp &nbsp Sysmtom/s: &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</label> </td>
									<td><input list="state" name="reason"
										class="form-control">
									    <datalist id="state">
									    <option disabled selected>Select Reason</option>
									    <option value="Aches, Pain, Fever">
										<option value="Chronic Cough">
										<option value="Cold, Flu, Allergy: (OTC Remedies)">
										<option value="Common Cold">
										<option value="Encephalitis and Meningitis">
									</datalist></td></tr>
									<tr><td></td><td><button class="btn btn-info pull-center" type="submit">Submit</button></td></tr>
									</table>
									
									
								</div>
							</div>
						</form>
					</div>
					<!-- Appointment End -->

					<!--Medical Report start -->
					<div class="col-md-9 profile-content tab-pane fade" id="medReport">
			 
						<h3><h4 class="alert-message alert-message-success">Previous Appointments</h4></h3>
						<table id="visit" class="display" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Date</th>
									<th>Time</th>
									<th>Reason</th>
								</tr>
							</thead>
							


							<tbody>

								<c:forEach var="temp" items="${theapp}">
								<tr>


									<td>${temp.date}</td>
									<td>${temp.appTime}</td>
									<td>${temp.reason}</td>

								</tr>
							 </c:forEach>




							</tbody>

						</table>

						<!-- for try -->

						<h3><h4 class="alert-message alert-message-success">Future Appointments</h4></h3>
						<table id="visit1" class="display" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Date</th>
									<th>Time</th>
									<th>Reason</th>
									<th><th>
								</tr>
							</thead>
							
							<tbody>
								<form method="get" name="form">
									<c:forEach var="temp" items="${fapp}">
									<tr>
										<td>${temp.date}</td>


										<td>${temp.appTime}</td>


										<td>${temp.reason}</td>
										<input type="hidden" name="appid" value="${temp.appId}" />
										<input type="hidden" name="command" value="cancel"/>
										<input type="hidden" name="pat_id" value="${temp.pat_id}"/>
										
										<td><input class="btn btn-danger" type="submit"  value="Cancel"
											formaction="HomeController"></td>
									</tr>

								</c:forEach>
								</form>
							</tbody>
						</table>



						<!-- for try end -->

					</div>
					<!-- medical report end-->

					<!--Refill Start -->
					<div class="col-md-9 profile-content tab-pane fade"
						id="precripRefil">

						<table id="visit2" class="display" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Prescription</th>
									<th>Availability</th>
									<th></th>
								</tr>
							</thead>
							
							<tbody>
								<form method="post" name="form" action="">
									<tr>
										<td>doxycylcine</td>
										<td>Yes</td>

										<td><input class="btn btn-info" type="submit" name="cancel" value="Refill">
										</td>
									</tr>
									<tr>
										<td>Paracetamol</td>
										<td>Yes</td>

										<td><input class="btn btn-info" type="submit" name="cancel" value="refill">
										</td>
									</tr>
									

								</form>
							</tbody>
						</table>

					</div>
					<!-- Refill end-->


					<!--Message start -->
					<div class="col-md-9 profile-content tab-pane fade" id="message">

						<table id="visit3" class="display" cellspacing="0" width="100%">
							<thead>
								<tr>

									<th><h4 class="alert-message alert-message-success">Message</h4></th>

								</tr>
							</thead>

							<tbody class="alert-message alert-message-success">

								<c:forEach var="temp" items="${themsg}">
								<tr>
									<td class="pull-left">${temp.message}</td>
								</tr>
								
								</c:forEach>

							</tbody>
						</table>



					</div>
					<!-- message end-->
				</div>
			</div>
				</div>

	</div>



	<center>
		<strong>Powered by Team 3 <a href="#" target="_blank"> </a></strong>
	</center>
	<br>
	<br>
	<script type="text/javascript" language="javascript"
		src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	 <!--  <script type="text/javascript" src="jquery/jquery-1.8.3.min.js"
		charset="UTF-8"></script>-->
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<!--  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>-->
	 
		<script src="js/patientprofile.js"></script>

</body>
</html>

