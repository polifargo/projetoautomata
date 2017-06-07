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
        $('#table').append('<tr>\n\
                                <td><input type="hidden" name="idProduto" class="form-control" type="text" value="' + produto + '"/>' + produto + '</td>\n\
                                <td><input type="hidden" name="prodqt" type="text" value="' + quantidade + '"/>' + quantidade + '</td>\n\
                                <td><input type="hidden" name="valorVenda" class="form-control" type="text" value="' + valorVenda + '"/>' + valorVenda + '</td>\n\
                                <td class="valorTotalUni"><input type="hidden" name="valorTotal" class="form-control" type="text" value="' + valorTotal + '"/>' + valorTotal + '</td>\n\
                            </tr>');
        
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

