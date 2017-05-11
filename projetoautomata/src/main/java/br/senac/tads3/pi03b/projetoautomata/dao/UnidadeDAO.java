/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.dao;

import br.senac.tads3.pi03b.projetoautomata.models.Unidade;
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
 * @author matheus_santo
 */
public class UnidadeDAO {

    private Connection connection;

    public void inserir(Unidade unidade)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO unidades (fantasia, razao, uf, cep, cidade, logradouro, bairro, email, telefone, notasInternas, inativo, cadastronacional)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, unidade.getFantasia());
            preparedStatement.setString(2, unidade.getRazao());
            preparedStatement.setString(3, unidade.getUf());
            preparedStatement.setString(4, unidade.getCep());
            preparedStatement.setString(5, unidade.getCidade());
            preparedStatement.setString(6, unidade.getLogradouro());
            preparedStatement.setString(7, unidade.getBairro());
            preparedStatement.setString(8, unidade.getEmail());
            preparedStatement.setString(9, unidade.getTelefone());
            preparedStatement.setString(10, unidade.getNotasInternas());
            preparedStatement.setInt(11, unidade.getInativo());
            preparedStatement.setString(12, unidade.getCadastroNacional());
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

    public void alterar(Unidade unidade)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE unidades SET fantasia=?, razao=?, uf=?, cep=?, cidade=?, logradouro=?, bairro=?, "
                + "email=?, telefone=?, notasinternas=?, inativo=?, cadastroNacional=?"
                + "WHERE id=?";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, unidade.getFantasia());
            preparedStatement.setString(2, unidade.getRazao());
            preparedStatement.setString(3, unidade.getUf());
            preparedStatement.setString(4, unidade.getCep());
            preparedStatement.setString(5, unidade.getCidade());
            preparedStatement.setString(6, unidade.getLogradouro());
            preparedStatement.setString(7, unidade.getBairro());
            preparedStatement.setString(8, unidade.getEmail());
            preparedStatement.setString(9, unidade.getTelefone());
            preparedStatement.setString(10, unidade.getNotasInternas());
            preparedStatement.setInt(11, unidade.getInativo());
            preparedStatement.setString(12, unidade.getCadastroNacional());
            preparedStatement.setInt(13, unidade.getId());
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
        String sql = "DELETE FROM unidades WHERE id=?";
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

    public List<Unidade> getListaUnidades() throws SQLException, ClassNotFoundException {
        List<Unidade> listaUnidades = new ArrayList<>();
        connection = DbUtil.getConnection();
        String query = "SELECT * FROM unidades ORDER BY fantasia";

        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Unidade unidade = new Unidade();
                unidade.setId(resultSet.getInt("id"));
                unidade.setFantasia(resultSet.getString("fantasia"));
                unidade.setRazao(resultSet.getString("razao"));
                unidade.setUf(resultSet.getString("uf"));
                unidade.setCep(resultSet.getString("cep"));
                unidade.setCidade(resultSet.getString("cidade"));
                unidade.setLogradouro(resultSet.getString("logradouro"));
                unidade.setBairro(resultSet.getString("bairro"));
                unidade.setEmail(resultSet.getString("email"));
                unidade.setTelefone(resultSet.getString("telefone"));
                unidade.setNotasInternas(resultSet.getString("notasInternas"));
                unidade.setInativo(Integer.parseInt(resultSet.getString("inativo")));
                unidade.setCadastroNacional(resultSet.getString("cadastronacional"));
                listaUnidades.add(unidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
        return listaUnidades;
    }

    public Unidade getUnidadeById(int id) throws SQLException, ClassNotFoundException {
        Unidade unidade = new Unidade();
        connection = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM unidades WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                unidade.setId(resultSet.getInt("id"));
                unidade.setFantasia(resultSet.getString("fantasia"));
                unidade.setRazao(resultSet.getString("razao"));
                unidade.setUf(resultSet.getString("uf"));
                unidade.setCep(resultSet.getString("cep"));
                unidade.setCidade(resultSet.getString("cidade"));
                unidade.setLogradouro(resultSet.getString("logradouro"));
                unidade.setBairro(resultSet.getString("bairro"));
                unidade.setEmail(resultSet.getString("email"));
                unidade.setTelefone(resultSet.getString("telefone"));
                unidade.setNotasInternas(resultSet.getString("notasInternas"));
                unidade.setInativo(Integer.parseInt(resultSet.getString("inativo")));
                unidade.setCadastroNacional(resultSet.getString("cadastronacional"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return unidade;
    }
}
