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
import me.elordenador.practica6.ElementNotFoundException;
import me.elordenador.practica6.Ordenador;
import me.elordenador.practicagui.App;

import java.io.IOException;

public class EditarOrdenadorController {


    @FXML
    private TextField marca, modelo, ram, procesador, tamDisco;
    @FXML
    private ComboBox<String> disco;
    @FXML
    private CheckBox estado;

    public void initialize() throws ElementNotFoundException {
        Ordenador ordenador = new Ordenador(OrdenadorController.selectedID);
        ordenador.load();
        marca.setText(ordenador.getMarca());
        modelo.setText(ordenador.getModelo());
        ram.setText(String.valueOf(ordenador.getRam()));
        procesador.setText(ordenador.getProcesador());
        tamDisco.setText(String.valueOf(ordenador.getTamDisco()));
        disco.setValue(ordenador.getTipoDisco().name());
        estado.setSelected(ordenador.getEstado());

    }
    @FXML
    public void save(ActionEvent actionEvent) throws IOException, ElementNotFoundException {
        Ordenador ordenador = new Ordenador(OrdenadorController.selectedID);
        ordenador.load();
        ordenador.setMarca(marca.getText());
        ordenador.setModelo(modelo.getText());
        ordenador.setRam(Integer.parseInt(ram.getText()));
        ordenador.setProcesador(procesador.getText());
        ordenador.setTamDisco(Integer.parseInt(tamDisco.getText()));
        ordenador.setEstado(estado.isSelected());
        ordenador.setTipoDisco(Disco.valueOf(disco.getValue()));
        ordenador.save();
        Stage stage = App.getInstance().getStage();
        Scene scene = new Scene((VBox) FXMLLoader.load(getClass().getClassLoader().getResource("ordenadores.fxml")));
        stage.setScene(scene);
    }
}
