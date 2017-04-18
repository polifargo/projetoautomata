<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Clientes</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Cliente ID</th>
                    <th>Nome</th>
                    <th>Tipo</th>
                    <th>Cadastro Nacional</th>
                    <th>Endereco</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th colspan="2">Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${clientes}" var="cliente">
                    <tr>
                        <td><c:out value="${cliente.id}" /></td>
                        <td><c:out value="${cliente.nome}" /></td>
                        <td><c:out value="${cliente.tipo}" /></td>
                        <td><c:out value="${cliente.cadastronacional}" /></td>
                        <td><c:out value="${cliente.endereco}" /></td>
                        <td><c:out value="${cliente.email}" /></td>
                        <td><c:out value="${cliente.telefone}" /></td>
                        <td><a
                                href="ClienteServlet?action=edit&id=<c:out value="${cliente.id}"/>">Atualizar</a></td>
                        <td><a
                                href="ClienteServlet?action=delete&id=<c:out value="${cliente.id}"/>">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ClienteServlet?action=insert">Adicionar Cliente</a>
        </p>
    </body>
</html>
