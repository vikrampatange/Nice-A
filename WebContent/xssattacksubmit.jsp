<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.nice.service.* ,com.nice.util.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Script Attack </title>
</head>
<body>

<%!
public  String cleanXSS(String value) {
	//You'll need to remove the spaces from the html entities below
	value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "& #41;");
	value = value.replaceAll("'", "& #39;");
	value = value.replaceAll("eval\\((.*)\\)", "");
	value = value.replaceAll("[\\\"\\\'][\\s]*javascript : ( .* )[\\\"\\\']", "\"\"");
	//value = value.replaceAll("&", "&amp;");
	//value = value.replaceAll("&", "&amp;");
	//value = value.replaceAll("script", "");
	return value;
	}


public  boolean getStatementType(String username) {

	if (username.contains("script") == true)
		 {
		return true;
	}

	else if (username.contains("META") == true)
			 {
		return true;
	}

	else if (username.contains("IMG") == true)
			{
		return true;
	}
	else if (username.contains("document") == true)
	{
       return true;
    }
	else if (username.contains("onload") == true)
	{
       return true;
    }

	
	else if (username.contains("div") == true||username.contains("DIV") )
			 {
		return true;
	} else {
		return false;
	}
}
%>
<%
ControlCenterService controlCenterService = new ControlCenterService();
String userName = cleanXSS(request.getParameter("userName"));
String password = request.getParameter("password");
String vm = request.getParameter("vm");
String clientIp = request.getParameter("clientIp");

System.out.println(getStatementType(userName));
%>

<% 

if(controlCenterService.isValidClientIpForXss(clientIp)==true)
	
{


if(getStatementType(userName)==true)
{
	controlCenterService.addXssAtack(clientIp);
	String message="Xss Scripting Detected";
    response.sendRedirect("logincross.jsp?message="+message);
}
else{
%>
userName :<%=userName %><br>
clientIp :<%=clientIp%><br>


<%} 
}
else{
	String message="Ip Locked due try Xss Scripting attack !";
    response.sendRedirect("logincross.jsp?message="+message);
}

%>
</body>
</html>