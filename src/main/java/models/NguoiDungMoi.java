/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class NguoiDungMoi {

    public NguoiDungMoi(String maND, String tenND, String dcND, String loaiNuocSD) {
        this.maND = maND;
        this.tenND = tenND;
        this.dcND = dcND;
        this.loaiNuocSD = loaiNuocSD;
    }
    
    public NguoiDungMoi () {
        
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getTenND() {
        return tenND;
    }

    public void setTenND(String tenND) {
        this.tenND = tenND;
    }

    public String getDcND() {
        return dcND;
    }

    public void setDcND(String dcND) {
        this.dcND = dcND;
    }

    public String getLoaiNuocSD() {
        return loaiNuocSD;
    }

    public void setLoaiNuocSD(String loaiNuocSD) {
        this.loaiNuocSD = loaiNuocSD;
    }
      private String maND, tenND, dcND, loaiNuocSD;
}
