<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Arrays"%>
<%@page import="br.senac.tads3.pi03b.projetoautomata.models.Cliente"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <h1>Informações Cliente</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Tipo</th>
                <th>Cadastro Nacional</th>
                <th>Endereço</th>
                <th>Email</th>
                <th>Telefone</th>
            </tr>
            <c:forEach items="${listaClientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.id}" /></td>
                    <td><c:out value="${cliente.nome}" /></td>
                    <td><c:out value="${cliente.tipo}" /></td>
                    <td><c:out value="${cliente.cadastroNacional}" /></td>
                    <td><c:out value="${cliente.endereco}" /></td>
                    <td><c:out value="${cliente.email}" /></td>
                    <td><c:out value="${cliente.telefone}" /></td> 
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
