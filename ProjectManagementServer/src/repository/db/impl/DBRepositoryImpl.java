/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.GenericEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import repository.db.DBConnectionFactory;
import repository.db.DBRepository;

/**
 *
 * @author HP
 */
public class DBRepositoryImpl implements DBRepository<GenericEntity, Object> {

    @Override
    public void save(GenericEntity parameter) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(parameter.getTableName())
                    .append("(").append(parameter.getInsertColumns()).append(")")
                    .append(" VALUES (").append(parameter.getInsertValues()).append(")");
            String query = sb.toString();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                Long id = rs.getLong(1);
                parameter.setDbId(id);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void update(GenericEntity parameter) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ")
                    .append(parameter.getTableName())
                    .append(" SET ")
                    .append(parameter.getUpdateQuery())
                    .append(" WHERE ")
                    .append(parameter.getWhereQuery());
            String query = sb.toString();
            statement.executeUpdate(query);

            statement.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void delete(GenericEntity parameter) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ")
                    .append(parameter.getTableName())
                    .append(" WHERE ")
                    .append(parameter.getWhereQuery());
            String query = sb.toString();
            statement.executeUpdate(query);

            statement.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity parameter) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ")
                    .append(parameter.getTableName());
            String query = sb.toString();
            ResultSet rs = statement.executeQuery(query);
            return parameter.getAllObjects(rs);

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAllByFilter(GenericEntity parameter, Object filter) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ")
                    .append(parameter.getTableName())
                    .append(" WHERE ")
                    .append(parameter.getWhereQueryWithFilter(filter));
            String query = sb.toString();
            ResultSet rs = statement.executeQuery(query);
            return parameter.getAllObjects(rs);

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAllByObject(GenericEntity parameter, Object object) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ")
                    .append(parameter.getTableName())
                    .append(" WHERE ")
                    .append(parameter.getWhereQueryWithObject(object));
            String query = sb.toString();
            ResultSet rs = statement.executeQuery(query);
            return parameter.getAllObjects(rs);

        } catch (SQLException ex) {
            throw ex;
        }
    }

}
