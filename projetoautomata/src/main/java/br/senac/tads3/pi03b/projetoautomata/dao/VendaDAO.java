/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.dao;

import br.senac.tads3.pi03b.projetoautomata.models.ItemVenda;
import br.senac.tads3.pi03b.projetoautomata.models.Venda;
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
public class VendaDAO {
    private Connection connection;

    public void inserir(Venda venda)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        ArrayList<ItemVenda> itens = new ArrayList<ItemVenda>();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql1 = "INSERT INTO Venda (idCliente, FormaPagamento, Valor, NotasInternas)"
                + " VALUES (?, ?, ?, ?)";
        
        String sql2 = "";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        PreparedStatement preparedStatement2 = null;
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement1.setInt(1, venda.getCliente());
            preparedStatement1.setString(2, venda.getFormaPagamento());
            preparedStatement1.setFloat( 3, venda.getValor());
            preparedStatement1.setString(4, venda.getNotasInternas());

            //Executa o comando no banco de dados
            preparedStatement1.executeUpdate();
            
            String query1 = "SELECT max(id) id FROM Venda";
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query1);
            
            for (ItemVenda item : venda.getItensVenda()) {
                sql2 = "INSERT INTO itensVenda (idProduto, idVenda, QtVendida, ValorTotal, ValorUnitario)"
                + " VALUES (?, ?, ?, ?, ?)";
                
                preparedStatement2 = connection.prepareStatement(sql2);
                
                preparedStatement2.setString(   1, item.getIdProduto());
                preparedStatement2.setInt(      2, resultSet.getInt("id"));
                preparedStatement2.setInt(      3, item.getQtVendida());
                preparedStatement2.setDouble(   4, item.getValorTotal());
                preparedStatement2.setDouble(   5, item.getValorUnitario());
                
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

    public void alterar(Venda venda)
            throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql1 = "UPDATE Venda SET idCliente=?, FormaPagamento=?, Valor=?, NotasInternas=?"
                + " WHERE id=?";
        
        String sql2;
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        PreparedStatement preparedStatement2 = null;
        try {
           //Configura os parâmetros do "PreparedStatement"
            preparedStatement1.setInt(1, venda.getCliente());
            preparedStatement1.setString(2, venda.getFormaPagamento());
            preparedStatement1.setString(3, String.valueOf(venda.getValor()));
            preparedStatement1.setString(4, venda.getNotasInternas());
            preparedStatement1.setInt(   5, venda.getId());
            //Executa o comando no banco de dados
            preparedStatement1.executeUpdate();
            
            for (ItemVenda item : venda.getItensVenda()) {
                sql2 = "UPDATE itensVenda SET idProduto=?, idVenda=?, QtVendida=?, ValorTotal=?, ValorUnitario=?"
                        + " WHERE id=?";
                
                preparedStatement2 = connection.prepareStatement(sql2);
                
                preparedStatement2.setString(   1, item.getIdProduto());
                preparedStatement2.setInt(      2, item.getIdVenda());
                preparedStatement2.setInt(      3, item.getQtVendida());
                preparedStatement2.setDouble(   4, item.getValorTotal());
                preparedStatement2.setDouble(   5, item.getValorUnitario());
                preparedStatement2.setDouble(   6, item.getId());
                
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
        String sql1 = "DELETE FROM Venda WHERE id=?";
        String sql2 = "DELETE FROM ItensVenda WHERE idVenda=?";
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

    public List<Venda> getListaVenda() throws SQLException, ClassNotFoundException {
        List<Venda> listaVenda = new ArrayList<>();
        
        connection = DbUtil.getConnection();
        String query1 = "SELECT * FROM Venda ORDER BY id";
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query1);
            while (resultSet.next()) {
                Venda venda = new Venda();
                venda.setId(resultSet.getInt("id"));
                venda.setCliente(resultSet.getInt("idCliente"));
                venda.setFormaPagamento(resultSet.getString("FormaPagamento"));
                venda.setNotasInternas(resultSet.getString("NotasInternas"));
                
                String query2 = "SELECT * FROM ItensVenda WHERE idVenda = " + venda.getId();
                ResultSet resultSetItens = st.executeQuery(query2);
                
                ArrayList<ItemVenda> itensVenda = new ArrayList<>();
                
                while(resultSetItens.next()){
                    ItemVenda ite = new ItemVenda();
                
                    ite.setId(resultSetItens.getInt("Id"));
                    ite.setIdProduto(resultSet.getString("idProduto"));
                    ite.setIdVenda(resultSet.getInt("idVenda"));
                    ite.setQtVendida(resultSet.getInt("QtVendida"));
                    ite.setValorTotal(resultSet.getDouble("ValorTotal"));
                    ite.setValorUnitario(resultSet.getDouble("ValorUnitario"));
                    
                    itensVenda.add(ite);
                }
                
                venda.setItens(itensVenda);
                listaVenda.add(venda);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
        return listaVenda;
    }

    public Venda getVendaById(int id) throws SQLException, ClassNotFoundException {
        Venda venda = new Venda();
        connection = DbUtil.getConnection();
        try {
            String query1 = "SELECT * FROM Venda WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                venda.setId(resultSet.getInt("id"));
                venda.setCliente(resultSet.getInt("idCliente"));
                venda.setFormaPagamento(resultSet.getString("FormaPagamento"));
                venda.setNotasInternas(resultSet.getString("NotasInternas"));
                
                String query2 = "SELECT * FROM ItensVenda WHERE idVenda = " + venda.getId();
                ResultSet resultSetItens = preparedStatement.executeQuery(query2);
                
                ArrayList<ItemVenda> itensVenda = new ArrayList<>();
                
                while(resultSetItens.next()){
                    ItemVenda ite = new ItemVenda();
                
                    ite.setId(resultSetItens.getInt("Id"));
                    ite.setIdProduto(resultSet.getString("idProduto"));
                    ite.setIdVenda(resultSet.getInt("idVenda"));
                    ite.setQtVendida(resultSet.getInt("QtVendida"));
                    ite.setValorTotal(resultSet.getDouble("ValorTotal"));
                    ite.setValorUnitario(resultSet.getDouble("ValorUnitario"));
                    
                    itensVenda.add(ite);
                }
                
                venda.setItens(itensVenda);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return venda;
    }
}
