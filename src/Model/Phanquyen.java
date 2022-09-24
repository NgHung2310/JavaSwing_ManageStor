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
@Table(name = "phanquyen")

@NamedQueries({
    @NamedQuery(name = "Phanquyen.findAll", query = "SELECT p FROM Phanquyen p"),
    @NamedQuery(name = "Phanquyen.findById", query = "SELECT p FROM Phanquyen p WHERE p.id = :id"),
    @NamedQuery(name = "Phanquyen.findByTen", query = "SELECT p FROM Phanquyen p WHERE p.ten = :ten")})
public class Phanquyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Ten")
    private String ten;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuyen")
    private Collection<Taikhoan> taikhoanCollection;

    public Phanquyen() {
    }

    public Phanquyen(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }


    public Collection<Taikhoan> getTaikhoanCollection() {
        return taikhoanCollection;
    }

    public void setTaikhoanCollection(Collection<Taikhoan> taikhoanCollection) {
        this.taikhoanCollection = taikhoanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phanquyen)) {
            return false;
        }
        Phanquyen other = (Phanquyen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Phanquyen[ id=" + id + " ]";
    }
    

    public static void InsertDB(String MaKH, String HoTenKH, String DiaChiKH, String SdtKH) throws ClassNotFoundException, SQLException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void UpdateDB(String MaKH, String MaKHNew, String HoTenKH, String DiaChiKH, String SdtKH) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void DeleteDB(String MaKH) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static Khachhang FindByID(String ID) throws SQLException, ClassNotFoundException {

        return null;
    }

    public static boolean isIdExist(String ID) throws ClassNotFoundException, SQLException {
        return false;
    }
}
