package controllers.Manager;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Client.HoaDonModel;

/**
 *
 * @author Phu Bao
 */
public class NhacDongTienNuocCtrl {

    public static List<HoaDonModel> hienThiCacHoaDonChuaThanhToan() throws ClassNotFoundException {
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
                + "WHERE HD.THANHTOAN = ? AND HD.NHACNHO = 0"
                + "ORDER BY HD.NGAYTAO, GN.NGAYGHI";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, 0);
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
            Logger.getLogger(NhacDongTienNuocCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHoaDon;
    }

    public static String layEmail(String maChuho) throws ClassNotFoundException {
        String email = null;
        String sql = "SELECT * FROM TAIKHOAN WHERE MATK = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChuho);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                email = resultSet.getString("EMAIL");
                return email;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhacDongTienNuocCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return email;
    }

    public static void doiTrangThai(String maHoaDon) throws ClassNotFoundException {
        String sql = "UPDATE HOADON SET NHACNHO = ? WHERE MAHOADON = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, true);
            statement.setString(2, maHoaDon);

            int rowsUpdated = statement.executeUpdate(); 
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật trạng thái thành công cho hóa đơn: " + maHoaDon);
            } else {
                System.out.println("Không tìm thấy hóa đơn với mã: " + maHoaDon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhacDongTienNuocCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
