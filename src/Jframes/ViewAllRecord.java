
package Jframes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sina
 */
public class ViewAllRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewAllRecord
     */
    
     DefaultTableModel model;
    
    public ViewAllRecord() {
        initComponents();
        
        setBorrowBookDetailsToTable();
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------    
       //to set the book details into the table
    public void setBorrowBookDetailsToTable(){
            
            
            try{
                
                Connection con=databaseconnection.getConnection();
                Statement st=con.createStatement();
                ResultSet rs= st.executeQuery("select * from lending_book");
                
                while(rs.next()){
                        
                        String id          =rs.getString("id");
                        String bookName   = rs.getString("book_name");
                        String studentName = rs.getString("student_name");
                        String lendingDate       = rs.getString("borrow_date");
                        String returnDate      = rs.getString("return_book_datte");
                        String status       = rs.getString("status");
                        
                        
                        Object[] obj= {id,bookName,studentName,lendingDate,returnDate,status};
                        
                        model =(DefaultTableModel)tbl_borrowBookDetails.getModel();
                        model.addRow(obj);
                    
                }
                
            }
            catch(Exception e){
                    
                JOptionPane.showMessageDialog(this,"Error");
            }
              
            
        }
 
//method to clear table      
        public void clearTable(){
            
            DefaultTableModel model=(DefaultTableModel)tbl_borrowBookDetails.getModel();
            
            //intori tamame history ghabli jadval pak mishe
            model.setRowCount(0);
            
            
        }   
    
    //to fetch the record using date fields
        public void search(){
            
            // baraye gereftan etelaat az package ytil estefade mikonim
            Date uFromDate = date_lendingDate.getDatoFecha();
            Date uToDate   = date_returndate.getDatoFecha();
            
            //package sql long haro barmigardone pas variable haye ma bayad be noe long tabdil bashan
            long u1=uFromDate.getTime();
            long u2=uToDate.getTime();
            
            //baraye estefade az etelaat az package sql estefade mikoim 
            //chon package java Date ro support nemikone 
            java.sql.Date fromDate= new java.sql.Date(u1);
            java.sql.Date toDate= new java.sql.Date(u2);
            
            
            try {
                     
                Connection con = databaseconnection.getConnection();
                String sql= "select * from lending_book where borrow_date BETWEEN ? and ?";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setDate(1, fromDate);
                ps.setDate(2,  toDate);
                
                ResultSet rs= ps.executeQuery();
                
                while(rs.next()){
                        String id          =rs.getString("id");
                        String bookName   = rs.getString("book_name");
                        String studentName = rs.getString("student_name");
                        String lendingDate       = rs.getString("borrow_date");
                        String returnDate      = rs.getString("return_book_datte");
                        String status       = rs.getString("status");
                        
                        
                        Object[] obj= {id,bookName,studentName,lendingDate,returnDate,status};
                        
                        model =(DefaultTableModel)tbl_borrowBookDetails.getModel();
                        model.addRow(obj);
                                        
                    
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Error");
            }
            
        }
    
    
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        date_lendingDate = new rojeru_san.componentes.RSDateChooser();
        jLabel13 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        date_returndate = new rojeru_san.componentes.RSDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_borrowBookDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel6.setText("  View All Record");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 310, 120));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 350, 5));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Lending Date :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, 60));

        date_lendingDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_lendingDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_lendingDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_lendingDate.setPlaceholder("Select Lending Date ..");
        jPanel1.add(date_lendingDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 290, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Return Date :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 160, 60));

        kButton1.setText("Search");
        kButton1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        kButton1.setkBorderRadius(40);
        kButton1.setkEndColor(new java.awt.Color(51, 51, 255));
        kButton1.setkHoverEndColor(new java.awt.Color(0, 255, 255));
        kButton1.setkHoverForeGround(new java.awt.Color(51, 51, 51));
        kButton1.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        kButton1.setkSelectedColor(new java.awt.Color(0, 204, 204));
        kButton1.setkStartColor(new java.awt.Color(0, 255, 255));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 140, -1));

        jPanel8.setBackground(new java.awt.Color(255, 51, 51));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("x");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, -1, 50));

        jPanel10.setBackground(new java.awt.Color(255, 51, 51));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel10.setText("Back");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        date_returndate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_returndate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_returndate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_returndate.setPlaceholder("Select Lending Date ..");
        jPanel1.add(date_returndate, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, 290, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 280));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_borrowBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Name", "Student Name", "Lending Date", "Return Date", "Status"
            }
        ));
        tbl_borrowBookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_borrowBookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_borrowBookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_borrowBookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_borrowBookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_borrowBookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_borrowBookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_borrowBookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_borrowBookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_borrowBookDetails.setRowHeight(40);
        tbl_borrowBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_borrowBookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_borrowBookDetails);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 320));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1200, 580));

        setSize(new java.awt.Dimension(1200, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_borrowBookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_borrowBookDetailsMouseClicked

    }//GEN-LAST:event_tbl_borrowBookDetailsMouseClicked

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
           clearTable();
           search();
    }//GEN-LAST:event_kButton1ActionPerformed

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked

        Home h=new Home();
        h.show();
        this.hide();

    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
         Home h= new Home();
         h.show();
         this.hide();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewAllRecord().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_lendingDate;
    private rojeru_san.componentes.RSDateChooser date_returndate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KButton kButton1;
    private rojeru_san.complementos.RSTableMetro tbl_borrowBookDetails;
    // End of variables declaration//GEN-END:variables
}
