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
        <title>Realizar Venda</title>
        <link href="css/listaform.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
            <form action="venda" method="post">
                <fieldset class="form-group">
                    <div class="form-group row">
                        <label for="vendaid">Venda ID</label>
                        <input class="form-control" type="text"
                               name="id" value="<c:out value="${venda.id}" />"
                               readonly="readonly" placeholder="Venda ID" />
                    </div>
                    <div class="form-group row">
                        <label for="vendacliente">Cliente</label>
                        <input class="form-control" type="text"
                               name="cliente" value="<c:out value="${venda.cliente}" />"
                               placeholder="Cliente" />
                    </div>
                    <div class="form-group row">
                        <label for="vendatecnico">Tecnico</label> 
                        <input class="form-control" type="text"
                               name="tecnico" value="<c:out value="${venda.tecnico}" />"
                               placeholder="Tecnico" />
                    </div>
                    <div class="form-group row">
                        <label for="vendaunidade">Unidade</label>
                        <input class="form-control" type="text"
                               name="unidade" value="<c:out value="${venda.unidade}" />"
                               placeholder="Unidade" />
                    </div>
                    <div class="form-group row">
                        <label for="vendavalor">Valor</label> 
                        <input class="form-control" type="text"
                               name="valor" value="<c:out value="${venda.valor}" />"
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