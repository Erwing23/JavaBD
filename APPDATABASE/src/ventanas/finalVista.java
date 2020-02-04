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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Conexion;

/**
 *
 * @author erwin
 */
public class finalVista {
     private  ScrollPane root ;
    public finalVista(){
        genera();
    
    }
    public void genera(){
        
        
        
        root= new ScrollPane();
        
        VBox V = new VBox();
       
        StackPane s = new StackPane();
        GridPane g1 = new GridPane();
       
      Button b2 = new Button("Cerrar");
        b2.setOnAction(e->{b2.getScene().getWindow().hide();});
      HBox hbo = new HBox();
      hbo.getChildren().addAll(b2);
      hbo.setSpacing(25);
      hbo.setAlignment(Pos.CENTER);
    
        s.getChildren().add(g1);
        
        int c = 0;
        int f = 0;
        Label l1 = new Label("ID RESERVA");
        
        Label l2 = new Label("FechaLlegada");
        
        Label l3 = new Label("FechaSalida");
        
        Label l4 = new Label("ID Empleado");
        
        
        g1.add(l1, 0, 0);
        g1.add(l2, 1, 0);
        g1.add(l3, 2, 0);
        g1.add(l4, 3, 0);
        
       
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
            System.out.println(registro.c.getId());
            st=cn2.con.createStatement();
            rs1=st.executeQuery("select * from Reserva where idCliente ='"+registro.c.getId()+"' ");
            while (rs1.next()) { 
                c=0;
                f+=1;
                //`Vuelo` (`idVuelo`,`NroAvion`,`Tipo`,`FechaVuelo`,
                idR= rs1.getString("idReserva");
                nomR= rs1.getString("FechaLlegada");
                 tip= rs1.getString("FechaSalida");
                  fe= rs1.getString("idEmpleado");
                  
                   
                  
                  
                
                  
                   g1.add(new Label(idR),c,f);
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
       V.getChildren().add(hbo);
     
 root = new ScrollPane(V);

      
       b2.setStyle("-fx-font-size:20px;-fx-text-fill:white;-fx-background-color:darkslateblue;");
//        root.setAlignment(Pos.CENTER);
       
       
        
        
        
        g1.setVgap(25);
        g1.setHgap(25);
    }
    public ScrollPane getRoot(){
        
        
        
        return root;
    
    
    }
    
    
}
