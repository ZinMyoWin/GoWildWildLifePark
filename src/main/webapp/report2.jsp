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
<title >Report 2</title>
<style >
table, th, td {
  border: 2px solid;
  
}
table{
width: 25%;
}
th {
  height: 50px;
}
</style>
</head>
<body>
<%
DBManager dbManager = new DBManager();
try{
	dbManager.getConnection();
	out.println("Connection Successfully");
	//select
	AnimalContentManager animalContentManager = new AnimalContentManager();
	ArrayList<Animal> animals = animalContentManager.selectTotalAnimalCount();
%>
<table>
<tr>
<th>Keeper Name</th>
<th>Total Animal</th>
</tr>
<%
for(Animal eachAnimal:animals ){
%>
<tr>
<td><%=eachAnimal.getKeepername() %></td>
<td><%=eachAnimal.getTotalanimals() %></td>
</tr>
<%
} 
}
catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%>
</table>
</body>
</html>