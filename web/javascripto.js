function dataHoje() {
    var data = new Date();
    var dia = data.getDate();
    var mes = data.getMonth() + 1;
    var ano = data.getFullYear();

    if (mes.toString().length === 1) {
        mes = "0" + mes;
    }
    if (dia.toString().length === 1) {
        dia = "0" + dia;
    }
    var x = ano + "-" + mes + "-" + dia;
    console.log(x);
    document.getElementById('dataCriacao').value = x;
}

function addMovel(valor, nome = 'movel') {
    // get reference to select element
    var sel = document.getElementById('MA');
    // create new option element
    var opt = document.createElement('option');
    // create text node to add to option element (opt)
    opt.appendChild(document.createTextNode(nome));
    // set value property of opt
    opt.value = valor;
    opt.onclick = removeMovel;
    // add opt to end of select box (sel)
    sel.add(opt);
}

function removeMovel() {
    var x = document.getElementById("MA");
    console.log(x.value);
    x.remove(x.selectedIndex);
}

function selectAll() {
    selectBox = document.getElementById('MA');
    for (var i = 0; i < selectBox.options.length; i++) {
        selectBox.options[i].selected = true;
    }
}

function limpa_formulario_cep() {
    //Limpa valores do formulário de cep.
    document.getElementById('logradouro').value = ("");
    document.getElementById('bairro').value = ("");
    document.getElementById('cidade').value = ("");
    document.getElementById('uf').value = ("");

}

function meu_callback(conteudo) {
    if (!("erro" in conteudo)) {
        //Atualiza os campos com os valores.
        document.getElementById('logradouro').value = (conteudo.logradouro);
        document.getElementById('bairro').value = (conteudo.bairro);
        document.getElementById('cidade').value = (conteudo.localidade);
        document.getElementById('uf').value = (conteudo.uf);

    } //end if.
    else {
        //CEP não Encontrado.
        limpa_formulario_cep();
        alert("CEP não encontrado.");
    }
}

function pesquisacep(valor) {

    //Nova variável "cep" somente com dígitos.
    var cep = valor.replace(/\D/g, '');
    console.log(cep);
    limpa_formulario_cep();
    if (cep.lenght < 8) {
        console.log("aeee");
    } else {
        //Verifica se campo cep possui valor informado.
        if (cep !== "") {

            //Expressão regular para validar o CEP.
            var validacep = /^[0-9]{8}$/;

            //Valida o formato do CEP.
            if (validacep.test(cep)) {

                //Preenche os campos com "..." enquanto consulta webservice.
                document.getElementById('logradouro').value = "...";
                document.getElementById('bairro').value = "...";
                document.getElementById('cidade').value = "...";
                document.getElementById('uf').value = "...";


                //Cria um elemento javascript.
                var script = document.createElement('script');

                //Sincroniza com o callback.
                script.src = 'https://viacep.com.br/ws/' + cep + '/json/?callback=meu_callback';

                //Insere script no documento e carrega o conteúdo.
                document.body.appendChild(script);

            }
        }
    }
}

//pedido
//https://gist.github.com/macsousa/be5b8c5075720c5463c349710fdfb0c8

  //Funcao adiciona uma nova linha na tabela
            function adicionaLinha(id,nome,preco,isso) {
                isso.disabled = true;
                var tabela = document.getElementById("tabelaProdutos");
                var numeroLinhas = tabela.rows.length;
                var linha = tabela.insertRow(numeroLinhas);
                var celula1 = linha.insertCell(0);
                var celula2 = linha.insertCell(1);   
                var celula3 = linha.insertCell(2); 
                var celula4 = linha.insertCell(3);   
                var celula5 = linha.insertCell(4); 
                var celula6 = linha.insertCell(5);
               
                celula1.innerHTML = `<input class="form-control" type='text' id="nome${numeroLinhas}" value="${nome}" readonly>`;
                
                celula2.innerHTML =  `<input class="form-control" type='text' id="preco${numeroLinhas}" value="${preco}" readonly>`; 
                celula3.innerHTML =  `<input class="form-control" type='number' id="qtd${numeroLinhas}" name="qtd${numeroLinhas}" value='1' min="1" oninput="mudarValor(this)">`;
                celula4.innerHTML =  `<input class="form-control" type='number' id="vt${numeroLinhas}" value="${preco}" readonly>`;
                celula5.innerHTML = `<button class="btn btn-danger" onclick='removeLinha(this)'>Remover</button>`;
                celula6.innerHTML =  `<input type='number' id="id${numeroLinhas}"  name="id${numeroLinhas}" value="${id}" hidden>`;
            }
            
            // funcao remove uma linha da tabela
            function removeLinha(linha) {
              var i=linha.parentNode.parentNode.rowIndex;
              var selectMoveis = document.getElementById("MR");
              console.log(selectMoveis);
              document.getElementById('tabelaProdutos').deleteRow(i);
            }            
            
            function mudarValor(isso){
                var valorTotal = document.getElementById(`vt${isso.parentNode.parentNode.rowIndex}`);
                valorTotal.value = (isso.value*document.getElementById(`preco${isso.parentNode.parentNode.rowIndex}`).value).toFixed(2);
            }
