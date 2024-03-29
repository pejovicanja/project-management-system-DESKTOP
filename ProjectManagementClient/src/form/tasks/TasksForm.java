/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form.tasks;

import controller.ControllerUI;
import domain.Project;
import domain.Task;
import domain.TaskStatus;
import domain.Team;
import form.components.cell.JDateChooserCellEditor;
import form.components.tablemodel.TasksTableModel;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import search.TaskSearch;
import search.TeamSearch;
import session.Session;

/**
 *
 * @author HP
 */
public class TasksForm extends javax.swing.JDialog {

    private List<Team> teams;
    private List<Task> tasks;
    private TableModel tableModel;

   
    public TasksForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        designTable();
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        lblUserText3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTasks = new javax.swing.JTable();
        btnAddTask = new javax.swing.JButton();
        btnDeleteTask = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setMaximumSize(new java.awt.Dimension(900, 640));
        panelMain.setMinimumSize(new java.awt.Dimension(900, 640));

        panelHeader.setBackground(new java.awt.Color(45, 118, 232));

        lblUserText3.setBackground(new java.awt.Color(45, 118, 232));
        lblUserText3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        lblUserText3.setForeground(new java.awt.Color(255, 255, 255));
        lblUserText3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUserText3.setText("TASKS");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/projectsList.png"))); // NOI18N

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUserText3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHome)
                .addGap(17, 17, 17))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUserText3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHome)))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        tblTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Status", "Due date", "Team"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTasks.setFocusable(false);
        tblTasks.setRowHeight(25);
        tblTasks.setSelectionBackground(new java.awt.Color(232, 57, 99));
        tblTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTasks.setShowGrid(true);
        tblTasks.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblTasks);

        btnAddTask.setText("Add task");
        btnAddTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTaskActionPerformed(evt);
            }
        });

        btnDeleteTask.setText("Delete task");
        btnDeleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTaskActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMainLayout.createSequentialGroup()
                        .addComponent(btnAddTask, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteTask)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTask, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteTask, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTaskActionPerformed
        if (tblTasks.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "You did not select task!", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tasks.remove(tasks.get(tblTasks.getSelectedRow()));
        ((TasksTableModel) tableModel).setTasks(tasks);
    }//GEN-LAST:event_btnDeleteTaskActionPerformed

    private void btnAddTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTaskActionPerformed
        Task task = new Task();
        task.setProject((Project) Session.getInstance().get("selectedProject"));
        task.setDueDate(LocalDate.now());
        task.setName(tasks == null  ? "Task 1" : "Task " + (tasks.size() + 1));
        task.setStatus(TaskStatus.NEW);
        task.setTeam(teams != null && !teams.isEmpty() ? teams.getFirst() : null);
        tasks.add(task);
        ((TasksTableModel) tableModel).setTasks(tasks);
        JOptionPane.showMessageDialog(this, "Fill in missing info");
    }//GEN-LAST:event_btnAddTaskActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTask;
    private javax.swing.JButton btnDeleteTask;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblUserText3;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTable tblTasks;
    // End of variables declaration//GEN-END:variables

    private void designTable() {
        tblTasks.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
        tblTasks.getTableHeader().setOpaque(false);
        tblTasks.getTableHeader().setBackground(new Color(32, 136, 203));
        tblTasks.getTableHeader().setForeground(new Color(255, 255, 255));
        tblTasks.setRowHeight(25);
    }

    private void populateTable() {
        try {
            teams = ControllerUI.getInstance().getTeamsByFilter(new TeamSearch());
            tasks = ControllerUI.getInstance().getTasksByFilter(new TaskSearch((Project) Session.getInstance().get("selectedProject")));
            tblTasks.setModel(new TasksTableModel(tasks, teams));
            tableModel = (TasksTableModel) tblTasks.getModel();

            tblTasks.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JComboBox<>(TaskStatus.values())));
            tblTasks.getColumnModel().getColumn(2).setCellEditor(new JDateChooserCellEditor(new JCheckBox()));
            tblTasks.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JComboBox<>(teams.toArray())));

            //IMPORTANT: Setting list of fetched tasks to selected project, then Update Project on ProjectForm
            //will also send tasks to server 
            Project selectedProject = (Project) Session.getInstance().get("selectedProject");
            selectedProject.setTasks(tasks);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error getting tasks!");
            System.exit(0);
        }
    }

}
