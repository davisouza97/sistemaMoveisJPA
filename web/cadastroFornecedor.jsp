<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >

        <title>Cadastro de Fornecedor</title>
    </head>

    <body>

        <div class="container">
            <form action="ManterFornecedorController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table class="tableform">
                    <tr>
                        <td colspan="4" style="text-align: center">${operacao} Fornecedor</td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <input class="form-control" type="HIDDEN" required min="1" name="id" id="id" value="${fornecedor.id}"  <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="nome">Nome</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="nome" id="nome" value="${fornecedor.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cnpj">CNPJ</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="number" required min="1" name="cnpj" id="cnpj" value="${fornecedor.cnpj}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="email">e-mail</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="email" id="email" value="${fornecedor.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label  for="celular">Celular</label>
                            </td>
                            <td>
                                <input class="form-control" type="text" required name="celular" id="celular" value="${fornecedor.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="telefone">Telefone</label>
                            </td>
                            <td>
                                <input class="form-control" type="text" name="telefone" id="telefone" value="${fornecedor.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cep">CEP</label>
                            </td>
                            <td colspan="1">
                                <input class="form-control" type="text" required min="1" name="cep" id="cep" value="${fornecedor.cep}" onblur="pesquisacep(this.value)" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="logradouro">Logradouro</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="logradouro" id="logradouro" value="${fornecedor.logradouro}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="numero">Numero</label>
                            </td>
                            <td>
                                <input class="form-control" type="number" required min="1" name="numero" id="numero"  value="${fornecedor.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="bairro">Bairro</label>
                            </td>
                            <td>
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="bairro" id="bairro" value="${fornecedor.bairro}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="uf">UF</label>
                            </td>
                            <td>
                                <input class="form-control" type="text" name="uf" id="uf" value="${fornecedor.uf}" required readonly>
                            </td>
                            <td>
                                <label for="cidade">Cidade</label>
                            </td>
                            <td>
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="cidade" id="cidade" value="${fornecedor.cidade}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="complemento">Complemento</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" name="complemento" id="complemento" value="${fornecedor.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                    </tr>


                    <tr>
                        <td>
                            <a href="PesquisaFornecedorController">
                                <input class="btn btn-danger" type="button" value="voltar">
                            </a>
                        </td>
                        <td colspan="2" class="tdsalvar">
                            <input class="btn btn-success" type="submit" name="confirmar" value="Confirmar">
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
        <script src="javascripto.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </body>

</html>