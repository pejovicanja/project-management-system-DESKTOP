/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.team;

import domain.Team;
import java.util.List;
import search.TeamSearch;
import so.AbstractSO;

/**
 *
 * @author HP
 */
public class GetTeamsByFilterSO extends AbstractSO {
    
    
    private List<Team> teams;
    private TeamSearch filter;

    @Override
    protected void preconditions(Object param) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        teams = repository.getAllByFilter((Team) param, filter);
    }
    
    public List<Team> getTeams() {
        return teams;
    }

    public void setFilter(TeamSearch filter) {
        this.filter = filter;
    }
}
