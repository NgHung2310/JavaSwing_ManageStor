/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.QuanLyKhoModel;
import Model.Danhmuchang;
import View.DanhMucHangView;
import View.NguoiDungView;
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
public class DanhMucHangController implements Action {

    private DanhMucHangView view;
    private QuanLyKhoModel model;

    public DanhMucHangController(DanhMucHangView view) throws ClassNotFoundException, SQLException {
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
                    if (Danhmuchang.isIdExist(view.getTextTfMa())) {
                        JOptionPane.showMessageDialog(view, "M?? n??y ???? t???n t???i!!");
                    } else {
                        Danhmuchang.InsertDB(view.getTextTfMa(), view.getTextTfTen());
                        JOptionPane.showMessageDialog(view, "Th??m th??nh c??ng");
                    }
                    view.loadJTable();
                    break;
                case "S???a":
                    if (view.getIndexTbl() < 0) {
                        JOptionPane.showMessageDialog(view, "B???n ch??a ch??? ?????nh d??? li???u ????? thao t??c!!");
                    } else {
                        try {
                            Danhmuchang.UpdateDB(view.getTextSelectedId(), view.getTextTfMa(), view.getTextTfTen());
                            JOptionPane.showMessageDialog(view, "S???a th??nh c??ng");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(view, "M?? n??y ???? t???n t???i!!");
                        }
                        view.loadJTable();
                    }
                    break;
                case "Xo??":
                    if (view.getIndexTbl() < 0) {
                        JOptionPane.showMessageDialog(view, "B???n ch??a ch??? ?????nh d??? li???u ????? thao t??c!!");
                    } else {
                        if (JOptionPane.showConfirmDialog(view, "B???n c?? ch???c mu???n xo?? kh??ng?") == 0) {
                            Danhmuchang.DeleteDB(view.getTextSelectedId());
                            JOptionPane.showMessageDialog(view, "Xo?? th??nh c??ng");
                            view.loadJTable();
                        }                      
                    }
                    break;
                case "T??m":
                    Danhmuchang res = Danhmuchang.FindByID(view.getTextTfIdCanTim());
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
