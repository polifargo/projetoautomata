<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <title>Adicionar Servico</title>
    </head>
    <body>
        <form action="ServicoServlet.do" method="post">
            <fieldset>
                <div>
                    <label for="servicoid">Servico ID</label> <input type="text"
                                                                     name="id" value="<c:out value="${servico.id}" />"
                                                                     readonly="readonly" placeholder="Servico ID" />
                </div>
                
                <div>
                    <label for="servicodescricao">Descrição</label> <input type="text"
                                                                     name="descricao" value="<c:out value="${servico.descricao}" />"
                                                                     placeholder="Descrição" />
                </div>
                
                <div>
                    <label for="servicotipo">Tipo</label> <input type="text"
                                                                     name="tipo" value="<c:out value="${servico.tipo}" />"
                                                                     placeholder="Tipo" />
                </div>
                
                <div>
                    <label for="servicotecnico">Tecnico</label> <input type="text"
                                                                     name="tecnico" value="<c:out value="${servico.tecnico}" />"
                                                                     placeholder="Tecnico" />
                </div>
                
                <div>
                    <label for="servicomediaconclusao">Media Conclusao</label> <input type="text"
                                                                     name="mediaconclusao" value="<c:out value="${servico.mediaconclusao}" />"
                                                                     readonly="readonly" placeholder="Media Conclusao" />
                </div>
                
                <div>
                    <label for="servicomediahoras">Media Horas</label> <input type="text"
                                                                     name="mediahoras" value="<c:out value="${servico.mediahoras}" />"
                                                                     readonly="readonly" placeholder="Media Horas" />
                </div>
                
                <div>
                    <label for="servicovalor">Valor</label> <input type="text"
                                                                     name="valor" value="<c:out value="${servico.valor}" />"
                                                                     readonly="readonly" placeholder="Valor" />
                </div>
                
                <div>
                    <input type="submit" value="Salvar" />
                </div>
            </fieldset>
        </form>
    </body>
</html>