<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <%@ include file="/shared/head.jsp" %>
        <title>Cadastro de Pedidos</title>
        <link rel="stylesheet" type="text/css" href="styletelas.css">
    </head>

    <body <c:if test="${operacao == 'Incluir'}">  onload="dataHoje()"</c:if>>
        <%@ include file="/shared/navbar.jsp" %>
        <input class="form-control" type="HIDDEN" required min="1" name="idPedido" id="idPedido" value="${pedido.id}">


        <div class="container">
            <div style="float: left; max-width: 33%">
                <form action="ManterPedidoController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                    <table>
                        <tr>
                        <input class="form-control" type="Hidden" min="0" name="id" id="id" value="${pedido.id}" readonly>
                        <td colspan="4" style="text-align: center">${operacao} Pedido</td>
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
                                            <option required value="${funcionario.id}" <c:if test="${pedido.funcionario.id == funcionario.id}"> selected</c:if>>${funcionario.id} - ${funcionario.nome}</option>
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
                            <td>
                                <label for="valorTotal">Valor Total</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="number" min="0"  name="valorTotal" id="valorTotal" <c:if
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
                                        <option required value="0" <c:if test="${pedido.cliente.id == null}"> selected</c:if></option>
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
                                <input class="form-control" type="date" required name="dataCriacao"  readonly id="dataCriacao" <c:if test="${operacao != 'Incluir'}">  value="${pedido.dataPedido}"</c:if>>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="dataPrevista">Data Prevista de Entrega</label>
                                </td>
                                <td colspan="4">
                                    <input class="form-control" type="date" maxlenght="10" minlength="10" min="" required name="dataPrevista" id="dataPrevista" value="${pedido.dataEntrega}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                                </td>
                            </tr>
                            <tr>

                                <td>
                                </td>

                            </tr>
                            <tr>

                                <td>

                                </td>

                            </tr>
                            <tr>
                                <td>
                                    <a href="PesquisaPedidoController">
                                        <input class="btn btn-danger" type="button" value="voltar">
                                    </a>
                                </td>
                                <td colspan="2" class="tdsalvar">
                                    <input class="btn btn-success" type="submit" name="" onclick="selectAll()" value="Confirmar">
                                </td>
                                <td>
                                    <a href="home.jsp">
                                        <input class="btn btn-primary" type="button" value="Home">
                                    </a>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>

                <div class="container" style="float: left; max-width: 60%">
                    <table class="table">
                        <tr>
                            <td>
                                Móveis já adicionados
                            </td>
                        </tr>
                        <tr>
                            <td>

                                <table id="tabelaProdutos" class="table">
                                    <tr>
                                        <td>Produto</td>
                                        <td>Valor</td>
                                        <td>Quantidade</td>
                                        <td>Valor Total</td>
                                        <td>Ação</td>
                                    <%
                                        //https://www.caelum.com.br/apostila-java-web/javaserver-pages/#exerccios-primeiro-jsp
                                        int j = 1;
                                    %>
                                    <c:forEach items="${moveisDoPedido}" var="movelPedido">
                                    <tr>
                                        <td class="form-control">${movelPedido.movel.nome}</td>
                                        <td ><input type='text' id="preco<%out.print(j);%>" value="${movelPedido.movel.preco}" readonly></td>
                                        <td ><input type="number" id="qtd<%out.print(j);%>" name="qtd<%out.print(j);%>" value="${movelPedido.quantidade}" min="1" oninput="mudarValor(this)" ></td>
                                        <td><input  type="number" id="vt<%out.print(j);%>" name="vt<%out.print(j);%>" value="${movelPedido.quantidade*movelPedido.movel.preco}" readonly></td>
                                        <td><button class="btn btn-danger" onclick="removeLinha(this)"> Remover</button></td>
                                        <td><input type='number' id="id<%out.print(j);%>" name="id<%out.print(j++);%>" value="${movelPedido.movel.id}" hidden></td>
                                    </tr>
                                </c:forEach>

                    </tr>
                </table>

                </td>
                </tr>
                </table>
            </div>   
            <div class="container" style="float: right; max-width: 7%">
                <table>
                    <tr>
                        <td>
                            Todos os Móveis
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <select id="MR" size="${moveis.size()}" multiple name="listaMoveisAdd" title="Selecione para adicionar">
                                //https://stackoverflow.com/questions/1490139/evaluate-list-contains-string-in-jstl
                                <c:forEach items="${moveis}" var="movel">
                                    <c:set var="contains" value="false" />
                                    <c:forEach var="item" items="${moveisDoPedido}">
                                        <c:if test="${item.movel.nome eq movel.nome}">
                                            <c:set var="contains" value="true" />
                                        </c:if>
                                    </c:forEach>
                                    <option onclick="adicionaLinha(${movel.id}, '${movel.nome}', '${movel.preco}', this)" value="${movel.id}" <c:if test="${contains}"> disabled </c:if>> ${movel.nome} </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
            </div>
        </div>

    </body>

    <script src="javascripto.js"></script>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</html>