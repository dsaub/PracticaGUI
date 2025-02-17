package me.elordenador.practicagui.models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import me.elordenador.practica6.Disco;

public class OrdenadoresModel {
    public SimpleIntegerProperty id, ram, tamDisco;
    public SimpleStringProperty marca, modelo, procesador, disco;
    public SimpleBooleanProperty estado;

    public OrdenadoresModel(Integer id, String marca, String modelo, Boolean estado, Integer ram, String procesador, Integer tamDisco, Disco disco) {
        this.id = new SimpleIntegerProperty(id);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.estado = new SimpleBooleanProperty(estado);
        this.ram = new SimpleIntegerProperty(ram);
        this.procesador = new SimpleStringProperty(procesador);
        this.tamDisco = new SimpleIntegerProperty(tamDisco);
        this.disco = new SimpleStringProperty(disco.name());
    }

    public int getId() {
        return id.get();
    }

    public String getMarca() {
        return marca.get();
    }

    public String getModelo() {
        return modelo.get();
    }

    public boolean getEstado() {
        return estado.get();
    }

    public int getRam() {
        return ram.get();
    }

    public String getProcesador() {
        return procesador.get();
    }

    public int getTamDisco() {
        return tamDisco.get();
    }

    public String getDisco() {
        return disco.get();
    }
}
