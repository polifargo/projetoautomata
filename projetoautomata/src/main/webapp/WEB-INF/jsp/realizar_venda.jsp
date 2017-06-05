<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <script src="js/jquery.maskedinput.js"></script>
        <script src="js/validacoes.js"></script>
        <script src="js/venda.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <form action="venda" method="post">
            <fieldset class="form-group">
                <div class="form-group row">
                    <input class="form-control" type="hidden"
                           name="id" value="<c:out value="${venda.Id}" />"
                           readonly="readonly"  placeholder="Venda ID" />
                </div>
                <div class="form-group row">
                    <div class="col-sm-4">
                        <label for="vendacliente">Cliente</label> 
                        <select name="cliente" required class="form-control">
                            <c:forEach var="cliente" items="${clientes}">
                                <option value="${cliente.id}">${cliente.id} - ${cliente.apelido}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-sm-4">
                        <label for="vendatecnico">Tecnico</label> 
                        <select name="tecnico" class="form-control">
                            <option value="none">Sem Tecnico</option>
                            <option value="Carlos">Carlos</option>
                            <option value="Vitor">Vitor</option>
                            <option value="Renato">Renato</option>
                        </select>
                    </div>
                    <div class="col-sm-4">
                        <label for="vendaunidade">Unidade</label> 
                        <select name="unidade" required class="form-control">
                            <c:forEach var="unidade" items="${unidades}">
                                <option value="${unidade.fantasia}">${unidade.fantasia}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2">
                        <label for="vendaproduto">Produtos</label>
                        <select id="produto" name="produto" required class="form-control">
                            <option value="" selected="selected">Selecione um produto...</option>
                            <c:forEach var="produto" items="${produtos}">
                                <option value="${produto.id} + ${produto.valorVenda}">${produto.modelo}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-sm-2">
                        <label for="vendavalorunitario">Valor Unitario</label>
                        <input type="text" readonly class="form-control" id="valorUnitario">
                    </div>
                    <div class="col-sm-1">
                        <label for="vendaquantidade">Quantidade</label>
                        <input min='1' class="form-control" type="number" id="quantidadeVenda" name="quantidade"/>
                    </div>
                    <div class="col-sm-2">
                        <label for="vendaadicionar">Insira no carrinho</label>
                        <a role="button" id="adicionar" class="btn btn-primary">Adicionar</a>
                    </div>
                    <div class="col-sm-5">
                        <label for="vendacarrinho">Carrinho</label> 
                        <table id="table" class="table">
                            <tr>
                                <th>Produto ID</th>
                                <th>Quantidade</th>
                                <th>Valor Unitario</th>
                                <th class="valorTotal">Valor Total</th>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-4">
                        <label for="vendadata">Data</label> 
                        <input class="form-control" type="date"
                               name="data" placeholder="Data..." />
                    </div>
                    <div class="col-sm-4">
                        <label for="vendaformapagamento">Forma de Pagamento</label> 
                        <select name="formapagamento" class="form-control">
                            <option value="Dinheiro">Dinheiro</option>
                            <option value="Cartao de Credito">Cartao de Credito</option>
                            <option value="Cartao de Debito">Cartao de Debito</option>
                            <option value="Cheque">Cheque</option>
                        </select>
                    </div>
                    <div class="col-sm-4">
                        <label for="vendavalor">Valor</label> 
                        <input class="form-control" type="text" id="valorFinal"
                               name="valor" value="<c:out value="${venda.valor}" />"
                               readonly="readonly" placeholder="Valor" />
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10">
                        <label for="vendanotasinternas">Notas Internas</label> 
                        <input class="form-control" type="textarea"
                               name="notasInternas" placeholder="Notas Internas..." maxlength="1000" />
                    </div>
                    <div class="col-sm-2">
                        <input class="form-control text-center" type="submit" value="Completar Venda" />
                    </div>
                </div>
            </fieldset>
        </form>
    </body>
    <c:import url="./rodape.jsp"/>
</html>