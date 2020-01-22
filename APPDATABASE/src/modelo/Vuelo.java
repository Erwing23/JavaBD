/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author erwin
 */
public class Vuelo {
    private String id;
    private String nasiento;
    private String claseb;
    private String fechasalida;

    public Vuelo(String id, String nasiento, String claseb, String fechasalida) {
        this.id = id;
        this.nasiento = nasiento;
        this.claseb = claseb;
        this.fechasalida = fechasalida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNasiento() {
        return nasiento;
    }

    public void setNasiento(String nasiento) {
        this.nasiento = nasiento;
    }

    public String getClaseb() {
        return claseb;
    }

    public void setClaseb(String claseb) {
        this.claseb = claseb;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    

    
    
    
    
}
