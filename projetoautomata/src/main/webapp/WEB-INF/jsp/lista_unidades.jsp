<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="listaform.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Unidades</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Unidade ID</th>
                    <th>Endereco</th>
                    <th>Nome</th>
                    <th>Razao</th>
                    <th>Cadastro Nacional</th>
                    <th colspan="2">Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${unidades}" var="unidade">
                    <tr>
                        <td><c:out value="${unidade.id}" /></td>
                        <td><c:out value="${unidade.endereco}" /></td>
                        <td><c:out value="${unidade.nome}" /></td>
                        <td><c:out value="${unidade.razao}" /></td>
                        <td><c:out value="${unidade.cadastroNacional}" /></td>
                        <td><a
                                href="unidades?action=edit&id=<c:out value="${unidade.id}"/>">Atualizar</a></td>
                        <td><a
                                href="unidades?action=delete&id=<c:out value="${unidade.id}"/>">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="unidades?action=insert">Adicionar Unidade</a>
            <br/>
            <a href="index.jsp">Voltar</a>
        </p>
    </body>
</html>
