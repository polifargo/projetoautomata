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

    public void inserir(Servico servico)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        String sql = "INSERT INTO servicos(descricao, tipo, tecnico, mediaConclusao, mediaHoras, valor)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            preparedStatement.setString(1, servico.getDescricao());
            preparedStatement.setString(2, servico.getTipo());
            preparedStatement.setString(3, servico.getTecnico());
            preparedStatement.setString(4, servico.getMediaConclusao());
            preparedStatement.setString(5, servico.getMediaHoras());
            preparedStatement.setFloat(6, servico.getValor());

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
        String sql = "UPDATE servicos SET descricao=?, tipo=?, tecnico=?, mediaConclusao=?, mediaHoras=?, valor=?"
                + "WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            preparedStatement.setString(1, servico.getDescricao());
            preparedStatement.setString(2, servico.getTipo());
            preparedStatement.setString(3, servico.getTecnico());
            preparedStatement.setString(4, servico.getMediaConclusao());
            preparedStatement.setString(5, servico.getMediaHoras());
            preparedStatement.setFloat(6, servico.getValor());
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
                servico.setId(resultSet.getInt("id"));
                servico.setDescricao(resultSet.getString("descricao"));
                servico.setTipo(resultSet.getString("tipo"));
                servico.setTecnico(resultSet.getString("tecnico"));
                servico.setMediaConclusao(resultSet.getString("mediaConclusao"));
                servico.setMediaHoras(resultSet.getString("mediaHoras"));
                servico.setValor(resultSet.getFloat("valor"));
                listaServicos.add(servico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
        return listaServicos;
    }

    public Servico getServicoById(int id) throws SQLException, ClassNotFoundException {
        Servico servico = new Servico();
        connection = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM servicos WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                servico.setId(resultSet.getInt("id"));
                servico.setDescricao(resultSet.getString("descricao"));
                servico.setTipo(resultSet.getString("tipo"));
                servico.setTecnico(resultSet.getString("tecnico"));
                servico.setMediaConclusao(resultSet.getString("mediaConclusao"));
                servico.setMediaHoras(resultSet.getString("mediaHoras"));
                servico.setValor(resultSet.getFloat("valor"));
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
