/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.main.Manager;

import controllers.Manager.QuanLiChuHoCtrl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.DataGlobal;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import models.ChuHoModel;

/**
 *
 * @author hoang
 */
public class QuanLiChuHo extends javax.swing.JFrame {

    /**
     * Creates new form ManagerClient
     */
    
    DefaultTableModel tableModel;
    List<ChuHoModel> listClient = new ArrayList<>();
    
    public QuanLiChuHo() {
        try {
            initComponents();

            tableModel = (DefaultTableModel) listClientTable.getModel();
            
            // Trong constructor của ManagerClient, sau khi khởi tạo initComponents():
            // Đặt renderer cho cột StatusAcc (ví dụ, cột thứ 5)
            /*listClientTable.getColumnModel().getColumn(4).setCellRenderer(new CustomTableCellRenderer());*/
            
            hienThiDSChuHo();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLiChuHo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hienThiDSChuHo() throws ClassNotFoundException {
        
        listClient = QuanLiChuHoCtrl.timTatCaChuHo();
        
        tableModel.setRowCount(0);

        listClient.forEach(ch -> {
            tableModel.addRow(new Object[]{
                ch.getMACH(),
                ch.getHOTEN(),
                ch.getSDT(),
                ch.getCCCD(),
                ch.getDIACHITT(),
                ch.getGIOITINH(),
                ch.getEMAIL()
            });
        });

    }
    
    /*public void kiemTraTinhTrangThanhToan() {
        try {
            List<PersonModel> listOverdueClients = ClientCtrl.kiemTraTinhTrangThanhToan();

            for (PersonModel person : listOverdueClients) {
                if (!person.getStatusAcc()) {
                    // Nếu tài khoản chưa bị khóa thì khóa
                    person.setStatusAcc(false);
                    // Cập nhật lại trạng thái tài khoản trong cơ sở dữ liệu
                    ClientCtrl.capNhatTrangThaiTaiKhoan(person.getPersonId(), false);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLiChuHo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    
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
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        AddClient = new javax.swing.JButton();
        UpdateInfoClient = new javax.swing.JButton();
        DeleteClient = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        ReloadClientPage = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listClientTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(134, 140, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quản lí chủ hộ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(245, 230, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Danh sách chủ hộ");

        AddClient.setBackground(new java.awt.Color(51, 102, 255));
        AddClient.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddClient.setForeground(new java.awt.Color(255, 255, 255));
        AddClient.setText("Thêm chủ hộ");
        AddClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClientActionPerformed(evt);
            }
        });

        UpdateInfoClient.setBackground(new java.awt.Color(51, 102, 255));
        UpdateInfoClient.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UpdateInfoClient.setForeground(new java.awt.Color(255, 255, 255));
        UpdateInfoClient.setText("Sửa thông tin");
        UpdateInfoClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateInfoClientActionPerformed(evt);
            }
        });

        DeleteClient.setBackground(new java.awt.Color(51, 102, 255));
        DeleteClient.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteClient.setForeground(new java.awt.Color(255, 255, 255));
        DeleteClient.setText("Xóa");
        DeleteClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteClientActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Tìm kiếm");

        ReloadClientPage.setBackground(new java.awt.Color(51, 102, 255));
        ReloadClientPage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ReloadClientPage.setForeground(new java.awt.Color(255, 255, 255));
        ReloadClientPage.setText("Làm mới");
        ReloadClientPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReloadClientPageActionPerformed(evt);
            }
        });

        listClientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã chủ hộ", "Tên chủ hộ", "Số điện thoại", "CCCD", "Địa chỉ", "Phái", "Email"
            }
        ));
        listClientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listClientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listClientTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addComponent(AddClient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UpdateInfoClient)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteClient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReloadClientPage)
                        .addGap(27, 27, 27))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(AddClient)
                    .addComponent(UpdateInfoClient)
                    .addComponent(DeleteClient)
                    .addComponent(ReloadClientPage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setText("Quản lí tiền nước công ti dịch vụ nước đô thị");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientActionPerformed
        // TODO add your handling code here:
        
        ThemChuHo addClientWindow = new ThemChuHo();
        addClientWindow.setVisible(true);
    }//GEN-LAST:event_AddClientActionPerformed

    private void UpdateInfoClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateInfoClientActionPerformed
        // TODO add your handling code here:
        SuaThongTinChuHo updateClientWindow = new SuaThongTinChuHo();
        updateClientWindow.setVisible(true);

    }//GEN-LAST:event_UpdateInfoClientActionPerformed

    private void DeleteClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteClientActionPerformed
        // TODO add your handling code here:

        int selectedIndex = listClientTable.getSelectedRow();
        if (selectedIndex >= 0) {
            String[] options = {"Đồng ý", "Thoát"};
            int option = JOptionPane.showOptionDialog(
                this,
                "Bạn có chắc muốn xóa chủ hộ này",
                "Cảnh báo",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[1]
            );

            if (option == 0) {
                try {
                    ChuHoModel chuho = listClient.get(selectedIndex);
                    //System.out.println(chuho);
                    QuanLiChuHoCtrl.XoaChuHo(chuho.getEMAIL());
                    hienThiDSChuHo();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(QuanLiChuHo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_DeleteClientActionPerformed

    private void ReloadClientPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReloadClientPageActionPerformed
        // TODO add your handling code here:

        try {
            // TODO add your handling code here:
            hienThiDSChuHo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLiChuHo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ReloadClientPageActionPerformed

    private void listClientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClientTableMouseClicked
                // TODO add your handling code here:
        int selectedIndex = listClientTable.getSelectedRow();

        if (selectedIndex >= 0) {
            try {
                
                ChuHoModel chuho = listClient.get(selectedIndex);

                //PersonModel personClient = new PersonModel(person.getNamePerson(),person.getRolePerson(), person.getEmail(), person.getAddressPerson(), person.getPhoneNumber(), person.getPasswordAcc());

                DataGlobal.getDataGLobal.dataGlobal.setCurrentEditChuHo(chuho);

            } catch (IndexOutOfBoundsException ex) {
                // Xử lý ngoại lệ IndexOutOfBoundsException nếu chỉ số không hợp lệ
                Logger.getLogger(QuanLiChuHo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_listClientTableMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLiChuHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLiChuHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLiChuHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLiChuHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuanLiChuHo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClient;
    private javax.swing.JButton DeleteClient;
    private javax.swing.JButton ReloadClientPage;
    private javax.swing.JButton UpdateInfoClient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable listClientTable;
    // End of variables declaration//GEN-END:variables
}
