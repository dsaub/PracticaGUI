package me.elordenador.practicagui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import me.elordenador.practica6.Disco;
import me.elordenador.practica6.Ordenador;
import me.elordenador.practicagui.App;
import me.elordenador.practicagui.models.OrdenadoresModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrdenadorController implements Initializable {
    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<OrdenadoresModel, Integer> id;
    @FXML
    private TableColumn<OrdenadoresModel, String> marca;
    @FXML
    private TableColumn<OrdenadoresModel, String> modelo;
    @FXML
    private TableColumn<OrdenadoresModel, Boolean> estado;
    @FXML
    private TableColumn<OrdenadoresModel, Integer> ram;
    @FXML
    private TableColumn<OrdenadoresModel, String> procesador;
    @FXML
    private TableColumn<OrdenadoresModel, Integer> tamDisco;
    @FXML
    private TableColumn<OrdenadoresModel, String> disco;
    private ObservableList<OrdenadoresModel> ordenadoresModels;

    public OrdenadorController() {

        System.out.println("Opened controller");
        for (Ordenador ordenador : App.ordenadores) {
            ordenadoresModels.add(new OrdenadoresModel(
                    ordenador.getId(),
                    ordenador.getMarca(),
                    ordenador.getModelo(),
                    ordenador.getEstado(),
                    ordenador.getRam(),
                    ordenador.getProcesador(),
                    ordenador.getTamDisco(),
                    ordenador.getTipoDisco()
            ));

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        ram.setCellValueFactory(new PropertyValueFactory<>("ram"));
        procesador.setCellValueFactory(new PropertyValueFactory<>("procesador"));
        tamDisco.setCellValueFactory(new PropertyValueFactory<>("disco"));
        disco.setCellValueFactory(new PropertyValueFactory<>("disco"));

        tableView.setItems(ordenadoresModels);
    }

    public void addDevice(ActionEvent actionEvent) throws IOException {
        Stage stage = App.getInstance().getStage();

        VBox vbox = FXMLLoader.load(getClass().getClassLoader().getResource("addOrdenador.fxml"));
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
    }
}
