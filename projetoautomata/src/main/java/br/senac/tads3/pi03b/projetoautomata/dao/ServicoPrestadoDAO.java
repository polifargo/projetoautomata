/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.dao;

import br.senac.tads3.pi03b.projetoautomata.models.ItemServico;
import br.senac.tads3.pi03b.projetoautomata.models.ServicoPrestado;
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
 * @author Andrey
 */
public class ServicoPrestadoDAO {
    private Connection connection;

    public void inserir(ServicoPrestado servicoPrestado)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        ArrayList<ItemServico> itens = new ArrayList<ItemServico>();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql1 = "INSERT INTO ServicoPrestado (idCliente, FormaPagamento, ValorTotal, ValorDesconto, NotasInternas)"
                + " VALUES (?, ?, ?, ?, ?)";
        
        String sql2 = "";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        PreparedStatement preparedStatement2 = null;
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement1.setInt(      1, servicoPrestado.getIdCliente());
            preparedStatement1.setString(   2, servicoPrestado.getFormaPagamento());
            preparedStatement1.setDouble(   3, servicoPrestado.getValorTotal());
            preparedStatement1.setDouble(   4, servicoPrestado.getValorDesconto());
            preparedStatement1.setString(   5, servicoPrestado.getNotasInternas());

            //Executa o comando no banco de dados
            preparedStatement1.executeUpdate();
            
