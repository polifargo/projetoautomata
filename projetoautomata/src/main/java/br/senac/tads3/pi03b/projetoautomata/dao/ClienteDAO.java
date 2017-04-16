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
import java.util.List;

/**
 *
 * @author mathe
 */
public class ClienteDAO {

    public void inserir(Cliente cliente)
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
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getTipo());
            preparedStatement.setString(3, cliente.getCadastroNacional());
            preparedStatement.setString(4, cliente.getEndereco());
            preparedStatement.setString(5, cliente.getEmail());
            preparedStatement.setString(6, cliente.getTelefone());

            //Executa o comando no banco de dados
            preparedStatement.executeUpdate();
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

    public void alterar(Cliente cliente)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE clientes SET (nome, tipo, cadastronacional, endereco, email, telefone) VALUES (?, ?, ?, ?, ?, ?) WHERE id=?";
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
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getTipo());
            preparedStatement.setString(3, cliente.getCadastroNacional());
            preparedStatement.setString(4, cliente.getEndereco());
            preparedStatement.setString(5, cliente.getEmail());
            preparedStatement.setString(6, cliente.getTelefone());
            preparedStatement.setInt(7, cliente.getId());
            //Executa o comando no banco de dados
            preparedStatement.executeUpdate();
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

    public void excluir(int id)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "DELETE FROM clientes WHERE id=?";
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
            preparedStatement.setInt(1, id);
            //Executa o comando no banco de dados
            preparedStatement.executeUpdate();
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

    public List<Cliente> getListaClientes() {
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        Connection connection = null;
        connection = ConnectionUtils.getConnection();

        String query = "SELECT * FROM clientes ORDER BY nome";
        Statement st;
        ResultSet resultSet;

        try {
            st = connection.createStatement();
            resultSet = st.executeQuery(query);
            Cliente cliente;
            while (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setTipo(resultSet.getString("tipo"));
                cliente.setCadastroNacional(resultSet.getString("cadastronacional"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setTelefone(resultSet.getString("telefone"));
                listaClientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    public Cliente getClienteById(int id) {
        Cliente cliente = new Cliente();
        Connection connection = null;
        connection = ConnectionUtils.getConnection();
        try {
            String query = "SELECT * FROM clientes WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setTipo(resultSet.getString("tipo"));
                cliente.setCadastroNacional(resultSet.getString("cadastronacional"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setTelefone(resultSet.getString("telefone"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
