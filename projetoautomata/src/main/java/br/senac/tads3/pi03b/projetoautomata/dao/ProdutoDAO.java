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
    
    public void acao(Produto produto) throws Exception{
        Produto prod = getProdutoById(produto.getId());
        
        if (prod.getId() == null) {
            inserir(produto);
        }else{
            alterar(produto);
        }
    }
    
    public void inserir(Produto produto)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();

        String sql = "INSERT INTO produtos (modelo, unidade, valorCusto, valorVenda, notasInternas, inativo, id)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            preparedStatement.setString(1, produto.getModelo());
            preparedStatement.setString(2, produto.getUnidade());
            preparedStatement.setFloat( 3, produto.getValorCusto());
            preparedStatement.setFloat( 4, produto.getValorVenda());
            preparedStatement.setString(5, produto.getNotasInternas());
            preparedStatement.setInt(   6, produto.getInativo());
            preparedStatement.setString(7, produto.getId());

            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void alterar(Produto produto)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();

        String sql = "UPDATE produtos SET modelo=?, unidade=?, valorCusto=?, valorVenda=?, notasInternas=?, inativo=?"
                + "WHERE id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            preparedStatement.setString(1, produto.getModelo());
            preparedStatement.setString(2, produto.getUnidade());
            preparedStatement.setFloat(3, produto.getValorCusto());
            preparedStatement.setFloat(4, produto.getValorVenda());
            preparedStatement.setString(5, produto.getNotasInternas());
            preparedStatement.setInt(6, produto.getInativo());
             preparedStatement.setString(7, produto.getId());

            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void excluir(String id) throws SQLException, Exception {
        connection = DbUtil.getConnection();
        String sql = "DELETE FROM produtos WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        try {
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public List<Produto> getListaProdutos() throws SQLException, ClassNotFoundException {
        List<Produto> listaProdutos = new ArrayList<>();
        connection = DbUtil.getConnection();
        String query = "SELECT * FROM produtos ORDER BY modelo";

        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getString("id"));
                produto.setModelo(resultSet.getString("modelo"));
                produto.setUnidade(resultSet.getString("unidade"));
                produto.setValorCusto(resultSet.getFloat("valorCusto"));
                produto.setValorVenda(resultSet.getFloat("valorVenda"));
                produto.setNotasInternas(resultSet.getString("notasInternas"));
                produto.setInativo(resultSet.getInt("inativo"));
                listaProdutos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
        return listaProdutos;
    }

    public Produto getProdutoById(String id) throws SQLException, ClassNotFoundException {
        Produto produto = new Produto();
        connection = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM produtos WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produto.setId(resultSet.getString("id"));
                produto.setModelo(resultSet.getString("modelo"));
                produto.setUnidade(resultSet.getString("unidade"));
                produto.setValorCusto(resultSet.getFloat("valorCusto"));
                produto.setValorVenda(resultSet.getFloat("valorVenda"));
                produto.setNotasInternas(resultSet.getString("notasInternas"));
                produto.setInativo(resultSet.getInt("inativo"));
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
