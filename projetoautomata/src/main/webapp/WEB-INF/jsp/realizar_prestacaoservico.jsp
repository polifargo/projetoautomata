<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/listaform.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="">
        <meta name="description" content="">
        <title>Adicionar Prestação de Serviço</title>
        <link href="css/listaform.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <form action="prestacaoservico" method="post">
            <fieldset class="form-group">
                <div class="form-group row">
                    <label for="prestacaoservicoid">Prestacao Servico ID</label>
                    <input class="form-control" type="text"
                           name="id" value="<c:out value="${prestacaoservico.id}" />"
                           readonly="readonly" placeholder="Prestacao Servico ID" />
                </div>
                <div class="form-group row">
                    <label for="prestacaoservicodescricao">Descrição</label> 
                    <input class="form-control" type="text"
                           name="descricao" value="<c:out value="${prestacaoservico.descricao}" />"
                           placeholder="Descrição" />
                </div>
                <div class="form-group row">
                    <label for="prestacaoservicohorario">Horario</label> 
                    <input class="form-control" type="text"
                           name="horario" value="<c:out value="${prestacaoservico.horario}" />"
                           placeholder="Horario" />
                </div>
                <div class="form-group row">
                    <label for="prestacaoservicovalor">Valor</label> 
                    <input class="form-control" type="text"
                           name="valor" value="<c:out value="${prestacaoservico.valor}" />"
                           readonly="readonly" placeholder="Valor" />
                </div>
                <div class="form-group row">
                    <input class="form-control" type="submit" value="Salvar" />
                </div>
            </fieldset>
        </form>
    </body>
    <c:import url="./rodape.jsp"/>
</html>