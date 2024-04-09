
package views.main.Worker;

import controllers.Worker.WorkerController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Worker.ChuHoModel;
import models.Worker.GhiNuocModel;
import models.Worker.GlobalData;



public class GhiDienSoNuoc extends javax.swing.JPanel {
    
    private workerMain wMain;
    private ChuHoModel chuHoModel;
    private WorkerController workerController = new WorkerController();

    public GhiDienSoNuoc(workerMain wMain) {
        this.wMain = wMain;
        initComponents();
        setDefault();
    }

    public void setDefault(){
        lb_branch.setText("Chi nhánh "+GlobalData.getInstance().getBranch());
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        text_date.setText(formattedDate);
        if(chuHoModel != null){
            lb_MADH.setText(chuHoModel.getMaDH());
            lb_nameUser.setText(chuHoModel.getHoTen());
            lb_address.setText(chuHoModel.getDiaChiDatNuoc());
            lb_phoneNo.setText(chuHoModel.getSdt());
            text_currentIndex.setText("");
            //----- set value of PrevIndex ----
            GhiNuocModel ghiNuocModel = workerController.getGhiNuocMoiNhat(chuHoModel.getMaDH());
            if(ghiNuocModel!= null){
                text_preIndex.setText(String.valueOf(ghiNuocModel.getCSC()));
                text_currentIndex.setText(String.valueOf(ghiNuocModel.getCSM()));
                lb_ngayBatDauGhi.setText(ghiNuocModel.getNgayBatDauGhi());
                lb_NgayDenHan.setText(ghiNuocModel.getNgayHanGhi());
                text_currentIndex.setEditable(true);
                lb_notificaiton.setText("");
                button_save.setEnabled(true);
            }else{    
                text_preIndex.setText(String.valueOf(0));
                text_currentIndex.setText(String.valueOf(0));
                text_currentIndex.setEditable(false);
                lb_notificaiton.setText("Tháng này chưa có đơn ghi nước, vui lòng liên hệ Quản Lý!");
                lb_ngayBatDauGhi.setText("");
                lb_NgayDenHan.setText("");
                button_save.setEnabled(false);
            }
            
        }
        
    }

    public ChuHoModel getChuHoModel() {
        return chuHoModel;
    }

