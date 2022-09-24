/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Model.*;
import View.LoginView;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author H
 */
public class Nhom10_QuanLyKho_Java {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        new LoginView().setVisible(true);
    }
}
