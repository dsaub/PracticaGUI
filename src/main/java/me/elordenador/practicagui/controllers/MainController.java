package me.elordenador.practicagui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import me.elordenador.practicagui.App;

import java.io.IOException;

public class MainController {

    @FXML
    public void openDispositivos() throws IOException {
        App app = App.getInstance();
        Stage stage = app.getStage();

        VBox vbox = FXMLLoader.load(getClass().getClassLoader().getResource("dispositivos.fxml"));
        Scene scene = new Scene(vbox);
        stage.setTitle("Listado de dispositivos");
        stage.setScene(scene);
    }

    @FXML
    public void openOrdenadores() throws IOException {
        App app = App.getInstance();
        Stage stage = app.getStage();

        VBox vbox = FXMLLoader.load(getClass().getClassLoader().getResource("ordenadores.fxml"));
        Scene scene = new Scene(vbox);
        stage.setTitle("Listado de ordenadores");
        stage.setScene(scene);
    }

    @FXML
    public void openImpresoras() {
        System.out.println("[DEBUG] Impresoras clicked.");
    }
}
