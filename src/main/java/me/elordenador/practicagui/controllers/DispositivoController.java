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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import me.elordenador.practica6.Dispositivo;
import me.elordenador.practica6.ElementNotFoundException;
import me.elordenador.practicagui.App;
import me.elordenador.practicagui.models.DispositivoModel;
import me.elordenador.practicagui.models.OrdenadoresModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadPoolExecutor;

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

    private ArrayList<Dispositivo> dispositivoArrayList = new ArrayList<>();


    @FXML
    private void addDevice(ActionEvent actionEvent) throws IOException {
        Stage stage = App.getInstance().getStage();

        VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("addDispositivo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private void deleteDevice(ActionEvent actionEvent) throws IOException, ElementNotFoundException {
        Dispositivo dispositivo = new Dispositivo(selectedID);
        dispositivo.load();
        dispositivo.delete();
        Stage stage = App.getInstance().getStage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("dispositivos.fxml"))));

    }

    @FXML
    private void editDevice(ActionEvent actionEvent) throws IOException {
        Stage stage = App.getInstance().getStage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("editDispositivo.fxml"))));
    }
    @FXML
    private ObservableList<DispositivoModel> dispositivosModels;

    @FXML
    private TextField searchBar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        App.getInstance().loadDispositivos();

        search();

        reloadData();



        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                DispositivoModel model = (DispositivoModel) newSelection;
                selectedID = model.getId();
                System.out.println("Selected ID: " + selectedID);
            }
        });
    }

    private void reloadData() {
        dispositivosModels = FXCollections.observableArrayList();

        for (Dispositivo dispositivo : dispositivoArrayList) {
            dispositivosModels.add(new DispositivoModel(dispositivo.getId(), dispositivo.getMarca(), dispositivo.getModelo(), dispositivo.getEstado()));
        }

        table.setItems(dispositivosModels);
    }

    @FXML
    private void search() {
        // Esta funcion se ejecutará cada vez que se modifique el texto en la barra de busqueda

            dispositivoArrayList = new ArrayList<>();
            String searchQuery = searchBar.getText();
            for (Dispositivo dispositivo: App.dispositivos) {
                if (String.valueOf(dispositivo.getId()).contains(searchQuery) ||
                        dispositivo.getMarca().contains(searchQuery) ||
                        dispositivo.getModelo().contains(searchQuery)) {
                    dispositivoArrayList.add(dispositivo);
                }
            }

            reloadData();



    }
}
