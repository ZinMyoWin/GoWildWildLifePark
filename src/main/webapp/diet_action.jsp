<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.crud.*" %>
 <%@ page import="com.dbconnector.*" %>
 <%@ page import="com.content.*" %>
 <%@ page import="java.sql.*" %>
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Diet_Action</title>
</head>
<body>
<%
String dType = request.getParameter("dtype");
Integer dFeed = Integer.valueOf(request.getParameter("feed"));
out.print(dType);
out.print(dFeed);
DBManager dbM = new DBManager();
try{
	dbM.getConnection();
	out.print("Connection Successfully");
	Diet diet = new Diet(dType,dFeed);
	DietContentManager dcm = new DietContentManager();
	int rowInserted = dcm.insert(diet);
	if(rowInserted==1){
		out.print("Successfully inserted");
	}
}
catch(SQLException e){
	e.printStackTrace();
}
%>
</body>
</html>