            String query1 = "SELECT max(id) id FROM ServicoPrestado";
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query1);
            
            for (ItemServico item : servicoPrestado.getItensServico()) {
                sql2 = "INSERT INTO ItensServico (idTecnico, idServico, idServicoPrestado, idVenda, ValorTotal, ValorUnitario)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
                
                preparedStatement2 = connection.prepareStatement(sql2);
                
                preparedStatement2.setInt(      1, item.getIdTecnico());
                preparedStatement2.setString(   2, item.getIdServico());
                preparedStatement2.setInt(      3, resultSet.getInt("id"));
                preparedStatement2.setInt(      4, item.getIdVenda());
                preparedStatement2.setDouble(   5, item.getValorTotal());
                preparedStatement2.setDouble(   6, item.getValorUnitario());
                
                //Executa o comando no banco de dados
                preparedStatement2.executeUpdate();
            }
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement1 != null && !preparedStatement1.isClosed()) {
                preparedStatement1.close();
            }
            
            if (preparedStatement2 != null && !preparedStatement2.isClosed()) {
                preparedStatement2.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void alterar(ServicoPrestado servicoPrestado)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql1 = "UPDATE ServicoPrestado SET idCliente=?, FormaPagamento=?, ValorTotal=?, ValorDesconto=?, NotasInternas=?"
                + " WHERE id=?";
        
        String sql2;
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        PreparedStatement preparedStatement2 = null;
        try {
           //Configura os parâmetros do "PreparedStatement"
            preparedStatement1.setInt(      1, servicoPrestado.getIdCliente());
            preparedStatement1.setString(   2, servicoPrestado.getFormaPagamento());
            preparedStatement1.setString(   3, String.valueOf(servicoPrestado.getValorTotal()));
            preparedStatement1.setString(   4, String.valueOf(servicoPrestado.getValorDesconto()));
            preparedStatement1.setString(   5, servicoPrestado.getNotasInternas());
            preparedStatement1.setInt(      6, servicoPrestado.getId());
            //Executa o comando no banco de dados
            preparedStatement1.executeUpdate();
            
            for (ItemServico item : servicoPrestado.getItensServico()) {
                sql2 = "UPDATE ItensServico SET idTecnico=?, idServico=?, idServicoPrestado=?, idVenda=?, ValorTotal=?, ValorUnitario=?"
                        + " WHERE id=?";
                
                preparedStatement2 = connection.prepareStatement(sql2);
                
                preparedStatement2.setInt(      1, item.getIdTecnico());
                preparedStatement2.setString(   2, item.getIdServico());
                preparedStatement2.setInt(      3, item.getIdServicoPrestado());
                preparedStatement2.setInt(      4, item.getIdVenda());
                preparedStatement2.setDouble(   5, item.getValorTotal());
                preparedStatement2.setDouble(   6, item.getValorUnitario());
                preparedStatement2.setDouble(   7, item.getId());
                
                //Executa o comando no banco de dados
                preparedStatement2.executeUpdate();
            }
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement1 != null && !preparedStatement1.isClosed()) {
                preparedStatement1.close();
            }
            if (preparedStatement2 != null && !preparedStatement2.isClosed()) {
                preparedStatement2.close();
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
        String sql1 = "DELETE FROM ServicoPrestado WHERE id=?";
        String sql2 = "DELETE FROM ItensServico WHERE idServicoPrestado=?";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement1.setInt(1, id);
            preparedStatement2.setInt(1, id);
            //Executa o comando no banco de dados
            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement1 != null && !preparedStatement1.isClosed()) {
                preparedStatement1.close();
            }
            if (preparedStatement2 != null && !preparedStatement2.isClosed()) {
                preparedStatement2.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public List<ServicoPrestado> getListaServico() throws SQLException, ClassNotFoundException {
        List<ServicoPrestado> listaServicoPrestado = new ArrayList<>();
        
        connection = DbUtil.getConnection();
        String query1 = "SELECT * FROM ServicoPrestado ORDER BY id";
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query1);
            while (resultSet.next()) {
                ServicoPrestado servicoPrestado = new ServicoPrestado();
                servicoPrestado.setId(resultSet.getInt("id"));
                servicoPrestado.setIdCliente(resultSet.getInt("idCliente"));
                servicoPrestado.setFormaPagamento(resultSet.getString("FormaPagamento"));
                servicoPrestado.setValorTotal(resultSet.getDouble("ValorTotal"));
                servicoPrestado.setValorDesconto(resultSet.getDouble("ValorDesconto"));
                servicoPrestado.setNotasInternas(resultSet.getString("NotasInternas"));
                
                String query2 = "SELECT * FROM ItensServico WHERE idServicoPrestado = " + servicoPrestado.getId();
                ResultSet resultSetItens = st.executeQuery(query2);
                
                ArrayList<ItemServico> itensServico = new ArrayList<>();
                
                while(resultSetItens.next()){
                    ItemServico ite = new ItemServico();
                
                    ite.setId(resultSetItens.getInt("Id"));
                    ite.setIdTecnico(resultSet.getInt("idTecnico"));
                    ite.setIdServico(resultSet.getString("idServico"));
                    ite.setIdServicoPrestado(resultSet.getInt("idServicoPrestado"));
                    ite.setIdVenda(resultSet.getInt("idVenda"));
                    ite.setValorTotal(resultSet.getDouble("ValorTotal"));
                    ite.setValorUnitario(resultSet.getDouble("ValorUnitario"));
                    
                    itensServico.add(ite);
                }
                
                servicoPrestado.setItens(itensServico);
                listaServicoPrestado.add(servicoPrestado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
        return listaServicoPrestado;
    }

    public ServicoPrestado getServicoPrestadoById(int id) throws SQLException, ClassNotFoundException {
        ServicoPrestado servicoPrestado = new ServicoPrestado();
        connection = DbUtil.getConnection();
        try {
            String query1 = "SELECT * FROM ServicoPrestado WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                servicoPrestado.setId(resultSet.getInt("id"));
                servicoPrestado.setIdCliente(resultSet.getInt("idCliente"));
                servicoPrestado.setFormaPagamento(resultSet.getString("FormaPagamento"));
                servicoPrestado.setValorTotal(resultSet.getDouble("ValorTotal"));
                servicoPrestado.setValorDesconto(resultSet.getDouble("ValorDesconto"));
                servicoPrestado.setNotasInternas(resultSet.getString("NotasInternas"));
                
                String query2 = "SELECT * FROM ItensServico WHERE idServicoPrestado = " + servicoPrestado.getId();
                ResultSet resultSetItens = preparedStatement.executeQuery(query2);
                
                ArrayList<ItemServico> itensServico = new ArrayList<>();
                
                while(resultSetItens.next()){
                    ItemServico ite = new ItemServico();
                
                    ite.setId(resultSetItens.getInt("Id"));
                    ite.setIdTecnico(resultSet.getInt("idTecnico"));
                    ite.setIdServico(resultSet.getString("idServico"));
                    ite.setIdServicoPrestado(resultSet.getInt("idServicoPrestado"));
                    ite.setIdVenda(resultSet.getInt("idVenda"));
                    ite.setValorTotal(resultSet.getDouble("ValorTotal"));
                    ite.setValorUnitario(resultSet.getDouble("ValorUnitario"));
                    
                    itensServico.add(ite);
                }
                
                servicoPrestado.setItens(itensServico);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return servicoPrestado;
    }
}