package hu.petrik.muzeumfrontendjavafx.controllers;

import hu.petrik.muzeumfrontendjavafx.Festmeny;
import hu.petrik.muzeumfrontendjavafx.Szobor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class SzoborModositController extends Controller {
    @FXML
    private Spinner magassagSpinner;
    @FXML
    private TextField emberTextField;
    @FXML
    private Spinner ertekSpinner;

    private Szobor modositando;

    @FXML
    public void megseClick(ActionEvent actionEvent) {
        this.stage.close();
    }

    @FXML
    public void modositasClick(ActionEvent actionEvent) {
    }

    public Szobor getModositando() {
        return modositando;
    }

    public void setModositando(Szobor modositando) {
        this.modositando = modositando;
        ertekekBeallitasa();
    }

    private void ertekekBeallitasa() {
        emberTextField.setText(modositando.getPerson());
        magassagSpinner.getValueFactory().setValue(modositando.getHeight());
        ertekSpinner.getValueFactory().setValue(modositando.getPrice());
    }
}
