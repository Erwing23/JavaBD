/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.ResultSet;
import java.sql.Statement;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modelo.Cliente;
import modelo.Conexion;

/**
 *
 * @author erwin
 */
public class Ingreso {
    private VBox root ;
    public static Cliente c ;
    public Ingreso(){
        genera();
    
    }
    public void genera(){
        root= new VBox();
      
           
             Label l3 = new Label("Ingrese su Email: ");
             
             
                   l3.setStyle("-fx-font-size:2em;-fx-text-fill:BLUE;-fx-font-weight:bolder;");
                  
                 
         
          TextField t3 = new TextField();
        
              GridPane g = new GridPane();
             
                g.add(l3, 0, 2);
                
                  Button b1 = new Button("LOGIN");
          
             
              g.add(t3, 2, 2);
             
              g.add(b1, 1,4 );
         g.setVgap(25);
         g.setHgap(40);
         g.setAlignment(Pos.CENTER);
              root.getChildren().add(g);
              root.setAlignment(Pos.CENTER);
              
              b1.setOnAction(e->{
                 
                  String s3 = t3.getText().toString();
                 
                  if(    !s3.equals("")    ){
                      System.out.println("vamos bien");
                     
        
             // INSTRUCCION SQL   
      Conexion cn2=new Conexion();
        Statement st;
        ResultSet rs1;
        String idc="";
        String nom=null;
        String ape = null;
        String ema=null;
        String cel =null;
        try {
            st=cn2.con.createStatement();
            rs1=st.executeQuery("select * from cliente where  Email ='"+s3+"'");
            while (rs1.next()) {  
                
                idc= rs1.getString("idCliente");
                 nom= rs1.getString("Nombres");
                  ape= rs1.getString("Apellidos");
                   ema= rs1.getString("Email");
                    cel= rs1.getString("Celular");
                
              //  System.out.println(rs.getInt("idAerolinea")+" " +rs.getString("idAvion")+" " +rs.getString("Nombre"));
            }
            
            cn2.con.close();
            if(idc.equals("")){
                System.out.println("vamos mal");
                   Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Ingreso de Cliente");
            alert.setContentText("NO EXISTE ESE CLIENTE");
            alert.showAndWait();
            
            }else{
                Cliente cp= new Cliente(nom,ape,ema);
              cp.setId(idc);
              registro.c=cp; 
                
             VentanaPrincipal ventB = new VentanaPrincipal();
                   b1.getScene().setRoot(ventB.getRoot());
            
            }
            
          
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
