/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.servlets;

import br.senac.tads3.pi03b.projetoautomata.dao.ClienteDAO;
import br.senac.tads3.pi03b.projetoautomata.dao.ProdutoDAO;
import br.senac.tads3.pi03b.projetoautomata.dao.UnidadeDAO;
import br.senac.tads3.pi03b.projetoautomata.dao.VendaDAO;
import br.senac.tads3.pi03b.projetoautomata.models.ItemVenda;
import br.senac.tads3.pi03b.projetoautomata.models.Venda;
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
 * @author Andrey
 */
@WebServlet(name = "ListaVendaServlet", urlPatterns = {"/listavenda"})
public class ListaVendaServlet extends HttpServlet {

    private ProdutoDAO daoProdutos;
    private ClienteDAO daoClientes;
    private UnidadeDAO daoUnidades;
    private VendaDAO daoVenda;
    public static final String LIST = "WEB-INF/jsp/lista_venda.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        daoVenda = new VendaDAO();
        try {
            request.setAttribute("venda", daoVenda.getListaVenda());
        } catch (SQLException ex) {
            Logger.getLogger(ListaVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher(LIST);
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Venda venda = new Venda();
        ItemVenda item = new ItemVenda();
        venda.setIdCliente(Integer.parseInt(request.getParameter("cliente")));
        venda.setTecnico(request.getParameter("tecnico"));
        venda.setUnidade(request.getParameter("unidade"));
        venda.setFormaPagamento(request.getParameter("formapagamento"));
        venda.setData(request.getParameter("data"));
        venda.setNotasInternas(request.getParameter("notasInternas"));

        daoVenda = new VendaDAO();
        String id = request.getParameter("id");
        try {
            daoVenda.inserirVenda(venda);
        } catch (Exception ex) {
            Logger.getLogger(ListaVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        view.forward(request, response);
    }
}
