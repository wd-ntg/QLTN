/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.main.Manager;
import views.main.Manager.ThemNhanVienView;
import models.DataGlobal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.NhanVienModel;

import controllers.Manager.QuanLiNhanVienCtrl;
import javax.swing.JOptionPane;


/**
 *
 * @author GIANG
 */
public class QuanLiNhanVienView extends javax.swing.JFrame {

    /**
     * Creates new form ManagerWorker
     */
    DefaultTableModel tableModel;
    List<NhanVienModel> listWorker = new ArrayList<>();
    
    // Lớp Singleton để lưu trữ thông tin của đối tượng PersonModel được chọn
    
    public QuanLiNhanVienView() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) listWorkerTable.getModel();
            
            hienThiDSNhanVien();

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        AddWorker = new javax.swing.JButton();
        UpdateInfoWorker = new javax.swing.JButton();
        DeleteWorker = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listWorkerTable = new javax.swing.JTable();
        ReloadPage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(134, 140, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quản lí nhân viên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
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

        jPanel2.setBackground(new java.awt.Color(134, 140, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Danh sách nhân viên");

        AddWorker.setBackground(new java.awt.Color(0, 153, 255));
        AddWorker.setForeground(new java.awt.Color(255, 255, 255));
        AddWorker.setText("Thêm nhân viên");
        AddWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddWorkerActionPerformed(evt);
            }
        });

        UpdateInfoWorker.setBackground(new java.awt.Color(0, 153, 255));
        UpdateInfoWorker.setForeground(new java.awt.Color(255, 255, 255));
        UpdateInfoWorker.setText("Sửa thông tin");
        UpdateInfoWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateInfoWorkerActionPerformed(evt);
            }
        });

        DeleteWorker.setBackground(new java.awt.Color(0, 153, 255));
        DeleteWorker.setForeground(new java.awt.Color(255, 255, 255));
        DeleteWorker.setText("Xóa");
        DeleteWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteWorkerActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tìm kiếm");

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                                .addComponent(AddWorker)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(UpdateInfoWorker)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteWorker)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ReloadPage)
                                .addGap(9, 9, 9)))
                        .addGap(18, 18, 18))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddWorkerActionPerformed
        // TODO add your handling code here:
        // Tạo cửa sổ mới để nhập thông tin người dùng
        ThemNhanVienView addUserWindow = new ThemNhanVienView();
    
        // Hiển thị cửa sổ AddUser
        addUserWindow.setVisible(true);
        
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
        
        int selectedIndex = listWorkerTable.getSelectedRow();
    
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
            java.util.logging.Logger.getLogger(QuanLiNhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLiNhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLiNhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLiNhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLiNhanVienView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddWorker;
    private javax.swing.JButton DeleteWorker;
    private javax.swing.JButton ReloadPage;
    private javax.swing.JButton UpdateInfoWorker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable listWorkerTable;
    // End of variables declaration//GEN-END:variables
}
