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
        <title>Adicionar Cliente</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <form action="clientes" method="post">
            <fieldset class="form-group">
                <div class="form-group row">
                    <label for="clienteid">Cliente ID</label> 
                    <input class="form-control" type="text"
                           name="id" value="<c:out value="${cliente.id}" />"
                           readonly="readonly" placeholder="Cliente ID" />
                </div>
                <div class="form-group row">
                    <label for="clientenome">Nome</label> 
                    <input class="form-control" type="text"
                           name="nome" value="<c:out value="${cliente.nome}" />"
                           placeholder="Nome..." />
                </div>
                <div class="form-group row">
                    <label for="clientetipo">Tipo</label> 
                    <input class="form-control" type="text"
                           name="tipo" value="<c:out value="${cliente.tipo}" />"
                           placeholder="Tipo..." />
                </div>
                <div class="form-group row">
                    <label for="clientecadastronacional">Cadastro Nacional</label>
                    <input class="form-control" type="text"
                           name="cadastronacional" value="<c:out value="${cliente.cadastroNacional}" />"
                           placeholder="CPF/CNPJ..." />
                </div>
                <div class="form-group row">
                    <label for="clienteendereco">Endereco</label>
                    <input class="form-control" type="text"
                           name="endereco" value="<c:out value="${cliente.endereco}" />"
                           placeholder="Endereco..." />
                </div>
                <div class="form-group row">
                    <label for="clienteemail">Email</label> 
                    <input class="form-control" type="text"
                           name="email" value="<c:out value="${cliente.email}" />"
                           placeholder="Email..." />
                </div>
                <div class="form-group row">
                    <label for="clientetelefone">Telefone</label> 
                    <input class="form-control" type="text"
                           name="telefone" value="<c:out value="${cliente.telefone}" />"
                           placeholder="Telefone" />
                </div>                                       
                <div class="form-group row">
                    <input class="form-control" type="submit" value="Salvar" />
                </div>
            </fieldset>
        </form>
    </body>
</html>