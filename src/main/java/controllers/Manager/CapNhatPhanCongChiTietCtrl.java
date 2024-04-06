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
import models.PhanCongModel;

/**
 *
 * @author GIANG
 */
public class CapNhatPhanCongChiTietCtrl {

    public static PhanCongModel timThongTinHienThiCapNhatPhanCong(String maPhanCong, String TimeAssign) throws ClassNotFoundException {

        PhanCongModel phanCongModel = new PhanCongModel();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT \n"
                    + "    NV.MANV AS MANV, \n"
                    + "    NV.HOTEN AS HOTENNV, \n"
                    + "    NV.SDT AS SDTNV,\n"
                    + "    TKNV.EMAIL AS EMAILNV,\n"
                    + "    CH.MACH AS MACH, \n"
                    + "    CH.HOTEN AS HOTENCH, \n"
                    + "    CH.SDT AS SDTCH,\n"
                    + "    TKCH.EMAIL AS EMAILCH,\n"
                    + "    CTKV.TENCHITIET AS TENDIACHIDATDONGHO,\n"
                    + "    KV.TENKHUVUC AS TENKHUVUC,\n"
                    + "    CTKV.MACTKV AS MADIACHI,\n"
                    + "    CTKV.TENCHITIET AS TENDIACHI,\n"
                    + "    L.MALOAI AS MALOAINUOC,\n"
                    + "    L.TENLOAI AS TENLOAINUOC\n"
                    + "FROM \n"
                    + "    PHANCONG PC\n"
                    + "JOIN \n"
                    + "    NHANVIEN NV ON NV.MANV = PC.MANV\n"
                    + "JOIN \n"
                    + "    QUANLY QL ON QL.MAQL = PC.MAQL\n"
                    + "JOIN \n"
                    + "    DONGHO DH ON DH.MADH = PC.MADH\n"
                    + "JOIN \n"
                    + "    CHUHO CH ON CH.MACH = DH.MACH\n"
                    + "JOIN \n"
                    + "    LOAI L ON L.MALOAI = DH.MALOAI\n"
                    + "JOIN \n"
                    + "    TAIKHOAN TKNV ON TKNV.MATK = NV.MANV\n"
                    + "JOIN \n"
                    + "    TAIKHOAN TKCH ON TKCH.MATK = CH.MACH\n"
                    + "JOIN \n"
                    + "    CHITIETKHUVUC CTKV ON CTKV.MACTKV = DH.MADIACHI\n"
                    + "JOIN \n"
                    + "    KHUVUC KV ON KV.MAKHUVUC = CTKV.MAKHUVUC\n"
                    + "WHERE \n"
                    + "   PC.MAPC = ? AND PC.NGAYPHAN LIKE ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maPhanCong);
            statement.setString(2, "%" + TimeAssign + "%");

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maNV = resultSet.getString("MANV");
                String hoTenNV = resultSet.getString("HOTENNV");
                String sdtNV = resultSet.getString("SDTNV");
                String emailNV = resultSet.getString("EMAILNV");
                String maCH = resultSet.getString("MACH");
                String hoTenCh = resultSet.getString("HOTENCH");
                String sdtCH = resultSet.getString("SDTCH");
                String emailCH = resultSet.getString("EMAILCH");
                String tenDiaChiDatDongHo = resultSet.getString("TENDIACHIDATDONGHO");
                String tenKhuVuc = resultSet.getString("TENKHUVUC");
                String maDiaChi = resultSet.getString("MADIACHI");
                String tenDiaChi = resultSet.getString("TENDIACHI");
                String maLoaiNuoc = resultSet.getString("MALOAINUOC");
                String tenLoaiNuoc = resultSet.getString("TENLOAINUOC");

                phanCongModel = new PhanCongModel(maNV, hoTenNV, sdtNV, emailNV, maCH, hoTenCh, sdtCH, emailCH, tenDiaChiDatDongHo, tenKhuVuc, maDiaChi, tenDiaChi, maLoaiNuoc, tenLoaiNuoc);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CapNhatPhanCongChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CapNhatPhanCongChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CapNhatPhanCongChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CapNhatPhanCongChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return phanCongModel;
    }

