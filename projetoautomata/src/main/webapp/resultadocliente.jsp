<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Cliente Adicionado</title>
    </head>
    <body>
        <h1>Cliente Novo</h1>
        <h1><c:out value="${sessionScope.novoCliente.nome}" /></h1>
        <p><c:out value="${sessionScope.novoCliente.tipo}" /></p>
        <p><c:out value="${sessionScope.novoCliente.cadastroNacional}" /></p>
        <p><c:out value="${sessionScope.novoCliente.endereco}" /></p>
        <p><c:out value="${sessionScope.novoCliente.email}" /></p>
        <p><c:out value="${sessionScope.novoCliente.telefone}" /></p>
        <c:remove scope="session" var="novoCliente" />
        <a href="listaclientes">Voltar</a>
    </body>
</html>
