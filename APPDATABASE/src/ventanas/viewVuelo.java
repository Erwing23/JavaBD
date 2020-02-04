/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Conexion;
import modelo.Vuelo;

/**
 *
 * @author erwin
 */
public class viewVuelo {
     private  VBox root ;
    public viewVuelo(){
        genera();
    
    }
    public void genera(){
        
        
        
        root= new VBox();
        
        VBox V = new VBox();
       
        StackPane s = new StackPane();
        GridPane g1 = new GridPane();
        Button b1 = new Button("RESERVAR");
      Button b2 = new Button("Volver");
      HBox hbo = new HBox();
      hbo.getChildren().addAll(b1,b2);
      hbo.setSpacing(25);
      hbo.setAlignment(Pos.CENTER);
     V.getChildren().add(hbo);
        s.getChildren().add(g1);
        int c = 0;
        int f = 0;
        Label l1 = new Label("ID");
        
        Label l2 = new Label("Número de avion");
        
        Label l3 = new Label("Tipo");
        
        Label l4 = new Label("Fecha Vuelo");
        
        
        g1.add(l1, 0, 0);
        g1.add(l2, 1, 0);
        g1.add(l3, 2, 0);
        g1.add(l4, 3, 0);
        
        ToggleGroup gb = new ToggleGroup();
         // INSTRUCCION SQL   
      Conexion cn2=new Conexion();
        Statement st;
        ResultSet rs1;
        String idR=null;
          String nomR=null;
            String tip=null;
              String fe=null;
                String dR=null;
        try {
            st=cn2.con.createStatement();
            rs1=st.executeQuery("select * from Vuelo ");
            while (rs1.next()) { 
                c=0;
                f+=1;
                //`Vuelo` (`idVuelo`,`NroAvion`,`Tipo`,`FechaVuelo`,
                idR= rs1.getString("idVuelo");
                nomR= rs1.getString("NroAvion");
                 tip= rs1.getString("Tipo");
                  fe= rs1.getString("FechaVuelo");
                   
                   RadioButton r1 = new RadioButton(idR);
                   r1.setToggleGroup(gb);
                   HBox h2 = new HBox();
                   System.out.println("Encontrado");
                   g1.add(r1,c,f);
                    c+=1;
                   g1.add(new Label(nomR),c,f);
                    c+=1; 
                   g1.add(new Label(tip),c,f);
                    c+=1;
                   g1.add(new Label(fe),c,f);
                    
                           
                   //c+=1;
              //  System.out.println(rs.getInt("idAerolinea")+" " +rs.getString("idAvion")+" " +rs.getString("Nombre"));
            }
            
            cn2.con.close();
            
            
          
        } catch (Exception se) {
        }//
      V.setStyle("-fx-background-color:WHITE;");
      
     V.getChildren().add(s);
      
     
 root.getChildren().add(V);

       b1.setStyle("-fx-font-size:20px;-fx-text-fill:white;-fx-background-color:darkslateblue;");
       b2.setStyle("-fx-font-size:20px;-fx-text-fill:white;-fx-background-color:darkslateblue;");
//        root.setAlignment(Pos.CENTER);
        b2.setOnAction(e->{
             VentanaPrincipal ventB = new VentanaPrincipal();
                   b2.getScene().setRoot(ventB.getRoot());
                   
         
        
        });
       
        
         b1.setOnAction(e->{
              
             RadioButton selectedRadioButton = (RadioButton) gb.getSelectedToggle();
String ids = selectedRadioButton.getText();
             System.out.println(ids+" ID=");
             Stage sr = new Stage();
            
      // INSTRUCCION SQL   
      Conexion cn3=new Conexion();
        Statement st3;
        ResultSet rs3;
        
        
        try {
            st3=cn3.con.createStatement();
            rs3=st3.executeQuery("select * from Restaurante where idRestaurante ='"+ids+"' ");
            while (rs3.next()) {  
                
               
              
              //  System.out.println(rs.getInt("idAerolinea")+" " +rs.getString("idAvion")+" " +rs.getString("Nombre"));
            }
            
            cn3.con.close();
             //INSTRUCCION SQL              
        Conexion cn=new Conexion();
        Statement st1;
         
        int rs;
         
        try {
            st1=cn.con.createStatement();
           
           //(`Reserva` (`idReserva`,`FechaLlegada`,`FechaSalida`,`idCliente`,`idEmpleado`) VALUES (1000,"20-01-06","20-02-03",269,328);
           int s1 = 2000;
           String s2 = registro.c.getId();
           java.sql.Date s3 = new java.sql.Date(0,0,0);
           java.sql.Date s31 = new java.sql.Date(1,1,1);
           
           int s4 = 2004;
           int ide = 328;
            rs=st1.executeUpdate("INSERT INTO Reserva (idReserva,idCliente,FechaLlegada,FechaSalida,idEmpleado) VALUES('" +s1+ "','" + s2 + "','" + s3 + "','" + s31 + "','" + ide + "' )");
            System.out.println("insert");
            System.out.println(rs);
          
            
            cn.con.close();
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
           
            
           VentanaPrincipal ventB = new VentanaPrincipal();
                   b1.getScene().setRoot(ventB.getRoot());
        } catch (Exception se) {
        }//
             
             
            
                   
         
        
        });
        
        g1.setVgap(25);
        g1.setHgap(25);
    }
    public VBox getRoot(){
        
        
        
        return root;
    
    
    }
    
    
}

   


