<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NICE-A | Security  Questions</title>
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
                             <li><a href="<%=request.getContextPath()%>/userregistration.jsp">Registration</a></li>
                             <li><a href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
                             <li><a href="<%=request.getContextPath()%>/bruteForceAttacks.jsp">BruteForce Attack </a></li>
                             
                              <li><a href="#">Link</a></li>
                            
                        </ul>
                       
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#">Link</a></li>
                          
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
			
			     
                      

                      <div class="alert alert-danger">

                       <a href="#" class="close" data-dismiss="alert">&times;</a>
                      
                         Please Provide Following Details To proceed Further <br>
                         <b>Warning !</b> If you fail provide valid details Your Account being Locked 
                        
                      </div>


			
			  <div class="panel panel-info">
						<div class="panel-heading">
							<h2 class="panel-title">Security  Questions</h2>
						</div>
			
	         <div class="well">

					<form role="form" class="form-horizontal" id="userSec" name="userRegistation" action="UserServlet" method="post" >
						
						
						 <input type="hidden" name="clientIp" value="<%=request.getRemoteHost()%>">
							
							
							
							
					<input type="hidden" name="action" value="userSec">
					
					<input type="hidden" name="userName" value="<%=request.getParameter("userName")%>">
					<input type="hidden" name="vm" value="<%=request.getParameter("vm")%>">
					

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

								<button type="submit" class="btn btn-primary">Submit</button>
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
