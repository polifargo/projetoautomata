<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="listaform.css" />
        <title>Adicionar Produto</title>
    </head>
    <body>
        <form action="produtos" method="post">
            <fieldset>
                <div>
                    <label for="produtoid">Produto ID</label> <input type="text"
                                                                     name="id" value="<c:out value="${produto.id}" />"
                                                                     readonly="readonly" placeholder="Produto ID" />
                </div>

                <div>
                    <label for="produtomodelo">Modelo</label> <input type="text"
                                                                     name="modelo" value="<c:out value="${produto.modelo}" />"
                                                                     placeholder="Modelo" />
                </div>

                <div>
                    <label for="produtoqtminima">Qt. Mínima</label> <input type="text"
                                                                           name="qtminima" value="<c:out value="${produto.qtminima}" />"
                                                                           placeholder="Qt. Mínima" />
                </div>

                <div>
                    <label for="produtoqtmaxima">Qt. Máxima</label> <input type="text"
                                                                           name="qtmaxima" value="<c:out value="${produto.qtmaxima}" />"
                                                                           placeholder="Qt. Máxima" />
                </div>

                <div>
                    <label for="produtounidade">Unidade</label> <input type="text"
                                                                       name="unidade" value="<c:out value="${produto.unidade}" />"
                                                                       placeholder="Unidade" />
                </div>

                <div>
                    <label for="produtotipo">Tipo</label> <input type="text"
                                                                 name="tipo" value="<c:out value="${produto.tipo}" />"
                                                                 placeholder="Tipo" />
                </div>

                <div>
                    <label for="produtovalor">Valor</label> <input type="text"
                                                                   name="valor" value="<c:out value="${produto.valor}" />"
                                                                   placeholder="Valor" />
                </div>

                <div>
                    <input type="submit" value="Salvar" />
                </div>
            </fieldset>
        </form>
    </body>
</html>