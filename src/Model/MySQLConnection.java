/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;

/**
 *
 * @author H
 */
public class MySQLConnection {

    private final Connection conn;

    public MySQLConnection(String url) throws ClassNotFoundException, SQLException {
        this.conn = DriverManager.getConnection(url, "root", "");
    }

    public MySQLConnection() throws ClassNotFoundException, SQLException {

        //Tạo kết nối
        String url = "jdbc:mysql://localhost:3306/quanlykho";//Đường dẫn vào Data Base
        this.conn = DriverManager.getConnection(url, "root", "");
    }

    public ResultSet getData(String tbname) throws SQLException {

        ResultSet rs = null;
        //Tạo đối tượng Statement()
        Statement ts = this.conn.createStatement();
        String sql = "select * from " + tbname;
        //Két quả trả về được lưu trong rs
        rs = ts.executeQuery(sql);
        return rs;

    }

    public void Update(String usn, String pw) throws SQLException {
        Statement sta = this.conn.createStatement();
        String sql1 = "Update myuser set username='" + usn + "' where username ='" + usn + "'";
        String sql2 = "Update myuser set password='" + pw + "' where username ='" + usn + "'";
        sta.executeUpdate(sql2);
        sta.executeUpdate(sql1);
    }

    public void Insert(String usn, String pw) throws SQLException {
        Statement sta = this.conn.createStatement();
        String sql1 = "Insert myuser values('" + usn + "'  ,'" + pw + "')";
        sta.executeUpdate(sql1);
    }

    public void Delete(String usn) throws SQLException {
        Statement sta = this.conn.createStatement();
        String sql = "delete myuser where username ='" + usn + "'";
        sta.executeUpdate(sql);
    }

    public void Close() throws SQLException {
        if (this.conn != null) {
            this.conn.close();
        }
    }

    public Connection getConnection(){
        return conn;
    }
            
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        MySQLConnection kn = new MySQLConnection("jdbc:mysql://localhost:3306/quanlykho");
        ResultSet rs = null;
        rs = kn.getData("hanghoa");
        while (rs.next()) {

        System.out.print(rs.getString(1)+ "   ");
        System.out.print(rs.getString(2)+ "   ");
        System.out.print(rs.getString(3)+ "   ");
        System.out.print(rs.getString(4)+ "   ");
        System.out.print(rs.getString(5)+ "   ");
        System.out.print(rs.getString(6)+ "   ");
        System.out.println("");
        }
    }
        
}
