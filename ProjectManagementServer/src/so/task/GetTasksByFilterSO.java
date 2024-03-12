package so.task;

import domain.Task;
import java.util.List;
import search.TaskSearch;
import so.AbstractSO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class GetTasksByFilterSO extends AbstractSO{

    private List<Task> tasks;
    private TaskSearch filter;

    @Override
    protected void preconditions(Object param) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        tasks = repository.getAllByFilter((Task) param, filter);
    }
    
    public List<Task> getTasks() {
        return tasks;
    }

    public void setFilter(TaskSearch filter) {
        this.filter = filter;
    }
    
}
