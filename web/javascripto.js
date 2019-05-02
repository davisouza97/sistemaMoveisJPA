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
