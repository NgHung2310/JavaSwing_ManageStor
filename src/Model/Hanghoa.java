/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author H
 */
@Entity
@Table(name = "hanghoa")

@NamedQueries({
    @NamedQuery(name = "Hanghoa.findAll", query = "SELECT h FROM Hanghoa h"),
    @NamedQuery(name = "Hanghoa.findByMaHang", query = "SELECT h FROM Hanghoa h WHERE h.maHang = :maHang"),
    @NamedQuery(name = "Hanghoa.findByTenHang", query = "SELECT h FROM Hanghoa h WHERE h.tenHang = :tenHang"),
    @NamedQuery(name = "Hanghoa.findByDonViTinh", query = "SELECT h FROM Hanghoa h WHERE h.donViTinh = :donViTinh"),
    @NamedQuery(name = "Hanghoa.findByDonGia", query = "SELECT h FROM Hanghoa h WHERE h.donGia = :donGia")})
public class Hanghoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaHang")
    private String maHang;
    @Column(name = "TenHang")
    private String tenHang;
    @Column(name = "DonViTinh")
    private String donViTinh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DonGia")
    private Float donGia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maHang")
    private Collection<Ttphieuxuat> ttphieuxuatCollection;
    @JoinColumn(name = "MaLoaiHang", referencedColumnName = "MaLoaiHang")
    @ManyToOne(optional = false)
    private Danhmuchang maLoaiHang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maHang")
    private Collection<Ttphieunhap> ttphieunhapCollection;

    public Hanghoa() {
    }

    public Hanghoa(String maHang) {
        this.maHang = maHang;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }


    public Collection<Ttphieuxuat> getTtphieuxuatCollection() {
        return ttphieuxuatCollection;
    }

    public void setTtphieuxuatCollection(Collection<Ttphieuxuat> ttphieuxuatCollection) {
        this.ttphieuxuatCollection = ttphieuxuatCollection;
    }

    public Danhmuchang getMaLoaiHang() {
        return maLoaiHang;
    }

    public void setMaLoaiHang(Danhmuchang maLoaiHang) {
        this.maLoaiHang = maLoaiHang;
    }


    public Collection<Ttphieunhap> getTtphieunhapCollection() {
        return ttphieunhapCollection;
    }

    public void setTtphieunhapCollection(Collection<Ttphieunhap> ttphieunhapCollection) {
        this.ttphieunhapCollection = ttphieunhapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHang != null ? maHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hanghoa)) {
            return false;
        }
        Hanghoa other = (Hanghoa) object;
        if ((this.maHang == null && other.maHang != null) || (this.maHang != null && !this.maHang.equals(other.maHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Hanghoa[ maHang=" + maHang + " ]";
    }

    public static void InsertDB(String MaHang, String TenHang, String DonViTinh, String DonGia, String MaLoaiHang) throws ClassNotFoundException, SQLException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "INSERT INTO `hanghoa`(`MaHang`, `TenHang`, `DonViTinh`, `DonGia`, `MaLoaiHang`) VALUES ('"+MaHang+"','"+TenHang+"','"+DonViTinh+"','"+DonGia+"','"+MaLoaiHang+"')";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void UpdateDB(String MaHang,String MaHangNew, String TenHang, String DonViTinh, String DonGia, String MaLoaiHang) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "UPDATE `hanghoa` SET `MaHang`='"+MaHangNew+"',`TenHang`='"+TenHang+"',`DonViTinh`='"+DonViTinh+"',`DonGia`='"+DonGia+"',`MaLoaiHang`='"+MaLoaiHang+"' WHERE `MaHang`='"+MaHang+"'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void DeleteDB(String MaHang) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "DELETE FROM `hanghoa` WHERE `MaHang`='"+MaHang+"'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static Hanghoa FindByID(String ID) throws SQLException, ClassNotFoundException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Hanghoa item : model.hanghoas) {
            if (item.getMaHang().toLowerCase().contains(ID.toLowerCase())) {
                return item;
            }
        }
        return null;
    }
    
    public static Hanghoa FindByName(String ID) throws SQLException, ClassNotFoundException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Hanghoa item : model.hanghoas) {
            if (item.getTenHang().toLowerCase().contains(ID.toLowerCase())) {
                return item;
            }
        }
        return null;
    }
    
    public static boolean isIdExist(String ID) throws ClassNotFoundException, SQLException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Hanghoa item : model.hanghoas) {
            if (item.getMaHang().toLowerCase().trim().equals(ID.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
