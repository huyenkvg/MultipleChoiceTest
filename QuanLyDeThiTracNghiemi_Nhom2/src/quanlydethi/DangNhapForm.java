package quanlydethi;

import CTDL.GiangDay;
import CTDL.GiangVien;
import functions.DBConection;
import static functions.DBConection.layKetNoi;
import static functions.Modify.layDanhSachMonHoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DangNhapForm extends javax.swing.JFrame {
    
    public static GiangVien giangvien = null;
    public static GiangDay giangday = null;
    public DangNhapForm() {
        initComponents();
        this.setTitle("BÀI TẬP QUẢN LÝ ĐỀ THI TRẮC NGHIỆM NHÓM 2");
        jPanelKhungDangNhap.setVisible(true);
        
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelKhungDangNhap = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_User = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonDangNhap = new javax.swing.JButton();
        jButton_Thoat = new javax.swing.JButton();
        jLabelThongBaoThongTinDangNhap = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ứng Dụng Quản Lý Khách Sạn Nhóm [...]");
        setBackground(new java.awt.Color(153, 255, 153));

        jPanel1.setBackground(new java.awt.Color(1, 26, 26));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 460));

        jPanelKhungDangNhap.setBackground(new java.awt.Color(0, 0, 0));
        jPanelKhungDangNhap.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 0), new java.awt.Color(204, 204, 0), new java.awt.Color(204, 204, 0), new java.awt.Color(102, 102, 0)));
        jPanelKhungDangNhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanelKhungDangNhap.setPreferredSize(new java.awt.Dimension(700, 260));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Username:");

        jTextField_User.setBackground(new java.awt.Color(153, 255, 204));
        jTextField_User.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Password:");

        jPasswordField.setBackground(new java.awt.Color(153, 255, 204));

        jButtonDangNhap.setBackground(new java.awt.Color(89, 147, 23));
        jButtonDangNhap.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jButtonDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDangNhap.setText("ĐĂNG NHẬP");
        jButtonDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDangNhapActionPerformed(evt);
            }
        });

        jButton_Thoat.setBackground(new java.awt.Color(204, 102, 0));
        jButton_Thoat.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jButton_Thoat.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Thoat.setText("THOÁT");

        jLabelThongBaoThongTinDangNhap.setForeground(new java.awt.Color(255, 0, 0));
        jLabelThongBaoThongTinDangNhap.setText("   ");

        javax.swing.GroupLayout jPanelKhungDangNhapLayout = new javax.swing.GroupLayout(jPanelKhungDangNhap);
        jPanelKhungDangNhap.setLayout(jPanelKhungDangNhapLayout);
        jPanelKhungDangNhapLayout.setHorizontalGroup(
            jPanelKhungDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhungDangNhapLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanelKhungDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelKhungDangNhapLayout.createSequentialGroup()
                        .addComponent(jButtonDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelKhungDangNhapLayout.createSequentialGroup()
                        .addGroup(jPanelKhungDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelKhungDangNhapLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29))
                            .addGroup(jPanelKhungDangNhapLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanelKhungDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelThongBaoThongTinDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_User, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(jPasswordField))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanelKhungDangNhapLayout.setVerticalGroup(
            jPanelKhungDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhungDangNhapLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanelKhungDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_User, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanelKhungDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelThongBaoThongTinDangNhap)
                .addGap(25, 25, 25)
                .addGroup(jPanelKhungDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(1, 26, 26));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("QUẢN LÝ ĐỀ THI TRẮC NGHIỆM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelKhungDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelKhungDangNhap, 255, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDangNhapActionPerformed
        // TODO add your handling code here:
        String user = jTextField_User.getText();
        char[] temp = jPasswordField.getPassword();
        String pass = String.valueOf(temp);
        boolean kt = false;
        Connection ketNoi = layKetNoi();
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement("SELECT * FROM TAIKHOAN WHERE [TENDANGNHAP] = '" + user + "' AND MATKHAU = '" + pass + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                kt = true;
            }
            rs.close();
            ps.close();
            ketNoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(DangNhapForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (kt == false) {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng!");
            jTextField_User.requestFocus();
            return;
        } else {
            ketNoi = layKetNoi();
            try {
                PreparedStatement ps = ketNoi.prepareStatement("SELECT * FROM GIANGVIEN where MAGV = '" + user + "'");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    giangvien = new GiangVien(rs.getString("MAGV"), rs.getString("HOTEN"),rs.getString("HOCVI"),rs.getString("HOCHAM"),rs.getString("CHUYENMON"), rs.getString("MAKHOA"));
                }
                rs.close();
                ps.close();
                ketNoi.close();
            } catch (SQLException ex) {
                Logger.getLogger(DangNhapForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        
            //======================================================================

            MainFrame main = new MainFrame();

            giangday =  new GiangDay(giangvien, layDanhSachMonHoc(giangvien.getMaGV()));

            main.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jButtonDangNhapActionPerformed

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhapForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDangNhap;
    private javax.swing.JButton jButton_Thoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelThongBaoThongTinDangNhap;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelKhungDangNhap;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextField_User;
    // End of variables declaration//GEN-END:variables
}
