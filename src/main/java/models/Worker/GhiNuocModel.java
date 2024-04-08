
package models.Worker;


public class GhiNuocModel {
    private String maGhi = "";
    private String maDH = "";
    private int CSC = 0;
    private int CSM = 0;
    private String maNV = "";
    private String ngayGhi = "";
    private String ki = "";
    private String ngayBatDauGhi = "";
    private String ngayHanGhi = "";

    public GhiNuocModel() {
    }

    public GhiNuocModel(String maGhi, String maDH, int CSC, int CSM, String maNV, String ngayGhi, String ki, String ngayBatDauGhi, String ngayHanGhi) {
        this.maGhi = maGhi;
        this.maDH = maDH;
        this.CSC = CSC;
        this.CSM = CSM;
        this.maNV = maNV;
        this.ngayGhi = ngayGhi;
        this.ki = ki;
        this.ngayBatDauGhi = ngayBatDauGhi;
        this.ngayHanGhi = ngayHanGhi;
    }

    public String getMaGhi() {
        return maGhi;
    }

    public void setMaGhi(String maGhi) {
        this.maGhi = maGhi;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public int getCSC() {
        return CSC;
    }

    public void setCSC(int CSC) {
        this.CSC = CSC;
    }

    public int getCSM() {
        return CSM;
    }

    public void setCSM(int CSM) {
        this.CSM = CSM;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayGhi() {
        return ngayGhi;
    }

    public void setNgayGhi(String ngayGhi) {
        this.ngayGhi = ngayGhi;
    }

    public String getKi() {
        return ki;
    }

    public void setKi(String ki) {
        this.ki = ki;
    }

    public String getNgayBatDauGhi() {
        return ngayBatDauGhi;
    }

    public void setNgayBatDauGhi(String ngayBatDauGhi) {
        this.ngayBatDauGhi = ngayBatDauGhi;
    }

    public String getNgayHanGhi() {
        return ngayHanGhi;
    }

    public void setNgayHanGhi(String ngayHanGhi) {
        this.ngayHanGhi = ngayHanGhi;
    }
    
    
}
