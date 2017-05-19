<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="">
        <meta name="description" content="">
        <title>Adicionar Produto</title>
        <link href="css/listaform.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.maskedinput.js"></script>
        <script src="js/jquery.maskMoney.js"></script>
        <script src="js/validacoes.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <form action="produtos" method="post">
            <fieldset class="form-group container-fluid">
                <div class="form-group row" >
                    <label for="produtoid">Produto ID</label> 
                    <input  class="form-control" type="text"
                            name="id" value="<c:out value="${produto.id}" />"
                            maxlength="15" placeholder="Produto ID"/>
                </div>
                <div class="form-group row" >
                    <label for="produtomodelo">Modelo</label>
                    <input class="form-control" type="text"
                           name="modelo" value="<c:out value="${produto.modelo}" />"
                           placeholder="Modelo..." maxlength="60"/>
                </div>
                <div class="form-group row">
                    <label for="produtounidade">Unidade</label> 
                    <select name="unidade" required class="form-control">
                        <c:forEach var="unidade" items="${listaUnidades}">
                            <option value="${unidade.fantasia}">${unidade.fantasia}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group row">
                    <label for="produtovalor">Valor Custo</label> 
                    <input class="form-control" type="text" id="valorCusto"
                           name="valorCusto" value="<c:out value="${produto.valorCusto}"/>"
                           placeholder="Valor Custo..."/>
                </div>
                <div class="form-group row">
                    <label for="produtovalor">Valor Venda</label> 
                    <input class="form-control" type="text" id="valorVenda"
                           name="valorVenda" value="<c:out value="${produto.valorVenda}"/>"
                           placeholder="Valor Venda..."/>
                </div>
                <div class="form-group row">
                    <label for="clientenotasinternas">Notas Internas</label> 
                    <input class="form-control" type="textarea"
                           name="notasInternas" maxlength="1000" placeholder="Notas Internas..." value="<c:out value="${produto.notasInternas}" />"
                           />
                </div> 
                <div class="form-group row">
                    <label for="produtoinativo">Inativo</label> 
                    <select name="inativo" class="form-control">
                        <option selected value="1">Ativo</option>
                        <option value="0">Inativo</option>
                    </select>
                </div>
                <div class="form-group row">
                    <input class="form-control" type="submit" value="Salvar" />
                </div>
                <div class="form-group row">
                    <a class="btn btn-danger form-control" role="button" href="produtos">Cancelar</a>
                </div>
            </fieldset>
        </form>
    </body>
    <c:import url="./rodape.jsp"/>
</html>