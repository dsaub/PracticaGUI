package me.elordenador.practicagui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import me.elordenador.practica6.Disco;
import me.elordenador.practica6.Ordenador;
import me.elordenador.practicagui.App;
import me.elordenador.practicagui.ErrorMSG;

import java.io.IOException;

public class AddOrdenadorController {
    @FXML
    private TextField marca, modelo, ram, procesador, tamDisco;
    @FXML
    private ComboBox<String> disco;
    @FXML
    private CheckBox estado;
    public void save(ActionEvent actionEvent) throws IOException {
        try {
            Ordenador ordenador = new Ordenador(marca.getText(), modelo.getText(), estado.isSelected(), Integer.parseInt(ram.getText()), procesador.getText(), Integer.parseInt(tamDisco.getText()), Disco.valueOf(disco.getValue()));
            ordenador.save();
            Stage stage = App.getInstance().getStage();
            Scene scene = new Scene((VBox) FXMLLoader.load(getClass().getClassLoader().getResource("ordenadores.fxml")));
            stage.setScene(scene);
        } catch (NumberFormatException e) {
            new ErrorMSG("Ha escrito texto normal en campos que requieren numeros (Ram o Tamaño de Disco)").show();
        }

    }
}
