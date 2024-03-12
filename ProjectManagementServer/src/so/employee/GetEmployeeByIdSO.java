/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.employee;

import domain.Employee;
import domain.Project;
import java.util.List;
import search.EmployeeSearch;
import search.ProjectSearch;
import so.AbstractSO;

/**
 *
 * @author HP
 */
public class GetEmployeeByIdSO extends AbstractSO {

    private Employee employee;
    private EmployeeSearch filter;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        List<Employee> employees = repository.getAllByFilter((Project) param, filter);
        if (employees != null && !employees.isEmpty()) {
            employee = employees.getFirst();
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeSearch getFilter() {
        return filter;
    }

    public void setFilter(EmployeeSearch filter) {
        this.filter = filter;
    }

}
