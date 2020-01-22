/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodb;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modelo.Vuelo;
import ventanas.VentanaPrincipal;
import ventanas.viewVuelo;

/**
 *
 * @author laptop
 */
public class ProyectoDB extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Connection con = null;
        try{
            con= DriverManager.getConnection("jbdc:mysql://localhost:3306/login","root","roo");
            if(con !=null)
                System.out.println("Exito de conexión");
        }catch(Exception e){
            System.out.println("Error en la conexión");
    }
      VentanaPrincipal ventp = new VentanaPrincipal();
    
     viewVuelo vuelos = new viewVuelo();
      //  Scene scene = new Scene(ventp.getRoot(),900,800);
        Scene scene = new Scene(vuelos.getRoot(),900,800);
        primaryStage.setTitle("RESERVA");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
