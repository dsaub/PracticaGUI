package me.elordenador.practicagui.models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DispositivoModel {
    private SimpleIntegerProperty id;
    private SimpleStringProperty marca, modelo;
    private SimpleBooleanProperty estado;

    public DispositivoModel(Integer id, String marca, String modelo, Boolean estado) {
        this.id = new SimpleIntegerProperty(id);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.estado = new SimpleBooleanProperty(estado);
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

}
