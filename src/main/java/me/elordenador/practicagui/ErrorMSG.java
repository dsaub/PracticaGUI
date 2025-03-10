package me.elordenador.practicagui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ErrorMSG {
    Alert alert;

    public ErrorMSG(String description) {
        this.alert = new Alert(Alert.AlertType.ERROR, description, ButtonType.OK);

    }

    public void show() {
        alert.showAndWait();
    }
}
