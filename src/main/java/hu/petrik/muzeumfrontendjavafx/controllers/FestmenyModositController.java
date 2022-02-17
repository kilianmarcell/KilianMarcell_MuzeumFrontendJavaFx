package hu.petrik.muzeumfrontendjavafx.controllers;

import hu.petrik.muzeumfrontendjavafx.Festmeny;
import hu.petrik.muzeumfrontendjavafx.Szobor;
import hu.petrik.muzeumfrontendjavafx.apis.FestmenyApi;
import hu.petrik.muzeumfrontendjavafx.apis.SzoborApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FestmenyModositController extends Controller {
    @FXML
    private TextField cimTextField;
    @FXML
    private Spinner<Integer> megjelenesEveSpinner;
    @FXML
    private CheckBox kiallitvaCheckBox;

    private Festmeny modositando;

    @FXML
    public void megseClick(ActionEvent actionEvent) {
        this.stage.close();
    }

    @FXML
    public void modositasClick(ActionEvent actionEvent) {
        String cim = cimTextField.getText().trim();
        int megjelenesEve = megjelenesEveSpinner.getValue();
        boolean kiallitva = kiallitvaCheckBox.isSelected();

        if (cim.isEmpty()){
            alert("Cím megadása kötelező!");
            return;
        }

        modositando.setTitle(cim);
        modositando.setYear(megjelenesEve);
        modositando.setOn_display(kiallitva);

        try {
            Festmeny modositott = FestmenyApi.editFestmeny(modositando);
            if (modositott != null){
                alertWait("Sikeres módosítás!");
            } else {
                alert("Sikertelen módosítás!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Festmeny getModositando() {
        return modositando;
    }

    public void setModositando(Festmeny modositando) {
        this.modositando = modositando;
        ertekekBeallitasa();
    }

    private void ertekekBeallitasa() {
        cimTextField.setText(modositando.getTitle());
        megjelenesEveSpinner.getValueFactory().setValue(modositando.getYear());
        kiallitvaCheckBox.setSelected(modositando.isOn_display());
    }
}
