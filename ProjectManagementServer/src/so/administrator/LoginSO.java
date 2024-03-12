/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.administrator;

import controller.Controller;
import domain.Administrator;
import exception.LoginException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import search.AdministratorSearch;
import so.AbstractSO;

/**
 *
 * @author HP
 */
public class LoginSO extends AbstractSO {

    private Administrator loggedInAdmin;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Administrator)) {
            throw new Exception("Object is not administrator!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Administrator administrator = (Administrator) param;
        AdministratorSearch search = new AdministratorSearch(administrator.getUsername(), administrator.getPassword());
        List<Administrator> administrators = repository.getAllByFilter(new Administrator(), search);
        if(administrators != null && !administrators.isEmpty()) {
            loggedInAdmin = administrators.getFirst();
        }
    }

    public Administrator getLoggedInAdmin() {
        return loggedInAdmin;
    }

}
