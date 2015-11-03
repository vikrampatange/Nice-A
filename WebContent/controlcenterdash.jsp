<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="com.nice.service.* ,com.nice.util.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NICE-A |Control Center</title>
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

<link href="css/autumn-dawn.css" rel="stylesheet">
<link href="css/layout.css" rel="stylesheet">


</head>
<div class="container">
	<body>

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
						<li><a
							href="<%=request.getContextPath()%>/userregistration.jsp">Registration</a></li>
						<li><a href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
						
							<li><a href="<%=request.getContextPath()%>/bruteForceAttacks.jsp">BruteForce Attack </a></li>
						
						
						<li><a href="#">Link</a></li>

					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a class="btn btn-danger btn-sm" href="ControlCenter?action=resetAll">Reset</a></li>

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
						 response.setIntHeader("Refresh", 5);
						

				           ControlCenterService controlCenterService = new ControlCenterService();
							List<VMachine> vMachineList = controlCenterService.getAllVMachine();
							
							
						%>

				
					<div class="panel panel-info">
						<div class="panel-heading">
							<h2 class="panel-title">CONTROL CENTER :   Virtual Machine</h2>
						</div>
						<div class="panel-body">
							<div class="table-responsive">

								<table class="table table-bordered">
									<caption>
										<!-- <h2>Virtual Machine</h2> -->
									</caption>
									<tr >
										<th class="text-center">Sr No</th>
										<th class="text-center">Virtual Machine</th>
										<th class="text-center">Status</th>
										<th class="text-center">Action</th>
									</tr>
									<%
									for (VMachine vMachine : vMachineList) {
								     
										if (vMachine.getStatus().equals(VMStatusMode.STABLE))
										{   %>
                                         <tr class="">
                                        <% }   
										else if (vMachine.getStatus().equals(VMStatusMode.VULNERABLE))
                                        {   %>
                                       <tr class="info">
                                       <% }
										
										else if (vMachine.getStatus().equals(VMStatusMode.EXPLOITED))
                                        {   %>
                                       <tr class="warning">
                                       <% }
										
										else if (vMachine.getStatus().equals(VMStatusMode.ZOMBIE)) 
                                        {   %>
                                       <tr class="danger">
										<% }%> 
                                      
       
     
                                     <td class="text-center"><%=vMachine.getId()%></td>
                                     <td class="text-center"><%=vMachine.getVm()%></td>
                                     <td class="text-center"><%=vMachine.getStatus()%></td>
									<td class="text-center"><a href="ControlCenter?action=changestatus&vm=<%=vMachine.getVm()%>">Action</a></td>
								</tr>
								<%
									}
								%>
								</table>
							</div>
						</div>
					</div>
					
					
					<%
					
					List<String> user  =controlCenterService.getAllLockedUsers();
					%>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h2 class="panel-title">CONTROL CENTER :  Locked User</h2>
						</div>
						<div class="panel-body">
							<div class="table-responsive">

								<table class="table table-bordered">
									<caption>
										<!-- <h2>Virtual Machine</h2> -->
									</caption>
									<tr  >
										<th class="text-center">User</th>
										
										<th class="text-center">Action</th>
									</tr>
									<%
									for (String u : user)  {
									  
									%>
                                     
                                       <tr class="danger">
										
                                      
       
     
                                     <td class="text-center"><%=u%></td>
                                    
									<td class="text-center"><a href="ControlCenter?action=changestatus&vm=<%=u%>">Action</a></td>
								</tr>
								<%
									}
								%>
								</table>
							</div>
						</div>
					</div>
               <!-- 2 Table  -->
               
               
               <%
					
					List<SQLInj> sQLInjList  =controlCenterService.getAllVSqlAttack();
					%>
               
               
               <div class="panel panel-info">
						<div class="panel-heading">
							<h2 class="panel-title">CONTROL CENTER :   SQL Attack</h2>
						</div>
						<div class="panel-body">
							<div class="table-responsive">

								<table class="table table-bordered">
									<caption>
										<!-- <h2>Virtual Machine</h2> -->
									</caption>
									<tr >
										<!-- <th class="text-center">Sr No</th> -->
										<th class="text-center">Client Ip</th>
										<th class="text-center">Attack Type</th>
										<th class="text-center">Action</th>
									</tr>
									<%
									for (SQLInj sQLInj : sQLInjList) {
								     
									 %>
                                       <tr class="danger">
									
                                      
       
     
                                     <td class="text-center"><%=sQLInj.getClientIp()%></td>
                                      <td class="text-center"><%=sQLInj.getAttackType()%></td>
                                   
									<td class="text-center"><a href="ControlCenter?action=changeAttack&clientIp=<%=sQLInj.getClientIp()%>">Action</a></td>
								</tr>
								<%
									}
								%>
								</table>
							</div>
						</div>
					</div>
					<!-- table 3 -->
					
					
					
					
					
					<%
					
					List<String> clientIpList  =controlCenterService.getAllXssAtackIp();
					%>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h2 class="panel-title">CONTROL CENTER :  Xss Attack</h2>
						</div>
						<div class="panel-body">
							<div class="table-responsive">

								<table class="table table-bordered">
									<caption>
										<!-- <h2>Virtual Machine</h2> -->
									</caption>
									<tr  >
										<th class="text-center">Client Ip</th>
										
										<th class="text-center">Action</th>
									</tr>
									<%
									for (String clientIp: clientIpList)  {
									  
									%>
                                     
                                       <tr class="danger">
										
                                      
       
     
                                     <td class="text-center"><%=clientIp%></td>
                                    
									<td class="text-center"><a href="ControlCenter?action=changeXssIp&clientIp=<%=clientIp%>">Action</a></td>
								</tr>
								<%
									}
								%>
								</table>
							</div>
						</div>
					</div>
               <!-- 4 Table  -->

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
