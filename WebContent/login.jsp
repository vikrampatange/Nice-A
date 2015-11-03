<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NICE-A |Login</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="bootstrapvalidator/vendor/bootstrap/css/bootstrap.css" />
<link rel="stylesheet"
	href="bootstrapvalidator/dist/css/formValidation.css" />

<!-- Include FontAwesome CSS if you want to use feedback icons provided by FontAwesome -->
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" />

<script type="text/javascript"
	src="bootstrapvalidator/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="bootstrapvalidator/vendor/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="bootstrapvalidator/dist/js/formValidation.js"></script>
<script type="text/javascript"
	src="bootstrapvalidator/dist/js/framework/bootstrap.js"></script>



<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="js/forgotpass.js"></script>

<link href="css/autumn-dawn.css" rel="stylesheet">
<link href="css/layout.css" rel="stylesheet">


<script type="text/javascript">
	
</script>

</head>
<body>
<div class="container">
	

		<div>
			<div class="navbar navbar-default">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-responsive-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">NICE-A</a>
				</div>
				<div class="navbar-collapse collapse navbar-responsive-collapse">
					<ul class="nav navbar-nav">
					
					
					
					
						<li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
						<li><a href="<%=request.getContextPath()%>/userregistration.jsp">Registration</a></li>
							
						<li class="active"><a href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
						
						<li><a href="<%=request.getContextPath()%>/sqlinjection.jsp">Attack </a></li>
						
						<!--<li><a href="<%=request.getContextPath()%>/xssattack.jsp">XSS Attack </a></li>-->
						
						<!-- <li><a href="<%=request.getContextPath()%>/bruteForceAttacks.jsp">BruteForce Attack </a></li>-->
						
					</ul>
						
						
						 <ul class="nav navbar-nav navbar-right">
                            <li><a  target="_blank" href="<%=request.getContextPath()%>/saggraph.jsp">SAG</a></li> 
                              
                            <li><a  target="_blank" href="<%=request.getContextPath()%>/acggraph.jsp">ACG</a></li>
                            
                            <li><a  target="_blank" href="<%=request.getContextPath()%>/controlcenterdash.jsp">Control</a></li>
                          
                       </ul>
						
						
					

					
				</div>
			</div>
		</div>
		

		<div id="nav1" border=1>
			<h4>###</h4>
			<hr>


		</div>

		<div id="section">

			<h4>
				<strong>NICE-A </strong>Network Intrusion Detection and
				Countermeasure Selection in Virtual Network Systems
			</h4>
			<div class="row">
				<div class="col-lg-12">

					<%
						if (request.getParameter("message") != null  && request.getParameter("message") != "")
						{
					%>


					<div class="alert alert-danger">

						<a href="#" class="close" data-dismiss="alert">&times;</a>

						<%=request.getParameter("message")%>

					</div>


					<%
						}
					%>
					<div id="loginDiv"class="panel panel-info">
						<div class="panel-heading">
							<h2 class="panel-title">User Login</h2>
						</div>
						<div class="well">

							<form class="form-horizontal" id="userLogin" name="userLogin" action="UserServlet" method="post">

								<input type="hidden" name="action" value="userLogin">
								 <input type="hidden" name="clientIp" value="<%=request.getRemoteHost()%>"> 
								 
								 
								 
									

								<div class="form-group">

									<label for="userName" class="control-label col-xs-4">
										User Name: </label>


									<div class="col-xs-5 ">
										<div class="  input-group">
											<span class="input-group-addon"> <i
												class="fa fa-user fa-fw"></i></span> 
												<input type="text" class="form-control" id="userName" name="userName" placeholder="User Name">
										</div>
										
									</div>

								</div>

								<div class="form-group">

									<label for="password :" class="control-label col-xs-4 ">Password
										:</label>


									<div class="col-xs-5 ">
										<div class="  input-group">
											<span class="input-group-addon"> <i
												class="fa fa-key fa-fw"></i></span> <input type="password"
												class="form-control" id="pass" name="password"
												placeholder="Password">
										</div>
									</div>

								</div>


								<div class="form-group">

									<label for="vm" class="control-label col-xs-4"> Virtual
										Machine :</label>


									<div class="col-xs-4">
										<div class="  input-group">
											<span class="input-group-addon"> <i
												class="fa fa-desktop fa-fw "></i></span> <select
												class="form-control" name="vm" id="vm">
												<option value="">Select</option>
												<option value="VM1">VM1</option>
												<option value="VM2">VM2</option>

											</select>
										</div>
									</div>

								</div>
								
								<div class="form-group">

									<div class="col-xs-offset-4 col-xs-10">

										<button id="login" type="submit" class="btn btn-primary">Login</button>
										<input type="reset" class="btn btn-warning" value="Back" />
										
										
										
										<!-- <input type="button" class="btn btn-warning" value="ForgotPassword" />-->
										
										
										

									</div>
									
									
									<p align="right"><a id="fp">Forogt password?</a>
									<!-- <input type=button onClick="parent.location='ForgotPasswordIndex.jsp'" value='**ForgotPassword'> -->
										
									
									
									

								</div>

							</form>




						</div>

					</div>

