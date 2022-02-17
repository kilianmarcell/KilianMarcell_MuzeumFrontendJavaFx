package hu.petrik.muzeumfrontendjavafx.controllers;

import hu.petrik.muzeumfrontendjavafx.Festmeny;
import hu.petrik.muzeumfrontendjavafx.apis.FestmenyApi;
import hu.petrik.muzeumfrontendjavafx.Szobor;
import hu.petrik.muzeumfrontendjavafx.apis.SzoborApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class MainController extends Controller {
    @FXML
    public Tab szobrokTab;
    @FXML
    public TableView<Szobor> szoborTableView;
    @FXML
    public TableColumn<Szobor, String> szoborEmberCol;
    @FXML
    public TableColumn<Szobor, Integer> szoborMagassagCol;
    @FXML
    public TableColumn<Szobor, Integer> szoborErtekCol;
    @FXML
    public Tab festmenyekTab;
    @FXML
    public TableView<Festmeny> festmenyTableView;
    @FXML
    public TableColumn<Festmeny, String> festmenyCimCol;
    @FXML
    public TableColumn<Festmeny, Integer> festmenyEvCol;
    @FXML
    public TableColumn<Festmeny, Integer> festmenyKiallitvaCol;

    public void initialize() {
        szoborEmberCol.setCellValueFactory(new PropertyValueFactory<>("person"));
        szoborMagassagCol.setCellValueFactory(new PropertyValueFactory<>("height"));
        szoborErtekCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        festmenyCimCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        festmenyEvCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        festmenyKiallitvaCol.setCellValueFactory(new PropertyValueFactory<>("on_display"));

        muzeumListaFeltolt();
    }

    private void muzeumListaFeltolt() {
        try {
            List<Szobor> szoborList = SzoborApi.getSzobor();
            List<Festmeny> festmenyList = FestmenyApi.getFestmeny();

            szoborTableView.getItems().clear();
            festmenyTableView.getItems().clear();

            for (Szobor s : szoborList) {
                szoborTableView.getItems().add(s);
            }
            for (Festmeny f : festmenyList) {
                festmenyTableView.getItems().add(f);
            }
        } catch (IOException e) {
            hibaKiir(e);
        }
    }

    @FXML
    public void onHozaadasClick(ActionEvent actionEvent) {
    }

    @FXML
    public void onModositasClick(ActionEvent actionEvent) {
    }

    @FXML
    public void onTorlesClick(ActionEvent actionEvent) {
    }
}