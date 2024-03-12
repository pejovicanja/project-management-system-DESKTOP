/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Communication;
import communication.Receiver;
import communication.Sender;
import domain.Administrator;
import domain.Employee;
import domain.Project;
import domain.Task;
import domain.Team;
import java.util.ArrayList;
import java.util.List;
import operation.Operation;
import search.EmployeeSearch;
import search.ProjectSearch;
import search.TaskSearch;
import search.TeamSearch;
import transfer.Request;
import transfer.Response;

/**
 *
 */
public class ControllerUI {

    private static ControllerUI instance;

    private final Sender sender;
    private final Receiver receiver;

    private ControllerUI() {
        sender = Communication.getInstance().getSender();
        receiver = Communication.getInstance().getReceiver();
    }

    public static ControllerUI getInstance() {
        if (instance == null) {
            instance = new ControllerUI();
        }
        return instance;
    }

    public Administrator login(String username, String password) throws Exception {
        Administrator admin = new Administrator();
        admin.setUsername(username);
        admin.setPassword(password);
        Request request = new Request(admin, Operation.LOGIN);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Administrator) response.getResult();
        }
        throw response.getException();
    }

    public Administrator logout(Administrator admin) throws Exception {
        Request request = new Request(admin, Operation.LOGOUT);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Administrator) response.getResult();
        }
        throw response.getException();
    }

    public List<Employee> getEmployeesByFilter(EmployeeSearch filter) throws Exception {
        Request request = new Request(filter, Operation.GET_EMPLOYEES_BY_FILTER);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Employee>) response.getResult();
        }
        throw response.getException();
    }

    public Employee updateEmployee(Employee employee) throws Exception {
        Request request = new Request(employee, Operation.UPDATE_EMPLOYEE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Employee) response.getResult();
        }
        throw response.getException();
    }

    public void deleteEmployee(Employee employee) throws Exception {
        Request request = new Request(employee, Operation.DELETE_EMPLOYEE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return;
        }
        throw response.getException();
    }

    public Employee saveEmployee(Employee employee) throws Exception {
        Request request = new Request(employee, Operation.SAVE_EMPLOYEE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Employee) response.getResult();
        }
        throw response.getException();
    }

    public List<Project> getProjectsByFilter(ProjectSearch projectSearch) throws Exception {
        Request request = new Request(projectSearch, Operation.GET_PROJECTS_BY_FILTER);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Project>) response.getResult();
        }
        throw response.getException();
    }

    public void deleteProject(Project selectedProject) throws Exception {
        Request request = new Request(selectedProject, Operation.DELETE_PROJECT);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return;
        }
        throw response.getException();
    }

    public Project updateProject(Project selectedProject) throws Exception {
        Request request = new Request(selectedProject, Operation.UPDATE_PROJECT);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Project) response.getResult();
        }
        throw response.getException();
    }

    public Project saveProject(Project selectedProject) throws Exception {
        Request request = new Request(selectedProject, Operation.SAVE_PROJECT);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Project) response.getResult();
        }
        throw response.getException();
    }

    public List<Task> getTasksByFilter(TaskSearch taskSearch) throws Exception {
        if (taskSearch.getProject().getId() == null) {
            return new ArrayList<>();
        }
        Request request = new Request(taskSearch, Operation.GET_TASKS_BY_FILTER);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Task>) response.getResult();
        }
        throw response.getException();

    }

    public List<Team> getTeamsByFilter(TeamSearch teamSearch) throws Exception {
        Request request = new Request(teamSearch, Operation.GET_TEAMS_BY_FILTER);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Team>) response.getResult();
        }
        throw response.getException();
    }

}
