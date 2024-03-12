/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.employee;

import domain.Employee;
import java.util.List;
import java.util.logging.Filter;
import search.EmployeeSearch;
import so.AbstractSO;

/**
 *
 * @author HP
 */
public class GetEmployeesByFilterSO extends AbstractSO{
    
    private List<Employee> employees; 
    private EmployeeSearch filter;

    @Override
    protected void preconditions(Object param) throws Exception {
        //no preconditions needed to be checked
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        employees=repository.getAllByFilter((Employee)param, filter);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setFilter(EmployeeSearch filter) {
        this.filter = filter;
    }
    
    
    
    
}
