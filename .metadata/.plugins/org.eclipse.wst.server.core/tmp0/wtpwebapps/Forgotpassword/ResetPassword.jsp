<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset your Password</title>
<link rel="stylesheet" href="css/tableLayout.css">

<script type="text/javascript">


	function Verify() 
	
	{
		var emailpattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		
		var emailObj = document.getElementById("cus_email");
		if (emailObj.value == null || emailObj.value == "") {
			alert("Enter email Id");
			emailObj.focus();
			return false;
		} else if (!emailpattern.test(emailObj.value)) {
			alert("please enter valid e-mail address")
			emailObj.focus();
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<form method="post" action="SendResetLink1">   
		<%
			if (request.getAttribute("linkfailuremsg") != null) {
		%>
		<font color="black" size="4"><p align="center"
				style="background-color: lightyellow">
				This link has been accessed once already.<br> OR it has been
				more than 1 hour since you requested for it.<br> In case you
				are trying to reset your password again, request for new link below.
			</p></font>
		<%
			}
		%>
		
		
		<table class="tablelayout">
			<caption>Reset your Password</caption>
			<tr>
				<td class="required">Enter your Email id</td>
				<td><input type="text" name="cus_email" id="cus_email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="reset" onclick="javascript: return Verify()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>