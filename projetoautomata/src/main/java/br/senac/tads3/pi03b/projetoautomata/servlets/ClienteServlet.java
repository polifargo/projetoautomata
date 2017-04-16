/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.servlets;

import br.senac.tads3.pi03b.projetoautomata.dao.ClienteDAO;
import br.senac.tads3.pi03b.projetoautomata.models.Cliente;
import java.io.IOException;
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
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {

    private final ClienteDAO dao;
    public static final String LISTA_CLIENTE = "/listaclientes.jsp";
    public static final String INSERT_OR_EDIT = "/cadastroclientes.jsp";

    public ClienteServlet() {
        dao = new ClienteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            forward = LISTA_CLIENTE;
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                dao.excluir(id);
            } catch (Exception ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("clientes", dao.getListaClientes());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Cliente cliente = dao.getClienteById(id);
            request.setAttribute("cliente", cliente);
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        } else {
            forward = LISTA_CLIENTE;
            request.setAttribute("clientes", dao.getListaClientes());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente cliente = new Cliente();
        cliente.setNome(request.getParameter("nome"));
        cliente.setTipo(request.getParameter("tipo"));
        cliente.setCadastroNacional(request.getParameter("cadastronacional"));
        cliente.setEndereco(request.getParameter("endereco"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefone(request.getParameter("telefone"));
        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {
            try {
                dao.inserir(cliente);
            } catch (Exception ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            cliente.setId(Integer.parseInt(id));
            try {
                dao.alterar(cliente);
            } catch (Exception ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_CLIENTE);
        request.setAttribute("clientes", dao.getListaClientes());
        view.forward(request, response);
    }

}
