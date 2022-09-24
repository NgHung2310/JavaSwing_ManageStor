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
@Table(name = "nhacungcap")

@NamedQueries({
    @NamedQuery(name = "Nhacungcap.findAll", query = "SELECT n FROM Nhacungcap n"),
    @NamedQuery(name = "Nhacungcap.findByMaNCC", query = "SELECT n FROM Nhacungcap n WHERE n.maNCC = :maNCC"),
    @NamedQuery(name = "Nhacungcap.findByTenNCC", query = "SELECT n FROM Nhacungcap n WHERE n.tenNCC = :tenNCC"),
    @NamedQuery(name = "Nhacungcap.findByDiaChiNCC", query = "SELECT n FROM Nhacungcap n WHERE n.diaChiNCC = :diaChiNCC"),
    @NamedQuery(name = "Nhacungcap.findBySdtNCC", query = "SELECT n FROM Nhacungcap n WHERE n.sdtNCC = :sdtNCC"),
    @NamedQuery(name = "Nhacungcap.findByMailNCC", query = "SELECT n FROM Nhacungcap n WHERE n.mailNCC = :mailNCC")})
public class Nhacungcap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaNCC")
    private String maNCC;
    @Column(name = "TenNCC")
    private String tenNCC;
    @Column(name = "DiaChiNCC")
    private String diaChiNCC;
    @Column(name = "SdtNCC")
    private String sdtNCC;
    @Column(name = "MailNCC")
    private String mailNCC;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maNCC")
    private Collection<Ttphieunhap> ttphieunhapCollection;

    public Nhacungcap() {
    }

    public Nhacungcap(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChiNCC() {
        return diaChiNCC;
    }

    public void setDiaChiNCC(String diaChiNCC) {
        this.diaChiNCC = diaChiNCC;
    }

    public String getSdtNCC() {
        return sdtNCC;
    }

    public void setSdtNCC(String sdtNCC) {
        this.sdtNCC = sdtNCC;
    }

    public String getMailNCC() {
        return mailNCC;
    }

    public void setMailNCC(String mailNCC) {
        this.mailNCC = mailNCC;
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
        hash += (maNCC != null ? maNCC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhacungcap)) {
            return false;
        }
        Nhacungcap other = (Nhacungcap) object;
        if ((this.maNCC == null && other.maNCC != null) || (this.maNCC != null && !this.maNCC.equals(other.maNCC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Nhacungcap[ maNCC=" + maNCC + " ]";
    }

    public static void InsertDB(String MaNCC, String TenNCC, String DiaChiNCC, String SdtNCC, String MailNCC) throws ClassNotFoundException, SQLException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "INSERT INTO `nhacungcap`(`MaNCC`, `TenNCC`, `DiaChiNCC`, `SdtNCC`, `MailNCC`) VALUES ('" + MaNCC + "','" + TenNCC + "','" + DiaChiNCC + "','" + SdtNCC + "','" + MailNCC + "')";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void UpdateDB(String MaNCC, String MaNCCNew, String TenNCC, String DiaChiNCC, String SdtNCC, String MailNCC) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "UPDATE `nhacungcap` SET `MaNCC`='" + MaNCCNew + "',`TenNCC`='" + TenNCC + "',`DiaChiNCC`='" + DiaChiNCC + "',`SdtNCC`='" + SdtNCC + "',`MailNCC`='" + MailNCC + "' WHERE `MaNCC`='" + MaNCC + "'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static void DeleteDB(String MaNCC) throws SQLException, ClassNotFoundException {
        MySQLConnection kn = new MySQLConnection();
        Statement sta = kn.getConnection().createStatement();
        String sql = "DELETE FROM `nhacungcap` WHERE `MaNCC`='" + MaNCC + "'";
        sta.executeUpdate(sql);
        kn.Close();
    }

    public static Nhacungcap FindByID(String ID) throws SQLException, ClassNotFoundException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Nhacungcap item : model.nhacungcaps) {
            if (item.getMaNCC().toLowerCase().contains(ID.toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    public static boolean isIdExist(String ID) throws ClassNotFoundException, SQLException {
        QuanLyKhoModel model = new QuanLyKhoModel();
        for (Nhacungcap item : model.nhacungcaps) {
            if (item.getMaNCC().toLowerCase().trim().equals(ID.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
