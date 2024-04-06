/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class TaiKhoanModel {

    public TaiKhoanModel(String MATK, String EMAIL, String MATKHAU, String MAPQ) {
        this.MATK = MATK;
        this.EMAIL = EMAIL;
        this.MATKHAU = MATKHAU;
        this.MAPQ = MAPQ;
    }
    
    public TaiKhoanModel() {
        
    }
    
    public String getMATK() {
        return MATK;
    }

    public void setMATK(String MATK) {
        this.MATK = MATK;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public String getMAPQ() {
        return MAPQ;
    }

    public void setMAPQ(String MAPQ) {
        this.MAPQ = MAPQ;
    }
    private String MATK, EMAIL, MATKHAU, MAPQ;
    
}
