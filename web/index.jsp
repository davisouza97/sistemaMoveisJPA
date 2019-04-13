<%-- 
    Document   : index
    Created on : 12/04/2019, 16:53:07
    Author     : davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LogarController" method="POST">
        <input type="text" name="login">
        <input type="password" name="senha">    
        <input type="submit">
        </form>
    </body>
</html>
