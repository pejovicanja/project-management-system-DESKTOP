/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.project;

import domain.Project;
import java.util.List;
import search.ProjectSearch;
import so.AbstractSO;

/**
 *
 * @author HP
 */
public class GetProjectsByFilterSO extends AbstractSO {

    private List<Project> projects;
    private ProjectSearch filter;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        projects = repository.getAllByFilter((Project) param, filter);
    }
    
    public List<Project> getProjects() {
        return projects;
    }

    public void setFilter(ProjectSearch filter) {
        this.filter = filter;
    }

}
