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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.NhanVienModel;
import models.PhanCongModel;
import java.util.UUID;
import models.DataGlobal;

/**
 *
 * @author GIANG
 */
public class ChiTietPhanCongKhuVucCtrl {

    public static List<PhanCongModel> timTatCaDuLieuThuocKhuVuc(String maKhuVuc, String TimeLine) throws ClassNotFoundException {
        List<PhanCongModel> dsChiTietPhanCongKhuVuc = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT \n"
                    + "    PC.MAPC AS MAPHANCONG, \n"
                    + "    DH.MADH AS MADONGHO, \n"
                    + "    CH.MACH AS MACHUHO, \n"
                    + "    CH.HOTEN AS TenCHUHO,\n"
                    + "    L.TENLOAI AS TenLOAINUOCSuDung,\n"
                    + "    CTKV.TENCHITIET AS DIACHIDONGHO,\n"
                    + "    NV.MANV AS MANHANVIEN,\n"
                    + "    NV.HOTEN AS TENNHANVIEN,\n"
                    + "    QL.MAQL AS MANGUOIPHUTRACH,\n"
                    + "    QL.HOTEN AS TENNGUOIPHUTRACH\n"
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
                    + "    TAIKHOAN TK ON CH.MACH = TK.MATK\n"
                    + "JOIN \n"
                    + "    LOAI L ON L.MALOAI = DH.MALOAI\n"
                    + "JOIN \n"
                    + "    CHITIETKHUVUC CTKV ON CTKV.MACTKV = DH.MADIACHI\n"
                    + "WHERE \n"
                    + "    CTKV.MAKHUVUC = ? AND PC.NGAYPHAN LIKE ? AND TK.TRANGTHAI = 'True'";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maKhuVuc);
            statement.setString(2, "%" + TimeLine + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maPhanCong = resultSet.getString("MAPHANCONG");
                String maDongHo = resultSet.getString("MADONGHO");
                String maNguoiQL = resultSet.getString("MANGUOIPHUTRACH");
                String tenNguoiQL = resultSet.getString("TENNGUOIPHUTRACH");
                String maNhanVien = resultSet.getString("MANHANVIEN");
                String tenNhanvien = resultSet.getString("TENNHANVIEN");
                String maChuHo = resultSet.getString("MACHUHO");
                String tenChuHo = resultSet.getString("TENCHUHO");
                String diaChiDongHo = resultSet.getString("DIACHIDONGHO");
                String tenLoaiNuoc = resultSet.getString("TenLOAINUOCSuDung");

                PhanCongModel phanCongModel = new PhanCongModel(maPhanCong, maDongHo, maNguoiQL, tenNguoiQL, maNhanVien, tenNhanvien, maChuHo, tenChuHo, diaChiDongHo, tenLoaiNuoc);
                dsChiTietPhanCongKhuVuc.add(phanCongModel);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsChiTietPhanCongKhuVuc;
    }
    
