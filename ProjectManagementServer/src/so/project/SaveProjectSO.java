/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.project;

import domain.Project;
import domain.Task;
import so.AbstractSO;

/**
 *
 * @author HP
 */
public class SaveProjectSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Project)) {
            throw new Exception("Object is not Project");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.save((Project) param);
        Project savedProject = (Project) param;
        if(savedProject.getTasks() != null) {
            for (Task task : savedProject.getTasks()) {
                task.setProject(savedProject);
                repository.save(task);
            }
        }
    }

}
