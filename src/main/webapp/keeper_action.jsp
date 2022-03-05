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
<title>Keeper Action</title>
</head>
<body>
<%
String kName = request.getParameter("name");
String kDate = request.getParameter("date");
String kEmail = request.getParameter("email");
String kPhone = request.getParameter("phone");
String kRank = request.getParameter("rank");
out.print(kName);
out.print(kDate);
out.print(kEmail);
out.print(kPhone);
out.print(kRank);
DBManager dbM = new DBManager();
try{
	dbM.getConnection();
	out.print("Connection Successfully");
	Keeper keeper = new Keeper(kName,kDate,kEmail,kPhone,kRank);
	KeeperContentManager scm = new KeeperContentManager();
	int rowInserted = scm.insert(keeper);
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