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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author H
 */
@Entity
@Table(name = "danhmuchang")

@NamedQueries({
    @NamedQuery(name = "Danhmuchang.findAll", query = "SELECT d FROM Danhmuchang d"),
    @NamedQuery(name = "Danhmuchang.findByMaLoaiHang", query = "SELECT d FROM Danhmuchang d WHERE d.maLoaiHang = :maLoaiHang"),
    @NamedQuery(name = "Danhmuchang.findByTenLoaiHang", query = "SELECT d FROM Danhmuchang d WHERE d.tenLoaiHang = :tenLoaiHang")})
public class Danhmuchang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaLoaiHang")
    private String maLoaiHang;
    @Column(name = "TenLoaiHang")
    private String tenLoaiHang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maLoaiHang")
    private Collection<Hanghoa> hanghoaCollection;

    public Danhmuchang() {
    }

    public Danhmuchang(String maLoaiHang) {
        this.maLoaiHang = maLoaiHang;
    }

    public String getMaLoaiHang() {
        return maLoaiHang;
    }

    public void setMaLoaiHang(String maLoaiHang) {
        this.maLoaiHang = maLoaiHang;
    }

    public String getTenLoaiHang() {
        return tenLoaiHang;
    }

    public void setTenLoaiHang(String tenLoaiHang) {
        this.tenLoaiHang = tenLoaiHang;
    }


    public Collection<Hanghoa> getHanghoaCollection() {
        return hanghoaCollection;
    }

    public void setHanghoaCollection(Collection<Hanghoa> hanghoaCollection) {
        this.hanghoaCollection = hanghoaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLoaiHang != null ? maLoaiHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Danhmuchang)) {
            return false;
        }
        Danhmuchang other = (Danhmuchang) object;
        if ((this.maLoaiHang == null && other.maLoaiHang != null) || (this.maLoaiHang != null && !this.maLoaiHang.equals(other.maLoaiHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Danhmuchang[ maLoaiHang=" + maLoaiHang + " ]";
    }

    public static void InsertDB(String ma, String ten) throws ClassNotFoundException, SQLException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "INSERT INTO `danhmuchang`(`MaLoaiHang`, `TenLoaiHang`) VALUES ('" + ma + "','" + ten + "')";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void UpdateDB(String ma, String maNew, String ten) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "UPDATE `danhmuchang` SET `MaLoaiHang`='" + maNew + "',`TenLoaiHang`='" + ten + "' WHERE `MaLoaiHang`='" + ma + "'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void DeleteDB(String ma) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "DELETE FROM `danhmuchang` WHERE `MaLoaiHang`='" + ma + "'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static Danhmuchang FindByID(String ma) throws SQLException, ClassNotFoundException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Danhmuchang item : model.danhmuchangs) {
            if (item.getMaLoaiHang().toLowerCase().contains(ma.toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    public static boolean isIdExist(String ma) throws ClassNotFoundException, SQLException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Danhmuchang item : model.danhmuchangs) {
            if (item.getMaLoaiHang().toLowerCase().trim().equals(ma.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
