<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <title>Adicionar Venda</title>
    </head>
    <body>
        <form action="VendaServlet.do" method="post">
            <fieldset>
                <div>
                    <label for="vendaid">Venda ID</label> <input type="text"
                                                                     name="id" value="<c:out value="${venda.id}" />"
                                                                     readonly="readonly" placeholder="Venda ID" />
                </div>
                
                <div>
                    <label for="vendacliente">Cliente</label> <input type="text"
                                                                     name="cliente" value="<c:out value="${venda.cliente}" />"
                                                                     placeholder="Cliente" />
                </div>
                
                <div>
                    <label for="vendatecnico">Tecnico</label> <input type="text"
                                                                     name="tecnico" value="<c:out value="${venda.tecnico}" />"
                                                                     placeholder="Tecnico" />
                </div>
                
                <div>
                    <label for="vendaunidade">Unidade</label> <input type="text"
                                                                     name="unidade" value="<c:out value="${venda.unidade}" />"
                                                                     placeholder="Unidade" />
                </div>
                
                <div>
                    <label for="vendavalor">Valor</label> <input type="text"
                                                                     name="valor" value="<c:out value="${venda.valor}" />"
                                                                     readonly="readonly" placeholder="Valor" />
                </div>
                
                <div>
                    <input type="submit" value="Salvar" />
                </div>
            </fieldset>
        </form>
    </body>
</html>