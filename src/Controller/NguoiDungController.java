/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author H
 */
public class NguoiDungController implements Action {

    private NguoiDungView view;
    private QuanLyKhoModel model;

    public NguoiDungController(NguoiDungView view) throws ClassNotFoundException, SQLException {
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
            switch (cmd) {
                case "Th??m":
                    if (Taikhoan.isUserExist(view.getTextTfTaiKhoan())) {
                        JOptionPane.showMessageDialog(view, "T??i kho???n n??y ???? t???n t???i!!");
                    } else {
                        Taikhoan.InsertDB(view.getTextTfTen(), view.getTextTfTaiKhoan(), view.getTextTfMatKhau(), view.getValueCbbQuyen());
                        JOptionPane.showMessageDialog(view, "Th??m th??nh c??ng");
                    }
                    view.loadJTable();
                    break;
                case "S???a":
                    if (view.getIndexTbl() < 0) {
                        JOptionPane.showMessageDialog(view, "B???n ch??a ch??? ?????nh d??? li???u ????? thao t??c!!");
                    } else {
                        if (Taikhoan.isUserExist(view.getTextTfTaiKhoan())) {
                            JOptionPane.showMessageDialog(view, "T??i kho???n n??y ???? t???n t???i!!");
                        } else {
                            Taikhoan.UpdateDB(view.getTextSelectedId(), view.getTextTfTen(), view.getTextTfTaiKhoan(), view.getTextTfMatKhau(), view.getValueCbbQuyen());
                            JOptionPane.showMessageDialog(view, "S???a th??nh c??ng");
                            view.loadJTable();
                        }
                    }
                    break;
                case "Xo??":
                    if (view.getIndexTbl() < 0) {
                        JOptionPane.showMessageDialog(view, "B???n ch??a ch??? ?????nh d??? li???u ????? thao t??c!!");
                    } else {
                        if (JOptionPane.showConfirmDialog(view, "B???n c?? ch???c mu???n xo?? kh??ng?") == 0) {
                            Taikhoan.DeleteDB(view.getTextSelectedId());
                            JOptionPane.showMessageDialog(view, "Xo?? th??nh c??ng");
                            view.loadJTable();
                        }
                    }
                    break;
                case "T??m":
                    Taikhoan res = Taikhoan.FindByUsername(view.getTextTfIdCanTim());
                    view.setJTable(res);
                    break;
                case "L??m m???i":
                    view.loadJTable();
                    view.clear();
                    break;
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
