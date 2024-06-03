/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class TrungGianModel {

    public TrungGianModel(String MATG, String TENTG, String MACTVK) {
        this.MATG = MATG;
        this.TENTG = TENTG;
        this.MACTVK = MACTVK;
    }
    
    public TrungGianModel () {
        
    }

    public TrungGianModel(String MATG, String TENTG, String MACTVK, String MAKHUVUC, String TENCHITIET, String EMAIL, String MAPQ, String TGDANGKY) {
        this.MATG = MATG;
        this.TENTG = TENTG;
        this.MACTVK = MACTVK;
        this.MAKHUVUC = MAKHUVUC;
        this.TENCHITIET = TENCHITIET;
        this.EMAIL = EMAIL;
        this.MAPQ = MAPQ;
        this.TGDANGKY = TGDANGKY;
    }

    public String getMATG() {
        return MATG;
    }

    public void setMATG(String MATG) {
        this.MATG = MATG;
    }

    public String getTENTG() {
        return TENTG;
    }

    public void setTENTG(String TENTG) {
        this.TENTG = TENTG;
    }

    public String getMACTVK() {
        return MACTVK;
    }

    public void setMACTVK(String MACTVK) {
        this.MACTVK = MACTVK;
    }

    public String getMAKHUVUC() {
        return MAKHUVUC;
    }

    public void setMAKHUVUC(String MAKHUVUC) {
        this.MAKHUVUC = MAKHUVUC;
    }

    public String getTENCHITIET() {
        return TENCHITIET;
    }

    public void setTENCHITIET(String TENCHITIET) {
        this.TENCHITIET = TENCHITIET;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getMAPQ() {
        return MAPQ;
    }

    public void setMAPQ(String MAPQ) {
        this.MAPQ = MAPQ;
    }

    public String getTGDANGKY() {
        return TGDANGKY;
    }

    public void setTGDANGKY(String TGDANGKY) {
        this.TGDANGKY = TGDANGKY;
    }
    private String MATG, TENTG, MACTVK, MAKHUVUC, TENCHITIET, EMAIL, MAPQ, TGDANGKY;
    
}
