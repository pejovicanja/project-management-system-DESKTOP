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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import search.ProjectSearch;

/**
 *
 * @author HP
 */
public class Project implements GenericEntity {

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Administrator administrator;
    private List<Task> tasks;

    public Project() {
        this.tasks = new ArrayList<>();
    }
    
    public Project(Long id){
        this.id = id;
    }

    public Project(Long projectID, String name, LocalDate startDate, LocalDate endDate, Administrator administrator) {
        this.id = projectID;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.administrator = administrator;
        this.tasks = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    

    @Override
    public String toString() {
        return "Project{" + "projectID=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", administrator=" + administrator + '}';
    }

    @Override
    public String getTableName() {
        return "project";
    }

    @Override
    public String getInsertColumns() {
        return "name, start_date, end_date, administrator_id";
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "','" + startDate.toString() + "','" + endDate.toString() + "'," + administrator.getId();

    }

    @Override
    public void setDbId(Long id) {
        this.id = id;
    }

    @Override
    public String getUpdateQuery() {
        return "name='" + name + "',start_date='" + startDate.toString() + "',end_date='" + endDate.toString() + "',administrator_id=" + administrator.getId();
    }

    @Override
    public String getWhereQuery() {
        return "id=" + id;
    }

    @Override
    public List<GenericEntity> getAllObjects(ResultSet rs) {
        List<GenericEntity> projects = new ArrayList<>();
        try {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                LocalDate startDate = (rs.getDate("start_date")).toLocalDate();
                LocalDate endDate = (rs.getDate("end_date")).toLocalDate();
                Administrator administrator = new Administrator(rs.getLong("administrator_id"));
                Project project = new Project(id, name, startDate, endDate, administrator);
                projects.add(project);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projects;
    }

    @Override
    public String getWhereQueryWithFilter(Object filter) {
        ProjectSearch search = (ProjectSearch) filter;

        if(search.getName()== null  && search.getStartDate()== null && search.getEndDate()== null) {
            return "1=1";
        }
        
        String searchString = "(";

        if(search.getId() != null) {
            searchString += "id = " + search.getId() + " AND ";
        }
        
        if (search.getName() != null) {
            searchString += "name LIKE '" + search.getName().trim() + "%' AND ";
        }


        if (search.getStartDate()!= null) {
            searchString += "start_date >= '" + search.getStartDate() + "' AND ";
        }

        if (search.getEndDate() != null) {
            searchString += "end_date <= '" + search.getEndDate() + "'";
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Project other = (Project) obj;
        return Objects.equals(this.id, other.id);
    }

    
}
