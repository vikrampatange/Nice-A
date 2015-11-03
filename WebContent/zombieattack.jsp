<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NICE-A | Zombie Attack </title>
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
			
			  <div class="alert alert-danger ">

						<a href="#" class="close" data-dismiss="alert">&times;</a>

						<h4>Requested Machine infected by Zombie Attack Please try different Virtual Machine </h4>

					</div>
			
	         <div class="well">

					<form class="form-horizontal" id="userRegistation" name="userRegistation" action="UserController" method="post" >
						
						 <div class="bs-example"> 
                   <img src="<%=request.getContextPath()%>/images/Zombie.jpg" class="img-rounded" alt="Rounded Image">
					
                  </div>

					</form>




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

</html>
