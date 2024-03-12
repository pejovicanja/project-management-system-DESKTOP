/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.components.tablemodel;

import domain.Employee;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class EmployeesTableModel extends AbstractTableModel {

    private List<Employee> employees;
    private final String[] header = {"First name", "Last name", "Birthdate"};

    public EmployeesTableModel(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee temp = employees.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                temp.getFirstname();
            case 1 ->
                temp.getLastname();
            case 2 ->
                temp.getBirthDate();
            default ->
                "N/A";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    public void setEmployees(List<Employee> temp) {
        employees = temp;
        fireTableDataChanged();
    }

    public Employee getEmployee(int index) {
        return employees.get(index);
    }

}
