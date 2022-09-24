/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 *
 * @author H
 */
@Entity
@Table(name = "taikhoan")

@NamedQueries({
    @NamedQuery(name = "Taikhoan.findAll", query = "SELECT t FROM Taikhoan t"),
    @NamedQuery(name = "Taikhoan.findById", query = "SELECT t FROM Taikhoan t WHERE t.id = :id"),
    @NamedQuery(name = "Taikhoan.findByTen", query = "SELECT t FROM Taikhoan t WHERE t.ten = :ten"),
    @NamedQuery(name = "Taikhoan.findByTaiKhoan", query = "SELECT t FROM Taikhoan t WHERE t.taiKhoan = :taiKhoan"),
    @NamedQuery(name = "Taikhoan.findByMatKhau", query = "SELECT t FROM Taikhoan t WHERE t.matKhau = :matKhau")})
public class Taikhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "TaiKhoan")
    private String taiKhoan;
    @Column(name = "MatKhau")
    private String matKhau;
    @JoinColumn(name = "IdQuyen", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Phanquyen idQuyen;

    public Taikhoan() {
    }

    public Taikhoan(Integer id) {
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

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Phanquyen getIdQuyen() {
        return idQuyen;
    }

    public void setIdQuyen(Phanquyen idQuyen) {
        this.idQuyen = idQuyen;
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
        if (!(object instanceof Taikhoan)) {
            return false;
        }
        Taikhoan other = (Taikhoan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Taikhoan[ id=" + id + " ]";
    }

    public static void InsertDB(String ten, String taiKhoan, String matKhau, String idQuyen) throws ClassNotFoundException, SQLException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "INSERT INTO taikhoan(Ten,TaiKhoan,MatKhau,IdQuyen) VALUES('" + ten + "'  ,'" + taiKhoan + "','" + matKhau + "','" + idQuyen + "')";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void UpdateDB(String ID, String ten, String taiKhoan, String matKhau, String quyen) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "UPDATE `taikhoan` SET `Ten`='" + ten + "',`TaiKhoan`='" + taiKhoan + "',`MatKhau`='" + matKhau + "',`IdQuyen`='" + quyen + "' WHERE `ID`='" + ID + "'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void DeleteDB(String ID) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "DELETE FROM `taikhoan` WHERE `ID`='" + ID + "'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static Taikhoan FindByUsername(String Username) throws SQLException, ClassNotFoundException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Taikhoan item : model.taikhoans) {
            if (item.getTaiKhoan().toLowerCase().contains(Username.toLowerCase())) {
                return item;
            }
        }
        return null;
    }
    
    
    public static boolean isUserExist(String username) throws ClassNotFoundException, SQLException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Taikhoan item : model.taikhoans) {
            if (item.getTaiKhoan().toLowerCase().trim().equals(username.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
