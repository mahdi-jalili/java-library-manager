package Jframes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author sina
 */
public class ManageStudents extends javax.swing.JFrame {

    String studentName, cours, branch;
    int studentId;

    DefaultTableModel model;

    public ManageStudents() {
        initComponents();

        setStudentDetailsToTable();
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------    
    public void setStudentDetailsToTable() {

        try {

            Connection con = databaseconnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");

            while (rs.next()) {

                String studentId = rs.getString("student_id");
                String studentName = rs.getString("name");
                String cours = rs.getString("cours");
                String branch = rs.getString("branch");

                Object[] obj = {studentId, studentName, cours, branch};

                model = (DefaultTableModel) tbl_studentdetails.getModel();
                model.addRow(obj);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error");
        }

    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------   
    public boolean addStudent() {

        boolean isAdded = false;

        studentId = Integer.parseInt(txt_studentid.getText());
        studentName = txt_studentName.getText();
        cours = combo_coursName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();

        try {

            Connection con = databaseconnection.getConnection();
            String sql = "insert into student_details values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setString(2, studentName);
            ps.setString(3, cours);
            ps.setString(4, branch);

            int rowCount = ps.executeUpdate();

            //this means the row inserted is sucssesfuly
            if (rowCount > 0) {
                isAdded = true;
            } else {
                isAdded = false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }
        return isAdded;

    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------       
    //for update table
    public boolean updateStudent() {

        boolean isUpdate = false;

        studentId = Integer.parseInt(txt_studentid.getText());
        studentName = txt_studentName.getText();
        cours = combo_coursName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();

        try {
            Connection con = databaseconnection.getConnection();

            String sql = "update student_details set name=? , cours=? , branch=? where student_id=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, studentName);
            ps.setString(2, cours);
            ps.setString(3, branch);
            ps.setInt(4, studentId);

            int rowCount = ps.executeUpdate();
            if (rowCount > 0) {
                isUpdate = true;
            } else {
                isUpdate = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }
        return isUpdate;
    }

    //Methos to delete student details
    public boolean deleteStudent() {

        boolean isDelete = false;

        studentId = Integer.parseInt(txt_studentid.getText());

        try {
            Connection con = databaseconnection.getConnection();
            String sql = "delete from student_details where student_id= ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);

            int roeCount = ps.executeUpdate();
            if (roeCount > 0) {
                try {
                    Connection con2 = databaseconnection.getConnection();
                    String sql2 = "UPDATE lending_book set status='Returned' WHERE student_id=?";
                    PreparedStatement st = con2.prepareStatement(sql2);
                    st.setInt(1, studentId);

                    int rowCount = st.executeUpdate();
                    if (rowCount > 0) {
                        isDelete = true;
                    } else {
                        isDelete = false;
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error");
                }
            } else {
                isDelete = false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }
        return isDelete;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------
//for remove hustory of table

    public void clearTable() {

        DefaultTableModel model = (DefaultTableModel) tbl_studentdetails.getModel();

        //intori tamame history ghabli jadval pak mishe
        model.setRowCount(0);

    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        combo_branch = new javax.swing.JComboBox<>();
        combo_coursName = new javax.swing.JComboBox<>();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Student id");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 100, 60));

        txt_studentid.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentid.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_studentid.setPlaceholder("Enter Student id...");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        txt_studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentidActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 220, 40));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 50, 50));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 100, 60));

        txt_studentName.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_studentName.setPlaceholder("Enter Your Name...");
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 220, 40));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 50, 50));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Select Cours");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 130, 60));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 50, 50));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Select Branch");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 140, 60));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 50, 50));

        combo_branch.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CS", "PLAIN", "ELECTRONICS", " " }));
        jPanel1.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 270, 40));

        combo_coursName.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_coursName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PHD", "MSC", " " }));
        jPanel1.add(combo_coursName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 270, 40));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Add");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 110, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("update");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 110, 70));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("delete");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 110, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 600));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("x");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 80, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 140, 50));

        tbl_studentdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Cours", "Branch"
            }
        ));
        tbl_studentdetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentdetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentdetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_studentdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentdetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentdetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentdetails.setRowHeight(40);
        tbl_studentdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentdetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentdetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 730, 350));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText("   Manage Students");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 390, 120));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 370, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 850, 600));

        setSize(new java.awt.Dimension(1200, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

        Home h = new Home();
        h.show();
        this.hide();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost

    }//GEN-LAST:event_txt_studentidFocusLost

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost

    }//GEN-LAST:event_txt_studentNameFocusLost

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void tbl_studentdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentdetailsMouseClicked

        // for show details of tabale in the textfields 
        int rowNumber = tbl_studentdetails.getSelectedRow();
        TableModel model = tbl_studentdetails.getModel();

        txt_studentid.setText(model.getValueAt(rowNumber, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNumber, 1).toString());
        combo_coursName.setSelectedItem(model.getValueAt(rowNumber, 2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNumber, 3).toString());


    }//GEN-LAST:event_tbl_studentdetailsMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed

        if (addStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student Added");

            clearTable();
            // for update table right Now
            setStudentDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Student Addition Failed");
        }

    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (updateStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student updated");

            clearTable();
            // for update table right Now
            setStudentDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Student updation Failed");
        }

    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if (deleteStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student deleted");

            clearTable();
            // for update table right Now
            setStudentDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Student deletion Failed");
        }

    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JComboBox<String> combo_coursName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro tbl_studentdetails;
    private app.bolivia.swing.JCTextField txt_studentName;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}
