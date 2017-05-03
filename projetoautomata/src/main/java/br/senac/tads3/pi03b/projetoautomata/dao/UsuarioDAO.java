/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.dao;

import br.senac.tads3.pi03b.projetoautomata.models.UsuarioSistema;
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
public class UsuarioDAO {

    private Connection connection;

    public void inserir(UsuarioSistema usuario)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO usuarios (nome, login, senha, papel, email)"
                + "VALUES (?, ?, ?, ?, ?)";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, usuario.getNomeCompleto());
            preparedStatement.setString(2, usuario.getUsuario());
            preparedStatement.setString(3, usuario.getHashSenha());
            preparedStatement.setString(4, usuario.getPapel());
            preparedStatement.setString(5, usuario.getEmail());

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

    public void alterar(UsuarioSistema usuario)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE usuarios SET nome=?, login=?, senha=?, papel=?, email=?"
                + "WHERE id=?";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, usuario.getNomeCompleto());
            preparedStatement.setString(2, usuario.getUsuario());
            preparedStatement.setString(3, usuario.getHashSenha());
            preparedStatement.setString(4, usuario.getPapel());
            preparedStatement.setString(5, usuario.getEmail());
            preparedStatement.setInt(6, usuario.getId());
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
        String sql = "DELETE FROM usuarios WHERE id=?";
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

    public List<UsuarioSistema> getListaUsuarios() throws SQLException, ClassNotFoundException {
        List<UsuarioSistema> listaUsuarios = new ArrayList<>();
        connection = DbUtil.getConnection();
        String query = "SELECT * FROM usuarios ORDER BY nome";
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                UsuarioSistema usuario = new UsuarioSistema();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNomeCompleto(resultSet.getString("nome"));
                usuario.setUsuario(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setPapel(resultSet.getString("papel"));
                usuario.setEmail(resultSet.getString("email"));
                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
        return listaUsuarios;
    }

    public UsuarioSistema getUsuarioById(int id) throws SQLException, ClassNotFoundException {
        UsuarioSistema usuario = new UsuarioSistema();
        connection = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM usuarios WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuario.setId(resultSet.getInt("id"));
                usuario.setNomeCompleto(resultSet.getString("nome"));
                usuario.setUsuario(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setPapel(resultSet.getString("papel"));
                usuario.setEmail(resultSet.getString("email"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return usuario;
    }
}
