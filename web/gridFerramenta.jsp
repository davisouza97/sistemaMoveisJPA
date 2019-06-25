
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <%@ include file="/shared/head.jsp" %>
        <script src="main.js"></script>


    </head>

    <body>
        <%@ include file="/shared/navbar.jsp" %>
        <div class="container">
            <table class="table table-striped table-bordered table-condensed table-hover" id="lista">
                <tr>
                    <th colspan="2">Grid Ferramenta</th>
                    <th> <%@ include file="/shared/busca.jsp" %></th>
                </tr>
                <tr>
                    <th>nome</th>
                    <th colspan="2">Ações</th>
                </tr>
                <c:forEach items="${ferramenta}" var="objetoFerramenta">
                    <tr>
                        <td>
                            <c:out value="${objetoFerramenta.nome}" />
                        </td>
                        <td><a class="btn btn-primary" href="ManterFerramentaController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${objetoFerramenta.id}" />">Editar</a></td>
                        <td><a class="btn btn-primary" href="ManterFerramentaController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${objetoFerramenta.id}" />">Excluir</a></td>
                    </tr>
                </c:forEach>

                <td><a class="btn btn-danger" href="home.jsp">Voltar</a></td>
                <td colspan="2"><a class="btn btn-primary" href="ManterFerramentaController?acao=prepararOperacao&operacao=Incluir">Incluir</a></td>
            </table>
        </div>
        <div class="container">


            <div>
                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#modalFerramenta">Relatorios</a>
            </div>
            <div class="modal fade" id="modalFerramenta" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5>
                                Relatorio Completo
                            </h5>
                            <div>
                                <form action="RelatorioController" method="POST">
                                    <input type="hidden" id="classe" name="classe" value="Ferramentas">
                                    <input type="submit" value="Relatorio" class="btn btn-success"/>
                                </form>
                            </div> 
                        </div>
                        <div class="modal-body">
                            <h5>
                                Escolha o Tipo
                            </h5>
                            <form action="RelatorioControllerParametro" method="POST" autofocus>
                                <select class="form-control" name="parametroValor">
                                    <c:forEach items="${ferramenta}" var="objetoFerramenta">
                                        <option value="${objetoFerramenta.tipo}">${objetoFerramenta.tipo}</option>  
                                    </c:forEach>
                                </select>
                                <input type="hidden" id="classe" name="classe" value="Ferramenta">
                                <input type="hidden" id="parametro" name="parametroNome" value="Par_Ferramenta">
                                <input type="submit" value="Enviar" class="btn btn-success"/></form>
                        </div>
                        <div class="modal-footer">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Optional JavaScript -->
        <%@ include file="/shared/scriptBusca.jsp" %>
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </body>

</html>