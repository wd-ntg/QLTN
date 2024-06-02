/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class HopDongModel {

    public HopDongModel(String MAHD, String TENHD, String TENNGUOIDANGKY, String DIACHIEMAIL, String DIADIEMDANGKY, String DULIEUCCCD, String DULIEUCHUNGMINHNHADAT, String DULIEUCHUKY, String TRANGTHAI, String SODIENTHOAI, String CCCD, String LOAINUOC) {
        this.MAHD = MAHD;
        this.TENHD = TENHD;
        this.TENNGUOIDANGKY = TENNGUOIDANGKY;
        this.DIACHIEMAIL = DIACHIEMAIL;
        this.DIADIEMDANGKY = DIADIEMDANGKY;
        this.DULIEUCCCD = DULIEUCCCD;
        this.DULIEUCHUNGMINHNHADAT = DULIEUCHUNGMINHNHADAT;
        this.DULIEUCHUKY = DULIEUCHUKY;
        this.TRANGTHAI = TRANGTHAI;
        this.SODIENTHOAI = SODIENTHOAI;
        this.CCCD = CCCD;
        this.LOAINUOC = LOAINUOC;
    }

    public String getNGAYDANGKY() {
        return NGAYDANGKY;
    }

    public void setNGAYDANGKY(String NGAYDANGKY) {
        this.NGAYDANGKY = NGAYDANGKY;
    }

    public HopDongModel(String MAHD, String TENHD, String TENNGUOIDANGKY, String DIACHIEMAIL, String DIADIEMDANGKY, String NDHD, String NGUOIKYDUYET, String DULIEUCCCD, String DULIEUCHUNGMINHNHADAT, String DULIEUCHUKY, String TRANGTHAI, String NGAYDANGKY, String SODIENTHOAI, String CCCD, String LOAINUOC) {
        this.MAHD = MAHD;
        this.TENHD = TENHD;
        this.TENNGUOIDANGKY = TENNGUOIDANGKY;
        this.DIACHIEMAIL = DIACHIEMAIL;
        this.DIADIEMDANGKY = DIADIEMDANGKY;
        this.NDHD = NDHD;
        this.NGUOIKYDUYET = NGUOIKYDUYET;
        this.DULIEUCCCD = DULIEUCCCD;
        this.DULIEUCHUNGMINHNHADAT = DULIEUCHUNGMINHNHADAT;
        this.DULIEUCHUKY = DULIEUCHUKY;
        this.TRANGTHAI = TRANGTHAI;
        this.NGAYDANGKY = NGAYDANGKY;
        this.SODIENTHOAI = SODIENTHOAI;
        this.CCCD = CCCD;
         this.LOAINUOC = LOAINUOC;
    }
    
    public HopDongModel () {
        
    }

    public String getMAHD() {
        return MAHD;
    }

    public void setMAHD(String MAHD) {
        this.MAHD = MAHD;
    }

    public String getTENHD() {
        return TENHD;
    }

    public void setTENHD(String TENHD) {
        this.TENHD = TENHD;
    }

    public String getTENNGUOIDANGKY() {
        return TENNGUOIDANGKY;
    }

    public void setTENNGUOIDANGKY(String TENNGUOIDANGKY) {
        this.TENNGUOIDANGKY = TENNGUOIDANGKY;
    }

    public String getDIACHIEMAIL() {
        return DIACHIEMAIL;
    }

    public void setDIACHIEMAIL(String DIACHIEMAIL) {
        this.DIACHIEMAIL = DIACHIEMAIL;
    }

    public String getDIADIEMDANGKY() {
        return DIADIEMDANGKY;
    }

    public void setDIADIEMDANGKY(String DIADIEMDANGKY) {
        this.DIADIEMDANGKY = DIADIEMDANGKY;
    }

    public String getNDHD() {
        return NDHD;
    }

    public void setNDHD(String NDHD) {
        this.NDHD = NDHD;
    }

    public String getNGUOIKYDUYET() {
        return NGUOIKYDUYET;
    }

    public void setNGUOIKYDUYET(String NGUOIKYDUYET) {
        this.NGUOIKYDUYET = NGUOIKYDUYET;
    }

    public String getDULIEUCCCD() {
        return DULIEUCCCD;
    }

    public void setDULIEUCCCD(String DULIEUCCCD) {
        this.DULIEUCCCD = DULIEUCCCD;
    }

    public String getDULIEUCHUNGMINHNHADAT() {
        return DULIEUCHUNGMINHNHADAT;
    }

    public void setDULIEUCHUNGMINHNHADAT(String DULIEUCHUNGMINHNHADAT) {
        this.DULIEUCHUNGMINHNHADAT = DULIEUCHUNGMINHNHADAT;
    }

    public String getDULIEUCHUKY() {
        return DULIEUCHUKY;
    }

    public void setDULIEUCHUKY(String DULIEUCHUKY) {
        this.DULIEUCHUKY = DULIEUCHUKY;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }
    private String MAHD, TENHD, TENNGUOIDANGKY, DIACHIEMAIL, DIADIEMDANGKY, NDHD, NGUOIKYDUYET, DULIEUCCCD, DULIEUCHUNGMINHNHADAT, DULIEUCHUKY, NGAYDANGKY;
    private String TRANGTHAI, SODIENTHOAI , CCCD, LOAINUOC;

    public String getLOAINUOC() {
        return LOAINUOC;
    }

    public void setLOAINUOC(String LOAINUOC) {
        this.LOAINUOC = LOAINUOC;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSODIENTHOAI() {
        return SODIENTHOAI;
    }

    public void setSODIENTHOAI(String SODIENTHOAI) {
        this.SODIENTHOAI = SODIENTHOAI;
    }
    
}
