<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <%@ include file="/shared/head.jsp" %>
        <title>Sistema Interno</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >

        <script type="text/javascript" src="jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <style>
            a {
                float: right;
            }
        </style>
    </head>
    <c:if test="${sessionScope.nome != null}">
    
    <body>
        
        <%@ include file="/shared/navbar.jsp" %>
        <br>
 
        <div class="container">

            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Móveis</h4>
                            <a href="PesquisaMovelController" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Funcionário</h4>
                            <a href="PesquisaFuncionarioController" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Fornecedor</h4>
                            <a href="PesquisaFornecedorController" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Cliente</h4>
                            <a href="PesquisaClienteController" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Pedido</h4>
                            <a href="PesquisaPedidoController" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Material</h4>
                            <a href="PesquisaMaterialController" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Ferramenta</h4>
                            <a href="PesquisaFerramentaController" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </body>
    </c:if>

</html>