package me.elordenador.practicagui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import me.elordenador.practica6.Dispositivo;
import me.elordenador.practicagui.App;

import java.io.IOException;

public class AddDispositivoController {
    @FXML
    private TextField marca, modelo;

    @FXML
    private CheckBox estado;
    public void save(ActionEvent actionEvent) throws IOException {

        Dispositivo dispositivo = new Dispositivo(marca.getText(), modelo.getText(), estado.isSelected());
        dispositivo.save();

        Stage stage = App.getInstance().getStage();
        VBox root = FXMLLoader.load(getClass().getClassLoader().getResource("dispositivos.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
