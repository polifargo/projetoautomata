<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="css/raiz.css" />
        <link rel="stylesheet" href="css/login.css" />
        <title>Login</title>
    </head>
    <body>
        <form method="post" action="ValidarLogin">
                <div class="principal">
                    <div class="input">
                        <div class="usuario">
                            <input type="text" placeholder="Usuário" maxlength="30"/>
                        </div>

                        <div class="senha">
                            <input type="password" placeholder="Senha"/>
                        </div>
                        
                        <input type="submit" value="Login"/>
                    </div>
                </div>
        </form>
    </body>
</html>