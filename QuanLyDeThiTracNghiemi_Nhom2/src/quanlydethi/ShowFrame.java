/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlydethi;

import CTDL.CauHoi;
import static CTDL.CauHoi.MULTI;
import static CTDL.CauHoi.YESNO;
import CTDL.MonHoc;
import functions.DBConection;
import static functions.DBConection.layKetNoi;
import functions.Modify;
import static functions.Modify.layDanhSachMonHoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HUYENKUTE
 */
public class ShowFrame extends javax.swing.JFrame {

    /**
     * Creates new form TaoMoiCauHoiYesNO
     */
    public static CauHoi cauHoiDangChon = null;
    public static MonHoc monDangChon = null;
    public static ArrayList<MonHoc> DsMonHoc;
    public static ArrayList<CauHoi> DsCauHoi;
    public static String maCauHoi;
    public static String loaiCauHoiDangXem = YESNO;
    public static JTable jTable_DSCHYN;
    public static JTable jTable_DSCHNLC;

    public void LoadDsMonHoc() {
        DsMonHoc = layDanhSachMonHoc(DangNhapForm.giangvien.getMaGV());
        monDangChon = DsMonHoc.get(0);
        combobox_MonHOc.removeAll();
        for (MonHoc x : DsMonHoc) {
            combobox_MonHOc.addItem(x.getTenMH());
        }
    }

    public void LoadCauHoiRaBang() {
        DsCauHoi = Modify.LayDsCauHoiCuaMon(monDangChon.getMaMH());
        DefaultTableModel model1 = new DefaultTableModel();
        DefaultTableModel model2 = new DefaultTableModel();

        model1.addColumn("ID Câu Hỏi");
        model2.addColumn("ID Câu Hỏi");
        model1.addColumn("Nội Dung");
        model2.addColumn("Nội Dung");
        model1.addColumn("Trình Độ");
        model2.addColumn("Trình Độ");

        Vector vec;
        for (CauHoi x : DsCauHoi) {

            vec = new Vector();
            vec.add(x.getMaCH());
            vec.add(x.getNoiDung());
            vec.add(x.getTrinhDo());
            if (x.getLoai().equals(YESNO)) {
                model1.addRow(vec);
            } else {
                model2.addRow(vec);
            }
        }

        jTable_DSCauHoiYesNo.setModel(model1);
        jTable_DSCauHoiNhieuLC.setModel(model2);
    }

