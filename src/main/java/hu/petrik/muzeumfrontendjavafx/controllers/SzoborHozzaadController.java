package hu.petrik.muzeumfrontendjavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class SzoborHozzaadController extends Controller{
    @FXML
    private Spinner magassagSpinner;
    @FXML
    private TextField emberTextField;
    @FXML
    private Spinner ertekSpinner;

    @FXML
    public void megseClick(ActionEvent actionEvent) {
        this.stage.close();
    }

    @FXML
    public void hozzadasClick(ActionEvent actionEvent) {
    }
}
