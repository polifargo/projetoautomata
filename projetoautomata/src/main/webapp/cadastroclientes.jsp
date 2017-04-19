<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="listaform.css" />
        <title>Adicionar Cliente</title>
    </head>
    <body>
        <form action="ClienteServlet" method="post">
            <fieldset>
                <div>
                    <label for="clienteid">Cliente ID</label> <input type="text"
                                                                     name="id" value="<c:out value="${cliente.id}" />"
                                                                     readonly="readonly" placeholder="Cliente ID" />
                </div>
                <div>
                    <label for="clienteNome">Nome</label> <input type="text"
                                                                 name="nome" value="<c:out value="${cliente.nome}" />"
                                                                 placeholder="Nome..." />
                </div>
                <div>
                    <label for="cliente">Tipo</label> <input type="text"
                                                             name="tipo" value="<c:out value="${cliente.tipo}" />"
                                                             placeholder="Tipo..." />
                </div>
                <div>
                    <label for="cliente">Cadastro Nacional</label> <input type="text"
                                                                          name="cadastronacional" value="<c:out value="${cliente.cadastroNacional}" />"
                                                                          placeholder="CPF/CNPJ..." />
                </div>
                <div>
                    <label for="cliente">Endereco</label> <input type="text"
                                                                 name="endereco" value="<c:out value="${cliente.endereco}" />"
                                                                 placeholder="Endereco..." />
                </div>
                <div>
                    <label for="cliente">Email</label> <input type="text"
                                                              name="email" value="<c:out value="${cliente.email}" />"
                                                              placeholder="Email..." />
                </div>
                <div>
                    <label for="cliente">Telefone</label> <input type="text"
                                                                 name="telefone" value="<c:out value="${cliente.telefone}" />"
                                                                 placeholder="Telefone" />
                </div>                                       
                <div>
                    <input type="submit" value="Salvar" />
                </div>
            </fieldset>
        </form>
    </body>
</html>