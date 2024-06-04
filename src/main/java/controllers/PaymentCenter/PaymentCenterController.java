package controllers.PaymentCenter;

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
import models.Client.HoaDonModel;
import models.PaymentCenter.DiemThuModel;
import utils.PasswordHashing;

public class PaymentCenterController {

    public static String maTrungGian = null;
    
    public static void ganMaTrungGian(String email) throws ClassNotFoundException{
        String sql = "SELECT * FROM TAIKHOAN WHERE EMAIL = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                maTrungGian = resultSet.getString("MATK");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Thu tiền
    public static List<HoaDonModel> hienThiCacHoaDonChuaTraTheoMaChuHo(String maChuHo) throws ClassNotFoundException {
        List<HoaDonModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT HD.MAHOADON, HD.TIEUTHU, HD.TONGTIEN, HD.THANHTOAN, "
                + "HD.NGAYDENHAN, HD.NGAYTRA, HD.NGAYTAO, "
                + "GN.NGAYGHI, GN.MAGHI, GN.KI, GN.CSC, GN.CSM, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI, CH.MACH, "
                + "CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC "
                + "FROM HOADON AS HD "
                + "JOIN GHINUOC AS GN ON GN.MAGHI = HD.MAGHI "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "JOIN CHITIETKHUVUC AS CTKV ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN KHUVUC AS KV ON KV.MAKHUVUC = CTKV.MAKHUVUC "
                + "WHERE CH.MACH = ? AND HD.THANHTOAN = ? "
                + "ORDER BY HD.NGAYTAO, GN.NGAYGHI";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            statement.setInt(2, 0);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HoaDonModel bill = new HoaDonModel(
                        resultSet.getString("MAHOADON"),
                        resultSet.getString("MAGHI"),
                        resultSet.getString("MADH"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"),
                        resultSet.getString("KI"),
                        resultSet.getString("MACTKV"),
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getString("MACH"),
                        resultSet.getInt("TIEUTHU"),
                        resultSet.getInt("TONGTIEN"),
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getDate("NGAYDENHAN"),
                        resultSet.getDate("NGAYTRA"),
                        resultSet.getDate("NGAYTAO"),
                        resultSet.getDate("NGAYGHI"),
                        resultSet.getInt("THANHTOAN"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    public static boolean kiemTraChuHoCoTrongHeThong(String maChuHo) throws ClassNotFoundException {
        String sql = "SELECT * FROM CHUHO WHERE MACH = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean kiemTraHoaDonDaDuocThanhToanChua(String maHoaDon) throws ClassNotFoundException {
        String sql = "SELECT * FROM HOADON WHERE THANHTOAN = 0 AND MAHOADON = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maHoaDon);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void thanhToan(String maHoaDon) throws ClassNotFoundException {
        Date ngayHomNay = new Date();
        java.sql.Date ngayHomNaySQL = new java.sql.Date(ngayHomNay.getTime());
        String sql = "UPDATE HOADON SET THANHTOAN = ?, NGAYTRA = ?, MATG = ? WHERE MAHOADON = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, 2);
            statement.setDate(2, ngayHomNaySQL);
            statement.setString(3, maHoaDon);
            statement.setString(3, maTrungGian);
            statement.setString(4, maHoaDon);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String traVeTenChuHo(String maChuHo) throws ClassNotFoundException {
        String tenChuHo = null;
        String sql = "SELECT HOTEN FROM CHUHO WHERE MACH = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tenChuHo = resultSet.getString("HOTEN");
                return tenChuHo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenChuHo;
    }

    public static String traVeTien(String maHoaDon) throws ClassNotFoundException {
        String tongTien = "0";
        String sql = "SELECT TONGTIEN FROM HOADON WHERE MAHOADON = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maHoaDon);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tongTien = resultSet.getString("TONGTIEN");
                return tongTien;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongTien;
    }
    
    // DS các hóa đơn đã giao dịch
    public static List<HoaDonModel> hienThiCacHoaDonDaGiaoDich() throws ClassNotFoundException {
        List<HoaDonModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT HD.MAHOADON, HD.TIEUTHU, HD.TONGTIEN, HD.THANHTOAN, "
                + "HD.NGAYDENHAN, HD.NGAYTRA, HD.NGAYTAO, "
                + "GN.NGAYGHI, GN.MAGHI, GN.KI, GN.CSC, GN.CSM, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI, CH.MACH, "
                + "CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC "
                + "FROM HOADON AS HD "
                + "JOIN GHINUOC AS GN ON GN.MAGHI = HD.MAGHI "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "JOIN CHITIETKHUVUC AS CTKV ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN KHUVUC AS KV ON KV.MAKHUVUC = CTKV.MAKHUVUC "
                + "WHERE HD.THANHTOAN = ? AND MATG = ? "
                + "ORDER BY HD.NGAYTAO, GN.NGAYGHI";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, 2);
            statement.setString(2, maTrungGian);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HoaDonModel bill = new HoaDonModel(
                        resultSet.getString("MAHOADON"),
                        resultSet.getString("MAGHI"),
                        resultSet.getString("MADH"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"),
                        resultSet.getString("KI"),
                        resultSet.getString("MACTKV"),
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getString("MACH"),
                        resultSet.getInt("TIEUTHU"),
                        resultSet.getInt("TONGTIEN"),
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getDate("NGAYDENHAN"),
                        resultSet.getDate("NGAYTRA"),
                        resultSet.getDate("NGAYTAO"),
                        resultSet.getDate("NGAYGHI"),
                        resultSet.getInt("THANHTOAN"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    public static List<HoaDonModel> timKiemHoaDon(String tuKhoa) throws ClassNotFoundException {
        List<HoaDonModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT HD.MAHOADON, HD.TIEUTHU, HD.TONGTIEN, HD.THANHTOAN, "
                + "HD.NGAYDENHAN, HD.NGAYTRA, HD.NGAYTAO, "
                + "GN.NGAYGHI, GN.MAGHI, GN.KI, GN.CSC, GN.CSM, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI, CH.MACH, "
                + "CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC "
                + "FROM HOADON AS HD "
                + "JOIN GHINUOC AS GN ON GN.MAGHI = HD.MAGHI "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "JOIN CHITIETKHUVUC AS CTKV ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN KHUVUC AS KV ON KV.MAKHUVUC = CTKV.MAKHUVUC "
                + "WHERE HD.THANHTOAN = ? AND MATG = ? "
                + "AND (HD.MAHOADON LIKE ? OR CH.MACH LIKE ?) "
                + "ORDER BY HD.NGAYTAO, GN.NGAYGHI";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, 2); // Set value for HD.THANHTOAN
            statement.setString(2, maTrungGian); // Set value for MATG
            statement.setString(3, "%" + tuKhoa + "%"); // Set value for MAHOADON LIKE
            statement.setString(4, "%" + tuKhoa + "%"); // Set value for CH.MACH LIKE
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HoaDonModel bill = new HoaDonModel(
                        resultSet.getString("MAHOADON"),
                        resultSet.getString("MAGHI"),
                        resultSet.getString("MADH"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"),
                        resultSet.getString("KI"),
                        resultSet.getString("MACTKV"),
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getString("MACH"),
                        resultSet.getInt("TIEUTHU"),
                        resultSet.getInt("TONGTIEN"),
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getDate("NGAYDENHAN"),
                        resultSet.getDate("NGAYTRA"),
                        resultSet.getDate("NGAYTAO"),
                        resultSet.getDate("NGAYGHI"),
                        resultSet.getInt("THANHTOAN"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }
    
    // Thông tin tài khoản
    public static DiemThuModel hienThiThongTinTaiKhoan() throws ClassNotFoundException {
        String sql = "SELECT TG.MATG, TG.TENTG, TK.EMAIL, "
                + "CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC "
                + "FROM TRUNGGIAN AS TG "
                + "JOIN CHITIETKHUVUC AS CTKV ON TG.MACTKV = CTKV.MACTKV "
                + "JOIN KHUVUC AS KV ON CTKV.MAKHUVUC = KV.MAKHUVUC "
                + "JOIN TAIKHOAN AS TK ON TK.MATK = TG.MATG "
                + "WHERE TG.MATG = ?";
        DiemThuModel dt = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maTrungGian);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                dt = new DiemThuModel(
                        resultSet.getString("MATG"),
                        resultSet.getString("TENTG"),
                        resultSet.getString("MACTKV"),
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getString("EMAIL"));
                return dt;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean kiemTraMatKhauHienTai(String password) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT TK.MATKHAU FROM TAIKHOAN AS TK "
                + "JOIN TRUNGGIAN AS TG ON TK.MATK = TG.MATG "
                + "WHERE TG.MATG = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maTrungGian);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String rightPassword = resultSet.getString("MATKHAU");
                if (PasswordHashing.checkPassword(password, rightPassword)) {
                    flag = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void doiMatKhau(String password) throws ClassNotFoundException {
        String sql = "UPDATE TAIKHOAN SET MATKHAU=? WHERE MATK=? ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            String hashPassword = PasswordHashing.hashPassword(password);
            statement.setString(1, hashPassword);
            statement.setString(2, maTrungGian);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
