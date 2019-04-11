<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

        <style>
            select{
                background: col

            }
        </style>

        <title>Cadastro de Pedidos</title>
    </head>

    <body>
        <div class="container">
            <form action="ManterPedidoController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table>
                    <tr>
                    <input class="form-control" type="Hidden" min="0" name="id" id="id" value="${pedido.id}" readonly>
                    <td colspan="4" style="text-align: center">${operacao} Pedido</td>
                    </tr>
                    <tr>
                        <c:if test="${operacao != 'Incluir'}">
                            <td>
                                <label for="CodigoPedido">Codigo do Pedido</label>
                            </td>
                            <td>
                                <input class="form-control" type="text" min="0" name="CodigoPedido" id="CodigoPedido" value="${pedido.codigoPedido}" readonly>
                            </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>
                            <label for="idFuncionario">Funcionario</label>
                        </td>
                        <td colspan="4">
                            <c:if test="${operacao == 'Incluir'}">
                                <select class="form-control" required name="idFuncionario">
                                    <option required value="0" <c:if test="${pedido.funcionario.id == null}"> selected </c:if>> </option>
                                    <c:forEach items="${funcionarios}" var="funcionario">
                                        <option required value="${funcionario.id}" <c:if
                                                    test="${pedido.funcionario.id == funcionario.id}"> selected</c:if>>${funcionario.id} - ${funcionario.nome}</option>
                                    </c:forEach>
                                </select>
                            </c:if>
                            <c:if test="${operacao != 'Incluir'}">
                                <input class="form-control" type="text" min="0" value="${pedido.funcionario.id} - ${pedido.funcionario.nome}" readonly>
                                <input class="form-control" type="Hidden" min="0" name="idFuncionario" id="idFuncionario" value="${pedido.funcionario.id}" readonly>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <input class="form-control" type="HIDDEN" required min="1" name="idPedido" id="idPedido" value="${pedido.id}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="valorTotal">Valor Total</label>
                        </td>
                        <td colspan="4">
                            <input class="form-control" type="number" min="0" name="valorTotal" id="valorTotal" <c:if
                                       test="${operacao == 'Incluir'}">value="0"</c:if>
                                   <c:if test="${operacao != 'Incluir'}">value="${pedido.valorTotal}"</c:if>
                                       readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="idCliente">Cliente</label>
                            </td>
                            <td colspan="4">
                            <c:if test="${operacao == 'Incluir'}">
                                <select class="form-control" required name="idCliente">
                                    <option required value="0" <c:if test="${pedido.cliente.id == null}"> selected</c:if>>
                                        </option>
                                    <c:forEach items="${clientes}" var="cliente">
                                        <option required value="${cliente.id}" <c:if test="${pedido.cliente.id == cliente.id}">
                                                selected</c:if>>${cliente.id} - ${cliente.nome}</option>
                                    </c:forEach>
                                </select>
                            </c:if>
                            <c:if test="${operacao != 'Incluir'}">
                                <input class="form-control" type="text" min="0" value="${pedido.cliente.id} - ${pedido.cliente.nome}" readonly>
                                <input class="form-control" type="Hidden" min="0" name="idCliente" id="idCliente" value="${pedido.cliente.id}" readonly>
                            </c:if>
                    </tr>
                    <tr>
                        <td>
                            <label for="dataCriacao">Data do Pedido</label>
                        </td>
                        <td colspan="4">
                            <input class="form-control" type="date" maxlenght="10" minlength="10"  required name="dataCriacao" id="dataNascimento" value="${pedido.dataPedido}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="dataPrevista">Data Prevista de Entrega</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="date" maxlenght="10" minlength="10"  required name="dataPrevista" id="dataNascimento" value="${pedido.dataEntrega}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Remover Moveis
                            </td>
                            <td>

                            </td>
                            <td>
                                Adicionar Moveis
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <c:if test="${operacao != 'Incluir'}">
                                <select size="5" multiple name="listaMoveisRemove" title="Selecione para remover">
                                    <c:forEach items="${moveis}" var="movel">
                                        <c:if test="${movel.pedido.id == pedido.id}">
                                            <option value="${movel.id}"> ${movel.nome}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </c:if>
                        </td>
                        <td></td>
                        <td>
                            <select size="5" multiple name="listaMoveisAdd" title="Selecione para adicionar">
                                <c:forEach items="${moveis}" var="movel">
                                    <c:if test="${movel.pedido == null}">
                                        <option value="${movel.id}"> ${movel.nome}</option>>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="PesquisaPedidoController">
                                <input class="btn btn-danger" type="button" value="voltar">
                            </a>
                        </td>
                        <td colspan="2" class="tdsalvar">
                            <input class="btn btn-success" type="submit" name="" value="Confirmar">
                        </td>
                        <td>
                            <a href="index.jsp">
                                <input class="btn btn-primary" type="button" value="Home">
                            </a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</html>