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
import me.elordenador.practica6.Dispositivo;
import me.elordenador.practica6.ElementNotFoundException;
import me.elordenador.practicagui.App;
import me.elordenador.practicagui.models.DispositivoModel;
import me.elordenador.practicagui.models.ImpresoraModel;
import me.elordenador.practica6.Impresora;
import me.elordenador.practicagui.models.OrdenadoresModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class ImpresoraController implements Initializable {

    @FXML
    private TableColumn<ImpresoraModel, String> marca, modelo, tipo;

    @FXML
    private TableColumn<ImpresoraModel, Boolean> estado, color, scanner;

    @FXML
    private TableColumn<ImpresoraModel, Integer> id;

    @FXML
    private TextField searchBar;

    @FXML
    private TableView<ImpresoraModel> table;

    private ArrayList<Impresora> impresoraArrayList;

    private ObservableList<ImpresoraModel> impresoraModelObservableArray;

    public static int selectedID = -1;

    public void search() {
        String searchQuery = searchBar.getText();
        App.getInstance().loadImpresoras();
        impresoraArrayList = new ArrayList<>();
        for (Impresora impresora : App.impresoras) {
            if (String.valueOf(impresora.getId()).contains(searchQuery) ||
            impresora.getMarca().contains(searchQuery) ||
            impresora.getModelo().contains(searchQuery)||
            impresora.getTipo().name().contains(searchQuery)) {
                impresoraArrayList.add(impresora);
            }
        }

        reload();

    }

    public void addDevice(ActionEvent actionEvent) {
        try {
            App.getInstance().getStage().setScene(new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("addImpresora.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void editDevice(ActionEvent actionEvent) throws IOException {
        App.getInstance().getStage().setScene(new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("editImpresora.fxml"))));
    }

    public void deleteDevice(ActionEvent actionEvent) throws IOException, ElementNotFoundException {
        System.out.println("Delete Device");
        Impresora impresora = new Impresora(selectedID);
        impresora.load();
        impresora.delete();
        search();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));
        scanner.setCellValueFactory(new PropertyValueFactory<>("scanner"));;
        search();
        reload();

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                ImpresoraModel model = (ImpresoraModel) newSelection;
                selectedID = model.getId();
                System.out.println("Selected ID: " + selectedID);
            }
        });
    }

    private void reload() {
        impresoraModelObservableArray = FXCollections.observableArrayList();

        for (Impresora impresora : impresoraArrayList) {
            impresoraModelObservableArray.add(new ImpresoraModel(impresora.getId(), impresora.getMarca(), impresora.getModelo(), impresora.getEstado(), impresora.getTipo().name(), impresora.getColor(), impresora.getEscaner()));
        }

        table.setItems(impresoraModelObservableArray);
    }
}
