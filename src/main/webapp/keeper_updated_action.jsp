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
<title>Keeper Update Action</title>
</head>
<body>
<%
int  keeperid = Integer.valueOf(request.getParameter("id"));
String name = request.getParameter("name");
String date = request.getParameter("date");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
String rank = request.getParameter("rank");
out.println(keeperid);
out.println(name);
out.println(date);
out.println(email);
out.println(phone);
out.println(rank);
KeeperContentManager kcm = new KeeperContentManager();
Keeper keeper = new Keeper(keeperid,name,date,email,phone,rank);
int rowsAffected;
try {

    rowsAffected = kcm.update(keeper);
    out.println("No of rows affected - " + rowsAffected);

}catch (SQLException e){
    out.println(e.getMessage());

}
%>
</body>
</html>