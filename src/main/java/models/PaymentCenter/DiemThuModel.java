package models.PaymentCenter;

/**
 *
 * @author Phu Bao
 */
public class DiemThuModel {
    private String maTG, tenTG, maCTKV, tenCTKV, maKV, tenKV, email;

    public DiemThuModel() {
    }

    public DiemThuModel(String maTG, String tenTG, String maCTKV, String tenCTKV, String maKV, String tenKV, String email) {
        this.maTG = maTG;
        this.tenTG = tenTG;
        this.maCTKV = maCTKV;
        this.tenCTKV = tenCTKV;
        this.maKV = maKV;
        this.tenKV = tenKV;
        this.email = email;
    }

    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getMaCTKV() {
        return maCTKV;
    }

    public void setMaCTKV(String maCTKV) {
        this.maCTKV = maCTKV;
    }

    public String getTenCTKV() {
        return tenCTKV;
    }

    public void setTenCTKV(String tenCTKV) {
        this.tenCTKV = tenCTKV;
    }

    public String getMaKV() {
        return maKV;
    }

    public void setMaKV(String maKV) {
        this.maKV = maKV;
    }

    public String getTenKV() {
        return tenKV;
    }

    public void setTenKV(String tenKV) {
        this.tenKV = tenKV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
