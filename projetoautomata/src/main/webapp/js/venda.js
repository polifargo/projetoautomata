var valorFinal = $("#valorFinal").val();

function addCart()
{   
    var produto = $("#produto").find('option:selected').val();
    var quantidade = $("#quantidadeVenda").val();
    var valorVenda;
    var valorTotal = valorVenda * quantidade;
    $('#table').append('<tr><td>'+ produto +'</td><td>'+ quantidade +'</td><td>'+ valorVenda +'</td>\n\
<td>'+ valorTotal +'</td></tr>');
    valorFinal = valorTotal+=valorTotal;
}

