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
                case "T???o phi???u":
                    Phieuxuat.InsertDB();
                    view.loadJTablePhieu();
                    break;
                case "Xo?? phi???u":
                    if (view.getIndexTblPhieu() < 0) {
                        JOptionPane.showMessageDialog(view, "B???n ch??a ch??? ?????nh phi???u xu???t ????? thao t??c!!");
                    } else {
                        if (JOptionPane.showConfirmDialog(view, "B???n c?? ch???c mu???n xo?? kh??ng?") == 0) {
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
                case "Th??m tt":
                    if (view.getIndexTblPhieu() < 0) {
                        JOptionPane.showMessageDialog(view, "B???n ch??a ch??? ?????nh phi???u xu???t ????? thao t??c!!");
                    } else {
                        if (Integer.parseInt(view.getTextTfSoLuong()) > slTon) {
                            JOptionPane.showMessageDialog(view, "S??? l?????ng h??ng xu???t kh??ng ???????c l???n h??n h??ng trong kho!!");
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
                            JOptionPane.showMessageDialog(view, "Th??m th??nh c??ng");
                        }
                    }
                    break;
                case "S???a tt":
                    if (view.getIndexTblPhieu() < 0) {
                        JOptionPane.showMessageDialog(view, "B???n ch??a ch??? ?????nh phi???u xu???t ????? thao t??c!!");
                    } else if (view.getIndexTblTtPhieu() < 0) {
                        JOptionPane.showMessageDialog(view, "B???n ch??a ch??? ?????nh th??ng tin phi???u ????? thao t??c!!");
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
                        JOptionPane.showMessageDialog(view, "S???a th??nh c??ng");
                        view.loadJTableTtPhieu(view.getTextSelectedIdPhieu());
                    }
                    break;
                case "Xo?? tt":
                    if (view.getIndexTblPhieu() < 0) {
                        JOptionPane.showMessageDialog(view, "B???n ch??a ch??? ?????nh phi???u xu???t ????? thao t??c!!");
                    } else if (view.getIndexTblTtPhieu() < 0) {
                        JOptionPane.showMessageDialog(view, "B???n ch??a ch??? ?????nh th??ng tin phi???u ????? thao t??c!!");
                    } else {
                        if (JOptionPane.showConfirmDialog(view, "B???n c?? ch???c mu???n xo?? kh??ng?") == 0) {
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
                            JOptionPane.showMessageDialog(view, "Xo?? th??nh c??ng");
                        }
                        view.loadJTableTtPhieu(view.getTextSelectedIdPhieu());
                    }
                    break;
                case "T??m":
                    ArrayList<Ttphieuxuat> res = Ttphieuxuat.FindByID(view.getTextCbbKhoTimKiem());
                    if (res.size() <= 0) {
                        JOptionPane.showMessageDialog(view, "Kh??ng c?? gi??? li???u!");
                    } else {
                        view.setJTableTtPhieu(res);
                    }
                    break;
                case "L??m m???i":
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
            JOptionPane.showMessageDialog(view, "Thao t??c kh??ng h???p l??? b???i m???t trong l?? do sau: \n - Tr?????ng d??? li???u tr???ng\n - D??? li???u b??? tr??ng\n - D??? li???u ??ang ???????c s??? d???ng");
        }
    }

}
