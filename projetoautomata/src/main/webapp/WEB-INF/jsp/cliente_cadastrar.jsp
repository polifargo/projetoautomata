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
        <script src="js/validacoes.js"></script>
    </head>
    <body>
        <div class="panel panel-default">
            <c:import url="./cabecalho.jsp"/>
            <form id="form" action="clientes" method="post">
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
                               placeholder="Nome..." id="nome" />
                    </div>
                    <div class="form-group row">
                        <label for="clientetipo">Tipo</label> 
                        <select name="tipo" class="form-control">
                            <option value="Pessoa Física">Pessoa Física</option>
                            <option value="Pessoa Jurídica">Pessoa Jurídica</option>
                        </select>
                    </div>
                    <div class="form-group row">
                        <label for="clientecadastronacional">Cadastro Nacional</label>
                        <input class="form-control" type="text" 
                               name="cadastronacional" value="<c:out value="${cliente.cadastroNacional}" />"
                               placeholder="CPF/CNPJ..." id="cpf"/>
                    </div>
                    <div class="form-group row">
                        <label for="clienteendereco">Endereco</label>
                        <input class="form-control" type="text"
                               name="endereco" value="<c:out value="${cliente.endereco}" />"
                               placeholder="Endereco..." id="endereco" />
                    </div>
                    <div class="form-group row">
                        <label for="clienteemail">Email</label> 
                        <input class="form-control" type="text"
                               name="email" value="<c:out value="${cliente.email}" />"
                               placeholder="Email..." id="email" />
                    </div>
                    <div class="form-group row">
                        <label for="clientetelefone">Telefone</label> 
                        <input class="form-control" type="text"
                               name="telefone" value="<c:out value="${cliente.telefone}" />"
                               placeholder="Telefone" id="telefone"/>
                    </div>                                       
                    <div class="form-group row">
                        <input class="form-control" type="submit" id="submit" value="Salvar" />
                    </div>
                    <div class="form-group row">
                        <a class="btn btn-danger form-control" role="button" href="clientes">Cancelar</a>
                    </div>
                </fieldset>
            </form>
        </div>
        <c:import url="./rodape.jsp"/>
    </body>
</html>