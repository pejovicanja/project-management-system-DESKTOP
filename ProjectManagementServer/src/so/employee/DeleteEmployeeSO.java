/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.employee;

import controller.Controller;
import domain.Employee;
import java.util.List;
import search.EmployeeSearch;
import so.AbstractSO;

/**
 *
 * @author HP
 */
public class DeleteEmployeeSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Employee)) {
            throw new Exception("Object is not employee");
        }
        Employee worker = (Employee) param;
        if (!isInBase(worker)) {
            throw new Exception("Employee does not exist");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((Employee) param);
    }

    private boolean isInBase(Employee employee) {
        List<Employee> employees;
        EmployeeSearch search = new EmployeeSearch();
        search.setId(employee.getId());
        try {
            employees = Controller.getInstance().getEmployeesByFilter(search);
            return !employees.isEmpty();
        } catch (Exception ex) {

        }
        return false;
    }

}