    public void setChuHoModel(ChuHoModel chuHoModel) {
        this.chuHoModel = chuHoModel;
    }

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lb_branch = new javax.swing.JLabel();
        button_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lb_MADH = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lb_nameUser = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        text_currentIndex = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_address = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lb_phoneNo = new javax.swing.JLabel();
        text_preIndex = new javax.swing.JTextField();
        text_date = new javax.swing.JTextField();
        lb_notificaiton = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb_ngayBatDauGhi = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lb_NgayDenHan = new javax.swing.JLabel();
        button_save = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1000, 720));

        jPanel1.setBackground(new java.awt.Color(235, 239, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        jPanel7.setBackground(new java.awt.Color(235, 239, 254));

        lb_branch.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        lb_branch.setForeground(new java.awt.Color(5, 205, 153));
        lb_branch.setText("Chi nhánh Tân Phú");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_branch)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lb_branch)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        button_back.setBackground(new java.awt.Color(134, 140, 255));
        button_back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button_back.setForeground(new java.awt.Color(255, 255, 255));
        button_back.setText("Quay lại");
        button_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(43, 54, 116));
        jLabel1.setText("Ghi Nước");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_back)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(button_back)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(235, 239, 254));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(544, 250));

        jLabel3.setText("Mã Đồng Hồ:");

        lb_MADH.setText("CH001");

        jLabel5.setText("Họ và tên:");

        lb_nameUser.setText("Lê Văn A");

        jLabel7.setText("Số nước cũ:");

        jLabel9.setText("Số nước mới:");

        text_currentIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_currentIndexActionPerformed(evt);
            }
        });

        jLabel10.setText("Thời gian ghi:");

        jLabel2.setText("Địa chỉ ghi nước:");

        lb_address.setText("acb, Tân Phú, Tp HCM");

        jLabel12.setText("Số điện thoại:");

        lb_phoneNo.setText("0121243423");

        text_preIndex.setText("100");
        text_preIndex.setEnabled(false);

        text_date.setEditable(false);

        lb_notificaiton.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lb_notificaiton.setForeground(new java.awt.Color(255, 0, 0));
        lb_notificaiton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel4.setText("Hạn Ghi:");

        jLabel6.setText("Từ ngày:");

        lb_ngayBatDauGhi.setText("01/01/2024");

        jLabel11.setText("Đến Ngày:");

        lb_NgayDenHan.setText("05/01/2024");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_notificaiton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9))
                            .addGap(19, 19, 19)))
                    .addComponent(jLabel10)
                    .addComponent(jLabel4))
                .addGap(88, 88, 88)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_preIndex)
                    .addComponent(text_currentIndex)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_nameUser)
                            .addComponent(lb_address)
                            .addComponent(lb_MADH)
                            .addComponent(lb_phoneNo)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_ngayBatDauGhi)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_NgayDenHan))
                            .addComponent(text_date))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(239, 239, 239))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_MADH)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lb_nameUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lb_address))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lb_phoneNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(lb_ngayBatDauGhi)
                    .addComponent(jLabel11)
                    .addComponent(lb_NgayDenHan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(text_preIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(text_currentIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(text_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_notificaiton, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        button_save.setBackground(new java.awt.Color(134, 140, 255));
        button_save.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button_save.setForeground(new java.awt.Color(255, 255, 255));
        button_save.setText("Lưu");
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_save)
                .addGap(234, 234, 234))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_save)
                .addContainerGap(301, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void text_currentIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_currentIndexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_currentIndexActionPerformed

    private void button_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_backActionPerformed

        wMain.setVisibleStack();
    }//GEN-LAST:event_button_backActionPerformed
    
    private String renderIdBill(){
        String id_bill = "";
        try {
            id_bill = workerController.getIdBill();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GhiDienSoNuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(id_bill.equals("")){
            id_bill = "MD1";
        }else{
            int newNumber = Integer.parseInt(id_bill.substring(2)) + 1;
            id_bill = "MD" + String.valueOf(newNumber);
        }
        return id_bill;
    }
    private boolean checkInput(){
        if(text_currentIndex.equals("")){
            JOptionPane.showMessageDialog(this, "Mã số nước mới không được để trống!", "Thông báo",JOptionPane.OK_OPTION);
            return false;
        }

        if (!(text_currentIndex.getText().matches("[0-9]+(\\.[0-9]+)?"))) {
            JOptionPane.showMessageDialog(this, "Số nước nhập vào phải là số!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        
        if(Integer.parseInt(String.valueOf(text_preIndex.getText())) >= Integer.parseInt(String.valueOf(text_currentIndex.getText()))){
            JOptionPane.showMessageDialog(this, "Số nước mới không hợp lệ!", "Thông báo", JOptionPane.OK_OPTION);
            return false;
        }
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateNow = currentDate.format(formatter);
        String message = "Đã quá hạn ghi nước, vui lòng liên hệ quản lý để xử lý!";
        
        if(!dateNow.substring(6).equals(lb_NgayDenHan.getText().substring(6))){
            JOptionPane.showMessageDialog(this, message, "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }
        
        if(!dateNow.substring(3, 5).equals(lb_NgayDenHan.getText().substring(3, 5))){
            JOptionPane.showMessageDialog(this, message, "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }
        int beginDay = Integer.parseInt(lb_ngayBatDauGhi.getText().substring(0, 2));
        int endDay = Integer.parseInt(lb_NgayDenHan.getText().substring(0, 2));
        int ngayGhi = Integer.parseInt(dateNow.substring(0, 2));
        
        if(ngayGhi > endDay || ngayGhi < beginDay){
            JOptionPane.showMessageDialog(this, message, "Thông Báo", JOptionPane.OK_OPTION);
            return false;
        }
        
        return true;
    }
    
    
    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        if(checkInput()){
            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn lưu không?","Thông báo",JOptionPane.OK_CANCEL_OPTION);
            if(option == JOptionPane.OK_OPTION){
                GhiNuocModel ghiNuocModel = workerController.getGhiNuocMoiNhat(chuHoModel.getMaDH());
                
                ghiNuocModel.setCSM(Integer.parseInt(text_currentIndex.getText()));
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                ghiNuocModel.setNgayGhi(currentDate.format(formatter));
                ghiNuocModel.setMaNV(GlobalData.getInstance().getNhanVienModel().getMaNV());
                System.out.println(ghiNuocModel.getMaNV());
                
                workerController.recordGhiNuocHoDan(ghiNuocModel);
                JOptionPane.showMessageDialog(this, "Thành Công!", "Thông báo",JOptionPane.OK_OPTION);
                
                setDefault();
                wMain.setBillsChuHo_DienSoNuoc(chuHoModel);
                wMain.setVisibleAllFalse();
                if(GlobalData.getInstance().getLengthStack() != 1){
                    wMain.setVisibleStack();
                }else{
                    wMain.setVisibleDienSoNuoc(true);
                    
                }
                
            }
        }
    }//GEN-LAST:event_button_saveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_back;
    private javax.swing.JButton button_save;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lb_MADH;
    private javax.swing.JLabel lb_NgayDenHan;
    private javax.swing.JLabel lb_address;
    private javax.swing.JLabel lb_branch;
    private javax.swing.JLabel lb_nameUser;
    private javax.swing.JLabel lb_ngayBatDauGhi;
    private javax.swing.JLabel lb_notificaiton;
    private javax.swing.JLabel lb_phoneNo;
    private javax.swing.JTextField text_currentIndex;
    private javax.swing.JTextField text_date;
    private javax.swing.JTextField text_preIndex;
    // End of variables declaration//GEN-END:variables
}
