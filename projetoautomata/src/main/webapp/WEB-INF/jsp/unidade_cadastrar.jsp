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
        <title>Adicionar Unidade</title>
        <link href="css/listaform.css" rel="stylesheet" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.maskedinput.js"></script>
        <script src="js/validacoes.js"></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <form action="unidades" method="post">
            <fieldset class="form-group container-fluid">
                <div class="form-group row">
                    <div class="col-sm-2">
                        <label for="unidadeid">Unidade ID</label> 
                        <input class="form-control" type="text" maxlength="3"
                               name="id" value="<c:out value="${unidade.id}" />"
                               placeholder="Unidade ID" required />
                    </div>
                    <div class="col-sm-4">
                        <label for="unidadefantasia">Fantasia</label> 
                        <input class="form-control" type="text"
                               name="fantasia" value="<c:out value="${unidade.fantasia}" />"
                               placeholder="Fantasia..." maxlength="30" required/>
                    </div>
                    <div class="col-sm-6">
                        <label for="unidaderazao">Razao</label> 
                        <input class="form-control" type="text"
                               name="razao" value="<c:out value="${unidade.razao}" />"
                               placeholder="Razao..." required/>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2">
                        <label for="unidadeuf">UF</label> 
                        <select name="uf" class="form-control">
                            <option value="AC" ${uf == 'AC' ? 'selected' : ''}>AC</option>
                            <option value="AL" ${uf == 'AL' ? 'selected' : ''}>AL</option>
                            <option value="AM" ${uf == 'AM' ? 'selected' : ''}>AM</option>
                            <option value="AP" ${uf == 'AP' ? 'selected' : ''}>AP</option>
                            <option value="BA" ${uf == 'BA' ? 'selected' : ''}>BA</option>
                            <option value="CE" ${uf == 'CE' ? 'selected' : ''}>CE</option>
                            <option value="DF" ${uf == 'DF' ? 'selected' : ''}>DF</option>
                            <option value="ES" ${uf == 'ES' ? 'selected' : ''}>ES</option>
                            <option value="GO" ${uf == 'GO' ? 'selected' : ''}>GO</option>
                            <option value="MA" ${uf == 'MA' ? 'selected' : ''}>MA</option>
                            <option value="MG" ${uf == 'MG' ? 'selected' : ''}>MG</option>
                            <option value="MS" ${uf == 'MS' ? 'selected' : ''}>MS</option>
                            <option value="MT" ${uf == 'MT' ? 'selected' : ''}>MT</option>
                            <option value="PA" ${uf == 'PA' ? 'selected' : ''}>PA</option>
                            <option value="PB" ${uf == 'PB' ? 'selected' : ''}>PB</option>
                            <option value="PE" ${uf == 'PE' ? 'selected' : ''}>PE</option>
                            <option value="PI" ${uf == 'PI' ? 'selected' : ''}>PI</option>
                            <option value="PR" ${uf == 'PR' ? 'selected' : ''}>PR</option>
                            <option value="RJ" ${uf == 'RJ' ? 'selected' : ''}>RJ</option>
                            <option value="RN" ${uf == 'RN' ? 'selected' : ''}>RN</option>
                            <option value="RS" ${uf == 'RS' ? 'selected' : ''}>RS</option>
                            <option value="RO" ${uf == 'RO' ? 'selected' : ''}>RO</option>
                            <option value="RR" ${uf == 'RR' ? 'selected' : ''}>RR</option>
                            <option value="SC" ${uf == 'SC' ? 'selected' : ''}>SC</option>
                            <option value="SE" ${uf == 'SE' ? 'selected' : ''}>SE</option>
                            <option value="SP" ${uf == 'SP' ? 'selected' : ''}>SP</option>
                            <option value="TO" ${uf == 'TO' ? 'selected' : ''}>TO</option>
                        </select>
                    </div>
                    <div class="col-sm-2">
                        <label for="unidadecep">CEP</label>
                        <input class="form-control" type="text" 
                               name="cep" value="<c:out value="${unidade.cep}" />"
                               placeholder="CEP..." maxlength="8" id="cep" required/>
                    </div>
                    <div class="col-sm-3">
                        <label for="unidadecidade">Cidade</label>
                        <input class="form-control" type="text" 
                               name="cidade" value="<c:out value="${unidade.cidade}" />"
                               placeholder="Cidade..." maxlength="60" id="cidade" required/>
                    </div>
                    <div class="col-sm-5">
                        <label for="unidadelogradouro">Logradouro</label>
                        <input class="form-control" type="text" 
                               name="logradouro" value="<c:out value="${unidade.logradouro}" />"
                               placeholder="Logradouro..." maxlength="60" id="logradouro" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-4">
                        <label for="unidadebairro">Bairro</label>
                        <input class="form-control" type="text" 
                               name="bairro" value="<c:out value="${unidade.bairro}" />"
                               placeholder="Bairro..." maxlength="60" id="bairro" required/>
                    </div>
                    <div class="col-sm-3">
                        <label for="unidadeemail">Email</label> 
                        <input class="form-control" type="email"
                               name="email" value="<c:out value="${unidade.email}" />"
                               placeholder="Email..." maxlength="80" id="email" required/>
                    </div>
                    <div class="col-sm-3">
                        <label for="unidadetelefone">Telefone</label> 
                        <input class="form-control" type="text"
                               name="telefone" value="<c:out value="${unidade.telefone}" />"
                               placeholder="Telefone..." maxlength="14" id="telefone" required/>
                    </div>
                    <div class="col-sm-2">
                        <label for="unidadeinativo">Status</label> 
                        <select name="inativo" class="form-control">
                            <option value="1" ${status == '1' ? 'selected' : ''}>Ativo</option>
                            <option value="0" ${status == '0' ? 'selected' : ''}>Inativo</option>
                        </select>
                    </div>
                </div>   
                <div class="form-group row">
                    <div class="col-sm-5">
                        <label for="unidadenotasinternas">Notas Internas</label> 
                        <input class="form-control" type="textarea"
                               name="notasInternas" maxlength="1000" placeholder="Notas Internas..." value="<c:out value="${unidade.notasInternas}" />"
                               id="notasInternas" required/>
                    </div>
                    <div class="col-sm-3">
                        <label for="unidadecadastronacional">Cadastro Nacional</label>
                        <input class="form-control" type="text" id="cnpj"
                               name="cadastroNacional" value="<c:out value="${unidade.cadastroNacional}" />"
                               placeholder="CNPJ..." maxlength="18" required/>
                    </div>
                    <div class="col-sm-2">
                        <input class="form-control" type="submit" value="Salvar" />
                    </div>
                    <div class="col-sm-2">
                        <a class="btn btn-danger form-control" role="button" href="unidades">Cancelar</a>
                    </div>
                </div>
            </fieldset>
        </form>
    </body>
    <c:import url="./rodape.jsp"/>
</html>