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
import javafx.stage.Stage;
import modelo.Reserva;

/**
 *
 * @author laptop
 */
public class VentanaPrincipal {
    VBox root;
    TextField email;
    TextField celular;
    TextField txtNombres;
    TextField txtApellidos;
    DatePicker fechallegada;
    DatePicker fechasalida;
    TextField txtemail;
    TextField txttelefono;
    public static String  city;

    ComboBox cmbEstado;
    
    public VentanaPrincipal(){
        createContent();
    }
       private void createContent(){
        root = new VBox(5);
        
        Label titulo = new Label("Reservacion");
        titulo.setId("titulo");
        Label lblEstado = new Label("Tipo de Reserva");
        cmbEstado = new ComboBox();
        
        cmbEstado.getItems().setAll(TipoReservas.values());
        
      /*  HBox cntCedula = new HBox(5);
        Label lblCedula = new Label("Cedula");
        txtCedula = new TextField();
        
        
        
        //cntCedula.getChildren().addAll(lblCedula,txtCedula);
 
        form1.add(lblCedula,0,0);
        form1.add(txtCedula,1,0);*/
    
        fechallegada = new DatePicker();
        Label lblLlegada = new Label("Fecha de Llegada");
      // form1.add(lblLlegada,0,4);
        //form1.add(fechallegada,1,4);
        fechasalida = new DatePicker();
        Label lblSalida = new Label("Fecha de Salida");
        //form1.add(lblSalida,2,4);
        //form1.add(fechasalida,3,4);
        
        
        HBox cntBotones = new HBox(5);
        Button btnGuardar = new Button("Siguiente");
       
        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e->{btnCerrar.getScene().getWindow().hide();});
        Button btnBuscar = new Button("Consultar mis reservas");
        btnBuscar.setOnAction(e->{
            VentanaBusqueda ventB = new VentanaBusqueda();
            btnBuscar.getScene().setRoot(ventB.getRoot());
            
        });
     
        cntBotones.getChildren().addAll(btnGuardar,btnCerrar,btnBuscar);
        titulo.setAlignment(Pos.CENTER);
       // form1.setAlignment(Pos.CENTER);
        cntBotones.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titulo);
        root.getChildren().addAll(lblEstado,cmbEstado);
       
       
        root.setSpacing(25);
        GridPane g1 = new GridPane();
         HBox hb = new HBox();
         
        
        
       cmbEstado.setOnAction(e->{
           hb.getChildren().clear();
          g1.getChildren().clear();
            switch (cmbEstado.getSelectionModel().getSelectedItem().toString()) {
                case "RESTAURANTE":
                    System.out.println("hello");
                     btnGuardar.setOnAction(a->{
                         vistaRest v = new vistaRest();
                         btnGuardar.getScene().setRoot(v.getRoot());
           
           
            
        });
                    break;
                case "HOTEL":
                    HBox h = new HBox();
                    Label l2 = new Label("Escriba la ciudad: ");
                    TextField t1= new TextField();
                    h.getChildren().addAll(l2,t1);
                    hb.getChildren().add(h);
                    break;
                case "VUELO":
                     btnGuardar.setOnAction(a->{
                         viewVuelo v = new viewVuelo();
                         btnGuardar.getScene().setRoot(v.getRoot());
           
           
            
        });
                    break;
                default:
                    break;
            }
            hb.getChildren().add(cntBotones);
        
       
       });
        root.getChildren().add(hb);
         hb.setAlignment(Pos.CENTER);
       root.setSpacing(25);
         root.setAlignment(Pos.CENTER);
         g1.setAlignment(Pos.CENTER);
    }

    public VBox getRoot() {
        return root;
    }
           private void manejarFormulario(){
    
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String email = txtemail.getText();
        String telefono = txttelefono.getText();
        TipoReservas tiporeserva = (TipoReservas) cmbEstado.getValue();
        LocalDate fechLlegada = (LocalDate) fechallegada.getValue();
        LocalDate fechSalida = (LocalDate) fechasalida.getValue();
        LocalDate lclDate = LocalDate.now();
        
        if(nombres.trim().length() >0 && apellidos.trim().length() >0&&email.trim().length()>0&&telefono.trim().length()>0&&tiporeserva!=null&&fechLlegada!= null&&fechSalida!=null){
            Cliente cliente = new Cliente(nombres,apellidos,email,telefono);
            System.out.println(cliente);
            Reserva reserva = new Reserva(fechSalida,fechLlegada,lclDate);
            System.out.println(reserva);
            
            
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
