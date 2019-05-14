
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <%@ include file="/shared/head.jsp" %>
        <title>Cadastro de Ferramentas</title>
    </head>

    <body>
    <%@ include file="/shared/navbar.jsp" %>
        <div class="container">
            <form action="ManterFerramentaController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table class="tableform">
                    <tr><td colspan="4" style="text-align: center">${operacao} Ferramenta</td></tr>
                    <tr>

                        <td colspan="4">
                            <input class="form-control" type="HIDDEN" required min="1" name="idFerramenta" id="id" value="${ferramenta.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label for="nome">Nome</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" size="40" required maxlength="45" minlength="3" name="nome" id="nome" value="${ferramenta.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="tipo">Tipo</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" required maxlength="45" minlength="1" name="tipo" id="tipo" value="${ferramenta.tipo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="qtdEstoque">Quantidade</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="numer" required min="0" name="qtdEstoque" id="qtdEstoque" value="${ferramenta.qtdEstoque}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="valorUnitario">Valor Unitário</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="number"  required maxlength="45" minlength="1" min="0" name="valorUnitario" id="valorUnitario" value="${ferramenta.valorUnitario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="unidade">Unidade</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" required maxlength="45" minlength="1" name="unidade" id="unidade" value="${ferramenta.unidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>

                            <td>
                                <label for="idFornecedor">Fornecedor</label>
                            </td>
                            <td colspan="4"> 
                                <select class="form-control" required name="idFornecedor" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option required value="0" <c:if test="${ferramenta.fornecedor == null}"> selected</c:if>> </option>  
                                <c:forEach items="${fornecedores}" var="fornecedor">
                                    <option required value="${fornecedor.id}" <c:if test="${ferramenta.fornecedor.id == fornecedor.id}"> selected</c:if>>${fornecedor.nome}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="PesquisaFerramentaController">
                                <input class="btn btn-danger" type="button" value="voltar">
                            </a>
                        </td>
                        <td colspan="2" class="tdsalvar">
                            <input class="btn btn-success" type="submit" name="salvar" value="confirmar">
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