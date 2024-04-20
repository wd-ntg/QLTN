package models.Client;

public class ThongKeModel {
    private String ki;
    private int soNuocTieuThu, soTienPhaiTra;

    public ThongKeModel() {
    }

    public ThongKeModel(String ki, int soNuocTieuThu, int soTienPhaiTra) {
        this.ki = ki;
        this.soNuocTieuThu = soNuocTieuThu;
        this.soTienPhaiTra = soTienPhaiTra;
    }

    public String getKi() {
        return ki;
    }

    public void setKi(String ki) {
        this.ki = ki;
    }

    public int getSoNuocTieuThu() {
        return soNuocTieuThu;
    }

    public void setSoNuocTieuThu(int soNuocTieuThu) {
        this.soNuocTieuThu = soNuocTieuThu;
    }

    public int getSoTienPhaiTra() {
        return soTienPhaiTra;
    }

    public void setSoTienPhaiTra(int soTienPhaiTra) {
        this.soTienPhaiTra = soTienPhaiTra;
    }
  
}
