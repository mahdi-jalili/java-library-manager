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
public class returnBook extends javax.swing.JFrame {

    /**
     * Creates new form LendingBook
     */
    public returnBook() {
        initComponents();
    }

    //this method get bookId and studentId from admin show status of book and student
    public void getLendingBookDetails() {
        String bookName = txt_bookName.getText();
        int studentId = Integer.parseInt(txt_studentId.getText());

        try {
            Connection con = databaseconnection.getConnection();
            //query used for get all status of book in lending_book
            String sql = "select * from lending_book where book_name = ? and student_id = ? and status = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bookName);
            ps.setInt(2, studentId);
            //this means the student has not return the book yet
            ps.setString(3, "pending");

            ResultSet rs = ps.executeQuery();

            //set all of status of book in textboxes and show for admin
            if (rs.next()) {
                lbl_borrowid.setText(rs.getString("id"));
                lbl_bookname.setText(rs.getString("book_name"));
                lbl_studentname.setText(rs.getString("student_name"));
                lbl_borrowdate.setText(rs.getString("borrow_date"));
                lbl_returndate.setText(rs.getString("return_book_datte"));
                lbl_borrowstatus.setText(rs.getString("status"));

                lbl_bookError1.setText("");

            } else {

                lbl_bookError1.setText("No Record Found");

                lbl_borrowid.setText("");
                lbl_bookname.setText("");
                lbl_studentname.setText("");
                lbl_borrowdate.setText("");
                lbl_returndate.setText("");
                lbl_borrowstatus.setText("");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }

    }

    //this method will returned book by admin
    public boolean returnBook() {
        String bookName = txt_bookName.getText();
        int studentId = Integer.parseInt(txt_studentId.getText());

        //make a variable for result
        boolean isReturned = false;

        //this converted status of book from pending to returned and show all information for admin
        try {
            Connection con = databaseconnection.getConnection();
            //query used for update all status of book and srudent in lending_book
            String sql = "update lending_book set status = ? where book_name =? and student_id = ? and status = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Returned");
            ps.setString(2, bookName);
            ps.setInt(3, studentId);
            ps.setString(4, "pending");

            int rowCount = ps.executeUpdate();

            if (rowCount > 0) {
                isReturned = true;

            } else {
                isReturned = false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "Error");
        }
        return isReturned;
    }

    //this method update number of book count
    public void updateBookCount() {

        String bookName = txt_bookName.getText();

        try {
            Connection con = databaseconnection.getConnection();
            //query used for update quantity of book in book_details table
            String sql = "update book_details set quantity = quantity + 1 where book_name = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bookName);

            int rowCount = ps.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "Book count Updated");

            } else {
                JOptionPane.showMessageDialog(this, "Can not update the Book count");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }

    }

    //this method will able to admin to set a "10 days" deadline for return_book date for any student
    public void Extention() {
        String bookName = txt_bookName.getText();
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = databaseconnection.getConnection();
            //query used for update return_book date and plus date 10 days in book_details table 
            String sql = "UPDATE lending_book SET return_book_datte=DATE_ADD(return_book_datte, INTERVAL 10 DAY) WHERE book_name=? AND student_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bookName);
            ps.setInt(2, studentId);

            int rowCount = ps.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "Return Date Updated");
                getLendingBookDetails();
            } else {
                JOptionPane.showMessageDialog(this, "Can not update the Return Date");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
        }
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
        jLabel2 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_bookName = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
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
        lbl_returndate = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        lbl_borrowid = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lbl_borrowdate = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbl_borrowstatus = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        lbl_bookError1 = new javax.swing.JLabel();
        Extention = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("  Return Book");
        main_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 280, 100));

        jPanel17.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        main_panel.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 280, 5));

        jPanel18.setBackground(new java.awt.Color(255, 51, 51));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 80, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        main_panel.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 140, 50));

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
        main_panel.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 340, 300, 40));

        txt_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_bookName.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_bookName.setPlaceholder("Enter Name Of Book You Want Return...");
        txt_bookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookNameFocusLost(evt);
            }
        });
        txt_bookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookNameActionPerformed(evt);
            }
        });
        main_panel.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 250, 300, 40));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Enter Book Name :");
        main_panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 200, 180, 60));

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("Enter Student Id :");
        main_panel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 300, 160, 60));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel10.setText("  Book Details");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, 120));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 240, 10));

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

        lbl_returndate.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_returndate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_returndate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 220, 40));

        lbl_studentname.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 220, 40));

        jLabel41.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Student Name :");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 150, 40));

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Book Name :");
        jPanel7.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 120, 40));

        lbl_bookname.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 130, 40));

        lbl_borrowid.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_borrowid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_borrowid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 150, 40));

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Borrow id :");
        jPanel7.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 120, 40));

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Status :");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 130, 40));

        jLabel39.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Borrow Date :");
        jPanel7.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 130, 40));

        lbl_borrowdate.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_borrowdate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_borrowdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 220, 40));

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Return Date :");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 130, 40));

        lbl_borrowstatus.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_borrowstatus.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_borrowstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 150, 40));

        main_panel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 300, 600));

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

        main_panel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-2.png"))); // NOI18N
        main_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 60, 590, 490));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("REturn Book");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        main_panel.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 470, 270, 60));

        lbl_bookError1.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError1.setForeground(new java.awt.Color(255, 204, 0));
        main_panel.add(lbl_bookError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 300, 40));

        Extention.setBackground(new java.awt.Color(102, 102, 255));
        Extention.setText("Extension");
        Extention.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtentionActionPerformed(evt);
            }
        });
        main_panel.add(Extention, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 530, 270, 60));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(102, 102, 255));
        rSMaterialButtonCircle1.setText("find ");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        main_panel.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 410, 270, 60));

        getContentPane().add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));

        setSize(new java.awt.Dimension(1200, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked

        Home h = new Home();
        h.show();
        this.hide();

    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel18MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_bookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookNameFocusLost


    }//GEN-LAST:event_txt_bookNameFocusLost

    private void txt_bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed

        getLendingBookDetails();


    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if (returnBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Returned Successfuly");
            updateBookCount();
        } else {
            JOptionPane.showMessageDialog(this, "Book Returnned Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void ExtentionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtentionActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Please pay attention that you must extention the return date just one time for user");
        Extention();
    }//GEN-LAST:event_ExtentionActionPerformed

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
            java.util.logging.Logger.getLogger(returnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returnBook().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Extention;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_bookError1;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_borrowdate;
    private javax.swing.JLabel lbl_borrowid;
    private javax.swing.JLabel lbl_borrowstatus;
    private javax.swing.JLabel lbl_returndate;
    private javax.swing.JLabel lbl_studentname;
    private javax.swing.JPanel main_panel;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookName;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
