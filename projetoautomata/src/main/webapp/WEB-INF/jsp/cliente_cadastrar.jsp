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
        <title>Adicionar Cliente</title>
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
        <form name="form" id="form" action="clientes" method="post">
            <fieldset class="form-group container-fluid">
                <div class="form-group row">
                    <input class="form-control" type="hidden"
                           name="id" value="<c:out value="${cliente.id}" />"
                           readonly="readonly" placeholder="Cliente ID"/>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="clientenome">Nome</label> 
                        <input class="form-control" type="text"
                               name="nome" value="<c:out value="${cliente.nome}" />"
                               placeholder="Nome..." maxlength="120" id="nome" required/>
                    </div>
                    <div class="col-sm-4">
                        <label for="clienteapelido">Apelido</label> 
                        <input class="form-control" type="text"
                               name="apelido" value="<c:out value="${cliente.apelido}" />"
                               placeholder="Apelido..." maxlength="60" id="apelido" required/>
                    </div>
                    <div class="col-sm-2">
                        <label for="clientesexo">Sexo</label> 
                        <select name="sexo" class="form-control">
                            <option selected value="masculino">Masculino</option>
                            <option value="feminino">Feminino</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">

                    <div class="col-sm-4">
                        <label for="clientetipo">Tipo</label> 
                        <select name="tipo" class="form-control">
                            <option value="F">Pessoa Física</option>
                            <option value="J">Pessoa Jurídica</option>
                        </select>
                    </div>
                    <div class="col-sm-4">
                        <label for="clientecadastronacional">Cadastro Nacional</label>
                        <input class="form-control" type="text" id="cadastroNacional" 
                               name="cadastroNacional" value="<c:out value="${cliente.cadastroNacional}" />"
                               placeholder="CPF/CNPJ..." maxlength="18" required/>
                    </div>
                    <div class="col-sm-4">
                        <label for="clienteinativo">Status</label> 
                        <select name="inativo" class="form-control">
                            <option selected value="1">Ativo</option>
                            <option value="0">Inativo</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2">
                        <label for="clienteuf">UF</label> 
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
                    <div class="col-sm-2">
                        <label for="clientecep">CEP</label>
                        <input class="form-control" type="text" 
                               name="cep" value="<c:out value="${cliente.cep}" />"
                               placeholder="CEP..." maxlength="9" id="cep" required/>
                    </div>
                    <div class="col-sm-3">
                        <label for="clientecidade">Cidade</label>
                        <input class="form-control" type="text" 
                               name="cidade" value="<c:out value="${cliente.cidade}" />"
                               placeholder="Cidade..." maxlength="60" id="cidade" required/>
                    </div>
                    <div class="col-sm-5">
                        <label for="clientelogradouro">Logradouro</label>
                        <input class="form-control" type="text" 
                               name="logradouro" value="<c:out value="${cliente.logradouro}" />"
                               placeholder="Logradouro..." maxlength="60" id="logradouro" required/>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-4">
                        <label for="clientebairro">Bairro</label>
                        <input class="form-control" type="text" 
                               name="bairro" value="<c:out value="${cliente.bairro}" />"
                               placeholder="Bairro..." maxlength="60" id="bairro" required/>
                    </div>
                    <div class="col-sm-4">
                        <label for="clienteemail">Email</label> 
                        <input class="form-control" type="email"
                               name="email" value="<c:out value="${cliente.email}" />"
                               placeholder="Email..." maxlength="80" id="email" required/>
                    </div>
                    <div class="col-sm-4">
                        <label for="clientetelefone">Telefone</label> 
                        <input class="form-control" type="text"
                               name="telefone" value="<c:out value="${cliente.telefone}" />"
                               placeholder="Telefone..." maxlength="14" id="telefone" required/>
                    </div>
                </div>   
                <div class="form-group row">
                    <div class="col-sm-8">
                        <label for="clientenotasinternas">Notas Internas</label> 
                        <input class="form-control" type="textarea"
                               name="notasinternas" maxlength="1000" placeholder="Notas Internas..." value="<c:out value="${cliente.notasInternas}" />"
                               id="telefone" id="notasinternas" required/>
                    </div>
                    <div class="col-lg-2">
                        <input class="form-control" type="submit" id="submit" value="Salvar" />
                    </div>
                    <div class="col-lg-2">
                        <a class="btn btn-danger form-control" role="button" href="clientes">Cancelar</a>
                    </div>
                </div>
            </fieldset>
        </form>
        <c:import url="./rodape.jsp"/>
    </body>
</html>