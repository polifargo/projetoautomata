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
        <c:import url="./cabecalho.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h2>Clientes cadastrados</h2>
                    <table class="table">
                        <tr>
                            <th>Cliente ID</th>
                            <th>Nome</th>
                            <th>Apelido</th>
                            <th>Tipo</th>
                            <th>UF</th>
                            <th>CEP</th>
                            <th>Cidade</th>
                            <th>Email</th>
                            <th>Telefone</th>
                            <th>Inativo</th>
                            <th>Cadastro Nacional</th>
                            <th colspan="2">Ação</th>
                        </tr>
                        <c:forEach items="${clientes}" var="cliente">
                            <tr>
                                <td><c:out value="${cliente.id}" /></td>
                                <td><c:out value="${cliente.nome}" /></td>
                                <td><c:out value="${cliente.apelido}" /></td>
                                <td><c:out value="${cliente.tipo}" /></td>
                                <td><c:out value="${cliente.uf}" /></td>
                                <td><c:out value="${cliente.cep}" /></td>
                                <td><c:out value="${cliente.cidade}" /></td>
                                <td><c:out value="${cliente.email}" /></td>
                                <td><c:out value="${cliente.telefone}" /></td>
                                <td><c:out value="${cliente.inativo}" /></td>
                                <td><c:out value="${cliente.cadastroNacional}" /></td>
                                <td><a role="button" class="btn btn-primary"
                                       href="clientes?action=edit&id=<c:out value="${cliente.id}"/>">Atualizar</a></td>
                                <td><a role="button" class="btn btn-danger"
                                       href="clientes?action=delete&id=<c:out value="${cliente.id}"/>">Excluir</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a class="btn btn-primary" role="button" href="clientes?action=insert">Adicionar Cliente</a>
                    <a class="btn btn-danger" role="button" href="inicio">Voltar</a>
                </div>
            </div>
        </div>
    </body>
    <c:import url="./rodape.jsp"/>
</html>
