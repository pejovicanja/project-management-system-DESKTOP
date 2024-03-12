/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Receiver;
import communication.Sender;
import controller.Controller;
import domain.Administrator;
import domain.Employee;
import domain.Project;
import domain.Task;
import domain.Team;
import exception.LoginException;
import java.net.Socket;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import static operation.Operation.DELETE_EMPLOYEE;
import static operation.Operation.GET_EMPLOYEES_BY_FILTER;
import static operation.Operation.GET_TASKS_BY_FILTER;
import static operation.Operation.LOGIN;
import static operation.Operation.LOGOUT;
import static operation.Operation.UPDATE_EMPLOYEE;
import search.EmployeeSearch;
import search.ProjectSearch;
import search.TaskSearch;
import search.TeamSearch;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author HP
 */
public class ClientHandler extends Thread {

    private final Socket socket;
    private final Sender sender;
    private final Receiver receiver;
    private Administrator currentAdmin;
    private Date loginTime;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
    }

    @Override
    public void run() {

        try {
            while (!socket.isClosed()) {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {
                    switch (request.getOperation()) {
                        case LOGIN -> {
                            Administrator a = (Administrator) request.getArgument();
                            Administrator admin = Controller.getInstance().login(a.getUsername(), a.getPassword());
                            if (admin != null) {
                                boolean isLoggedIn = ServerThread.isAdminLoggedIn(admin);
                                if (isLoggedIn) {
                                    response.setException(new LoginException("Admin is already logged in"));
                                } else {
                                    currentAdmin = admin;
                                    loginTime = new Date();
                                }
                            }
                            response.setResult(admin);
                        }
                        case LOGOUT -> {
                            Administrator activeAdmin = (Administrator) request.getArgument();
                            Controller.getInstance().logout(activeAdmin);
                            response.setResult(activeAdmin);
                        }
                        case GET_EMPLOYEES_BY_FILTER -> {
                            EmployeeSearch search = (EmployeeSearch) request.getArgument();
                            List<Employee> employees = Controller.getInstance().getEmployeesByFilter(search);
                            response.setResult(employees);
                        }
                        case UPDATE_EMPLOYEE -> {
                            Employee employeeUpdated = (Employee) request.getArgument();
                            Controller.getInstance().updateEmployee(employeeUpdated);
                            response.setResult(employeeUpdated);
                        }
                        case DELETE_EMPLOYEE -> {
                            Employee employeeDeleted = (Employee) request.getArgument();
                            Controller.getInstance().deleteEmployee(employeeDeleted);
                            response.setResult(employeeDeleted);
                        }
                        case SAVE_EMPLOYEE -> {
                            Employee employeeSave = (Employee) request.getArgument();
                            Controller.getInstance().saveEmployee(employeeSave);
                            response.setResult(employeeSave);
                        }
                        case GET_PROJECTS_BY_FILTER -> {
                            ProjectSearch search = (ProjectSearch) request.getArgument();
                            List<Project> projects = Controller.getInstance().getProjectsByFilter(search);
                            response.setResult(projects);
                        }
                        case DELETE_PROJECT -> {
                            Project projectDeleted = (Project) request.getArgument();
                            Controller.getInstance().deleteProject(projectDeleted);
                            response.setResult(projectDeleted);
                        }
                        case UPDATE_PROJECT -> {
                            Project projectUpdated = (Project) request.getArgument();
                            Controller.getInstance().updateProject(projectUpdated);
                            response.setResult(projectUpdated);
                        }
                        case SAVE_PROJECT -> {
                            Project projectSaved = (Project) request.getArgument();
                            Controller.getInstance().saveProject(projectSaved);
                            response.setResult(projectSaved);
                        }
                        case GET_TASKS_BY_FILTER -> {
                            TaskSearch search = (TaskSearch) request.getArgument();
                            List<Task> tasks = Controller.getInstance().getTasksByFilter(search);
                            response.setResult(tasks);
                        }
                        case GET_TEAMS_BY_FILTER -> {
                            TeamSearch search = (TeamSearch) request.getArgument();
                            List<Team> teams = Controller.getInstance().getTeamsByFilter(search);
                            response.setResult(teams);
                        }
                    }
                } catch (Exception ex) {
                    response.setException(ex);
                }
                sender.send(response);
            }
        } catch (Exception ex) {
            System.out.println("Logged out");
            ServerThread.removeClient(this);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public Administrator getCurrentAdmin() {
        return currentAdmin;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    
}
