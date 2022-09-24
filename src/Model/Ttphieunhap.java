/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
@Table(name = "ttphieunhap")

@NamedQueries({
    @NamedQuery(name = "Ttphieunhap.findAll", query = "SELECT t FROM Ttphieunhap t"),
    @NamedQuery(name = "Ttphieunhap.findById", query = "SELECT t FROM Ttphieunhap t WHERE t.id = :id"),
    @NamedQuery(name = "Ttphieunhap.findBySLNhap", query = "SELECT t FROM Ttphieunhap t WHERE t.sLNhap = :sLNhap"),
    @NamedQuery(name = "Ttphieunhap.findByDGNhap", query = "SELECT t FROM Ttphieunhap t WHERE t.dGNhap = :dGNhap")})
public class Ttphieunhap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SLNhap")
    private Integer sLNhap;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DGNhap")
    private Float dGNhap;
    @JoinColumn(name = "MaPN", referencedColumnName = "MaPN")
    @ManyToOne(optional = false)
    private Phieunhap maPN;
    @JoinColumn(name = "MaNCC", referencedColumnName = "MaNCC")
    @ManyToOne(optional = false)
    private Nhacungcap maNCC;
    @JoinColumn(name = "MaHang", referencedColumnName = "MaHang")
    @ManyToOne(optional = false)
    private Hanghoa maHang;

    public Ttphieunhap() {
    }

    public Ttphieunhap(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSLNhap() {
        return sLNhap;
    }

    public void setSLNhap(Integer sLNhap) {
        this.sLNhap = sLNhap;
    }

    public Float getDGNhap() {
        return dGNhap;
    }

    public void setDGNhap(Float dGNhap) {
        this.dGNhap = dGNhap;
    }

    public Phieunhap getMaPN() {
        return maPN;
    }

    public void setMaPN(Phieunhap maPN) {
        this.maPN = maPN;
    }

    public Nhacungcap getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(Nhacungcap maNCC) {
        this.maNCC = maNCC;
    }

    public Hanghoa getMaHang() {
        return maHang;
    }

    public void setMaHang(Hanghoa maHang) {
        this.maHang = maHang;
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
        if (!(object instanceof Ttphieunhap)) {
            return false;
        }
        Ttphieunhap other = (Ttphieunhap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Ttphieunhap[ id=" + id + " ]";
    }

    public static void InsertDB(String MaPN, String MaNCC, String MaHang, String SLNhap, String DGNhap) throws ClassNotFoundException, SQLException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "INSERT INTO `ttphieunhap`(`MaPN`, `MaNCC`, `MaHang`, `SLNhap`, `DGNhap`) VALUES ('" + MaPN + "','" + MaNCC + "','" + MaHang + "','" + SLNhap + "','" + DGNhap + "')";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void UpdateDB(String ID, String MaPN, String MaNCC, String MaHang, String SLNhap, String DGNhap) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "UPDATE `ttphieunhap` SET `MaPN`='" + MaPN + "',`MaNCC`='" + MaNCC + "',`MaHang`='" + MaHang + "',`SLNhap`='" + SLNhap + "',`DGNhap`='" + DGNhap + "' WHERE ID='" + ID + "'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void DeleteDB(String ID) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "DELETE FROM `ttphieunhap` WHERE ID='" + ID + "'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static ArrayList<Ttphieunhap> FindByID(String ID) throws SQLException, ClassNotFoundException {
        ArrayList<Ttphieunhap> lstRes = new ArrayList<>();
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Ttphieunhap item : model.ttphieunhaps) {
            if (item.getMaHang().getTenHang().toLowerCase().trim().contains(ID.toLowerCase())) {
                lstRes.add(item);
            }
        }
        return lstRes;
    }

    public static boolean isIdExist(String ID) throws ClassNotFoundException, SQLException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Ttphieunhap item : model.ttphieunhaps) {
            if (item.getMaHang().getTenHang().toLowerCase().equals(ID.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
