<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<%-- 	<%
    if (request.getSession().getAttribute("userName") == null) {
        response.sendRedirect("login.jsp?message=Please Login");
    }

%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NICE-A |File Upload</title>
<!-- Bootstrap -->
<link href="bootstrap/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="jasny-bootstrap/css/jasny-bootstrap.min.css"
	rel="stylesheet" media="screen">



<link rel="stylesheet"
	href="bootstrapvalidator/dist/css/formValidation.css" />

<!-- Include FontAwesome CSS if you want to use feedback icons provided by FontAwesome -->
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" />



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

			<h4>
				<strong>NICE-A </strong>Network Intrusion Detection and
				Countermeasure Selection in Virtual Network Systems
			</h4>
			<div class="row">
				<div class="col-lg-12">

					<%
						if (request.getParameter("message") != null
								&& request.getParameter("message") != "") {
					%>


					 <div class="alert alert-success ">

						<a href="#" class="close" data-dismiss="alert">&times;</a>

						<%=request.getParameter("message")%>

				 	</div>


					<%
						}
					%>
					
					<div class="panel panel-info">
						<div class="panel-heading">
							<h2 class="panel-title">File Upload</h2>
						</div>
						<div class="well">

							<form id="fileForm" name="fileForm" class="form-horizontal"
								action="FileUploadServlet" method="post"
								enctype="multipart/form-data">

								<div class="fileinput fileinput-new" data-provides="fileinput">
									<div class="fileinput-preview thumbnail"
										data-trigger="fileinput" style="width: 200px; height: 150px;"></div>
									<div>
										<span class="btn btn-default"> <span
											class="fileinput-new">Select File</span> <span
											class="fileinput-exists">Change</span> <input type="file"
											name=uploadfile id="uploadfile" size="50"
											class="btn btn-success" />

										</span> <input type="submit" id="btnUpload" value="Upload"
											class="btn btn-info" /> 
											<a href="#" class="btn btn-danger fileinput-exists" data-dismiss="fileinput">Remove</a>
											
											
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
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="bootstrap/jquery/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="bootstrap/bootstrap/js/bootstrap.min.js"></script>
		<script src="jasny-bootstrap/js/jasny-bootstrap.min.js"></script>


		<script type="text/javascript"
			src="bootstrapvalidator/dist/js/formValidation.js"></script>
		<script type="text/javascript"
			src="bootstrapvalidator/dist/js/framework/bootstrap.js"></script>




	</body>
</div>



<script type="text/javascript">
	$(document).ready(function() {
		$('#btnUpload').bind("click", function() {
			var imgVal = $('#uploadfile').val();
			if (imgVal == '') {
				alert("Empty input file");
				return false;

			} else {

				$('form').submit();
			}

		});
	});
</script>


</html>