<div id="hidden"class="panel panel-info">
						<div class="panel-heading">
							<h2 class="panel-title">Forgot Password</h2>
						</div>
						<div class="well">

							<form class="form-horizontal" id="forgotpassword" name="forgotpassword" action="EmailSend1" method="post">

								<input type="hidden" name="action" value="userLogin">
								 <input type="hidden" name="clientIp" value="<%=request.getRemoteHost()%>"> 
								 
								 
								 
									

								<div class="form-group">

							<label for="userEmail" class="control-label col-xs-4">
								Email:</label>


							<div class="col-xs-5 ">
                                      <div class="  input-group">
                                          <span class="input-group-addon"> <i class="fa fa-envelope-o fa-fw"></i></span>
								           <input type="text" class="form-control" id="userEmail" name="userEmail" placeholder="Email">
									  </div>

							</div>

						</div>

								


								
								
								<div class="form-group">

									<div class="col-xs-offset-4 col-xs-10">

										<button id="btnSubmit" type="submit" class="btn btn-primary">Submit</button>
									<!-- 	<input type="button" class="btn btn-warning" value="Back" onclick="login.jsp"/> -->
										<a href="login.jsp"class="btn btn-warning">Back</a>
										
										
										<!-- <input type="button" class="btn btn-warning" value="ForgotPassword" />-->
										
										
								
									</div>
									
									
									
									<!-- <input type=button onClick="parent.location='ForgotPasswordIndex.jsp'" value='**ForgotPassword'> -->
										
									
						
								</div>

							</form>




						</div>

					</div>


				</div>

			</div>
		</div>

		<!-- 	<div id="nav1" border=1>
		<h4># </h4>
		<hr>


	   </div> -->

<div id="footer">Copyright ©</div>


</div>
	</body>




<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#userLogin')
								.formValidation(
										{
											message : 'This value is not valid',
											icon : {
												valid : 'fa fa-ok fa-fw',
												invalid : 'fa fa-remove fa-fw',
												validating : 'fa fa-refresh fa-fws'
											},
											fields : {
												
												userName : {
													message : 'The username is not valid',
													validators : {
														notEmpty : {
															message : 'The username is required and can\'t be empty1'
														},
														stringLength : {
															min : 3,
															max : 10,
															message : 'The username must be more than 4 and less than 10 characters long'
														},
														regexp : {
															regexp : /^[a-zA-Z0-9_\.]+$/,
															message : 'The username can only consist of alphabetical, number, dot and underscore'
														}
													}
												},

												password : {
													validators : {
														notEmpty : {
															message : 'The password is required and can\'t be empty'
														}
													}
												},

												vm : {
													validators : {
														notEmpty : {
															message : 'The VM is required and can\'t be empty'
														}
													}
												}

											}
										});
					});
</script>


</html>
