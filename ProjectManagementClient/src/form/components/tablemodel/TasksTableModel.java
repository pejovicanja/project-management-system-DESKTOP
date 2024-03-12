/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.components.tablemodel;

import domain.Task;
import domain.TaskStatus;
import domain.Team;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class TasksTableModel extends AbstractTableModel {

    private List<Task> tasks;
    private List<Team> teams;
    private final String[] header = {"Name", "Status", "Due date", "Team"};

    public TasksTableModel(List<Task> tasks, List<Team> teams) {
        this.tasks = tasks;
        this.teams = teams;
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task temp = tasks.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                temp.getName();
            case 1 ->
                temp.getStatus();
            case 2 ->
                temp.getDueDate();
            case 3 ->
                temp.getTeam() == null ? null : teams.get(teams.indexOf(temp.getTeam()));
            default ->
                "N/A";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(rowIndex >= tasks.size()){
            return;
        }
        Task temp = tasks.get(rowIndex);
        try {
            switch (columnIndex) {
                case 0 -> {
                    if (((String) aValue).equals("")) {
                        JOptionPane.showMessageDialog(null, "Please insert name of tasks", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        temp.setName((String) aValue);
                    }
                }
                case 1 -> {
                    TaskStatus status = (TaskStatus) (aValue);
                    temp.setStatus(status);

                }
                case 2 -> {
                    LocalDate dueDate = LocalDate.parse((String) aValue, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    if (dueDate.isBefore(temp.getProject().getStartDate()) || dueDate.isAfter(temp.getProject().getEndDate())) {
                        JOptionPane.showMessageDialog(null, "Due date must be in range of project's date", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        temp.setDueDate(dueDate);
                    }
                }
                case 3 -> {
                    Team team = (Team) (aValue);
                    temp.setTeam(team);
                }

            }
        } catch (DateTimeParseException ex) {
            // when user leaves empty capacity field
            // or enter manually date with wrong format
            // and try to select another row
            // old values will be automatically shown
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        fireTableDataChanged();
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

}
