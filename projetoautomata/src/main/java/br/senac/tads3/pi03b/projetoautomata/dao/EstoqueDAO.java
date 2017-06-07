/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.dao;

import br.senac.tads3.pi03b.projetoautomata.models.ItemVenda;
import br.senac.tads3.pi03b.projetoautomata.models.Venda;
import br.senac.tads3.pi03b.projetoautomata.utils.DbUtil;
import br.senac.tads3.pi03b.projetoautomata.dao.ClienteDAO;
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
public class EstoqueDAO {

    private Connection connection;

    public List<Venda> getListaVenda() throws SQLException, ClassNotFoundException {
        List<Venda> listaVenda = new ArrayList<>();
        ClienteDAO cli = new ClienteDAO();
        
        connection = DbUtil.getConnection();
        String query1 = "SELECT * FROM Venda ORDER BY DATA";
        try {
            Statement st = connection.createStatement();
            ResultSet resultVenda = st.executeQuery(query1);
            while (resultVenda.next()) {
                Venda venda = new Venda();
                venda.setId(resultVenda.getInt("id"));
                venda.setIdCliente(resultVenda.getInt("idCliente"));
                venda.setFormaPagamento(resultVenda.getString("FormaPagamento"));
                venda.setNotasInternas(resultVenda.getString("NotasInternas"));
                venda.setCliente(cli.getClienteById(resultVenda.getInt("idCliente")));
                venda.setData(resultVenda.getString("data"));
                venda.setValor(resultVenda.getDouble("valor"));
                
                listaVenda.add(venda);
            }
            
            for(Venda venda : listaVenda){
                String query2 = "SELECT * FROM ItensVenda WHERE idVenda = " + venda.getId();
                Statement st2 = connection.createStatement();
                ResultSet resultSetItens = st2.executeQuery(query2);

                ArrayList<ItemVenda> itensVenda = new ArrayList<>();

                while (resultSetItens.next()) {
                    ItemVenda ite = new ItemVenda();

                    ite.setId(resultSetItens.getInt("Id"));
                    ite.setIdProduto(resultSetItens.getString("idProduto"));
                    ite.setIdVenda(resultSetItens.getInt("idVenda"));
                    ite.setQtVendida(resultSetItens.getInt("QtVendida"));
                    ite.setValorTotal(resultSetItens.getDouble("ValorTotal"));
                    ite.setValorUnitario(resultSetItens.getDouble("ValorUnitario"));

                    itensVenda.add(ite);
                }
                
                venda.setItens(itensVenda);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
        return listaVenda;
    }

    public Venda getVendaById(int id) throws SQLException, ClassNotFoundException {
        Venda venda = new Venda();
        ClienteDAO cli = new ClienteDAO();
        connection = DbUtil.getConnection();
        try {
            String query1 = "SELECT * FROM Venda WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                venda.setId(resultSet.getInt("id"));
                venda.setIdCliente(resultSet.getInt("idCliente"));
                venda.setFormaPagamento(resultSet.getString("FormaPagamento"));
                venda.setNotasInternas(resultSet.getString("NotasInternas"));
                venda.setCliente(cli.getClienteById(resultSet.getInt("idCliente")));
                venda.setData(resultSet.getString("data"));
                
                String query2 = "SELECT * FROM ItensVenda WHERE idVenda = " + venda.getId();
                ResultSet resultSetItens = preparedStatement.executeQuery(query2);

                ArrayList<ItemVenda> itensVenda = new ArrayList<>();

                while (resultSetItens.next()) {
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
