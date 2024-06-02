
package controllers.Manager;

import controllers.Worker.WorkerController;
import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.HopDongModel1;
import models.WaterCategoryModel;
import models.Worker.HoaDonModel;


public class HopDongCtrl1 {
    public List<HopDongModel1> getHopDongModel1s(String where, Object ... search){
        List<HopDongModel1> lsHopDongModel1s = new ArrayList<>();
        String sql = """
                     select * from HOPDONG
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
                        rs.getBoolean("TRANGTHAI"),
                        rs.getString("NGUOIKYDUYET"),
                        rs.getString("DULIEUCCCD"),
                        rs.getString("DULIEUCHUNGMINHNHADAT"),
                        rs.getString("DULIEUCHUKY"),
                        (Date) rs.getDate("NGAYDANGKY"),
                        rs.getString("SODIENTHOAI"),
                        rs.getString("CCCD"),
                        rs.getString("LOAINUOC")
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
}
