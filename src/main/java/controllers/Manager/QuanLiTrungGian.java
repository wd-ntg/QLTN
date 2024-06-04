/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.Manager;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.NhanVienModel;
import models.TaiKhoanModel;
import models.TrungGianModel;
import utils.PasswordHashing;

/**
 *
 * @author GIANG
 */
public class QuanLiTrungGian {

    public static void themTrungGian(TrungGianModel trungGian, TaiKhoanModel taikhoan, String tenChiTietDiaChi, String MaKhuVuc) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        PreparedStatement statement3 = null;

        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra sự tồn tại của MATK trong TAIKHOAN
            String checkSQL1 = "SELECT COUNT(*) FROM TAIKHOAN WHERE MATK = ?";
            statement = connection.prepareStatement(checkSQL1);
            statement.setString(1, taikhoan.getMATK());
            ResultSet rs1 = statement.executeQuery();
            if (rs1.next() && rs1.getInt(1) > 0) {
                System.out.println("MATK đã tồn tại. Không thể chèn bản ghi mới.");
                return;
            }

            // Chèn dữ liệu vào bảng TAIKHOAN
            String sql2 = "INSERT INTO TAIKHOAN (MATK, EMAIL, MATKHAU, MAPQ) VALUES (?, ?, ?, ?)";
            statement2 = connection.prepareStatement(sql2);
            statement2.setString(1, taikhoan.getMATK());
            statement2.setString(2, taikhoan.getEMAIL());
            String hashPassword = PasswordHashing.hashPassword(taikhoan.getEMAIL());
            statement2.setString(3, hashPassword);
            statement2.setString(4, taikhoan.getMAPQ());
            statement2.executeUpdate();

            // Kiểm tra sự tồn tại của MACTKV trong CHITIETKHUVUC
            String checkSQL2 = "SELECT COUNT(*) FROM CHITIETKHUVUC WHERE MACTKV = ?";
            statement = connection.prepareStatement(checkSQL2);
            statement.setString(1, trungGian.getMACTVK());
            ResultSet rs2 = statement.executeQuery();
            if (rs2.next() && rs2.getInt(1) > 0) {
                System.out.println("MACTKV đã tồn tại. Không thể chèn bản ghi mới.");
                return;
            }

            // Chèn dữ liệu vào bảng CHITIETKHUVUC
            String sql3 = "INSERT INTO CHITIETKHUVUC (MACTKV, TENCHITIET, MAKHUVUC) VALUES (?, ?, ?)";
            statement3 = connection.prepareStatement(sql3);
            statement3.setString(1, trungGian.getMACTVK());
            statement3.setString(2, tenChiTietDiaChi);
            statement3.setString(3, MaKhuVuc);
            statement3.executeUpdate();

            // Kiểm tra sự tồn tại của MATG trong TRUNGGIAN
            String checkSQL3 = "SELECT COUNT(*) FROM TRUNGGIAN WHERE MATG = ?";
            statement = connection.prepareStatement(checkSQL3);
            statement.setString(1, trungGian.getMATG());
            ResultSet rs3 = statement.executeQuery();
            if (rs3.next() && rs3.getInt(1) > 0) {
                System.out.println("MATG đã tồn tại. Không thể chèn bản ghi mới.");
                return;
            }

            // Chèn dữ liệu vào bảng TRUNGGIAN
            String sql = "INSERT INTO TRUNGGIAN (MATG, TENTG, MACTKV) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, trungGian.getMATG());
            statement.setString(2, trungGian.getTENTG());
            statement.setString(3, trungGian.getMACTVK());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Đóng các PreparedStatement và Connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement2 != null) {
                try {
                    statement2.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement3 != null) {
                try {
                    statement3.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static List<TrungGianModel> timTatCaTrungGian() throws ClassNotFoundException {
        List<TrungGianModel> dsTrungGian = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT TG.MACTKV, TG.MATG, CTKV.MAKHUVUC, TG.TENTG, CTKV.MACTKV, CTKV.TENCHITIET, TK.EMAIL, TK.MAPQ, TK.TGDANGKY\n"
                    + "FROM TRUNGGIAN TG\n"
                    + "JOIN TAIKHOAN AS TK ON TK.MATK = TG.MATG\n"
                    + "JOIN CHITIETKHUVUC AS CTKV ON CTKV.MACTKV = TG.MACTKV";

            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maTG = resultSet.getString("MATG");
                String maKhuVuc = resultSet.getString("MAKHUVUC");
                String tenTG = resultSet.getString("TENTG");
                String maChiTietKhuVuc = resultSet.getString("MACTKV");
                String tenChiTietDiaChi = resultSet.getString("TENCHITIET");
                String email = resultSet.getString("EMAIL");
                String maPQ = resultSet.getString("MAPQ");
                String thoiGianDangKy = resultSet.getString("TGDANGKY");
                TrungGianModel trungGianModel = new TrungGianModel(maTG, tenTG, maChiTietKhuVuc, maKhuVuc, tenChiTietDiaChi, email, maPQ, thoiGianDangKy);
                dsTrungGian.add(trungGianModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsTrungGian;
    }

    public static void XoaTrungGian(String maTrungGian, String maChiTietKhuVuc) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        PreparedStatement statement3 = null;
        try {
            connection = ConnectDB.getConnection();

            // Xóa từ bảng TRUNGGIAN
            String sql1 = "DELETE FROM TRUNGGIAN WHERE MATG = ?";
            statement1 = connection.prepareStatement(sql1);
            statement1.setString(1, maTrungGian);
            statement1.executeUpdate();

            // Xóa từ bảng CHITIETKHUVUC
            String sql2 = "DELETE FROM CHITIETKHUVUC WHERE MACTKV = ?";
            statement2 = connection.prepareStatement(sql2);
            statement2.setString(1, maChiTietKhuVuc);
            statement2.executeUpdate();

            // Xóa từ bảng CHITIETKHUVUC
            String sql3 = "DELETE FROM TAIKHOAN WHERE MATK = ?";
            statement3 = connection.prepareStatement(sql3);
            statement3.setString(1, maTrungGian);
            statement3.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement2 != null) {
                try {
                    statement2.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
