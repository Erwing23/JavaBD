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
import modelo.Reserva;

/**
 *
 * @author laptop
 */
public class VentanaBusqueda {
    VBox root;
    TextField email;
    
    TextField txtNombres;
    TextField txtApellidos;
    TextField txtEmail;
   

    ComboBox cmbEstado;
    
    public VentanaBusqueda(){
        createContent();
    }
       private void createContent(){
        root = new VBox(5);
        
        Label titulo = new Label("Reservacion");
        titulo.setId("titulo");
    
        
      /*  HBox cntCedula = new HBox(5);
        Label lblCedula = new Label("Cedula");
        txtCedula = new TextField();
        
        
        
        //cntCedula.getChildren().addAll(lblCedula,txtCedula);
 
        form1.add(lblCedula,0,0);
        form1.add(txtCedula,1,0);*/
       GridPane form1 = new GridPane();
     
        
        HBox cntNombres = new HBox(5);
        Label lblNombres = new Label("Nombres");
        txtNombres = new TextField();
        form1.add(lblNombres, 0, 1);
        form1.add(txtNombres, 1, 1);
        //cntNombres.getChildren().addAll(lblNombres,txtNombres);
     
        

        Label lblApellidos = new Label("Apellidos");
        txtApellidos = new TextField();
   
        Label lblEmail = new Label("Email");
        txtEmail = new TextField();
  
        form1.add(lblApellidos,2,1);
        form1.add(txtApellidos,3,1);
        form1.add(lblEmail,0,2);
        form1.add(txtEmail,1,2);
    
        
        form1.setVgap(15);
        form1.setHgap(25);
        form1.setPadding(new Insets(25));
        
      
        
        
        HBox cntBotones = new HBox(5);
        Button btnGuardar = new Button("Consultar");
        btnGuardar.setOnAction(e->{
            manejarFormulario();
           
            
        });
        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e->{btnCerrar.getScene().getWindow().hide();});
        
     
        cntBotones.getChildren().addAll(btnGuardar,btnCerrar);
        titulo.setAlignment(Pos.CENTER);
        form1.setAlignment(Pos.CENTER);
        cntBotones.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titulo,form1,cntBotones);
        root.setAlignment(Pos.CENTER);
        
    }

    public VBox getRoot() {
        return root;
    }
           private void manejarFormulario(){
    
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String email = txtEmail.getText();
        

        if(nombres.trim().length() >0 && apellidos.trim().length() >0&& email.trim().length()>0){
            Cliente cliente = new Cliente(nombres,apellidos,email);
            System.out.println(cliente);
   
         
            
            
             }

        
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Ingreso de Reserva");
            alert.setContentText("Todos los campos son obligatorios");
            alert.showAndWait();
            
        }
    }
    
}
