/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class KhuVucModel {

    public KhuVucModel(String MAKHUVUC, String TENKHUVUC) {
        this.MAKHUVUC = MAKHUVUC;
        this.TENKHUVUC = TENKHUVUC;
    }
    
    public KhuVucModel() {
        
    }

    public String getMAKHUVUC() {
        return MAKHUVUC;
    }

    public void setMAKHUVUC(String MAKHUVUC) {
        this.MAKHUVUC = MAKHUVUC;
    }

    public String getTENKHUVUC() {
        return TENKHUVUC;
    }

    public void setTENKHUVUC(String TENKHUVUC) {
        this.TENKHUVUC = TENKHUVUC;
    }
    private String MAKHUVUC, TENKHUVUC;
    
}
