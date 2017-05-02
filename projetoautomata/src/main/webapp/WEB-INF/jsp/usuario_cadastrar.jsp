<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/listaform.css" />
        <title>Adicionar Usuario</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="panel panel-default">
            <form action="usuarios" method="post">
                <fieldset class="form-group">
                    <div class="form-group row">
                        <label for="usuarioid">Usuario ID</label>
                        <input class="form-control" type="text"
                               name="id" value="<c:out value="${usuario.id}" />"
                               readonly="readonly" placeholder="Usuario ID" />
                    </div>
                    <div class="form-group row">
                        <label for="usuarionome">Nome</label>
                        <input class="form-control" type="text"
                               name="nome" value="<c:out value="${usuario.nome}" />"
                               placeholder="Nome" />
                    </div>
                    <div class="form-group row">
                        <label for="usuariologin">Login</label>
                        <input class="form-control" type="text"
                               name="login" value="<c:out value="${usuario.login}" />"
                               placeholder="Login" />
                    </div>
                    <div class="form-group row">
                        <label for="usuariosenha">Senha</label> 
                        <input class="form-control" type="text"
                               name="senha" value="<c:out value="${usuario.senha}" />"
                               placeholder="Senha" />
                    </div>
                    <div class="form-group row">
                        <label for="usuarioemail">Email</label>
                        <input class="form-control" type="text"
                               name="email" value="<c:out value="${usuario.email}" />"
                               placeholder="Email" />
                    </div>
                    <div class="form-group row">
                        <input class="form-control" type="submit" value="Salvar" />
                    </div>
                    <div class="form-group row">
                        <a class="btn btn-danger form-control" role="button" href="usuarios">Cancelar</a>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
    <c:import url="./rodape.jsp"/>
</html>