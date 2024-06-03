
package models.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import views.main.Manager.ManagerMain;


public class GlobalData {
    private static GlobalData instance;
    private int status = 0;
    private ManagerMain managerMain = new ManagerMain();
    private NhanVienModel nhanVienModel = new NhanVienModel();
    private List<ChuHoModel> lsChuHoInfor = new ArrayList<>();
    private List<HoaDonModel> lsBill = new ArrayList<>();
    private List<GhiNuocModel> lsGhiNuoc = new ArrayList<>();
    private String branch = "";
    Stack<String> stackPosition = new Stack<>();

    public String getStack() {
        return stackPosition.pop();
    }

    public void setStack(String stack) {
        this.stackPosition.push(stack);
    }
    
    public void clearStack(){
        this.stackPosition.clear();
    }
    
    public int getLengthStack(){
        return this.stackPosition.size();
    }

    public List<HoaDonModel> getLsBill() {
        return lsBill;
    }

    public void setLsBill(List<HoaDonModel> lsBill) {
        this.lsBill = lsBill;
    }

    public List<GhiNuocModel> getLsGhiNuoc() {
        return lsGhiNuoc;
    }

    public void setLsGhiNuoc(List<GhiNuocModel> lsGhiNuoc) {
        this.lsGhiNuoc = lsGhiNuoc;
    }

    
    
    private GlobalData() {
        // Khởi tạo global data ở đây
        lsChuHoInfor = new ArrayList<>();
    }

    public static synchronized GlobalData getInstance() {
        if (instance == null) {
            instance = new GlobalData();
        }
        return instance;
    }

    public NhanVienModel getNhanVienModel() {
        return nhanVienModel;
    }

    public void setNhanVienModel(NhanVienModel nhanVienModel) {
        this.nhanVienModel = nhanVienModel;
    }

    

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    public void clearData(){
        nhanVienModel = null;
        branch = null;
    }

    public List<ChuHoModel> getLsChuHoInfor() {
        return lsChuHoInfor;
    }

    public void setLsChuHoInfor(List<ChuHoModel> lsChuHoInfor) {
        this.lsChuHoInfor = lsChuHoInfor;
    }

    public ManagerMain getManagerMain() {
        return managerMain;
    }

    public void setManagerMain(ManagerMain managerMain) {
        this.managerMain = managerMain;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
   
    
}
