<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <title>Adicionar Unidade</title>
    </head>
    <body>
        <form action="UnidadeServlet.do" method="post">
            <fieldset>
                <div>
                    <label for="unidadeid">Unidade ID</label> <input type="text"
                                                                     name="id" value="<c:out value="${unidade.id}" />"
                                                                     readonly="readonly" placeholder="Unidade ID" />
                </div>
                
                <div>
                    <label for="unidadeendereco">Endereco</label> <input type="text"
                                                                     name="endereco" value="<c:out value="${unidade.endereco}" />"
                                                                     placeholder="Endereco" />
                </div>
                
                <div>
                    <label for="unidadenome">Nome</label> <input type="text"
                                                                     name="nome" value="<c:out value="${unidade.nome}" />"
                                                                     placeholder="Nome" />
                </div>
                
                <div>
                    <label for="unidaderazao">Razao</label> <input type="text"
                                                                     name="razao" value="<c:out value="${unidade.razao}" />"
                                                                     placeholder="Razao" />
                </div>
                
                <div>
                    <label for="unidadecadastroNacional">CPF/CNPJ</label> <input type="text"
                                                                     name="cadastroNacional" value="<c:out value="${unidade.cadastroNacional}" />"
                                                                     placeholder="CPF/CNPJ" />
                </div>
                
                <div>
                    <input type="submit" value="Salvar" />
                </div>
            </fieldset>
        </form>
    </body>
</html>