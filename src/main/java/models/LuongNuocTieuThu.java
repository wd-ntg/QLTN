/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class LuongNuocTieuThu {

    public LuongNuocTieuThu(Integer tieuThuNuoc, String kiNuocTieuThu) {
        this.tieuThuNuoc = tieuThuNuoc;
        this.kiNuocTieuThu = kiNuocTieuThu;
    }
    
    public LuongNuocTieuThu () {
        
    }

    public Integer getTieuThuNuoc() {
        return tieuThuNuoc;
    }

    public void setTieuThuNuoc(Integer tieuThuNuoc) {
        this.tieuThuNuoc = tieuThuNuoc;
    }

    public String getKiNuocTieuThu() {
        return kiNuocTieuThu;
    }

    public void setKiNuocTieuThu(String kiNuocTieuThu) {
        this.kiNuocTieuThu = kiNuocTieuThu;
    }
    private Integer tieuThuNuoc;
    private String kiNuocTieuThu;
}
