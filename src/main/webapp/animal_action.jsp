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
<title>Animal Action</title>
</head>
<body>
<%
String AName=request.getParameter("animalname");
String Agender=request.getParameter("gender");
int Year=Integer.valueOf(request.getParameter("year"));
int Sid=Integer.valueOf (request.getParameter("speciesId"));
int Did=Integer.valueOf (request.getParameter("dietId"));
int Eid=Integer.valueOf (request.getParameter("enclosureId"));
int Kid=Integer.valueOf (request.getParameter("keeperId"));
out.print(AName);
out.print(Agender);
out.print(Year);
out.print(Sid);
out.print(Did);
out.print(Eid);
out.print(Kid);
DBManager dbM= new DBManager();
try{
	dbM.getConnection();
	out.println("Connection Successfully");
	Animal animal=new Animal (AName,Agender,Year,Sid,Did,Eid,Kid);
	AnimalContentManager acm=new AnimalContentManager();
	int rowInserted =acm.insert(animal);
	if(rowInserted==1){
		out.println("Successfully inserted");
	}
}
catch(SQLException e){
	e.printStackTrace();
	}
%>
</body>
</html>