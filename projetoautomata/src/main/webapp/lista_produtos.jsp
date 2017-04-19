<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="listaform.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Produtos</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Produto ID</th>
                    <th>Modelo</th>
                    <th>Quantidade Maxima</th>
                    <th>Quantidade Minima</th>
                    <th>Unidade</th>
                    <th>Tipo</th>
                    <th>Valor</th>
                    <th colspan="2">Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${produtos}" var="produto">
                    <tr>
                        <td><c:out value="${produto.id}" /></td>
                        <td><c:out value="${produto.modelo}" /></td>
                        <td><c:out value="${produto.qtminima}" /></td>
                        <td><c:out value="${produto.qtmaxima}" /></td>
                        <td><c:out value="${produto.unidade}" /></td>
                        <td><c:out value="${produto.tipo}" /></td>
                        <td><c:out value="${produto.valor}" /></td>
                        <td><a
                                href="ProdutoServlet?action=edit&id=<c:out value="${produto.id}"/>">Atualizar</a></td>
                        <td><a
                                href="ProdutoServlet?action=delete&id=<c:out value="${produto.id}"/>">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ProdutoServlet?action=insert">Adicionar Produto</a>
            <br/>
            <a href="index.jsp">Voltar</a>
        </p>
    </body>
</html>
