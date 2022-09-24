/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Hanghoa;
import Model.QuanLyKhoModel;
import View.HangHoaView;
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
public class HangHoaController implements Action {

    private HangHoaView view;
    private QuanLyKhoModel model;

    public HangHoaController(HangHoaView view) throws ClassNotFoundException, SQLException {
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
                case "Thêm":
                    if (Hanghoa.isIdExist(view.getTextTfMaHang())) {
                        JOptionPane.showMessageDialog(view, "Mã này đã tồn tại!!");
                    } else {
                        Hanghoa.InsertDB(view.getTextTfMaHang(), view.getTextTfTenHang(), view.getTextTfDonViTinh(), view.getTextTfDonGia(), view.getValueCbbLoaiHang());
                        JOptionPane.showMessageDialog(view, "Thêm thành công");
                    }
                    view.loadJTable();
                    break;
                case "Sửa":
                    if (view.getIndexTbl() < 0) {
                        JOptionPane.showMessageDialog(view, "Bạn chưa chỉ định dữ liệu để thao tác!!");
                    } else {
                        try {
                            Hanghoa.UpdateDB(view.getTextSelectedId(), view.getTextTfMaHang(), view.getTextTfTenHang(), view.getTextTfDonViTinh(), view.getTextTfDonGia(), view.getValueCbbLoaiHang());
                            JOptionPane.showMessageDialog(view, "Sửa thành công");
                            view.loadJTable();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(view, "Mã này đã tồn tại!!");
                        }
                    }
                    break;
                case "Xoá":
                    if (view.getIndexTbl() < 0) {
                        JOptionPane.showMessageDialog(view, "Bạn chưa chỉ định dữ liệu để thao tác!!");
                    } else {
                        if (JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn xoá không?") == 0) {
                            Hanghoa.DeleteDB(view.getTextSelectedId());
                            JOptionPane.showMessageDialog(view, "Xoá thành công");
                            view.loadJTable();
                        }
                    }
                    break;
                case "Tìm":
                    Hanghoa res = Hanghoa.FindByID(view.getTextTfIdCanTim());
                    view.setJTable(res);
                    break;
                case "Làm mới":
                    view.loadJTable();
                    view.clear();
                    break;
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
