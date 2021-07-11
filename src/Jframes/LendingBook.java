
package Jframes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author sina
 */
public class LendingBook extends javax.swing.JFrame {

    /**
     * Creates new form LendingBook
     */
    public LendingBook() {
        initComponents();
    }
    
    
    
    
    
    
    
    
    
    
    //for give information from database and display that in bookdetail text field
    
    public void getBookDetail(){
        
        int bookId = Integer.parseInt(txt_bookId.getText());
        
        try{
            Connection con= databaseconnection.getConnection();
            
            PreparedStatement ps= con.prepareStatement("select * from book_details where book_id= ?");
            ps.setInt(1,bookId);
            ResultSet rs= ps.executeQuery();
            
            if(rs.next()){
                lbl_bookid.setText(rs.getString("book_id"));
                lbl_bookname.setText(rs.getString("book_name"));
                lbl_writer.setText(rs.getString("writer"));
                lbl_quantity.setText(rs.getString("quantity"));
                
                
            }
            else{
                lbl_bookError1.setText("invalid Book id");
            }
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error");
        }
    }
    
    
        
    //for give information from database and display that in bookdetail text field
    
    public void getStudentDetail(){
        
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try{
            Connection con= databaseconnection.getConnection();
            
            PreparedStatement ps= con.prepareStatement("select * from student_details where student_id= ?");
            ps.setInt(1,studentId);
            ResultSet rs= ps.executeQuery();
            
            if(rs.next()){
                lbl_studentid.setText(rs.getString("student_id"));
                lbl_studentname.setText(rs.getString("name"));
                lbl_cours.setText(rs.getString("cours"));
                lbl_branch.setText(rs.getString("branch"));
                
                
            }
            else{
                lbl_studentError.setText("invalid Student id");
            }
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error");
        }
    }
    
    
    
    public boolean lendingBook(){
        
        boolean isborrow = false;
        
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        String bookName=  lbl_bookname.getText();
        String studentName= lbl_studentname.getText();
        
        // bayad baraye estefade az class Date ketabkhoneye Date dar java.util ro import konim aval . 
        //chon chizi ke on ghesmate taeiin konnade tarikh return mikone jozve date hastesh
        //va baraye daryaft khoroji on az method getDatefecha estefade mishe
        Date lendingDate = date_lendingDate.getDatoFecha();
        Date returnDate  = date_returnDate.getDatoFecha();
        
        //chon date marbot be sql bayad az noe hamon sql bashe taghruban ye castt darim inja 
        //chin java.sql.date long migire inkaro kardim
        
        Long d1= lendingDate.getTime();
        Long d2= returnDate.getTime();
        
        java.sql.Date slendingDate = new java.sql.Date(d1);
        java.sql.Date sreturnDate = new java.sql.Date(d2);
        
        try {
              Connection con = databaseconnection.getConnection();
              String sql = "insert into lending_book(book_id , book_name , student_id , student_name , borrow_date , return_book_datte , status) values(?,?,?,?,?,?,?)";
              PreparedStatement ps= con.prepareStatement(sql);
              
              ps.setInt(1,bookId);
              ps.setString(2,bookName);
              ps.setInt(3, studentId);
              ps.setString(4, studentName);
              ps.setDate(5,slendingDate);
              ps.setDate(6, sreturnDate);
              ps.setString(7,"pending");
              
              int rowCount = ps.executeUpdate();
              
              if (rowCount > 0 ) {
                            isborrow= true;
            }
              else{
                            isborrow= false;
              }
              
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(this,"Error");
        }
        return isborrow;
    }
    
   
    // update number of book count
    public void updateBookcount(){
        
                int bookId = Integer.parseInt(txt_bookId.getText());
                
                try {
                         Connection con= databaseconnection.getConnection();
                         String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
                         PreparedStatement ps= con.prepareStatement(sql);
                         ps.setInt(1, bookId);
                         
                         int rowCount = ps.executeUpdate();
                         
               if (rowCount > 0 ) {
                            JOptionPane.showMessageDialog(this,"Book count Updated");
                            //shomare ghabli ro migirim cast mikonim
                            int initialCount = Integer.parseInt(lbl_quantity.getText());
                            //shomare jadid ro jaygozari mikonim  :)
                            lbl_quantity.setText(Integer.toString(initialCount - 1 ));
                            
                            
            }
              else{
                            JOptionPane.showMessageDialog(this,"can not update the Book count");

               }                        
                         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }
        
    }
    
    
//    check wheather book already alocated or not
   
