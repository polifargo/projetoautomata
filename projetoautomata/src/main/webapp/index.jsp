<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="">
        <meta name="description" content="">
        <title>Welcome</title>
        <link rel="stylesheet" type="text/css" href="css/listaform.css" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:if test="${not empty sessionScope.usuario}">
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand"><img src="resources/logo.png"></a>
                </div>
                <a class="navbar-brand" href="clientes">Clientes</a>
                <a class="navbar-brand" href="produtos">Produtos</a>
                <a class="navbar-brand" href="servicos">Servicos</a>
                <a class="navbar-brand" href="unidades">Unidades</a>
                <a class="navbar-brand" href="usuarios">Usuarios</a>
                <a class="navbar-brand" href="venda">Realizar Venda</a>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.jsp"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                    <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>Sair</a></li>
                    <li><a><span class="glyphicon glyphicon-user"></span><c:out value="${sessionScope.usuario.nome}" /></a></li>
                </ul>
            </div>
        </nav>
        <c:import url="WEB-INF/jsp/rodape.jsp"/>
    </c:if>
</body>
</html>
