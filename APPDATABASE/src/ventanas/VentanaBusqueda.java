/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Cliente;
import modelo.TipoReservas;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import modelo.Reserva;

/**
 *
 * @author laptop
 */
public class VentanaBusqueda {
    VBox root;

    ComboBox cmbReserva;
    
    public VentanaBusqueda(){
        createContent();
    }
       private void createContent(){
        root = new VBox(5);
        
        Label titulo = new Label("Reservacion");
        titulo.setId("titulo");
        Label reserva = new Label("Que tipo de reserva deseas?");
        root.setPadding(new Insets(25));
        ComboBox cmbReserva = new ComboBox();
        cmbReserva.getItems().setAll(TipoReservas.values());
        root.getChildren().add(titulo);
        root.getChildren().add(cmbReserva);
        HBox cntBotones = new HBox(5);
        Button btnGuardar = new Button("Consultar");
        btnGuardar.setOnAction(e->{ 
        });
        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e->{btnCerrar.getScene().getWindow().hide();});
        
     
        cntBotones.getChildren().addAll(btnGuardar,btnCerrar);
        titulo.setAlignment(Pos.CENTER);
        
        cntBotones.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);
        
    }

    public VBox getRoot() {
        return root;
    }
           
}
