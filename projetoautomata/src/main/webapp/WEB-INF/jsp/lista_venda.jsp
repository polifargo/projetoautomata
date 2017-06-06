<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/listaform.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="">
        <meta name="description" content="">
        <title>Relatório de vendas</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/filtrovenda.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h2>Relatório de vendas</h2>
                    <table class="table" id="table">
                        <tr>
                            <th>Cliente</th>
                            <th>Unidade</th>
                            <th>Dt. venda</th>
                            <th>F. pagamento</th>
                            <th>Vl. total</th>
                            <th>Notas internas</th>
                        </tr>
                        <c:forEach items="${venda}" var="venda">
                            <tr>
                                <td><c:out value="${venda.cliente.nome}" /></td>
                                <td><c:out value="${venda.unidade}" /></td>
                                <td><c:out value="${venda.data}" /></td>
                                <td><c:out value="${venda.formaPagamento}" /></td>
                                <td><c:out value="${venda.valor}" /></td>
                                <td><c:out value="${venda.notasInternas}" /></td>
                            </tr>
                        </c:forEach>
                        <div class="col-sm-4">
                            <span class="glyphicon glyphicon-search"></span>
                            <input class="form-inline pesquisaField" onkeyup="filtroCliente()" type="text" id="filtroCliente" placeholder="Pesquisar por cliente...">
                        </div>
                    </table>
                    <a class="btn btn-danger" role="button" href="inicio">Voltar</a>
                </div>
            </div>
        </div>
    </body>
    <c:import url="./rodape.jsp"/>
</html>