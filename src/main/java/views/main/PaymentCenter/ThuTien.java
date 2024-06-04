package views.main.PaymentCenter;

import controllers.PaymentCenter.PaymentCenterController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Client.HoaDonModel;
import utils.DialogHelper;
import utils.GenerateCode;
import utils.Validator;
import utils.customCode.Table.TableCustom;

/**
 *
 * @author Phu Bao
 */
public class ThuTien extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List<HoaDonModel> dsHoaDon = new ArrayList<>();
    String maChuHo = null;
    
    public ThuTien() {
        initComponents();
        tableModel = (DefaultTableModel) tblHoaDon.getModel();
        setingUITable();
        lblNofication.setVisible(false);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
    }
    
    private void setingUITable() {
        TableColumn column1 = tblHoaDon.getColumnModel().getColumn(0);
        column1.setPreferredWidth(25);
        TableColumn column2 = tblHoaDon.getColumnModel().getColumn(1);
        column2.setPreferredWidth(30);
        TableColumn column3 = tblHoaDon.getColumnModel().getColumn(2);
        column3.setPreferredWidth(75);
        TableColumn column4 = tblHoaDon.getColumnModel().getColumn(3);
        column4.setPreferredWidth(30);
        TableColumn column5 = tblHoaDon.getColumnModel().getColumn(4);
        column5.setPreferredWidth(30);
    }

    private void traCuuHoaDonTheoMaChuHo(String maChuHo) throws ClassNotFoundException {
        dsHoaDon = PaymentCenterController.hienThiCacHoaDonChuaTraTheoMaChuHo(maChuHo);
        tableModel.setRowCount(0);
        dsHoaDon.forEach(hd -> {
            tableModel.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaCTKV(),
                hd.getTenChiTiet(), hd.getMaDongHo(), hd.getKi()});
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTraCuu = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        lblThongBao = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblKi = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTienThoi = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        lblNofication = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Trang chủ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tra cứu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 51, 255))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã địa chỉ", "Tên địa chỉ", "Mã đồng hồ", "Kì"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nhập mã chủ hộ");

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnTraCuu.setBackground(new java.awt.Color(0, 153, 255));
        btnTraCuu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTraCuu.setForeground(new java.awt.Color(255, 255, 255));
        btnTraCuu.setText("Tra cứu");
        btnTraCuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(204, 204, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Client/icons8-refresh-16.png"))); // NOI18N
        btnLamMoi.setBorder(null);
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        lblThongBao.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblThongBao.setForeground(new java.awt.Color(0, 153, 153));
        lblThongBao.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(48, 48, 48)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnTraCuu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTraCuu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblThongBao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel5.setToolTipText("");

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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Đồng hồ:");
        jLabel9.setToolTipText("");

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jLabel9))
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
                                    .addComponent(lblKi))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jLabel9)
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

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Khách đưa:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Thối lại:");
        jLabel20.setToolTipText("");

        txtTienKhachDua.setEditable(false);
        txtTienKhachDua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        txtTienThoi.setEditable(false);
        txtTienThoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnThanhToan.setBackground(new java.awt.Color(0, 153, 153));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setEnabled(false);
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        lblNofication.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNofication.setForeground(new java.awt.Color(255, 0, 51));
        lblNofication.setText("Quá hạn, vui lòng ra trụ sở thanh toán");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienThoi, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btnThanhToan)
                        .addContainerGap(155, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNofication)
                        .addGap(80, 80, 80))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtTienThoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNofication))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int selectedIndex = tblHoaDon.getSelectedRow();
        if (selectedIndex >= 0) {
            try {
                btnThanhToan.setEnabled(true);
                txtTienKhachDua.setEditable(true);
                HoaDonModel hoaDon = dsHoaDon.get(selectedIndex);
                lblMaChuHo.setText(hoaDon.getMaChuHo());
                String tenChuHo = PaymentCenterController.traVeTenChuHo(maChuHo);
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
                Date ngayDenHan = hoaDon.getNgayDenHan();
                Date ngayHomNay = new Date();
                if (ngayHomNay.after(ngayDenHan)) {
                    btnThanhToan.setEnabled(false);
                    lblNofication.setVisible(true);
                } else {
                    lblNofication.setVisible(false);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThuTien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Chưa có dòng nào được chọn");
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnTraCuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraCuuActionPerformed
        // TODO add your handling code here:
        maChuHo = txtTimKiem.getText();
        try {
            if (!PaymentCenterController.kiemTraChuHoCoTrongHeThong(maChuHo)) {
                DialogHelper.showError("Không tìm thấy mã chủ hộ");
            } else {
                traCuuHoaDonTheoMaChuHo(maChuHo);
                if (dsHoaDon.isEmpty()) {
                    lblThongBao.setText("Không có hóa đơn chưa thanh toán");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThuTien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTraCuuActionPerformed
    
    private void lamMoi() {
        lblMaChuHo.setText("________________________");
        lblDiaChi.setText("________________________");
        lblDongHo.setText("________________________");
        lblMaHoaDon.setText("________________________");
        lblKi.setText("________________________");
        lblTenChuHo.setText("________________________");
        lblTieuThu.setText("________________________");
        lblTongTien.setText("________________________");
        lblThongBao.setText("");

        txtTienKhachDua.setText("");
        txtTienThoi.setText("");
        txtTimKiem.setText("");
        btnThanhToan.setEnabled(true);
        lblNofication.setVisible(false);
    }
    
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        lamMoi();
        try {
            traCuuHoaDonTheoMaChuHo("");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThuTien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
        try {
            // Kiểm tra tính hợp lệ của giá trị trong txtTienKhachDua
            if (Validator.isIntegerString(txtTienKhachDua.getText())) {
                String tongTienString = PaymentCenterController.traVeTien(lblMaHoaDon.getText());
                int tongTien = Integer.parseInt(tongTienString);
                int tienThu = Integer.parseInt(txtTienKhachDua.getText());

                // Tính toán tiền thối hoặc tiền thiếu
                if (tienThu > tongTien) {
                    int tienThoi = tienThu - tongTien;
                    txtTienThoi.setText(GenerateCode.generateMoneyCurrency(tienThoi));
                } else {
                    int tienThieu = tongTien - tienThu;
                    txtTienThoi.setText("Còn thiếu: " + GenerateCode.generateMoneyCurrency(tienThieu));
                }
            } else {
                DialogHelper.showError("Vui lòng nhập số hợp lệ");
            }
        } catch (NumberFormatException | ClassNotFoundException ex) {
            Logger.getLogger(ThuTien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        try {
            if (Validator.isIntegerString(txtTienKhachDua.getText())) {
                int tienThu = Integer.parseInt(txtTienKhachDua.getText());
                String maHoaDon = lblMaHoaDon.getText();
                String tongTienString = PaymentCenterController.traVeTien(maHoaDon);
                int tongTien = Integer.parseInt(tongTienString);

                if (tienThu < tongTien) {
                    DialogHelper.showError("Khách hàng chưa đưa đủ tiền");
                } else if (tienThu >= tongTien) {
                    if (PaymentCenterController.kiemTraHoaDonDaDuocThanhToanChua(maHoaDon)) {
                        PaymentCenterController.thanhToan(maHoaDon);
                        DialogHelper.showMessage("Giao dịch thành công!");
                        lamMoi();
                        traCuuHoaDonTheoMaChuHo(maChuHo);
                    } else {
                        DialogHelper.showError("Lỗi giao dịch, vui lòng nhấn làm mới giao dịch");
                    }
                } else {
                    DialogHelper.showError("Lỗi giao dịch");
                }
            } else {
                DialogHelper.showError("Số tiền không hợp lệ, vui lòng nhập lại");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThuTien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTraCuu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblKi;
    private javax.swing.JLabel lblMaChuHo;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblNofication;
    private javax.swing.JLabel lblTenChuHo;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblTieuThu;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThoi;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
