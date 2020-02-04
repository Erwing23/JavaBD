/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.ResultSet;
import java.sql.Statement;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Cliente;
import modelo.Conexion;

/**
 *
 * @author erwin
 */
public class registro {
    private VBox root ;
    public static Cliente c ;
    public registro(){
        genera();
    
    }
    public void genera(){
        root= new VBox();
      
           Label l1 = new Label("Ingrese su Nombre: ");
            Label l2 = new Label("Ingrese su Apellido: ");
             Label l3 = new Label("Ingrese su Email: ");
              Label l4 = new Label("Ingrese su Celular: ");
               l1.setStyle("-fx-font-size:2em;-fx-text-fill:BLUE;-fx-font-weight:bolder;");
                 l2.setStyle("-fx-font-size:2em;-fx-text-fill:BLUE;-fx-font-weight:bolder;");
                   l3.setStyle("-fx-font-size:2em;-fx-text-fill:BLUE;-fx-font-weight:bolder;");
                     l4.setStyle("-fx-font-size:2em;-fx-text-fill:BLUE;-fx-font-weight:bolder;");
                 
          TextField t1 = new TextField();
          TextField t2 = new TextField();
          TextField t3 = new TextField();
          TextField t4 = new TextField();
              GridPane g = new GridPane();
              g.add(l1, 0, 0);
               g.add(l2, 0, 1);
                g.add(l3, 0, 2);
                 g.add(l4, 0, 3);
                  Button b1 = new Button("REGISTRO");
          
              g.add(t1, 2, 0);
              g.add(t2, 2, 1);
              g.add(t3, 2, 2);
              g.add(t4, 2, 3);
              g.add(b1, 1,4 );
         g.setVgap(25);
         g.setHgap(40);
         g.setAlignment(Pos.CENTER);
              root.getChildren().add(g);
              root.setAlignment(Pos.CENTER);
              
              b1.setOnAction(e->{
                  String s1 = t1.getText().toString();
                  String s2 = t2.getText().toString();
                  String s3 = t3.getText().toString();
                  String s4 = t4.getText().toString();
                  if( !s1.equals("")  &&!s2.equals("")  && !s3.equals("")  &&!s4.equals("")   ){
                      System.out.println("vamos bien");
                      c = new Cliente(s1,s2,s3,s4);
        
        //INSTRUCCION SQL              
        Conexion cn=new Conexion();
        Statement st1;
         
        int rs;
         
        try {
            st1=cn.con.createStatement();
           
            System.out.println(s1+""+s2+""+s3+""+s4);
            rs=st1.executeUpdate("INSERT INTO cliente (Nombres,Apellidos,Email,Celular) VALUES('" +s1+ "','" + s2 + "','" + s3 + "','" + s4  + "'  )");
            System.out.println("insert");
            System.out.println(rs);
          
            
            cn.con.close();
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
      // INSTRUCCION SQL   
      Conexion cn2=new Conexion();
        Statement st;
        ResultSet rs1;
        String idc=null;
        try {
            st=cn2.con.createStatement();
            rs1=st.executeQuery("select * from cliente where Nombres ='"+s1+"' and Apellidos ='"+s2+"' and Email ='"+s3+"'");
            while (rs1.next()) {  
                
                idc= rs1.getString("idCliente");
                System.out.println(rs1.getInt("idCliente"));
                System.out.println(rs1.getClass());
              //  System.out.println(rs.getInt("idAerolinea")+" " +rs.getString("idAvion")+" " +rs.getString("Nombre"));
            }
            
            cn2.con.close();
            c.setId(idc);
            
           VentanaPrincipal ventB = new VentanaPrincipal();
                   b1.getScene().setRoot(ventB.getRoot());
        } catch (Exception se) {
        }//
                  }else{
                      System.out.println("vamos mal");
                   Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Ingreso de Cliente");
            alert.setContentText("Todos los campos son obligatorios");
            alert.showAndWait();
                  }
                   
              
              
              });
              
        //root.getChildren().addAll(h1,h2);
      root.setStyle("-fx-background-color:WHITE;");
//        b1.setStyle("-fx-font-size:20px;-fx-text-fill:white;-fx-background-color:darkslateblue;");
//        b2.setStyle("-fx-font-size:20px;-fx-text-fill:white;-fx-background-color:darkslateblue;");
   }
    public VBox getRoot(){
        
        
        
        return root;
    
    
    }
    
    
}
