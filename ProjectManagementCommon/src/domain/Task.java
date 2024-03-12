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
import search.TaskSearch;

/**
 *
 * @author HP
 */
public class Task implements GenericEntity {

    private Long id;
    private Project project;
    private String name;
    private LocalDate dueDate;
    private Team team;
    private TaskStatus status;

    public Task() {
    }

    public Task(Long id, Project project, String name, LocalDate dueDate, Team team, TaskStatus status) {
        this.id = id;
        this.project = project;
        this.name = name;
        this.dueDate = dueDate;
        this.team = team;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", project=" + project + ", name=" + name + ", dueDate=" + dueDate + ", team=" + team + ", status=" + status + '}';
    }

    @Override
    public String getTableName() {
        return "task";
    }

    @Override
    public String getInsertColumns() {
        return "project_id, name, status, due_date, team_id";
    }

    @Override
    public String getInsertValues() {
        return project.getId() + ",'" + name + "','" + status.toString() + "','" + dueDate.toString() + "'," + team.getId();
    }

    @Override
    public void setDbId(Long id) {
        this.id = id;
    }

    @Override
    public String getUpdateQuery() {
        return "name = '" + name + "', status = '" + status + "', due_date = '" + dueDate.toString() + "', team_id = " + team.getId();
    }

    @Override
    public String getWhereQuery() {
        return "id=" + id;
    }

    @Override
    public List<GenericEntity> getAllObjects(ResultSet rs) {
        List<GenericEntity> tasks = new ArrayList<>();
        try {
            while (rs.next()) {
                Long id = rs.getLong("id");
                Project project = new Project(rs.getLong("project_id"));
                String name = rs.getString("name");
                TaskStatus status = TaskStatus.valueOf(rs.getString("status"));
                LocalDate dueDate = (rs.getDate("due_date")).toLocalDate();
                Team team = new Team(rs.getLong("team_id"));
                Task task = new Task(id, project, name, dueDate, team, status);
                tasks.add(task);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tasks;
    }

    @Override
    public String getWhereQueryWithFilter(Object filter) {
        TaskSearch search = (TaskSearch) filter;

        if (search.getProject() == null) {
            return "1=1";
        }

        return "project_id = " + search.getProject().getId();
    }

    @Override
    public String getWhereQueryWithObject(Object object) {
        return "project_id=" + ((Project) object).getId();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.project);
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
        final Task other = (Task) obj;
        if(this.id == null && other.id == null){
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.project, other.project);
    }

}
