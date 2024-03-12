/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import search.AdministratorSearch;
import search.ProjectSearch;

/**
 *
 * @author HP
 */
public class Administrator implements GenericEntity {

    private Long id;
    private String username;
    private String password;
    private LocalDate employmentDate;

    public Administrator() {
    }

    public Administrator(Long id) {
        this.id = id;
    }

    public Administrator(Long id, String username, String password, LocalDate employmentDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.employmentDate = employmentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    @Override
    public String toString() {
        return "Administrator{" + "id=" + id + ", username=" + username + ", password=" + password + ", employmentDate=" + employmentDate + '}';
    }

    @Override
    public String getTableName() {
        return "administrator";
    }

    @Override
    public String getInsertColumns() {
        return "username, password, employment_date";
    }

    @Override
    public String getInsertValues() {
        return "'" + username + "','" + password + "','" + employmentDate.toString() + "'";
    }

    @Override
    public void setDbId(Long id) {
        this.id = id;
    }

    @Override
    public String getUpdateQuery() {
        return "username='" + username + "',password='" + password + "',employment_date='" + employmentDate.toString() + "'";
    }

    @Override
    public String getWhereQuery() {
        return "id=" + id;
    }

    @Override
    public List<GenericEntity> getAllObjects(ResultSet rs) {
        List<GenericEntity> administrators = new ArrayList<>();
        try {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                LocalDate employmentDate = (rs.getDate("employment_date")).toLocalDate();
                Administrator administrator = new Administrator(id, username, password, employmentDate);
                administrators.add(administrator);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return administrators;
    }

    @Override
    public String getWhereQueryWithFilter(Object filter) {
        AdministratorSearch search = (AdministratorSearch) filter;

        return "(username = '" + search.getUsername() + "' AND password = '" + search.getPassword() + "')";
    }

    @Override
    public String getWhereQueryWithObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
