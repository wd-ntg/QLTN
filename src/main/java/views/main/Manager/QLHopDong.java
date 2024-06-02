
package views.main.Manager;

import controllers.Manager.HopDongCtrl1;
import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.HopDongModel1;
import models.Worker.ChuHoModel;
import models.Worker.GlobalData;
import utils.SendEmailHopDong;
import utils.customCode.Table.TableCustom;
import utils.customCode.TableButton.TableActionCellEditor;
import utils.customCode.TableButton.TableActionCellEditor_One;
import utils.customCode.TableButton.TableActionCellEditor_Two;
import utils.customCode.TableButton.TableActionCellRender;
import utils.customCode.TableButton.TableActionCellRender_One;
import utils.customCode.TableButton.TableActionCellRender_Two;
import utils.customCode.TableButton.TableActionEvent;
import utils.customCode.TableButton.TableActionEvent_One;
import utils.customCode.TableButton.TableActionEvent_Two;


public class QLHopDong extends javax.swing.JPanel {
    ManagerMain managerMain;
    private List<HopDongModel1> lsHopDongModel1s = new ArrayList<>();
    private HopDongCtrl1 hopDongCtrl1 = new HopDongCtrl1();
    private DefaultTableModel tblModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            if(column == 9 || column == 8 || column == 7 || column == 6){
                return true;
            }
            return false;
        }
        
    };

    public QLHopDong() {
        this.managerMain = GlobalData.getInstance().getManagerMain();
        initComponents();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        initTable();
        fillTableHopDong("");
    }
    private void initTable() {
        String[] header = new String[]{"MAHD","Tên Hợp Đồng","Tên Chủ Hộ", "Email","Địa Điểm Đăng Ký","Ngày Đăng Ký", "CCCD", "Ảnh Nhà Đất", "Chữ Ký","Duyệt"};
        tblModel.setColumnIdentifiers(header);
        table.setModel(tblModel);
        table.getTableHeader().setFont(new Font("Times New Roman",Font.PLAIN, 18));
    }

    private void setingUITable(){
        TableColumn column1 = table.getColumnModel().getColumn(0);
        column1.setPreferredWidth(25);
        TableColumn column2 = table.getColumnModel().getColumn(1);
        column2.setPreferredWidth(75);
        TableColumn column3 = table.getColumnModel().getColumn(2);
        column3.setPreferredWidth(50);
        TableColumn column4 = table.getColumnModel().getColumn(3);
        column4.setPreferredWidth(50);
        TableColumn column5 = table.getColumnModel().getColumn(4);
        column5.setPreferredWidth(200);
        TableColumn column6 = table.getColumnModel().getColumn(5);
        column6.setPreferredWidth(50);
        TableColumn column7 = table.getColumnModel().getColumn(6);
        column7.setPreferredWidth(50);
        TableColumn column8 = table.getColumnModel().getColumn(7);
        column8.setPreferredWidth(50);
        TableColumn column9 = table.getColumnModel().getColumn(8);
        column9.setPreferredWidth(48);
    }
    
    private void fillTableHopDong(String where, Object ... text){
        tblModel.setRowCount(0);
        lsHopDongModel1s = hopDongCtrl1.getHopDongModel1s(where, text);
        for(HopDongModel1 hd: lsHopDongModel1s){
            tblModel.addRow(new String[]{
                String.valueOf(hd.getMaHD()),
                hd.getTenHD(),
                hd.getTenNguoiDangKy(),
                hd.getEmail(), 
                hd.getDiadiemDangKy(),
                String.valueOf(hd.getNgayDangKy()),
            });
        }
        tblModel.fireTableDataChanged();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer3 = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer4 = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        centerRenderer2.setHorizontalAlignment( JLabel.CENTER );
        centerRenderer3.setHorizontalAlignment( JLabel.CENTER );
        centerRenderer4.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer2 );
        table.getColumnModel().getColumn(7).setCellRenderer( centerRenderer3);
        table.getColumnModel().getColumn(8).setCellRenderer( centerRenderer4 );
        table.getColumnModel().getColumn(9).setCellRenderer( centerRenderer );
        TableActionEvent_Two event = new TableActionEvent_Two() {
            @Override
            public void onEdit(int row) {
                String idMAHD = String.valueOf(table.getValueAt(row, 0)).trim();
                for(HopDongModel1 hd: lsHopDongModel1s){
                    if(hd.getMaHD().equals(idMAHD)){
                        
                        break;
                    }
                }
            }

            @Override
            public void onDelete(int row) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);
            }

            @Override
            public void onView(int row) {
                String idMAHD = String.valueOf(table.getValueAt(row, 0));
                for(HopDongModel1 hd: lsHopDongModel1s){
                    if(hd.getMaHD().equals(idMAHD)){
                        int Option = JOptionPane.showConfirmDialog(QLHopDong.this, "Bạn có chắc muốn từ chối hợp đồng này?","Thông báo", JOptionPane.YES_NO_OPTION);
                        if(Option == JOptionPane.OK_OPTION){
                            // Xóa HopDong theo mã HD
//                            int status = hopDongCtrl1.deleteHopDong(idMAHD);
//                            if(status == 1){
//                                JOptionPane.showMessageDialog(QLHopDong.this, "Thành Công", "Thông báo",JOptionPane.OK_OPTION);
//                            }
                            fillTableHopDong("");
                            String text="Lỗi CCCD";
                            try {
                                // Gửi email cho người đăng ký - Dùng email họ đã đăng ký - Tự động
                                SendEmailHopDong.SendEmailHopDong(hd, text,"nguyenthanht632@gmail.com",false);
                            } catch (MessagingException | UnsupportedEncodingException ex) {
                                Logger.getLogger(QLHopDong.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    }
                }
            }
        };
        
        TableActionEvent_One event_One = new TableActionEvent_One() {
            @Override
            public void onEdit(int row, int column) {
                String idMAHD = String.valueOf(table.getValueAt(row, 0));
                int col = table.getSelectedColumn();
                for(HopDongModel1 hd: lsHopDongModel1s){
                    if(hd.getMaHD().equals(idMAHD)){
                        showDialog(row, col,hd);
                        break;
                    }
                }
            }

            @Override
            public void onDelete(int row, int column) {
                
            }

            @Override
            public void onView(int row, int column) {
                String idMAHD = String.valueOf(table.getValueAt(row, 0));
                int col = (table.getSelectedColumn());
                for(HopDongModel1 hd: lsHopDongModel1s){
                    if(hd.getMaHD().equals(idMAHD)){
                        showDialog(row, col, hd);
                        break;
                    }
                }
            }
        };
        
        
        table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender_One());
        table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor_One(event_One));
        table.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender_One());
        table.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor_One(event_One));
        table.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender_One());
        table.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor_One(event_One));
        
        table.getColumnModel().getColumn(9).setCellRenderer(new TableActionCellRender_Two());
        table.getColumnModel().getColumn(9).setCellEditor(new TableActionCellEditor_Two(event));
    }
    
    private void showDialog(int row, int col, HopDongModel1 hd){
        
//        Hiển thị CCCD
        switch (col) {
            case 6 -> createDialog(hd, "cccd");
            case 7 -> createDialog(hd, "sodo");
            case 8 -> createDialog(hd, "chukynd");
            default -> {
                return;
            }
        }
    }
    private void createDialog(HopDongModel1 hd,String loai){
        String imagePath = "src/main/java/images/hopDong" +"/"+hd.getMaHD()+"_"+loai+".jpg";
         // Tạo JDialog mới
            JDialog dialog = new JDialog(managerMain, "Image Dialog", true);
            dialog.setSize(500, 600);
            dialog.setLayout(new BorderLayout());

            File imageFile = new File(imagePath);

            if (imageFile.exists()) {
                // Tạo ImageIcon từ ảnh
                ImageIcon imageIcon = new ImageIcon(imagePath);

                // Tạo JLabel chứa ImageIcon
                JLabel imageLabel = new JLabel(imageIcon);
                dialog.add(imageLabel, BorderLayout.CENTER);
            } else {
                downLoadImg(hd.getDulieuCCCD(), imagePath);
            }

            // Đặt vị trí của JDialog ở giữa màn hình
            dialog.setLocationRelativeTo(null);

            // Hiển thị JDialog
            dialog.setVisible(true);
    }
    private void downLoadImg(String imageUrl,String outputPath){
        Path output = Paths.get(outputPath);
        try (InputStream inputstream = new URL(imageUrl).openStream()){
            Files.copy(inputstream, output,StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải file");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        textFieldSearchOption1 = new utils.customCode.TextField.TextFieldSearchOption();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MAHD", "Tên Hợp Đồng", "Tên Chủ Hộ", "Emai", "Địa điểm đăng ký", "CCCD", "Ảnh Nhà Đất", "Chữ Ký", "Ngày Đăng Ký", "Xem HĐ/Duyệt HĐ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Danh Sách Hợp Đồng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 536, Short.MAX_VALUE)
                .addComponent(textFieldSearchOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textFieldSearchOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private utils.customCode.TextField.TextFieldSearchOption textFieldSearchOption1;
    // End of variables declaration//GEN-END:variables
}
