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
import java.util.ArrayList;
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
 * @author mathe
 */
@WebServlet(name = "VendaServlet", urlPatterns = {"/venda"})
public class VendaServlet extends HttpServlet {

    private ProdutoDAO daoProdutos;
    private ClienteDAO daoClientes;
    private UnidadeDAO daoUnidades;
    private VendaDAO daoVenda;
    public static final String LIST = "WEB-INF/jsp/realizar_venda.jsp";
    public static final String HOME = "inicio";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        daoProdutos = new ProdutoDAO();
        daoClientes = new ClienteDAO();
        daoUnidades = new UnidadeDAO();
        
        Venda venda = new Venda();
        
        try {
            request.setAttribute("clientes", daoClientes.getListaClientes());
            request.setAttribute("produtos", daoProdutos.getListaProdutos());
            request.setAttribute("unidades", daoUnidades.getListaUnidades());
            request.setAttribute("venda", venda);
        } catch (SQLException ex) {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        
        String[] idProduto = request.getParameterValues("idProduto");
        String[] prodqt = request.getParameterValues("prodqt");
        String[] valorVenda = request.getParameterValues("valorVenda");
        String[] valorTotal = request.getParameterValues("valorTotal");
        
        for (int i = 0; i < idProduto.length; i++) {
            item = new ItemVenda();
            
            item.setIdProduto(idProduto[i]);
            item.setQtVendida(Integer.parseInt(prodqt[i]));
            item.setValorUnitario(Double.parseDouble(valorVenda[i]));
            item.setValorTotal(Double.parseDouble(valorTotal[i]));
            
            venda.setItem(item);
        }
        
        daoVenda = new VendaDAO();
        String id = request.getParameter("id");
        try {
            daoVenda.inserirVenda(venda);
        } catch (Exception ex) {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(HOME);
        view.forward(request, response);
    }
}