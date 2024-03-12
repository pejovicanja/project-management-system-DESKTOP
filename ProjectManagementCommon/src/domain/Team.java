/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import search.TeamSearch;

/**
 *
 * @author HP
 */
public class Team implements GenericEntity {

    private Long id;
    private String name;
    private int numOfMembers;

    public Team() {
    }

    public Team(Long id) {
        this.id = id;
    }

    public Team(Long id, String name, int numOfMembers) {
        this.id = id;
        this.name = name;
        this.numOfMembers = numOfMembers;
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

    public int getNumOfMembers() {
        return numOfMembers;
    }

    public void setNumOfMembers(int numOfMembers) {
        this.numOfMembers = numOfMembers;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public String getTableName() {
        return "team";
    }

    @Override
    public String getInsertColumns() {
        return "name, number_of_members";
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "'," + numOfMembers;
    }

    @Override
    public void setDbId(Long id) {
        this.id = id;
    }

    @Override
    public String getUpdateQuery() {
        return "name='" + name + "',number_of_members=" + numOfMembers;
    }

    @Override
    public String getWhereQuery() {
        return "id=" + id;
    }

    @Override
    public List<GenericEntity> getAllObjects(ResultSet rs) {
        List<GenericEntity> teams = new ArrayList<>();
        try {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                int numOfMembers = rs.getInt("number_of_members");
                Team team = new Team(id, name, numOfMembers);
                teams.add(team);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Team.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teams;
    }

    @Override
    public String getWhereQueryWithFilter(Object filter) {
        TeamSearch search = (TeamSearch) filter;
        return "1=1";
    }

    @Override
    public String getWhereQueryWithObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Team other = (Team) obj;
        return Objects.equals(this.id, other.id);
    }



    
}
