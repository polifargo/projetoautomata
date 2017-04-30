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
        <title>Unidades</title>
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
                    <h2>Unidades cadastradas</h2>
                    <table class="table">
                        <tr>
                            <th>Unidade ID</th>
                            <th>Endereco</th>
                            <th>Nome</th>
                            <th>Razao</th>
                            <th>Cadastro Nacional</th>
                            <th colspan="2">Ação</th>
                        </tr>
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
                    </table>
                    <a class="btn btn-primary" role="button" href="unidades?action=insert">Adicionar Unidade</a>
                    <a class="btn btn-danger" role="button" href="index.jsp">Voltar</a>
                </div>
            </div>
        </div>
        <c:import url="./rodape.jsp"/>
    </body>
</html>
