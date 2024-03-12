/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import search.EmployeeSearch;

/**
 *
 * @author HP
 */
public class Employee implements GenericEntity {

    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private LocalDate creationDate;
    private Administrator administrator;

    public Employee() {
    }

    public Employee(Long id, String firstname, String lastname, LocalDate birthDate, LocalDate creationDate, Administrator administrator) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.creationDate = creationDate;
        this.administrator = administrator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthDate=" + birthDate + ", creationDate=" + creationDate + ", administrator=" + administrator + '}';
    }

    @Override
    public String getTableName() {
        return "employee";
    }

    @Override
    public String getInsertColumns() {
        return "firstname, lastname, birth_date, creation_date, administrator_id";
    }

    @Override
    public String getInsertValues() {
        return "'" + firstname + "','" + lastname + "','" + birthDate.toString() + "','" + creationDate.toString() + "'," + administrator.getId();
    }

    @Override
    public void setDbId(Long id) {
        this.id = id;
    }

    @Override
    public String getUpdateQuery() {
        return "firstname='" + firstname + "',lastname='" + lastname + "', birth_date='" + birthDate.toString() + "',creation_date='" + creationDate.toString()
                + "',administrator_id=" + administrator.getId();
    }

    @Override
    public String getWhereQuery() {
        return "id=" + id;
    }

    @Override
    public List<GenericEntity> getAllObjects(ResultSet rs) {
        List<GenericEntity> employees = new ArrayList<>();
        try {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                LocalDate birthDate = (rs.getDate("birth_date")).toLocalDate();
                LocalDate creationDate = (rs.getDate("creation_date")).toLocalDate();
                Long administratorID = rs.getLong("administrator_id");
                Administrator administrator = new Administrator(administratorID);
                Employee employee = new Employee(id, firstname, lastname, birthDate, creationDate, administrator);
                employees.add(employee);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }

    @Override
    public String getWhereQueryWithFilter(Object filter) {
        EmployeeSearch search = (EmployeeSearch) filter;

        if(search.getFirstname() == null && search.getLastname() == null && search.getBirthDateFrom() == null && search.getBirthDateTo() == null) {
            return "1=1";
        }
        
        String searchString = "(";

        if(search.getId() != null) {
            searchString += "id = " + search.getId() + " AND ";
        }
        
        if (search.getFirstname() != null) {
            searchString += "firstname LIKE '" + search.getFirstname().trim() + "%' AND ";
        }

        if (search.getLastname() != null) {
            searchString += "lastname LIKE '" + search.getLastname().trim() + "%' AND ";
        }

        if (search.getBirthDateFrom() != null) {
            searchString += "birth_date >= '" + search.getBirthDateFrom() + "' AND ";
        }

        if (search.getBirthDateTo() != null) {
            searchString += "birth_date <= '" + search.getBirthDateTo() + "'";
        }

        if (searchString.endsWith("AND ")) {
            int lastIndex = searchString.lastIndexOf("AND ");
            searchString = searchString.substring(0, lastIndex);
        }
        return searchString + ")";
    }

    @Override
    public String getWhereQueryWithObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
