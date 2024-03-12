/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.employee;

import controller.Controller;
import domain.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import search.EmployeeSearch;
import so.AbstractSO;

/**
 *
 * @author HP
 */
public class UpdateEmployeeSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Employee)) {
            throw new Exception("Object is not employee");
        }
        Employee employee = (Employee) param;
        if (!isInBase(employee)) {
            throw new Exception("Employee does not exist");
        }

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.update((Employee) param);
    }
    

    private boolean isInBase(Employee employee) {
        List<Employee> employees;
        EmployeeSearch search = new EmployeeSearch();
        search.setId(employee.getId());
        try {
            employees=Controller.getInstance().getEmployeesByFilter(search);
            return !employees.isEmpty();
        } catch (Exception ex) {
            
        }
        
        return false;
    }

}
