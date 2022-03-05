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
<title>Keeper Delete Successfully</title>
</head>
<body>
<%
 int keeperid = Integer.valueOf(request.getParameter("id"));

           KeeperContentManager ecm = new KeeperContentManager();
           int rowsAffected;
            try {

                rowsAffected = ecm.delete(keeperid);
                out.println("No of rows affected - " + rowsAffected);

             }catch (SQLException e){
                  out.println(e.getMessage());

              }
%>
</body>
</html>