    public ShowFrame() {
        initComponents();
        LoadDsMonHoc();
        LoadCauHoiRaBang();
        txt_MaGV.setText(DangNhapForm.giangvien.getMaGV());
        btn_XemCauHoi.setEnabled(false);
        btn_XoaCauHoi.setEnabled(false);
        txt_MaGV.setEditable(false);
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
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_MaGV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        combobox_MonHOc = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_ID_CauHoiDangChon = new javax.swing.JTextField();
        btn_XemCauHoi = new javax.swing.JButton();
        btn_ThemCauHoi = new javax.swing.JButton();
        btn_XoaCauHoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel_BangCauHoi = new javax.swing.JPanel();
        jTabbedPane_CauHoi = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_DSCauHoiYesNo = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_DSCauHoiNhieuLC = new javax.swing.JTable();

        setTitle("Quản Lý Câu Hỏi");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(1300, 700));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 204))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 600));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã Giảng Viên:");

        txt_MaGV.setBackground(new java.awt.Color(204, 204, 255));
        txt_MaGV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_MaGV.setForeground(new java.awt.Color(0, 0, 204));
        txt_MaGV.setText("GV001");

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Môn học:");

        combobox_MonHOc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combobox_MonHOc.setForeground(new java.awt.Color(0, 0, 204));
        combobox_MonHOc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobox_MonHOcItemStateChanged(evt);
            }
        });
        combobox_MonHOc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combobox_MonHOcMouseClicked(evt);
            }
        });
        combobox_MonHOc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_MonHOcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combobox_MonHOc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_MaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_MaGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combobox_MonHOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));

        jLabel5.setBackground(new java.awt.Color(0, 51, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("ID câu hỏi:");

        txt_ID_CauHoiDangChon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_ID_CauHoiDangChon.setText("001");
        txt_ID_CauHoiDangChon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_ID_CauHoiDangChonFocusLost(evt);
            }
        });

        btn_XemCauHoi.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_XemCauHoi.setText("XEM");
        btn_XemCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XemCauHoiActionPerformed(evt);
            }
        });

        btn_ThemCauHoi.setBackground(new java.awt.Color(0, 0, 102));
        btn_ThemCauHoi.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_ThemCauHoi.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThemCauHoi.setText("THÊM MỘT CÂU HỎI");
        btn_ThemCauHoi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ThemCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemCauHoiActionPerformed(evt);
            }
        });

        btn_XoaCauHoi.setBackground(new java.awt.Color(153, 0, 0));
        btn_XoaCauHoi.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_XoaCauHoi.setForeground(new java.awt.Color(255, 255, 255));
        btn_XoaCauHoi.setText("XÓA CÂU HỎI NÀY");
        btn_XoaCauHoi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_XoaCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaCauHoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ID_CauHoiDangChon, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_XemCauHoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_XoaCauHoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ThemCauHoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ID_CauHoiDangChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_XemCauHoi))
                .addGap(31, 31, 31)
                .addComponent(btn_XoaCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_ThemCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Câu Hỏi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel_BangCauHoi.setBackground(new java.awt.Color(153, 153, 255));
        jPanel_BangCauHoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 255, 204), new java.awt.Color(204, 204, 0), new java.awt.Color(51, 102, 0), new java.awt.Color(51, 51, 0)));

        jTabbedPane_CauHoi.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane_CauHoi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane_CauHoi.setForeground(new java.awt.Color(0, 0, 153));
        jTabbedPane_CauHoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTabbedPane_CauHoi.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane_CauHoiStateChanged(evt);
            }
        });
        jTabbedPane_CauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane_CauHoiMouseClicked(evt);
            }
        });

        jTable_DSCauHoiYesNo.setBackground(new java.awt.Color(51, 204, 255));
        jTable_DSCauHoiYesNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable_DSCauHoiYesNo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_DSCauHoiYesNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DSCauHoiYesNoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_DSCauHoiYesNo);

        jTabbedPane_CauHoi.addTab("LOẠI YES/NO", jScrollPane2);

        jTable_DSCauHoiNhieuLC.setBackground(new java.awt.Color(51, 204, 255));
        jTable_DSCauHoiNhieuLC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable_DSCauHoiNhieuLC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_DSCauHoiNhieuLC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DSCauHoiNhieuLCMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_DSCauHoiNhieuLC);

        jTabbedPane_CauHoi.addTab("LOẠI NHIỀU PHƯƠNG ÁN", jScrollPane3);

        javax.swing.GroupLayout jPanel_BangCauHoiLayout = new javax.swing.GroupLayout(jPanel_BangCauHoi);
        jPanel_BangCauHoi.setLayout(jPanel_BangCauHoiLayout);
        jPanel_BangCauHoiLayout.setHorizontalGroup(
            jPanel_BangCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jTabbedPane_CauHoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jPanel_BangCauHoiLayout.setVerticalGroup(
            jPanel_BangCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_BangCauHoiLayout.createSequentialGroup()
                .addComponent(jTabbedPane_CauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_BangCauHoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel_BangCauHoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1204, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_XemCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XemCauHoiActionPerformed
        // TODO add your handling code here:
        if (txt_ID_CauHoiDangChon.getText().toString().trim().isEmpty()) {
            return;
        }
        if (loaiCauHoiDangXem.equals(YESNO)) {
            XemCauHoiYesNO quanly = new XemCauHoiYesNO("CHI TIẾT CÂU HỎI "+cauHoiDangChon.getMaCH());
            quanly.setVisible(true);
        } else {
            XemCauHoiMulti quanly = new XemCauHoiMulti("CHI TIẾT CÂU HỎI "+cauHoiDangChon.getMaCH());
            quanly.setVisible(true);
        }
    }//GEN-LAST:event_btn_XemCauHoiActionPerformed

    private void jTabbedPane_CauHoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane_CauHoiMouseClicked
        // TODO add your handling code here:
        System.out.println(jTabbedPane_CauHoi.getSelectedIndex());
        if (jTabbedPane_CauHoi.getSelectedIndex() == 1) {
            loaiCauHoiDangXem = MULTI;
        } else {
            loaiCauHoiDangXem = YESNO;
        }

    }//GEN-LAST:event_jTabbedPane_CauHoiMouseClicked

    private void combobox_MonHOcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combobox_MonHOcMouseClicked
        // TODO add your handling code here:

        monDangChon = DsMonHoc.get(combobox_MonHOc.getSelectedIndex());
        LoadCauHoiRaBang();
    }//GEN-LAST:event_combobox_MonHOcMouseClicked

    private void combobox_MonHOcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_MonHOcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_MonHOcActionPerformed

    private void combobox_MonHOcItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_MonHOcItemStateChanged
        // TODO add your handling code here:         
        monDangChon = DsMonHoc.get(combobox_MonHOc.getSelectedIndex());
        LoadCauHoiRaBang();
        txt_ID_CauHoiDangChon.setText("");
        cauHoiDangChon = null;

        btn_XemCauHoi.setEnabled(false);
        btn_XoaCauHoi.setEnabled(false);

    }//GEN-LAST:event_combobox_MonHOcItemStateChanged

    private void txt_ID_CauHoiDangChonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ID_CauHoiDangChonFocusLost
        // TODO add your handling code here:

        String res = txt_ID_CauHoiDangChon.getText().toString().trim();
        if (res.isEmpty()) {
            txt_ID_CauHoiDangChon.setText("");
            return;
        }
        CauHoi check = Modify.TimKiemCauHoi(Integer.parseInt(res));
        if (check == null) {
            JOptionPane.showMessageDialog(null, "ID câu hỏi không tồn tại!!! ", "Thông báo", WARNING_MESSAGE);
            if (cauHoiDangChon != null) {
                txt_ID_CauHoiDangChon.setText(cauHoiDangChon.getMaCH() + "");
            } else {
                txt_ID_CauHoiDangChon.setText("");

                btn_XemCauHoi.setEnabled(false);
                btn_XoaCauHoi.setEnabled(false);

            }
            txt_ID_CauHoiDangChon.requestFocus();

        } else {
            cauHoiDangChon = check;
        }
        btn_XemCauHoi.setEnabled(true);
        btn_XoaCauHoi.setEnabled(true);


    }//GEN-LAST:event_txt_ID_CauHoiDangChonFocusLost

    private void jTable_DSCauHoiYesNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DSCauHoiYesNoMouseClicked
        // TODO add your handling code here:
        int index = jTable_DSCauHoiYesNo.getSelectedRow();
        index = Integer.parseInt(jTable_DSCauHoiYesNo.getModel().getValueAt(index, 0).toString());
        cauHoiDangChon = Modify.TimKiemCauHoi(index);
        txt_ID_CauHoiDangChon.setText(cauHoiDangChon.getMaCH() + "");

        btn_XemCauHoi.setEnabled(true);
        btn_XoaCauHoi.setEnabled(true);
    }//GEN-LAST:event_jTable_DSCauHoiYesNoMouseClicked

    private void jTable_DSCauHoiNhieuLCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DSCauHoiNhieuLCMouseClicked
        // TODO add your handling code here:

        int index = jTable_DSCauHoiNhieuLC.getSelectedRow();
        index = Integer.parseInt(jTable_DSCauHoiNhieuLC.getModel().getValueAt(index, 0).toString());
        cauHoiDangChon = Modify.TimKiemCauHoi(index);
        txt_ID_CauHoiDangChon.setText(cauHoiDangChon.getMaCH() + "");
        btn_XemCauHoi.setEnabled(true);
        btn_XoaCauHoi.setEnabled(true);
    }//GEN-LAST:event_jTable_DSCauHoiNhieuLCMouseClicked
    //==================================================XOA CAUHOI========================================================
    //xét điều kiện xóa
    private void xoaCH(String maCH) {
        Connection kn = layKetNoi();
        String sql1 = "delete from LUACHON where MACH = ?";
        try {
            PreparedStatement ps = kn.prepareStatement(sql1);
            ps.setString(1, maCH);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ShowFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "delete from CAUHOI where MACH = ?";
        try {
            PreparedStatement ps = kn.prepareStatement(sql);
            ps.setString(1, maCH);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ShowFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean checkMaCH(String maCH) {
        boolean kt = true;
        String pattern = "^[0-9]+$";
        if (txt_ID_CauHoiDangChon.getText().equals("")) {
            return false;
        } else if (!txt_ID_CauHoiDangChon.getText().matches(pattern)) {
            //khong hợp lệ;
            return false;
        }
        return kt;
    }

    private boolean kiemTraCHTonTai(String maCH) {
        String temp;
        boolean kt = false;
        String maCHoi = txt_ID_CauHoiDangChon.getText();
        Connection kn = layKetNoi();
        if (maCH.equals("") == true) {
            if (checkMaCH(maCHoi) == false) {
                kt = false;
            }
        } else {
            try {
                Statement st = kn.createStatement();
//                PreparedStatement ps = kn.prepareStatement("select * from CAUHOI");
//                ResultSet rs = ps.executeQuery();
                ResultSet rs = st.executeQuery("select * from CAUHOI");
                while (rs.next()) {
                    temp = rs.getString("MACH");
                    if (temp.equals(maCH) == true) {
                        kt = true;
                        break;
                    }
                }
                rs.close();
//                ps.close();
                st.close();
                kn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ShowFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (kt == false) {
                JOptionPane.showMessageDialog(this, "Câu hỏi này không tồn tại!");
            } else {
                try {
                    kn = layKetNoi();
                    PreparedStatement ps = kn.prepareStatement("select * from CTDETHI where MACH = '" + maCH + "'");
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        kt = false;
                    }
                    rs.close();
                    ps.close();
                    kn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ShowFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (kt == false) {
                    JOptionPane.showMessageDialog(this, "Không thể xóa câu hỏi này!");
                }
            }
        }
        return kt;
    }

    private void btn_XoaCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaCauHoiActionPerformed
        // TODO add your handling code here:
        // XÓA CÂU HỎI ĐANG CHỌN
        // XÓA CÂU HỎI ĐANG CHỌN
        String maCH = txt_ID_CauHoiDangChon.getText();
        boolean kt = true;
        kt = kiemTraCHTonTai(maCH);
        if (kt == true) {
            int selected = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa câu"
                    + " hỏi này không", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
            if (selected == JOptionPane.YES_NO_OPTION) {
                xoaCH(maCH);
                LoadCauHoiRaBang();
                txt_ID_CauHoiDangChon.setEditable(false);
                JOptionPane.showMessageDialog(this, "Xóa câu hỏi thành công!");
                Modify.BoDeNguon.remove(Modify.TimKiemCauHoi(Integer.parseInt(maCH)));
                LoadCauHoiRaBang();
            }
        }
    }//GEN-LAST:event_btn_XoaCauHoiActionPerformed

    private void jTabbedPane_CauHoiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane_CauHoiStateChanged
        // TODO add your handling code here:
        System.out.println(jTabbedPane_CauHoi.getSelectedIndex());
        if (jTabbedPane_CauHoi.getSelectedIndex() == 1) {
            loaiCauHoiDangXem = MULTI;
        } else {
            loaiCauHoiDangXem = YESNO;
        }
    }//GEN-LAST:event_jTabbedPane_CauHoiStateChanged

    private void btn_ThemCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemCauHoiActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:

        if (loaiCauHoiDangXem.equals(YESNO)) {
            TaoMoiCauHoiYesNO quanly = new TaoMoiCauHoiYesNO("Tạo Một Câu Hỏi Mới Loại ĐÚNG/SAI");
            quanly.setVisible(true);
        } else {
            TaoMoiCauHoiMulti quanly = new TaoMoiCauHoiMulti("Tạo Một Câu Hỏi Mới Loại NHIỀU LỰA CHỌN");
            quanly.setVisible(true);
        }
//        this.setVisible(false);

    }//GEN-LAST:event_btn_ThemCauHoiActionPerformed

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
            java.util.logging.Logger.getLogger(ShowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ThemCauHoi;
    private javax.swing.JButton btn_XemCauHoi;
    private javax.swing.JButton btn_XoaCauHoi;
    private javax.swing.JComboBox<String> combobox_MonHOc;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel_BangCauHoi;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane_CauHoi;
    private javax.swing.JTable jTable_DSCauHoiNhieuLC;
    private javax.swing.JTable jTable_DSCauHoiYesNo;
    private javax.swing.JTextField txt_ID_CauHoiDangChon;
    private javax.swing.JTextField txt_MaGV;
    // End of variables declaration//GEN-END:variables
}
