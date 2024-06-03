
package views.main.Manager;

import controllers.Manager.HopDongCtrl1;
import controllers.Manager.QuanLiChuHoCtrl;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import models.ChuHoModel;
import models.DataGlobal;
import models.HopDongModel1;
import models.QuanLyModel;
import models.TaiKhoanModel;
import models.Worker.GlobalData;
import utils.SendEmailHopDong;
import views.main.client.ChuKyDienTuPanel;
import views.main.client.CloudinaryUploader;



public class XemHopDong extends javax.swing.JFrame {
    QuanLyModel quanly = DataGlobal.getDataGLobal.dataGlobal.getPhienQLHienTai();
    HopDongCtrl1 hopDongCtrl1 = new HopDongCtrl1();
    private HopDongModel1 hopDong = new HopDongModel1();
    private CloudinaryUploader uploader;
    private QuanLiChuHoCtrl quanLiChuHoCtrl = new QuanLiChuHoCtrl();
    
    public XemHopDong(HopDongModel1 hopDong) {
        this.hopDong = hopDong;
        initComponents();
        setInit();
    }
    private void setInit(){
        LocalDate currentDate = LocalDate.now();
        lb_day.setText(String.valueOf(currentDate.getDayOfMonth()));
        lb_month.setText(String.valueOf(currentDate.getMonthValue()));
        lb_year.setText(String.valueOf(currentDate.getYear()));
        lb_nameQL.setText(quanly.getHOTEN());
        lb_nameCH.setText(hopDong.getTenNguoiDangKy());
        lb_cccdCH.setText(hopDong.getCccd());
        lb_DiaChiDK.setText(hopDong.getDiadiemDangKy());
        lb_sdtCH.setText(hopDong.getSodienthoai());
        lb_LoaiNuocDK.setText(hopDongCtrl1.getLoaiNuocByID(hopDong.getLoaiNuoc()).getTenLoai());
        addsignTolabel();
        lb_nameCHKy.setText(hopDong.getTenNguoiDangKy());
        lb_nameQLKY.setText(quanly.getHOTEN());
        
    }
    private void addsignTolabel(){
        String imagePath = "src/main/java/images/hopDong" +"/"+hopDong.getMaHD()+"_"+"chukynd"+".png";
        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            if(downLoadImg(hopDong.getDuLieuChuKy(), imagePath)==0){
                return;
            }
        }
        // Tạo ImageIcon từ ảnh
        ImageIcon imageIcon = new ImageIcon(imagePath);
        lb_khungchukynd.setIcon(imageIcon);
        lb_khungchukynd.setHorizontalAlignment(JLabel.CENTER);
        lb_khungchukynd.setVerticalAlignment(JLabel.CENTER);
        pn_chukynd.revalidate();
        pn_chukynd.repaint();
    }
    
    private int downLoadImg(String imageUrl,String outputPath){
        Path output = Paths.get(outputPath);
        try (InputStream inputstream = new URL(imageUrl).openStream()){
            Files.copy(inputstream, output,StandardCopyOption.REPLACE_EXISTING);
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải file");
            return 0;
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lb_day = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb_year = new javax.swing.JLabel();
        lb_month = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lb_nameQL = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lb_Quyen = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lb_nameCH = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lb_cccdCH = new javax.swing.JLabel();
        lb_DiaChiDK = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lb_sdtCH = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lb_LoaiNuocDK = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        pn_chukyql = new javax.swing.JPanel();
        lb_khungchukyql = new javax.swing.JLabel();
        pn_chukynd = new javax.swing.JPanel();
        lb_khungchukynd = new javax.swing.JLabel();
        btn_KyQL = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        lb_nameQLKY = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lb_nameCHKy = new javax.swing.JLabel();
        btn_XacNhan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Độc Lập - Tự Do - Hạnh Phúc");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HỢP ĐỒNG DỊCH VỤ CẤP NƯỚC");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Căn cứ Bộ luật Dân sự số 91/2015/QH13 của Quốc Hội nước CHXHCN Việt Nam;\nCăn cứ Nghị định số 117/2007/NĐ-CP ngày 11/7/2007 của Chính phủ về sản xuất, \ncung cấp và tiêu thụ nước sạch.\nCăn cứ Thông tư số...... /2008/TT-BXD ngày.....tháng....năm 2008 \ncủa Bộ trưởng Bộ Xây dựng hướng dẫn thực hiện Nghị định số 117/2007/NĐ-CP \nngày 11/7/2007 của Chính phủ về sản xuất, cung cấp và tiêu thụ nước sạch.\nCăn cứ Quyết định số....../......ngày......tháng......năm...... của UBND...... (cấp tỉnh) \nban hành Quy định (quy chế ) về hoạt động sản xuất,\ncung cấp và tiêu thụ nước sạch trên địa bàn tỉnh.");
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Hôm nay, ngày");

        lb_day.setText("...");

        jLabel6.setText("tháng");

        jLabel7.setText("năm");

        lb_year.setText("...");

        lb_month.setText("...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_day)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_month)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lb_year)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lb_day)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(lb_year)
                    .addComponent(lb_month)))
        );

        jLabel10.setText("Chúng tôi gồm:");

        jLabel11.setText("I. Bên cung cấp dịch vụ (gọi tắt là Bên A)");

        jLabel13.setText("Tên đơn vị cấp nước:");

        jLabel14.setText("Công Ty Cấp Nước Quận Thủ Đức");

        jLabel15.setText("Đại diện là ông/bà:");

        lb_nameQL.setText("Nguyễn Văn A");

        jLabel17.setText("Chức Vụ:");

        lb_Quyen.setText("Quản Lý");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_nameQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_Quyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lb_nameQL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lb_Quyen))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel12.setText("II. Khách hàng sử dụng nước (gọi tắt là Bên B)");

        jLabel19.setText("Chủ hộ (hoặc tên cơ quan):");

        lb_nameCH.setText("Nguyễn Văn B");

        jLabel21.setText("Số CMND/CCCD:");

        jLabel22.setText("Địa chỉ mua nước:");

        lb_cccdCH.setText("042444233");

        lb_DiaChiDK.setText("123, Lê Văn Việt, Quận Thủ Đức, TP.HCM");

        jLabel25.setText("Điện thoại:");

        lb_sdtCH.setText("02341234");

        jLabel27.setText("Loại nước:");

        lb_LoaiNuocDK.setText("Dân dụng");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_DiaChiDK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lb_cccdCH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_nameCH, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addComponent(lb_sdtCH, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_LoaiNuocDK))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lb_nameCH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lb_cccdCH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lb_DiaChiDK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lb_sdtCH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lb_LoaiNuocDK))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setText("Cùng nhau thoả thuận ký kết hợp đồng dịch vụ cấp nước với các nội dung sau:");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Điều 1. Đối tượng của hợp đồng\n\nQuy định đối tượng của hợp đồng: mua bán nước sạch bảo đảm điều kiện \nchất lượng dịch vụ cam kết.\n\nĐiều 2. Điều kiện chất lượng dịch vụ\n\nQuy định chất lượng dịch vụ tại điểm đấu nối bao gồm chất lượng nước sạch,\náp lực, lưu lượng, tính liên tục của dịch vụ phù hợp với tiêu chuẩn do cơ quan\nnhà nước có thẩm quyền ban hành và thỏa thuận thực hiện dịch vụ cấp nước\nmà đơn vị cấp nước đã ký.\n\nĐiều 3. Giá nước sạch\n\nQuy định giá nước sạch cho các đối tượng và mục đích sử dụng nước khác nhau,\nphù hợp với biểu giá do Uỷ ban nhân dân cấp tỉnh ban hành \nvà phương án giá tiêu thụ nước sạch đã được phê duyệt;\nnguyên tắc áp dụng giá nước mới khi có quyết định điều chỉnh của\nUỷ ban nhân dân cấp tỉnh.");
        jTextArea2.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea2);

        pn_chukyql.setPreferredSize(new java.awt.Dimension(400, 300));

        lb_khungchukyql.setBackground(new java.awt.Color(255, 255, 255));
        lb_khungchukyql.setPreferredSize(new java.awt.Dimension(250, 150));

        javax.swing.GroupLayout pn_chukyqlLayout = new javax.swing.GroupLayout(pn_chukyql);
        pn_chukyql.setLayout(pn_chukyqlLayout);
        pn_chukyqlLayout.setHorizontalGroup(
            pn_chukyqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_chukyqlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_khungchukyql, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_chukyqlLayout.setVerticalGroup(
            pn_chukyqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_khungchukyql, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pn_chukynd.setPreferredSize(new java.awt.Dimension(400, 300));

        lb_khungchukynd.setBackground(new java.awt.Color(255, 255, 255));
        lb_khungchukynd.setPreferredSize(new java.awt.Dimension(250, 150));

        javax.swing.GroupLayout pn_chukyndLayout = new javax.swing.GroupLayout(pn_chukynd);
        pn_chukynd.setLayout(pn_chukyndLayout);
        pn_chukyndLayout.setHorizontalGroup(
            pn_chukyndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_khungchukynd, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        pn_chukyndLayout.setVerticalGroup(
            pn_chukyndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_khungchukynd, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        btn_KyQL.setText("Ký");
        btn_KyQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KyQLActionPerformed(evt);
            }
        });

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Bên cung cấp dịch vụ");

        lb_nameQLKY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_nameQLKY.setText("Nguyễn Văn A");

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Khách hàng sử dụng nước");

        lb_nameCHKy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_nameCHKy.setText("Nguyễn Văn B");

        btn_XacNhan.setText("Xác Nhận");
        btn_XacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_KyQL)
                            .addComponent(pn_chukyql, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lb_nameQLKY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pn_chukynd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(lb_nameCHKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btn_XacNhan)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_chukynd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn_chukyql, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nameQLKY)
                    .addComponent(lb_nameCHKy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_KyQL)
                    .addComponent(btn_XacNhan))
                .addContainerGap(313, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XacNhanActionPerformed
        if(GlobalData.getInstance().getStatus()!=0){
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn tạo hợp đồng này?","Thông báo", JOptionPane.OK_CANCEL_OPTION);
            if(choice == JOptionPane.OK_OPTION){
                String maDongHo = null;
                ChuHoModel chuho = null;
                TaiKhoanModel taikhoan  = null;
                String url = "src/main/java/images/hopDong" +"/"+hopDong.getMaHD()+"_"+"hopdong"+".png";
                //Chụp ảnh jframe này và upload lên icloud
                // 1. Chụp ảnh
                if(captureAndSaveFrame(url) == 1){
                    try {
                        JOptionPane.showMessageDialog(this, "Lưu hợp đồng thành công","Thông báo", JOptionPane.OK_OPTION);
                        // Tạo account cho người đăn ký && Tạo Thông tin chủ hộ cho người đăng ký
                            String HOTEN = hopDong.getTenNguoiDangKy();
                            String SDT = hopDong.getSodienthoai();
                            String CCCD = hopDong.getCccd();
                            //String MAPQ;
                            String MAPQ = "R3";
                            String EMAIL = hopDong.getEmail();
                            String DIACHITT = hopDong.getDiadiemDangKy();
                            java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss");
                            String dateString = dateFormat1.format(currentDate);
                            String MACH = "CH" + dateString;
                            chuho = new ChuHoModel(MACH, HOTEN, SDT, CCCD, DIACHITT, null);
                            taikhoan = new TaiKhoanModel(MACH, EMAIL, SDT, MAPQ );
                            quanLiChuHoCtrl.themChuHo(chuho, taikhoan);
                        // End
                        // Tạo Đồng hồ mới cho người đăng ký && Thêm địa chỉ chi tiết cho đồng hồ
                        maDongHo = hopDongCtrl1.taoDongHo(MACH, DIACHITT, hopDong.getLoaiNuoc());
                        
                        // clear table Hop Dong
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(XemHopDong.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Lưu hợp đồng thất bại","Thông báo", JOptionPane.OK_OPTION);
                }
                // End Chụp ảnh
                // upload file và cập nhật bảng HOPDONG
                File outputFile = new File(url);
                uploader = new CloudinaryUploader();
                String publicUrl = uploader.uploadFile(outputFile);
                hopDong.setNdhd(publicUrl);
                hopDong.setNguoiKyDuyet(DataGlobal.getDataGLobal.dataGlobal.getPhienQLHienTai().getMAQL());
                hopDong.setNgayTaoHD(new Date());
                int checkupdateHD = hopDongCtrl1.updateHopDong(hopDong);
                System.out.println("update hop dong: " + checkupdateHD);
                // Thoát chính nó
                this.dispose();
                GlobalData.getInstance().getManagerMain().setEnabled(true);
                // Gửi email thông báo thành công
                if(checkupdateHD == 1){
                    try {
                    String text = "Chúc mừng bạn đăng ký thành công!";
                    // Gửi email cho người đăng ký - Dùng email họ đã đăng ký - Tự động
                    SendEmailHopDong.SendEmailHopDong(hopDong, text,"nguyenthanht632@gmail.com",true,taikhoan,maDongHo);
                    } catch (MessagingException | UnsupportedEncodingException ex) {
                        Logger.getLogger(QLHopDong.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        }else{
            JOptionPane.showMessageDialog(this, "Hãy kí trước khi tạo hợp đồng", "Thông báo", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_btn_XacNhanActionPerformed

    private void btn_KyQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KyQLActionPerformed
        JFrame frame = new JFrame("Chữ Ký Điện Tử");
        ChuKyDienTuPanel chuKyPanel = new ChuKyDienTuPanel();
        JButton saveButton = new JButton("Lưu Chữ Ký");
        JButton clearButton = new JButton("Làm Sạch");
        String url = "src/main/java/images/hopDong" +"/"+hopDong.getMaHD()+"_"+"chukyql" + GlobalData.getInstance().getStatus()+".png";

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GlobalData.getInstance().setStatus(chuKyPanel.saveSignatureQL(url, GlobalData.getInstance().getStatus(), hopDong.getMaHD()));
                if(GlobalData.getInstance().getStatus() != 0){
                    File imageFile = new File(url);
                    
                    ImageIcon imageIcon = new ImageIcon(url);
                    lb_khungchukyql.setIcon(imageIcon);
                    lb_khungchukyql.setHorizontalAlignment(JLabel.CENTER);
                    lb_khungchukyql.setVerticalAlignment(JLabel.CENTER);
                    pn_chukyql.revalidate();
                    pn_chukyql.repaint();
                }
                frame.dispose(); // Đóng JFrame sau khi lưu

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chuKyPanel.clearSignature();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);

        frame.setLayout(new BorderLayout());
        frame.add(chuKyPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(250, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đặt JFrame để đóng khi tắt cửa sổ
        frame.setLocationRelativeTo(this); // Hiển thị cửa sổ ở giữa cửa sổ cha
        frame.setVisible(true);
    }//GEN-LAST:event_btn_KyQLActionPerformed
    
    
    
     // Hàm chụp ảnh hợp đồng:
    private int captureAndSaveFrame(String filePath){
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g2d = image.createGraphics();
        this.paintAll(g2d);
        g2d.dispose();
        
        File outputFile = new File(filePath);
        try {
            ImageIO.write(image, "png", outputFile);
            return 1;
        } catch (IOException ex) {
            Logger.getLogger(XemHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    // End hàm chụp ảnh hợp đồng
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
            java.util.logging.Logger.getLogger(XemHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XemHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XemHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XemHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TuChoiHopDong().setVisible(true);
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TuChoiHopDong().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_KyQL;
    private javax.swing.JButton btn_XacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lb_DiaChiDK;
    private javax.swing.JLabel lb_LoaiNuocDK;
    private javax.swing.JLabel lb_Quyen;
    private javax.swing.JLabel lb_cccdCH;
    private javax.swing.JLabel lb_day;
    private javax.swing.JLabel lb_khungchukynd;
    private javax.swing.JLabel lb_khungchukyql;
    private javax.swing.JLabel lb_month;
    private javax.swing.JLabel lb_nameCH;
    private javax.swing.JLabel lb_nameCHKy;
    private javax.swing.JLabel lb_nameQL;
    private javax.swing.JLabel lb_nameQLKY;
    private javax.swing.JLabel lb_sdtCH;
    private javax.swing.JLabel lb_year;
    private javax.swing.JPanel pn_chukynd;
    private javax.swing.JPanel pn_chukyql;
    // End of variables declaration//GEN-END:variables
}
