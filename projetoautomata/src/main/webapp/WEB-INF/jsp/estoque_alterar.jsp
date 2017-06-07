
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="">
        <meta name="description" content="">
        <title>Estoque Produto</title>
        <link href="css/listaform.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <form action="estoque" method="post">
            <fieldset class="form-group container-fluid">
                <div class="form-group row" >
                    <div class="col-sm-2">
                        <label for="produtoid">Produto ID</label> 
                        <input  class="form-control" type="text"
                                name="id" value="<c:out value="${produto.id}" />"
                                readonly="readonly" maxlength="15" placeholder="Produto ID" />
                    </div>
                    <div class="col-sm-2">
                        <label for="produtomodelo">Modelo</label>
                        <input class="form-control" type="text"
                               name="modelo" value="<c:out value="${produto.modelo}" />"
                               readonly="readonly" placeholder="Modelo..." maxlength="60"/>
                    </div>
                    <div class="col-sm-2">
                        <label for="produtounidade">Unidade</label> 
                        <input class="form-control" type="text"
                               name="idUnidade" value="<c:out value="${produto.unidade}" />"
                               readonly="readonly" placeholder="Unidade..."/>
                    </div>
                    <div class="col-sm-2">
                        <label for="produtoquantidade">Quantidade</label> 
                        <input class="form-control" type="number"
                               name="quantidade" min='0' value="<c:out value="${produto.quantidade}"/>"
                               placeholder="Quantidade..." required/>
                    </div>
                    <div class="col-sm-2">
                        <input class="form-control" type="submit" value="Salvar" />
                    </div>
                    <div class="col-sm-2">
                        <a class="btn btn-danger form-control" role="button" href="estoque">Cancelar</a>
                    </div>
                </div>
            </fieldset>
        </form>
    </body>
    <c:import url="./rodape.jsp"/>
</html>
