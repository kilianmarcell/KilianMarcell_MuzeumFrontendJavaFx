package hu.petrik.muzeumfrontendjavafx.controllers;

import hu.petrik.muzeumfrontendjavafx.Festmeny;
import hu.petrik.muzeumfrontendjavafx.apis.FestmenyApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class FestmenyHozzaadController extends Controller{
    @FXML
    private TextField cimTextField;
    @FXML
    private Spinner<Integer> megjelenesEveSpinner;
    @FXML
    private CheckBox kiallitvaCheckBox;

    @FXML
    public void megseClick(ActionEvent actionEvent) {
        this.stage.close();
    }

    @FXML
    public void hozzaadasClick(ActionEvent actionEvent) {
        String cim = cimTextField.getText().trim();
        int megjelenesEve = megjelenesEveSpinner.getValue();
        boolean kiallitva = kiallitvaCheckBox.isSelected();

        if (cim.isEmpty()){
            alert("Cím megadása kötelező!");
            return;
        }

        try {
            Festmeny ujFestmeny = new Festmeny(0, cim, megjelenesEve, kiallitva);
            Festmeny letrehozott = FestmenyApi.addFestmeny(ujFestmeny);
            if (letrehozott != null){
                alert("Festmény hozzáadása sikeres!");
            } else {
                alert("Festmény hozzáadása sikeretelen!");
            }
        } catch (Exception e) {
            hibaKiir(e);
        }
    }
}