    public static PhanCongModel timThongTinHienThiCapNhatPhanCongNhanVienChuaPhanCong(String maPhanCong, String TimeAssign) throws ClassNotFoundException {

        PhanCongModel phanCongModel = new PhanCongModel();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT \n"
                    + "    CH.MACH AS MACH, \n"
                    + "    CH.HOTEN AS HOTENCH, \n"
                    + "    CH.SDT AS SDTCH,\n"
                    + "    TKCH.EMAIL AS EMAILCH,\n"
                    + "    CTKV.TENCHITIET AS TENDIACHIDATDONGHO,\n"
                    + "    KV.TENKHUVUC AS TENKHUVUC,\n"
                    + "    CTVK.MACTKV AS MADIACHI,\n"
                    + "    CTVK.TENCHITIET AS TENDIACHI,\n"
                    + "    L.MALOAI AS MALOAINUOC,\n"
                    + "    L.TENLOAI AS TENLOAINUOC\n"
                    + "FROM \n"
                    + "    PHANCONG PC\n"
                    + "JOIN \n"
                    + "    NHANVIEN NV ON NV.MANV = PC.MANV\n"
                    + "JOIN \n"
                    + "    QUANLY QL ON QL.MAQL = PC.MAQL\n"
                    + "JOIN \n"
                    + "    DONGHO DH ON DH.MADH = PC.MADH\n"
                    + "JOIN \n"
                    + "    CHUHO CH ON CH.MACH = DH.MACH\n"
                    + "JOIN \n"
                    + "    LOAI L ON L.MALOAI = DH.MALOAI\n"
                    + "JOIN \n"
                    + "    TAIKHOAN TKNV ON TKNV.MATK = NV.MANV\n"
                    + "JOIN \n"
                    + "    TAIKHOAN TKCH ON TKCH.MATK = CH.MACH\n"
                    + "JOIN \n"
                    + "    CHITIETKHUVUC CTKV ON CTKV.MACTKV = DH.MADIACHI\n"
                    + "JOIN \n"
                    + "    KHUVUC KV ON KV.MAKHUVUC = CTKV.MAKHUVUC\n"
                    + "WHERE \n"
                    + "    PC.MAPC = ? AND (PC.NGAYPHAN LIKE ? OR PC.NGAYPHAN IS NULL)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maPhanCong);
            statement.setString(2, "%" + TimeAssign + "%");

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maNV = "";
                String hoTenNV = "";
                String sdtNV = "";
                String emailNV = "";
                String maCH = resultSet.getString("MACH");
                String hoTenCh = resultSet.getString("HOTENCH");
                String sdtCH = resultSet.getString("SDTCH");
                String emailCH = resultSet.getString("EMAILCH");
                String tenDiaChiDatDongHo = resultSet.getString("TENDIACHIDATDONGHO");
                String tenKhuVuc = resultSet.getString("TENKHUVUC");
                String maDiaChi = resultSet.getString("MADIACHI");
                String tenDiaChi = resultSet.getString("TENDIACHI");
                String maLoaiNuoc = resultSet.getString("MALOAINUOC");
                String tenLoaiNuoc = resultSet.getString("TENLOAINUOC");

                phanCongModel = new PhanCongModel(maNV, hoTenNV, sdtNV, emailNV, maCH, hoTenCh, sdtCH, emailCH, tenDiaChiDatDongHo, tenKhuVuc, maDiaChi, tenDiaChi, maLoaiNuoc, tenLoaiNuoc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CapNhatPhanCongChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CapNhatPhanCongChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CapNhatPhanCongChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CapNhatPhanCongChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return phanCongModel;
    }

    public static List<NhanVienModel> timTatCaNhanVienTrucThuocKhuVuc(String maKhuVuc) throws ClassNotFoundException {
        List<NhanVienModel> dsNhanvienTrucThuocKhuVuc = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT NV.MANV, NV.HOTEN, NV.SDT, NV.CCCD, TK.EMAIL "
                    + "FROM NHANVIEN NV "
                    + "JOIN KHUVUC KV ON KV.MAKHUVUC = NV.MAKHUVUC "
                    + "JOIN TAIKHOAN TK ON TK.MATK = NV.MANV "
                    + "WHERE KV.MAKHUVUC = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, maKhuVuc);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maNhanVien = resultSet.getString("MANV");
                String tenNhanvien = resultSet.getString("HOTEN");
                String cccd = resultSet.getString("CCCD");
                String soDienThoai = resultSet.getString("SDT");
                String email = resultSet.getString("EMAIL");

                NhanVienModel nhanVienModel = new NhanVienModel(maNhanVien, tenNhanvien, soDienThoai, cccd, email);
                dsNhanvienTrucThuocKhuVuc.add(nhanVienModel);
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

        return dsNhanvienTrucThuocKhuVuc;
    }

    public static void capNhatThongTinPhanCongNhanVienChiTiet(String maNhanVien, String maPhanCong, String TimeAssign) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement updateStatement = null;

        try {
            connection = ConnectDB.getConnection();

            String updateQuery = "UPDATE PHANCONG SET MANV = ?  WHERE MAPC = ? AND NGAYPHAN LIKE ?";
            updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, maNhanVien);
            updateStatement.setString(2, maPhanCong);
            updateStatement.setString(3, "%" + TimeAssign + "%");

            updateStatement.executeUpdate();
        } catch (SQLException ex) {
            // Xử lý ngoại lệ khi thực hiện truy vấn SQL
            Logger.getLogger(CapNhatPhanCongChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
