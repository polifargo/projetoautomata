/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.dao;

import br.senac.tads3.pi03b.projetoautomata.models.Servico;
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
public class ServicoDAO {

    private Connection connection;
    
    public void acao(Servico servico) throws Exception{
        Servico serv = this.getServicoById(servico.getId());
        
        if (serv.getId() == null) {
            inserir(servico);
        }else{
            alterar(servico);
        }
    }

    public void inserir(Servico servico)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        String sql = "INSERT INTO servicos(id, descricao, tipo, valor, notasInternas, inativo)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            preparedStatement.setString(1, servico.getId());
            preparedStatement.setString(2, servico.getDescricao());
            preparedStatement.setString(3, servico.getTipo());
            preparedStatement.setFloat( 4, servico.getValor());
            preparedStatement.setString(5, servico.getNotasInternas());
            preparedStatement.setInt(   6, servico.getInativo());

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

    public void alterar(Servico servico)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        String sql = "UPDATE servicos SET descricao=?, tipo=?, valor=?, notasInternas=?, inativo=?"
                + "WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            preparedStatement.setString(1, servico.getDescricao());
            preparedStatement.setString(2, servico.getTipo());
            preparedStatement.setFloat(3, servico.getValor());
            preparedStatement.setString(4, servico.getNotasInternas());
            preparedStatement.setInt(5, servico.getInativo());
            preparedStatement.setString(6, servico.getId());
            preparedStatement.executeUpdate();
        } finally {
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
        String sql = "DELETE FROM servicos WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            preparedStatement.setInt(1, id);
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

    public List<Servico> getListaServicos() throws SQLException, ClassNotFoundException {
        List<Servico> listaServicos = new ArrayList<>();
        connection = DbUtil.getConnection();
        String query = "SELECT * FROM servicos ORDER BY descricao";

        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Servico servico = new Servico();
                servico.setId(resultSet.getString("id"));
                servico.setDescricao(resultSet.getString("descricao"));
                servico.setTipo(resultSet.getString("tipo"));
                servico.setValor(Float.parseFloat(resultSet.getString("valor")));
                servico.setNotasInternas(resultSet.getString("notasInternas"));
                servico.setInativo(resultSet.getInt("inativo"));
                listaServicos.add(servico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
        return listaServicos;
    }

    public Servico getServicoById(String id) throws SQLException, ClassNotFoundException {
        Servico servico = new Servico();
        connection = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM servicos WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                servico.setId(resultSet.getString("id"));
                servico.setDescricao(resultSet.getString("descricao"));
                servico.setTipo(resultSet.getString("tipo"));
                servico.setValor(Float.parseFloat(resultSet.getString("valor")));
                servico.setNotasInternas(resultSet.getString("notasInternas"));
                servico.setInativo(resultSet.getInt("inativo"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return servico;
    }
}
