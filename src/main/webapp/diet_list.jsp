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
<title>Diet List</title>
<style >
table, th, td {
  border: 2px solid;
  
}
table{
width: 100%;
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
	DietContentManager dietContentManager = new DietContentManager();
	ArrayList<Diet> diets = dietContentManager.selectAll();
%>
<h1 style="margin-left:500px;">Enclosure List</h1>
<table>
<tr>
<th>Diet ID</th>
<th>Diet Type</th>
<th>No Of Feed</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<%
for(Diet eachDiet:diets ){
%>
<tr>
<th><%=eachDiet.getDietId() %></th>
<th><%=eachDiet.getDietType() %></th>
<th><%=eachDiet.getNoOfFeed()%></th>
<th><a href="enclosure_update.jsp?id=<%=eachDiet.getDietId() %>" >Edit</a>
<th><a >Delete</a>
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