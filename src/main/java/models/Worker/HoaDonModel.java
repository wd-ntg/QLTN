
package models.Worker;

import java.util.Date;


public class HoaDonModel {
    private String maHoaDon = "";
    private int tieuthu = 0;
    private double tongtien = 0.0;
    private Date ngayDenHan = null;
    private Date ngayTra = null;
    private String maNV = "";
    private boolean thanhToan = false;
    private String maGhi = "";
    private Date ngayTao = null;
    private ChuHoModel chuHo = new ChuHoModel();
    
    //Thêm các trường của các bảng khác
    private String ki = "";
    private String maDH = "";
    private String diaChiChiTiet = "";

    public HoaDonModel() {
    }

    
    
    public HoaDonModel(String maHoaDon, int tieuthu, double tongtien, Date ngayDenHan, Date ngayTra, String maNV, boolean thanhToan, String maGhi, Date ngayTao) {
        this.maHoaDon = maHoaDon;
        this.tieuthu = tieuthu;
        this.tongtien = tongtien;
        this.ngayDenHan = ngayDenHan;
        this.ngayTra = ngayTra;
        this.maNV = maNV;
        this.thanhToan = thanhToan;
        this.maGhi = maGhi;
        this.ngayTao = ngayTao;
    }

    public String getDiaChiChiTiet() {
        return diaChiChiTiet;
    }

    public void setDiaChiChiTiet(String diaChiChiTiet) {
        this.diaChiChiTiet = diaChiChiTiet;
    }

    
    
    public String getKi() {
        return ki;
    }

    public void setKi(String ki) {
        this.ki = ki;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    
    public ChuHoModel getChuHo() {
        return chuHo;
    }

    public void setChuHo(ChuHoModel chuHo) {
        this.chuHo = chuHo;
    }
    
    
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getTieuthu() {
        return tieuthu;
    }

    public void setTieuthu(int tieuthu) {
        this.tieuthu = tieuthu;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public Date getNgayDenHan() {
        return ngayDenHan;
    }

    public void setNgayDenHan(Date ngayDenHan) {
        this.ngayDenHan = ngayDenHan;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public boolean isThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(boolean thanhToan) {
        this.thanhToan = thanhToan;
    }

    public String getMaGhi() {
        return maGhi;
    }

    public void setMaGhi(String maGhi) {
        this.maGhi = maGhi;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    
}
