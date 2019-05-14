<%-- 
    Document   : navbar
    Created on : 14/05/2019, 13:17:40
    Author     : davis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="home.jsp">Sistema Interno</a>
    <div style="color: white;">${sessionScope.nome}</div>
    <div><form action="DeslogarController" method="POST"><input class="btn btn-danger" type="submit" value="Logout"></form></div>

</nav>
