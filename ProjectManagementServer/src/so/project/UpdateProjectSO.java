/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.project;

import controller.Controller;
import domain.Project;
import domain.Task;
import java.util.List;
import search.ProjectSearch;
import search.TaskSearch;
import so.AbstractSO;

/**
 *
 * @author HP
 */
public class UpdateProjectSO extends AbstractSO {

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
        repository.update((Project) param);
        Project updatedProject = (Project) param;

        List<Task> dbTasks;
        TaskSearch search = new TaskSearch(updatedProject);
        dbTasks = repository.getAllByFilter(new Task(), search);
        if (dbTasks != null) {
            for (Task dbTask : dbTasks) {
                if (!updatedProject.getTasks().contains(dbTask)) {
                    repository.delete(dbTask);
                }
            }
        }

        if (updatedProject.getTasks() != null) {
            for (Task task : updatedProject.getTasks()) {
                if (task.getId() == null) {
                    repository.save(task);
                } else {
                    repository.update(task);
                }
            }
        }
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
