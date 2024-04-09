/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.main.Manager;

import controllers.Manager.PhanCongCtrl;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;

import controllers.Manager.ChiTietPhanCongKhuVucCtrl;
import controllers.Manager.QuanLiNhanVienCtrl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DataGlobal;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import models.KhuVucModel;
import models.NhanVienModel;
import models.PhanCongModel;

/**
 *
 * @author GIANG
 */
public class ChiTietPhanCongKhuVucView extends javax.swing.JFrame {

    /**
     * Creates new form DetailAssignment
     */
    // Tạo combobox và thêm các mục vào
    List<NhanVienModel> dsNhanVienTrongKhuVuc = new ArrayList<>();

    KhuVucModel khuVucModel = DataGlobal.getDataGLobal.dataGlobal.getKhuVucModel();

    DefaultTableModel tableModel;

    List<PhanCongModel> phanCongNhanVienModel = new ArrayList<>();

    List<PhanCongModel> dsThayDoiPhanCongNhanVienModel = new ArrayList<>();

    List<String> detailAddressId = new ArrayList<>();

    List<String> detailAddressIdNone = new ArrayList<>();

    String resultTime;

    String TimeSelect;

    String EmployerNon;
   

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date currentDate = new Date();
    String dateTimeString = dateFormat.format(currentDate);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Phân tích chuỗi thành LocalDateTime
    LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

    // Trích xuất tháng và năm
    int month = dateTime.getMonthValue();
    int year = dateTime.getYear();

