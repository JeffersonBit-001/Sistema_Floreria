<%-- 
    Document   : index
    Created on : 27 nov 2024, 22:12:45
    Author     : Joaquin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% response.sendRedirect(request.getContextPath()+"/Vista/index.jsp"); %>
    </body>
</html>
