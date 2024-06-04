package views.main.Manager;

import controllers.Manager.NhacDongTienNuocCtrl;
import controllers.PaymentCenter.PaymentCenterController;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Client.HoaDonModel;
import utils.DialogHelper;
import utils.GenerateCode;
import utils.SendReminderEmail;
import utils.customCode.Table.TableCustom;

/**
 *
 * @author Phu Bao
 */
public class NhacNhoTienNuoc extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List<HoaDonModel> dsHoaDon = new ArrayList<>();
    
    public NhacNhoTienNuoc() {
        try {
            initComponents();
            tableModel = (DefaultTableModel) tblHoaDon.getModel();
            setingUITable();
            TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
            hienThiHoaDonChuaDong();
            kiemTraNgay();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhacNhoTienNuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void hienThiHoaDonChuaDong() throws ClassNotFoundException {
        dsHoaDon = NhacDongTienNuocCtrl.hienThiCacHoaDonChuaThanhToan();
        tableModel.setRowCount(0);
        dsHoaDon.forEach(hd -> {
            tableModel.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaChuHo() ,hd.getMaCTKV(),
                hd.getTenChiTiet(), hd.getMaDongHo(), hd.getKi()});
        });
    }

    private void kiemTraNgay() {
        LocalDate today = LocalDate.now(); // Lấy ngày hiện tại
        int dayOfMonth = today.getDayOfMonth(); // Lấy ngày trong tháng
        if (dayOfMonth >= 23 && dayOfMonth <= 25) {
            btnGuiHangLoat.setEnabled(true);
            btnGuiMail.setEnabled(true);
        } else {
            btnGuiHangLoat.setEnabled(false);
            btnGuiMail.setEnabled(false);
            lblThongBao.setText("Hôm nay không phải là ngày gửi email");
        }
    }

    private void guiEmailHangLoat() {
        try {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String maHoaDon = tableModel.getValueAt(i, 0).toString();
                String maChuHo = tableModel.getValueAt(i, 1).toString();
                String maDiaChi = tableModel.getValueAt(i, 2).toString();
                String tenChiTiet = tableModel.getValueAt(i, 3).toString();
                String maDongHo = tableModel.getValueAt(i, 4).toString();
                String ki = tableModel.getValueAt(i, 5).toString();
                String email = NhacDongTienNuocCtrl.layEmail(maChuHo);
                
                String tenChuHo = PaymentCenterController.traVeTenChuHo(maChuHo);
                if (!maHoaDon.isEmpty() || !maDiaChi.isEmpty() || !maChuHo.isEmpty() || !tenChiTiet.isEmpty() || !maDongHo.isEmpty() || !ki.isEmpty() || !email.isEmpty()) {
                    SendReminderEmail.sendEmail(tenChuHo, ki, tenChiTiet, email);
                    NhacDongTienNuocCtrl.doiTrangThai(maHoaDon);
                }
            }
        } catch (ClassNotFoundException | MessagingException | UnsupportedEncodingException ex) {
            Logger.getLogger(NhacNhoTienNuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setingUITable() {
        TableColumn column1 = tblHoaDon.getColumnModel().getColumn(0);
        column1.setPreferredWidth(20);
        TableColumn column2 = tblHoaDon.getColumnModel().getColumn(1);
        column2.setPreferredWidth(20);
        TableColumn column3 = tblHoaDon.getColumnModel().getColumn(2);
        column3.setPreferredWidth(90);
        TableColumn column4 = tblHoaDon.getColumnModel().getColumn(3);
        column4.setPreferredWidth(30);
        TableColumn column5 = tblHoaDon.getColumnModel().getColumn(4);
        column5.setPreferredWidth(30);
        TableColumn column6 = tblHoaDon.getColumnModel().getColumn(5);
        column6.setPreferredWidth(30);
    }
    
    private void lamMoi() {
        try {
            lblMaChuHo.setText("________________________");
            lblDiaChi.setText("________________________");
            lblDongHo.setText("________________________");
            lblMaHoaDon.setText("________________________");
            lblKi.setText("________________________");
            lblTenChuHo.setText("________________________");
            lblTieuThu.setText("________________________");
            lblTongTien.setText("________________________");
            hienThiHoaDonChuaDong();
            kiemTraNgay();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhacNhoTienNuoc.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnGuiHangLoat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblMaChuHo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTieuThu = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTenChuHo = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblKi = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnGuiMail = new javax.swing.JButton();
        lblThongBao = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(134, 140, 255));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("NHẮC TIỀN NƯỚC");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách các hóa đơn chưa thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        btnGuiHangLoat.setBackground(new java.awt.Color(0, 102, 255));
        btnGuiHangLoat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuiHangLoat.setForeground(new java.awt.Color(255, 255, 255));
        btnGuiHangLoat.setText("Gửi hàng loạt");
        btnGuiHangLoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiHangLoatActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Client/icons8-refresh-16.png"))); // NOI18N
        btnLamMoi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        tblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã chủ hộ", "Mã địa chỉ", "Tên địa chỉ", "Mã đồng hồ", "Kì"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mã chủ hộ:");
        jLabel3.setToolTipText("");

        lblMaChuHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaChuHo.setText("________________________");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Địa chỉ");
        jLabel7.setToolTipText("");

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDiaChi.setText("________________________");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Tiêu thụ:");
        jLabel11.setToolTipText("");

        lblTieuThu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTieuThu.setText("________________________");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Mã hóa đơn:");
        jLabel15.setToolTipText("");

        lblMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaHoaDon.setText("________________________");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Tên chủ hộ:");
        jLabel5.setToolTipText("");

        lblTenChuHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenChuHo.setText("________________________");

        lblDongHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDongHo.setText("________________________");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Đồng hồ:");
        jLabel10.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Kì:");
        jLabel13.setToolTipText("");

        lblKi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblKi.setText("________________________");

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTongTien.setText("________________________");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Tổng tiền:");
        jLabel17.setToolTipText("");

        btnGuiMail.setBackground(new java.awt.Color(0, 153, 102));
        btnGuiMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuiMail.setForeground(new java.awt.Color(255, 255, 255));
        btnGuiMail.setText("Gửi mail");
        btnGuiMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiMailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(35, 35, 35)
                                .addComponent(lblMaChuHo))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel10))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDongHo)
                                    .addComponent(lblMaHoaDon)
                                    .addComponent(lblDiaChi))))
                        .addGap(126, 126, 126)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel11))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTongTien))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTenChuHo)
                                            .addComponent(lblTieuThu)
                                            .addComponent(lblKi)))))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuiMail)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(btnGuiMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblMaChuHo)
                    .addComponent(jLabel5)
                    .addComponent(lblTenChuHo))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(lblTieuThu))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lblDiaChi)))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(lblDongHo))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(lblKi)))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblMaHoaDon)
                    .addComponent(jLabel17)
                    .addComponent(lblTongTien))
                .addContainerGap())
        );

        lblThongBao.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblThongBao.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnGuiHangLoat)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lblThongBao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnGuiHangLoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblThongBao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuiHangLoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiHangLoatActionPerformed
        // TODO add your handling code here:
        guiEmailHangLoat();
    }//GEN-LAST:event_btnGuiHangLoatActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        lamMoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int selectedIndex = tblHoaDon.getSelectedRow();
        if (selectedIndex >= 0) {
            try {
                HoaDonModel hoaDon = dsHoaDon.get(selectedIndex);
                lblMaChuHo.setText(hoaDon.getMaChuHo());
                String tenChuHo = PaymentCenterController.traVeTenChuHo(hoaDon.getMaChuHo());
                lblTenChuHo.setText(tenChuHo);
                lblDiaChi.setText(hoaDon.getTenChiTiet());
                String dongHo = hoaDon.getMaDongHo() + "-" + hoaDon.getTenDongHo();
                lblDongHo.setText(dongHo);
                int chiSoCu = hoaDon.getChiSoCu();
                int chiSoMoi = hoaDon.getChiSoMoi();
                int soNuoc = chiSoMoi - chiSoCu;
                lblTieuThu.setText(String.valueOf(soNuoc));
                lblKi.setText(hoaDon.getKi());
                lblMaHoaDon.setText(hoaDon.getMaHoaDon());
                lblTongTien.setText(String.valueOf(GenerateCode.generateMoneyCurrency(hoaDon.getTongTien())));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NhacNhoTienNuoc.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Chưa có dòng nào được chọn");
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnGuiMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiMailActionPerformed
        try {
            // TODO add your handling code here:
            String maChuHo = lblMaChuHo.getText();
            String tenChuHo = lblMaChuHo.getText();
            String ki = lblKi.getText();
            String diaChi = lblDiaChi.getText();
            String email = NhacDongTienNuocCtrl.layEmail(maChuHo);
            String maHoaDon = lblMaHoaDon.getText();
            if (maChuHo.isEmpty() || tenChuHo.isEmpty() || ki.isEmpty() || diaChi.isEmpty() || email.isEmpty() || email == null|| maHoaDon.isEmpty()) {
                DialogHelper.showError("Lỗi gửi email");
            } else {
                SendReminderEmail.sendEmail(tenChuHo, ki, diaChi, email);
                NhacDongTienNuocCtrl.doiTrangThai(maHoaDon);
                DialogHelper.showMessage("Gửi thành công");
            }
        } catch (ClassNotFoundException | MessagingException | UnsupportedEncodingException ex) {
            Logger.getLogger(NhacNhoTienNuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuiMailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuiHangLoat;
    private javax.swing.JButton btnGuiMail;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblKi;
    private javax.swing.JLabel lblMaChuHo;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblTenChuHo;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblTieuThu;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblHoaDon;
    // End of variables declaration//GEN-END:variables
}
