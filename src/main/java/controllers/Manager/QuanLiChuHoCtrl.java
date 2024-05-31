/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.Manager;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ChuHoModel;
import models.QuanLyModel;
import models.TaiKhoanModel;


/**
 *
 * @author hoang
 */

public class QuanLiChuHoCtrl {
    
    //PersonModel personModel = DataGlobal.getDataGLobal.dataGlobal.getCurrentEditPerson();

    // Thêm chủ hộ vào cơ sở dữ liệu
    public static void themChuHo(ChuHoModel chuho, TaiKhoanModel taikhoan) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectDB.getConnection();

            //Chèn dữ liệu vào bảng Account
            String sql2 = "INSERT INTO TAIKHOAN (MATK, EMAIL, MATKHAU, MAPQ, TRANGTHAI) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            statement2.setString(1, taikhoan.getMATK());
            statement2.setString(2, taikhoan.getEMAIL());
            statement2.setString(3, chuho.getSDT());
            statement2.setString(4, taikhoan.getMAPQ());
            statement2.setBoolean(5, true);
            statement2.executeUpdate();

            //Chèn dữ liệu vào bảng Chuho
            String sql = "INSERT INTO CHUHO (MACH, HOTEN, SDT, CCCD, DIACHITT, GIOITINH) VALUES (?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            statement.setString(1, chuho.getMACH());
            statement.setString(2, chuho.getHOTEN());
            statement.setString(3, chuho.getSDT());
            statement.setString(4, chuho.getCCCD());
            statement.setString(5, chuho.getDIACHITT());
            statement.setString(6, chuho.getGIOITINH());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<ChuHoModel> timTatCaChuHo() throws ClassNotFoundException {
        List<ChuHoModel> dsChuHo = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT CH.MACH, CH.HOTEN, CH.SDT, CH.CCCD, CH.DIACHITT, CH.GIOITINH, TAIKHOAN.EMAIL "
                    + "FROM CHUHO CH "
                    + "JOIN TAIKHOAN ON TAIKHOAN.MATK = CH.MACH "
                    + "WHERE TAIKHOAN.TRANGTHAI = 'TRUE'";

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String maChuHo = resultSet.getString("MACH");
                String hoTen = resultSet.getString("HOTEN");
                String soDienThoai = resultSet.getString("SDT");
                String cccd = resultSet.getString("CCCD");
                String diaChiTT = resultSet.getString("DIACHITT");
                String gioiTinh = resultSet.getString("GIOITINH");
                String email = resultSet.getString("EMAIL");
                
                ChuHoModel chuHoModel = new ChuHoModel(maChuHo, hoTen, soDienThoai, cccd, diaChiTT, gioiTinh, email);
                dsChuHo.add(chuHoModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsChuHo;
    }
    
    public static void XoaChuHo(String Email) throws ClassNotFoundException {
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
            Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
      
    public static void CapNhatChuHo(ChuHoModel chuho, String email, String maCH) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE CHUHO SET HOTEN=?, SDT=?, CCCD=?, DIACHITT = ?, GIOITINH=? WHERE MACH=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, chuho.getHOTEN());
            statement.setString(2, chuho.getSDT());
            statement.setString(3, chuho.getCCCD());
            statement.setString(4, chuho.getDIACHITT());
            statement.setString(5, chuho.getGIOITINH());
            statement.setString(6, maCH);
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static QuanLyModel layThongTinQuanLy(String email) throws ClassNotFoundException {
        QuanLyModel quanLy = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT QL.MAQL, QL.HOTEN, QL.SDT, QL.CCCD, QL.NGAYLAM, TAIKHOAN.EMAIL " +
                         "FROM QUANLY QL " +
                         "JOIN TAIKHOAN ON TAIKHOAN.MATK = QL.MAQL " +
                         "WHERE TAIKHOAN.EMAIL = ? AND TAIKHOAN.TRANGTHAI = 'TRUE'";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String MAQL = resultSet.getString("MAQL");
                String HOTEN = resultSet.getString("HOTEN");
                String SDT = resultSet.getString("SDT");
                String CCCD = resultSet.getString("CCCD");
                String NGAYLAM = resultSet.getString("NGAYLAM");
                String EMAIL = resultSet.getString("EMAIL");
                quanLy = new QuanLyModel(MAQL, HOTEN, SDT, CCCD, NGAYLAM, EMAIL);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return quanLy;
    }
      
    /*public static List<PersonModel> kiemTraTinhTrangThanhToan() throws ClassNotFoundException {
        List<PersonModel> overdueClients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM CollectMoney WHERE DATEDIFF(WEEK, TimeCollect, GETDATE()) >= 5 AND StatusCollect = 0";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String personId = resultSet.getString("PersonId");
                // Lấy thông tin của người dùng từ PersonId và thêm vào danh sách overdueClients
                PersonModel person = layThongTinNguoiDung(personId);
                if (person != null) {
                    overdueClients.add(person);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return overdueClients;
    }*/

    // Phương thức này để lấy thông tin của người dùng từ PersonId
    /*private static PersonModel layThongTinNguoiDung(String personId) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        PersonModel person = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Person WHERE PersonId = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, personId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String rolePerson = resultSet.getString("RolePerson");
                String namePerson = resultSet.getString("NamePerson");
                String email = resultSet.getString("Email");
                String phoneNumber = resultSet.getString("PhoneNumber");
                String addressPerson = resultSet.getString("AddressPerson");
                // Tạo đối tượng PersonModel từ thông tin lấy được
                person = new PersonModel(personId, rolePerson, namePerson, email, phoneNumber, addressPerson);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return person;
    }*/

    
    /*public static void capNhatTrangThaiTaiKhoan(String personId, boolean status) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Person SET StatusAcc = ? WHERE PersonId = ?";
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, status);
            statement.setString(2, personId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiChuHoCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }*/

}
