/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author laptop
 */
public class Conexion {
      Connection con;
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booking","root","root");
        } catch (Exception e) {
            System.err.println("Error:" +e);
        }
    }
    public static void main(String[] args) {
        Conexion cn=new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st=cn.con.createStatement();
            rs=st.executeQuery("select * from aerolinea");
            while (rs.next()) {                
                System.out.println(rs.getInt("idAerolinea")+" " +rs.getString("idAvion")+" " +rs.getString("Nombre"));
            }
            cn.con.close();
        } catch (Exception e) {
        }
        
    }
}
    

