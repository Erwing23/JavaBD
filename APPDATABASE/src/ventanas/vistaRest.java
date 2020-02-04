/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javafx.geometry.Insets;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Conexion;
import static ventanas.registro.c;

/**
 *
 * @author erwin
 */
public class vistaRest {
    private  ScrollPane root ;
    public vistaRest(){
        genera();
    
    }
    public void genera(){
        
        
        
        VBox V = new VBox();
       
        StackPane s = new StackPane();
        GridPane g1 = new GridPane();
        Button b1 = new Button("RESERVAR");
      Button b2 = new Button("Volver");
      HBox hbo = new HBox();
      hbo.getChildren().addAll(b1,b2);
      hbo.setSpacing(25);
      hbo.setAlignment(Pos.CENTER);
  
     s.getChildren().add(g1);
        int c = 0;
        int f = 0;
        Label l1 = new Label("ID");
        
        Label l2 = new Label("Nombre");
        
        Label l3 = new Label("Mesas");
        
        Label l4 = new Label("Puntaje");
        
        Label l5 = new Label("Direccion");
        g1.add(l1, 0, 0);
        g1.add(l2, 1, 0);
        g1.add(l3, 2, 0);
        g1.add(l4, 3, 0);
        g1.add(l5, 4, 0);
        ToggleGroup gb = new ToggleGroup();
         // INSTRUCCION SQL   
      Conexion cn2=new Conexion();
        Statement st;
        ResultSet rs1;
        String idR=null;
          String nomR=null;
            String mesR=null;
              String pR=null;
                String dR=null;
        try {
            st=cn2.con.createStatement();
            rs1=st.executeQuery("select * from restaurante where MesasDisp <>0; ");
            while (rs1.next()) { 
                c=0;
                f+=1;
                //idRestaurante`,`Nombre`,`MesasDisp`,`Puntuacion`,`Direccion
                idR= rs1.getString("idRestaurante");
                nomR= rs1.getString("Nombre");
                 mesR= rs1.getString("MesasDisp");
                  pR= rs1.getString("Puntuacion");
                   dR= rs1.getString("Direccion");
                   RadioButton r1 = new RadioButton(idR);
                   r1.setToggleGroup(gb);
                   HBox h2 = new HBox();
                   
                   g1.add(r1,c,f);
                    c+=1;
                   g1.add(new Label(nomR),c,f);
                    c+=1; 
                   g1.add(new Label(mesR),c,f);
                    c+=1;
                   g1.add(new Label(pR),c,f);
                    c+=1;
                   g1.add(new Label(dR),c,f);
                           
                   //c+=1;
              //  System.out.println(rs.getInt("idAerolinea")+" " +rs.getString("idAvion")+" " +rs.getString("Nombre"));
            }
            
             cn2.con.close();
           
            
          
            
            
          
        } catch (Exception se) {
        }//
      V.setStyle("-fx-background-color:WHITE;");
      
     V.getChildren().add(s);
         V.getChildren().add(hbo);
     
root = new ScrollPane(V);

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
               
            
            
      // INSTRUCCION SQL   
      Conexion cn3=new Conexion();
        Statement st3;
        ResultSet rs3;
        Statement u1;
        String rName=null;
       
        String puntos=null;
        String Direccion=null;
        try {
            u1 = cn3.con.createStatement();
                int ru1 = u1.executeUpdate("update Restaurante set MesasDisp=MesasDisp-1 where idRestaurante ='"+ids+"' ");
            System.out.println(ru1);
            st3=cn3.con.createStatement();
            rs3=st3.executeQuery("select * from Restaurante where idRestaurante ='"+ids+"' ");
            while (rs3.next()) {
                rName = rs3.getString("Nombre");
                
                puntos = rs3.getString("Puntuacion");
                
                
                
                Direccion = rs3.getString("Direccion");
                
               
              
              //  System.out.println(rs.getInt("idAerolinea")+" " +rs.getString("idAvion")+" " +rs.getString("Nombre"));
            }
            
            cn3.con.close();
             //INSTRUCCION SQL              
        Conexion cn=new Conexion();
        Statement st1;
         
        int rs; 
        String s2 = registro.c.getId();
        int d=Integer.parseInt(s2);
           java.sql.Date s3 = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          java.sql.Date s31 = new java.sql.Date(Calendar.getInstance().getTime().getTime());
           
           int s4 = 2004;
           int ide = 328;
         
        try {
            st1=cn.con.createStatement();
           
           //(`Reserva` (`idReserva`,`FechaLlegada`,`FechaSalida`,`idCliente`,`idEmpleado`) VALUES (1000,"20-01-06","20-02-03",269,328);
          
          
            rs=st1.executeUpdate("INSERT INTO Reserva (idCliente,FechaLlegada,FechaSalida,idEmpleado) VALUES('" + d + "','" + s3 + "','" + s31 + "','" + ide + "' )");
            System.out.println("insert");
            System.out.println(rs);
          
            
            cn.con.close();
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
        Cliente clien = registro.c;
           
            
           VentanaPrincipal ventB = new VentanaPrincipal();
                   b1.getScene().setRoot(ventB.getRoot());
                   
                   Stage sm = new Stage();
                   VBox vp = new VBox();
                   Label lp = new Label("FELICIDADES "+clien.getNombre() +"");
                   Label lp1 = new Label("HA CONFIRMADO SU RESERVACION DE RESTAURANTE CON LOS DATOS: ");
                   GridPane grid = new GridPane();
                   Label lp2 = new Label("ID Cliente: "+clien.getId());
                   Label lp3 = new Label("Nombre del Restaurante: "+rName);
                   Label lp4 = new Label("Direccion: "+Direccion);
                   Label lp5 = new Label("Puntuación: "+puntos);
                   Label lp6 = new Label("Fecha de Reserva: "+s3);
                   
                   
                   grid.add(lp,1,0);
                   grid.add(lp1,1,1);
                   grid.add(lp2,0,2);
                   grid.add(lp3,0,3);
                   grid.add(lp4,0,4);
                   grid.add(lp5,0,5);
                   grid.add(lp6,0,6);
                   grid.setVgap(10);
                   grid.setHgap(10);
                   vp.getChildren().addAll(grid);
                   vp.setAlignment(Pos.CENTER);
                   vp.setPadding(new Insets(40,40,40,40));
                   Scene sc= new Scene(vp,800,500);
                   sm.setScene(sc);
                   sm.setTitle("FELICIDADES");
                   sm.show();
                   
        } catch (Exception se) {
        }//
             
             
            
                   
         
        
        });
        
        g1.setVgap(25);
        g1.setHgap(25);
    }
    public ScrollPane getRoot(){
        
        
        
        return root;
    
    
    }
    
    
}