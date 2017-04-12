<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrada</title>
    </head>
    <body>
        <div class="cliente">
            <h1>Cadastrar Cliente</h1>
            <div class="formulario">
                <form action="cadastroclientes" method="post">
                    <div>
                        <label for="txtnome">Nome</label>
                        <input type="text" name="nome" id="txtnome" />
                    </div>
                    <div>
                        <label for="txtemail">Tipo</label>
                        <input type="text" name="email" id="txttipo" />
                    </div>
                    <div>
                        <label for="txtcn">CadastroNacional</label>
                        <input type="text" name="cn" id="txtcn" />
                    </div>
                    <div>
                        <label for="txtendereco">Endereço</label>
                        <input type="text" name="endereco" id="txtendereco" />
                    </div>
                    <div>
                        <label for="txtemail">Email</label>
                        <input type="text" name="email" id="txtemail" />
                    </div>
                    <div>
                        <label for="txttelefone">Telefone</label>
                        <input type="text" name="telefone" id="txttelefone" />
                    </div>
                    <div>
                        <input type="submit" value="Salvar" />
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>