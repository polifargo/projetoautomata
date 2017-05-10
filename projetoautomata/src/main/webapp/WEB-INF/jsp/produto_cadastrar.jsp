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
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="panel panel-default">
            <form action="produtos" method="post">
                <fieldset class="form-group">
                    <div class="form-group row" >
                        <label for="produtoid">Produto ID</label> 
                        <input  class="form-control" type="text"
                                name="id" value="<c:out value="${produto.id}" />"
                                readonly="readonly" maxlength="15" placeholder="Produto ID" />
                    </div>
                    <div class="form-group row" >
                        <label for="produtomodelo">Modelo</label>
                        <input class="form-control" type="text"
                               name="modelo" value="<c:out value="${produto.modelo}" />"
                               placeholder="Modelo..." maxlength="60" required/>
                    </div>
                    <div class="form-group row">
                        <label for="produtounidade">Unidade</label> 
                        <input class="form-control" type="text"
                               name="unidade" value="<c:out value="${produto.unidade}" />"
                               placeholder="Unidade..." maxlength="30" required/>
                    </div>
                    <div class="form-group row">
                        <label for="produtovalor">Valor Venda</label> 
                        <input class="form-control" type="number"
                               name="valorVenda" value="<c:out value="${produto.valorCusto}" />"
                               placeholder="Valor Venda..." required/>
                    </div>
                    <div class="form-group row">
                        <label for="produtovalor">Valor Venda</label> 
                        <input class="form-control" type="number"
                               name="valorCusto" value="<c:out value="${produto.valorVenda}" />"
                               placeholder="Valor Custo..." required/>
                    </div>
                    <div class="form-group row">
                        <label for="clientenotasinternas">Notas Internas</label> 
                        <input class="form-control" type="textarea"
                               name="notasInternas" maxlength="1000" placeholder="Notas Internas..." value="<c:out value="${produto.notasInternas}" />"
                               />
                    </div> 
                    <div class="form-group row">
                        <label for="clienteinativo">Inativo</label> 
                        <input class="form-control" type="number"
                               name="inativo" maxlength="1" placeholder="Inativo..." value="<c:out value="${produto.inativo}" />"
                               id="inativo" required/>
                    </div> 
                    <div class="form-group row">
                        <input class="form-control" type="submit" value="Salvar" />
                    </div>
                    <div class="form-group row">
                        <a class="btn btn-danger form-control" role="button" href="produtos">Cancelar</a>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
    <c:import url="./rodape.jsp"/>
</html>