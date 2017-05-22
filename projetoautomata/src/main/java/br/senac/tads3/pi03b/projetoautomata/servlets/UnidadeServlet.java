/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.servlets;

import br.senac.tads3.pi03b.projetoautomata.dao.UnidadeDAO;
import br.senac.tads3.pi03b.projetoautomata.models.Unidade;
import br.senac.tads3.pi03b.projetoautomata.services.UnidadeService;
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
 * @author mathe
 */
@WebServlet(name = "UnidadeServlet", urlPatterns = {"/unidades"})
public class UnidadeServlet extends HttpServlet {

    private UnidadeService service;
    private UnidadeDAO dao;
    public static final String LIST = "WEB-INF/jsp/lista_unidades.jsp";
    public static final String INSERT_OR_EDIT = "WEB-INF/jsp/unidade_cadastrar.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        dao = new UnidadeDAO();
        if ("delete".equalsIgnoreCase(action)) {
            forward = LIST;
            String id = String.valueOf(request.getParameter("id"));
            try {
                dao.excluir(id);
            } catch (Exception ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                request.setAttribute("unidades", dao.getListaUnidades());
            } catch (SQLException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("edit".equalsIgnoreCase(action)) {
            forward = INSERT_OR_EDIT;
            String id = request.getParameter("id");
            Unidade unidade = null;
            try {
                unidade = dao.getUnidadeById(id);
                request.setAttribute("uf", unidade.getUf());
                request.setAttribute("status", unidade.getInativo());
            } catch (SQLException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("unidade", unidade);
        } else if ("insert".equalsIgnoreCase(action)) {
            forward = INSERT_OR_EDIT;
        } else {
            forward = LIST;
            try {
                request.setAttribute("unidades", dao.getListaUnidades());
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
        Unidade unidade = new Unidade();
        unidade.setId(request.getParameter("id"));
        unidade.setFantasia(request.getParameter("fantasia"));
        unidade.setRazao(request.getParameter("razao"));
        unidade.setUf(request.getParameter("uf"));
        unidade.setCep(request.getParameter("cep"));
        unidade.setCidade(request.getParameter("cidade"));
        unidade.setLogradouro(request.getParameter("logradouro"));
        unidade.setBairro(request.getParameter("bairro"));
        unidade.setEmail(request.getParameter("email"));
        unidade.setTelefone(request.getParameter("telefone"));
        unidade.setNotasInternas(request.getParameter("notasInternas"));
        unidade.setInativo(Integer.parseInt(request.getParameter("inativo")));
        unidade.setCadastroNacional(request.getParameter("cadastroNacional"));
        service = new UnidadeService();
        dao = new UnidadeDAO();
        if (service.validarCampos(unidade)) {
            try {
                dao.acao(unidade);
            } catch (Exception ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        try {
            request.setAttribute("unidades", dao.getListaUnidades());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.forward(request, response);
    }

}
