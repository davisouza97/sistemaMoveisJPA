
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <%@ include file="/shared/head.jsp" %>
        <title>Grid Móveis</title>
        <script src="main.js"></script>
    </head>

    <body>
        <%@ include file="/shared/navbar.jsp" %>
        <div class="container">

            <table class="table table-striped table-bordered table-condensed table-hover" id="lista">
                <tr>
                    <th colspan="4">Grid Moveis</th>
                </tr>
                <tr>
                    <th>nome</th>
                    <th colspan="1">Ações</th>
                    <th colspan="1"><input id="filtro-nome"/></th>
                </tr>
                <c:forEach items="${moveis}" var="movel">
                    <tr>
                        <td>
                            <c:out value="${movel.nome}" />
                        </td>
                        <td><a class="btn btn-primary" href="ManterMoveisController?acao=prepararOperacao&operacao=Editar&id=<c:out value="${movel.id}" />">Editar</a></td>
                        <td><a class="btn btn-primary" href="ManterMoveisController?acao=prepararOperacao&operacao=Excluir&id=<c:out value="${movel.id}" />">Excluir</a></td>
                    </tr>
                </c:forEach>
                <td><a class="btn btn-danger" href="home.jsp">Voltar</a></td>
                <td colspan="3"><a class="btn btn-primary" href="ManterMoveisController?acao=prepararOperacao&operacao=Incluir">Incluir</a></td>
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
                                <a href="RelatorioControllerMoveis" class="btn btn-success">Emitir Relatorio</a>
                            </div> 
                        </div>
                        <div class="modal-body">
                            <h5>
                                Escolha o Tipo
                            </h5>
                            <form action="RelatorioControllerMoveisPar" method="POST" autofocus>
                                <select class="form-control" name="paramMovel">  
                                    <c:forEach items="${moveis}" var="movel">
                                        <option value="${movel.tipo}">${movel.tipo}</option>  
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
        <script>
            var filtro = document.getElementById('filtro-nome');
            var tabela = document.getElementById('lista');
            filtro.onkeyup = function () {
                var nomeFiltro = filtro.value;
                nomeFiltro = nomeFiltro.toLowerCase();
                for (var i = 2; i < tabela.rows.length-1; i++) {
                    var conteudoCelula = tabela.rows[i].cells[0].innerText;
                    var corresponde = conteudoCelula.toLowerCase().indexOf(nomeFiltro) >= 0;
                    tabela.rows[i].style.display = corresponde ? '' : 'none';
                }
            };
        </script>
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </body>

</html>