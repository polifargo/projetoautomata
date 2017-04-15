/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.dao;

import br.senac.tads3.pi03b.projetoautomata.models.Cliente;
import br.senac.tads3.pi03b.projetoautomata.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class ClienteDAO {

    public static void inserir(String nomeCliente, String tipo,
            String cadastroNacional, String endereco, String email, String telefone)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO clientes (nome, tipo, cadastronacional, endereco, email, telefone) VALUES (?, ?, ?, ?, ?, ?)";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, nomeCliente);
            preparedStatement.setString(2, tipo);
            preparedStatement.setString(3, cadastroNacional);
            preparedStatement.setString(4, endereco);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, telefone);

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static ArrayList<Cliente> getListaClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        Connection connection = null;
        connection = ConnectionUtils.getConnection();

        String query = "SELECT * FROM clientes ORDER BY nome";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Cliente cliente;
            while (rs.next()) {
                cliente = new Cliente(rs.getLong("id"), rs.getString("nome"), rs.getString("tipo"),
                        rs.getString("cadastronacional"), rs.getString("endereco"), rs.getString("email"), rs.getString("telefone"));
                listaClientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }
}
