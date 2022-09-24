/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Phieuxuat;
import Model.QuanLyKhoModel;
import Model.Ttphieunhap;
import Model.Ttphieuxuat;
import View.XuatHangView;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author H
 */
public class XuatHangController implements Action {

    private XuatHangView view;
    private QuanLyKhoModel model;
    private int slTon;

    public XuatHangController(XuatHangView view) throws ClassNotFoundException, SQLException {
        this.view = view;
        model = new QuanLyKhoModel();
    }

    @Override
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEnabled(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            String cmd = e.getActionCommand();
            int slNhap = 0;
            int slXuat = 0;
            switch (cmd) {
                case "Tạo phiếu":
                    Phieuxuat.InsertDB();
                    view.loadJTablePhieu();
                    break;
                case "Xoá phiếu":
                    if (view.getIndexTblPhieu() < 0) {
                        JOptionPane.showMessageDialog(view, "Bạn chưa chỉ định phiếu xuất để thao tác!!");
                    } else {
                        if (JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn xoá không?") == 0) {
                            Phieuxuat.DeleteDB(view.getTextSelectedIdPhieu());
                            model = new QuanLyKhoModel();
                            for (Ttphieunhap item1 : model.ttphieunhaps) {
                                if (item1.getMaHang().getMaHang().equals(view.getTextCbbHangHoa())) {
                                    slNhap += item1.getSLNhap();
                                }
                            }
                            for (Ttphieuxuat item1 : model.ttphieuxuats) {
                                if (item1.getMaHang().getMaHang().equals(view.getTextCbbHangHoa())) {
                                    slXuat += item1.getSLXuat();
                                }
                            }
                            slTon = slNhap - slXuat;
                            view.setLbTonKho(slTon + "");
                        }
                        view.loadJTablePhieu();
                    }
                    break;
                case "Thêm tt":
                    if (view.getIndexTblPhieu() < 0) {
                        JOptionPane.showMessageDialog(view, "Bạn chưa chỉ định phiếu xuất để thao tác!!");
                    } else {
                        if (Integer.parseInt(view.getTextTfSoLuong()) > slTon) {
                            JOptionPane.showMessageDialog(view, "Số lượng hàng xuất không được lớn hơn hàng trong kho!!");
                        } else {
                            Ttphieuxuat.InsertDB(view.getTextCbbN(), view.getTextCbbHangHoa(), view.getTextTfSoLuong(), view.getTextTfDonGia(), view.getTextSelectedIdPhieu());
                            view.loadJTableTtPhieu(view.getTextSelectedIdPhieu());
                            model = new QuanLyKhoModel();
                            for (Ttphieunhap item1 : model.ttphieunhaps) {
                                if (item1.getMaHang().getMaHang().equals(view.getTextCbbHangHoa())) {
                                    slNhap += item1.getSLNhap();
                                }
                            }
                            for (Ttphieuxuat item1 : model.ttphieuxuats) {
                                if (item1.getMaHang().getMaHang().equals(view.getTextCbbHangHoa())) {
                                    slXuat += item1.getSLXuat();
                                }
                            }
                            slTon = slNhap - slXuat;
                            view.setLbTonKho(slTon + "");
                            JOptionPane.showMessageDialog(view, "Thêm thành công");
                        }
                    }
                    break;
                case "Sửa tt":
                    if (view.getIndexTblPhieu() < 0) {
                        JOptionPane.showMessageDialog(view, "Bạn chưa chỉ định phiếu xuất để thao tác!!");
                    } else if (view.getIndexTblTtPhieu() < 0) {
                        JOptionPane.showMessageDialog(view, "Bạn chưa chỉ định thông tin phiếu để thao tác!!");
                    } else {
                        Ttphieuxuat.UpdateDB(view.getTextSelectedIdTtPhieu(), view.getTextCbbN(), view.getTextCbbHangHoa(), view.getTextTfSoLuong(), view.getTextTfDonGia(), view.getTextSelectedIdPhieu());
                        model = new QuanLyKhoModel();
                        for (Ttphieunhap item1 : model.ttphieunhaps) {
                            if (item1.getMaHang().getMaHang().equals(view.getTextCbbHangHoa())) {
                                slNhap += item1.getSLNhap();
                            }
                        }
                        for (Ttphieuxuat item1 : model.ttphieuxuats) {
                            if (item1.getMaHang().getMaHang().equals(view.getTextCbbHangHoa())) {
                                slXuat += item1.getSLXuat();
                            }
                        }
                        slTon = slNhap - slXuat;
                        view.setLbTonKho(slTon + "");
                        JOptionPane.showMessageDialog(view, "Sửa thành công");
                        view.loadJTableTtPhieu(view.getTextSelectedIdPhieu());
                    }
                    break;
                case "Xoá tt":
                    if (view.getIndexTblPhieu() < 0) {
                        JOptionPane.showMessageDialog(view, "Bạn chưa chỉ định phiếu xuất để thao tác!!");
                    } else if (view.getIndexTblTtPhieu() < 0) {
                        JOptionPane.showMessageDialog(view, "Bạn chưa chỉ định thông tin phiếu để thao tác!!");
                    } else {
                        if (JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn xoá không?") == 0) {
                            Ttphieuxuat.DeleteDB(view.getTextSelectedIdTtPhieu());
                            model = new QuanLyKhoModel();
                            for (Ttphieunhap item1 : model.ttphieunhaps) {
                                if (item1.getMaHang().getMaHang().equals(view.getTextCbbHangHoa())) {
                                    slNhap += item1.getSLNhap();
                                }
                            }
                            for (Ttphieuxuat item1 : model.ttphieuxuats) {
                                if (item1.getMaHang().getMaHang().equals(view.getTextCbbHangHoa())) {
                                    slXuat += item1.getSLXuat();
                                }
                            }
                            slTon = slNhap - slXuat;
                            view.setLbTonKho(slTon + "");
                            JOptionPane.showMessageDialog(view, "Xoá thành công");
                        }
                        view.loadJTableTtPhieu(view.getTextSelectedIdPhieu());
                    }
                    break;
                case "Tìm":
                    ArrayList<Ttphieuxuat> res = Ttphieuxuat.FindByID(view.getTextCbbKhoTimKiem());
                    if (res.size() <= 0) {
                        JOptionPane.showMessageDialog(view, "Không có giữ liệu!");
                    } else {
                        view.setJTableTtPhieu(res);
                    }
                    break;
                case "Làm mới":
                    view.clear();
                    break;
                case "comboBoxChanged":
                    for (Ttphieunhap item1 : model.ttphieunhaps) {
                        if (item1.getMaHang().getMaHang().equals(view.getTextCbbHangHoa())) {
                            slNhap += item1.getSLNhap();
                        }
                    }
                    for (Ttphieuxuat item1 : model.ttphieuxuats) {
                        if (item1.getMaHang().getMaHang().equals(view.getTextCbbHangHoa())) {
                            slXuat += item1.getSLXuat();
                        }
                    }
                    slTon = slNhap - slXuat;
//                    String res=slTon+"";
                    view.setLbTonKho(slTon + "");
                default:
                    break;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NguoiDungController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Thao tác không hợp lệ bởi một trong lý do sau: \n - Trường dữ liệu trống\n - Dữ liệu bị trùng\n - Dữ liệu đang được sử dụng");
        }
    }

}
