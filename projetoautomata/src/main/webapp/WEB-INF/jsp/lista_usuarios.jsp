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
        <title>Usuarios</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h2>Usuarios Cadastrados</h2>
                    <table class="table">
                        <tr>
                            <th>Usuario ID</th>
                            <th>Nome</th>
                            <th>Login</th>
                            <th>Senha</th>
                            <th>Papel</th>
                            <th>Email</th>
                            <th colspan="2">Ação</th>
                        </tr>
                        <c:forEach items="${usuarios}" var="usuario">
                            <tr>
                                <td><c:out value="${usuario.id}" /></td>
                                <td><c:out value="${usuario.nome}" /></td>
                                <td><c:out value="${usuario.login}" /></td>
                                <td><c:out value="${usuario.senha}" /></td>
                                <td><c:out value="${usuario.papel}" /></td>
                                <td><c:out value="${usuario.email}" /></td>
                                <td><a role="button" class="btn btn-primary"
                                        href="usuarios?action=edit&id=<c:out value="${usuario.id}"/>">Atualizar</a></td>
                                <td><a role="button" class="btn btn-danger"
                                        href="usuarios?action=delete&id=<c:out value="${usuario.id}"/>">Excluir</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a <a class="btn btn-primary" role="button" href="usuarios?action=insert">Adicionar Usuario</a>
                        <a class="btn btn-danger" role="button" href="index.jsp">Voltar</a>
                </div>
            </div>
        </div>
        <c:import url="./rodape.jsp"/>
    </body>
</html>
