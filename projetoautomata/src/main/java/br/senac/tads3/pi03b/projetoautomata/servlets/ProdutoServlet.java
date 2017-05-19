/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.servlets;

import br.senac.tads3.pi03b.projetoautomata.dao.ProdutoDAO;
import br.senac.tads3.pi03b.projetoautomata.dao.UnidadeDAO;
import br.senac.tads3.pi03b.projetoautomata.models.Produto;
import br.senac.tads3.pi03b.projetoautomata.services.ProdutoService;
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

/**
 *
 * @author matheus_santo
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/produtos"})
public class ProdutoServlet extends HttpServlet {

    private ProdutoService service;
    private ProdutoDAO dao;
    private UnidadeDAO daoU;
    public static final String LIST = "WEB-INF/jsp/lista_produtos.jsp";
    public static final String INSERT_OR_EDIT = "WEB-INF/jsp/produto_cadastrar.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        dao = new ProdutoDAO();
        daoU = new UnidadeDAO();
        try {
            request.setAttribute("listaUnidades", daoU.getListaUnidades());
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ("delete".equalsIgnoreCase(action)) {
            forward = LIST;
            String id = String.valueOf(request.getParameter("id"));
            try {
                dao.excluir(id);
            } catch (Exception ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                request.setAttribute("produtos", dao.getListaProdutos());
            } catch (SQLException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("edit".equalsIgnoreCase(action)) {
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
        } else if ("insert".equalsIgnoreCase(action)) {
            forward = INSERT_OR_EDIT;
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
        produto.setId(request.getParameter("id"));
        produto.setModelo(request.getParameter("modelo"));
        produto.setUnidade(request.getParameter("unidade"));
        produto.setValorCusto(Float.parseFloat(request.getParameter("valorCusto")));
        produto.setValorVenda(Float.parseFloat(request.getParameter("valorVenda")));
        produto.setNotasInternas(request.getParameter("notasInternas"));
        produto.setInativo(Integer.parseInt(request.getParameter("inativo")));
        service = new ProdutoService();
        if (service.validarCampos(produto)) {
            dao = new ProdutoDAO();
            try {
                dao.acao(produto);
            } catch (Exception ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
