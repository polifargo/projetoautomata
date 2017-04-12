/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.servlets;

import br.senac.tads3.pi03b.projetoautomata.models.Cliente;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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
@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cliente c1 = new Cliente(1L, "Fulano da Silva", "Pessoa Física",
                "203.312.231-23", "Rua Zike Tuma", "matheus@kkkk.com", "(11) 91234-5678");

        Cliente c2 = new Cliente(3L, "Fulano da Silva", "Pessoa Física",
                "203.312.231-23", "Rua Zike Tuma", "matheus@kkkk.com", "(11) 91234-5678");

        List<Cliente> clientes = Arrays.asList(c1, c2);

        request.setAttribute("listaClientes", clientes);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("cliente.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException ex) {

        }

    }

}
