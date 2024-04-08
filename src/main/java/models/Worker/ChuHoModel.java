
package models.Worker;


public class ChuHoModel {
    private String maCH;
    private String hoTen;
    private String sdt;
    private String cccd ;
    private String diaChiTT;
    private String gioiTinh;
    
    private String loaiNuoc;
    private String diaChiDatNuoc;
    private String maDH;

    public ChuHoModel() {
    }

    public ChuHoModel(String maCH, String hoTen, String sdt, String cccd, String diaChiTT, String gioiTinh) {
        this.maCH = maCH;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.cccd = cccd;
        this.diaChiTT = diaChiTT;
        this.gioiTinh = gioiTinh;
    }

    public String getLoaiNuoc() {
        return loaiNuoc;
    }

    public void setLoaiNuoc(String loaiNuoc) {
        this.loaiNuoc = loaiNuoc;
    }

    public String getDiaChiDatNuoc() {
        return diaChiDatNuoc;
    }

    public void setDiaChiDatNuoc(String diaChiDatNuoc) {
        this.diaChiDatNuoc = diaChiDatNuoc;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    
    
    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiaChiTT() {
        return diaChiTT;
    }

    public void setDiaChiTT(String diaChiTT) {
        this.diaChiTT = diaChiTT;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    
}
