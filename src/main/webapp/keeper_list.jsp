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
<title>Keeper List</title>
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
	KeeperContentManager keeperContentManager = new KeeperContentManager();
	ArrayList<Keeper> keepers = keeperContentManager.selectAll();
%>
<h1 style="margin-left:500px;">Keeper List</h1>
<table>
<tr>
<th>Keeper ID</th>
<th>Keeper Name</th>
<th>Keeper Date</th>
<th>Keeper Email</th>
<th>Keeper Phone</th>
<th>Rank</th>
<th>Edit</th>
<th>Delete</th>

</tr>
<%
for(Keeper eachKeeper:keepers ){
%>
<tr>
<th><%=eachKeeper.getKeeperId() %></th>
<th><%=eachKeeper.getKeeperName() %></th>
<th><%=eachKeeper.getKeeperDate() %></th>
<th><%=eachKeeper.getKeeperEmail() %></th>
<th><%=eachKeeper.getKeeperPhone() %></th>
<th><%=eachKeeper.getKeeperRank() %></th>
<th><a href="keeper_update.jsp?id=<%=eachKeeper.getKeeperId() %>" >Edit</a>
<th><a href="keeper_deleted_action.jsp?id=<%=eachKeeper.getKeeperId() %>" >Delete</a>
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