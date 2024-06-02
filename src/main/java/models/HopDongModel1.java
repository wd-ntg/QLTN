
package models;

import java.util.Date;


public class HopDongModel1 {
    private String maHD;
    private String tenHD;
    private String tenNguoiDangKy;
    private String email;
    private String diadiemDangKy;
    private String ndhd;
    private boolean trangThai;
    private String nguoiKyDuyet;
    private String dulieuCCCD;
    private String duLieuChungMinhNhaDat;
    private String duLieuChuKy;
    private Date ngayDangKy;
    private String sodienthoai;
    private String cccd;
    private String loaiNuoc;

    public HopDongModel1() {
    }

    public HopDongModel1(String maHD, String tenHD, String tenNguoiDangKy, String email, String diadiemDangKy, String ndhd, boolean trangThai, String nguoiKyDuyet, String dulieuCCCD, String duLieuChungMinhNhaDat, String duLieuChuKy, Date ngayDangKy, String sodienthoai, String cccd, String loaiNuoc) {
        this.maHD = maHD;
        this.tenHD = tenHD;
        this.tenNguoiDangKy = tenNguoiDangKy;
        this.email = email;
        this.diadiemDangKy = diadiemDangKy;
        this.ndhd = ndhd;
        this.trangThai = trangThai;
        this.nguoiKyDuyet = nguoiKyDuyet;
        this.dulieuCCCD = dulieuCCCD;
        this.duLieuChungMinhNhaDat = duLieuChungMinhNhaDat;
        this.duLieuChuKy = duLieuChuKy;
        this.ngayDangKy = ngayDangKy;
        this.sodienthoai = sodienthoai;
        this.cccd = cccd;
        this.loaiNuoc = loaiNuoc;
    }
    
    

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenHD() {
        return tenHD;
    }

    public void setTenHD(String tenHD) {
        this.tenHD = tenHD;
    }

    public String getTenNguoiDangKy() {
        return tenNguoiDangKy;
    }

    public void setTenNguoiDangKy(String tenNguoiDangKy) {
        this.tenNguoiDangKy = tenNguoiDangKy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNdhd() {
        return ndhd;
    }

    public void setNdhd(String ndhd) {
        this.ndhd = ndhd;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getNguoiKyDuyet() {
        return nguoiKyDuyet;
    }

    public void setNguoiKyDuyet(String nguoiKyDuyet) {
        this.nguoiKyDuyet = nguoiKyDuyet;
    }

    public String getDulieuCCCD() {
        return dulieuCCCD;
    }

    public void setDulieuCCCD(String dulieuCCCD) {
        this.dulieuCCCD = dulieuCCCD;
    }

    public String getDuLieuChungMinhNhaDat() {
        return duLieuChungMinhNhaDat;
    }

    public void setDuLieuChungMinhNhaDat(String duLieuChungMinhNhaDat) {
        this.duLieuChungMinhNhaDat = duLieuChungMinhNhaDat;
    }

    public String getDuLieuChuKy() {
        return duLieuChuKy;
    }

    public void setDuLieuChuKy(String duLieuChuKy) {
        this.duLieuChuKy = duLieuChuKy;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public String getDiadiemDangKy() {
        return diadiemDangKy;
    }

    public void setDiadiemDangKy(String diadiemDangKy) {
        this.diadiemDangKy = diadiemDangKy;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getLoaiNuoc() {
        return loaiNuoc;
    }

    public void setLoaiNuoc(String loaiNuoc) {
        this.loaiNuoc = loaiNuoc;
    }
    
    
}
