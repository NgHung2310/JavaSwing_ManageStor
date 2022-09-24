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
import javax.persistence.CascadeType;
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
@Table(name = "phieunhap")

@NamedQueries({
    @NamedQuery(name = "Phieunhap.findAll", query = "SELECT p FROM Phieunhap p"),
    @NamedQuery(name = "Phieunhap.findByMaPN", query = "SELECT p FROM Phieunhap p WHERE p.maPN = :maPN"),
    @NamedQuery(name = "Phieunhap.findByNgayNhap", query = "SELECT p FROM Phieunhap p WHERE p.ngayNhap = :ngayNhap")})
public class Phieunhap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaPN")
    private String maPN;
    @Column(name = "NgayNhap")
    @Temporal(TemporalType.DATE)
    private Date ngayNhap;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maPN")
    private Collection<Ttphieunhap> ttphieunhapCollection;

    public Phieunhap() {
    }

    public Phieunhap(String maPN) {
        this.maPN = maPN;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
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
        hash += (maPN != null ? maPN.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phieunhap)) {
            return false;
        }
        Phieunhap other = (Phieunhap) object;
        if ((this.maPN == null && other.maPN != null) || (this.maPN != null && !this.maPN.equals(other.maPN))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Phieunhap[ maPN=" + maPN + " ]";
    }

    public static void InsertDB() throws ClassNotFoundException, SQLException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "";
        sql = "INSERT INTO `phieunhap`(`NgayNhap`) VALUES ('" + java.time.LocalDate.now() + "')";
        sta.executeUpdate(sql);
        kn.Close();
    }

//    public static void UpdateDB(String MaPN, String MaPNNew, String NgayNhap) throws SQLException, ClassNotFoundException {
//        MySQLConnection kn = new MySQLConnection();
//        Statement sta = kn.getConnection().createStatement();
//        String sql = "UPDATE `phieunhap` SET `MaPN`='" + MaPNNew + "',`NgayNhap`='" + NgayNhap + "' WHERE `MaPN`='" + MaPN + "'";
//        sta.executeUpdate(sql);
//        kn.Close();
//    }
    public static void DeleteDB(String MaPN) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "DELETE FROM `phieunhap` WHERE `MaPN`='" + MaPN + "'";
        String sql1 = "DELETE FROM `ttphieunhap` WHERE `MaPN`='" + MaPN + "'";
        sta.executeUpdate(sql1);
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static Phieunhap FindByID(String ID) throws SQLException, ClassNotFoundException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Phieunhap item : model.phieunhaps) {
            if (item.getMaPN().toLowerCase().contains(ID.toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    public static boolean isIdExist(String ID) throws ClassNotFoundException, SQLException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Phieunhap item : model.phieunhaps) {
            if (item.getMaPN().toLowerCase().trim().equals(ID.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
