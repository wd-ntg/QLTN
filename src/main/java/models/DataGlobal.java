/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class DataGlobal {
    
    private PhanCongModel phanCongModel;
    
    private String linkChuKy;

    public String getLinkChuKy() {
        return linkChuKy;
    }

    public void setLinkChuKy(String linkChuKy) {
        this.linkChuKy = linkChuKy;
    }

    public PhanCongModel getPhanCongModel() {
        return phanCongModel;
    }

    public void setPhanCongModel(PhanCongModel phanCongModel) {
        this.phanCongModel = phanCongModel;
    }
    
    private NhanVienModel currentEditNhanVien;
    
    private ChuHoModel currentEditChuHo;
    
    private QuanLyModel phienQLHienTai;

    public QuanLyModel getPhienQLHienTai() {
        return phienQLHienTai;
    }

    public void setPhienQLHienTai(QuanLyModel phienQLHienTai) {
        this.phienQLHienTai = phienQLHienTai;
    }

    public NhanVienModel getCurrentEditNhanVien() {
        return currentEditNhanVien;
    }

    public void setCurrentEditNhanVien(NhanVienModel currentEditNhanVien) {
        this.currentEditNhanVien = currentEditNhanVien;
    }
    
    
    private String TimeAssign;
    
    private String EmployerNon;
    
    private KhuVucModel khuVucModel;

    public KhuVucModel getKhuVucModel() {
        return khuVucModel;
    }

    public void setKhuVucModel(KhuVucModel khuVucModel) {
        this.khuVucModel = khuVucModel;
    }
    
    public DataGlobal() {
        // Khởi tạo một đối tượng PersonModel trống
        phanCongModel = new PhanCongModel();
        currentEditNhanVien = new NhanVienModel();
        khuVucModel = new KhuVucModel();
        phienQLHienTai = new QuanLyModel();
        TimeAssign = "";
        EmployerNon = "";
        
        currentEditChuHo = new ChuHoModel();
        linkChuKy = "";
    }


    public void setTimeAssign(String TimeAssign) {
        this.TimeAssign = TimeAssign;
    }

    public String getTimeAssign() {
        return TimeAssign;
    }

    public void setEmployerNon(String EmployerNon) {
        this.EmployerNon = EmployerNon;
    }

    public String getEmployerNon() {
        return EmployerNon;
    }
   
    
    
    public class getDataGLobal {
        public static DataGlobal dataGlobal = new DataGlobal();
    }
    
    public ChuHoModel getCurrentEditChuHo() {
        return currentEditChuHo;
    }

    public void setCurrentEditChuHo(ChuHoModel currentEditChuHo) {
        this.currentEditChuHo = currentEditChuHo;
    }
}
