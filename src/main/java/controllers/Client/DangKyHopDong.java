/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.Client;

import controllers.Manager.CapNhatPhanCongChiTietCtrl;
import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.HopDongModel;
import models.PhanCongModel;

/**
 *
 * @author GIANG
 */
public class DangKyHopDong {

    public static HopDongModel themHopDong(HopDongModel hopDongModel) throws ClassNotFoundException {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO HOPDONG (MAHD, TENHD, TENNGUOIDANGKY, DIACHIEMAIL, DIADIEMDANGKY, NDHD, DULIEUCCCD, DULIEUCHUNGMINHNHADAT, DULIEUCHUKY, TRANGTHAI, SODIENTHOAI, CCCD, LOAINUOC) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            // Set the parameters for the PreparedStatement
            statement.setString(1, hopDongModel.getMAHD());
            statement.setString(2, hopDongModel.getTENHD());
            statement.setString(3, hopDongModel.getTENNGUOIDANGKY());
            statement.setString(4, hopDongModel.getDIACHIEMAIL());
            statement.setString(5, hopDongModel.getDIADIEMDANGKY());
            statement.setString(6, hopDongModel.getNDHD());
            statement.setString(7, hopDongModel.getDULIEUCCCD());
            statement.setString(8, hopDongModel.getDULIEUCHUNGMINHNHADAT());
            statement.setString(9, hopDongModel.getDULIEUCHUKY());
            statement.setString(10, hopDongModel.getTRANGTHAI());
            statement.setString(11, hopDongModel.getSODIENTHOAI());
            statement.setString(12, hopDongModel.getCCCD());
            statement.setString(13, hopDongModel.getLOAINUOC());
            

            // Execute the insert statement
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CapNhatPhanCongChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close the resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CapNhatPhanCongChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return hopDongModel;
    }

}
