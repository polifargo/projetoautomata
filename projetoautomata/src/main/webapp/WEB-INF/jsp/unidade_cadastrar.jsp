<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/listaform.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="">
        <meta name="description" content="">
        <title>Adicionar Unidade</title>
        <link href="css/listaform.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <form action="unidades" method="post">
            <fieldset class="form-group">
                <div class="form-group row">
                    <label for="unidadeid">Unidade ID</label> 
                    <input class="form-control" type="text"
                           name="id" value="<c:out value="${unidade.id}" />"
                           readonly="readonly" placeholder="Unidade ID" />
                </div>
                <div class="form-group row">
                    <label for="unidadeendereco">Endereco</label> 
                    <input class="form-control" type="text"
                           name="endereco" value="<c:out value="${unidade.endereco}" />"
                           placeholder="Endereco" />
                </div>
                <div class="form-group row">
                    <label for="unidadenome">Nome</label>
                    <input class="form-control" type="text"
                           name="nome" value="<c:out value="${unidade.nome}" />"
                           placeholder="Nome" />
                </div>
                <div class="form-group row">
                    <label for="unidaderazao">Razao</label> 
                    <input class="form-control" type="text"
                           name="razao" value="<c:out value="${unidade.razao}" />"
                           placeholder="Razao" />
                </div>
                <div class="form-group row">
                    <label for="unidadecadastroNacional">CPF/CNPJ</label> 
                    <input class="form-control" type="text"
                           name="cadastroNacional" value="<c:out value="${unidade.cadastroNacional}" />"
                           placeholder="CPF/CNPJ" />
                </div>
                <div class="form-group row">
                    <input type="submit" value="Salvar" />
                </div>
                <div class="form-group row">
                    <a class="btn btn-danger form-control" role="button" href="unidades">Cancelar</a>
                </div>
            </fieldset>
        </form>
    </body>
    <c:import url="./rodape.jsp"/>
</html>