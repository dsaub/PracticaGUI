package me.elordenador.practicagui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import me.elordenador.practica6.Dispositivo;
import me.elordenador.practicagui.App;
import me.elordenador.practicagui.models.DispositivoModel;
import me.elordenador.practicagui.models.ImpresoraModel;
import me.elordenador.practica6.Impresora;

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

    public void search() {
        String searchQuery = searchBar.getText();
        App.getInstance().loadImpresoras();
        impresoraArrayList = new ArrayList<>();
        for (Impresora impresora : App.impresoras) {
            if (String.valueOf(impresora.getId()).contains(searchQuery) ||
            impresora.getMarca().contains(searchQuery) ||
            impresora.getModelo().contains(searchQuery)
            impresora.getTipo().name().contains(searchQuery)) {
                impresoraArrayList.add(impresora);
            }
        }

    }

    public void addDevice(ActionEvent actionEvent) {
    }

    public void editDevice(ActionEvent actionEvent) {
    }

    public void deleteDevice(ActionEvent actionEvent) {
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
    }

    private void reload() {
        impresoraModelObservableArray = FXCollections.observableArrayList();

        for (Impresora impresora : impresoraArrayList) {
            impresoraModelObservableArray.add(new ImpresoraModel(impresora.getId(), impresora.getMarca(), impresora.getModelo(), impresora.getEstado(), impresora.getTipo().name(), impresora.getColor(), impresora.getEscaner()));
        }

        table.setItems(impresoraModelObservableArray);
    }
}
