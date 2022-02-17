package hu.petrik.muzeumfrontendjavafx.controllers;

import hu.petrik.muzeumfrontendjavafx.Szobor;
import hu.petrik.muzeumfrontendjavafx.apis.SzoborApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class SzoborHozzaadController extends Controller{
    @FXML
    private TextField emberTextField;
    @FXML
    private Spinner<Integer> magassagSpinner;
    @FXML
    private Spinner<Integer> ertekSpinner;

    @FXML
    public void megseClick(ActionEvent actionEvent) {
        this.stage.close();
    }

    @FXML
    public void hozzadasClick(ActionEvent actionEvent) {
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

        try {
            Szobor ujSzobor = new Szobor(0, ember, magassag, ertek);
            Szobor letrehozott = SzoborApi.addSzobor(ujSzobor);
            if (letrehozott != null){
                alert("Szobor hozzáadása sikeres!");
            } else {
                alert("Szobor hozzáadása sikeretelen!");
            }
        } catch (Exception e) {
            hibaKiir(e);
        }
    }
}
