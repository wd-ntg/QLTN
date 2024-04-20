/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author hoang
 */
public class ChuHoModel {
    private String MACH;
    private String HOTEN;
    private String SDT;
    private String CCCD;
    private String DIACHITT;
    private String GIOITINH;
    private String EMAIL;
    
    
    public ChuHoModel(String MACH, String HOTEN, String SDT, String CCCD, String DIACHITT, String GIOITINH) {
        this.MACH = MACH;
        this.HOTEN = HOTEN;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.DIACHITT = DIACHITT;
        this.GIOITINH = GIOITINH;
    }
    
    public ChuHoModel(String HOTEN, String SDT, String CCCD, String DIACHITT, String EMAIL) {
        this.HOTEN = HOTEN;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.DIACHITT = DIACHITT;
        this.EMAIL = EMAIL;
    }
    
    public ChuHoModel(String MACH, String HOTEN, String SDT, String CCCD, String DIACHITT, String GIOITINH, String EMAIL) {
        this.MACH = MACH;
        this.HOTEN = HOTEN;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.DIACHITT = DIACHITT;
        this.GIOITINH = GIOITINH;
        this.EMAIL = EMAIL;
    }
    
    public ChuHoModel() {
        
    }

    public String getMACH() {
        return MACH;
    }

    public void setMACH(String MACH) {
        this.MACH = MACH;
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

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getDIACHITT() {
        return DIACHITT;
    }

    public void setDIACHITT(String DIACHITT) {
        this.DIACHITT = DIACHITT;
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
    
}
