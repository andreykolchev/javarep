<%-- 
    Document   : main
    Created on : Apr 6, 2015, 11:58:30 PM
    Author     : user
--%>

<%@page import="testjdbc.TestJDBC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        TestJDBC tj = new TestJDBC();
        tj.check();
        
        %>
    </body>
</html>
