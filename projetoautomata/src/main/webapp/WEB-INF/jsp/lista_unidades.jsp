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
        <script src="js/filtrodepesquisa.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h2>Unidades Cadastradas</h2>
                    <table id="table" class="table">
                        <tr>
                            <th>Unidade ID</th>
                            <th>Fantasia</th>
                            <th>Razao</th>
                            <th>UF</th>
                            <th>CEP</th>
                            <th>Cidade</th>
                            <th>Email</th>
                            <th>Telefone</th>
                            <th>Notas Internas</th>
                            <th>Cadastro Nacional</th>
                            <th class="text-center" colspan="2">Ação</th>
                        </tr>
                        <c:forEach items="${unidades}" var="unidade">
                            <tr>
                                <td><c:out value="${unidade.id}" /></td>
                                <td><c:out value="${unidade.fantasia}" /></td>
                                <td><c:out value="${unidade.razao}" /></td>
                                <td><c:out value="${unidade.uf}" /></td>
                                <td><c:out value="${unidade.cep}" /></td>
                                <td><c:out value="${unidade.cidade}" /></td>
                                <td><c:out value="${unidade.email}" /></td>
                                <td><c:out value="${unidade.telefone}" /></td>
                                <td><c:out value="${unidade.notasInternas}" /></td>
                                <td><c:out value="${unidade.cadastroNacional}" /></td>
                                <td><a role="button" class="btn btn-primary"
                                       href="unidades?action=edit&id=<c:out value="${unidade.id}"/>">Atualizar</a></td>
                                <td><a onclick="return confirm('Tem certeza?');" role="button" class="btn btn-danger"
                                       href="unidades?action=delete&id=<c:out value="${unidade.id}"/>">Inativar</a></td>
                            </tr>
                        </c:forEach>
                        <div class="col-sm-4">
                            <span class="glyphicon glyphicon-search"></span>
                            <input class="form-inline pesquisaField" onkeyup="filtroFantasia()" type="text" id="filtroFantasia" placeholder="Pesquisar por fantasia...">
                        </div>
                        <div class="col-sm-4">
                            <span class="glyphicon glyphicon-search"></span>
                            <input class="form-inline pesquisaField" onkeyup="filtroID()" type="text" id="filtroID" placeholder="Pesquisar por ID...">
                        </div>
                    </table>
                    <a class="btn btn-primary" role="button" href="unidades?action=insert">Adicionar Unidade</a>
                    <a class="btn btn-danger" role="button" href="inicio">Voltar</a>
                </div>
            </div>
        </div>
    </body>
    <c:import url="./rodape.jsp"/>
</html>
