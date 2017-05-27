function addCart()
{
    var produtoValue = $("#produto").find('option:selected').val();
    var produto = produtoValue.substr(0, produtoValue.indexOf('+'));
    var quantidade = $("#quantidadeVenda").val();
    var valorVenda = $("#valorUnitario").val();
    var valorTotal = valorVenda * quantidade;
    $('#table').append('<tr><td>' + produto + '</td><td>' + quantidade + '</td><td>' + valorVenda + '</td>\n\
<td>' + valorTotal + '</td></tr>');
}

function getValorUnitario() {
    var selectedValue = document.getElementById("produto");
    var value = selectedValue.options[selectedValue.selectedIndex].value;
    var produto = value.split('+').pop();
    document.getElementById("valorUnitario").value = produto; //assign value
}

