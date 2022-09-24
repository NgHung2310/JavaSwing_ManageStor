/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author H
 */
public class QuanLyKhoModel {
    private MySQLConnection connection;
    private ResultSet rs;
    public ArrayList<Taikhoan> taikhoans;
    public ArrayList<Phanquyen> phanquyens;
    public ArrayList<Danhmuchang> danhmuchangs;
    public ArrayList<Hanghoa> hanghoas;
    public ArrayList<Khachhang> khachhangs;
    public ArrayList<Nhacungcap> nhacungcaps;
    public ArrayList<Phieunhap> phieunhaps;
    public ArrayList<Phieuxuat> phieuxuats;
    public ArrayList<Ttphieunhap> ttphieunhaps;
    public ArrayList<Ttphieuxuat> ttphieuxuats;

    public QuanLyKhoModel() throws ClassNotFoundException, SQLException {
        connection = new MySQLConnection("jdbc:mysql://localhost:3306/quanlykho");
        taikhoans = new ArrayList<>();
        phanquyens = new ArrayList<>();
        danhmuchangs = new ArrayList<>();
        hanghoas = new ArrayList<>();
        khachhangs = new ArrayList<>();
        nhacungcaps = new ArrayList<>();
        phieunhaps = new ArrayList<>();
        phieuxuats = new ArrayList<>();
        ttphieunhaps = new ArrayList<>();
        ttphieuxuats = new ArrayList<>();
        setPhanQuyens();
        setTaiKhoans();
        setDanhMucHangs();
        setHangHoas();
        setKhachHangs();
        setNhaCungCaps();
        setPhieuNhaps();
        setPhieuXuats();
        setTtPhieuNhaps();
        setTtPhieuXuats();
    }

    public void setPhanQuyens() throws ClassNotFoundException, SQLException {
        rs = null;
        rs = connection.getData("phanquyen");
        while (rs.next()) {
            Phanquyen pq = new Phanquyen();
            pq.setId(rs.getInt("ID"));
            pq.setTen(rs.getString("Ten"));
            phanquyens.add(pq);
        }
    }

    public void setTaiKhoans() throws ClassNotFoundException, SQLException {
        rs = null;
        rs = connection.getData("taikhoan");
        while (rs.next()) {
            Taikhoan tk = new Taikhoan();
            tk.setId(Integer.parseInt(rs.getString("ID")));
            tk.setTen(rs.getString("Ten"));
            tk.setTaiKhoan(rs.getString("TaiKhoan"));
            tk.setMatKhau(rs.getString("MatKhau"));
            for (Phanquyen item : phanquyens) {
                if (rs.getInt("IdQuyen") == item.getId()) {
                    tk.setIdQuyen(item);
                }
            }
            taikhoans.add(tk);
        }
    }

    public void setDanhMucHangs() throws ClassNotFoundException, SQLException {
        rs = null;
        rs = connection.getData("danhmuchang");
        while (rs.next()) {
            Danhmuchang dmh = new Danhmuchang();
            dmh.setMaLoaiHang(rs.getString("MaLoaiHang"));
            dmh.setTenLoaiHang(rs.getString("TenLoaiHang"));
            danhmuchangs.add(dmh);
        }
    }

    public void setHangHoas() throws ClassNotFoundException, SQLException {
        rs = null;
        rs = connection.getData("hanghoa");
        while (rs.next()) {
            Hanghoa hh = new Hanghoa();
            hh.setMaHang(rs.getString("MaHang"));
            hh.setTenHang(rs.getString("TenHang"));
            hh.setDonViTinh(rs.getString("DonViTinh"));
            hh.setDonGia(rs.getFloat("DonGia"));
            for (Danhmuchang item : danhmuchangs) {
                if (rs.getString("MaLoaiHang").equals(item.getMaLoaiHang())) {
                    hh.setMaLoaiHang(item);
                }
            }
            hanghoas.add(hh);
        }
    }

