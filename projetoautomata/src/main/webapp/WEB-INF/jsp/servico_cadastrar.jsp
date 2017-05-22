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
        <title>Adicionar Servico</title>
        <link href="css/listaform.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.maskMoney.js"></script>
        <script src="js/jquery.maskedinput.js"></script>
        <script src="js/validacoes.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <form action="servicos" method="post">
            <fieldset class="form-group container-fluid">
                <div class="form-group row">
                    <div class="col-sm-4">
                        <label for="servicoid">Servico ID</label> 
                        <input class="form-control" type="text"
                               name="id" value="<c:out value="${servico.id}" />"
                               maxlength="15" placeholder="Servico ID" required/>
                    </div>
                    <div class="col-sm-8">
                        <label for="servicodescricao">Descrição</label> 
                        <input class="form-control" type="text"
                               name="descricao" value="<c:out value="${servico.descricao}" />"
                               placeholder="Descrição..." maxlength="60" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-4">
                        <label for="servicotipo">Tipo</label>
                        <select name="tipo" class="form-control">
                            <option value="Montagem" ${tipo == 'Montagem' ? 'selected' : ''}>Montagem</option>
                            <option value="Conserto" ${tipo == 'Conserto' ? 'selected' : ''}>Conserto</option>
                            <option value="Formatação" ${tipo == 'Formatação' ? 'selected' : ''}>Formatação</option>
                        </select>
                    </div>
                    <div class="col-sm-4">
                        <label for="servicovalor">Valor</label> 
                        <input class="form-control" type="text" id="valor"
                               name="valor" value="<c:out value="${servico.valor}" />"
                               placeholder="Valor..." required/>
                    </div>
                    <div class="col-sm-4">
                        <label for="servicoinativo">Status</label> 
                        <select name="inativo" class="form-control">
                            <option value="1" ${status == '1' ? 'selected' : ''}>Ativo</option>
                            <option value="0" ${status == '0' ? 'selected' : ''}>Inativo</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-8">
                        <label for="serviconotasinternas">Notas Internas</label> 
                        <input class="form-control" type="textarea"
                               name="notasInternas" value="<c:out value="${servico.notasInternas}" />"
                               placeholder="Notas Internas..." maxlength="1000" requireds/>
                    </div>
                    <div class="col-sm-2">
                        <input class="form-control" type="submit" value="Salvar" />
                    </div>
                    <div class="col-sm-2">
                        <a class="btn btn-danger form-control" role="button" href="servicos">Cancelar</a>
                    </div>
                </div>
            </fieldset>
        </form>
    </body>
    <c:import url="./rodape.jsp"/>
</html>