$(function () {

    var sum = 0;

    $("#produto").on('change', function () {
        let val = $(this).find('option:selected').val();
        let produto = val.split('+').pop();
        $("#valorUnitario").val(produto);
    });

    $("#adicionar").on('click', function () {
        let val = $("#produto").find('option:selected').val();
        let produto = val.substr(0, val.indexOf('+'));
        let quantidade = $("#quantidadeVenda").val();
        let valorVenda = $("#valorUnitario").val();
        let valorTotal = valorVenda * quantidade;

        if (!isNaN(quantidade) || quantidade > 0 || quantidade !== "") {
            $('#table').append('<tr><td>' + produto + '</td><td>' + quantidade + '</td><td>' + valorVenda + '</td>\n\
<td id="valorTotal">' + valorTotal + '</td></tr>');
        } else {
            alert("Quantidade inválida");
        }

        $("#valorTotal").each(function () {
            var value = $(this).text();
            // add only if the value is number
            if (!isNaN(value) && value.length !== 0) {
                sum += parseFloat(value);
            }
        });

        $("#valorFinal").val(sum);
    });
});

