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
        <script type="text/javascript">
            function dataHoje() {
                var data = new Date();
                var dia = data.getDate();
                var mes = data.getMonth() + 1;
                var ano = data.getFullYear();

                if (mes.toString().length == 1) {
                    mes = "0" + mes;
                }
                if (dia.toString().length == 1) {
                    dia = "0" + dia;
                }
                var x = ano + "-" + mes + "-" + dia;
                console.log(x);
                document.getElementById('dataCriacao').value = x;
            }

            function addMovel(valor, nome = 'movel') {
                // get reference to select element
                var sel = document.getElementById('MA');
                // create new option element
                var opt = document.createElement('option');
                // create text node to add to option element (opt)
                opt.appendChild(document.createTextNode(nome));
                // set value property of opt
                opt.value = valor;
                opt.onclick = removeMovel;
                // add opt to end of select box (sel)
                sel.add(opt);
            }

            function removeMovel() {
                var x = document.getElementById("MA");
                console.log(x.value);
                x.remove(x.selectedIndex);
            }

            function selectAll() {
                selectBox = document.getElementById('MA');
                for (var i = 0; i < selectBox.options.length; i++) {
                    selectBox.options[i].selected = true;
                }
            }


        </script>
        <title>Cadastro de Pedidos</title>
    </head>

    <body <c:if test="${operacao == 'Incluir'}">  onload="dataHoje()"</c:if>>

            <input class="form-control" type="HIDDEN" required min="1" name="idPedido" id="idPedido" value="${pedido.id}">


        <div class="container">
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
                                Móveis já adicionados
                            </td>
                            <td>
                            </td>
                            <td>
                                Todos os Móveis
                            </td>
                        </tr>
                        <tr>
                            <td>

                            <c:if test="${true}">
                                <select id="MA" size="5" multiple name="listaMoveis" title="Selecione para remover">
                                    <c:forEach items="${moveisDoPedido}" var="movelPedido">
                                        <option onclick="removeMovel()" value="${movelPedido.movel.id}"> ${movelPedido.movel.nome}</option>
                                    </c:forEach>
                                </select>
                            </c:if>
                        </td>
                        <td></td>
                        <c:if test="${true}">
                            <td>
                                <select id="MR" size="5" multiple name="listaMoveisAdd" title="Selecione para adicionar">
                                    <c:forEach items="${moveis}" var="movel">
                                        <option onclick="addMovel(${movel.id}, '${movel.nome}')" value="${movel.id}" > ${movel.nome}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </c:if>
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
    </body>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</html>