package hu.petrik.muzeumfrontendjavafx.controllers;

import hu.petrik.muzeumfrontendjavafx.Festmeny;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class FestmenyModositController extends Controller {
    @FXML
    private CheckBox kiallitvaCheckBox;
    @FXML
    private TextField cimTextField;
    @FXML
    private Spinner megjelenesEveSpinner;

    private Festmeny modositando;

    @FXML
    public void megseClick(ActionEvent actionEvent) {
    }

    @FXML
    public void modositasClick(ActionEvent actionEvent) {
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
