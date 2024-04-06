/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.Manager;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.KhuVucModel;

/**
 *
 * @author GIANG
 */
public class KhuVucCtrl {
    public static List<KhuVucModel> timTatCaKhuvuc() throws ClassNotFoundException {
        List<KhuVucModel> dsKhuvuc = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM KHUVUC";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String maKhuVuc = resultSet.getString("MAKHUVUC");
                String tenKhuVuc = resultSet.getString("TENKHUVUC");

                KhuVucModel khuVucModel = new KhuVucModel(maKhuVuc, tenKhuVuc);
                dsKhuvuc.add(khuVucModel);
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

        return dsKhuvuc;
    }
}
