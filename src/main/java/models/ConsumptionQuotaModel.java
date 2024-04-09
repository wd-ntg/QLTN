package models;

/**
 *
 * @author Phu Bao
 */
public class ConsumptionQuotaModel {
    private String maDinhMuc, maLoai, tenLoai;
    private int soDau, soCuoi, donGia;
    private double thue;

    public ConsumptionQuotaModel() {
    }

    public ConsumptionQuotaModel(String maDinhMuc, int soCuoi, double thue, int donGia) {
        this.maDinhMuc = maDinhMuc;
        this.soCuoi = soCuoi;
        this.thue = thue;
        this.donGia = donGia;
    }

    public ConsumptionQuotaModel(String maLoai, String tenLoai, int soDau, int soCuoi, double thue, int donGia) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.soDau = soDau;
        this.soCuoi = soCuoi;
        this.thue = thue;
        this.donGia = donGia;
    }
    
    public ConsumptionQuotaModel(String maDinhMuc, String maLoai, String tenLoai, int soDau, int soCuoi, double thue, int donGia) {
        this.maDinhMuc = maDinhMuc;
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.soDau = soDau;
        this.soCuoi = soCuoi;
        this.thue = thue;
        this.donGia = donGia;
    }

    public String getMaDinhMuc() {
        return maDinhMuc;
    }

    public void setMaDinhMuc(String maDinhMuc) {
        this.maDinhMuc = maDinhMuc;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public int getSoDau() {
        return soDau;
    }

    public void setSoDau(int soDau) {
        this.soDau = soDau;
    }

    public int getSoCuoi() {
        return soCuoi;
    }

    public void setSoCuoi(int soCuoi) {
        this.soCuoi = soCuoi;
    }

    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    
}
