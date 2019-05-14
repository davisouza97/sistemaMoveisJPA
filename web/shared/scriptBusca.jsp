<%-- 
    Document   : scriptBusca
    Created on : 14/05/2019, 14:07:29
    Author     : davis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        