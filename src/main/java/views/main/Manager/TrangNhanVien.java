/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.main.Manager;

import controllers.Manager.KhuVucCtrl;
import controllers.Manager.QuanLiNhanVienCtrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.DataGlobal;
import models.KhuVucModel;
import models.NhanVienModel;

/**
 *
 * @author GIANG
 */
public class TrangNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form TrangNhanVien
     */
    DefaultTableModel tableModel;
    List<NhanVienModel> listWorker = new ArrayList<>();
    
    private int selectedIndex;

    public TrangNhanVien() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) listWorkerTable.getModel();

            hienThiDSNhanVien();
            
            UpdateInfoWorker.setEnabled(false);
            UpdateInfoWorker.setEnabled(false);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLiNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hienThiDSNhanVien() throws ClassNotFoundException {

        listWorker = QuanLiNhanVienCtrl.timTatCaNhanVien();

        tableModel.setRowCount(0);

        listWorker.forEach(nv -> {
            tableModel.addRow(new Object[]{nv.getMANV(), nv.getHOTEN(), nv.getCHUCVU(), nv.getEMAIL(), nv.getSDT(), nv.getGIOITINH(), nv.getMAKHUVUC()});
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        AddWorker = new javax.swing.JButton();
        UpdateInfoWorker = new javax.swing.JButton();
        DeleteWorker = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listWorkerTable = new javax.swing.JTable();
        ReloadPage = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Danh sách nhân viên");

        AddWorker.setBackground(new java.awt.Color(0, 153, 255));
        AddWorker.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddWorker.setForeground(new java.awt.Color(255, 255, 255));
        AddWorker.setText("Thêm nhân viên");
        AddWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddWorkerActionPerformed(evt);
            }
        });

        UpdateInfoWorker.setBackground(new java.awt.Color(0, 153, 255));
        UpdateInfoWorker.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UpdateInfoWorker.setForeground(new java.awt.Color(255, 255, 255));
        UpdateInfoWorker.setText("Sửa thông tin");
        UpdateInfoWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateInfoWorkerActionPerformed(evt);
            }
        });

        DeleteWorker.setBackground(new java.awt.Color(0, 153, 255));
        DeleteWorker.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DeleteWorker.setForeground(new java.awt.Color(255, 255, 255));
        DeleteWorker.setText("Xóa");
        DeleteWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteWorkerActionPerformed(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        listWorkerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ và tên", "Chức vụ", "Email", "Số điện thoại", "Giới tính", "Khu vực làm việc"
            }
        ));
        listWorkerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listWorkerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listWorkerTable);

        ReloadPage.setBackground(new java.awt.Color(0, 153, 255));
        ReloadPage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ReloadPage.setForeground(new java.awt.Color(255, 255, 255));
        ReloadPage.setText("Làm mới");
        ReloadPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReloadPageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddWorker)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateInfoWorker)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DeleteWorker)
                        .addGap(12, 12, 12)
                        .addComponent(ReloadPage)
                        .addGap(9, 9, 9)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(AddWorker)
                    .addComponent(UpdateInfoWorker)
                    .addComponent(DeleteWorker)
                    .addComponent(ReloadPage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(235, 239, 254));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(43, 54, 116));
        jLabel1.setText("Quản lí nhân viên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(5, 205, 153));
        jLabel2.setText("Quản lí tiền nước công ti dịch vụ nước đô thị");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddWorkerActionPerformed
        // TODO add your handling code here:
        // Tạo cửa sổ mới để nhập thông tin người dùng
        ThemNhanVienView addUserWindow = new ThemNhanVienView();

        // Hiển thị cửa sổ AddUser
        addUserWindow.setVisible(true);
        addUserWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            hienThiDSNhanVien();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLiNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddWorkerActionPerformed


    private void UpdateInfoWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateInfoWorkerActionPerformed
        // TODO add your handling code here:
        CapNhatNhanVienView updateWorkerWindow = new CapNhatNhanVienView();

        updateWorkerWindow.setVisible(true);
        updateWorkerWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_UpdateInfoWorkerActionPerformed

    private void DeleteWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteWorkerActionPerformed
        // TODO add your handling code here:

        int selectedIndex = listWorkerTable.getSelectedRow();
        if (selectedIndex >= 0) {
            String[] options = {"Đồng ý", "Thoát"};
            int option = JOptionPane.showOptionDialog(
                    this,
                    "Bạn có chắc muốn xóa nhân viên này",
                    "Cảnh báo",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    options,
                    options[1]
            );

            if (option == 0) {
                try {
                    NhanVienModel nhanvien = listWorker.get(selectedIndex);

                    QuanLiNhanVienCtrl.XoaNhanVien(nhanvien.getEMAIL());
                    hienThiDSNhanVien();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(QuanLiNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_DeleteWorkerActionPerformed

    private void listWorkerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listWorkerTableMouseClicked
        // TODO add your handling code here:

        selectedIndex = listWorkerTable.getSelectedRow();
        
        if (selectedIndex == -1) {
            UpdateInfoWorker.setEnabled(false);
            UpdateInfoWorker.setEnabled(false);
           
        } else {
            UpdateInfoWorker.setEnabled(true);
            UpdateInfoWorker.setEnabled(true);
        }

        // Kiểm tra xem người dùng đã chọn một dòng hợp lệ hay không
        if (selectedIndex >= 0) {
            try {
                // Lấy đối tượng PersonModel từ danh sách listWorker
                NhanVienModel nhanvien = listWorker.get(selectedIndex);

                //            NhanVienModel nhanvien = new NhanVienModel();
                DataGlobal.getDataGLobal.dataGlobal.setCurrentEditNhanVien(nhanvien);

            } catch (IndexOutOfBoundsException ex) {
                // Xử lý ngoại lệ IndexOutOfBoundsException nếu chỉ số không hợp lệ
                Logger.getLogger(QuanLiNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_listWorkerTableMouseClicked

    private void ReloadPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReloadPageActionPerformed
        // TODO add your handling code here:

        try {
            // TODO add your handling code here:
            hienThiDSNhanVien();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLiNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ReloadPageActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddWorker;
    private javax.swing.JButton DeleteWorker;
    private javax.swing.JButton ReloadPage;
    private javax.swing.JButton UpdateInfoWorker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listWorkerTable;
    // End of variables declaration//GEN-END:variables
}