    public ChiTietPhanCongKhuVucView() {

        // Date Time
        // Tạo chuỗi mới
        resultTime = month + "/" + year;

        try {
            initComponents();

            // Set abtribution 
            // Tạo JComboBox cho tháng và năm
            String[] monthsYears = generateMonthsYears();

            for (int i = 0; i < monthsYears.length; i++) {
                dsThoiGianPhanCong.addItem(monthsYears[i]);
            }

//            listTimeAssignment = new JComboBox<>(monthsYears);
            nameArea.setText(khuVucModel.getTENKHUVUC());

            JComboBox<String> comboBox = new JComboBox<>();

// Gán TableCellEditor cho cột bạn muốn thêm combobox vào (ví dụ: cột thứ 2)
            TableColumn column = bangPhanCongNhanVien.getColumnModel().getColumn(5);

            bangPhanCongNhanVien.getAccessibleContext();

            column.setCellEditor(
                    new DefaultCellEditor(comboBox));

            dsNhanVienTrongKhuVuc = ChiTietPhanCongKhuVucCtrl.timTatCaNhanVienTrucThuocKhuVuc(khuVucModel.getMAKHUVUC());

            dsNhanVienTrongKhuVuc.forEach(nv -> {
                comboBox.addItem(nv.getMANV());

            });

            // Add Data 
            tableModel = (DefaultTableModel) bangPhanCongNhanVien.getModel();

            hienThiDSPhanCong(khuVucModel.getMAKHUVUC(), resultTime);

            TimeSelect = dsThoiGianPhanCong.getSelectedItem().toString();

            dsThoiGianPhanCong.setSelectedItem(resultTime);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChiTietPhanCongKhuVucView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void selectTime() {
        String selectedValue = dsThoiGianPhanCong.getSelectedItem().toString();

        TimeSelect = selectedValue;
    }

    public void hienThiDSPhanCong(String AreaId, String TimeLine) throws ClassNotFoundException {

        phanCongNhanVienModel = ChiTietPhanCongKhuVucCtrl.timTatCaDuLieuThuocKhuVuc(AreaId, TimeLine);
        tableModel.setRowCount(0);

        phanCongNhanVienModel.forEach(pc -> {
            tableModel.addRow(new Object[]{pc.getMAPC(), pc.getMACH(), pc.getHOTENCH(), pc.getTENLOAINUOC(), pc.getTENDIACHI(), pc.getMANV(), pc.getHOTENNV(), pc.getMAQL(), pc.getHOTENQL()});
        });

        phanCongNhanVienModel.forEach(assign -> {
            detailAddressId.add(assign.getMAPC());
        });
        
        EmployerNon = "";
        
        DataGlobal.getDataGLobal.dataGlobal.setEmployerNon(EmployerNon);

    }

    public void hienThiDSChuaPhanCong(String AreaId, String TimeLine) throws ClassNotFoundException {

        phanCongNhanVienModel = ChiTietPhanCongKhuVucCtrl.timTatCaDuLieuThuocKhuVucChuaPhanCong(AreaId, TimeLine);

        tableModel.setRowCount(0);

        phanCongNhanVienModel.forEach(pc -> {
            tableModel.addRow(new Object[]{pc.getMAPC(), pc.getMACH(), pc.getHOTENCH(), pc.getTENLOAINUOC(), pc.getTENDIACHI(), pc.getMANV(), pc.getHOTENNV(), pc.getMAQL(), pc.getHOTENQL()});
        });

        phanCongNhanVienModel.forEach(assign -> {
            detailAddressIdNone.add(assign.getMAPC());
        });

    }

    private String[] generateMonthsYears() {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        int currentYear = calendar.get(java.util.Calendar.YEAR);
        String[] monthsYears = new String[120]; // 5 years before and 5 years after
        int count = 0;
        for (int year = currentYear - 5; year <= currentYear + 5; year++) {
            for (int month = 1; month <= 12; month++) {
                if (count < monthsYears.length) {
                    monthsYears[count++] = getMonthName(month) + year;
                } else {
                    break; // Exit the loop if we've filled the array
                }
            }
        }
        return monthsYears;
    }

    private String getMonthName(int month) {
        switch (month) {
            case 1:
                return "1/";
            case 2:
                return "2/";
            case 3:
                return "3/";
            case 4:
                return "4/";
            case 5:
                return "5/";
            case 6:
                return "6/";
            case 7:
                return "7/";
            case 8:
                return "8/";
            case 9:
                return "9/";
            case 10:
                return "10/";
            case 11:
                return "11/";
            case 12:
                return "12/";
            default:
                return "";
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameArea = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangPhanCongNhanVien = new javax.swing.JTable();
        tuDongPhanCong = new javax.swing.JButton();
        dsThoiGianPhanCong = new javax.swing.JComboBox<>();
        chinhSua = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        xemThongTin = new javax.swing.JButton();
        datLai = new javax.swing.JButton();
        apDung = new javax.swing.JButton();
        nguoiDungChuaDuocPhanCong = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(134, 140, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phân công nhân viên ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Công ty dịch vụ nước đô thị Quận 9");

        nameArea.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        nameArea.setText("Name Area");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameArea, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameArea, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Danh sách phân công nhân viên");

        bangPhanCongNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã PC", "Mã người sử dụng", "Tên người sử dụng", "Loại nước sử dụng", "Địa chỉ đồng hồ", "Mã nhân viên", "Tên nhân viên", "Mã QL PC", "Tên QLPC"
            }
        ));
        bangPhanCongNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangPhanCongNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bangPhanCongNhanVien);

        tuDongPhanCong.setText("Tự động phân công");
        tuDongPhanCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuDongPhanCongActionPerformed(evt);
            }
        });

        dsThoiGianPhanCong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        dsThoiGianPhanCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsThoiGianPhanCongMouseClicked(evt);
            }
        });
        dsThoiGianPhanCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsThoiGianPhanCongActionPerformed(evt);
            }
        });

        chinhSua.setText("Chỉnh sửa");
        chinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chinhSuaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Chọn thời gian");

        xemThongTin.setText("Xem thông tin");
        xemThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemThongTinActionPerformed(evt);
            }
        });

        datLai.setText("Đặt lại");
        datLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datLaiActionPerformed(evt);
            }
        });

        apDung.setText("Áp dụng");
        apDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apDungActionPerformed(evt);
            }
        });

        nguoiDungChuaDuocPhanCong.setText("Người dùng chưa được phân công");
        nguoiDungChuaDuocPhanCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nguoiDungChuaDuocPhanCongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nguoiDungChuaDuocPhanCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(datLai)
                                .addGap(26, 26, 26)
                                .addComponent(apDung)
                                .addGap(27, 27, 27)
                                .addComponent(chinhSua))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(dsThoiGianPhanCong, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xemThongTin)
                            .addComponent(tuDongPhanCong)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tuDongPhanCong)
                        .addComponent(chinhSua)
                        .addComponent(datLai)
                        .addComponent(apDung)))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xemThongTin)
                    .addComponent(dsThoiGianPhanCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(nguoiDungChuaDuocPhanCong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tuDongPhanCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuDongPhanCongActionPerformed
        // TODO add your handling code here:
        // Định dạng ngày giờ
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Lấy ngày hiện tại
        Date currentDate = new Date();

        // Tạo một đối tượng Calendar và thiết lập ngày hiện tại vào đó
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // Tăng thêm 1 tháng
        calendar.add(Calendar.MONTH, 1);

        // Đặt ngày là 1
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // Lấy ngày sau khi tăng 1 tháng và định dạng lại thành chuỗi
        Date nextMonthDate = calendar.getTime();

        String nextMonthDateTimeString = dateFormat.format(nextMonthDate);

        selectTime();

        String TimeAutoAssign = String.valueOf(month + 1) + "/" + year;

        System.out.println(resultTime);

        try {

            if (ChiTietPhanCongKhuVucCtrl.kiemTraLichPhanCong(TimeAutoAssign, khuVucModel.getMAKHUVUC())) {
                JOptionPane.showMessageDialog(null, "Tháng tiếp theo đã được phân công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            } else {
                ChiTietPhanCongKhuVucCtrl.autoPhanCongNhanVien(khuVucModel.getMAKHUVUC(), nextMonthDateTimeString, resultTime);
                JOptionPane.showMessageDialog(null, "Phân công tháng tiếp theo thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {
            Logger.getLogger(ChiTietPhanCongKhuVucView.class.getName()).log(Level.SEVERE, null, ex);

        }


    }//GEN-LAST:event_tuDongPhanCongActionPerformed

    private void chinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinhSuaActionPerformed
        // TODO add your handling code here:
        selectTime();
        String[] parts = TimeSelect.split("/");

        // Lấy tháng và năm từ mảng parts
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);

        if (month >= Integer.parseInt(String.valueOf(this.month)) && year >= Integer.parseInt(String.valueOf(this.year))) {
            DataGlobal.getDataGLobal.dataGlobal.setTimeAssign(TimeSelect);
            CapNhatPhanCongChiTietView updateAssignmentEmployDetail = new CapNhatPhanCongChiTietView();
            updateAssignmentEmployDetail.setVisible(true);
             updateAssignmentEmployDetail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else {
            JOptionPane.showMessageDialog(null, "Ngoài thời gian phân công, không được chỉnh sửa phân công !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_chinhSuaActionPerformed

    private void dsThoiGianPhanCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsThoiGianPhanCongActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_dsThoiGianPhanCongActionPerformed

    private void datLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datLaiActionPerformed
        // TODO add your handling code here:
        try {
            hienThiDSPhanCong(khuVucModel.getMAKHUVUC(), resultTime);
            dsThoiGianPhanCong.setSelectedItem(resultTime);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChiTietPhanCongKhuVucView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_datLaiActionPerformed

    private void apDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apDungActionPerformed
        // TODO add your handling code here:

        selectTime();

        String[] parts = TimeSelect.split("/");

        // Lấy tháng và năm từ mảng parts
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);

        if (EmployerNon.equals("AC")) {
            if (month >= Integer.parseInt(String.valueOf(this.month)) && year >= Integer.parseInt(String.valueOf(this.year))) {
                for (int row = 0; row < bangPhanCongNhanVien.getRowCount(); row++) {
                    String maPC = (String) bangPhanCongNhanVien.getValueAt(row, 0);
                    
                    String maCH = (String) bangPhanCongNhanVien.getValueAt(row, 1); // Giả sử cột đầu tiên là PersonId
                    String tenCH = (String) bangPhanCongNhanVien.getValueAt(row, 2); // Giả sử cột thứ hai là NamePerson
                    String loaiNuoc = (String) bangPhanCongNhanVien.getValueAt(row, 3);
                    String diaChiDongHo = (String) bangPhanCongNhanVien.getValueAt(row, 4);
                    String maNV = (String) bangPhanCongNhanVien.getValueAt(row, 5);
                    String tenNV = (String) bangPhanCongNhanVien.getValueAt(row, 6);
                    String maQL = (String) bangPhanCongNhanVien.getValueAt(row, 7);
                    String tenQL = (String) bangPhanCongNhanVien.getValueAt(row, 8);


                    PhanCongModel thayDoiPhanCongChiTiet = new PhanCongModel(maPC, maQL, tenQL, maNV, tenNV, maCH, tenCH, diaChiDongHo, loaiNuoc); // Thêm các thông tin còn lại của AssignmentEmpoylerModel

                    // Thêm đối tượng AssignmentEmpoylerModel vào danh sách
                    dsThayDoiPhanCongNhanVienModel.add(thayDoiPhanCongChiTiet);
                }

                try {

                    ChiTietPhanCongKhuVucCtrl.capNhatTatCaDuLieuThuocKhuVucChuaPhanCong(khuVucModel.getMAKHUVUC(), phanCongNhanVienModel, dsThayDoiPhanCongNhanVienModel, TimeSelect);

                } catch (Exception e) {
                    // Xử lý ngoại lệ nếu có
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ngoài thời gian phân công, không được chỉnh sửa phân công !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (month >= Integer.parseInt(String.valueOf(this.month)) && year >= Integer.parseInt(String.valueOf(this.year))) {
                for (int row = 0; row < bangPhanCongNhanVien.getRowCount(); row++) {
                    String maPC = (String) bangPhanCongNhanVien.getValueAt(row, 0);
                    
                    String maCH = (String) bangPhanCongNhanVien.getValueAt(row, 1); // Giả sử cột đầu tiên là PersonId
                    String tenCH = (String) bangPhanCongNhanVien.getValueAt(row, 2); // Giả sử cột thứ hai là NamePerson
                    String loaiNuoc = (String) bangPhanCongNhanVien.getValueAt(row, 3);
                    String diaChiDongHo = (String) bangPhanCongNhanVien.getValueAt(row, 4);
                    String maNV = (String) bangPhanCongNhanVien.getValueAt(row, 5);
                    String tenNV = (String) bangPhanCongNhanVien.getValueAt(row, 6);
                    String maQL = (String) bangPhanCongNhanVien.getValueAt(row, 7);
                    String tenQL = (String) bangPhanCongNhanVien.getValueAt(row, 8);

                    PhanCongModel thayDoiPhanCongNhanVienModel = new PhanCongModel(maPC, maQL, tenQL, maNV, tenNV, maCH, tenCH, diaChiDongHo, loaiNuoc);  // Thêm các thông tin còn lại của AssignmentEmpoylerModel

                    // Thêm đối tượng AssignmentEmpoylerModel vào danh sách
                    dsThayDoiPhanCongNhanVienModel.add(thayDoiPhanCongNhanVienModel);
                }

                try {

                    ChiTietPhanCongKhuVucCtrl.capNhatTatCaDuLieuThuocKhuVuc(khuVucModel.getMAKHUVUC(), phanCongNhanVienModel, dsThayDoiPhanCongNhanVienModel, TimeSelect);

                } catch (Exception e) {
                    // Xử lý ngoại lệ nếu có
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ngoài thời gian phân công, không được chỉnh sửa phân công !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_apDungActionPerformed

    private void bangPhanCongNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangPhanCongNhanVienMouseClicked
        // TODO add your handling code here:

        int selectedIndex = bangPhanCongNhanVien.getSelectedRow();

        // Kiểm tra xem người dùng đã chọn một dòng hợp lệ hay không
        if (selectedIndex >= 0) {
            try {
                // Lấy đối tượng PersonModel từ danh sách listWorker

                PhanCongModel phanCongModel = phanCongNhanVienModel.get(selectedIndex);

                DataGlobal.getDataGLobal.dataGlobal.setPhanCongModel(phanCongModel);

            } catch (IndexOutOfBoundsException ex) {
                // Xử lý ngoại lệ IndexOutOfBoundsException nếu chỉ số không hợp lệ
                Logger.getLogger(ChiTietPhanCongKhuVucView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bangPhanCongNhanVienMouseClicked

    private void xemThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemThongTinActionPerformed
        // TODO add your handling code here:

        selectTime();
        try {
            ChiTietPhanCongKhuVucCtrl.timTatCaDuLieuThuocKhuVucTheoThoiGian(khuVucModel.getMAKHUVUC(), String.valueOf(dsThoiGianPhanCong.getSelectedItem()));
            hienThiDSPhanCong(khuVucModel.getMAKHUVUC(), TimeSelect);

        } catch (Exception ex) {
            Logger.getLogger(ChiTietPhanCongKhuVucView.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_xemThongTinActionPerformed

    private void dsThoiGianPhanCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsThoiGianPhanCongMouseClicked

    }//GEN-LAST:event_dsThoiGianPhanCongMouseClicked

    private void nguoiDungChuaDuocPhanCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nguoiDungChuaDuocPhanCongActionPerformed
        // TODO add your handling code here:

        EmployerNon = "AC";
        
        DataGlobal.getDataGLobal.dataGlobal.setEmployerNon(EmployerNon);

        try {
            hienThiDSChuaPhanCong(khuVucModel.getMAKHUVUC(), resultTime);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChiTietPhanCongKhuVucView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_nguoiDungChuaDuocPhanCongActionPerformed

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
            java.util.logging.Logger.getLogger(ChiTietPhanCongKhuVucView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhanCongKhuVucView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhanCongKhuVucView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhanCongKhuVucView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietPhanCongKhuVucView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apDung;
    private javax.swing.JTable bangPhanCongNhanVien;
    private javax.swing.JButton chinhSua;
    private javax.swing.JButton datLai;
    private javax.swing.JComboBox<String> dsThoiGianPhanCong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameArea;
    private javax.swing.JButton nguoiDungChuaDuocPhanCong;
    private javax.swing.JButton tuDongPhanCong;
    private javax.swing.JButton xemThongTin;
    // End of variables declaration//GEN-END:variables
}