    public void setKhachHangs() throws ClassNotFoundException, SQLException {
        rs = null;
        rs = connection.getData("khachhang");
        while (rs.next()) {
            Khachhang kh = new Khachhang();
            kh.setMaKH(rs.getString("MaKH"));
            kh.setHoTenKH(rs.getString("HoTenKH"));
            kh.setDiaChiKH(rs.getString("DiaChiKH"));
            kh.setSdtKH(rs.getString("SdtKH"));
            khachhangs.add(kh);
        }
    }

    public void setNhaCungCaps() throws ClassNotFoundException, SQLException {
        rs = null;
        rs = connection.getData("nhacungcap");
        while (rs.next()) {
            Nhacungcap ncc = new Nhacungcap();
            ncc.setMaNCC(rs.getString("MaNCC"));
            ncc.setTenNCC(rs.getString("TenNCC"));
            ncc.setSdtNCC(rs.getString("SdtNCC"));
            ncc.setDiaChiNCC(rs.getString("DiaChiNCC"));
            ncc.setMailNCC(rs.getString("MailNCC"));
            nhacungcaps.add(ncc);
        }
    }


    public void setPhieuNhaps() throws ClassNotFoundException, SQLException {
        rs = null;
        rs = connection.getData("phieunhap");
        while (rs.next()) {
            Phieunhap pn = new Phieunhap();
            pn.setMaPN(rs.getString("MaPN"));
            pn.setNgayNhap(rs.getDate("NgayNhap"));
            phieunhaps.add(pn);
        }
    }

    public void setPhieuXuats() throws ClassNotFoundException, SQLException {
        rs = null;
        rs = connection.getData("phieuxuat");
        while (rs.next()) {
            Phieuxuat px = new Phieuxuat();
            px.setMaPX(rs.getString("MaPX"));
            px.setNgayXuat(rs.getDate("NgayXuat"));
            phieuxuats.add(px);
        }
    }

    public void setTtPhieuNhaps() throws ClassNotFoundException, SQLException {
        rs = null;
        rs = connection.getData("ttphieunhap");
        while (rs.next()) {
            Ttphieunhap ttpn = new Ttphieunhap();
            ttpn.setId(rs.getInt("ID"));
            for (Phieunhap item : phieunhaps) {
                if (rs.getString("MaPN").equals(item.getMaPN())) {
                    ttpn.setMaPN(item);
                }
            }
            for (Nhacungcap item : nhacungcaps) {
                if (rs.getString("MaNCC").equals(item.getMaNCC())) {
                    ttpn.setMaNCC(item);
                }
            }
            for (Hanghoa item : hanghoas) {
                if (rs.getString("MaHang").equals(item.getMaHang())) {
                    ttpn.setMaHang(item);
                }
            }
            ttpn.setDGNhap(rs.getFloat("DGNhap"));
            ttpn.setSLNhap(rs.getInt("SLNhap"));
            ttphieunhaps.add(ttpn);
        }

    }

    public void setTtPhieuXuats() throws ClassNotFoundException, SQLException {
        rs = null;
        rs = connection.getData("ttphieuxuat");
        while (rs.next()) {
            Ttphieuxuat ttpx = new Ttphieuxuat();
            ttpx.setId(rs.getInt("ID"));
            for (Phieuxuat item : phieuxuats) {
                if (rs.getString("MaPX").equals(item.getMaPX())) {
                    ttpx.setMaPX(item);
                }
            }
            for (Khachhang item : khachhangs) {
                if (rs.getString("MaKH").equals(item.getMaKH())) {
                    ttpx.setMaKH(item);
                }
            }
            for (Hanghoa item : hanghoas) {
                if (rs.getString("MaHang").equals(item.getMaHang())) {
                    ttpx.setMaHang(item);
                }
            }
            ttpx.setDGXuat(rs.getFloat("DGXuat"));
            ttpx.setSLXuat(rs.getInt("SLXuat"));
            ttphieuxuats.add(ttpx);
        }
    }
}
