/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.components.tablemodel;

import domain.Project;
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
public class ProjectsTableModel extends AbstractTableModel {

    private List<Project> projects;
    private final String[] header = {"Name", "Start date", "End date"};

    public ProjectsTableModel(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public int getRowCount() {
        return projects.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Project temp = projects.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                temp.getName();
            case 1 ->
                temp.getStartDate();
            case 2 ->
                temp.getEndDate();
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
        Project temp = projects.get(rowIndex);
        try {
            switch (columnIndex) {
                case 0 -> {
                    if (((String) aValue).equals("")) {
                        JOptionPane.showMessageDialog(null, "Please insert name of project", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        temp.setName((String) aValue);
                    }
                }
                case 1 -> {
                    LocalDate startDate = LocalDate.parse((String) aValue, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    if (startDate.isAfter(temp.getEndDate())) {
                        JOptionPane.showMessageDialog(null, "Start date can't be after end date", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        temp.setStartDate(startDate);
                    }
                }
                case 2 -> {
                    LocalDate endDate = LocalDate.parse((String) aValue, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    if (endDate.isBefore(temp.getStartDate())) {
                        JOptionPane.showMessageDialog(null, "End date can't be before start date", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        temp.setEndDate(endDate);
                    }
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

    public void setProjects(List<Project> projects) {
        this.projects = projects;
        fireTableDataChanged();
    }

    public Project getProject(int index) {
        return projects.get(index);
    }
}
