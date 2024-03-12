/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import constants.ServerConstants;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class DBConnectionFactory {

    private static DBConnectionFactory instance;
    private Connection connection;

    private DBConnectionFactory() {

    }

    public static DBConnectionFactory getInstance() {
        if (instance == null) {
            instance = new DBConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream(ServerConstants.DB_CONFIG_FILE_PATH));
            String url = properties.getProperty(ServerConstants.DB_CONFIG_URL);
            String username = properties.getProperty(ServerConstants.DB_CONFIG_USERNAME);
            String password = properties.getProperty(ServerConstants.DB_CONFIG_PASSWORD);
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        }
        return connection;
    }

    public boolean testConnection(String url, String username, String password) {
        try {
            DriverManager.getConnection(url, username, password);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