    public static List<PhanCongModel> timTatCaDuLieuThuocKhuVucBangOTimKiem(String maKhuVuc, String TimeLine, String loaiTimKiem, String loaiSapXep, String thongTinTimKiem) throws ClassNotFoundException {
        List<PhanCongModel> dsChiTietPhanCongKhuVuc = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT \n"
                    + "    PC.MAPC AS MAPHANCONG, \n"
                    + "    DH.MADH AS MADONGHO, \n"
                    + "    CH.MACH AS MACHUHO, \n"
                    + "    CH.HOTEN AS TenCHUHO,\n"
                    + "    L.TENLOAI AS TenLOAINUOCSuDung,\n"
                    + "    CTKV.TENCHITIET AS DIACHIDONGHO,\n"
                    + "    NV.MANV AS MANHANVIEN,\n"
                    + "    NV.HOTEN AS TENNHANVIEN,\n"
                    + "    QL.MAQL AS MANGUOIPHUTRACH,\n"
                    + "    QL.HOTEN AS TENNGUOIPHUTRACH\n"
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
                    + "    CHITIETKHUVUC CTKV ON CTKV.MACTKV = DH.MADIACHI\n"
                    + "WHERE \n"
                    + "    CTKV.MAKHUVUC = ? AND PC.NGAYPHAN LIKE ? AND " + loaiTimKiem + " LIKE ? " + loaiSapXep;;
            statement = connection.prepareStatement(sql);
            statement.setString(1, maKhuVuc);
            statement.setString(2, "%" + TimeLine + "%");
            statement.setString(3, "%" + thongTinTimKiem + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maPhanCong = resultSet.getString("MAPHANCONG");
                String maDongHo = resultSet.getString("MADONGHO");
                String maNguoiQL = resultSet.getString("MANGUOIPHUTRACH");
                String tenNguoiQL = resultSet.getString("TENNGUOIPHUTRACH");
                String maNhanVien = resultSet.getString("MANHANVIEN");
                String tenNhanvien = resultSet.getString("TENNHANVIEN");
                String maChuHo = resultSet.getString("MACHUHO");
                String tenChuHo = resultSet.getString("TENCHUHO");
                String diaChiDongHo = resultSet.getString("DIACHIDONGHO");
                String tenLoaiNuoc = resultSet.getString("TenLOAINUOCSuDung");

                PhanCongModel phanCongModel = new PhanCongModel(maPhanCong, maDongHo, maNguoiQL, tenNguoiQL, maNhanVien, tenNhanvien, maChuHo, tenChuHo, diaChiDongHo, tenLoaiNuoc);
                dsChiTietPhanCongKhuVuc.add(phanCongModel);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsChiTietPhanCongKhuVuc;
    }

//    public static List<PhanCongModel> timTatCaDuLieuThuocKhuVucChuaPhanCong(String maKhuVuc, String TimeLine) throws ClassNotFoundException {
//        List<PhanCongModel> dsChiTietKhuVucPhanCong = new ArrayList<>();
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            connection = ConnectDB.getConnection();
//            String sql = "SELECT \n"
//                    + "    PC.MAPC AS MAPHANCONG, \n"
//                    + "    CH.MACH AS MACHUHO, \n"
//                    + "    CH.HOTEN AS TenCHUHO,\n"
//                    + "    L.TENLOAI AS TenLOAINUOCSuDung,\n"
//                    + "    CTKV.TENCHITIET AS DIACHIDONGHO\n"
//                    + "FROM \n"
//                    + "    PHANCONG PC\n"
//                    + "JOIN \n"
//                    + "    DONGHO DH ON DH.MADH = PC.MADH\n"
//                    + "JOIN \n"
//                    + "    CHUHO CH ON CH.MACH = DH.MACH\n"
//                    + "JOIN \n"
//                    + "    LOAI L ON L.MALOAI = DH.MALOAI\n"
//                    + "JOIN \n"
//                    + "    CHITIETKHUVUC CTKV ON CTKV.MACTKV = DH.MADIACHI\n"
//                    + "WHERE \n"
//                    + "    CTKV.MAKHUVUC = ? AND PC.NGAYPHAN IS NULL";
//
//            statement = connection.prepareStatement(sql);
//            statement.setString(1, maKhuVuc);
//            resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                String maPhanCong = resultSet.getString("MAPHANCONG");
//                String maNguoiQL = "";
//                String tenNguoiQL = "";
//                String maNhanVien = "";
//                String tenNhanvien = "";
//                String maChuHo = resultSet.getString("MACHUHO");
//                String tenChuHo = resultSet.getString("TENCHUHO");
//                String diaChiDongHo = resultSet.getString("DIACHIDONGHO");
//                String tenLoaiNuoc = resultSet.getString("TenLOAINUOCSuDung");
//
//                PhanCongModel phanCongModel = new PhanCongModel(maPhanCong, maNguoiQL, tenNguoiQL, maNhanVien, tenNhanvien, maChuHo, tenChuHo, diaChiDongHo, tenLoaiNuoc);
//                dsChiTietKhuVucPhanCong.add(phanCongModel);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//
//        return dsChiTietKhuVucPhanCong;
//    }
    public static List<PhanCongModel> timTatCaDuLieuThuocKhuVucChuaPhanCong(String maKhuVuc, String TimeLine) throws ClassNotFoundException {
        List<PhanCongModel> dsChiTietKhuVucPhanCong = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT \n"
                    + "    DH.MADH AS MADONGHO, \n"
                    + "    CH.MACH AS MACHUHO, \n"
                    + "    CH.HOTEN AS TenCHUHO,\n"
                    + "    L.TENLOAI AS TenLOAINUOCSuDung,\n"
                    + "    CTKV.TENCHITIET AS DIACHIDONGHO\n"
                    + "FROM \n"
                    + "    DONGHO DH\n"
                    + "JOIN \n"
                    + "    CHUHO CH ON CH.MACH = DH.MACH\n"
                    + "JOIN \n"
                    + "    TAIKHOAN TK ON CH.MACH = TK.MATK\n"
                    + "JOIN \n"
                    + "    LOAI L ON L.MALOAI = DH.MALOAI\n"
                    + "JOIN \n"
                    + "    CHITIETKHUVUC CTKV ON CTKV.MACTKV = DH.MADIACHI\n"
                    + "LEFT JOIN \n"
                    + "    PHANCONG PC ON DH.MADH = PC.MADH \n"
                    + "    AND PC.KYPHANCONG = ?\n"
                    + "WHERE \n"
                    + "    CTKV.MAKHUVUC = ?\n"
                    + "    AND PC.MADH IS NULL AND TK.TRANGTHAI = 'True';";

            statement = connection.prepareStatement(sql);
            statement.setString(1, TimeLine);
            statement.setString(2, maKhuVuc);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maPhanCong = "";
                String maNguoiQL = "";
                String tenNguoiQL = "";
                String maNhanVien = "";
                String tenNhanvien = "";
                String maDongHo = resultSet.getString("MADONGHO");
                String maChuHo = resultSet.getString("MACHUHO");
                String tenChuHo = resultSet.getString("TENCHUHO");
                String diaChiDongHo = resultSet.getString("DIACHIDONGHO");
                String tenLoaiNuoc = resultSet.getString("TenLOAINUOCSuDung");

                PhanCongModel phanCongModel = new PhanCongModel(maPhanCong, maDongHo, maNguoiQL, tenNguoiQL, maNhanVien, tenNhanvien, maChuHo, tenChuHo, diaChiDongHo, tenLoaiNuoc);
                dsChiTietKhuVucPhanCong.add(phanCongModel);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsChiTietKhuVucPhanCong;
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
                    + "WHERE KV.MAKHUVUC = ? AND TK.TRANGTHAI = 'True'";

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

    public static void capNhatTatCaDuLieuThuocKhuVuc(String AreaId, List<PhanCongModel> phanCongModels, List<PhanCongModel> thayDoiPhanCongModels, String TimeAssign) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement updateStatement = null;
        PreparedStatement updateGhiNuoc = null;
        PreparedStatement checkExistStatement = null;
        
        LocalDate currentDate = LocalDate.now();
        int yearCurrent = currentDate.getYear();
        int monthCurrent = currentDate.getMonthValue();
        int dayCurrent = currentDate.getDayOfMonth();

        String ngayThangNamHienTai = dayCurrent + "/" + monthCurrent + "/" + yearCurrent;
        String kyPhanCongHienTai = monthCurrent + "/" + yearCurrent;
        String kyGhiNuocHienTai;

        if (monthCurrent == 1) {
            kyGhiNuocHienTai = "12/" + (yearCurrent - 1);
        } else {
            kyGhiNuocHienTai = (monthCurrent - 1) + "/" + yearCurrent;
        }

//        Phải có nameDetailAddres khác nhau nữa 


        try {
            connection = ConnectDB.getConnection(); // Thiết lập kết nối đến cơ sở dữ liệu

            for (PhanCongModel phanCongModel : thayDoiPhanCongModels) {

                String maPC = phanCongModel.getMAPC();

                String maNhanVien = phanCongModel.getMANV();
                
                

                // Thực hiện truy vấn để lấy ngày phân công hiện tại
                String layNgayQuery = "SELECT NGAYPHAN, MADH FROM PHANCONG WHERE MAPC = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(layNgayQuery);
                preparedStatement.setString(1, maPC);
                ResultSet resultSet = preparedStatement.executeQuery();
                String ngayCu = "";
                String maDongHo = "";
                if (resultSet.next()) {
                    ngayCu = resultSet.getString("NGAYPHAN");
                    maDongHo = resultSet.getString("MADH");
                }
                preparedStatement.close();

                String thayDoiNgay = ngayThangNamHienTai;
                
                // Kiểm tra sự tồn tại trong bảng GHINUOC
                String checkExistQuery = "SELECT MANV, CSM FROM GHINUOC WHERE MADH = ? AND KI LIKE ?";
                checkExistStatement = connection.prepareStatement(checkExistQuery);
                checkExistStatement.setString(1, maDongHo);
                checkExistStatement.setString(2, "%" + kyGhiNuocHienTai + "%");
                ResultSet checkExistResult = checkExistStatement.executeQuery();

                if (checkExistResult.next()) {
                    String existingMaNV = checkExistResult.getString("CSM");
                    if (existingMaNV != null) {
                        // Nếu tồn tại MANV khác null thì không thực hiện cập nhật
                        continue;
                    }
                }

                // Thực hiện truy vấn UPDATE để cập nhật dữ liệu
                String updateQuery = "UPDATE PHANCONG SET MANV = ?, NGAYPHAN = ?  WHERE MAPC = ?";
                updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, maNhanVien);
                updateStatement.setString(2, thayDoiNgay);
                updateStatement.setString(3, maPC);

                updateStatement.executeUpdate();

                

                String updateBanGhiNuoc = "Update GHINUOC SET MANV = ? WHERE MADH = ? AND KI LIKE ?";
                updateGhiNuoc = connection.prepareStatement(updateBanGhiNuoc);
                updateGhiNuoc.setString(1, maNhanVien);
                updateGhiNuoc.setString(2, maDongHo);
                updateGhiNuoc.setString(3, "%" + kyGhiNuocHienTai + "%");

                updateGhiNuoc.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Xử lý ngoại lệ khi thực hiện truy vấn SQL
        } finally {
            // Đóng tài nguyên sau khi hoàn thành công việc
            if (updateStatement != null) {
                updateStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static void capNhatTatCaDuLieuThuocKhuVucChuaPhanCong(String AreaId, List<PhanCongModel> assignmentEmpoylerModels, List<PhanCongModel> changeAssignmentEmpoylerModels, String TimeAssign) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement insertStatement = null;
        PreparedStatement ghiNuocStatement = null;
        ResultSet resultSet = null;

        LocalDate currentDate = LocalDate.now();
        int yearCurrent = currentDate.getYear();
        int monthCurrent = currentDate.getMonthValue();
        int dayCurrent = currentDate.getDayOfMonth();

        String ngayThangNamHienTai = dayCurrent + "/" + monthCurrent + "/" + yearCurrent;
        String kyPhanCongHienTai = monthCurrent + "/" + yearCurrent;
        String kyGhiNuocHienTai;

        if (monthCurrent == 1) {
            kyGhiNuocHienTai = "12/" + (yearCurrent - 1);
        } else {
            kyGhiNuocHienTai = (monthCurrent - 1) + "/" + yearCurrent;
        }

        String maQL = DataGlobal.getDataGLobal.dataGlobal.getPhienQLHienTai().getMAQL();

        try {
            connection = ConnectDB.getConnection(); // Thiết lập kết nối đến cơ sở dữ liệu

            for (PhanCongModel changeAssignment : changeAssignmentEmpoylerModels) {
                String maNhanVien = changeAssignment.getMANV();
                String maDongHo = changeAssignment.getMADH();
                
                System.out.println("Ma dong ho " + maDongHo);

                UUID uuid = UUID.randomUUID();
                String maPC = "PC" + uuid.toString();
                String maGhi = "MG" + uuid.toString();

                String SQL2 = "INSERT INTO PHANCONG (MAPC, MAQL, MANV, MADH, NGAYPHAN, KYPHANCONG) VALUES (?,?,?,?,?,?)";

                insertStatement = connection.prepareStatement(SQL2);
                insertStatement.setString(1, maPC);
                insertStatement.setString(2, maQL);
                insertStatement.setString(3, maNhanVien);
                insertStatement.setString(4, maDongHo);
                insertStatement.setString(5, ngayThangNamHienTai);
                insertStatement.setString(6, kyPhanCongHienTai);

                insertStatement.executeUpdate();
                insertStatement.close();

                String SQL3 = "INSERT INTO GHINUOC (MAGHI, MADH, MANV, KI, NGAYBATDAUGHI, NGAYHANGHI) VALUES (?, ?, ?, ?, ?, ?)";

                ghiNuocStatement = connection.prepareStatement(SQL3);
                ghiNuocStatement.setString(1, maGhi);
                ghiNuocStatement.setString(2, maDongHo);
                ghiNuocStatement.setString(3, maNhanVien);
                ghiNuocStatement.setString(4, kyGhiNuocHienTai);
                ghiNuocStatement.setString(5, ngayThangNamHienTai);
                ghiNuocStatement.setString(6, "10/" + kyPhanCongHienTai);

                ghiNuocStatement.executeUpdate();
                ghiNuocStatement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (ghiNuocStatement != null) {
                ghiNuocStatement.close();
            }
            if (insertStatement != null) {
                insertStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static List<PhanCongModel> timTatCaDuLieuThuocKhuVucTheoThoiGian(String maKhuVuc, String TimeLine) throws ClassNotFoundException {
        List<PhanCongModel> dsChiTietPhanCongKhuVuc = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT \n"
                    + "    PC.MAPC AS MAPHANCONG, \n"
                    + "    CH.MACH AS MACHUHO, \n"
                    + "    DH.MADH AS MADONGHO, \n"
                    + "    CH.HOTEN AS TenCHUHO,\n"
                    + "    L.TENLOAI AS TenLOAINUOCSuDung,\n"
                    + "    CTKV.TENCHITIET AS DIACHIDONGHO,\n"
                    + "    NV.MANV AS MANHANVIEN,\n"
                    + "    NV.HOTEN AS TENNHANVIEN,\n"
                    + "    QL.MAQL AS MANGUOIPHUTRACH,\n"
                    + "    QL.HOTEN AS TENNGUOIPHUTRACH\n"
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
                    + "    CHITIETKHUVUC CTKV ON CTKV.MACTKV = DH.MADIACHI\n"
                    + "WHERE \n"
                    + "    CTKV.MAKHUVUC = ? AND PC.NGAYPHAN LIKE ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maKhuVuc);
            statement.setString(2, "%" + TimeLine + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maPhanCong = resultSet.getString("MAPHANCONG");
                String maDongHo = resultSet.getString("MADONGHO");
                String maNguoiQL = resultSet.getString("MANGUOIPHUTRACH");
                String tenNguoiQL = resultSet.getString("TENNGUOIPHUTRACH");
                String maNhanVien = resultSet.getString("MANHANVIEN");
                String tenNhanvien = resultSet.getString("TENNHANVIEN");
                String maChuHo = resultSet.getString("MACHUHO");
                String tenChuHo = resultSet.getString("TENCHUHO");
                String diaChiDongHo = resultSet.getString("DIACHIDONGHO");
                String tenLoaiNuoc = resultSet.getString("TenLOAINUOCSuDung");

                PhanCongModel phanCongModel = new PhanCongModel(maPhanCong, maDongHo, maNguoiQL, tenNguoiQL, maNhanVien, tenNhanvien, maChuHo, tenChuHo, diaChiDongHo, tenLoaiNuoc);
                dsChiTietPhanCongKhuVuc.add(phanCongModel);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsChiTietPhanCongKhuVuc;
    }

//    public static void autoPhanCongNhanVien(String maKhuVuc, String TimeAssign, String Timeline) throws ClassNotFoundException {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//
//        String maQL = DataGlobal.getDataGLobal.dataGlobal.getPhienQLHienTai().getMAQL();
//
//        try {
//            connection = ConnectDB.getConnection();
//            String sql = "SELECT PC.MANV AS IDNhanVien, PC.MADH AS IDDongHo\n"
//                    + "FROM PHANCONG PC \n"
//                    + "JOIN DONGHO DH ON DH.MADH = PC.MADH\n"
//                    + "JOIN CHITIETKHUVUC CTKV ON CTKV.MACTKV = DH.MADIACHI\n"
//                    + "WHERE CTKV.MAKHUVUC = ? AND DH.TRANGTHAI = 'True' AND PC.NGAYPHAN LIKE ?";
//            statement = connection.prepareStatement(sql);
//            statement.setString(1, maKhuVuc);
//            statement.setString(2, "%" + Timeline + "%");
//
//            resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                String maNhanVien = resultSet.getString("IDNhanVien");
//
//                UUID uuid = UUID.randomUUID();
//                String maPC = "PC" + uuid.toString();
//
//                String maGhi = "MG" + uuid.toString();
//
//                String maDongHo = resultSet.getString("IDDongHo");
//
//                String SQL2 = "INSERT INTO PHANCONG (MAPC, MAQL, MANV, MADH, NGAYPHAN) VALUES (?,?,?,?,?)";
//
//                PreparedStatement insertStatement = connection.prepareStatement(SQL2);
//                insertStatement.setString(1, maPC);
//                insertStatement.setString(2, maQL);
//                insertStatement.setString(3, maNhanVien);
//                insertStatement.setString(4, maDongHo);
//                insertStatement.setString(5, TimeAssign);
//
//                insertStatement.executeUpdate(); // Thực thi câu lệnh INSERT
//
//                String SQL3 = "INSERT INTO GHINUOC (MAGHI, MADH, MANV, KI, NGAYBATDAUGHI, NGAYHANGHI) VALUES (?, ?, ?, ?, ?, ?)";
//
//                PreparedStatement updateStatement = connection.prepareStatement(SQL3);
//                updateStatement.setString(1, maGhi);
//                updateStatement.setString(2, maDongHo);
//                updateStatement.setString(3, maNhanVien);
//                updateStatement.setString(4, TimeAssign.substring(2, 9));
//                updateStatement.setString(5, "01/" + TimeAssign.substring(2));
//                updateStatement.setString(6, "10/" + TimeAssign.substring(2));
//
//                updateStatement.executeUpdate(); // Thực thi câu lệnh UPDATE
//
//// Đóng statement updateStatement
//                updateStatement.close();
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (statement != null) {
//                    statement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    public static void autoPhanCongNhanVien(String maKhuVuc, String ngayThangNamHienTai, String kyPhanCongHienTai) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String maQL = DataGlobal.getDataGLobal.dataGlobal.getPhienQLHienTai().getMAQL();

        List<String> nhanVienList = new ArrayList<>();
        int nhanVienIndex = 0;
        
        LocalDate currentDate = LocalDate.now();
        int yearCurrent = currentDate.getYear();
        int monthCurrent = currentDate.getMonthValue();
        int dayCurrent = currentDate.getDayOfMonth();
        
        String kyGhiNuocHienTai;

        if (monthCurrent == 1) {
            kyGhiNuocHienTai = "12/" + (yearCurrent - 1);
        } else {
            kyGhiNuocHienTai = (monthCurrent - 1) + "/" + yearCurrent;
        }
        
        try {
            connection = ConnectDB.getConnection();

            // Lấy danh sách IDNhanVien từ bảng NhanVien với điều kiện MAKV = ?
            String sqlNhanVien = "SELECT MANV FROM NhanVien JOIN TAIKHOAN AS TK ON TK.MATK = NhanVien.MANV WHERE MAKHUVUC = ? AND TK.TRANGTHAI = 'True'";
            statement = connection.prepareStatement(sqlNhanVien);
            statement.setString(1, maKhuVuc); // sử dụng maKhuVuc làm điều kiện MAKV
            ResultSet rsNhanVien = statement.executeQuery();
            while (rsNhanVien.next()) {
                nhanVienList.add(rsNhanVien.getString("MANV"));
            }
            rsNhanVien.close();
            statement.close();

            if (nhanVienList.isEmpty()) {
                throw new SQLException("No NhanVien found for MAKV = '" + maKhuVuc + "'");
            }

            String sql = "SELECT \n"
                    + "    DH.MADH, \n"
                    + "    CH.MACH AS MACHUHO, \n"
                    + "    CH.HOTEN AS TenCHUHO,\n"
                    + "    L.TENLOAI AS TenLOAINUOCSuDung,\n"
                    + "    CTKV.TENCHITIET AS DIACHIDONGHO\n"
                    + "FROM \n"
                    + "    DONGHO DH\n"
                    + "JOIN \n"
                    + "    CHUHO CH ON CH.MACH = DH.MACH\n"
                    + "JOIN \n"
                    + "    LOAI L ON L.MALOAI = DH.MALOAI\n"
                    + "JOIN \n"
                    + "    CHITIETKHUVUC CTKV ON CTKV.MACTKV = DH.MADIACHI\n"
                    + "LEFT JOIN \n"
                    + "    PHANCONG PC ON DH.MADH = PC.MADH \n"
                    + "    AND PC.KYPHANCONG = ?\n"
                    + "WHERE \n"
                    + "    CTKV.MAKHUVUC = ?\n"
                    + "    AND PC.MADH IS NULL;";

            statement = connection.prepareStatement(sql);
            statement.setString(1, kyPhanCongHienTai);
            statement.setString(2, maKhuVuc);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maNhanVien = nhanVienList.get(nhanVienIndex);
                nhanVienIndex = (nhanVienIndex + 1) % nhanVienList.size(); // Round-robin

                UUID uuid = UUID.randomUUID();
                String maPC = "PC" + uuid.toString();

                String maGhi = "MG" + uuid.toString();

                String maDongHo = resultSet.getString("MADH");

                String SQL2 = "INSERT INTO PHANCONG (MAPC, MAQL, MANV, MADH, NGAYPHAN, KYPHANCONG) VALUES (?,?,?,?,?,?)";

                PreparedStatement insertStatement = connection.prepareStatement(SQL2);
                insertStatement.setString(1, maPC);
                insertStatement.setString(2, maQL);
                insertStatement.setString(3, maNhanVien);
                insertStatement.setString(4, maDongHo);
                insertStatement.setString(5, ngayThangNamHienTai);
                insertStatement.setString(6, kyPhanCongHienTai);

                insertStatement.executeUpdate();
                insertStatement.close();

                String SQL3 = "INSERT INTO GHINUOC (MAGHI, MADH, MANV, KI, NGAYBATDAUGHI, NGAYHANGHI) VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement updateStatement = connection.prepareStatement(SQL3);
                updateStatement.setString(1, maGhi);
                updateStatement.setString(2, maDongHo);
                updateStatement.setString(3, maNhanVien);
                updateStatement.setString(4, kyGhiNuocHienTai);
                updateStatement.setString(5, ngayThangNamHienTai);
                updateStatement.setString(6, "10/" + kyPhanCongHienTai);

                updateStatement.executeUpdate();
                updateStatement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean kiemTraLichPhanCong(String kyPhanCong, String maKhuVuc) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT PC.MAPC, CTKV.TENCHITIET\n"
                    + "FROM PHANCONG AS PC\n"
                    + "JOIN DONGHO DH ON DH.MADH = PC.MADH\n"
                    + "JOIN CHITIETKHUVUC CTKV ON CTKV.MACTKV = DH.MADIACHI\n"
                    + "WHERE PC.KYPHANCONG LIKE ? AND CTKV.MAKHUVUC = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + kyPhanCong + "%");
            statement.setString(2, maKhuVuc);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhanCongKhuVucCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
