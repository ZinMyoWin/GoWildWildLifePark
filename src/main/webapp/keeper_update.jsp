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
<title>Keeper Update</title>
<style >
body {
top:50px;
 width:100%;
 height: 100%;
 background-image: url('images/keeper.png');
 background-repeat: no-repeat;
 background-size: cover;
 text-align: center;
 display: flex;
 justify-content:center;
}
input{
float:right;
 border: 2px solid #000000;
  border-radius: 5px;
  width: 200px;
  height: 30px;
}
.btn{
width: 70px;
    height: 50px;
    background-color: #cccccc;
    font-size: 15px;
    border-radius: 20px;
    margin-left:20px;
}
label{
color:blue;
font-size: 150%;
}
</style>
</head>
<body>
<form action="keeper_updated_action.jsp" style="margin-top:150px;margin-right:250px">
<%
int id = Integer.valueOf(request.getParameter("id"));
KeeperContentManager hcm = new KeeperContentManager();
try{
	Keeper hc = hcm.getById(id);

%>
<br><br><br>
<label>Keeper Id:</label><input type="text" name="id" value="<%=hc.getKeeperId() %>">
<br><br><br>
<label>Keeper Name:</label><input type="text" name="name"  value="<%=hc.getKeeperName() %>">
<br><br><br>
<label>Keeper Date:</label><input type="text" name="date" value="<%=hc.getKeeperDate() %>">
<br><br><br>
<label>Keeper Email:</label><input type="text" name="email" value="<%=hc.getKeeperEmail() %>">
<br><br><br>
<label>Keeper Phone:</label><input type="text" name="phone" value="<%=hc.getKeeperPhone() %>">
<br><br><br>
<label>Rank:</label><input type="text" name="rank" value="<%=hc.getKeeperRank() %>">
<br><br><br>

<%
}
catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%>

<input type="reset" value="Clear" class="btn">
<input type="submit" value="Update" class="btn">
</form>
</body>
</html>