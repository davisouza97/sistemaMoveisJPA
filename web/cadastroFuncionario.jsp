<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <%@ include file="/shared/head.jsp" %>
        <title>Cadastro de Funcionario</title>
    </head>

    <body>
<%@ include file="/shared/navbar.jsp" %>
        <div class="container">
            <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="POST">
                <table class="tableform">
                    <tr>
                        <td colspan="4" style="text-align: center">${operacao} Funcionario</td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <input class="form-control" type="HIDDEN" required min="1" name="id" id="id" value="${funcionario.id}"  <c:if test="${operacao == 'Editar'||operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="nome">Nome</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="nome" id="nome" value="${funcionario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="senha">Senha</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="password" maxlength="12" minlength="3" name="senha" id="senha" value="${funcionario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cpf">CPF</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" required maxlength="11" minlength="11" min="1" name="cpf" id="cpf" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="dataNascimento">Data de Nascimento</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="date" required name="dataNascimento" id="dataNascimento" value="${funcionario.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="email">e-mail</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="email" required name="email" id="email" value="${funcionario.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr><td><label for="celular">Celular</label></td><td><input class="form-control" type="text" required name="celular" id="celular" value="${funcionario.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td><td><label for="telefone">Telefone</label></td><td><input class="form-control" type="text" name="telefone" id="telefone" value="${funcionario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                        <tr>
                            <td>
                                <label for="cep">CEP</label>
                            </td>
                            <td colspan="1">
                                    <input class="form-control" type="text" required name="cep" id="cep" value="${funcionario.cep}" onblur="pesquisacep(this.value)" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="logradouro">Logradouro</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="logradouro" id="logradouro" value="${funcionario.logradouro}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="numero">Número</label>
                            </td>
                            <td>
                                <input class="form-control" type="number" required min="1" name="numero" id="numero" placeholder="numero" value="${funcionario.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>
                                <label for="bairro">Bairro</label>
                            </td>
                            <td>
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="bairro" id="bairro" value="${funcionario.bairro}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="uf">UF</label>
                            </td>
                            <td>
                                <input class="form-control" type="text" name="uf" id="uf" value="${funcionario.uf}" required  readonly>
                            </td>
                            <td>
                                <label for="cidade">Cidade</label>
                            </td>
                            <td>
                                <input class="form-control" type="text" required maxlength="45" minlength="3" name="cidade" id="cidade" value="${funcionario.cidade}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="complemento">Complemento</label>
                            </td>
                            <td colspan="4">
                                <input class="form-control" type="text" maxlength="45" minlength="3" name="complemento" id="complemento" value="${funcionario.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                        </tr>

                        <tr>
                            <td>Cargo </td>
                            <td colspan="4">
                                <select name="cargo" required id="cargo" class="form-control">
                                    <option value="Estagiário" <c:if test="${funcionario.cargo.equals('Estagiário')}"> selected</c:if>>Estagiario</option>
                                <option value="Gerente" <c:if test="${funcionario.cargo.equals('Gerente')}"> selected</c:if>>Gerente</option>
                                <option value="Marceneiro" <c:if test="${funcionario.cargo.equals('Marceneiro')}"> selected</c:if>>Marceneiro</option> 
                                <option value="secretária" <c:if test="${funcionario.cargo.equals('Secretária')}"> selected</c:if>>Secretaria</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="salario">Salário</label>
                            </td>
                            <td>
                                <input class="form-control" type="number" required min="0" name="salario" id="salario" value="${funcionario.salario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>
                            <td>Comissão&nbsp;</td>
                            <td>
                                <input type="radio" required name="comissao" value="S" <c:if test="${funcionario.comissao.equals('S')}"> checked</c:if>>S&nbsp;
                            <input type="radio" required name="comissao" value="N" <c:if test="${funcionario.comissao.equals('N')}"> checked</c:if>>N
                            </td>
                        </tr>

                        <tr>
                            <td>
                            <c:if test="${operacao != 'Cadastrar'}">
                                <a href="PesquisaFuncionarioController">
                                    <input class="btn btn-danger" type="button" value="voltar">
                                </a>
                            </c:if>
                            <c:if test="${operacao == 'Cadastrar'}">
                                <a href="DeslogarController">
                                    <input class="btn btn-danger" type="button" value="voltar">
                                </a>
                            </c:if>
                        </td>
                        <td colspan="2" class="tdsalvar" >
                            <input class="btn btn-success" type="submit" name="confirmar" value="Confirmar">
                        </td>
                        <c:if test="${operacao != 'Cadastrar'}">
                            <td>
                                <a href="home.jsp">
                                    <input class="btn btn-primary" type="button" value="Home">
                                </a>
                            </td>
                        </c:if>
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