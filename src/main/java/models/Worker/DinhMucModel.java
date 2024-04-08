
package models.Worker;


public class DinhMucModel {
    private String maDinhMuc;
    private String maLoai;
    private int soDau;
    private int soCuoi;
    private double thue;
    private double dongia;

    public DinhMucModel() {
    }

    public DinhMucModel(String maDinhMuc, String maLoai, int soDau, int soCuoi, double thue, double dongia) {
        this.maDinhMuc = maDinhMuc;
        this.maLoai = maLoai;
        this.soDau = soDau;
        this.soCuoi = soCuoi;
        this.thue = thue;
        this.dongia = dongia;
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

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }
    
    
    
}
