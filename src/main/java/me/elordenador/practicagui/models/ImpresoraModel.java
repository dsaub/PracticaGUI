package me.elordenador.practicagui.models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableArray;

public class ImpresoraModel {
    private SimpleIntegerProperty id;
    private SimpleStringProperty marca, modelo, tipo;
    private SimpleBooleanProperty estado, color, scanner;

    public ImpresoraModel(Integer id, String marca, String modelo, Boolean estado, String tipo, Boolean color, Boolean scanner) {
        this.id = new SimpleIntegerProperty(id);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.estado = new SimpleBooleanProperty(estado);
        this.tipo = new SimpleStringProperty(tipo);
        this.color = new SimpleBooleanProperty(color);
        this.scanner = new SimpleBooleanProperty(scanner);
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

    public String getTipo() {
        return tipo.get();
    }

    public boolean getColor() {
        return color.get();
    }

    public boolean getScanner() {
        return scanner.get();
    }
}
