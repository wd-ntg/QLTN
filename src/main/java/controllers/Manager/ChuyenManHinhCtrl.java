package controllers.Manager;

import controllers.Manager.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Client.DanhMucModel;
import views.main.Manager.LoaiNuocView;
import views.main.Manager.DangNhapView;
import views.main.Manager.NhacNhoTienNuoc;
import views.main.Manager.ProfileQuanLyViewPanel;
import views.main.Manager.QLHopDong;
import views.main.Manager.QuanLiChuHoPanel;
import views.main.Manager.TrangNhanVien;
import views.main.Manager.TrangPhanCong;
import views.main.Manager.TrangTrungGianView;
import views.main.Manager.TrangchuTK;
/*import views.main.client.ClientBill;
import views.main.client.ClientChangePassword;
import views.main.client.ClientChart;
import views.main.client.ClientHome;
import views.main.client.ClientInfo;
import views.main.client.ClientLogin;*/
import views.main.client.DangNhap;

/**
 *
 * @author Phu Bao
 */
public class ChuyenManHinhCtrl {

    private JPanel root;
    private String kindSelected = "";

    List<DanhMucModel> listItem = null;

    public ChuyenManHinhCtrl(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "Home";
        jpnItem.setBackground(new Color(230, 255, 255));
        jlbItem.setBackground(new Color(230, 255, 255));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangchuTK());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucModel> listItem) {
        this.listItem = listItem;
        for (DanhMucModel item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "Trang chu":
                    node = new TrangchuTK();
                    break;
                case "Nhan vien":
                    node = new TrangNhanVien();
                    break;
               case "Thêm loại nước":
                    node = new LoaiNuocView();
                    break;
                case "Quan li chu ho":
                    node = new QuanLiChuHoPanel();
                    break;
                
                case "Phan cong":
                    node = new TrangPhanCong();
                    break;
                case "Ho so quan li":
                    node = new ProfileQuanLyViewPanel();
                    break;
                case "Nhac nuoc":
                    node = new NhacNhoTienNuoc();
                    break;
                case "QL Hop Dong":
                    node = new QLHopDong();
                    break;
                case "QL Diem Thu":
                    node = new TrangTrungGianView();
                    break;
//              case "LogOut":
////                    node = new DangNhap();
//                    break;                 
                default:
                    node = new TrangchuTK();

            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
           kindSelected = kind;
           jpnItem.setBackground(new Color(255, 255, 255));
           jlbItem.setBackground(new Color(255, 255, 255));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(230, 255, 255));
            jlbItem.setBackground(new Color(230, 255, 255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(255, 255, 255));
                jlbItem.setBackground(new Color(255, 255, 255));
            }
        }

    }

    private void setChangeBackground(String kind) {
        for (DanhMucModel item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(230, 255, 255));
                item.getJlb().setBackground(new Color(230, 255, 255));
            } else {
                item.getJpn().setBackground(new Color(255, 255, 255));
                item.getJlb().setBackground(new Color(255, 255, 255));
            }
        }
    }

}