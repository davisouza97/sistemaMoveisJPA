<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file="/shared/head.jsp" %>
        <title>Sistema de Móveis</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
        <style type="text/css">
            .login-form {
                width: 340px;
                margin: 50px auto;

            }
            .login-form form {
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 20px;
            }
            .btn {        
                font-size: 15px;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="login-form">
            <form action="LogarController" method="POST">
                <h2 class="text-center">Logar</h2>       
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="CPF" name="login">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Senha" name="senha">
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary btn-block" value="Logar">
                </div>     
            </form>
            <p class="text-center"><a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Cadastrar">Criar Conta</a></p>
        </div>
    </body>
</html>                                		                            