/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author H
 */
@Entity
@Table(name = "phieuxuat")

@NamedQueries({
    @NamedQuery(name = "Phieuxuat.findAll", query = "SELECT p FROM Phieuxuat p"),
    @NamedQuery(name = "Phieuxuat.findByMaPX", query = "SELECT p FROM Phieuxuat p WHERE p.maPX = :maPX"),
    @NamedQuery(name = "Phieuxuat.findByNgayXuat", query = "SELECT p FROM Phieuxuat p WHERE p.ngayXuat = :ngayXuat")})
public class Phieuxuat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaPX")
    private String maPX;
    @Column(name = "NgayXuat")
    @Temporal(TemporalType.DATE)
    private Date ngayXuat;
    @OneToMany(mappedBy = "maPX")
    private Collection<Ttphieuxuat> ttphieuxuatCollection;

    public Phieuxuat() {
    }

    public Phieuxuat(String maPX) {
        this.maPX = maPX;
    }

    public String getMaPX() {
        return maPX;
    }

    public void setMaPX(String maPX) {
        this.maPX = maPX;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
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
        hash += (maPX != null ? maPX.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phieuxuat)) {
            return false;
        }
        Phieuxuat other = (Phieuxuat) object;
        if ((this.maPX == null && other.maPX != null) || (this.maPX != null && !this.maPX.equals(other.maPX))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Phieuxuat[ maPX=" + maPX + " ]";
    }

    public static void InsertDB() throws ClassNotFoundException, SQLException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "";
        sql = "INSERT INTO `phieuxuat`(`NgayXuat`) VALUES ('" + java.time.LocalDate.now() + "')";
        sta.executeUpdate(sql);
        kn.Close();
    }

//    public static void UpdateDB(String MaPX, String MaPXNew, String NgayXuat) throws SQLException, ClassNotFoundException {
//        MySQLConnection kn = new MySQLConnection();
//        Statement sta = kn.getConnection().createStatement();
//        String sql = "UPDATE `phieuxuat` SET `MaPX`='" + MaPXNew + "',`NgayXuat`='" + NgayXuat + "' WHERE `MaPX`='" + MaPX + "'";
//        sta.executeUpdate(sql);
//        kn.Close();
//    }
    public static void DeleteDB(String MaPX) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "DELETE FROM `phieuxuat` WHERE `MaPX`='" + MaPX + "'";
        String sql1 = "DELETE FROM `ttphieuxuat` WHERE `MaPX`='" + MaPX + "'";
        sta.executeUpdate(sql1);
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static Phieuxuat FindByID(String ID) throws SQLException, ClassNotFoundException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Phieuxuat item : model.phieuxuats) {
            if (item.getMaPX().toLowerCase().contains(ID.toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    public static boolean isIdExist(String ID) throws ClassNotFoundException, SQLException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Phieuxuat item : model.phieuxuats) {
            if (item.getMaPX().toLowerCase().trim().equals(ID.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
