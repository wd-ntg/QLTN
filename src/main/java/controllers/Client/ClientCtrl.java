package controllers.Client;

import database.ConnectDB;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import models.Client.HoaDonModel;
import models.Client.ThongKeModel;
import models.Client.HoModel;
import models.Client.ThongTinCaNhanModel;
//import models.PersonData;
//import models.PersonModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Phu Bao
 */
public class ClientCtrl {

    public static String maChuHo;

    // Home
    public static List<HoaDonModel> hienThiCacHoaDonChuaTra() throws ClassNotFoundException {
        List<HoaDonModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT HD.MAHOADON, HD.TIEUTHU, HD.TONGTIEN, HD.THANHTOAN, "
                + "HD.NGAYDENHAN, HD.NGAYTRA, HD.NGAYTAO, "
                + "NVLHD.MANV AS MANVLHD, NVLHD.HOTEN AS TENNVLHD, "
                + "NVGN.MANV AS MANVGN, NVGN.HOTEN AS TENNVGN, "
                + "GN.NGAYGHI, GN.MAGHI, GN.KI, GN.CSC, GN.CSM, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI, CH.MACH, "
                + "CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC "
                + "FROM HOADON AS HD "
                + "JOIN NHANVIEN AS NVLHD ON HD.MANV = NVLHD.MANV "
                + "JOIN GHINUOC AS GN ON GN.MAGHI = HD.MAGHI "
                + "JOIN NHANVIEN AS NVGN ON GN.MANV = NVGN.MANV "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "JOIN CHITIETKHUVUC AS CTKV ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN KHUVUC AS KV ON KV.MAKHUVUC = CTKV.MAKHUVUC "
                + "WHERE CH.MACH = ? AND HD.THANHTOAN = 0 " // Fix mising space before WHERE
                + "ORDER BY HD.NGAYTAO, GN.NGAYGHI";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HoaDonModel bill = new HoaDonModel(
                        resultSet.getString("MAHOADON"),
                        resultSet.getString("MANVLHD"),
                        resultSet.getString("MAGHI"),
                        resultSet.getString("MADH"),
                        resultSet.getString("MANVGN"),
                        resultSet.getString("TENNVLHD"),
                        resultSet.getString("TENNVGN"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"),
                        resultSet.getString("KI"),
                        resultSet.getString("MACTKV"),
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getInt("TIEUTHU"),
                        resultSet.getInt("TONGTIEN"),
                        resultSet.getInt("THANHTOAN"),
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getDate("NGAYDENHAN"),
                        resultSet.getDate("NGAYTRA"),
                        resultSet.getDate("NGAYTAO"),
                        resultSet.getDate("NGAYGHI"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    public static List<HoaDonModel> hienThiCacHoaDonChuaTraTheoDiaChi(String maDiaChi) throws ClassNotFoundException {
        List<HoaDonModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT HD.MAHOADON, HD.TIEUTHU, HD.TONGTIEN, HD.THANHTOAN, "
                + "HD.NGAYDENHAN, HD.NGAYTRA, HD.NGAYTAO, "
                + "NVLHD.MANV AS MANVLHD, NVLHD.HOTEN AS TENNVLHD, "
                + "NVGN.MANV AS MANVGN, NVGN.HOTEN AS TENNVGN, "
                + "GN.NGAYGHI, GN.MAGHI, GN.KI, GN.CSC, GN.CSM, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI, CH.MACH, "
                + "CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC "
                + "FROM HOADON AS HD "
                + "JOIN NHANVIEN AS NVLHD ON HD.MANV = NVLHD.MANV "
                + "JOIN GHINUOC AS GN ON GN.MAGHI = HD.MAGHI "
                + "JOIN NHANVIEN AS NVGN ON GN.MANV = NVGN.MANV "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "JOIN CHITIETKHUVUC AS CTKV ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN KHUVUC AS KV ON KV.MAKHUVUC = CTKV.MAKHUVUC "
                + "WHERE CH.MACH = ? AND HD.THANHTOAN = 0 AND DH.MADIACHI = ? " 
                + "ORDER BY HD.NGAYTAO, GN.NGAYGHI";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            statement.setString(2, maDiaChi);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HoaDonModel bill = new HoaDonModel(
                        resultSet.getString("MAHOADON"),
                        resultSet.getString("MANVLHD"),
                        resultSet.getString("MAGHI"),
                        resultSet.getString("MADH"),
                        resultSet.getString("MANVGN"),
                        resultSet.getString("TENNVLHD"),
                        resultSet.getString("TENNVGN"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"),
                        resultSet.getString("KI"),
                        resultSet.getString("MACTKV"),
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getInt("TIEUTHU"),
                        resultSet.getInt("TONGTIEN"),
                        resultSet.getInt("THANHTOAN"),
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getDate("NGAYDENHAN"),
                        resultSet.getDate("NGAYTRA"),
                        resultSet.getDate("NGAYTAO"),
                        resultSet.getDate("NGAYGHI"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    public static List<HoaDonModel> sapXepTheoGiaTien(List<HoaDonModel> dsHoaDon, boolean tangDan) {
        if (tangDan) {
            Collections.sort(dsHoaDon, Comparator.comparing(HoaDonModel::getTongTien));
        } else {
            Collections.sort(dsHoaDon, Comparator.comparing(HoaDonModel::getTongTien).reversed());
        }
        return dsHoaDon;
    }

    public static void thanhToan(String maHoaDon) throws ClassNotFoundException {
        Date ngayHomNay = new Date();
        java.sql.Date ngayHomNaySQL = new java.sql.Date(ngayHomNay.getTime());
        String sql = "UPDATE HOADON SET THANHTOAN = ?, NGAYTRA = ? WHERE MAHOADON = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, 3);
            statement.setDate(2, ngayHomNaySQL);
            statement.setString(3, maHoaDon);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String traVeEmail() throws ClassNotFoundException{
        String sql = "SELECT * FROM TAIKHOAN WHERE MATK = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email =  resultSet.getString("EMAIL");
                return email;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Info
    public static ThongTinCaNhanModel hienThiChuHo() throws ClassNotFoundException {
        String sql = "SELECT CH.MACH, CH.HOTEN, CH.SDT, CH.CCCD, "
                + "CH.DIACHITT, CH.GIOITINH, TK.EMAIL  "
                + "FROM CHUHO AS CH "
                + "JOIN TAIKHOAN AS TK ON TK.MATK = CH.MACH "
                + "WHERE CH.MACH = ?";
        ThongTinCaNhanModel ch = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ch = new ThongTinCaNhanModel(
                        resultSet.getString("MACH"),
                        resultSet.getString("HOTEN"),
                        resultSet.getString("SDT"),
                        resultSet.getString("CCCD"),
                        resultSet.getString("DIACHITT"),
                        resultSet.getString("GIOITINH"),
                        resultSet.getString("EMAIL"));
                return ch;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<HoModel> hienThiCacHoDangSuDungDichVu() throws ClassNotFoundException {
        List<HoModel> dsCacHo = new ArrayList<>();
        String sql = "SELECT CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI "
                + "FROM CHITIETKHUVUC AS CTKV "
                + "JOIN KHUVUC AS KV ON CTKV.MAKHUVUC = KV.MAKHUVUC "
                + "JOIN DONGHO AS DH ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN CHUHO AS CH ON CH.MACH = DH.MACH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "WHERE CH.MACH = ? "
                + "ORDER BY CTKV.MACTKV";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HoModel house = new HoModel(
                        resultSet.getString("MACTKV"), 
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getString("MADH"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"));
                dsCacHo.add(house);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsCacHo;
    }
    
    //Log in
    public static String dangNhap(String email, String matKhau) throws ClassNotFoundException {
        String sql = "SELECT MATKHAU, MAPQ FROM TAIKHOAN AS TK "
                + "WHERE EMAIL = ? AND TRANGTHAI = 1";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String rightPassword = resultSet.getString("MATKHAU");
                if (rightPassword.equals(matKhau)) {
                    return resultSet.getString("MAPQ");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void ganMaChuHo(String email) throws ClassNotFoundException{
        String sql = "SELECT * FROM TAIKHOAN WHERE EMAIL = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                maChuHo = resultSet.getString("MATK");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean kiemTraEmailCoTonTai(String email) throws ClassNotFoundException {
        boolean flag = false;
        //  RolePerson = 'R3' 
        String sql = "SELECT EMAIL FROM TAIKHOAN WHERE EMAIL = ? AND TRANGTHAI = 1";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static boolean kiemTraMatKhauCoChinhXac(String email, String password) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM TAIKHOAN "
                + "WHERE EMAIL = ? AND MATKHAU = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void taoMatKhauMoi(String matKhau, String email) throws ClassNotFoundException {
        String sql = "UPDATE MATKHAU SET TAIKHOAN=? WHERE EMAIL=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, matKhau);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Bill
    public static List<HoaDonModel> hienThiHoaDon() throws ClassNotFoundException {
        List<HoaDonModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT HD.MAHOADON, HD.TIEUTHU, HD.TONGTIEN, HD.THANHTOAN, "
                + "HD.NGAYDENHAN, HD.NGAYTRA, HD.NGAYTAO, "
                + "NVLHD.MANV AS MANVLHD, NVLHD.HOTEN AS TENNVLHD, "
                + "NVGN.MANV AS MANVGN, NVGN.HOTEN AS TENNVGN, "
                + "GN.NGAYGHI, GN.MAGHI, GN.KI, GN.CSC, GN.CSM, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI, CH.MACH, "
                + "CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC "
                + "FROM HOADON AS HD "
                + "JOIN NHANVIEN AS NVLHD ON HD.MANV = NVLHD.MANV "
                + "JOIN GHINUOC AS GN ON GN.MAGHI = HD.MAGHI "
                + "JOIN NHANVIEN AS NVGN ON GN.MANV = NVGN.MANV "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "JOIN CHITIETKHUVUC AS CTKV ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN KHUVUC AS KV ON KV.MAKHUVUC = CTKV.MAKHUVUC "
                + "WHERE CH.MACH = ? AND HD.THANHTOAN != 0 " 
                + "ORDER BY HD.NGAYTAO, GN.NGAYGHI";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HoaDonModel bill = new HoaDonModel(
                        resultSet.getString("MAHOADON"),
                        resultSet.getString("MANVLHD"),
                        resultSet.getString("MAGHI"),
                        resultSet.getString("MADH"),
                        resultSet.getString("MANVGN"),
                        resultSet.getString("TENNVLHD"),
                        resultSet.getString("TENNVGN"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"),
                        resultSet.getString("KI"),
                        resultSet.getString("MACTKV"),
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getInt("TIEUTHU"),
                        resultSet.getInt("TONGTIEN"),
                        resultSet.getInt("THANHTOAN"),
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getDate("NGAYDENHAN"),
                        resultSet.getDate("NGAYTRA"),
                        resultSet.getDate("NGAYTAO"),
                        resultSet.getDate("NGAYGHI"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    public static List<HoaDonModel> hienThiHoaDonTheoDiaChi(String maDiaChi) throws ClassNotFoundException {
        List<HoaDonModel> dsHoaDon = new ArrayList<>();
        String sql = "SELECT HD.MAHOADON, HD.TIEUTHU, HD.TONGTIEN, HD.THANHTOAN, "
                + "HD.NGAYDENHAN, HD.NGAYTRA, HD.NGAYTAO, "
                + "NVLHD.MANV AS MANVLHD, NVLHD.HOTEN AS TENNVLHD, "
                + "NVGN.MANV AS MANVGN, NVGN.HOTEN AS TENNVGN, "
                + "GN.NGAYGHI, GN.MAGHI, GN.KI, GN.CSC, GN.CSM, "
                + "DH.MADH, DH.TENDH, LN.MALOAI, LN.TENLOAI, CH.MACH, "
                + "CTKV.MACTKV, CTKV.TENCHITIET, KV.MAKHUVUC, KV.TENKHUVUC "
                + "FROM HOADON AS HD "
                + "JOIN NHANVIEN AS NVLHD ON HD.MANV = NVLHD.MANV "
                + "JOIN GHINUOC AS GN ON GN.MAGHI = HD.MAGHI "
                + "JOIN NHANVIEN AS NVGN ON GN.MANV = NVGN.MANV "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN LOAI AS LN ON DH.MALOAI = LN.MALOAI "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "JOIN CHITIETKHUVUC AS CTKV ON CTKV.MACTKV = DH.MADIACHI "
                + "JOIN KHUVUC AS KV ON KV.MAKHUVUC = CTKV.MAKHUVUC "
                + "WHERE CH.MACH = ? AND HD.THANHTOAN != 0 AND CTKV.MACTKV = ? " 
                + "ORDER BY HD.NGAYTAO, GN.NGAYGHI";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            statement.setString(2, maDiaChi);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HoaDonModel bill = new HoaDonModel(
                        resultSet.getString("MAHOADON"),
                        resultSet.getString("MANVLHD"),
                        resultSet.getString("MAGHI"),
                        resultSet.getString("MADH"),
                        resultSet.getString("MANVGN"),
                        resultSet.getString("TENNVLHD"),
                        resultSet.getString("TENNVGN"),
                        resultSet.getString("TENDH"),
                        resultSet.getString("MALOAI"),
                        resultSet.getString("TENLOAI"),
                        resultSet.getString("KI"),
                        resultSet.getString("MACTKV"),
                        resultSet.getString("TENCHITIET"),
                        resultSet.getString("MAKHUVUC"),
                        resultSet.getString("TENKHUVUC"),
                        resultSet.getInt("TIEUTHU"),
                        resultSet.getInt("TONGTIEN"),
                        resultSet.getInt("THANHTOAN"),
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getDate("NGAYDENHAN"),
                        resultSet.getDate("NGAYTRA"),
                        resultSet.getDate("NGAYTAO"),
                        resultSet.getDate("NGAYGHI"));
                dsHoaDon.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }
    
    private static String traVeHinhThucTrungGian(String maHD) throws ClassNotFoundException {
        String output = null;
        String sql = "SELECT HD.MAHOADON, HT.TENHT, TG.MATG, TG.MACTKV,TG.TENTG "
                + "FROM HOADON AS HD "
                + "JOIN HINHTHUCTHANHTOAN AS HT ON HD.THANHTOAN = HT.MAHT "
                + "JOIN TRUNGGIAN AS TG ON HD.MATG = TG.MATG "
                + "WHERE HD.MAHOADON = ? AND HD.THANHTOAN = 2";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maHD);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                output = resultSet.getString("TENHT") + " tại " + resultSet.getString("TENTG");
                return output;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
    private static String traVeHinhThucKhac(String maHD) throws ClassNotFoundException {
        String output = null;
        String sql = "SELECT HD.MAHOADON, HT.TENHT "
                + "FROM HOADON AS HD "
                + "JOIN HINHTHUCTHANHTOAN AS HT ON HD.THANHTOAN = HT.MAHT "
                + "WHERE HD.MAHOADON = ? AND (HD.THANHTOAN = 1 OR HD.THANHTOAN = 3)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maHD);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                output = resultSet.getString("TENHT");
                return output;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
    public static String traVeHinhThucThanhToan(String maHD) throws ClassNotFoundException{
        String sql = "SELECT THANHTOAN FROM HOADON "
                + "WHERE MAHOADON = ? AND THANHTOAN != 0";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maHD);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int thanhToan = resultSet.getInt("THANHTOAN");
                if (thanhToan == 2){
                    return traVeHinhThucTrungGian(maHD);
                } else if (thanhToan == 1 || thanhToan == 3){
                    return traVeHinhThucKhac(maHD);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<HoaDonModel> sapXepTheoTienTangDan(List<HoaDonModel> dsHoaDon) throws ClassNotFoundException {
        dsHoaDon.sort(Comparator.comparing(HoaDonModel::getTongTien));
        return dsHoaDon;
    }

    public static List<HoaDonModel> sapXepTheoTienGiamDan(List<HoaDonModel> dsHoaDon) throws ClassNotFoundException {
        dsHoaDon.sort(Comparator.comparing(HoaDonModel::getTongTien).reversed());
        return dsHoaDon;
    }

    // Change Password
    public static boolean kiemTraMatKhauHienTai(String password) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT TK.MATKHAU FROM TAIKHOAN AS TK "
                + "JOIN CHUHO AS CH ON TK.MATK = CH.MACH "
                + "WHERE CH.MACH = ? AND TK.MATKHAU = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void doiMatKhau(String password) throws ClassNotFoundException {
        String sql = "UPDATE TAIKHOAN SET MATKHAU=? WHERE MATK=? ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, password);
            statement.setString(2, maChuHo);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Chart
    public static List<ThongKeModel> layDuLieuThongKe(String maDiaChi) throws ClassNotFoundException {
        List<ThongKeModel> list = new ArrayList<>();
        String sql = "SELECT GN.CSC, GN.CSM, GN.KI, HD.TONGTIEN "
                + "FROM HOADON AS HD "
                + "JOIN GHINUOC AS GN ON HD.MAGHI = GN.MAGHI "
                + "JOIN DONGHO AS DH ON DH.MADH = GN.MADH "
                + "JOIN CHUHO AS CH ON DH.MACH = CH.MACH "
                + "WHERE CH.MACH = ? AND DH.MADIACHI = ? "
                + "ORDER BY GN.KI DESC ";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuHo);
            statement.setString(2, maDiaChi);
            ResultSet resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next() && count < 6) {
                ThongKeModel chart = new ThongKeModel();
                int chiSoCu = resultSet.getInt("CSC");
                int chiSoMoi = resultSet.getInt("CSM");
                int soNuocTieuThu = chiSoMoi - chiSoCu;
                chart.setKi(resultSet.getString("KI"));
                chart.setSoTienPhaiTra(resultSet.getInt("TONGTIEN"));
                chart.setSoNuocTieuThu(soNuocTieuThu);
                list.add(chart);
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.reverse(list);
        return list;
    }

    public static void thongKe(JPanel jpnItem1, JPanel jpnItem2, String maDiaChi) {
        try {
            List<ThongKeModel> listItem = layDuLieuThongKe(maDiaChi);
            if (listItem != null && !listItem.isEmpty()) {
                DefaultCategoryDataset datasetWater = new DefaultCategoryDataset();
                DefaultCategoryDataset datasetMoney = new DefaultCategoryDataset();

                for (ThongKeModel item : listItem) {
                    datasetWater.addValue(item.getSoNuocTieuThu(), "Số nước tiêu thụ", item.getKi());
                    datasetMoney.addValue(item.getSoTienPhaiTra(), "Số tiền phải trả", item.getKi());
                }

                // Create water consumption chart (bar chart)
                JFreeChart chartWater = ChartFactory.createBarChart(
                        "Thống kê số nước", // Tiêu đề biểu đồ
                        "Thời gian", // Nhãn của trục ngang
                        "Số lượng", // Nhãn của trục dọc
                        datasetWater, // Dataset cho dữ liệu của biểu đồ
                        org.jfree.chart.plot.PlotOrientation.VERTICAL, // Hướng của biểu đồ (vertical)
                        true, // Có hiển thị legend không
                        true, // Có tạo tooltips không
                        false // Có tạo URLs không
                );
                ChartPanel chartPanel1 = new ChartPanel(chartWater);
                chartPanel1.setPreferredSize(new Dimension(jpnItem1.getWidth(), 300));

                CategoryPlot plot1 = chartWater.getCategoryPlot();
                plot1.setBackgroundPaint(Color.WHITE);
                BarRenderer renderer1 = (BarRenderer) plot1.getRenderer();
                renderer1.setSeriesPaint(0, new Color(173, 216, 230));

                renderer1.setMaximumBarWidth(0.1);

                jpnItem1.removeAll();
                jpnItem1.setLayout(new CardLayout());
                jpnItem1.add(chartPanel1);
                jpnItem1.validate();
                jpnItem1.repaint();

                // Create money to pay chart (line chart)
                JFreeChart chartMoney = ChartFactory.createLineChart(
                        "Thống kê tiền phải trả", // Tiêu đề biểu đồ
                        "Thời gian", // Nhãn của trục ngang
                        "Tiền", // Nhãn của trục dọc
                        datasetMoney, // Dataset cho dữ liệu của biểu đồ
                        org.jfree.chart.plot.PlotOrientation.VERTICAL, // Hướng của biểu đồ (vertical)
                        true, // Có hiển thị legend không
                        true, // Có tạo tooltips không
                        false // Có tạo URLs không
                );
                CategoryPlot plot2 = chartMoney.getCategoryPlot();
                plot2.setBackgroundPaint(Color.WHITE);
                LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
                plot2.setRenderer(renderer2);
                renderer2.setDefaultShapesVisible(true);
                renderer2.setDefaultShape(new Ellipse2D.Double(-2, -2, 4, 4));
                renderer2.setDefaultToolTipGenerator(new StandardCategoryToolTipGenerator());

                // Update JPanel with the money to pay chart
                ChartPanel chartPanel2 = new ChartPanel(chartMoney);
                chartPanel2.setPreferredSize(new Dimension(jpnItem2.getWidth(), 300));
                jpnItem2.removeAll();
                jpnItem2.setLayout(new CardLayout());
                jpnItem2.add(chartPanel2);
                jpnItem2.validate();
                jpnItem2.repaint();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
