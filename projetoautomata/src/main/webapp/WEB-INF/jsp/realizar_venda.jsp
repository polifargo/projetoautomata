<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/listaform.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="">
        <meta name="description" content="">
        <title>Realizar Venda</title>
        <link href="css/listaform.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <form action="venda" method="post">
            <fieldset class="form-group">
                <div class="form-group row">
                    <label for="vendaid">Venda ID</label>
                    <input class="form-control" type="text"
                           name="id" value="<c:out value="${venda.Id}" />"
                           readonly="readonly" placeholder="Venda ID" />
                </div>
                <div class="form-group row">
                    <label for="vendacliente">Cliente</label> 
                    <select name="cliente" required class="form-control">
                        <c:forEach var="cliente" items="${clientes}">
                            <option value="${cliente.id}">${cliente.id} - ${cliente.apelido}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group row">
                    <label for="vendatecnico">Tecnico</label> 
                    <select name="tecnico" class="form-control">
                        <option value="none">Sem Tecnico</option>
                        <option value="Carlos">Carlos</option>
                        <option value="Marcos">Marcos</option>
                        <option value="Paulo">Paulo</option>
                        <option value="Renato">Renato</option>
                    </select>
                </div>
                <div class="form-group row">
                    <label for="produtounidade">Unidade</label> 
                    <select name="unidade" required class="form-control">
                        <c:forEach var="unidade" items="${unidades}">
                            <option value="${unidade.fantasia}">${unidade.fantasia}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group row">
                    <label for="vendacliente">Produtos</label> 
                    <select name="produto" required class="form-control">
                        <c:forEach var="produto" items="${produtos}">
                            <option value="${produto.id}">${produto.id} - ${produto.modelo}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group row">
                    <label for="vendacarrinho">Carrinho</label> 
                    <table class="table">
                        <tr>
                            <th>Produto ID</th>
                            <th>Quantidade</th>
                            <th>Valor Unitario</th>
                            <th>Valor Total</th>
                        </tr>
                        <c:forEach items="${itemsVenda}" var="itemVenda">
                            <tr>
                                <td><c:out value="${itemVenda.idProduto}" /></td>
                                <td><c:out value="${itemVenda.quantidade}" /></td>
                                <td><c:out value="${itemVenda.valorUnitario}" /></td>
                                <td><c:out value="${itemVenda.valorTotal}" /></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="form-group row">
                    <label for="vendavalor">Valor</label> 
                    <input class="form-control" type="text"
                           name="valor" value="<c:out value="${venda.valor}" />"
                           readonly="readonly" placeholder="Valor" />
                </div>
                <div class="form-group row">
                    <input class="form-control" type="submit" value="Completar Venda" />
                </div>
            </fieldset>
        </form>
    </body>
    <c:import url="./rodape.jsp"/>
</html>