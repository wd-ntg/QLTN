/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.Manager;

import java.util.Random;
import database.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DataGlobal;
import models.NhanVienModel;

import models.TaiKhoanModel;

/**
 *
 * @author GIANG
 */
public class QuanLiNhanVienCtrl {

    public static void themNhanVien(NhanVienModel nhanvien, TaiKhoanModel taikhoan) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();

            // Câu lệnh SQL chèn dữ liệu vào bảng Account
            String sql2 = "INSERT INTO TAIKHOAN (MATK, EMAIL, MATKHAU, MAPQ) VALUES (?, ?, ?, ?)";
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            statement2.setString(1, taikhoan.getMATK());
            statement2.setString(2, taikhoan.getEMAIL());
            statement2.setString(3, nhanvien.getSDT());
            statement2.setString(4, taikhoan.getMAPQ());
// hashedPassword là chuỗi mật khẩu đã được băm
            statement2.executeUpdate();

            if (taikhoan.getMAPQ().equals("R1")) {
                String sql = "INSERT INTO QUANLY (MANV, HOTEN, SDT, NGAYLAM, CCCD) VALUES (?, ?, ?, ?, ?)";
                statement = connection.prepareStatement(sql);

                statement.setString(1, nhanvien.getMANV());
                statement.setString(2, nhanvien.getHOTEN());
                statement.setString(3, nhanvien.getSDT());
                statement.setString(4, nhanvien.getNGAYLAM());
                statement.setString(5, nhanvien.getCCCD());
//            String hashedPassword = PasswordHashing.hashPassword(nv.getMatKhau());
                statement.executeUpdate();
            } else {
                String sql = "INSERT INTO NHANVIEN (MANV, HOTEN, SDT, NGAYLAM, CCCD, GIOITINH, MAKHUVUC) VALUES (?, ?, ?, ?, ?, ?, ?)";
                statement = connection.prepareStatement(sql);

                statement.setString(1, nhanvien.getMANV());
                statement.setString(2, nhanvien.getHOTEN());
                statement.setString(3, nhanvien.getSDT());
                statement.setString(4, nhanvien.getNGAYLAM());
                statement.setString(5, nhanvien.getCCCD());
                statement.setString(6, nhanvien.getGIOITINH());
                statement.setString(7, nhanvien.getMAKHUVUC());
//            String hashedPassword = PasswordHashing.hashPassword(nv.getMatKhau());
                statement.executeUpdate();
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

    }

    public static List<NhanVienModel> timTatCaNhanVien() throws ClassNotFoundException {
        List<NhanVienModel> dsNhanvien = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT NV.MANV, NV.HOTEN, NV.SDT, NV.NGAYLAM, NV.CCCD, NV.GIOITINH, NV.MAKHUVUC, TAIKHOAN.EMAIL, TAIKHOAN.MAPQ, KV.TENKHUVUC, PQ.TENQUYEN "
                    + "FROM NHANVIEN NV "
                    + "JOIN KHUVUC KV ON KV.MAKHUVUC = NV.MAKHUVUC "
                    + "JOIN TAIKHOAN ON TAIKHOAN.MATK = NV.MANV "
                    + "JOIN PHANQUYEN PQ ON PQ.MAPQ = TAIKHOAN.MAPQ "
                    + "WHERE TAIKHOAN.TRANGTHAI = 'TRUE'";

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String maNhanVien = resultSet.getString("MANV");
                String hoTen = resultSet.getString("HOTEN");
                String soDienThoai = resultSet.getString("SDT");
                String ngayLam = resultSet.getString("NGAYLAM");
                String cccd = resultSet.getString("CCCD");
                String gioiTinh = resultSet.getString("GIOITINH");
                String maKhuVuc = resultSet.getString("TENKHUVUC");
                String chucVu = resultSet.getString("TENQUYEN");
                String email = resultSet.getString("EMAIL");
                NhanVienModel nhanVienModel = new NhanVienModel(maNhanVien, hoTen, soDienThoai, ngayLam, cccd, gioiTinh, maKhuVuc, chucVu, email);
                dsNhanvien.add(nhanVienModel);
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

        return dsNhanvien;
    }

    public static void XoaNhanVien(String Email) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE TAIKHOAN SET TRANGTHAI= ? WHERE EMAIL = ?";

            statement = connection.prepareStatement(sql);

            statement.setString(1, "False");
            statement.setString(2, Email);

            statement.executeUpdate();

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
    }

    public static void CapNhatNhanVien(NhanVienModel nhanvien, String email, String maNV) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;

        System.out.println(nhanvien.getHOTEN());

        try {
            connection = ConnectDB.getConnection();
            String sql1 = "UPDATE NHANVIEN SET HOTEN=?, SDT=?, CCCD=?, GIOITINH=?, MAKHUVUC=? WHERE MANV=?";
            statement = connection.prepareStatement(sql1);

            statement.setString(1, nhanvien.getHOTEN());
            statement.setString(2, nhanvien.getSDT());
            statement.setString(3, nhanvien.getCCCD());
            statement.setString(4, nhanvien.getGIOITINH());
            statement.setString(5, nhanvien.getMAKHUVUC());
            statement.setString(6, maNV);

            statement.executeUpdate();

            // Tạo một PreparedStatement mới cho câu lệnh sql2
            String sql2 = "UPDATE TAIKHOAN SET MAPQ=? WHERE EMAIL=?";
            PreparedStatement statement2 = connection.prepareStatement(sql2);

            statement2.setString(1, nhanvien.getCHUCVU());
            statement2.setString(2, email);

            statement2.executeUpdate();

            System.out.println("Thông tin nhân viên đã được cập nhật thành công.");
        } catch (SQLException ex) {
            System.err.println("Lỗi khi cập nhật thông tin nhân viên: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi khi đóng câu lệnh: " + ex.getMessage());
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi khi đóng kết nối: " + ex.getMessage());
            }
        }
    }

}
