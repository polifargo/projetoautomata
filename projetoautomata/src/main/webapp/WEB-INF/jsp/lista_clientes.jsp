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
        <script src="js/filtrodepesquisa.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h2>Clientes cadastrados</h2>
                    <table id="table" class="table">
                        <tr>
                            <th>Cliente ID</th>
                            <th>Apelido</th>
                            <th>Nome</th>
                            <th>Cidade</th>
                            <th>Telefone</th>
                            <th>Cadastro Nacional</th>
                            <th class="text-center" colspan="2">A��o</th>
                        </tr>
                        <c:forEach items="${clientes}" var="cliente">
                            <tr>
                                <td><c:out value="${cliente.id}" /></td>
                                <td><c:out value="${cliente.apelido}" /></td>
                                <td><c:out value="${cliente.nome}" /></td>
                                <td><c:out value="${cliente.cidade}" /></td>                              
                                <td><c:out value="${cliente.telefone}" /></td>
                                <td><c:out value="${cliente.cadastroNacional}" /></td>
                                <td><a role="button" class="btn btn-primary"
                                       href="clientes?action=edit&id=<c:out value="${cliente.id}"/>">Atualizar</a></td>
                                <td><a onclick="return confirm('Tem certeza?');" role="button" class="btn btn-danger"
                                       href="clientes?action=delete&id=<c:out value="${cliente.id}"/>">Inativar</a></td>
                            </tr>
                        </c:forEach>
                        <div class="col-sm-4">
                            <span class="glyphicon glyphicon-search"></span>
                            <input class="form-inline pesquisaField" onkeyup="filtroNome()" type="text" id="filtroNome" placeholder="Pesquisar por nome...">
                        </div>
                        <div class="col-sm-4">
                            <span class="glyphicon glyphicon-search"></span>
                            <input class="form-inline pesquisaField" onkeyup="filtroID()" type="text" id="filtroID" placeholder="Pesquisar por ID...">
                        </div>
                    </table>
                    <a class="btn btn-primary" role="button" href="clientes?action=insert">Adicionar Cliente</a>
                    <a class="btn btn-danger" role="button" href="inicio">Voltar</a>
                </div>
            </div>
        </div>
    </body>
    <c:import url="./rodape.jsp"/>
</html>
