/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search;

import domain.Project;
import java.io.Serializable;

/**
 *
 * @author HP
 */
public class TaskSearch implements Serializable{
    
    private Project project;

    public TaskSearch(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    
}
