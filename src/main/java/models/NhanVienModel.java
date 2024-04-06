/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class NhanVienModel {

    public NhanVienModel(String MANV, String HOTEN, String SDT, String CCCD, String EMAIL) {
        this.MANV = MANV;
        this.HOTEN = HOTEN;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.EMAIL = EMAIL;
    }

    public NhanVienModel(String HOTEN, String SDT, String CCCD, String GIOITINH, String MAKHUVUC, String CHUCVU) {
        this.HOTEN = HOTEN;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.GIOITINH = GIOITINH;
        this.MAKHUVUC = MAKHUVUC;
        this.CHUCVU = CHUCVU;
    }

    public NhanVienModel(String MANV, String HOTEN, String SDT, String NGAYLAM, String CCCD, String GIOITINH, String MAKHUVUC, String CHUCVU, String EMAIL, String KHUVUCLAMVIEC) {
        this.MANV = MANV;
        this.HOTEN = HOTEN;
        this.SDT = SDT;
        this.NGAYLAM = NGAYLAM;
        this.CCCD = CCCD;
        this.GIOITINH = GIOITINH;
        this.MAKHUVUC = MAKHUVUC;
        this.CHUCVU = CHUCVU;
        this.EMAIL = EMAIL;
        this.KHUVUCLAMVIEC = KHUVUCLAMVIEC;
    }

    public NhanVienModel(String MANV, String HOTEN, String SDT, String NGAYLAM, String CCCD, String GIOITINH, String MAKHUVUC, String CHUCVU, String EMAIL) {
        this.MANV = MANV;
        this.HOTEN = HOTEN;
        this.SDT = SDT;
        this.NGAYLAM = NGAYLAM;
        this.CCCD = CCCD;
        this.GIOITINH = GIOITINH;
        this.MAKHUVUC = MAKHUVUC;
        this.CHUCVU = CHUCVU;
        this.EMAIL = EMAIL;
    }

    public NhanVienModel(String MANV, String HOTEN, String SDT, String NGAYLAM, String CCCD, String GIOITINH, String MAKHUVUC) {
        this.MANV = MANV;
        this.HOTEN = HOTEN;
        this.SDT = SDT;
        this.NGAYLAM = NGAYLAM;
        this.CCCD = CCCD;
        this.GIOITINH = GIOITINH;
        this.MAKHUVUC = MAKHUVUC;
    }

    public NhanVienModel() {

    }
    private String MANV, HOTEN, SDT, NGAYLAM, CCCD, GIOITINH, MAKHUVUC, CHUCVU, EMAIL, KHUVUCLAMVIEC;

    public String getKHUVUCLAMVIEC() {
        return KHUVUCLAMVIEC;
    }

    public void setKHUVUCLAMVIEC(String KHUVUCLAMVIEC) {
        this.KHUVUCLAMVIEC = KHUVUCLAMVIEC;
    }

    public String getCHUCVU() {
        return CHUCVU;
    }

    public void setCHUCVU(String CHUCVU) {
        this.CHUCVU = CHUCVU;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getMAKHUVUC() {
        return MAKHUVUC;
    }

    public void setMAKHUVUC(String MAKHUVUC) {
        this.MAKHUVUC = MAKHUVUC;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getNGAYLAM() {
        return NGAYLAM;
    }

    public void setNGAYLAM(String NGAYLAM) {
        this.NGAYLAM = NGAYLAM;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

}
