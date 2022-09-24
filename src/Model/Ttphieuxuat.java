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
@Table(name = "ttphieuxuat")

@NamedQueries({
    @NamedQuery(name = "Ttphieuxuat.findAll", query = "SELECT t FROM Ttphieuxuat t"),
    @NamedQuery(name = "Ttphieuxuat.findById", query = "SELECT t FROM Ttphieuxuat t WHERE t.id = :id"),
    @NamedQuery(name = "Ttphieuxuat.findBySLXuat", query = "SELECT t FROM Ttphieuxuat t WHERE t.sLXuat = :sLXuat"),
    @NamedQuery(name = "Ttphieuxuat.findByDGXuat", query = "SELECT t FROM Ttphieuxuat t WHERE t.dGXuat = :dGXuat")})
public class Ttphieuxuat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SLXuat")
    private Integer sLXuat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DGXuat")
    private Float dGXuat;
    @JoinColumn(name = "MaPX", referencedColumnName = "MaPX")
    @ManyToOne
    private Phieuxuat maPX;
    @JoinColumn(name = "MaHang", referencedColumnName = "MaHang")
    @ManyToOne(optional = false)
    private Hanghoa maHang;
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne(optional = false)
    private Khachhang maKH;

    public Ttphieuxuat() {
    }

    public Ttphieuxuat(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSLXuat() {
        return sLXuat;
    }

    public void setSLXuat(Integer sLXuat) {
        this.sLXuat = sLXuat;
    }

    public Float getDGXuat() {
        return dGXuat;
    }

    public void setDGXuat(Float dGXuat) {
        this.dGXuat = dGXuat;
    }

    public Phieuxuat getMaPX() {
        return maPX;
    }

    public void setMaPX(Phieuxuat maPX) {
        this.maPX = maPX;
    }

    public Hanghoa getMaHang() {
        return maHang;
    }

    public void setMaHang(Hanghoa maHang) {
        this.maHang = maHang;
    }

    public Khachhang getMaKH() {
        return maKH;
    }

    public void setMaKH(Khachhang maKH) {
        this.maKH = maKH;
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
        if (!(object instanceof Ttphieuxuat)) {
            return false;
        }
        Ttphieuxuat other = (Ttphieuxuat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Ttphieuxuat[ id=" + id + " ]";
    }

    public static void InsertDB(String MaKH, String MaHang, String SLXuat, String DGXuat, String MaPX) throws ClassNotFoundException, SQLException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "INSERT INTO `ttphieuxuat`(`MaKH`, `MaHang`, `SLXuat`, `DGXuat`, `MaPX`) VALUES ('"+MaKH+"','"+MaHang+"','"+SLXuat+"','"+DGXuat+"','"+MaPX+"')";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void UpdateDB(String ID,String MaKH, String MaHang, String SLXuat, String DGXuat, String MaPX) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "UPDATE `ttphieuxuat` SET `MaKH`='"+MaKH+"',`MaHang`='"+MaHang+"',`SLXuat`='"+SLXuat+"',`DGXuat`='"+DGXuat+"',`MaPX`='"+MaPX+"' WHERE ID='" + ID + "'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void DeleteDB(String ID) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "DELETE FROM `ttphieuxuat` WHERE ID='" + ID + "'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static ArrayList<Ttphieuxuat> FindByID(String ID) throws SQLException, ClassNotFoundException {
        ArrayList<Ttphieuxuat> lstRes = new ArrayList<>();
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Ttphieuxuat item : model.ttphieuxuats) {
            if (item.getMaHang().getTenHang().toLowerCase().contains(ID.toLowerCase())) {
                lstRes.add(item);
            }
        }
        return lstRes;
    }

    public static boolean isIdExist(String ID) throws ClassNotFoundException, SQLException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Ttphieuxuat item : model.ttphieuxuats) {
            if (item.getMaHang().getTenHang().toLowerCase().trim().equals(ID.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
