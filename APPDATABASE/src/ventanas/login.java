/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author erwin
 */
public class login {
    private VBox root ;
    public login(){
        genera();
    
    }
    public void genera(){
        
        
        root= new VBox();
        Label l1 = new Label("Reservas Ecuador");
        l1.setStyle("-fx-font-size:4em;-fx-text-fill:BLUE;-fx-font-weight:bolder;");
        root.getChildren().add(l1);
        HBox h1 = new HBox();
        ImageView img1 = new ImageView();
        ImageView img2 = new ImageView();
        Image i1 = new Image(getClass().getResource("/recursos/logo.PNG").toString());
        Image i2 = new Image(getClass().getResource("/recursos/espol.png").toString());
        img1.setImage(i1);
        img2.setImage(i2);
        h1.getChildren().addAll(img1,img2);
        h1.setAlignment(Pos.CENTER);
        h1.setPadding(new Insets(000,0,40,0));
        HBox h2 = new HBox();
        Button b1 = new Button("Registrarse");
        Button b2 = new Button("Ingresar");
        h2.getChildren().addAll(b1,b2);
        h2.setSpacing(40);
        h2.setAlignment(Pos.CENTER);
        root.getChildren().addAll(h1,h2);
      root.setStyle("-fx-background-color:WHITE;");
        b1.setStyle("-fx-font-size:20px;-fx-text-fill:white;-fx-background-color:darkslateblue;");
        b2.setStyle("-fx-font-size:20px;-fx-text-fill:white;-fx-background-color:darkslateblue;");
        root.setAlignment(Pos.CENTER);
        b1.setOnAction(e->{
            registro r = new registro();
           b1.getScene().setRoot(r.getRoot());
        
        });
    }
    public VBox getRoot(){
        
        
        
        return root;
    
    
    }
    
    
}
