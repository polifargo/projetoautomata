/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.servlets;

import br.senac.tads3.pi03b.projetoautomata.dao.ProdutoDAO;
import br.senac.tads3.pi03b.projetoautomata.models.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstoqueServlet", urlPatterns = {"/estoque"})
public class EstoqueServlet extends HttpServlet {

    private ProdutoDAO dao;
    public static final String LIST = "WEB-INF/jsp/estoque.jsp";
    public static final String INSERT_OR_EDIT = "WEB-INF/jsp/estoque_alterar.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        dao = new ProdutoDAO();
        if ("edit".equalsIgnoreCase(action)) {
            forward = INSERT_OR_EDIT;
            String id = request.getParameter("id");
            Produto produto = null;
            try {
                produto = dao.getProdutoById(id);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("produto", produto);
        } else {
            forward = LIST;
            try {
                request.setAttribute("produtos", dao.getListaProdutos());
            } catch (SQLException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Produto produto = new Produto();
        produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        produto.setId(request.getParameter("id"));
        dao = new ProdutoDAO();

        try {
            dao.alterarQuantidade(produto);
        } catch (Exception ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST);
        try {
            request.setAttribute("produtos", dao.getListaProdutos());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.forward(request, response);
    }
}
