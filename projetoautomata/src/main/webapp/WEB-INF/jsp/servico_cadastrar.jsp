<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/listaform.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="">
        <meta name="description" content="">
        <title>Adicionar Servico</title>
        <link href="css/listaform.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <form action="servicos" method="post">
            <fieldset class="form-group">
                <div class="form-group row">
                    <label for="servicoid">Servico ID</label> 
                    <input class="form-control" type="text"
                           name="id" value="<c:out value="${servico.id}" />"
                           readonly="readonly" placeholder="Servico ID" />
                </div>
                <div class="form-group row">
                    <label for="servicodescricao">Descrição</label> 
                    <input class="form-control" type="text"
                           name="descricao" value="<c:out value="${servico.descricao}" />"
                           placeholder="Descrição" />
                </div>
                <div class="form-group row">
                    <label for="servicotipo">Tipo</label>
                    <select name="tipo" class="form-control">
                        <option value="Montagem">Montagem</option>
                        <option value="Conserto">Conserto</option>
                        <option value="Formatação">Formatação</option>
                    </select>
                </div>
                <div class="form-group row">
                    <label for="servicotecnico">Tecnico</label> 
                    <input class="form-control" type="text"
                           name="tecnico" value="<c:out value="${servico.tecnico}" />"
                           placeholder="Tecnico" />
                </div>
                <div class="form-group row">
                    <label for="servicomediaconclusao">Media Conclusao</label> 
                    <input class="form-control" type="date"
                           name="mediaConclusao" value="<c:out value="${servico.mediaConclusao}" />"
                           placeholder="Media Conclusao" />
                </div>
                <div class="form-group row">
                    <label for="servicomediahoras">Media Horas</label>
                    <input class="form-control" type="number"
                           name="mediaHoras" value="<c:out value="${servico.mediaHoras}" />"
                           placeholder="Media Horas" />
                </div>
                <div class="form-group row">
                    <label for="servicovalor">Valor</label> 
                    <input class="form-control" type="number"
                           name="valor" value="<c:out value="${servico.valor}" />"
                           placeholder="Valor" />
                </div>
                <div class="form-group row">
                    <input class="form-control" type="submit" value="Salvar" />
                </div>
                <div class="form-group row">
                    <a class="btn btn-danger form-control" role="button" href="servicos">Cancelar</a>
                </div>
            </fieldset>
        </form>
    </body>
</html>