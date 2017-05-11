<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
        <meta name="author" content=""></meta>
        <meta name="description" content=""></meta>
        <title>Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="css/estilos.css" rel="stylesheet" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="https://use.typekit.net/ayg4pcz.js"></script>
        <script>try {
                Typekit.load({async: true});
            } catch (e) {
            }</script>
    </head>
    <body>
        <div class="container">
            <h1 class="welcome text-center">Bem Vindo </h1>
            <div class="card card-container">
                <h2 class='login_title text-center'>Login</h2>
                <hr>

                    <form class="form-signin" action="login" method="post">
                        <span id="reauth-email" class="reauth-email"></span>
                        <p class="input_title">Login</p>
                        <input type="text" name="login" id="inputEmail" class="login_box" required autofocus/>
                        <p class="input_title">Senha</p>
                        <input type="password" name="senha" id="inputPassword" class="login_box" required/>
                        <div id="remember" class="checkbox">
                            <label>

                            </label>
                        </div>
                        <button class="btn btn-lg btn-primary" type="submit">Login</button>
                    </form><!-- /form -->
            </div><!-- /card-container -->
        </div><!-- /container -->
        <c:import url="./rodape.jsp"/>
    </body>
</html>
