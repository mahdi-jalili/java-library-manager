package Jframes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sina
 */
public class Search extends javax.swing.JFrame {

    /**
     * Creates new form Search
     */
    public Search() {
        initComponents();
    }

    //peyda kardane ketab az roye name ketab
    public void searchBook() {

        String bookName = txt_searchbook.getText();
        String writer = txt_searchwriter.getText();

        try {
            Connection con = databaseconnection.getConnection();
            String sql = "select * from book_details where Book_name like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + bookName + "%");

            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tbl_bookSearch.getModel();

            while (tbl_bookSearch.getRowCount() > 0) {
                model.removeRow(0);
            }

            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookNamee = rs.getString("Book_name");
                String writerr = rs.getString("writer");
                String quantity = rs.getString("quantity");

                Object[] obj = {bookId, bookNamee, writerr, quantity};
                model.addRow(obj);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }

    }

    //peyda kardane ketab az roye name nevisande   
    public void searchWriter() {

        String bookName = txt_searchbook.getText();
        String writer = txt_searchwriter.getText();

        try {
            Connection con = databaseconnection.getConnection();
            String sql = "select * from book_details where writer like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + writer + "%");

            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tbl_bookSearch.getModel();

            while (tbl_bookSearch.getRowCount() > 0) {
                model.removeRow(0);
            }

            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookNamee = rs.getString("Book_name");
                String writerr = rs.getString("writer");
                String quantity = rs.getString("quantity");

                Object[] obj = {bookId, bookNamee, writerr, quantity};
                model.addRow(obj);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_searchbook = new app.bolivia.swing.JCTextField();
        txt_searchwriter = new app.bolivia.swing.JCTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bookSearch = new rojerusan.RSTableMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Borrow = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(102, 102, 255));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel9.setText("Back");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel1.setText("go to this page");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 470, 130, 30));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("Which Book :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 120, 50));

        txt_searchbook.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_searchbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchbookActionPerformed(evt);
            }
        });
        jPanel1.add(txt_searchbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 330, 40));

        txt_searchwriter.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_searchwriter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchwriterActionPerformed(evt);
            }
        });
        jPanel1.add(txt_searchwriter, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 360, 40));

        tbl_bookSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Writer", "Quantity"
            }
        ));
        tbl_bookSearch.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookSearch.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookSearch.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookSearch.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbl_bookSearch.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookSearch.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookSearch.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookSearch.setRowHeight(40);
        jScrollPane1.setViewportView(tbl_bookSearch);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 860, 340));

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("x");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 80, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 140, 50));

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

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 370, 5));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("   Search Box");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 210, 80));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel5.setText("Which Auther :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 130, 50));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel6.setText("If You Want");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 420, 80, 30));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel7.setText("get any Book ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 440, 100, 40));

        Borrow.setBackground(new java.awt.Color(255, 51, 51));
        Borrow.setText("get book");
        Borrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BorrowMouseClicked(evt);
            }
        });
        jPanel1.add(Borrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 500, 140, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 610));

        setSize(new java.awt.Dimension(1235, 611));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked

        Home_user h = new Home_user();
        h.show();
        this.hide();

    }//GEN-LAST:event_jPanel8MouseClicked

    private void txt_searchbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchbookActionPerformed

        searchBook();

    }//GEN-LAST:event_txt_searchbookActionPerformed

    private void txt_searchwriterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchwriterActionPerformed
          searchWriter();
    }//GEN-LAST:event_txt_searchwriterActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void BorrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BorrowMouseClicked

        LendingBookUser l = new LendingBookUser();
        l.show();
        this.hide();
    }//GEN-LAST:event_BorrowMouseClicked

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
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Borrow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSTableMetro tbl_bookSearch;
    private app.bolivia.swing.JCTextField txt_searchbook;
    private app.bolivia.swing.JCTextField txt_searchwriter;
    // End of variables declaration//GEN-END:variables
}
