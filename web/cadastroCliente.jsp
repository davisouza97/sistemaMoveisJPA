
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <%@ include file="/shared/head.jsp" %>
        <title>Cadastro de Clientes</title>
    </head>

    <body>
    <%@ include file="/shared/navbar.jsp" %>
        <div class="container">
            <form action="ManterClienteController?acao=confirmarOperacao&operacao=${operacao}" method="POST" autofocus>
                <table>
                    <tr>
                        <td colspan="4" style="text-align: center">${operacao} Cliente</td>
                    </tr>

                    <tr>
                        <td colspan="4">
                            <input type="HIDDEN" min="1" class="form-control" name="id" required id="id" value="${cliente.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="nome">Nome</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" maxlength="45" minlength="3"  name="nome" required id="nome" value="${cliente.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cpf">CPF</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="number" maxlenght="14" minlength="14" required name="cpf" id="cpf" value="${cliente.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="dataNascimento">Data de Nascimento</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="date" maxlenght="10" minlength="10"  required name="dataNascimento" id="dataNascimento" value="${cliente.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="celular">Celular</label>
                            </td>
                            <td>
                                <input class="form-control"  type="number" maxlenght="13" minlength="9" name="celular" required id="celular" value="${cliente.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="telefone">Telefone</label>
                            </td>
                            <td>
                                <input class="form-control" type="number" maxlenght="13" minlength="8" name="telefone" id="telefone" value="${cliente.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="e-mail">e-mail</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="email" name="email" required id="email" value="${cliente.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cep">CEP</label>
                            </td>
                            <td colspan="1">
                                <input class="form-control" type="text" name="cep" id="cep" maxlenght="8" minlength="8" oninput="pesquisacep(this.value)" required value="${cliente.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="logradouro">Logradouro</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" required name="logradouro" maxlenght="45" minlength="3" id="logradouro" value="${cliente.logradouro}" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="numero">Número</label>
                        </td>
                        <td>
                            <input class="form-control" type="number" maxlenght="6" minlength="1" name="numero" required id="numero" value="${cliente.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="bairro">Bairro</label>
                            </td>
                            <td>
                                <input class="form-control" type="text" name="bairro" id="bairro" value="${cliente.bairro}" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="uf" required>UF</label>
                        </td>
                        <td>
                            <input class="form-control" type="text" name="uf" id="uf" value="${cliente.uf}" required readonly>
                        </td>
                        <td>
                            <label for="cidade">Cidade</label>
                        </td>
                        <td>
                            <input class="form-control" type="text" maxlenght="45" minlength="2" required name="cidade" id="cidade" value="${cliente.cidade}" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="complemento">Complemento</label>
                        </td>
                        <td colspan="4">
                            <input class="form-control" type="text" maxlenght="45" name="complemento" id="complemento" value="${cliente.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <a href="PesquisaController?classe=Cliente">
                                <input class="btn btn-danger" type="button" value="voltar">
                            </a>
                        </td>
                        <td colspan="2">
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
        <script src="javascripto.js" type="text/javascript"></script>
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </body>
</html>