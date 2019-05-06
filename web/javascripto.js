function dataHoje() {
    var data = new Date();
    var dia = data.getDate();
    var mes = data.getMonth() + 1;
    var ano = data.getFullYear();
    if (mes.toString().length == 1) {
        mes = "0" + mes;
    }
    if (dia.toString().length == 1) {
        dia = "0" + dia;
    }
    var x = ano + "-" + mes + "-" + dia;
    console.log(x);
    document.getElementById('dataCriacao').value = x;
}

function addMovel(valor, nome = 'movel',quantidade) {
// get reference to select element
    var sel = document.getElementById('MA');
    var sel2 = document.getElementById('listaQtd');
    // create new option element
    var opt = document.createElement('option');
    var opt2 = document.createElement('option');
    // create text node to add to option element (opt)
    opt.appendChild(document.createTextNode(nome));
    opt2.appendChild(document.createTextNode(quantidade));
    // set value property of opt
    opt.value = valor;
    opt2.value = quantidade;
    opt.onclick = removeMovel;
    // add opt to end of select box (sel)
    sel.add(opt);
    sel2.add(opt2);
    
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

function inserirMovel(id, nome, preco, qtd, item) {
    item.disabled = true;
//https://www.portaleducacao.com.br/conteudo/artigos/idiomas/inserindo-linhas-em-uma-tabela-com-javascript/6592
// Captura a referência da tabela com id “minhaTabela”
    var table = document.getElementById("interno");
    // Captura a quantidade de linhas já existentes na tabela
    var numOfRows = table.rows.length;//footer tava atrapalhando
    // Captura a quantidade de colunas da última linha da tabela
    //var numOfCols = table.rows[numOfRows - 1].cells.length;

    // Insere uma linha no fim da tabela.
    //var newRow = table.insertRow(numOfRows);
    // Faz um loop para criar as colunas
    var insere = true;
    var linha = null;
    for (var k = 1; k < numOfRows - 1; k++) {
        var x = table.rows[k].cells[0].outerText;
        if (x === nome) {
            //console.log(table.rows[j].cells[0]);
            insere = false;
            linha = k;
            break;
        } else {
            insere = true;
            linha = null;
        }
    }

    if (insere) {
        var newRow = table.insertRow(numOfRows - 1);
        for (var j = 0; j < 5; j++) {

            newRow.value = id;
            // Insere uma coluna na nova linha 
            newCell = newRow.insertCell(j);
            // Insere um conteúdo na coluna
            if (j === 0) {
                newCell.innerHTML = nome;

            }
            if (j === 1) {
                newCell.innerHTML = preco;
            }
            if (j === 2) {
                var input = document.createElement("input");
                input.type = "number";
                input.value = qtd;
                //input.class = "valor";
                newCell.appendChild(input);
            }
            if (j === 3) {
                newCell.innerHTML = "$$$$$$";
            }
            if (j === 4) {
                newCell.innerHTML = "botao";
            }
        }
        addMovel(id, nome);
    } else {
//        var vlr = table.rows[linha].cells[2].value;
//        console.log(vlr);
//        console.log(table.rows[linha].cells[2]);
//        //var vlr = table.rows[linha].cells[2].innerHTML.value;
//        table.rows[linha].cells[2].innerHTML = parseInt(table.rows[linha].cells[2].innerHTML,10)+1;
    }

}


