/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.dao;

import br.senac.tads3.pi03b.projetoautomata.models.Produto;
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
 * @author matheus.esanto1
 */
public class ProdutoDAO {

    private Connection connection;

    public void inserir(Produto produto)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO produtos (modelo, qtminima, qtmaxima, unidade, tipo, valor)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, produto.getModelo());
            preparedStatement.setInt(2, produto.getQtminima());
            preparedStatement.setInt(3, produto.getQtmaxima());
            preparedStatement.setString(4, produto.getUnidade());
            preparedStatement.setString(5, produto.getTipo());
            preparedStatement.setFloat(6, produto.getValor());

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

    public void alterar(Produto produto)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE produtos SET modelo=?, qtminima=?, qtmaxima=?, unidade=?, tipo=?, valor=?"
                + "WHERE id=?";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, produto.getModelo());
            preparedStatement.setInt(2, produto.getQtminima());
            preparedStatement.setInt(3, produto.getQtmaxima());
            preparedStatement.setString(4, produto.getUnidade());
            preparedStatement.setString(5, produto.getTipo());
            preparedStatement.setFloat(6, produto.getValor());
            preparedStatement.setInt(7, produto.getId());
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
        String sql = "DELETE FROM produtos WHERE id=?";
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

    public List<Produto> getListaProdutos() throws SQLException, ClassNotFoundException {
        List<Produto> listaProdutos = new ArrayList<>();
        connection = DbUtil.getConnection();
        String query = "SELECT * FROM produtos ORDER BY nome";

        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getInt("id"));
                produto.setModelo(resultSet.getString("modelo"));
                produto.setQtminima(resultSet.getInt("qtminima"));
                produto.setQtmaxima(resultSet.getInt("qtmaxima"));
                produto.setUnidade(resultSet.getString("unidade"));
                produto.setTipo(resultSet.getString("tipo"));
                produto.setValor(resultSet.getFloat("valor"));
                listaProdutos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
        return listaProdutos;
    }

    public Produto getProdutoById(int id) throws SQLException, ClassNotFoundException {
        Produto produto = new Produto();
        connection = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM produtos WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produto.setId(resultSet.getInt("id"));
                produto.setModelo(resultSet.getString("modelo"));
                produto.setQtminima(resultSet.getInt("qtminima"));
                produto.setQtmaxima(resultSet.getInt("qtmaxima"));
                produto.setUnidade(resultSet.getString("unidade"));
                produto.setTipo(resultSet.getString("tipo"));
                produto.setValor(resultSet.getFloat("valor"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return produto;
    }
}
