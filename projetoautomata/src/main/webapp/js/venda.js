$(function () {
    $("#adicionar").hide();
    
    $("#produto").on('change', function () {
        $("#adicionar").show();
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
        $('#table').append('<tr><td>' + produto + '</td><td>' + quantidade + '</td><td>' + valorVenda + '</td>\n\
<td class="valorTotalUni">' + valorTotal + '</td></tr>');
        
        var sum = 0;
        
        $(".valorTotalUni").each(function () {
            var value = $(this).text();
            // add only if the value is number
            if (!isNaN(value) && value.length !== 0) {
                sum += parseFloat(value);
            }
        });

        $("#valorFinal").val(sum);
    });
});

