/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.dao;

import br.senac.tads3.pi03b.projetoautomata.models.Cliente;
import br.senac.tads3.pi03b.projetoautomata.utils.DbUtil;
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

    private Connection connection;

    public void inserir(Cliente cliente)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO clientes (nome, apelido, sexo, tipo, uf, cep, cidade, logradouro, bairro, email, telefone, notasInternas, inativo, cadastronacional)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getApelido());
            preparedStatement.setString(3, cliente.getSexo());
            preparedStatement.setString(4, cliente.getTipo());
            preparedStatement.setString(5, cliente.getUf());
            preparedStatement.setString(6, cliente.getCep());
            preparedStatement.setString(7, cliente.getCidade());
            preparedStatement.setString(8, cliente.getLogradouro());
            preparedStatement.setString(9, cliente.getBairro());
            preparedStatement.setString(10, cliente.getEmail());
            preparedStatement.setString(11, cliente.getTelefone());
            preparedStatement.setString(12, cliente.getNotasInternas());
            preparedStatement.setInt(13, cliente.getInativo());
            preparedStatement.setString(14, cliente.getCadastroNacional());

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
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE clientes SET nome=?, apelido=?, sexo=?,"
                + "tipo=?, uf=?, cep=?, cidade=?, logradouro=?, "
                + "bairro=?, email=?, telefone=?, notasInternas=?, inativo=?, cadastronacional=?"
                + "WHERE id=?";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getApelido());
            preparedStatement.setString(3, cliente.getSexo());
            preparedStatement.setString(4, cliente.getTipo());
            preparedStatement.setString(5, cliente.getUf());
            preparedStatement.setString(6, cliente.getCep());
            preparedStatement.setString(7, cliente.getCidade());
            preparedStatement.setString(8, cliente.getLogradouro());
            preparedStatement.setString(9, cliente.getBairro());
            preparedStatement.setString(10, cliente.getEmail());
            preparedStatement.setString(11, cliente.getTelefone());
            preparedStatement.setString(12, cliente.getNotasInternas());
            preparedStatement.setInt(13, cliente.getInativo());
            preparedStatement.setString(14, cliente.getCadastroNacional());
            preparedStatement.setInt(15, cliente.getId());
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
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE clientes SET inativo=0 WHERE id=?";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
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

    public List<Cliente> getListaClientes() throws SQLException, ClassNotFoundException {
        List<Cliente> listaClientes = new ArrayList<>();
        connection = DbUtil.getConnection();
        String query = "SELECT * FROM clientes WHERE inativo=1 ORDER BY nome";

        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setApelido(resultSet.getString("apelido"));
                cliente.setSexo(resultSet.getString("sexo"));
                cliente.setTipo(resultSet.getString("tipo"));
                cliente.setUf(resultSet.getString("uf"));
                cliente.setCep(resultSet.getString("cep"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setLogradouro(resultSet.getString("logradouro"));
                cliente.setBairro(resultSet.getString("bairro"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setNotasInternas(resultSet.getString("notasInternas"));
                cliente.setInativo(Integer.parseInt(resultSet.getString("inativo")));
                cliente.setCadastroNacional(resultSet.getString("cadastronacional"));
                listaClientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
        return listaClientes;
    }

    public Cliente getClienteById(int id) throws SQLException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        connection = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM clientes WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setApelido(resultSet.getString("apelido"));
                cliente.setSexo(resultSet.getString("sexo"));
                cliente.setTipo(resultSet.getString("tipo"));
                cliente.setUf(resultSet.getString("uf"));
                cliente.setCep(resultSet.getString("cep"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setLogradouro(resultSet.getString("logradouro"));
                cliente.setBairro(resultSet.getString("bairro"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setNotasInternas(resultSet.getString("notasInternas"));
                cliente.setInativo(Integer.parseInt(resultSet.getString("inativo")));
                cliente.setCadastroNacional(resultSet.getString("cadastronacional"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return cliente;
    }
}
