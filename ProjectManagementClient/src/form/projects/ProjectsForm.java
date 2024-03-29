/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form.projects;

import controller.ControllerUI;
import domain.Administrator;
import domain.Project;
import domain.Task;
import form.MainForm;
import form.components.cell.JDateChooserCellEditor;
import form.components.tablemodel.ProjectsTableModel;
import form.tasks.TasksForm;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import search.ProjectSearch;
import search.TaskSearch;
import session.Session;

public class ProjectsForm extends javax.swing.JFrame {

    private TableModel tableModel;
    private List<Project> projects;
    private Project selectedProject;
    private final List<Project> projectsWithFetchedTasks = new ArrayList<>();

    public ProjectsForm() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelMain = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        lblProjectsText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProjects = new javax.swing.JTable();
        panelSearch = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnReset = new javax.swing.JButton();
        txtSearchName = new javax.swing.JTextField();
        dateBegin = new com.toedter.calendar.JDateChooser();
        dateEnd = new com.toedter.calendar.JDateChooser();
        btnManageTasks = new javax.swing.JButton();
        btnAddProject = new javax.swing.JButton();
        btnUpdateProject = new javax.swing.JButton();
        btnDeleteProject = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 640));
        setResizable(false);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setMaximumSize(new java.awt.Dimension(900, 640));
        panelMain.setMinimumSize(new java.awt.Dimension(900, 640));
        panelMain.setPreferredSize(new java.awt.Dimension(900, 640));

        panelHeader.setBackground(new java.awt.Color(45, 118, 232));

        lblProjectsText.setBackground(new java.awt.Color(45, 118, 232));
        lblProjectsText.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        lblProjectsText.setForeground(new java.awt.Color(255, 255, 255));
        lblProjectsText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblProjectsText.setText("PROJECTS");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/projectsList.png"))); // NOI18N

        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProjectsText, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(lblProjectsText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHome)))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        tblProjects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Begin date ", "End date "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProjects.setFocusable(false);
        tblProjects.setRowHeight(25);
        tblProjects.setSelectionBackground(new java.awt.Color(232, 57, 99));
        tblProjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProjects.setShowGrid(true);
        tblProjects.setShowVerticalLines(false);
        tblProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProjectsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProjects);

        panelSearch.setBackground(new java.awt.Color(255, 255, 255));
        panelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel3.setText("Name:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Begin date:");

        jLabel6.setText("End date:");

        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSearchLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSearchLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSearchLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(dateBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSearchLayout.createSequentialGroup()
                        .addComponent(btnFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addComponent(dateBegin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFilter)
                    .addComponent(btnReset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnManageTasks.setText("Manage tasks");
        btnManageTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageTasksActionPerformed(evt);
            }
        });

        btnAddProject.setText("Add project");
        btnAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjectActionPerformed(evt);
            }
        });

        btnUpdateProject.setText("Update project");
        btnUpdateProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProjectActionPerformed(evt);
            }
        });

        btnDeleteProject.setText("Delete project");
        btnDeleteProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteProject)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdateProject)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnManageTasks)))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(panelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnManageTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdateProject, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteProject, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(panelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetTable();

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        String name = txtSearchName.getText();
        Date startDate = dateBegin.getDate();
        Date endDate = dateEnd.getDate();

        ProjectSearch search = new ProjectSearch();
        if (name != null) {
            search.setName(name.trim());
        }
        if (startDate != null) {
            LocalDate startDateLD = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            search.setStartDate(startDateLD);
        }
        if (endDate != null) {
            LocalDate endDateLD = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            search.setEndDate(endDateLD);
        }

        try {
            projects = ControllerUI.getInstance().getProjectsByFilter(search);
            if (projects.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No projects match criteria values.");
            }

            ((ProjectsTableModel) tableModel).setProjects(projects);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error getting projects!","Error",JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnDeleteProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProjectActionPerformed
        if (tblProjects.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "You did not select project!", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (selectedProject == null) {
            JOptionPane.showMessageDialog(this, "You did not select project!", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            ControllerUI.getInstance().deleteProject(selectedProject);
            JOptionPane.showMessageDialog(this, "Project successfully deleted");

            resetTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error while deleting project!", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteProjectActionPerformed

    private void tblProjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProjectsMouseClicked
        int rowIndex = tblProjects.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }

        selectedProject = ((ProjectsTableModel) tableModel).getProject(rowIndex);

    }//GEN-LAST:event_tblProjectsMouseClicked

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        new MainForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void btnAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProjectActionPerformed
        Project project = new Project();
        project.setAdministrator((Administrator) Session.getInstance().get("loggedInUser"));
        project.setStartDate(LocalDate.now());
        project.setEndDate(LocalDate.now());
        project.setName(projects == null ? "Project 1" : "Project " + (projects.size() + 1));
        project.setTasks(new ArrayList<>());
        projects.add(project);
        ((ProjectsTableModel) tableModel).setProjects(projects);
        JOptionPane.showMessageDialog(this, "Fill in missing info and then click update");
    }//GEN-LAST:event_btnAddProjectActionPerformed

    private void btnUpdateProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProjectActionPerformed
        if (tblProjects.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select project you want to update/save");
            return;
        }

        Project selectedProject = projects.get(tblProjects.getSelectedRow());

        try {
            if (selectedProject.getId() != null && !projectsWithFetchedTasks.contains(selectedProject)) {
                List<Task> tasks = ControllerUI.getInstance().getTasksByFilter(new TaskSearch(selectedProject));
                selectedProject.setTasks(tasks);
            }

            if (selectedProject.getId() != null) {
                selectedProject = ControllerUI.getInstance().updateProject(selectedProject);
            } else {
                Project savedProject = ControllerUI.getInstance().saveProject(selectedProject);
                selectedProject.setId(savedProject.getId());
            }
            ((ProjectsTableModel) tableModel).setProjects(projects);
            JOptionPane.showMessageDialog(this, "Project successfully saved");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving project!", "ERROR", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_btnUpdateProjectActionPerformed

    private void btnManageTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageTasksActionPerformed
        if (tblProjects.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select project you want to manage tasks!");
            return;
        }

        Project selectedProject = projects.get(tblProjects.getSelectedRow());
        if (!projectsWithFetchedTasks.contains(selectedProject)) {
            projectsWithFetchedTasks.add(selectedProject);
        }
        Session.getInstance().add("selectedProject", selectedProject);
        new TasksForm(this, true).setVisible(true);

    }//GEN-LAST:event_btnManageTasksActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProject;
    private javax.swing.JButton btnDeleteProject;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnManageTasks;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdateProject;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dateBegin;
    private com.toedter.calendar.JDateChooser dateEnd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblProjectsText;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JTable tblProjects;
    private javax.swing.JTextField txtSearchName;
    // End of variables declaration//GEN-END:variables

    private void designTable() {
        tblProjects.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
        tblProjects.getTableHeader().setOpaque(false);
        tblProjects.getTableHeader().setBackground(new Color(32, 136, 203));
        tblProjects.getTableHeader().setForeground(new Color(255, 255, 255));
        tblProjects.setRowHeight(25);
    }

    private void populateTable() {
        try {
            projects = ControllerUI.getInstance().getProjectsByFilter(new ProjectSearch());

            tblProjects.setModel(new ProjectsTableModel(projects));
            tableModel = (ProjectsTableModel) tblProjects.getModel();

            tblProjects.getColumnModel().getColumn(1).setCellEditor(new JDateChooserCellEditor(new JCheckBox()));
            tblProjects.getColumnModel().getColumn(2).setCellEditor(new JDateChooserCellEditor(new JCheckBox()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error getting projects!");
            System.exit(0);
        }
    }

    private void resetTable() {
        txtSearchName.setText("");
        dateBegin.setDate(null);
        dateEnd.setDate(null);
        populateTable();
    }

}
