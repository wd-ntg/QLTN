
package models.Worker;

import java.util.Date;


public class HoaDonModel {
    private String maHoaDon;
    private int tieuthu;
    private double tongtien;
    private Date ngayDenHan;
    private Date ngayTra;
    private String maNV;
    private int thanhToan;
    private String maGhi;
    private Date ngayTao;
    private boolean nhacNho;
    private String maTG;
    private ChuHoModel chuHo = new ChuHoModel();
    
    //Thêm các trường của các bảng khác
    private String ki = "";
    private String maDH = "";
    private String diaChiChiTiet = "";

    public HoaDonModel() {
    }

    public HoaDonModel(String maHoaDon, int tieuthu, double tongtien, Date ngayDenHan, Date ngayTra, String maNV, int thanhToan, String maGhi, Date ngayTao, boolean nhacNho, String maTG) {
        this.maHoaDon = maHoaDon;
        this.tieuthu = tieuthu;
        this.tongtien = tongtien;
        this.ngayDenHan = ngayDenHan;
        this.ngayTra = ngayTra;
        this.maNV = maNV;
        this.thanhToan = thanhToan;
        this.maGhi = maGhi;
        this.ngayTao = ngayTao;
        this.nhacNho = nhacNho;
        this.maTG = maTG;
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

    public int getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(int thanhToan) {
        this.thanhToan = thanhToan;
    }

    public boolean isNhacNho() {
        return nhacNho;
    }

    public void setNhacNho(boolean nhacNho) {
        this.nhacNho = nhacNho;
    }

    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }
    
    
}
