/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author matheus_santo
 */
public class DbUtil {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;

        // Passo 1: Registrar o driver JDBC
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

        // Passo 2: Abrir a conexão
        conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/automata",
                "root", // usuário BD
                "root"); // senha BD
        return conn;
    }
}
