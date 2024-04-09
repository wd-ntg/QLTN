
package controllers.Worker;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Worker.ChuHoModel;
import models.Worker.DinhMucModel;
import models.Worker.GhiNuocModel;
import models.Worker.HoaDonModel;
import models.Worker.NhanVienModel;




public class WorkerController {
    public NhanVienModel getInforNVbyID(String maNV){
        String sql = """
                     select *
                     from NHANVIEN as nv
                     join TAIKHOAN as tk
                     on nv.MANV = tk.MATK
                     where MANV = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, maNV);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                NhanVienModel nhanVienModel = new NhanVienModel(
                        resultSet.getString("MANV"), 
                        resultSet.getString("HOTEN"), 
                        resultSet.getString("SDT"), 
                        resultSet.getString("CCCD"),
                        resultSet.getString("GIOITINH"), 
                        resultSet.getString("MAKHUVUC") );
                nhanVienModel.setEmail(resultSet.getString("EMAIL"));
                nhanVienModel.setPassword(resultSet.getString("MATKHAU"));

                return nhanVienModel;              
            }
        }
        catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public NhanVienModel getInforNVbyEmail(String email){
        String sql = """
                     select *
                     from NHANVIEN as nv
                     join TAIKHOAN as tk
                     on nv.MANV = tk.MATK
                     where EMAIL = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                NhanVienModel nhanVienModel = new NhanVienModel(
                        resultSet.getString("MANV"), 
                        resultSet.getString("HOTEN"), 
                        resultSet.getString("SDT"), 
                        resultSet.getString("CCCD"),
                        resultSet.getString("GIOITINH"), 
                        resultSet.getString("MAKHUVUC") );
                nhanVienModel.setEmail(resultSet.getString("EMAIL"));
                nhanVienModel.setPassword(resultSet.getString("MATKHAU"));

                return nhanVienModel;              
            }
        }
        catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ChuHoModel getInforCHbyMADH(String maDH){
        String sql = """
                    select ch.MACH, ch.HOTEN, ch.SDT, ch.CCCD, ch.GIOITINH, dh.MADH, l.TENLOAI,ctkv.TENCHITIET
                    from CHUHO as ch
                    join DONGHO as dh
                    on ch.MACH = dh.MACH
                    join CHITIETKHUVUC as ctkv
                    on dh.MADIACHI = ctkv.MACTKV
                    join LOAI as l
                    on l.MALOAI = dh.MALOAI
                    where dh.MADH =? and dh.TRANGTHAI = 1
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, maDH);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ChuHoModel chuHoModel = new ChuHoModel(
                        resultSet.getString("MACH"),
                        resultSet.getString("HOTEN"),
                        resultSet.getString("SDT"),
                        resultSet.getString("CCCD"),
                        "",
                        resultSet.getString("GIOITINH"));

                chuHoModel.setDiaChiDatNuoc(resultSet.getString("TENCHITIET"));
                chuHoModel.setMaDH(resultSet.getString("MADH"));
                chuHoModel.setLoaiNuoc(resultSet.getString("TENLOAI"));

                return chuHoModel;              
            }
        }
        catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void changePassword(String newPassword, String maNV){
        String sql = """
                     UPDATE TAIKHOAN
                     set MATKHAU = ?
                     where MATK = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, newPassword);
            statement.setString(2, maNV);
            int rs = statement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getBranchWork(String maKV){
        String sql = """
                     select *
                     from KHUVUC as kv
                     where kv.MAKHUVUC = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, maKV);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("TENKHUVUC");              
            }
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<ChuHoModel> getInforChuHoByBranch(String branch, String where, Object ... search){
        List<ChuHoModel> lsChuHo = new ArrayList<>();
        branch = "%" + branch +"%";
        String sql = """
                    select ch.MACH, ch.HOTEN, ch.SDT, ch.CCCD, ch.GIOITINH, dh.MADH, l.TENLOAI,ctkv.TENCHITIET
                    from CHUHO as ch
                    join DONGHO as dh
                    on ch.MACH = dh.MACH
                    join CHITIETKHUVUC as ctkv
                    on dh.MADIACHI = ctkv.MACTKV
                    join LOAI as l
                    on l.MALOAI = dh.MALOAI
                    where ctkv.TENCHITIET like ? and dh.TRANGTHAI = 1
                     """ + where;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, branch);
            for(int i = 0; i< search.length; i++){
                statement.setObject(i+2, search[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ChuHoModel chuHoModel = new ChuHoModel(
                        resultSet.getString("MACH"),
                        resultSet.getString("HOTEN"),
                        resultSet.getString("SDT"),
                        resultSet.getString("CCCD"),
                        "",
                        resultSet.getString("GIOITINH"));

                chuHoModel.setDiaChiDatNuoc(resultSet.getString("TENCHITIET"));
                chuHoModel.setMaDH(resultSet.getString("MADH"));
                chuHoModel.setLoaiNuoc(resultSet.getString("TENLOAI"));
                lsChuHo.add(chuHoModel);
                              
            }
            return lsChuHo;
        }
        catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<HoaDonModel> getInforUsersPendingByBranch(String branch, String where, Object ... search){
        List<HoaDonModel> lsBills = new ArrayList<>();
        branch = "%" + branch +"%";
        String sql = """
                    select hd.MAHOADON, ch.MACH,ch.HOTEN, ctkv.TENCHITIET, hd.TONGTIEN, gn.KI, hd.NGAYDENHAN,dh.MADH
                    from CHUHO as ch
                    join DONGHO  as dh
                    on ch.MACH = dh.MACH
                    join CHITIETKHUVUC as ctkv
                    on dh.MADIACHI = ctkv.MACTKV
                    join GHINUOC as gn
                    on gn.MADH = dh.MADH
                    join HOADON as hd
                    on hd.MAGHI = gn.MAGHI
                    where ctkv.TENCHITIET like ? and dh.TRANGTHAI = 1 and hd.THANHTOAN = 0
                     """ + where;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, branch);
            for(int i = 0; i< search.length; i++){
                statement.setObject(i+2, search[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HoaDonModel hoadon = new HoaDonModel();
                hoadon.setMaHoaDon(resultSet.getString("MAHOADON"));
                hoadon.getChuHo().setMaCH(resultSet.getString("MACH"));
                hoadon.getChuHo().setHoTen(resultSet.getString("HOTEN"));
                hoadon.getChuHo().setMaDH(resultSet.getString("MADH"));
                hoadon.setDiaChiChiTiet(resultSet.getString("TENCHITIET"));
                hoadon.setTongtien(resultSet.getDouble("TONGTIEN"));
                hoadon.setKi(String.valueOf(resultSet.getDate("KI")));
                hoadon.setNgayDenHan((Date) resultSet.getDate("NGAYDENHAN"));
                lsBills.add(hoadon);
                              
            }
            return lsBills;
        }
        catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void recordGhiNuocHoDan(GhiNuocModel ghiNuocModel) {
        String sql = """
                     UPDATE GHINUOC
                     SET CSM = ?, NGAYGHI = ?, MANV = ?
                     WHERE MAGHI = ?;
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, ghiNuocModel.getCSM());
            statement.setString(2, ghiNuocModel.getNgayGhi());
            statement.setString(3, ghiNuocModel.getMaNV());
            statement.setString(4, ghiNuocModel.getMaGhi());
           
            int rs = statement.executeUpdate();
            System.out.println(rs);
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<GhiNuocModel> getLsGhiNuocChuHo(String maDH){
        List<GhiNuocModel> lsGhiNuoc = new ArrayList<>();
        String sql = """
                    select *
                     from GHINUOC as gn
                     where gn.MADH = ?
                     order by gn.CSC DESC
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, maDH);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                GhiNuocModel billModel = new GhiNuocModel(
                        resultSet.getString("MAGHI"), 
                        resultSet.getString("MADH"), 
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getString("MANV")==null?"":resultSet.getString("MANV"),
                        String.valueOf(resultSet.getDate("NGAYGHI")), 
                        String.valueOf(resultSet.getDate("KI")),
                        resultSet.getString("NGAYBATDAUGHI"),
                        resultSet.getString("NGAYHANGHI")
                );
                lsGhiNuoc.add(billModel);
                              
            }
            return lsGhiNuoc;
        }
        catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsGhiNuoc;
    }
    public GhiNuocModel getGhiNuocMoiNhat(String maDH) {
        GhiNuocModel ghiNuocModel = null;
        String sql = """
                    select TOP 1 *  
                    from GHINUOC as gn
                    where gn.MADH = ? and YEAR(gn.KI) = YEAR(GETDATE()) and MONTH(gn.KI) = MONTH(GETDATE()) -1
                    order by gn.CSC DESC
                    
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, maDH);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                GhiNuocModel ghiNuocModeltmp = new GhiNuocModel(
                        resultSet.getString("MAGHI"),
                        maDH,
                        resultSet.getInt("CSC"),
                        resultSet.getInt("CSM"),
                        resultSet.getString("MANV"),
                        String.valueOf(resultSet.getDate("NGAYGHI")),
                        String.valueOf(resultSet.getDate("KI")),
                        resultSet.getString("NGAYBATDAUGHI"),
                        resultSet.getString("NGAYHANGHI"));
                ghiNuocModel = ghiNuocModeltmp;
            }
            return ghiNuocModel;
        }
        catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ghiNuocModel;
    }
    
    
    public String getIdBill() throws ClassNotFoundException{
        String idBill = "";
        int numflag = -1;
        String sql = """
                     SELECT cm.CollectMoneyId
                     FROM CollectMoney AS cm
                     
                    """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                
                idBill = resultSet.getString("CollectMoneyId");
                
                int number = Integer.parseInt(idBill.substring(2));
                if(numflag < number){
                    numflag = number;
                }          
            }
            idBill = "MD" + numflag;
        }
        catch (SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return idBill;
    }
    
    public List<DinhMucModel> getDinhMuc(String maDH){
        List<DinhMucModel> lsDinhMuc = new ArrayList<>();
        String sql = """
                     select *
                     from DINHMUC as dm
                     join DONGHO as dh
                     on dm.MALOAI = dh.MALOAI
                     where dh.MADH = ?
                     order by dm.SODAU ASC
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, maDH);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DinhMucModel dinhMucModel = new DinhMucModel(
                        resultSet.getString("MADINHMUC"),
                        resultSet.getString("MALOAI"),
                        resultSet.getInt("SODAU"),
                        resultSet.getInt("SOCUOI"),
                        resultSet.getDouble("THUE"),
                        resultSet.getDouble("DONGIA"));
                lsDinhMuc.add(dinhMucModel);
            }
            return lsDinhMuc;
        }
        catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Map<String, Double> getPayDone(String area, int month){
        Map<String, Double> payDoneMap = new HashMap<>();
        String sql = """
                    select COUNT(hd.MAHOADON) as DonePay
                    from HOADON as hd
                    join GHINUOC as gn
                    on hd.MAGHI = gn.MAGHI
                    join DONGHO as dh
                    on gn.MADH = dh.MADH
                    join CHITIETKHUVUC as ctkv
                    on dh.MADIACHI = ctkv.MACTKV
                    where ctkv.TENCHITIET like ?
                    and dh.TRANGTHAI = 1 
                    and hd.THANHTOAN =1
                    and YEAR(hd.NGAYTAO) = YEAR(GETDATE()) 
                    and MONTH(hd.NGAYTAO) = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, "%"+area +"%");
            statement.setInt(2, month);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {        
                payDoneMap.put("DonePay", resultSet.getDouble("DonePay"));
            }
            return payDoneMap;
        }
        catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Map<String, Double> getPayPending(String area, int month){
        Map<String, Double> payDoneMap = new HashMap<>();
        String sql = """
                    select COUNT(hd.MAHOADON) as PendingPay
                    from HOADON as hd
                    join GHINUOC as gn
                    on hd.MAGHI = gn.MAGHI
                    join DONGHO as dh
                    on gn.MADH = dh.MADH
                    join CHITIETKHUVUC as ctkv
                    on dh.MADIACHI = ctkv.MACTKV
                    where ctkv.TENCHITIET like ?
                    and dh.TRANGTHAI = 1 
                    and hd.THANHTOAN =0
                    and YEAR(hd.NGAYTAO) = YEAR(GETDATE()) 
                    and MONTH(hd.NGAYTAO) = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, "%"+area +"%");
            statement.setInt(2, month);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {        
                payDoneMap.put("PendingPay", resultSet.getDouble("PendingPay"));
            }
            return payDoneMap;
        }
        catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int getTotalUser(String area){
        int totalUser = 0;
        String sql ="""
                    select count(tmp_table.MACH) as TotalUser
                    from  (
                    	select distinct ch.MACH
                    	from CHUHO as ch
                    	join DONGHO as dh
                    	on ch.MACH = dh.MACH
                    	join CHITIETKHUVUC as ctkv
                    	on dh.MADIACHI = ctkv.MACTKV
                    	where ctkv.TENCHITIET like ?
                    ) as tmp_table
                    """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, "%"+area +"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {        
                totalUser = resultSet.getInt("TotalUser");
            }
            return totalUser;
        }
        catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int setUserHadPayDone(String maHD, String ngayTra, String maNV){
        String sql = """
                    update HOADON
                    set NGAYTRA = ?, MANV = ?, THANHTOAN = ?
                    where MAHOADON = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, ngayTra);
            statement.setString(2, maNV);
            statement.setInt(3, 1);
            statement.setString(4, maHD);


            int rs = statement.executeUpdate();
            return rs;
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}