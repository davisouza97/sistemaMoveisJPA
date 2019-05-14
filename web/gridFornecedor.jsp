
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html lang="pt-br">

    <head>
        <%@ include file="/shared/head.jsp" %>
        <title>Grid Forencedor</title>
        <script src="main.js"></script>


    </head>

    <body>
        <%@ include file="/shared/navbar.jsp" %>
        <div class="container">

            <table class="table table-striped table-bordered table-condensed table-hover">
                <tr>
                    <th colspan="2">Grid Fornecedor</th>
                    <th> <%@ include file="/shared/busca.jsp" %></th>
                </tr>
                <tr>
                    <th>nome</th>
                    <th colspan="2">A��es</th>
                </tr>
                <c:forEach items="${fornecedores}" var="fornecedor">
                    <tr>
                        <td>
                            <c:out value="${fornecedor.nome}" />
                        </td>
                        <td><a class="btn btn-primary" href="ManterFornecedorController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${fornecedor.id}"/> ">Editar</a></td>
                        <td><a class="btn btn-primary" href="ManterFornecedorController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${fornecedor.id}"/> ">Excluir</a></td>
                    </tr>
                </c:forEach>
                <td><a class="btn btn-danger" href="home.jsp">Voltar</a></td>
                <td colspan="3"><a class="btn btn-primary" href="ManterFornecedorController?acao=prepararOperacao&operacao=Incluir">Incluir</a></td>
            </table>

        </div>
        <div class="container">


            <div>
                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#modalFornecedor">Relatorios</a>
            </div>
            <div class="modal fade" id="modalFornecedor" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5>
                                Relatorio Completo
                            </h5>
                            <div>
                                <a href="RelatorioControllerFornecedor" class="btn btn-success">Emitir Relatorio</a>
                            </div> 
                        </div>
                        <div class="modal-body">
                            <h5>
                               Escolha a Cidade
                            </h5>
                            <form action="RelatorioControllerFornecedorPar" method="POST" autofocus>
                                <select class="form-control" name="paramFornecedor">
                                     
                                    <c:forEach items="${fornecedores}" var="fornecedor">
                                        <option  value="${fornecedor.cidade}">${fornecedor.cidade}</option>  
                                    </c:forEach>
                                </select>
                                <input type="submit" value="Enviar" class="btn btn-success"/>

                            </form>
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