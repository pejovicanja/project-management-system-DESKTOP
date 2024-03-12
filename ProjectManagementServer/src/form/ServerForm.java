/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import thread.ServerThread;

/**
 *
 * @author HP
 */
public class ServerForm extends javax.swing.JFrame {

    /**
     * Creates new form ServerForm
     */
    private ServerThread st;

    public ServerForm() {
        initComponents();
        setLocationRelativeTo(null);
        lblStatus.setText("Server is not running");
        lblStatus.setForeground(Color.red);
        btnStopServer.setEnabled(false);
        activeUsers.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnStartServer = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnStopServer = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        formSettings = new javax.swing.JMenuItem();
        activeUsers = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);

        jPanel1.setBackground(new java.awt.Color(45, 118, 232));

        btnStartServer.setText("Start server");
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        lblStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("jLabel1");

        btnStopServer.setText("Stop server");
        btnStopServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(btnStartServer)
                .addGap(61, 61, 61)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(btnStopServer)
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(207, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jMenu1.setText("Menu");

        formSettings.setText("Database settings");
        formSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formSettingsActionPerformed(evt);
            }
        });
        jMenu1.add(formSettings);

        activeUsers.setText("Active users ");
        activeUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeUsersActionPerformed(evt);
            }
        });
        jMenu1.add(activeUsers);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Info");

        jMenuItem1.setText("About application");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("About creator");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStopServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopServerActionPerformed
        if (st != null && st.getServerSocket().isBound()) {
            st.closeServer();
            btnStopServer.setEnabled(false);
            btnStartServer.setEnabled(true);
            lblStatus.setText("Server is not running!");
            lblStatus.setForeground(Color.red);
            formSettings.setEnabled(true);
            activeUsers.setEnabled(false);
        }
    }//GEN-LAST:event_btnStopServerActionPerformed

    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed
        if (st == null || !st.isAlive()) {
            try {
                st = new ServerThread();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Server has already been running!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        st.start();
        btnStopServer.setEnabled(true);
        btnStartServer.setEnabled(false);
        lblStatus.setText("Server is running!");
        lblStatus.setForeground(Color.green);
        formSettings.setEnabled(false);
        activeUsers.setEnabled(true);
    }//GEN-LAST:event_btnStartServerActionPerformed

    private void formSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formSettingsActionPerformed
        new SettingsForm(this, true).setVisible(true);

    }//GEN-LAST:event_formSettingsActionPerformed

    private void activeUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeUsersActionPerformed
        new ActiveUsersForm(this, true).setVisible(true);
    }//GEN-LAST:event_activeUsersActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(this, "Ova aplikacija je kreirana u januaru 2024. i predstavlja klijent-server aplikaciju"
                + " napisanu u Java programskom jeziku. Opšta namena aplikacije jeste efikasno upravljanje timova na projektu. Ovaj softverski"
                + " sistem treba da omogući evidentiranje projekata, zadataka, zaposlenih, kao i timova u okviru svakog projekta.");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(this, "Anja Pejović, 2001. godište, iz Bara, Crna Gora.");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem activeUsers;
    private javax.swing.JButton btnStartServer;
    private javax.swing.JButton btnStopServer;
    private javax.swing.JMenuItem formSettings;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}