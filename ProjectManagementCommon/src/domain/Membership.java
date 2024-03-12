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

/**
 *
 * @author HP
 */
public class Membership implements GenericEntity {

    private Employee employee;
    private Team team;
    private LocalDate joiningDate;
    private MembershipStatus status;

    public Membership() {
    }

    public Membership(Employee employee, Team team, LocalDate joiningDate, MembershipStatus membershipStatus) {
        this.employee = employee;
        this.team = team;
        this.joiningDate = joiningDate;
        this.status = membershipStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public MembershipStatus getStatus() {
        return status;
    }

    public void setStatus(MembershipStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Membership{" + "employee=" + employee + ", team=" + team + ", joiningDate=" + joiningDate + ", membershipStatus=" + status + '}';
    }

    @Override
    public String getTableName() {
        return "membership";
    }

    @Override
    public String getInsertColumns() {
        return "employee_id, team_id, joining_date, status";

    }

    @Override
    public String getInsertValues() {
        return employee.getId() + "," + team.getId() + ",'" + joiningDate.toString() + "','" + status.toString() + "'";
    }

    @Override
    public void setDbId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public String getUpdateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereQuery() {
        return "employee_id=" + employee.getId() + " AND team_id=" + team.getId();
    }

    @Override
    public List<GenericEntity> getAllObjects(ResultSet rs) {
        List<GenericEntity> memberships = new ArrayList<>();
        try {
            while (rs.next()) {
                Long employeeID = rs.getLong("employee_id");
                Long teamID = rs.getLong("team_id");
                LocalDate joiningDate = (rs.getDate("joining_date")).toLocalDate();
                MembershipStatus status = MembershipStatus.valueOf(rs.getString("status"));
                Employee employee = new Employee();
                employee.setId(employeeID);
                Team team = new Team();
                team.setId(teamID);
                Membership membership = new Membership(employee, team, joiningDate, status);
                memberships.add(membership);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Membership.class.getName()).log(Level.SEVERE, null, ex);
        }
        return memberships;
    }

    @Override
    public String getWhereQueryWithFilter(Object filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereQueryWithObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
