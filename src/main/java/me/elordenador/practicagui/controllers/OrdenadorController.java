package me.elordenador.practicagui.controllers;

import javafx.application.Platform;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
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
    private Label texto;
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

    @FXML
    private TextField searchBar;
    public static int selectedID = -1;
    public OrdenadorController() {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        ram.setCellValueFactory(new PropertyValueFactory<>("ram"));
        procesador.setCellValueFactory(new PropertyValueFactory<>("procesador"));
        tamDisco.setCellValueFactory(new PropertyValueFactory<>("tamDisco"));
        disco.setCellValueFactory(new PropertyValueFactory<>("disco"));
        ordenadoresModels = FXCollections.observableArrayList();
        System.out.println("Opened controller");
        App.getInstance().loadOrdenadores();
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
        tableView.setItems(ordenadoresModels);

        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                OrdenadoresModel model = (OrdenadoresModel) newSelection;
                selectedID = model.getId();
                System.out.println("Selected ID: " + selectedID);
            }
        });
    }
    
    public void addDevice(ActionEvent actionEvent) throws IOException {
        Stage stage = App.getInstance().getStage();

        VBox vbox = FXMLLoader.load(getClass().getClassLoader().getResource("addOrdenador.fxml"));
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
    }

    public void editDevice(ActionEvent actionEvent) throws IOException {
        if (selectedID != -1) {
            Stage stage = App.getInstance().getStage();
            VBox vbox = FXMLLoader.load(getClass().getClassLoader().getResource("editOrdenador.fxml"));
            Scene scene = new Scene(vbox);
            stage.setScene(scene);
        }
    }

    public void deleteDevice(ActionEvent actionEvent) throws IOException {
        // TODO: Agregar metodologia de deleteDevice
        Ordenador ordenador = new Ordenador(selectedID);
        ordenador.delete();
        VBox vbox = FXMLLoader.load(getClass().getClassLoader().getResource("ordenadores.fxml"));
        Scene scene = new Scene(vbox);
        Stage stage = App.getInstance().getStage();
        stage.setScene(scene);
    }


    @FXML
    private void easteregg(ActionEvent actionEvent) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                texto.getTransforms().add(new Rotate(i,i,i));
                Platform.runLater(() -> texto.setText("dude/"));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


    }

    @FXML
    private void search(ActionEvent actionEvent) {
    }
}
