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
        <title>Adicionar Unidade</title>
        <link href="css/listaform.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="panel panel-default">
            <form action="unidades" method="post">
                <fieldset class="form-group">
                    <div class="form-group row">
                        <label for="unidadeid">Unidade ID</label> 
                        <input class="form-control" type="text"
                               name="id" value="<c:out value="${unidade.id}" />"
                               readonly="readonly" placeholder="Unidade ID" />
                    </div>
                    <div class="form-group row">
                        <label for="unidadefantasia">Fantasia</label> 
                        <input class="form-control" type="text"
                               name="fantasia" value="<c:out value="${unidade.fantasia}" />"
                               placeholder="Fantasia" />
                    </div>
                    <div class="form-group row">
                        <label for="unidaderazao">Razao</label> 
                        <input class="form-control" type="text"
                               name="razao" value="<c:out value="${unidade.razao}" />"
                               placeholder="Razao" />
                    </div>
                     <div class="form-group row">
                            <label for="unidadeuf">UF</label> 
                            <select name="uf" class="form-control">
                                <option value="AC">AC</option>
                                <option value="AL">AL</option>
                                <option value="AM">AM</option>
                                <option value="AP">AP</option>
                                <option value="BA">BA</option>
                                <option value="CE">CE</option>
                                <option value="DF">DF</option>
                                <option value="ES">ES</option>
                                <option value="GO">GO</option>
                                <option value="MA">MA</option>
                                <option value="MG">MG</option>
                                <option value="MS">MS</option>
                                <option value="MT">MT</option>
                                <option value="PA">PA</option>
                                <option value="PB">PB</option>
                                <option value="PE">PE</option>
                                <option value="PI">PI</option>
                                <option value="PR">PR</option>
                                <option value="RJ">RJ</option>
                                <option value="RN">RN</option>
                                <option value="RS">RS</option>
                                <option value="RO">RO</option>
                                <option value="RR">RR</option>
                                <option value="SC">SC</option>
                                <option value="SE">SE</option>
                                <option value="SP">SP</option>
                                <option value="TO">TO</option>
                            </select>
                        </div>
                        <div class="form-group row">
                            <label for="unidadecep">CEP</label>
                            <input class="form-control" type="text" 
                                   name="cep" value="<c:out value="${unidade.cep}" />"
                                   placeholder="CEP" id="cep"/>
                        </div>
                        <div class="form-group row">
                            <label for="unidadecidade">Cidade</label>
                            <input class="form-control" type="text" 
                                   name="cidade" value="<c:out value="${unidade.cidade}" />"
                                   placeholder="Cidade" id="cidade"/>
                        </div>
                        <div class="form-group row">
                            <label for="unidadelogradouro">Logradouro</label>
                            <input class="form-control" type="text" 
                                   name="logradouro" value="<c:out value="${unidade.logradouro}" />"
                                   placeholder="Logradouro" id="logradouro"/>
                        </div>
                        <div class="form-group row">
                            <label for="unidadebairro">Bairro</label>
                            <input class="form-control" type="text" 
                                   name="bairro" value="<c:out value="${unidade.bairro}" />"
                                   placeholder="Bairro" id="bairro"/>
                        </div>
                        <div class="form-group row">
                            <label for="unidadeemail">Email</label> 
                            <input class="form-control" type="text"
                                   name="email" value="<c:out value="${unidade.email}" />"
                                   placeholder="Email..." id="email" />
                        </div>
                        <div class="form-group row">
                            <label for="unidadetelefone">Telefone</label> 
                            <input class="form-control" type="text"
                                   name="telefone" value="<c:out value="${unidade.telefone}" />"
                                   placeholder="Telefone" id="telefone"/>
                        </div>   
                        <div class="form-group row">
                            <label for="unidadenotasinternas">Notas Internas</label> 
                            <input class="form-control" type="textarea"
                                   name="notasinternas" value="<c:out value="${unidade.notasInternas}" />"
                                   id="telefone"/>
                        </div> 
                        <div class="form-group row">
                            <label for="unidadeinativo">Inativo</label> 
                            <input class="form-control" type="number"
                                   name="inativo" value="<c:out value="${unidade.inativo}" />"
                                   id="inativo"/>
                        </div> 
                        <div class="form-group row">
                            <label for="unidadecadastronacional">Cadastro Nacional</label>
                            <input class="form-control" type="text" 
                                   name="cadastronacional" value="<c:out value="${unidade.cadastroNacional}" />"
                                   placeholder="CNPJ" />
                        </div>
                    <div class="form-group row">
                        <input class="form-control" type="submit" value="Salvar" />
                    </div>
                    <div class="form-group row">
                        <a class="btn btn-danger form-control" role="button" href="unidades">Cancelar</a>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
    <c:import url="./rodape.jsp"/>
</html>