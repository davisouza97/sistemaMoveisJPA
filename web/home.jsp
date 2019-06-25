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
                            <a href="PesquisaController?classe=Movel" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Funcionário</h4>
                            <a href="PesquisaController?classe=Funcionario" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Fornecedor</h4>
                            <a href="PesquisaController?classe=Fornecedor" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Cliente</h4>
                            <a href="PesquisaController?classe=Cliente" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Pedido</h4>
                            <a href="PesquisaController?classe=Pedido" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Material</h4>
                            <a href="PesquisaController?classe=Material" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title">Ferramenta</h4>
                            <a href="PesquisaController?classe=Ferramenta" class="btn btn-primary">Manter</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </body>
    </c:if>

</html>