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
        <title>Servicos</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/filtrodepesquisa.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h2>Servicos cadastrados</h2>
                    <table id="table" class="table">
                        <tr>
                            <th>Servico ID</th>
                            <th>Descricao</th>
                            <th>Tipo</th>
                            <th>Valor</th>
                            <th>Notas Internas</th>
                            <th>Inativo</th>
                            <th class="text-center" colspan="2">Ação</th>
                        </tr>
                        <c:forEach items="${servicos}" var="servico">
                            <tr>
                                <td><c:out value="${servico.id}" /></td>
                                <td><c:out value="${servico.descricao}" /></td>
                                <td><c:out value="${servico.tipo}" /></td>
                                <td><c:out value="${servico.valor}" /></td>
                                <td><c:out value="${servico.notasInternas}" /></td>
                                <td><c:out value="${servico.inativo}" /></td>
                                <td><a role="button" class="btn btn-primary"
                                       href="servicos?action=edit&id=<c:out value="${servico.id}"/>">Atualizar</a></td>
                                <td><a onclick="return confirm('Tem certeza?');" role="button" class="btn btn-danger"
                                       href="servicos?action=delete&id=<c:out value="${servico.id}"/>">Inativar</a></td>
                            </tr>
                        </c:forEach>
                        <div class="col-sm-4">
                            <span class="glyphicon glyphicon-search"></span>
                            <input class="form-inline" onkeyup="filtroDescricao()" type="text" id="filtroDescricao" placeholder="Pesquisar por descricao...">
                        </div>
                        <div class="col-sm-4">
                            <span class="glyphicon glyphicon-search"></span>
                            <input class="form-inline" onkeyup="filtroID()" type="text" id="filtroID" placeholder="Pesquisar por ID...">
                        </div>
                    </table>
                    <a class="btn btn-primary" role="button" href="servicos?action=insert">Adicionar Servico</a>
                    <a class="btn btn-danger" role="button" href="inicio">Voltar</a>
                </div>
            </div>
        </div>
    </body>
    <c:import url="./rodape.jsp"/>
</html>
