<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>


<html lang="pt-br">

    <head>
        <%@ include file="/shared/head.jsp" %>
        <title>Grid Pedido</title>
    </head>
    <body>
        <%@ include file="/shared/navbar.jsp" %>
        <div class="container">

            <table class="table table-striped table-bordered table-condensed table-hover" id="lista">
                <tr>
                    <th colspan="2">Grid Pedido</th>
                    <th colspan="2"> <%@ include file="/shared/busca.jsp" %></th>
                </tr>
                <tr>
                    <th>Codigo Pedido</th>
                    <th>Valor Total</th>
                    <th colspan="2">Ações</th>
                </tr>
                <c:forEach items="${pedidos}" var="pedido">
                    <tr>
                        <td>
                            <c:out value="${pedido.id}" />
                        </td>

                        <td>
                            <c:out value=" R$${pedido.valorTotal}" />
                        </td>

                        <td><a class="btn btn-primary"
                               href="ManterPedidoController?acao=prepararOperacao&Operacao=Editar&id=<c:out value="${pedido.id}" />">Editar</a></td>
                        <td><a class="btn btn-primary"
                               href="ManterPedidoController?acao=prepararOperacao&Operacao=Excluir&id=<c:out value="${pedido.id}" />">Excluir</a></td>
                    </tr>
                </c:forEach>
                <td><a class="btn btn-danger" href="home.jsp">Voltar</a></td>
                <td colspan="3"><a class="btn btn-primary"
                                   href="ManterPedidoController?acao=prepararOperacao&operacao=Incluir">Incluir</a></td>
            </table>
        </div>
        <div class="container">
            <div>
                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#modalMovel">Relatorios</a>
            </div>
            <div class="modal fade" id="modalMovel" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5>
                                Relatorio Completo
                            </h5>
                            <div>
                                <form action="RelatorioController" method="POST">
                                    <input type="hidden" id="teste" name="teste" value="Pedidos">
                                    <input type="submit" value="Relatorio" class="btn btn-success"/>
                                </form>
                            </div> 
                        </div>
                        <div class="modal-body">
                            <h5>
                                Escolha o Móvel
                            </h5>
                            <form action="RelatorioControllerParametro" method="POST" autofocus>
                                <select class="form-control" name="paramPedido">
                                    <c:forEach items="${pedidos}" var="pedido">
                                        <option value="${pedido.id}">${pedido.id}</option>  
                                    </c:forEach>
                                </select>
                                <input type="hidden" id="teste" name="teste" value="Pedidos">
                                <input type="hidden" id="parametro" name="parametroNome" value="Par_Pedido">
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