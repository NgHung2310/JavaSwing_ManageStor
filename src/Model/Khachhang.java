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
@Table(name = "khachhang")

@NamedQueries({
    @NamedQuery(name = "Khachhang.findAll", query = "SELECT k FROM Khachhang k"),
    @NamedQuery(name = "Khachhang.findByMaKH", query = "SELECT k FROM Khachhang k WHERE k.maKH = :maKH"),
    @NamedQuery(name = "Khachhang.findByHoTenKH", query = "SELECT k FROM Khachhang k WHERE k.hoTenKH = :hoTenKH"),
    @NamedQuery(name = "Khachhang.findByDiaChiKH", query = "SELECT k FROM Khachhang k WHERE k.diaChiKH = :diaChiKH"),
    @NamedQuery(name = "Khachhang.findBySdtKH", query = "SELECT k FROM Khachhang k WHERE k.sdtKH = :sdtKH")})
public class Khachhang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaKH")
    private String maKH;
    @Column(name = "HoTenKH")
    private String hoTenKH;
    @Column(name = "DiaChiKH")
    private String diaChiKH;
    @Column(name = "SdtKH")
    private String sdtKH;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maKH")
    private Collection<Ttphieuxuat> ttphieuxuatCollection;

    public Khachhang() {
    }

    public Khachhang(String maKH) {
        this.maKH = maKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }


    public Collection<Ttphieuxuat> getTtphieuxuatCollection() {
        return ttphieuxuatCollection;
    }

    public void setTtphieuxuatCollection(Collection<Ttphieuxuat> ttphieuxuatCollection) {
        this.ttphieuxuatCollection = ttphieuxuatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKH != null ? maKH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khachhang)) {
            return false;
        }
        Khachhang other = (Khachhang) object;
        if ((this.maKH == null && other.maKH != null) || (this.maKH != null && !this.maKH.equals(other.maKH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Khachhang[ maKH=" + maKH + " ]";
    }

    public static void InsertDB(String MaKH, String HoTenKH, String DiaChiKH, String SdtKH) throws ClassNotFoundException, SQLException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "INSERT INTO `khachhang`(`MaKH`, `HoTenKH`, `DiaChiKH`, `SdtKH`) VALUES ('" + MaKH + "','" + HoTenKH + "','" + DiaChiKH + "','" + SdtKH + "')";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void UpdateDB(String MaKH, String MaKHNew, String HoTenKH, String DiaChiKH, String SdtKH) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "UPDATE `khachhang` SET `MaKH`='" + MaKHNew + "',`HoTenKH`='" + HoTenKH + "',`DiaChiKH`='" + DiaChiKH + "',`SdtKH`='" + SdtKH + "' WHERE `MaKH`='" + MaKH + "'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void DeleteDB(String MaKH) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "DELETE FROM `khachhang` WHERE `MaKH`='" + MaKH + "'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static Khachhang FindByID(String ID) throws SQLException, ClassNotFoundException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Khachhang item : model.khachhangs) {
            if (item.getMaKH().toLowerCase().contains(ID.toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    public static boolean isIdExist(String ID) throws ClassNotFoundException, SQLException {
       QuanLyKhoModel model = new QuanLyKhoModel();
        for (Khachhang item : model.khachhangs) {
            if (item.getMaKH().toLowerCase().trim().equals(ID.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
