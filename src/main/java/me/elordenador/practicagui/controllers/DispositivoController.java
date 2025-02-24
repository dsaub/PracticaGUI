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
import me.elordenador.practica6.Dispositivo;
import me.elordenador.practicagui.App;
import me.elordenador.practicagui.models.DispositivoModel;
import me.elordenador.practicagui.models.OrdenadoresModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DispositivoController implements Initializable {

    public static int selectedID = -1;
    @FXML
    private TableView table;

    @FXML
    private TableColumn<DispositivoModel, Integer> id;

    @FXML
    private TableColumn<DispositivoModel, String> marca, modelo;

    @FXML
    private TableColumn<DispositivoModel, Boolean> estado;


    @FXML
    private void addDevice(ActionEvent actionEvent) throws IOException {
        Stage stage = App.getInstance().getStage();

        VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("addDispositivo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private void deleteDevice(ActionEvent actionEvent) {

    }

    @FXML
    private void editDevice(ActionEvent actionEvent) {

    }
    @FXML
    private ObservableList<DispositivoModel> dispositivosModels;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        dispositivosModels = FXCollections.observableArrayList();
        App.getInstance().loadDispositivos();

        for (Dispositivo dispositivo : App.dispositivos) {
            dispositivosModels.add(new DispositivoModel(dispositivo.getId(), dispositivo.getMarca(), dispositivo.getModelo(), dispositivo.getEstado()));
        }

        table.setItems(dispositivosModels);

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                OrdenadoresModel model = (OrdenadoresModel) newSelection;
                selectedID = model.getId();
                System.out.println("Selected ID: " + selectedID);
            }
        });
    }
}
