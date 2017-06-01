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
        <title>Produtos</title>
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
                    <h2>Produtos cadastrados</h2>
                    <table id="table" class="table">
                        <tr>
                            <th>Produto ID</th>
                            <th>Modelo</th>
                            <th>Unidade</th>
                            <th>Valor Custo</th>
                            <th>Valor Venda</th>
                            <th>Notas Internas</th>
                            <th class="text-center" colspan="2">Ação</th>
                        </tr>
                        <c:forEach items="${produtos}" var="produto">
                            <tr>
                                <td><c:out value="${produto.id}" /></td>
                                <td><c:out value="${produto.modelo}" /></td>
                                <td><c:out value="${produto.unidade}" /></td>
                                <td><c:out value="${produto.valorCusto}" /></td>
                                <td><c:out value="${produto.valorVenda}" /></td>
                                <td><c:out value="${produto.notasInternas}" /></td>
                                <td><a role="button" class="btn btn-primary"
                                       href="produtos?action=edit&id=<c:out value="${produto.id}"/>">Atualizar</a></td>
                                <td><a onclick="return confirm('Tem certeza?');" role="button" class="btn btn-danger"
                                       href="produtos?action=delete&id=<c:out value="${produto.id}"/>">Inativar</a></td>
                            </tr>
                        </c:forEach>
                        <div class="col-sm-4">
                            <span class="glyphicon glyphicon-search"></span>
                            <input class="form-inline pesquisaField" onkeyup="filtroModelo()" type="text" id="filtroModelo" placeholder="Pesquisar por modelo...">
                        </div>
                        <div class="col-sm-4">
                            <span class="glyphicon glyphicon-search"></span>
                            <input class="form-inline pesquisaField" onkeyup="filtroID()" type="text" id="filtroID" placeholder="Pesquisar por ID...">
                        </div>
                    </table>
                    <a class="btn btn-primary" role="button" href="produtos?action=insert">Adicionar Produto</a>
                    <a class="btn btn-danger" role="button" href="inicio">Voltar</a>
                </div>
            </div>
        </div>
    </body>
    <c:import url="./rodape.jsp"/>
</html>
