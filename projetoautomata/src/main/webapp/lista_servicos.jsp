<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="listaform.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Servicos</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Servico ID</th>
                    <th>Descricao</th>
                    <th>Tipo</th>
                    <th>Tecnico</th>
                    <th>Media Conclusao</th>
                    <th>Media Horas</th>
                    <th>Valor</th>
                    <th colspan="2">Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${servicos}" var="servico">
                    <tr>
                        <td><c:out value="${servico.id}" /></td>
                        <td><c:out value="${servico.descricao}" /></td>
                        <td><c:out value="${servico.tipo}" /></td>
                        <td><c:out value="${servico.tecnico}" /></td>
                        <td><c:out value="${servico.mediaConclusao}" /></td>
                        <td><c:out value="${servico.mediaHoras}" /></td>
                        <td><c:out value="${servico.valor}" /></td>
                        <td><a
                                href="ServicoServlet?action=edit&id=<c:out value="${servico.id}"/>">Atualizar</a></td>
                        <td><a
                                href="ServicoServlet?action=delete&id=<c:out value="${servico.id}"/>">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ServicoServlet?action=insert">Adicionar Servico</a>
            <br/>
            <a href="index.jsp">Voltar</a>
        </p>
    </body>
</html>