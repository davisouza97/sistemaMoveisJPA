
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
        <title>Cadastro de Móveis</title>
    </head>

    <body>
        <div class="container">
            <form action="ManterMoveisController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table class="tableform">
                    <tr>
                        <td><input type="HIDDEN" required min="1" name="idPedido" id="idPedido" value="${movel.pedido}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                        <tr>
                            <td colspan="4">
                                <input class="form-control" type="HIDDEN" required min="1" name="id" id="id" value="${movel.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="nome">Nome</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="nome" id="nome" value="${movel.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="preco">Preço</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="number" required min="0" name="preco" id="preco" value="${movel.preco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="tipo">Tipo</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" required maxlength="45" minlength="2" name="tipo" id="tipo" value="${movel.tipo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="idFerramenta">Ferramenta</label>
                            </td>
                            <td colspan="4">
                                <select class="form-control" required name="idFerramenta" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option required value="0" <c:if test="${movel.material == null}"> selected</c:if>> </option>  
                                <c:forEach items="${ferramentas}" var="ferramenta">
                                    <option required value="${ferramenta.id}" <c:if test="${movel.ferramenta.id == ferramenta.id}"> selected</c:if>> ${ferramenta.nome}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                        
                        
                        <tr>
                            <td>
                                <label for="idMaterial">Material</label>
                            </td>
                            <td colspan="4">
                                <select class="form-control" required name="idMaterial" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option required value="0" <c:if test="${movel.material == null}"> selected</c:if>> </option>  
                                <c:forEach items="${materiais}" var="material">
                                    <option required value="${material.id}" <c:if test="${movel.material.id == material.id}"> selected</c:if>> ${material.nome}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="altura">Altura</label>
                        </td>
                        <td colspan="3">
                            <input class="form-control" type="number" min="1" name="altura" id="altura" value="${movel.altura}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="largura">Largura</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="number" min="1" name="largura" id="largura" value="${movel.largura}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="comprimento">Comprimento</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="number" min="1" name="comprimento" id="comprimento" value="${movel.comprimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>

                            <td>
                                <label for="peso">Peso</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="number" min="1" name="peso" id="peso" value="${movel.peso}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                       

                    <tr>
                        <td>
                            <a href="PesquisaMovelController">
                                <input class="btn btn-danger" type="button" value="voltar">
                            </a>
                        </td>
                        <td colspan="2" class="tdsalvar" >
                            <input class="btn btn-success" type="submit" name="salvar" value="Confirmar">
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
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </body>
</html>