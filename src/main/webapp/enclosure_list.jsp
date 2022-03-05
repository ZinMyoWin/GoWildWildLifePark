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
<title>Enclosure List</title>
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
	EnclosureContentManager enclosureContentManager = new EnclosureContentManager();
	ArrayList<Enclosure> enclosures = enclosureContentManager.selectAll();
%>
<h1 style="margin-left:500px;">Enclosure List</h1>
<table>
<tr>
<th>Enclosure ID</th>
<th>Enclosure Type</th>
<th>Enclosure Location</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<%
for(Enclosure eachEnclosure:enclosures ){
%>
<tr>
<th><%=eachEnclosure.getEnclosureid() %></th>
<th><%=eachEnclosure.getType() %></th>
<th><%=eachEnclosure.getLocation()%></th>
<th><a href="enclosure_update.jsp?id=<%=eachEnclosure.getEnclosureid() %>" >Edit</a>
<th><a href="enclosure_deleted_action.jsp?id=<%=eachEnclosure.getEnclosureid() %>" >Delete</a>
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