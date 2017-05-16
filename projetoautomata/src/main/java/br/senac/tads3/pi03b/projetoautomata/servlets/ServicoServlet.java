/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.servlets;

import br.senac.tads3.pi03b.projetoautomata.dao.ServicoDAO;
import br.senac.tads3.pi03b.projetoautomata.models.Servico;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "ServicoServlet", urlPatterns = {"/servicos"})
public class ServicoServlet extends HttpServlet {

    private ServicoDAO dao;
    public static final String LIST = "WEB-INF/jsp/lista_servicos.jsp";
    public static final String INSERT_OR_EDIT = "WEB-INF/jsp/servico_cadastrar.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        dao = new ServicoDAO();
        if ("delete".equalsIgnoreCase(action)) {
            forward = LIST;
            String id = String.valueOf(request.getParameter("id"));
            try {
                dao.excluir(id);
            } catch (Exception ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                request.setAttribute("servicos", dao.getListaServicos());
            } catch (SQLException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("edit".equalsIgnoreCase(action)) {
            forward = INSERT_OR_EDIT;
            String id = request.getParameter("id");
            Servico servico = null;
            try {
                servico = dao.getServicoById(id);
            } catch (SQLException ex) {
                Logger.getLogger(ServicoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServicoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("servico", servico);
        } else if ("insert".equalsIgnoreCase(action)) {
            forward = INSERT_OR_EDIT;
        } else {
            forward = LIST;
            try {
                request.setAttribute("servicos", dao.getListaServicos());
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
        DateFormat mediaConclusao = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat mediaHoras = new SimpleDateFormat("HH:mm");
        
        Servico servico = new Servico();
        
        servico.setId(request.getParameter("id"));
        servico.setDescricao(request.getParameter("descricao"));
        servico.setTipo(request.getParameter("tipo"));
        servico.setValor(Float.parseFloat(request.getParameter("valor")));
        servico.setNotasInternas(request.getParameter("notasInternas"));
        servico.setInativo(Integer.parseInt(request.getParameter("inativo")));
        
        dao = new ServicoDAO();
        
        try{
            dao.acao(servico);
        }catch(Exception ex){
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        try {
            request.setAttribute("servicos", dao.getListaServicos());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.forward(request, response);
    }
}