            public boolean isAlreadyBorrow() {
                
                boolean isAlreadyBorrow= false;
                
              int bookId = Integer.parseInt(txt_bookId.getText());
              int studentId = Integer.parseInt(txt_studentId.getText());
             
                try {
                    Connection con= databaseconnection.getConnection();
                    String sql = "select * from lending_book where book_id = ? and student_id =? and status =? ";
                    PreparedStatement ps= con.prepareStatement(sql);
                    ps.setInt(1, bookId);
                    ps.setInt(2, studentId);
                    ps.setString(3, "pending");
                    
                    ResultSet rs = ps.executeQuery();
                    
                    if (rs.next()) {
                        
                        isAlreadyBorrow= true;
                        
                    }else{
                        isAlreadyBorrow= false;
                    }
                    
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error");
                }
                
                return isAlreadyBorrow;
            }
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_writer = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        lbl_bookid = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_bookError1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_studentid = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        lbl_cours = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        date_lendingDate = new rojeru_san.componentes.RSDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        date_returnDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 215, 230, 0));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel5.setText("Back");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 280, 10));

        jPanel11.setBackground(new java.awt.Color(255, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel31.setText("  Student Details");
        jPanel11.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 280, 120));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 350, 5));

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Book Name :");
        jPanel11.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 120, 40));

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 220, 40));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quantity :");
        jPanel11.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 120, 40));

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("writer :");
        jPanel11.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 120, 40));

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Book id :");
        jPanel11.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 120, 40));

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 220, 40));

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 220, 40));

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 220, 40));

        jPanel7.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 420, 810));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 220, 40));

        lbl_writer.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_writer.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_writer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 220, 40));

        jLabel41.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("writer :");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 120, 40));

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Book Name :");
        jPanel7.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 120, 40));

        lbl_bookname.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 220, 40));

        lbl_bookid.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 220, 40));

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Book id :");
        jPanel7.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, 40));

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Quantity :");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 120, 40));

        lbl_bookError1.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError1.setForeground(new java.awt.Color(255, 204, 0));
        jPanel7.add(lbl_bookError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 600, 300, 40));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel6.setText("  Book Details");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 270, 120));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 810));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 810));

        main_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 810));

        jPanel13.setBackground(new java.awt.Color(255, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(102, 102, 255));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel22.setText("Back");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel23.setText("  Book Details");
        jPanel13.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 280, 120));

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Book Name :");
        jPanel13.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 120, 40));

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 220, 40));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity :");
        jPanel13.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 120, 40));

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("writer :");
        jPanel13.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 120, 40));

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Book id :");
        jPanel13.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 120, 40));

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 220, 40));

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 220, 40));

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 220, 40));

        main_panel.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 810));

        jPanel10.setBackground(new java.awt.Color(102, 102, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel14.setText("  Student Details");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, 120));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 290, 5));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Student Name:");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 150, 40));

        lbl_branch.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 220, 40));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Branch :");
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 120, 40));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Cours :");
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 120, 40));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Student id :");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, 40));

        lbl_studentid.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lbl_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 220, 40));

        lbl_studentname.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 180, 40));

        lbl_cours.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_cours.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lbl_cours, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 220, 40));

        lbl_studentError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 204, 0));
        jPanel10.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 610, 300, 40));

        main_panel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 370, 600));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel16.setText("  Student Details");
        main_panel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 280, 120));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("  Lending Book");
        main_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 280, 100));

        jPanel17.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        main_panel.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, 390, 5));

        jPanel18.setBackground(new java.awt.Color(102, 102, 255));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("x");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        main_panel.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 90, 50));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_studentId.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student id...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        main_panel.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 310, 250, 40));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Lending Date :");
        main_panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, 160, 60));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_bookId.setToolTipText("");
        txt_bookId.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book id...");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        main_panel.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 240, 250, 40));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Enter Book Id :");
        main_panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 160, 60));

        date_lendingDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_lendingDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_lendingDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_lendingDate.setPlaceholder("Select Lending Date ..");
        main_panel.add(date_lendingDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 380, 250, -1));

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("Enter Student Id :");
        main_panel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, 160, 60));

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setText("Book Return Date :");
        main_panel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, 180, 60));

        date_returnDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_returnDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_returnDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_returnDate.setPlaceholder("Select Lending Date ..");
        main_panel.add(date_returnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 450, 250, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("Lendiing Book");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        main_panel.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 520, 190, 60));

        getContentPane().add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        setSize(new java.awt.Dimension(1200, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked

        Home h=new Home();
        h.show();
        this.hide();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel18MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
                getStudentDetail();
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        //if(txt_bookId.getText().equals("")){
               getBookDetail();
        
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
      
      if (lbl_quantity.getText().equals("0")){  
              
              JOptionPane.showMessageDialog(this, "This Book Not Availible");
      } else{
          
        if (isAlreadyBorrow() == false) {
                 if (lendingBook() == true) {
                        
                JOptionPane.showMessageDialog(this,"Book inserted successfully");
                updateBookcount();
        }
            else{
                JOptionPane.showMessageDialog(this, "Can not lending the Book");
            }            
        }
        else{
            JOptionPane.showMessageDialog(this,"This Student Already has this Book");
        }
      }
 
            
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         Home h=new Home();
         h.show();
         this.hide();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and femain_panel       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(LendingBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LendingBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LendingBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LendingBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LendingBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_lendingDate;
    private rojeru_san.componentes.RSDateChooser date_returnDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_bookError1;
    private javax.swing.JLabel lbl_bookid;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_cours;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentid;
    private javax.swing.JLabel lbl_studentname;
    private javax.swing.JLabel lbl_writer;
    private javax.swing.JPanel main_panel;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
