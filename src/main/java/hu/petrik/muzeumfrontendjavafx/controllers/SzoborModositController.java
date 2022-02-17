package hu.petrik.muzeumfrontendjavafx.controllers;

import hu.petrik.muzeumfrontendjavafx.Festmeny;
import hu.petrik.muzeumfrontendjavafx.Szobor;
import hu.petrik.muzeumfrontendjavafx.apis.SzoborApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SzoborModositController extends Controller {
    @FXML
    private TextField emberTextField;
    @FXML
    private Spinner<Integer> magassagSpinner;
    @FXML
    private Spinner<Integer> ertekSpinner;

    private Szobor modositando;

    @FXML
    public void megseClick(ActionEvent actionEvent) {
        this.stage.close();
    }

    @FXML
    public void modositasClick(ActionEvent actionEvent) {
        String ember = emberTextField.getText().trim();
        int magassag = magassagSpinner.getValue();
        int ertek = ertekSpinner.getValue();

        if (ember.isEmpty()){
            alert("Ember megadása kötelező!");
            return;
        }

        if (ember.length() < 5) {
            alert("Az ember mezőnek legalább 5 karakter hosszúnak kell lennie!");
            return;
        }

        modositando.setPerson(ember);
        modositando.setHeight(magassag);
        modositando.setPrice(ertek);

        try {
            Szobor modositott = SzoborApi.editSzobor(modositando);
            if (modositott != null){
                alertWait("Sikeres módosítás!");
            } else {
                alert("Sikertelen módosítás!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
