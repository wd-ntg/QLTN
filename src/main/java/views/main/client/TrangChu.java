package views.main.client;

import controllers.Client.ClientCtrl;
import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Client.HoaDonModel;
import models.Client.HoModel;
import utils.DialogHelper;
import utils.GenerateCode;
import utils.GenerateVerifyCode;
import utils.SendMailConfirmPaymentOnline;
import utils.customCode.Table.TableCustom;

/**
 *
 * @author Phu Bao
 */
public class TrangChu extends javax.swing.JPanel {

    /**
     * Creates new form ClientHome
     */
    DefaultTableModel tableModel;
    List<HoaDonModel> dsHoaDon = new ArrayList<>();
    private List<HoModel> dsCacHo;
    public static String verifyCode;

    public TrangChu() {
        initComponents();
        tableModel = (DefaultTableModel) tblDanhSachHoaDonChuaTra.getModel();
        try {
            setingUITable();
            TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
            hienThiHoaDon();
            hienThiDSCacHo();
            datThongBao();
            lblTrangThaiThanhToan.setVisible(false);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setingUITable() {
        TableColumn column1 = tblDanhSachHoaDonChuaTra.getColumnModel().getColumn(0);
        column1.setPreferredWidth(25);
        TableColumn column2 = tblDanhSachHoaDonChuaTra.getColumnModel().getColumn(1);
        column2.setPreferredWidth(30);
        TableColumn column3 = tblDanhSachHoaDonChuaTra.getColumnModel().getColumn(2);
        column3.setPreferredWidth(75);
        TableColumn column4 = tblDanhSachHoaDonChuaTra.getColumnModel().getColumn(3);
        column4.setPreferredWidth(30);
        TableColumn column5 = tblDanhSachHoaDonChuaTra.getColumnModel().getColumn(4);
        column5.setPreferredWidth(30);
        TableColumn column6 = tblDanhSachHoaDonChuaTra.getColumnModel().getColumn(5);
        column6.setPreferredWidth(60);
        TableColumn column7 = tblDanhSachHoaDonChuaTra.getColumnModel().getColumn(6);
        column7.setPreferredWidth(60);
        TableColumn column8 = tblDanhSachHoaDonChuaTra.getColumnModel().getColumn(7);
        column8.setPreferredWidth(60);
        TableColumn column9 = tblDanhSachHoaDonChuaTra.getColumnModel().getColumn(8);
        column9.setPreferredWidth(60);
    }

    private void hienThiDSCacHo() {
        try {
            dsCacHo = ClientCtrl.hienThiCacHoDangSuDungDichVu();
            cboDSCacHo.removeAllItems();
            cboDSCacHo.addItem("--Tất cả--");
            dsCacHo.forEach(ho -> {
                String diaChi = ho.getTenChiTiet();
                cboDSCacHo.addItem(diaChi);
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hienThiDSCacHoaDonTheoDiaChi(String maHo) throws ClassNotFoundException {
        dsHoaDon = ClientCtrl.hienThiCacHoaDonChuaTraTheoDiaChi(maHo);
        tableModel.setRowCount(0);
        dsHoaDon.forEach(hd -> {
            tableModel.addRow(new Object[]{hd.getMaHoaDon(), hd.getTenNhanVienGhiNuoc(), hd.getTenNhanVienLapHoaDon(),
                hd.getChiSoCu(), hd.getChiSoMoi(), hd.getNgayGhi(), hd.getNgayTao(),
                hd.getTenLoai(), hd.getMaCTKV()});
        });
        datThongBao();
    }

    private void hienThiHoaDon() throws ClassNotFoundException {
        dsHoaDon = ClientCtrl.hienThiCacHoaDonChuaTra();
        tableModel.setRowCount(0);
        dsHoaDon.forEach(hd -> {
            tableModel.addRow(new Object[]{hd.getMaHoaDon(), hd.getTenNhanVienGhiNuoc(), hd.getTenNhanVienLapHoaDon(),
                hd.getChiSoCu(), hd.getChiSoMoi(), hd.getNgayGhi(), hd.getNgayTao(),
                hd.getTenLoai(), hd.getMaCTKV()});
        });
        datThongBao();
    }

    private void datThongBao() {
        if (dsHoaDon.isEmpty()) {
            lblThongBao.setText("Bạn đã thanh toán hết hóa đơn");
            lblThongBao.setForeground(Color.GREEN);
        } else {
            lblThongBao.setText("Vui lòng thanh toán hóa đơn trước khi quá hạn");
            lblThongBao.setForeground(Color.RED);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDongHo = new javax.swing.JTextField();
        txtMaHoaDon = new javax.swing.JTextField();
        txtSoTien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTieuThu = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtKi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNgayDenHan = new javax.swing.JTextField();
        lblTrangThaiThanhToan = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachHoaDonChuaTra = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboDSCacHo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        lblThongBao = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 0, 51));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Chi tiết");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setText("Đồng hồ:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setText("Tiêu thụ:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel4.setText("Mã hóa đơn:");

        txtDongHo.setEditable(false);
        txtDongHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaHoaDon.setEditable(false);
        txtMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSoTien.setEditable(false);
        txtSoTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel5.setText("Số tiền:");

        txtTieuThu.setEditable(false);
        txtTieuThu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnThanhToan.setBackground(new java.awt.Color(0, 153, 153));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setEnabled(false);
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel8.setText("Địa chỉ:");

        txtDiaChi.setEditable(false);
        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnLamMoi.setBackground(new java.awt.Color(51, 102, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel10.setText("Kì:");

        txtKi.setEditable(false);
        txtKi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel12.setText("Ngày đến hạn:");

        txtNgayDenHan.setEditable(false);
        txtNgayDenHan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblTrangThaiThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThaiThanhToan.setForeground(new java.awt.Color(255, 0, 0));
        lblTrangThaiThanhToan.setText("Quá hạn, vui lòng đến trụ sở để thanh toán");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(txtDiaChi))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDongHo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKi))
                                .addGap(50, 50, 50))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblTrangThaiThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12)
                            .addComponent(btnThanhToan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTieuThu, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(txtSoTien)
                            .addComponent(txtNgayDenHan)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(97, 97, 97))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTrangThaiThanhToan))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTieuThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtNgayDenHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Trang chủ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        tblDanhSachHoaDonChuaTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "NV ghi nước", "NV lập hóa đơn", "Chỉ số trước", "Chỉ số sau", "Ngày ghi nước", "Ngày lập HĐ", "Loại tiền nước", "Mã địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachHoaDonChuaTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachHoaDonChuaTraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachHoaDonChuaTra);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Các hóa đơn chưa thanh toán");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Các hóa đơn");

        cboDSCacHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboDSCacHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDSCacHoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Chọn hộ:");

        lblThongBao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThongBao.setText("Nofication");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(cboDSCacHo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(71, 71, 71)
                        .addComponent(lblThongBao)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDSCacHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachHoaDonChuaTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachHoaDonChuaTraMouseClicked
        // TODO add your handling code here:
        int selectedIndex = tblDanhSachHoaDonChuaTra.getSelectedRow();
        if (selectedIndex >= 0) {
            btnThanhToan.setEnabled(true);
            HoaDonModel hoaDon = dsHoaDon.get(selectedIndex);
            txtMaHoaDon.setText(hoaDon.getMaHoaDon());
            txtNgayDenHan.setText(String.valueOf(hoaDon.getNgayDenHan()));
            int chiSoCu = hoaDon.getChiSoCu();
            int chiSoMoi = hoaDon.getChiSoMoi();
            int soNuoc = chiSoMoi - chiSoCu;
            txtTieuThu.setText(String.valueOf(soNuoc));
            txtSoTien.setText(String.valueOf(GenerateCode.generateMoneyCurrency(hoaDon.getTongTien())));
            txtDiaChi.setText(hoaDon.getTenChiTiet());
            txtKi.setText(hoaDon.getKi());
            String dongHo = hoaDon.getMaDongHo() + "-" + hoaDon.getTenDongHo();
            txtDongHo.setText(dongHo);
            Date ngayDenHan = hoaDon.getNgayDenHan();
            Date ngayHomNay = new Date();
            if (ngayHomNay.after(ngayDenHan)) {
                lblTrangThaiThanhToan.setVisible(true);
                btnThanhToan.setEnabled(false);
            } else {
                lblTrangThaiThanhToan.setVisible(false);
            }
        } else {
            System.out.println("Chưa có dòng nào được chọn");
        }

    }//GEN-LAST:event_tblDanhSachHoaDonChuaTraMouseClicked

    public void refresh() {
        txtMaHoaDon.setText("");
        txtDongHo.setText("");
        txtTieuThu.setText("");
        txtSoTien.setText("");
        txtDiaChi.setText("");
        cboDSCacHo.setSelectedIndex(0);
        txtKi.setText("");
        txtNgayDenHan.setText("");
        datThongBao();
        lblTrangThaiThanhToan.setVisible(false);
        btnThanhToan.setEnabled(true);
        try {
            hienThiHoaDon();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        refresh();
        btnThanhToan.setEnabled(false);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        try {
            int selectedIndex = tblDanhSachHoaDonChuaTra.getSelectedRow();
            if (selectedIndex >= 0) {
                HoaDonModel hd = dsHoaDon.get(selectedIndex);
                if (XacNhanThanhToan.Instance == null) {
                    XacNhanThanhToan.Instance = new XacNhanThanhToan();
                }
                String email = ClientCtrl.traVeEmail();
                System.out.println(email);
                if (email == null) {
                    DialogHelper.showError("Không tìm thấy email");
                } else {
                    verifyCode = GenerateVerifyCode.generateRandomCode();
                    System.out.println(verifyCode);
                    SendMailConfirmPaymentOnline.sendEmail(verifyCode, email);
                    DialogHelper.showMessage("Kiểm tra email của bạn để lấy mã xác nhận");
                    XacNhanThanhToan.Instance.txtMaHoaDon.setText(hd.getMaHoaDon());
                    XacNhanThanhToan.Instance.txtSoTien.setText(String.valueOf(GenerateCode.generateMoneyCurrency(hd.getTongTien())));

                    XacNhanThanhToan.Instance.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            // Khi cửa sổ DSGiuongBenhKhaDung được đóng, gọi phương thức làm mới
                            refresh();
                        }
                    });
                    XacNhanThanhToan.Instance.setVisible(true);
                }
            } else {
                DialogHelper.showError("Chưa có dòng nào trong bảng được chọn");
            }
        } catch (ClassNotFoundException | MessagingException | UnsupportedEncodingException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void cboDSCacHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDSCacHoActionPerformed
        // TODO add your handling code here:
        if (cboDSCacHo.getSelectedIndex() == 0) {
            try {
                hienThiHoaDon();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            int index = cboDSCacHo.getSelectedIndex();
            String maHo = dsCacHo.get(index - 1).getMaCTKV();
            System.out.println(maHo);
            if (maHo != null) {
                try {
                    hienThiDSCacHoaDonTheoDiaChi(maHo);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                DialogHelper.showError("Lỗi tải dữ liệu!");
            }
        }
    }//GEN-LAST:event_cboDSCacHoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JComboBox<String> cboDSCacHo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblTrangThaiThanhToan;
    private javax.swing.JTable tblDanhSachHoaDonChuaTra;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDongHo;
    private javax.swing.JTextField txtKi;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtNgayDenHan;
    private javax.swing.JTextField txtSoTien;
    private javax.swing.JTextField txtTieuThu;
    // End of variables declaration//GEN-END:variables
}
