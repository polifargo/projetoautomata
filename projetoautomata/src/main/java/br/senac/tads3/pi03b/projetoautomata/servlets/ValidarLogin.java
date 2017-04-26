/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.servlets;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/login")
public class ValidarLogin extends HttpServlet {

    private static final Map<String, String> USUARIOS_CADASTRADOS;

    static {
        USUARIOS_CADASTRADOS = new LinkedHashMap<>();
        USUARIOS_CADASTRADOS.put("madruga", "pagueoaluguel");
        USUARIOS_CADASTRADOS.put("bozo", "abcd1234");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("login");
        String senhaDigitada = request.getParameter("senha");

        String senhaCadastrada = USUARIOS_CADASTRADOS.get(usuario);
        if (senhaCadastrada != null && senhaCadastrada.equals(senhaDigitada)) {
            HttpSession sessao = request.getSession(false);
            if (sessao != null) {
                sessao.invalidate();
            }
            sessao = request.getSession(true);
            sessao.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/erroLogin.jsp");
        }

    }
}
