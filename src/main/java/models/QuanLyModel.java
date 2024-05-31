/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class QuanLyModel {
    
    public QuanLyModel(String MAQL, String HOTEN, String SDT, String NGAYSINH, String NGAYLAM, String CCCD, String GIOITINH, String EMAIL) {
        this.MAQL = MAQL;
        this.HOTEN = HOTEN;
        this.SDT = SDT;
        this.NGAYSINH = NGAYSINH;
        this.NGAYLAM = NGAYLAM;
        this.CCCD = CCCD;
        this.GIOITINH = GIOITINH;
        this.EMAIL = EMAIL;
    }
    
    public QuanLyModel(String MAQL, String HOTEN, String SDT, String CCCD, String NGAYLAM, String EMAIL) {
        this.MAQL = MAQL;
        this.HOTEN = HOTEN;
        this.SDT = SDT;
        this.NGAYLAM = NGAYLAM;
        this.CCCD = CCCD;
        this.EMAIL = EMAIL;
    }
    
    public QuanLyModel () {
        
    }

    public String getMAQL() {
        return MAQL;
    }

    public void setMAQL(String MAQL) {
        this.MAQL = MAQL;
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

    public String getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(String NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
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

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
    private String MAQL, HOTEN, SDT, NGAYSINH, NGAYLAM, CCCD, GIOITINH, EMAIL;
}
