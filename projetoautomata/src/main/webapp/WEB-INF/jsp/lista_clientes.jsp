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
        <title>Clientes</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h2>Clientes cadastrados</h2>
                    <table class="table">
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
                        <c:forEach items="${clientes}" var="cliente">
                            <tr>
                                <td><c:out value="${cliente.id}" /></td>
                                <td><c:out value="${cliente.nome}" /></td>
                                <td><c:out value="${cliente.tipo}" /></td>
                                <td><c:out value="${cliente.cadastroNacional}" /></td>
                                <td><c:out value="${cliente.endereco}" /></td>
                                <td><c:out value="${cliente.email}" /></td>
                                <td><c:out value="${cliente.telefone}" /></td>
                                <td><a
                                        href="clientes?action=edit&id=<c:out value="${cliente.id}"/>">Atualizar</a></td>
                                <td><a
                                        href="clientes?action=delete&id=<c:out value="${cliente.id}"/>">Excluir</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a href="clientes?action=insert">Adicionar Cliente</a>
                </div>
            </div>
        </div>
    </body>
</html>
