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
<title>Enclosure Update</title>
<style >
body {
top:50px;
 width:100%;
 height: 100%;
 background-image: url('images/enclosure.png');
 background-repeat: no-repeat;
 background-size: cover;
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
color:#FFFF00;
font-size: 160%;
}
</style>
</head>
<body>
<body>
<form action="enclosure_updated_action.jsp" style="margin-top:150px;margin-right:250px">
<%
int id = Integer.valueOf(request.getParameter("id"));
EnclosureContentManager hcm = new EnclosureContentManager();
try{
	Enclosure hc = hcm.getById(id);

%>
<br><br><br>
<label>Enclosure Id:</label><input type="text" name="id" value="<%=hc.getEnclosureid()%>">
<br><br><br>
<label>Enclosure Type:</label><input type="text" name="type"  value="<%=hc.getType() %>">
<br><br><br>
<label>Enclosure Location:</label><input type="text" name="location" value="<%=hc.getLocation() %>">
<br><br><br>
<%
}
catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%>

<input type="submit" value="Update" class="btn">
<input type="reset" value="Clear" class="btn">
</form>
</body>
</html>