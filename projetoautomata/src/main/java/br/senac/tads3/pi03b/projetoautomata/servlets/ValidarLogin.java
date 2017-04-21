/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.servlets;

import br.senac.tads3.pi03b.projetoautomata.dao.UsuarioDAO;
import br.senac.tads3.pi03b.projetoautomata.models.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mathe
 */
@WebServlet("/ValidarLogin")
public class ValidarLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(); //obtem a sessao do usuario, caso exista

        Usuario usuario = null;
        String login_form = request.getParameter("login"); // Pega o Login vindo do formulario
        String senha_form = request.getParameter("senha"); //Pega a senha vinda do formulario

        try {
            UsuarioDAO dao = new UsuarioDAO(); //cria uma instancia do DAO usuario
            usuario = dao.getUsuario(login_form, senha_form);
        } catch (ClassNotFoundException | SQLException e) {

        }

        //se nao encontrou usuario no banco, redireciona para a pagina de erro!
        if (usuario == null) {
            session.invalidate();
            request.getRequestDispatcher("erroLogin.jsp").forward(request, response);
        } else {
            //se o dao retornar um usuario, coloca o mesmo na sessao
            session.setAttribute("usuario", usuario);
            request.getRequestDispatcher("logado.jsp").forward(request, response);
        }

    }
}
