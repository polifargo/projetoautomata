<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <title>Adicionar Prestação de Serviço</title>
    </head>
    <body>
        <form action="PrestacaoServicoServlet.do" method="post">
            <fieldset>
                <div>
                    <label for="prestacaoservicoid">Prestacao Servico ID</label> <input type="text"
                                                                     name="id" value="<c:out value="${prestacaoservico.id}" />"
                                                                     readonly="readonly" placeholder="Prestacao Servico ID" />
                </div>
                
                <div>
                    <label for="prestacaoservicodescricao">Descrição</label> <input type="text"
                                                                     name="descricao" value="<c:out value="${prestacaoservico.descricao}" />"
                                                                     placeholder="Descrição" />
                </div>
                
                <div>
                    <label for="prestacaoservicohorario">Horario</label> <input type="text"
                                                                     name="horario" value="<c:out value="${prestacaoservico.horario}" />"
                                                                     placeholder="Horario" />
                </div>
                
                <div>
                    <label for="prestacaoservicovalor">Valor</label> <input type="text"
                                                                     name="valor" value="<c:out value="${prestacaoservico.valor}" />"
                                                                     readonly="readonly" placeholder="Valor" />
                </div>
                
                <div>
                    <input type="submit" value="Salvar" />
                </div>
            </fieldset>
        </form>
    </body>
</html>