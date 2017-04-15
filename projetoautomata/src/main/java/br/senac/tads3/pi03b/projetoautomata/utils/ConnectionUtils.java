/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author matheus_santo
 */
public class ConnectionUtils {

    public static Connection getConnection() {
        //Conexão para abertura e fechamento
        Connection connection = null;
        try {
            //Só tenta abrir uma conexão se não existir ou estiver fechada            
            //Endereço de conexão com o banco de dados
            String dbURL = MainConstant.DB_ADDRESS;
            //Propriedades para armazenamento de usuário e senha
            Properties properties = new Properties();
            properties.put("user", MainConstant.DB_USER);
            properties.put("password", MainConstant.DB_PASS);
            //Realiza a conexão com o banco
            connection = DriverManager.getConnection(dbURL, properties);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //Retorna a conexão
        return connection;
    }
}
