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
<title>Delete Successfully</title>
</head>
<body>
<%
 int enclosureid = Integer.valueOf(request.getParameter("id"));

           EnclosureContentManager ecm = new EnclosureContentManager();
           int rowsAffected;
            try {

                rowsAffected = ecm.delete(enclosureid);
                out.println("No of rows affected - " + rowsAffected);

             }catch (SQLException e){
                  out.println(e.getMessage());

              }
%>
</body>
</html>