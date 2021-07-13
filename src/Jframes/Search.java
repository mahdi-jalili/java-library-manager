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

    //method to find books with the book_name
    public void searchBook() {
        //Variables of class : bookname for bookname, writer for writername
        String bookname = txt_searchbook.getText();

        try {
            Connection con = databaseconnection.getConnection();
            //used query for bookname in book_details table
            String sql = "select book_name from book_details where book_name like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + bookname + "%");

            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tbl_bookSearch.getModel();

            while (tbl_bookSearch.getRowCount() > 0) {
                model.removeRow(0);
            }

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("book_name")});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }

    }

    //peyda kardane ketab az roye name nevisande   
    public void searchWriter() {

        String writer = txt_searchwriter.getText();

        try {
            Connection con = databaseconnection.getConnection();
            String sql = "select writer from book_details where writer like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + writer + "%");

            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tbl_writerSearch1.getModel();

            while (tbl_writerSearch1.getRowCount() > 0) {
                model.removeRow(0);
            }

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("writer")});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_writerSearch1 = new rojerusan.RSTableMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        SearchByAutherName = new rojerusan.RSMaterialButtonCircle();
        SearchbyBookName = new rojerusan.RSMaterialButtonCircle();

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

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Which Auther :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 130, 50));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Which Book :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 120, 50));

        txt_searchbook.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_searchbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchbookActionPerformed(evt);
            }
        });
        jPanel1.add(txt_searchbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 230, 40));

        txt_searchwriter.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_searchwriter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchwriterActionPerformed(evt);
            }
        });
        jPanel1.add(txt_searchwriter, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 240, 40));

        tbl_bookSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Name"
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 470, 340));

        tbl_writerSearch1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Writer"
            }
        ));
        tbl_writerSearch1.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_writerSearch1.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_writerSearch1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_writerSearch1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbl_writerSearch1.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_writerSearch1.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_writerSearch1.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_writerSearch1.setRowHeight(40);
        jScrollPane2.setViewportView(tbl_writerSearch1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 490, 340));

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

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 140, 50));

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
        jLabel4.setText("   Search Books");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 210, 80));

        SearchByAutherName.setBackground(new java.awt.Color(255, 51, 51));
        SearchByAutherName.setText("Search");
        SearchByAutherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchByAutherNameActionPerformed(evt);
            }
        });
        jPanel1.add(SearchByAutherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 140, 110, 60));

        SearchbyBookName.setBackground(new java.awt.Color(255, 51, 51));
        SearchbyBookName.setText("Search");
        SearchbyBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchbyBookNameActionPerformed(evt);
            }
        });
        jPanel1.add(SearchbyBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 110, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 10, 1240, 610));

        setSize(new java.awt.Dimension(1200, 600));
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

    private void SearchByAutherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchByAutherNameActionPerformed
        searchWriter();
    }//GEN-LAST:event_SearchByAutherNameActionPerformed

    private void SearchbyBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbyBookNameActionPerformed
        searchBook();
    }//GEN-LAST:event_SearchbyBookNameActionPerformed

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
    private rojerusan.RSMaterialButtonCircle SearchByAutherName;
    private rojerusan.RSMaterialButtonCircle SearchbyBookName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro tbl_bookSearch;
    private rojerusan.RSTableMetro tbl_writerSearch1;
    private app.bolivia.swing.JCTextField txt_searchbook;
    private app.bolivia.swing.JCTextField txt_searchwriter;
    // End of variables declaration//GEN-END:variables
}
