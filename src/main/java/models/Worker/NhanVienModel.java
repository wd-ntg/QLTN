
package models.Worker;


public class NhanVienModel {
    private String maNV = "";
    private String hoTen = "";
    private String sdt= "";
    private String cccd = "";
    private String gioiTinh = "";
    private String maKV = "";

    private String email = "";
    private String password = "";
    
    public NhanVienModel() {
    }

    public NhanVienModel(String maNV, String hoTen, String sdt, String cccd, String gioiTinh, String maKV) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.cccd = cccd;
        this.gioiTinh = gioiTinh;
        this.maKV = maKV;
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public String getMaKV() {
        return maKV;
    }

    public void setMaKV(String maKV) {
        this.maKV = maKV;
    }

    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }


    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
