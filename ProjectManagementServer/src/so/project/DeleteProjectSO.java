/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.project;

import controller.Controller;
import domain.Project;
import java.util.List;
import search.ProjectSearch;
import so.AbstractSO;

/**
 *
 * @author HP
 */
public class DeleteProjectSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Project)) {
            throw new Exception("Object is not project");
        }
        Project project = (Project) param;
        if (!isInBase(project)) {
            throw new Exception("Project does not exist");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((Project) param);
    }

    private boolean isInBase(Project project) {
        List<Project> projects;
        ProjectSearch search = new ProjectSearch();
        search.setId(project.getId());
        try {
            projects = Controller.getInstance().getProjectsByFilter(search);
            return !projects.isEmpty();
        } catch (Exception ex) {

        }
        return false;
    }

}
