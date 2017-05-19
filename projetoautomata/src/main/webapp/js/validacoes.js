$(function () {
    $("input").blur(function () {
        if ($(this).val() === "")
        {
            $(this).css({"border": "1px solid #F00", "padding": "2px"});
        }
    });
    $("#submit").click(function () {
        var cont = 0;
        $("#form input").each(function () {
            if ($(this).val() === "")
            {
                $(this).css({"border": "1px solid #F00", "padding": "2px"});
                cont++;
            }
        });
        if (cont === 0)
        {
            $("#form").submit();
        }
    });
    $("#cadastroNacional").mask('999.999.999-99', {reverse: true});
    $("#cep").mask("99999-999");
    $('#cnpj').mask('99.999.999/9999-99', {reverse: true});
    $('#telefone').mask("(99)9999-9999?9").ready(function (event) {
        var target, phone, element;
        target = (event.currentTarget) ? event.currentTarget : event.srcElement;
        phone = target.value.replace(/\D/g, '');
        element = $(target);
        element.unmask();
        if (phone.length > 10) {
            element.mask("(99)99999-999?9");
        } else {
            element.mask("(99)9999-9999?9");
        }
    }
    );
    $("#valorVenda").maskMoney({symbol: 'R$ ',
        showSymbol: true, thousands: '.', decimal: ',', symbolStay: true});
    $("#valorCusto").maskMoney({symbol: 'R$ ',
        showSymbol: true, thousands: '.', decimal: ',', symbolStay: true});
});