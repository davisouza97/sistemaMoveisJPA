<%-- 
    Document   : navbar
    Created on : 14/05/2019, 13:17:40
    Author     : davis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="home.jsp">Sistema Interno</a>
    <a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Editar=<c:out value="${funcionario.id}"/>> <div style="color: white;"><img src="images/abacate.png" width="35px">${sessionScope.nome}</div></a>
    <div><form action="DeslogarController" method="POST"><input class="btn btn-danger" type="submit" value="Logout"></form></div>

</nav>
