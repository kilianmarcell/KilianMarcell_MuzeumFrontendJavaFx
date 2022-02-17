package hu.petrik.muzeumfrontendjavafx.controllers;

import hu.petrik.muzeumfrontendjavafx.Festmeny;
import hu.petrik.muzeumfrontendjavafx.apis.FestmenyApi;
import hu.petrik.muzeumfrontendjavafx.Szobor;
import hu.petrik.muzeumfrontendjavafx.apis.SzoborApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    @FXML
    public Button modositButton;
    @FXML
    public Button torlesButton;
    @FXML
    private TabPane muzeumTabPane;

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

        modositButton.setDisable(true);
        torlesButton.setDisable(true);
    }

    @FXML
    public void onHozaadasClick(ActionEvent actionEvent) {
        modositButton.setDisable(true);
        torlesButton.setDisable(true);

        int tab = muzeumTabPane.getSelectionModel().getSelectedIndex();
        if (tab == 0) {
            try {
                Controller hozzadas = ujAblak("szobor-hozzaad-view.fxml", "Szobor hozzáadása",
                        320, 400);
                hozzadas.getStage().setOnCloseRequest(event -> muzeumListaFeltolt());
                hozzadas.getStage().show();
            } catch (Exception e) {
                hibaKiir(e);
            }
        } else if (tab == 1){
            try {
                Controller hozzadas = ujAblak("festmeny-hozzaad-view.fxml", "Festmény hozzáadása",
                        320, 400);
                hozzadas.getStage().setOnCloseRequest(event -> muzeumListaFeltolt());
                hozzadas.getStage().show();
            } catch (Exception e) {
                hibaKiir(e);
            }
        }
    }

    @FXML
    public void onModositasClick(ActionEvent actionEvent) {
        modositButton.setDisable(true);
        torlesButton.setDisable(true);

        int tab = muzeumTabPane.getSelectionModel().getSelectedIndex();
        if (tab == 0) {
            try {
                Szobor modositando = szoborTableView.getSelectionModel().getSelectedItem();

                SzoborModositController modosit = (SzoborModositController) ujAblak("szobor-modosit-view.fxml", "Szobor módosítása",
                        320, 400);
                modosit.setModositando(modositando);
                modosit.getStage().setOnCloseRequest(event -> muzeumListaFeltolt());
                modosit.getStage().show();
            } catch (Exception e) {
                hibaKiir(e);
            }
        } else if (tab == 1){
            try {
                Festmeny modositando = festmenyTableView.getSelectionModel().getSelectedItem();

                FestmenyModositController modosit = (FestmenyModositController) ujAblak("festmeny-modosit-view.fxml", "Festmény módosítása",
                        320, 400);
                modosit.setModositando(modositando);
                modosit.getStage().setOnCloseRequest(event -> muzeumListaFeltolt());
                modosit.getStage().show();
            } catch (Exception e) {
                hibaKiir(e);
            }
        }
    }

    @FXML
    public void onTorlesClick(ActionEvent actionEvent) {
        int tab = muzeumTabPane.getSelectionModel().getSelectedIndex();
        if (tab == 0) {
            Szobor torlendoSzobor = szoborTableView.getSelectionModel().getSelectedItem();
            if (!confirm("Biztosan törli az alábbi szobrot: " + torlendoSzobor.getPerson())) {
                return;
            }
            try {
                boolean sikeres = SzoborApi.deleteSzobor(torlendoSzobor.getId());
                alert(sikeres ? "Sikeres törlés!" : "Sikertelen törlés!");
                muzeumListaFeltolt();
            } catch (IOException e) {
                hibaKiir(e);
            }
        } else if (tab == 1) {
            Festmeny torlendoFestmeny = festmenyTableView.getSelectionModel().getSelectedItem();
            if (!confirm("Biztosan törli az alábbi festményt: " + torlendoFestmeny.getTitle())) {
                return;
            }
            try {
                boolean sikeres = FestmenyApi.deleteFestmeny(torlendoFestmeny.getId());
                alert(sikeres ? "Sikeres törlés!" : "Sikertelen törlés!");
                muzeumListaFeltolt();
            } catch (IOException e) {
                hibaKiir(e);
            }
        }
    }

    @FXML
    public void onSzoborClick(MouseEvent mouseEvent) {
        modositButton.setDisable(false);
        torlesButton.setDisable(false);
    }

    @FXML
    public void onFestmenyClick(MouseEvent mouseEvent) {
        modositButton.setDisable(false);
        torlesButton.setDisable(false);
    }
}