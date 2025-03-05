package me.elordenador.practicagui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import me.elordenador.practica6.Dispositivo;
import me.elordenador.practica6.ElementNotFoundException;
import me.elordenador.practica6.Impresora;
import me.elordenador.practicagui.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditImpresoraController implements Initializable {

    @FXML
    private TextField marca, modelo;

    @FXML
    private CheckBox estado, color, scanner;
    @FXML
    private ComboBox<String> tipo;

    private int selectedID;
    private Impresora dispositivo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedID = DispositivoController.selectedID;

        dispositivo = new Impresora(selectedID);
        try {
            dispositivo.load();
        } catch (ElementNotFoundException e) {
            throw new RuntimeException(e);
        }
        marca.setText(dispositivo.getMarca());
        modelo.setText(dispositivo.getModelo());
        estado.setSelected(dispositivo.getEstado());
        color.setSelected(dispositivo.getColor());
        scanner.setSelected(dispositivo.getEscaner());
        tipo.setValue(dispositivo.getTipo().name());


    }

    @FXML
    private void save(ActionEvent actionEvent) throws IOException {

        dispositivo.setMarca(marca.getText());
        dispositivo.setModelo(modelo.getText());
        dispositivo.setEstado(estado.isSelected());
        dispositivo.save();
        Stage stage = App.getInstance().getStage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("dispositivos.fxml"))));
    }
}
