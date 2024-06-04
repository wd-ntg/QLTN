/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.Manager;

import database.ConnectDB;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import models.KhuVucModel;
import models.LuongNuocTieuThu;
import models.NguoiDungMoi;
import models.ThongKeThanhToan;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.SimpleTimePeriod;

/**
 *
 * @author GIANG
 */
public class ThongKeCtrl {

    public static List<LuongNuocTieuThu> getDataLuongNuoc(String nam) throws ClassNotFoundException {
        List<LuongNuocTieuThu> ds = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT MONTH(NGAYDENHAN) AS THANG, SUM(TIEUTHU) AS TIEUTHU_TONG\n"
                    + "FROM HOADON\n"
                    + "WHERE YEAR(NGAYDENHAN) like ?\n"
                    + "GROUP BY MONTH(NGAYDENHAN);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nam + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer luongNuoc = resultSet.getInt("TIEUTHU_TONG");
                String ki = resultSet.getString("THANG");

                LuongNuocTieuThu luongNuocTieuThu = new LuongNuocTieuThu(luongNuoc, ki);
                ds.add(luongNuocTieuThu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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

        return ds;
    }

    public void setDataToPieChartLuongNuoc(JPanel pieChartLuongNuoc, String nam) {
        try {
            List<LuongNuocTieuThu> listLuongNuoc = getDataLuongNuoc(nam);

            DefaultPieDataset dataset = new DefaultPieDataset();
            if (listLuongNuoc != null) {
                for (LuongNuocTieuThu item : listLuongNuoc) {
                    dataset.setValue(item.getKiNuocTieuThu(), item.getTieuThuNuoc());
                }
            }

            JFreeChart chart = ChartFactory.createPieChart(
                    "Biểu đồ lượng nước tiêu thụ",// Tiêu đề biểu đồ
                    dataset, // Dữ liệu
                    true, // Hiển thị legend
                    true, // Hiển thị tooltips
                    false // Hiển thị URLs
            );

            // Tạo một bảng chú giải
            PiePlot plot = (PiePlot) chart.getPlot();
            ChartPanel chartPanel = new ChartPanel(chart);
            // Set the preferred size to the size of the container panel
            chartPanel.setPreferredSize(pieChartLuongNuoc.getPreferredSize());
            pieChartLuongNuoc.removeAll(); // Xóa dữ liệu cũ trước khi cập nhật dữ liệu mới
            pieChartLuongNuoc.setLayout(new CardLayout());
            pieChartLuongNuoc.add(chartPanel, BorderLayout.CENTER);
            pieChartLuongNuoc.validate();
            pieChartLuongNuoc.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<ThongKeThanhToan> getDataThanhToan(String nam) throws ClassNotFoundException {
        List<ThongKeThanhToan> ds = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT \n"
                    + "    MONTH(NGAYDENHAN) AS THANG, \n"
                    + "    SUM(CASE WHEN THANHTOAN IN ('0') THEN TONGTIEN ELSE 0 END) AS CHUATHANHTOAN,\n"
                    + "    SUM(CASE WHEN THANHTOAN IN ('1', '2', '3') THEN TONGTIEN ELSE 0 END) AS DATHANHTOAN\n"
                    + "FROM \n"
                    + "    HOADON\n"
                    + "WHERE \n"
                    + "    YEAR(NGAYDENHAN) like ? \n"
                    + "GROUP BY \n"
                    + "    MONTH(NGAYDENHAN);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nam + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer tongTienDaThanhToan = resultSet.getInt("DATHANHTOAN");
                Integer tongTienChuaThanhToan = resultSet.getInt("CHUATHANHTOAN");
                String ki = resultSet.getString("THANG");

                ThongKeThanhToan luongNuocTieuThu = new ThongKeThanhToan(tongTienDaThanhToan, tongTienChuaThanhToan, ki);
                ds.add(luongNuocTieuThu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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

        return ds;
    }

    public void setDataToChartThanhToan(JPanel jpnItem, String nam) {
        try {
            List<ThongKeThanhToan> thanhToan = getDataThanhToan(nam);

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            if (thanhToan != null) {
                for (ThongKeThanhToan item : thanhToan) {
                    dataset.addValue(item.getTienChuaThanhToan(), "Tiền chưa thanh toán", item.getKiThanhToan());
                    dataset.addValue(item.getTienDaThanhToan(), "Tiền đã thanh toán", item.getKiThanhToan());
                    dataset.addValue(0, "Kì", item.getKiThanhToan()); // Đây là biểu đồ cột nên kì sẽ không được hiển thị bởi cột
                }
            }

            JFreeChart barChart = ChartFactory.createBarChart(
                    "BIỂU ĐỒ THEO DÕI TÌNH TRẠNG THANH TOÁN",
                    "Kì",
                    "Tiền",
                    dataset
            );

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Integer demSoluongNguoiSuDung() throws ClassNotFoundException {
        Integer count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();//

            if (connection != null) {
                String sql = "SELECT COUNT(*) AS SoLuong FROM CHUHO;";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    count = resultSet.getInt("SoLuong");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public Integer demSoluongNhanVien() throws ClassNotFoundException {
        Integer count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();//

            if (connection != null) {
                String sql = "SELECT COUNT(*) AS SoLuong FROM NHANVIEN;";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    count = resultSet.getInt("SoLuong");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public static List<NguoiDungMoi> getNguoiDungMoi(String thang) throws ClassNotFoundException {
        List<NguoiDungMoi> ds = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "select CH.MACH, CH.HOTEN, CH.DIACHITT, L.TENLOAI\n"
                    + "from CHUHO AS CH\n"
                    + "JOIN DONGHO DH ON DH.MACH = CH.MACH\n"
                    + "JOIN LOAI L ON L.MALOAI = DH.MALOAI\n"
                    + "JOIN TAIKHOAN TK ON TK.MATK = CH.MACH\n"
                    + "WHERE TK.TGDANGKY LIKE ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + thang + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String maCH = resultSet.getString("MACH");
                String hoVaTen = resultSet.getString("HOTEN");
                String diaChi = resultSet.getString("DIACHITT");
                String loaiNuoc = resultSet.getString("TENLOAI");

                NguoiDungMoi luongNuocTieuThu = new NguoiDungMoi(maCH, hoVaTen, diaChi, loaiNuoc);
                ds.add(luongNuocTieuThu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiNhanVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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

        return ds;
    }

}
