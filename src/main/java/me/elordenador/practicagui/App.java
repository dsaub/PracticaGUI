package me.elordenador.practicagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import me.elordenador.practica6.Dispositivo;
import me.elordenador.practica6.ElementNotFoundException;
import me.elordenador.practica6.Impresora;
import me.elordenador.practica6.Ordenador;

import java.io.IOException;
import java.util.ArrayList;

public class App extends Application {
    private Scene scene;
    private Stage stage;
    public static ArrayList<Dispositivo> dispositivos;
    public static ArrayList<Ordenador> ordenadores;
    public static ArrayList<Impresora> impresoras;
    private static App instance;
    public void start(Stage stage) throws IOException {
        instance = this;
        Ordenador.init();
        Impresora.init();
        Dispositivo.init();


        loadImpresoras();

        loadDispositivos();

        loadOrdenadores();





        this.stage = stage;
        VBox root = (VBox) FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));

        scene = new Scene(root);
        stage.setTitle("Ventana principal");
        stage.setScene(scene);

        stage.show();
    }

    public void loadOrdenadores() {

        ordenadores = new ArrayList<>();

        for (int i = 0; i < Ordenador.length(); i++) {
            Ordenador ordenador = new Ordenador(i);
            try {
                ordenador.load();
                ordenadores.add(ordenador);
            } catch (ElementNotFoundException e) {
                System.out.println("[WARN] Device not found");
            }
        }
    }

    public Scene getScene() {
        return scene;
    }

    public Stage getStage() {
        return stage;
    }

    public static App getInstance() {
        return instance;
    }

    public void loadDispositivos() {
        dispositivos = new ArrayList<>();
        for (int i = 0; i < Dispositivo.length(); i++) {
            Dispositivo dispositivo = new Dispositivo(i);
            try {
                dispositivo.load();
                dispositivos.add(dispositivo);
            } catch (ElementNotFoundException e) {
                System.out.println("[WARN] Device not found");
            }

        }
    }

    public void loadImpresoras() {
        impresoras = new ArrayList<>();
        for (int i = 0; i < Impresora.length(); i++) {
            Impresora impresora = new Impresora(i);
            try {
                impresora.load();
                impresoras.add(impresora);
            } catch (ElementNotFoundException e) {
                System.err.println("[WARN] Device not found");
            }
        }
    }
}
