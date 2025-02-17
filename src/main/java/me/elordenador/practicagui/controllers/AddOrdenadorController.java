package me.elordenador.practicagui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import me.elordenador.practica6.Disco;
import me.elordenador.practica6.Ordenador;
import me.elordenador.practicagui.App;

import java.io.IOException;

public class AddOrdenadorController {
    @FXML
    private TextArea marca, modelo, ram, procesador, tamDisco, disco;
    @FXML
    private CheckBox estado;
    public void save(ActionEvent actionEvent) throws IOException {
        Ordenador ordenador = new Ordenador(marca.getText(), modelo.getText(), estado.isSelected(), Integer.parseInt(ram.getText()), procesador.getText(), Integer.parseInt(tamDisco.getText()), Disco.valueOf(disco.getText()));
        ordenador.save();
        Stage stage = App.getInstance().getStage();
        Scene scene = new Scene((VBox) FXMLLoader.load(getClass().getClassLoader().getResource("ordenadores.fxml")));
        stage.setScene(scene);
    }
}
