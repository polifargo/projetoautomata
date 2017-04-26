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
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Por favor se logue</h3>
                        </div>
                        <div class="panel-body">
                            <form accept-charset="UTF-8" role="form" method="post" action="login">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="Usuário" maxlength="30" name="login"/>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" type="password" placeholder="Senha" name="senha"/>
                                    </div>
                                    <input class="btn btn-lg btn-success btn-block" type="submit" value="Login"/>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
