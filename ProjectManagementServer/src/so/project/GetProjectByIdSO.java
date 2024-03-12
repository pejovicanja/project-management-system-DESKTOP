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
public class GetProjectByIdSO extends AbstractSO {

    private Project project;
    private ProjectSearch filter;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        List<Project> projects = repository.getAllByFilter((Project) param, filter);
        if(projects != null && !projects.isEmpty()) {
            project = projects.getFirst();
        }
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ProjectSearch getFilter() {
        return filter;
    }

    public void setFilter(ProjectSearch filter) {
        this.filter = filter;
    }

    
}
