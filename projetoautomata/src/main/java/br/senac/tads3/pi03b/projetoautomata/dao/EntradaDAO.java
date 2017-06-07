package br.senac.tads3.pi03b.projetoautomata.dao;

import br.senac.tads3.pi03b.projetoautomata.models.Entrada;
import br.senac.tads3.pi03b.projetoautomata.models.Produto;
import br.senac.tads3.pi03b.projetoautomata.utils.DbUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alef.rmendes
 */
public class EntradaDAO {

    private Connection connection;

    public void acao(Entrada entrada) throws Exception {
        // Só existe opção de incluir uma entrada
        inserir(entrada);
    }

    public void inserir(Entrada entrada) throws SQLException, Exception {
        connection = DbUtil.getConnection();

        String sql = "INSERT INTO ENTRADA(idProduto, idUnidade, quantidade) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            preparedStatement.setString(1, entrada.getIdProduto());
            preparedStatement.setString(2, entrada.getIdUnidade());
            preparedStatement.setDouble(3, entrada.getQuantidade());

            preparedStatement.executeUpdate();
        } catch(Exception erro){
            erro.printStackTrace();
        }
        finally {
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
        String query = "SELECT * FROM produtos WHERE inativo=1 ORDER BY modelo";

        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getString("id"));
                produto.setModelo(resultSet.getString("modelo"));
                produto.setUnidade(resultSet.getString("unidade"));
                produto.setValorCusto(resultSet.getDouble("valorCusto"));
                produto.setValorVenda(resultSet.getDouble("valorVenda"));
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
}
