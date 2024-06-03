
package controllers.Manager;

import controllers.Worker.WorkerController;
import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.HopDongModel1;
import models.KhuVucModel;
import models.WaterCategoryModel;
import models.Worker.HoaDonModel;
import utils.SimilarString;


public class HopDongCtrl1 {
    public List<HopDongModel1> getHopDongModel1s(String where, Object ... search){
        List<HopDongModel1> lsHopDongModel1s = new ArrayList<>();
        String sql = """
                     select * from HOPDONG
                     where TRANGTHAI = 'DANGCHODUYET'
                     """ + where;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            for(int i = 0; i< search.length; i++){
                statement.setObject(i+2, search[i]);
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                HopDongModel1 hopDongModel1 = new HopDongModel1(
                        rs.getString("MAHD"),
                        rs.getString("TENHD"),
                        rs.getString("TENNGUOIDANGKY"),
                        rs.getString("DIACHIEMAIL"),
                        rs.getString("DIADIEMDANGKY"),
                        rs.getString("NDHD"),
                        rs.getString("TRANGTHAI"),
                        rs.getString("NGUOIKYDUYET"),
                        rs.getString("DULIEUCCCD"),
                        rs.getString("DULIEUCHUNGMINHNHADAT"),
                        rs.getString("DULIEUCHUKY"),
                        (Date) rs.getDate("NGAYDANGKY"),
                        rs.getString("SODIENTHOAI"),
                        rs.getString("CCCD"),
                        rs.getString("LOAINUOC"),
                        (Date) rs.getDate("NGAYTAOHD")
                );
                lsHopDongModel1s.add(hopDongModel1);
            }
            return lsHopDongModel1s;
        }
        catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int deleteHopDong(String maHD){
        String sql = """
                     delete from HOPDONG
                     where MAHD = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, maHD);          
            int rs = statement.executeUpdate();
            return rs;
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public WaterCategoryModel getLoaiNuocByID(String maLoai){
        WaterCategoryModel loaiNuoc = new WaterCategoryModel();
        String sql = """
                     select * from LOAI
                     where MALOAI = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, maLoai);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                loaiNuoc.setMaLoai(rs.getString("MALOAI"));
                loaiNuoc.setTenLoai(rs.getString("TENLOAI"));
                loaiNuoc.setPhiTre(rs.getDouble("PHITRE"));
            }
            return loaiNuoc;
        }catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int updateHopDong(HopDongModel1 hd){
        String sql = """
                     UPDATE HOPDONG
                     SET NGUOIKYDUYET = ?, NGAYTAOHD = ?, NDHD = ?, TRANGTHAI = ?
                     WHERE MAHD = ?;
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            java.sql.Date sqlDate = new java.sql.Date(hd.getNgayTaoHD().getTime());
            statement.setString(1, hd.getNguoiKyDuyet());
            statement.setDate(2,sqlDate);
            statement.setString(3, hd.getNdhd());
            statement.setString(4, "DADUYET");
            statement.setString(5, hd.getMaHD());
            int rs = statement.executeUpdate();
            return 1;
        }catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public String taoCTKV(String diachiDK){
        KhuVucCtrl khuVucCtrl = new KhuVucCtrl();
        List<KhuVucModel> khuVucModels = new ArrayList<>();
        String maKV = "AE1";
        String maCTKV = null;
        SimilarString similarString = new SimilarString();
        try {
            khuVucModels = khuVucCtrl.timTatCaKhuvuc();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HopDongCtrl1.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(KhuVucModel kv: khuVucModels){
            if(similarString.isSimilar(kv.getTENKHUVUC(), diachiDK) == 1){
                maKV = kv.getMAKHUVUC();
            }
        }
        String sql = """
                     INSERT INTO CHITIETKHUVUC(MACTKV, TENCHITIET, MAKHUVUC) VALUES (?, ?, ?);
                     """;
       
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss");
            String dateString = dateFormat1.format(currentDate);
            maCTKV = "DC" + dateString;
            
            statement.setString(1, maCTKV);
            statement.setString(2,diachiDK);
            statement.setString(3, maKV);
            int rs = statement.executeUpdate();
            return maCTKV;
        }catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String taoDongHo(String maCH,String diachiDK, String loaiNuocDK){
        String maCTKV = taoCTKV(diachiDK);
        String sql = """
                     INSERT INTO DONGHO(MADH, TENDH, MALOAI, MACH, MADIACHI, TRANGTHAI, NGAYHOATDONG) VALUES (?, ?, ?,?,?,?,?);
                     """;
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = dateFormat1.format(currentDate);
        String maDH = "DH" + dateString;
        Date date = new Date();
        
        // Định dạng muốn chuyển đổi
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        // Chuyển đổi Date thành chuỗi
        String formattedDate = sdf.format(date);
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, maDH);            
            statement.setString(2, "Đồng hồ dân dụng");
            statement.setString(3, loaiNuocDK);
            statement.setString(4, maCH);
            statement.setString(5, maCTKV);
            statement.setBoolean(6, true);
            statement.setString(7,formattedDate);
            
            int rs = statement.executeUpdate();
            return maDH;
        }catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
