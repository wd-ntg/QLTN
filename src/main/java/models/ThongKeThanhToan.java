/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class ThongKeThanhToan {

    public ThongKeThanhToan(Integer tienDaThanhToan, Integer tienChuaThanhToan, String kiThanhToan) {
        this.tienDaThanhToan = tienDaThanhToan;
        this.tienChuaThanhToan = tienChuaThanhToan;
        this.kiThanhToan = kiThanhToan;
    }

    public ThongKeThanhToan() {

    }

    public Integer getTienDaThanhToan() {
        return tienDaThanhToan;
    }

    public void setTienDaThanhToan(Integer tienDaThanhToan) {
        this.tienDaThanhToan = tienDaThanhToan;
    }

    public Integer getTienChuaThanhToan() {
        return tienChuaThanhToan;
    }

    public void setTienChuaThanhToan(Integer tienChuaThanhToan) {
        this.tienChuaThanhToan = tienChuaThanhToan;
    }
    private Integer tienDaThanhToan, tienChuaThanhToan;
    private String kiThanhToan;

    public String getKiThanhToan() {
        return kiThanhToan;
    }

    public void setKiThanhToan(String kiThanhToan) {
        this.kiThanhToan = kiThanhToan;
    }

}
