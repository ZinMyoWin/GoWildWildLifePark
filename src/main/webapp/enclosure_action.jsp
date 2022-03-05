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
<title>Enclosure_action</title>
</head>
<body>
<%
String eType = request.getParameter("type");
String eLocation = request.getParameter("location");
out.print(eType);
out.print(eLocation);
DBManager dbM = new DBManager();
try{
	dbM.getConnection();
	out.print("Connection Successfully");
	Enclosure enclosure = new Enclosure(eType,eLocation);
	EnclosureContentManager ecm = new EnclosureContentManager();
	int rowInserted = ecm.insert(enclosure);
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