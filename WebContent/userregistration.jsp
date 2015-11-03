<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NICE-A | User Registration</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="bootstrapvalidator/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrapvalidator/dist/css/formValidation.css"/>
   
   <!-- Include FontAwesome CSS if you want to use feedback icons provided by FontAwesome -->
 <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="bootstrapvalidator/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator/dist/js/formValidation.js"></script>
    <script type="text/javascript" src="bootstrapvalidator/dist/js/framework/bootstrap.js"></script>
   
  
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

<link href="css/autumn-dawn.css" rel="stylesheet">
<link href="css/layout.css" rel="stylesheet">


</head>
<div class="container">
<body>

	<div>
		<div class="navbar navbar-default">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">NICE-A</a>
                    </div>
                    
                    <div class="navbar-collapse collapse navbar-responsive-collapse">
                        <ul class="nav navbar-nav">
                         	
                         	<li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
                         	
							<li class="active"><a href="<%=request.getContextPath()%>/userregistration.jsp">Registration</a></li>
							
							<li><a href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
							
							<li><a href="<%=request.getContextPath()%>/sqlinjection.jsp">Attack </a></li>
							
							<!--<li><a href="<%=request.getContextPath()%>/xssattack.jsp">XSS Attack </a></li>-->
							
							<!--<li><a href="<%=request.getContextPath()%>/bruteForceAttacks.jsp">BruteForce Attack </a></li>-->
							
							
                            
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
		<h4> <strong>NICE-A   </strong>Network Intrusion Detection and Countermeasure Selection in
				Virtual Network Systems</h4>
		<div class="row">
			<div class="col-lg-12">
			
			          <% 
                   if(request.getParameter("message") != null && request.getParameter("message") !="")  
                  { 
                	 
               %>
                      

                      <div class="alert alert-success ">

                       <a href="#" class="close" data-dismiss="alert">&times;</a>

                            <%=request.getParameter("message") %>

                      </div>


                   <% 
                   }
               %>
			
			
			
			  <div class="panel panel-info">
						<div class="panel-heading">
							<h2 class="panel-title">User Registration</h2>
						</div>
			
	         <div class="well">

					<form role="form" class="form-horizontal" id="userRegistation" name="userRegistation" action="UserServlet" method="post" >
						
						<input type="hidden" name="action" value="userReg">
						
						 <input type="hidden" name="clientIp" value="<%=request.getRemoteHost()%>">
							
							
							
							
					<!-- <input type="hidden" name="action" value="userReg"> -->
					
						<div class="form-group">

							<label for="userName" class="control-label col-xs-4">
								User Name: </label>


							<div class="col-xs-5 ">
                                   <div class="  input-group">
                                          <span class="input-group-addon"> <i class="fa fa-user fa-fw"></i></span>
                                          
								            <input type="text" class="form-control" id="userName" name="userName" placeholder="User Name">
                                   </div>
							</div>

						</div>

						<div class="form-group">

							<label for="password :" class="control-label col-xs-4 ">Password
								:</label>


							<div class="col-xs-5 ">
                                     <div class="  input-group">
                                          <span class="input-group-addon"> <i class="fa fa-key fa-fw"></i></span>
								          <input type="password" class="form-control" id="password"  name="password" placeholder="Password">
                                    </div>
							</div>

						</div>


					


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

							<label for="userMobile" class="control-label col-xs-4"> Mobile Number:</label>


							<div class="col-xs-5 ">
                                     <div class="  input-group">
                                          <span class="input-group-addon"> <i class="fa fa-mobile fa-fw "></i></span>
								           <input type="text" class="form-control" id="userMobile"
									        name="userMobile" placeholder="Mobile Number">
                                     </div>
							</div>

						</div>
						

					<div class="form-group">

									<label for="secQues" class="control-label col-xs-4"> Security  questions:
										</label>


									<div class="col-xs-7">
										<div class="  input-group">
											<span class="input-group-addon"> <i
												class="fa fa-lock fa-fw "></i></span> <select
												class="form-control" name="secQues" id="secQues">
												<option value="">--choose your question---</option>
												<option value="When was the first time (year) you used Google?"> When was the first time (year) you used Google?</option>
												<option value="What is your favorite movie?"> What is your favorite movie?</option>
                                                <option value="What was your favorite place to visit as a child?"> What was your favorite place to visit as a child?</option>
											</select>
										</div>
									</div>

					</div>
					
					
					<div class="form-group">

							<label for="answer" class="control-label col-xs-4">
								Answer:</label>


							<div class="col-xs-5 ">
                                      <div class="  input-group">
                                          <span class="input-group-addon"> <i class="fa fa-key fa-fw"></i></span>
								           <input type="text" class="form-control" id="answer"
									         name="answer" placeholder="Answer">
									  </div>

							</div>

						</div>
						<div class="form-group">

							<div class="col-xs-offset-4 col-xs-10">

								<button type="submit" class="btn btn-primary">Register</button>
								<input type="reset"  id="cancel" class="btn btn-warning" value="Clear" />

							</div>

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
   
	
	

</body>
</div>


	
<script type="text/javascript">
$(document).ready(function() {
    $('#userRegistation').formValidation({
        message: 'This value is not valid',
        icon: {
            valid: 'fa fa-ok fw',
            invalid: 'fa fa-remove fw',
            validating: 'fa fa-refresh fw'
        },
        fields: {
        	
            
            userName: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'The username is required and can\'t be empty'
                    },
                    stringLength: {
                        min: 2,
                        max: 30,
                        message: 'The username must be more than 6 and less than 30 characters long'
                    },
                    regexp : {
						regexp : /^[a-zA-Z0-9_\.]+$/,
						message : 'The username can only consist of alphabetical, number, dot and underscore'
					}
                }
            },
               
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required and can\'t be empty'
                    }
                }
            },
            userEmail: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            } ,
            
            userMobile: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'The Mobile number is required and can\'t be empty'
                    },
                    stringLength: {
                        min: 10,
                        max: 10,
                        message: 'The Mobile number must be more  10 digit long'
                    },
                    regexp: {
                        regexp: /^[0-9\.]+$/,
                        message: 'The Mobile number can only  number '
                    }
                }
            },
            
            secQues : {
				validators : {
					notEmpty : {
						message : 'The Security  Question is required and can\'t be empty'
					}
				}
			},
            
			answer : {
				validators : {
					notEmpty : {
						message : 'The Answer is required and can\'t be empty'
					}
				}
			}
        }
    });
    
    
    $("#cancel").on("click", function(){ // or $("button[type='reset']").on(...)
        $("form").data('bootstrapValidator').resetForm();
      });
});
</script>

	
</html>
