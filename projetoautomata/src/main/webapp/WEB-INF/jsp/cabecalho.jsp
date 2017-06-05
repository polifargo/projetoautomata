<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="">
        <meta name="description" content="">
        <title>Welcome</title>
        <link rel="stylesheet" type="text/css" href="css/listaform.css" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/comportamentos.js"></script>
    </head>
    <body>
        <c:if test="${not empty sessionScope.usuario}">        
            <div id="loginbar">
                <div class="itemLogin">
                    <img id="imgHome" src="resources/home.png">
                    <a href="inicio">Home</a>
                </div>

                <div class="itemLogin">
                    <img id="imgProfile" src="resources/profile.png">
                    ${sessionScope.usuario.nome}
                </div>

                <div class="itemLogin">
                    <img id="imgExit" src="resources/exit.png">
                    <a href="logout">Sair</a>
                </div>
            </div>

            <div id="espacadora">
            </div>

        <header>
            <div class="logos">
                <img id="logo" src="resources/logo.png" height="80">
                <img id="logotipo" src="resources/logotipo.png">
            </div>
        </header>

        <div id="abas">
            <c:choose>
                <c:when test="${sessionScope.usuario.papel == 'BASICO'}">
                    <div class="abasItem cadastro">Consulta</div>
                    <div class="abasItem venda">Venda</div>
                    <div class="abasItem servico">Serviço</div>
                </c:when>
                <c:when test="${sessionScope.usuario.papel == 'MEDIO'}">
                    <div class="abasItem cadastro">Consulta</div>
                    <div class="abasItem servico">Serviço</div>
                    <div class="abasItem estoque">Estoque</div>
                </c:when>
                <c:otherwise>
                    <div class="abasItem venda">Venda</div>
                    <div class="abasItem servico">Serviço</div>
                    <div class="abasItem cadastro">Consulta</div>
                    <div class="abasItem estoque">Estoque</div>
                    <div class="abasItem gerencia">Gerência</div>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="telas">
            <c:choose>
                <c:when test="${sessionScope.usuario.papel == 'BASICO'}">
                    <div class="telasItem cadastro" style="display:none;">
                        <a href="clientes">Clientes</a>
                    </div>
                    <div class="telasItem servico" style="display:none;">
                        <a href="prestacaoservico">Prestação Serviço</a>
                    </div>
                    <div class="telasItem venda" style="display:none;">
                        <a href="venda">Realizar Venda</a>
                    </div>
                </c:when>

                <c:when test="${sessionScope.usuario.papel == 'MEDIO'}">
                    <div class="telasItem cadastro" style="display:none;">
                        <a href="produtos">Produtos</a>
                    </div>
                    <div class="telasItem servico" style="display:none;">
                        <a href="servicos">Serviços</a>
                    </div>
                    <div class="telasItem estoque" style="display:none;">
                        <a href="estoque">Estoque</a>
                    </div>
                </c:when>

                <c:otherwise>
                    <div class="telasItem cadastro" style="display:none;">
                        <a href="clientes">Clientes</a>
                    </div>
                    <div class="telasItem cadastro" style="display:none;">
                        <a href="produtos">Produtos</a>
                    </div>

                    <div class="telasItem servico" style="display:none;">
                        <a href="servicos">Serviços</a>
                    </div>

                    <div class="telasItem servico" style="display:none;">
                        <a href="prestacaoservico">Prestação Serviço</a>
                    </div>

                    <div class="telasItem cadastro" style="display:none;">
                        <a href="unidades">Unidades</a>
                    </div>
                    
                    <div class="telasItem gerencia" style="display:none;">
                        <a href="unidades?action=insert">Unidades</a>
                    </div>
                    
                    <div class="telasItem gerencia" style="display:none;">
                        <a href="servicos?action=insert">Serviços</a>
                    </div>
                    <div class="telasItem gerencia" style="display:none;">
                        <a href="produtos?action=insert">Produtos</a>
                    </div>

                    <div class="telasItem estoque" style="display:none;">
                        <a href="estoque">Saldos</a>
                    </div>

                    <div class="telasItem venda" style="display:none;">
                        <a href="venda">Realizar Venda</a>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</c:if>
</body>
<c:import url="./rodape.jsp"/>
</html>