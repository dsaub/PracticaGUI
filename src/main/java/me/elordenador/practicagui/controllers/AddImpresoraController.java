package me.elordenador.practicagui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import me.elordenador.practica6.Impresora;
import me.elordenador.practica6.TipoImpresora;
import me.elordenador.practicagui.App;

import java.io.IOException;

public class AddImpresoraController {
    @FXML
    private TextField marca, modelo;
    @FXML
    private CheckBox estado, color, scanner;

    @FXML
    private ComboBox<String> tipo;
    public void save(ActionEvent actionEvent) throws IOException {

        Impresora impresora = new Impresora(marca.getText(), modelo.getText(), estado.isSelected(), TipoImpresora.valueOf(tipo.getValue()), color.isSelected(), scanner.isSelected());
        impresora.save();
        App.getInstance().getStage().setScene(new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("impresoras.fxml"))));
    }
}
