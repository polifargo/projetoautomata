<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="listaform.css" />
        <title>Adicionar Usuario</title>
    </head>
    <body>
        <form action="usuarios" method="post">
            <fieldset>
                <div>
                    <label for="usuarioid">Usuario ID</label> <input type="text"
                                                                     name="id" value="<c:out value="${usuario.id}" />"
                                                                     readonly="readonly" placeholder="Usuario ID" />
                </div>
                
                <div>
                    <label for="usuarionome">Nome</label> <input type="text"
                                                                     name="nome" value="<c:out value="${usuario.nome}" />"
                                                                     placeholder="Nome" />
                </div>
                
                <div>
                    <label for="usuariologin">Login</label> <input type="text"
                                                                     name="login" value="<c:out value="${usuario.login}" />"
                                                                     placeholder="Login" />
                </div>
                
                <div>
                    <label for="usuariosenha">Senha</label> <input type="text"
                                                                     name="senha" value="<c:out value="${usuario.senha}" />"
                                                                     placeholder="Senha" />
                </div>
                
                <div>
                    <label for="usuarioemail">Email</label> <input type="text"
                                                                     name="email" value="<c:out value="${usuario.email}" />"
                                                                     placeholder="Email" />
                </div>
                
                <div>
                    <input type="submit" value="Salvar" />
                </div>
            </fieldset>
        </form>
    </body>
</html>