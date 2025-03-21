<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="text.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String fName=(String)request.getAttribute("fname");
out.println("page belongs to "+fName+"<br>");

UserBean ub=(UserBean)application.getAttribute("ubean");

out.println(ub.getfName()
     +"&nbsp&nbsp <br>"+ub.getlName()
	 +"&nbsp&nbsp <br>"+ub.getAddr()
     +"&nbsp&nbsp <br>"+ub.getmId()
	 +"&nbsp&nbsp <br>"+ub.getPhNo()
     +"&nbsp&nbsp <br>"+"<a href='edit'>Edit</a>");
%>
 <a href="logout">Logout</a>
</body>
</html>