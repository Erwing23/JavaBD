/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author erwin
 */
public class vistaHotel {
    private VBox root ;
    public vistaHotel(String s){
        genera(s);
    
    }
    public void genera(String s){
        
        
        root= new VBox();
        
        
      root.setStyle("-fx-background-color:WHITE;");
//        b1.setStyle("-fx-font-size:20px;-fx-text-fill:white;-fx-background-color:darkslateblue;");
//        b2.setStyle("-fx-font-size:20px;-fx-text-fill:white;-fx-background-color:darkslateblue;");
//        root.setAlignment(Pos.CENTER);
//        b1.setOnAction(e->{
//            registro r = new registro();
//           b1.getScene().setRoot(r.getRoot());
//        
//        });
    }
    public VBox getRoot(){
        
        
        
        return root;
    
    
    }
    
    
}