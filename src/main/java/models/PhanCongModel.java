/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class PhanCongModel {

    public PhanCongModel(String MANV, String HOTENNV, String SDTNV, String EMAILNV, String MACH, String HOTENCH, String SDTCH, String CCCDCH, String EMAILCH, String TENKHUVUC, String MADIACHI, String TENDIACHI, String MALOAINUOC, String TENLOAINUOC) {
        this.MANV = MANV;
        this.HOTENNV = HOTENNV;
        this.SDTNV = SDTNV;
        this.EMAILNV = EMAILNV;
        this.MACH = MACH;
        this.HOTENCH = HOTENCH;
        this.SDTCH = SDTCH;
        this.CCCDCH = CCCDCH;
        this.EMAILCH = EMAILCH;
        this.TENKHUVUC = TENKHUVUC;
        this.MADIACHI = MADIACHI;
        this.TENDIACHI = TENDIACHI;
        this.MALOAINUOC = MALOAINUOC;
        this.TENLOAINUOC = TENLOAINUOC;
    }

    public PhanCongModel(String MAPC, String MAQL, String HOTENQL, String MANV, String HOTENNV, String MACH, String HOTENCH, String TENDIACHI, String TENLOAINUOC) {
        this.MAPC = MAPC;
        this.MAQL = MAQL;
        this.HOTENQL = HOTENQL;
        this.MANV = MANV;
        this.HOTENNV = HOTENNV;
        this.MACH = MACH;
        this.HOTENCH = HOTENCH;
        this.TENDIACHI = TENDIACHI;
        this.TENLOAINUOC = TENLOAINUOC;
    }

    public PhanCongModel(String MAPC, String MAQL, String HOTENQL, String MANV, String NGAYPHAN, String HOTENNV, String SDTNV, String MACH, String HOTENCH, String SDTCH, String TENDIACHI, String TENLOAINUOC) {
        this.MAPC = MAPC;
        this.MAQL = MAQL;
        this.HOTENQL = HOTENQL;
        this.MANV = MANV;
        this.NGAYPHAN = NGAYPHAN;
        this.HOTENNV = HOTENNV;
        this.SDTNV = SDTNV;
        this.MACH = MACH;
        this.HOTENCH = HOTENCH;
        this.SDTCH = SDTCH;
        this.TENDIACHI = TENDIACHI;
        this.TENLOAINUOC = TENLOAINUOC;
    }

    public PhanCongModel(String MAPC, String MAQL, String MANV, String MAKHUVUC, String NGAYPHAN, String HOTENNV, String SDTNV, String CCCDNV, String HOTENCH, String SDTCH, String CCCDCH, String TENKHUVUC, String MADIACHI, String TENDIACHI, String MALOAINUOC, String TENLOAINUOC) {
        this.MAPC = MAPC;
        this.MAQL = MAQL;
        this.MANV = MANV;
        this.MAKHUVUC = MAKHUVUC;
        this.NGAYPHAN = NGAYPHAN;
        this.HOTENNV = HOTENNV;
        this.SDTNV = SDTNV;
        this.CCCDNV = CCCDNV;
        this.HOTENCH = HOTENCH;
        this.SDTCH = SDTCH;
        this.CCCDCH = CCCDCH;
        this.TENKHUVUC = TENKHUVUC;
        this.MADIACHI = MADIACHI;
        this.TENDIACHI = TENDIACHI;
        this.MALOAINUOC = MALOAINUOC;
        this.TENLOAINUOC = TENLOAINUOC;
    }
    
    public PhanCongModel () {
        
    }

    public String getMAPC() {
        return MAPC;
    }

    public void setMAPC(String MAPC) {
        this.MAPC = MAPC;
    }

    public String getMAQL() {
        return MAQL;
    }

    public void setMAQL(String MAQL) {
        this.MAQL = MAQL;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getMAKHUVUC() {
        return MAKHUVUC;
    }

    public void setMAKHUVUC(String MAKHUVUC) {
        this.MAKHUVUC = MAKHUVUC;
    }

    public String getNGAYPHAN() {
        return NGAYPHAN;
    }

    public void setNGAYPHAN(String NGAYPHAN) {
        this.NGAYPHAN = NGAYPHAN;
    }

    public String getHOTENNV() {
        return HOTENNV;
    }

    public void setHOTENNV(String HOTENNV) {
        this.HOTENNV = HOTENNV;
    }

    public String getSDTNV() {
        return SDTNV;
    }

    public void setSDTNV(String SDTNV) {
        this.SDTNV = SDTNV;
    }

    public String getCCCDNV() {
        return CCCDNV;
    }

    public void setCCCDNV(String CCCDNV) {
        this.CCCDNV = CCCDNV;
    }

    public String getHOTENCH() {
        return HOTENCH;
    }

    public void setHOTENCH(String HOTENCH) {
        this.HOTENCH = HOTENCH;
    }

    public String getSDTCH() {
        return SDTCH;
    }

    public void setSDTCH(String SDTCH) {
        this.SDTCH = SDTCH;
    }

    public String getCCCDCH() {
        return CCCDCH;
    }

    public void setCCCDCH(String CCCDCH) {
        this.CCCDCH = CCCDCH;
    }

    public String getTENKHUVUC() {
        return TENKHUVUC;
    }

    public void setTENKHUVUC(String TENKHUVUC) {
        this.TENKHUVUC = TENKHUVUC;
    }

    public String getMADIACHI() {
        return MADIACHI;
    }

    public void setMADIACHI(String MADIACHI) {
        this.MADIACHI = MADIACHI;
    }

    public String getTENDIACHI() {
        return TENDIACHI;
    }

    public void setTENDIACHI(String TENDIACHI) {
        this.TENDIACHI = TENDIACHI;
    }

    public String getMALOAINUOC() {
        return MALOAINUOC;
    }

    public void setMALOAINUOC(String MALOAINUOC) {
        this.MALOAINUOC = MALOAINUOC;
    }

    public String getTENLOAINUOC() {
        return TENLOAINUOC;
    }

    public void setTENLOAINUOC(String TENLOAINUOC) {
        this.TENLOAINUOC = TENLOAINUOC;
    }
    private String MAPC, MAQL, HOTENQL, MANV, MAKHUVUC, NGAYPHAN, HOTENNV, SDTNV, EMAILNV, CCCDNV,MACH, HOTENCH, SDTCH, CCCDCH, EMAILCH, TENKHUVUC, MADIACHI, TENDIACHI, MALOAINUOC, TENLOAINUOC;

    public String getEMAILNV() {
        return EMAILNV;
    }

    public void setEMAILNV(String EMAILNV) {
        this.EMAILNV = EMAILNV;
    }

    public String getEMAILCH() {
        return EMAILCH;
    }

    public void setEMAILCH(String EMAILCH) {
        this.EMAILCH = EMAILCH;
    }

    public String getMACH() {
        return MACH;
    }

    public void setMACH(String MACH) {
        this.MACH = MACH;
    }

    public String getHOTENQL() {
        return HOTENQL;
    }

    public void setHOTENQL(String HOTENQL) {
        this.HOTENQL = HOTENQL;
    }
}
