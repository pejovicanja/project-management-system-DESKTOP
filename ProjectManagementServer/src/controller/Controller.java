/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Administrator;
import domain.Employee;
import domain.Project;
import domain.Task;
import domain.Team;
import java.util.List;
import repository.Repository;
import repository.db.impl.DBRepositoryImpl;
import search.EmployeeSearch;
import search.ProjectSearch;
import search.TaskSearch;
import search.TeamSearch;
import so.AbstractSO;
import so.administrator.LoginSO;
import so.administrator.LogoutSO;
import so.employee.DeleteEmployeeSO;
import so.employee.GetEmployeesByFilterSO;
import so.employee.SaveEmployeeSO;
import so.employee.UpdateEmployeeSO;
import so.project.DeleteProjectSO;
import so.project.GetProjectsByFilterSO;
import so.project.SaveProjectSO;
import so.project.UpdateProjectSO;
import so.task.GetTasksByFilterSO;
import so.team.GetTeamsByFilterSO;

/**
 *
 * @author HP
 */
public class Controller {

    private static Controller controller;

    private Controller() {
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public Administrator login(String username, String password) throws Exception {
        Administrator admin = new Administrator();
        admin.setUsername(username);
        admin.setPassword(password);
        AbstractSO loginSO = new LoginSO();
        loginSO.execute(admin);
        return ((LoginSO) loginSO).getLoggedInAdmin();
    }

    public void logout(Administrator admin) throws Exception {
        AbstractSO logoutSO = new LogoutSO();
        logoutSO.execute(admin);
    }

    public List<Employee> getEmployeesByFilter(EmployeeSearch search) throws Exception {
        AbstractSO getEmployeesByFilter = new GetEmployeesByFilterSO();
        ((GetEmployeesByFilterSO) getEmployeesByFilter).setFilter(search);
        getEmployeesByFilter.execute(new Employee());
        return ((GetEmployeesByFilterSO) getEmployeesByFilter).getEmployees();
    }

    public void updateEmployee(Employee employee) throws Exception {
        AbstractSO updateEmployeeSO = new UpdateEmployeeSO();
        updateEmployeeSO.execute(employee);
    }

    public void deleteEmployee(Employee employeeDeleted) throws Exception {
        AbstractSO deleteEmployeeSO = new DeleteEmployeeSO();
        deleteEmployeeSO.execute(employeeDeleted);
    }

    public void saveEmployee(Employee employeeSave) throws Exception {
        AbstractSO saveEmployeeSO = new SaveEmployeeSO();
        saveEmployeeSO.execute(employeeSave);
    }

    public List<Project> getProjectsByFilter(ProjectSearch search) throws Exception {
        AbstractSO getProjectsByFilter = new GetProjectsByFilterSO();
        ((GetProjectsByFilterSO) getProjectsByFilter).setFilter(search);
        getProjectsByFilter.execute(new Project());
        return ((GetProjectsByFilterSO) getProjectsByFilter).getProjects();
    }

    public void deleteProject(Project projectDeleted) throws Exception {
        AbstractSO deleteProjectSO = new DeleteProjectSO();
        deleteProjectSO.execute(projectDeleted);
    }

    public void updateProject(Project projectUpdated) throws Exception {
        AbstractSO updateProjectSO = new UpdateProjectSO();
        updateProjectSO.execute(projectUpdated);
    }

    public void saveProject(Project projectSaved) throws Exception {
        AbstractSO saveProjectSO = new SaveProjectSO();
        saveProjectSO.execute(projectSaved);
    }

    public List<Task> getTasksByFilter(TaskSearch search) throws Exception {
        AbstractSO getTasksByFilterSO = new GetTasksByFilterSO();
        ((GetTasksByFilterSO) getTasksByFilterSO).setFilter(search);
        getTasksByFilterSO.execute(new Task());
        return ((GetTasksByFilterSO) getTasksByFilterSO).getTasks();
    }

    public List<Team> getTeamsByFilter(TeamSearch search) throws Exception {
        AbstractSO getTeamsByFilterSO = new GetTeamsByFilterSO();
        ((GetTeamsByFilterSO) getTeamsByFilterSO).setFilter(search);
        getTeamsByFilterSO.execute(new Team());
        return ((GetTeamsByFilterSO) getTeamsByFilterSO).getTeams();
    }

}
