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
        <form action="produtos" method="post">
            <fieldset class="form-group">
                <div class="form-group row" >
                    <label for="produtoid">Produto ID</label> 
                    <input  class="form-control" type="text"
                            name="id" value="<c:out value="${produto.id}" />"
                            readonly="readonly" placeholder="Produto ID" />
                </div>
                <div class="form-group row" >
                    <label for="produtomodelo">Modelo</label>
                    <input class="form-control" type="text"
                           name="modelo" value="<c:out value="${produto.modelo}" />"
                           placeholder="Modelo" />
                </div>
                <div  class="form-group row">
                    <label for="produtoqtminima">Qt. Mínima</label> 
                    <input class="form-control" type="number"
                           name="qtminima" value="<c:out value="${produto.qtminima}" />"
                           placeholder="Qt. Mínima" />
                </div>
                <div class="form-group row">
                    <label for="produtoqtmaxima">Qt. Máxima</label> 
                    <input class="form-control" type="number"
                           name="qtmaxima" value="<c:out value="${produto.qtmaxima}" />"
                           placeholder="Qt. Máxima" />
                </div>
                <div class="form-group row">
                    <label for="produtounidade">Unidade</label> 
                    <input class="form-control" type="text"
                           name="unidade" value="<c:out value="${produto.unidade}" />"
                           placeholder="Unidade" />
                </div>
                <div class="form-group row">
                    <label for="produtotipo">Tipo</label> 
                    <select name="tipo" class="form-control">
                        <option value="Placa Mãe">Placa Mãe</option>
                        <option value="Memória RAM">Memória RAM</option>
                        <option value="Placa de Vídeo">Placa de Vídeo</option>
                        <option value="SSD">SSD</option>
                        <option value="Fonte">Fonte</option>
                    </select>
                </div >
                <div class="form-group row">
                    <label for="produtovalor">Valor</label> 
                    <input class="form-control" type="number"
                           name="valor" value="<c:out value="${produto.valor}" />"
                           placeholder="Valor" />
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
</html>