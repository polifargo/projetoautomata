<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/listaform.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Usuarios</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Usuario ID</th>
                    <th>Nome</th>
                    <th>Login</th>
                    <th>Senha</th>
                    <th>Email</th>
                    <th colspan="2">Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${usuarios}" var="usuario">
                    <tr>
                        <td><c:out value="${usuario.id}" /></td>
                        <td><c:out value="${usuario.nome}" /></td>
                        <td><c:out value="${usuario.login}" /></td>
                        <td><c:out value="${usuario.senha}" /></td>
                        <td><c:out value="${usuario.email}" /></td>
                        <td><a
                                href="usuarios?action=edit&id=<c:out value="${usuario.id}"/>">Atualizar</a></td>
                        <td><a
                                href="usuarios?action=delete&id=<c:out value="${usuario.id}"/>">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="usuarios?action=insert">Adicionar Usuario</a>
            <br/>
            <a href="index.jsp">Voltar</a>
        </p>
    </body>
</html>
