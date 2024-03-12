/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.employee;

import domain.Employee;
import so.AbstractSO;

/**
 *
 * @author HP
 */
public class SaveEmployeeSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Employee)) {
            throw new Exception("Object is not Employee");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.save((Employee) param);
    }
}
