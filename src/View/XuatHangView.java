/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.NhapHangController;
import Controller.XuatHangController;
import Model.Hanghoa;
import Model.Khachhang;
import Model.Nhacungcap;
import Model.Phieuxuat;
import Model.QuanLyKhoModel;
import Model.Ttphieunhap;
import Model.Ttphieuxuat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author H
 */
public class XuatHangView extends javax.swing.JFrame {

    QuanLyKhoModel model;

    /**
     * Creates new form XuatHangView
     */
    public XuatHangView() throws ClassNotFoundException, SQLException {
        initComponents();
        model = new QuanLyKhoModel();
        loadJTablePhieu();
        loadJCombobox();
        Action action = new XuatHangController(this);
        btnLamMoi.addActionListener(action);
        btnSuaTt.addActionListener(action);
        btnThemPhieu.addActionListener(action);
        btnThemTt.addActionListener(action);
        btnTim.addActionListener(action);
        btnXoaPhieu.addActionListener(action);
        btnXoaTt.addActionListener(action);
        cbbHangHoa.addActionListener(action);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfSoLuong = new javax.swing.JTextField();
        tfDonGia = new javax.swing.JTextField();
        cbbN = new javax.swing.JComboBox<>();
        cbbHangHoa = new javax.swing.JComboBox<>();
        btnTim = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieu = new javax.swing.JTable();
        btnThemPhieu = new javax.swing.JButton();
        btnXoaPhieu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThongTinPhieu = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cbbKhoTimKiem = new javax.swing.JComboBox<>();
        btnThemTt = new javax.swing.JButton();
        btnSuaTt = new javax.swing.JButton();
        btnXoaTt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Xuất hàng");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Số lượng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Đơn giá");

        tfSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tfDonGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbHangHoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnTim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTim.setText("Tìm");

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLamMoi.setText("Làm mới");

        tblPhieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblPhieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã phiếu", "Ngày tạo"
            }
        ));
        tblPhieu.setRowHeight(30);
        tblPhieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieu);

        btnThemPhieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemPhieu.setText("Tạo phiếu");

        btnXoaPhieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoaPhieu.setText("Xoá phiếu");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Khách hàng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Hàng hoá");

        tblThongTinPhieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblThongTinPhieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Khách hàng", "Hàng hoá", "Số lượng", "Đơn giá"
            }
        ));
        tblThongTinPhieu.setRowHeight(30);
        tblThongTinPhieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinPhieuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblThongTinPhieu);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Tìm theo Tên hàng");

        cbbKhoTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnThemTt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemTt.setText("Thêm tt");

        btnSuaTt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSuaTt.setText("Sửa tt");

        btnXoaTt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoaTt.setText("Xoá tt");

        jLabel1.setText("Còn lại:");

        jlb.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemPhieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbN, 0, 225, Short.MAX_VALUE)
                            .addComponent(cbbHangHoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSoLuong)
                            .addComponent(tfDonGia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbKhoTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(416, 416, 416)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnThemTt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(btnSuaTt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(btnXoaTt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnThemPhieu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaPhieu))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jlb))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbKhoTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTt)
                    .addComponent(btnSuaTt)
                    .addComponent(btnXoaTt)
                    .addComponent(btnLamMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuMouseClicked
        String id = getTextSelectedIdPhieu();
        try {
            loadJTableTtPhieu(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhapHangView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangView.class.getName()).log(Level.SEVERE, null, ex);
        }
        int dongchon = 0;
    }//GEN-LAST:event_tblPhieuMouseClicked

    private void tblThongTinPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinPhieuMouseClicked
        int dongchon = 0;
        dongchon = tblThongTinPhieu.getSelectedRow();
        String ncc = tblThongTinPhieu.getValueAt(dongchon, 1) + "";
        String hh = tblThongTinPhieu.getValueAt(dongchon, 2) + "";
        String sl = tblThongTinPhieu.getValueAt(dongchon, 3) + "";
        String dg = tblThongTinPhieu.getValueAt(dongchon, 4) + "";
        cbbN.setSelectedItem(ncc);
        cbbHangHoa.setSelectedItem(hh);
        tfSoLuong.setText(sl);
        tfDonGia.setText(dg);
    }//GEN-LAST:event_tblThongTinPhieuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XuatHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XuatHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XuatHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XuatHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new XuatHangView().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(XuatHangView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(XuatHangView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaTt;
    private javax.swing.JButton btnThemPhieu;
    private javax.swing.JButton btnThemTt;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoaPhieu;
    private javax.swing.JButton btnXoaTt;
    private javax.swing.JComboBox<String> cbbHangHoa;
    private javax.swing.JComboBox<String> cbbKhoTimKiem;
    private javax.swing.JComboBox<String> cbbN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlb;
    private javax.swing.JTable tblPhieu;
    private javax.swing.JTable tblThongTinPhieu;
    private javax.swing.JTextField tfDonGia;
    private javax.swing.JTextField tfSoLuong;
    // End of variables declaration//GEN-END:variables

    public void loadJTablePhieu() throws ClassNotFoundException, SQLException {
        int i = 0;
        model = new QuanLyKhoModel();
        for (Phieuxuat item : model.phieuxuats) {
            DefaultTableModel model = (DefaultTableModel) tblPhieu.getModel();
            model.setRowCount(i + 1);
            tblPhieu.setValueAt(item.getMaPX(), i, 0);
            tblPhieu.setValueAt(item.getNgayXuat(), i, 1);
            i++;
        }

    }

    public void loadJTableTtPhieu(String idPhieu) throws ClassNotFoundException, SQLException {
        int i = 0;
        model = new QuanLyKhoModel();
        DefaultTableModel m = (DefaultTableModel) tblThongTinPhieu.getModel();
        m.setRowCount(0);
        for (Ttphieuxuat item : model.ttphieuxuats) {
            if (item.getMaPX().getMaPX().equals(idPhieu)) {
                m.setRowCount(i + 1);
                tblThongTinPhieu.setValueAt(item.getId(), i, 0);
                tblThongTinPhieu.setValueAt(item.getMaKH().getHoTenKH(), i, 1);
                tblThongTinPhieu.setValueAt(item.getMaHang().getTenHang(), i, 2);
                tblThongTinPhieu.setValueAt(item.getSLXuat(), i, 3);
                tblThongTinPhieu.setValueAt(item.getDGXuat(), i, 4);
                i++;
            }
        }
    }

    public void loadJCombobox() {
        for (Khachhang item : model.khachhangs) {
            cbbN.addItem(item.getHoTenKH());
        }
        for (Hanghoa item : model.hanghoas) {
            cbbHangHoa.addItem(item.getTenHang());
            cbbKhoTimKiem.addItem(item.getTenHang());
        }
    }

    public void setJTableTtPhieu(ArrayList<Ttphieuxuat> lstPhieu) throws ClassNotFoundException, SQLException {
        int i = 0;
        DefaultTableModel model = (DefaultTableModel) tblThongTinPhieu.getModel();
        model.setRowCount(0);
        for (Ttphieuxuat item : lstPhieu) {
            model.setRowCount(i + 1);
            tblThongTinPhieu.setValueAt(item.getId(), i, 0);
            tblThongTinPhieu.setValueAt(item.getMaKH().getHoTenKH(), i, 1);
            tblThongTinPhieu.setValueAt(item.getMaHang().getTenHang(), i, 2);
            tblThongTinPhieu.setValueAt(item.getSLXuat(), i, 3);
            tblThongTinPhieu.setValueAt(item.getDGXuat(), i, 4);
            i++;

        }
    }

    public String getTextSelectedIdPhieu() {
        int dongchon = tblPhieu.getSelectedRow();
        String ID = tblPhieu.getValueAt(dongchon, 0) + "";
        return ID;
    }

    public String getTextSelectedIdTtPhieu() {
        int dongchon = tblThongTinPhieu.getSelectedRow();
        String ID = tblThongTinPhieu.getValueAt(dongchon, 0) + "";
        return ID;
    }

    public String getTextTfSoLuong() {
        return tfSoLuong.getText();
    }

    public String getTextTfDonGia() {
        return tfDonGia.getText();
    }

    public String getTextCbbN() {
        String string = cbbN.getSelectedItem().toString();
        for (Khachhang item : model.khachhangs) {
            if (item.getHoTenKH().equals(string)) {
                return item.getMaKH();
            }
        }
        return "";
    }

    public String getTextCbbHangHoa() {
        String string = cbbHangHoa.getSelectedItem().toString();
        for (Hanghoa item : model.hanghoas) {
            if (item.getTenHang().equals(string)) {
                return item.getMaHang();
            }
        }
        return "";
    }

    public String getTextCbbKhoTimKiem() {
//        String string = cbbKhoTimKiem.getSelectedItem().toString();
//        for (Khohang item : model.khohangs) {
//            if (item.getTenKho().equals(string)) {
//                return item.getMaKho();
//            }
//        }
//        return "";
        return cbbKhoTimKiem.getSelectedItem().toString();
    }

    public void clear() {
        tfDonGia.setText("");
        tfSoLuong.setText("");
    }

    public void setLbTonKho(String str) {
        jlb.setText(str);
    }

    public int getIndexTblPhieu() {
        return tblPhieu.getSelectedRow();
    }

    public int getIndexTblTtPhieu() {
        return tblThongTinPhieu.getSelectedRow();
    }
}