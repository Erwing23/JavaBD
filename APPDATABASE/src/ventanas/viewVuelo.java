/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modelo.Vuelo;

/**
 *
 * @author erwin
 */
public class viewVuelo {

    private BorderPane root;
    private Stage s;

    public viewVuelo() {
        create();
    }

    public void create() {
        root = new BorderPane();
        TableView<Vuelo> table = new TableView<>();
        TableColumn<Vuelo, String> idCol = new TableColumn<>("ID DE VUELO");
        TableColumn<Vuelo, String> asientoCol = new TableColumn<>("Número de Asiento");
        TableColumn<Vuelo, String> clase = new TableColumn<>("Clase");
        TableColumn<Vuelo, String> fechas = new TableColumn<>("Fecha de salida");
        //
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        asientoCol.setCellValueFactory(new PropertyValueFactory<>("Asiento"));
        clase.setCellValueFactory(new PropertyValueFactory<>("Clase"));
        fechas.setCellValueFactory(new PropertyValueFactory<>("Fecha de partida"));
        //
        // fechas.setSortType(TableColumn.SortType.ASCENDING);
        ObservableList<Vuelo> list = getVuelolist();
        
        table.setItems(list);
        table.getColumns().addAll(idCol, asientoCol, clase, fechas);
        Button next = new Button("Continuar");
        
                
        root.getChildren().addAll(table);

    }

    public BorderPane getRoot() {
        return root;
    }

    public ObservableList<Vuelo> getVuelolist() {
        Vuelo v1 = new Vuelo("1", "1", "Ejecutivo", "1/21/20");
        Vuelo v2 = new Vuelo("1", "2", "Economico", "1/21/20");
        Vuelo v3 = new Vuelo("2", "1", "Ejecutivo", "1/21/20");
        Vuelo v4 = new Vuelo("2", "2", "Economico", "1/21/20");

        ObservableList<Vuelo> list = FXCollections.observableArrayList(v1, v2, v3, v4);
        return list;
    }

}
