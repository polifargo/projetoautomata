<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/listaform.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="">
        <meta name="description" content="">
        <title>Adicionar Usuario</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
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
                               placeholder="Nome" maxlength="30" required/>
                    </div>
                    <div class="form-group row">
                        <label for="usuariologin">Login</label>
                        <input class="form-control" type="text"
                               name="login" value="<c:out value="${usuario.login}" />"
                               placeholder="Login" maxlength="30" required/>
                    </div>
                    <div class="form-group row">
                        <label for="usuariosenha">Senha</label> 
                        <input class="form-control" type="text"
                               name="senha" value="<c:out value="${usuario.senha}" />"
                               placeholder="Senha" maxlength="15" required/>
                    </div>
                    <div class="form-group row">
                        <label for="usuariopapel">Papel</label> 
                        <select name="papel" class="form-control">
                            <option value="ADMIN">Administrador</option>
                            <option value="BASICO">Basico</option>
                        </select>
                    </div >
                    <div class="form-group row">
                        <label for="usuarioemail">Email</label>
                        <input class="form-control" type="email"
                               name="email" value="<c:out value="${usuario.email}" />"
                               placeholder="Email" maxlength="30" required />
                    </div>
                    <div class="form-group row">
                        <input class="form-control" type="submit" value="Salvar" />
                    </div>
                    <div class="form-group row">
                        <a class="btn btn-danger form-control" role="button" href="usuarios">Cancelar</a>
                    </div>
                </fieldset>
            </form>
    </body>
    <c:import url="./rodape.jsp"/>
</html>